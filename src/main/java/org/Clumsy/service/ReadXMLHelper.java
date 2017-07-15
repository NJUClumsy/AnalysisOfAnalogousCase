package org.Clumsy.service;
import java.io.File;
import java.util.*;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by Lucifer on 17/7/15.
 */
public class ReadXMLHelper {

    private static ArrayList<String> keyValue = new ArrayList<String>();

    public static ArrayList<String> getKeyValue(String url){//必须是绝对路径
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(url));
            Element bookStore = document.getRootElement();

            Iterator it = bookStore.elementIterator();
            iterate(it);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return keyValue;
    }

    public static void iterate(Iterator it){
        while (it.hasNext()) {
//            System.out.println("=====开始遍历=====");
            Element book = (Element) it.next();

            List<Attribute> bookAttrs = book.attributes();
            for (Attribute attr : bookAttrs) {
//                System.out.println("--属性值：" + attr.getValue());
                keyValue.add(attr.getValue());
            }
            Iterator itt = book.elementIterator();
            iterate(itt);
//            System.out.println("=====结束遍历=====");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = ReadXMLHelper.getKeyValue("/Users/chengxuelie/Documents/GitHub/AnalysisOfAnalogousCase/src/main/java/org/Clumsy/service/a.xml");
        System.out.println(list);
    }

}

