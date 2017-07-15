package org.Clumsy.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by slow_time on 2017/7/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class OrderInfoControllerTest {

    @Autowired
    OrderInfoController orderInfoController;


    @Test
    public void testReturnJson() throws Exception {

        System.out.println(orderInfoController.returnJson().size());
    }
}
