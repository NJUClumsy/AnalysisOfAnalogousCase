package org.Clumsy.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 字节流转数组
 * Created by green-cherry on 2017/7/17.
 */
public class BytesToFile {

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 将MultipartFile转化为Document
     *
     * @param multipartFile
     * @return
     */
    public static Document multipartFileToDocument(MultipartFile multipartFile) {
        byte[] bytes = new byte[0];
        try {
            bytes = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getDocument(bytes);
    }


    /**
     * 根据byte数组，生成document
     */
    private static Document getDocument(byte[] bfile) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new ByteArrayInputStream(bfile));

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

}
