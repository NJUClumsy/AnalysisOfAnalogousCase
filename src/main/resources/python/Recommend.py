# -*- coding: UTF-8 -*-
import jieba
import numpy as np
import pymongo
import sys
from bson import ObjectId


def connect_mongodb():
    servers = "mongodb://172.26.31.191:27017"
    conn = pymongo.MongoClient(servers)
    db = conn.test
    return db


def read_from_file(file_name):
    with open(file_name, "r", encoding='utf8') as fp:
        words = fp.read()
    return words


def stop_words(stop_word_file):
    words = read_from_file(stop_word_file)
    result = jieba.cut(words)
    new_words = []
    for r in result:
        new_words.append(r)
    return set(new_words)


def del_stop_words(words, stop_words_set):
    # words是已经切词但是没有去除停用词的文档。
    # 返回的会是去除停用词后的文档
    result = jieba.cut(words)
    new_words = []
    for r in result:
        if r not in stop_words_set:
            new_words.append(r)
    return new_words


def get_all_vector(stop_words_set):
    db = connect_mongodb()
    collection = db.case
    cause = collection.find_one({"_id": ObjectId("596b2dbc39e14e6ddb1bb09b")}, {"案由": 1})["案由"]
    all_document = collection.find({"案由": cause}, {"全文": 1}).limit(150)
    names = []
    posts = []
    for document in all_document:
        temp = ''
        name = document['_id']
        for k in document["全文"]:
            if k != '文尾':
                temp += document["全文"][k]
        posts.append(temp)
        names.append(name)
    docs = []
    word_set = set()
    for post in posts:
        doc = del_stop_words(post, stop_words_set)
        docs.append(doc)
        word_set |= set(doc)

    word_set = list(word_set)
    docs_vsm = []
    for doc in docs:
        temp_vector = []
        for word in word_set:
            temp_vector.append(doc.count(word) * 1.0)
        docs_vsm.append(temp_vector)

    docs_matrix = np.array(docs_vsm)
    column_sum = [float(len(np.nonzero(docs_matrix[:, i])[0])) for i in range(docs_matrix.shape[1])]
    column_sum = np.array(column_sum)
    column_sum = docs_matrix.shape[0] / column_sum
    idf = np.log(column_sum)
    idf = np.diag(idf)
    # 请仔细想想，根绝IDF的定义，计算词的IDF并不依赖于某个文档，所以我们提前计算好。
    # 注意一下计算都是矩阵运算，不是单个变量的运算。
    for doc_v in docs_matrix:
        if doc_v.sum() == 0:
            doc_v = doc_v / 1
        else:
            doc_v = doc_v / (doc_v.sum())
        tfidf = np.dot(docs_matrix, idf)
        return names, tfidf


def gen_sim(A, B):
    num = float(np.dot(A, B.T))
    denum = np.linalg.norm(A) * np.linalg.norm(B)
    if denum == 0:
        denum = 1
    cosn = num / denum
    sim = 0.5 + 0.5 * cosn
    return sim


def randCent(dataSet, k):
    n = np.shape(dataSet)[1]
    centroids = np.mat(np.zeros((k, n)))  # create centroid mat
    for j in range(n):  # create random cluster centers, within bounds of each dimension
        minJ = min(dataSet[:, j])
        rangeJ = float(max(dataSet[:, j]) - minJ)
        centroids[:, j] = np.mat(minJ + rangeJ * np.random.rand(k, 1))
    return centroids


def kMeans(dataSet, k, distMeas=gen_sim, createCent=randCent):
    m = np.shape(dataSet)[0]
    clusterAssment = np.mat(np.zeros((m, 2)))  # create mat to assign data points
    # to a centroid, also holds SE of each point
    centroids = createCent(dataSet, k)
    clusterChanged = True
    counter = 0
    while counter <= 50:
        counter += 1
        clusterChanged = False
        for i in range(m):  # for each data point assign it to the closest centroid
            minDist = np.inf
            minIndex = -1
            for j in range(k):
                distJI = distMeas(centroids[j, :], dataSet[i, :])
                if distJI < minDist:
                    minDist = distJI
                    minIndex = j
            if clusterAssment[i, 0] != minIndex:
                clusterChanged = True
            clusterAssment[i, :] = minIndex, minDist ** 2
        # print centroids
        for cent in range(k):  # recalculate centroids
            ptsInClust = dataSet[np.nonzero(clusterAssment[:, 0].A == cent)[0]]  # get all the point in this cluster
            centroids[cent, :] = np.mean(ptsInClust, axis=0)  # assign centroid to mean
    return centroids, clusterAssment


def getRecommendedCases(Id):
    name, tfidf = get_all_vector(stop_words('/Users/slow_time/Desktop/AnalysisOfAnalogousCase/src/main/resources/python/table.txt'))

    num_clusters = int(len(name) / 5)

    C1, C2 = kMeans(tfidf, num_clusters)
    labels = [int(x[0]) for x in np.array(C2)]
    label = 0
    for i in range(len(name)):
        if str(name[i]) == Id:
            label = labels[i]
            break
    similarCases = []
    for i in range(len(labels)):
        if labels[i] == label:
            if str(name[i]) != Id:
                similarCases.append(str(name[i]))
    if len(similarCases) > 5:
        similarCases = similarCases[0:5]
    return similarCases


similar_cases = getRecommendedCases(sys.argv[1])
result = ','.join(similar_cases)
print(result)

