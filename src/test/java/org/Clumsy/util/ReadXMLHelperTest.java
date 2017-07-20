package org.Clumsy.util;

import org.Clumsy.entity.Case;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;


/**
 * Created by NathanielLu on 2017/7/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class ReadXMLHelperTest {

    private static Logger logger=Logger.getLogger(BytesToFile.class);

    @Test
    public void testGetCase() throws Exception {
        String url = "src/test/resources/g.xml";
        SAXReader sax=new SAXReader();
        File xmlFile=new File(url);
        try {
            Document document = sax.read(xmlFile);
            Case actual = ReadXMLHelper.getCase(document);
            System.out.println(actual.toString());
        } catch (DocumentException e) {
            logger.info("context"+e);
        }catch(NullPointerException e){
            logger.info("context"+e);
        }
    }

}