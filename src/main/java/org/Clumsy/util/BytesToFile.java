package org.Clumsy.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * 将multipartFile转化成Document
 * Created by Lucifer on 17/7/17.
 */
public class BytesToFile {

    private BytesToFile(){

    }


    /**
     * 将MultipartFile转化为Document
     *
     * @param multipartFile
     * @return
     */
    public static Document multipartFileToDocument(MultipartFile multipartFile) throws DocumentException, IOException {
        byte[] bytes;
        bytes = multipartFile.getBytes();

        return getDocument(bytes);
    }


    /**
     * 根据byte数组，生成document
     */
    private static Document getDocument(byte[] bfile) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document;
        document = reader.read(new ByteArrayInputStream(bfile));

        return document;
    }
}

