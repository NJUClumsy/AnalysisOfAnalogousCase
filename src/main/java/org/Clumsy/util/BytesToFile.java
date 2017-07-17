package org.Clumsy.util;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 * 将multipartFile转化成Document
 * Created by Lucifer on 17/7/17.
 */
public class BytesToFile {
    private static Logger logger=Logger.getLogger(BytesToFile.class);

    private BytesToFile(){

    }

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
            logger.info("context"+e);
        } catch (IOException e) {
            logger.info("context"+e);
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
            logger.info("context"+e);
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
            logger.info("context"+e);
        }
        return document;
    }
}

