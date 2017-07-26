package org.Clumsy.util;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by NathanielLu on 2017/7/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class BytesToFileTest {

    private static Logger logger=Logger.getLogger(BytesToFile.class);

    @Test
    public void testGetBytes() throws Exception{
//        String url = "src/test/resources/g.xml";
//        System.out.println(BytesToFile.getBytes(url));
    }

}