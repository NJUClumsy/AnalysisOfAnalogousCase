package org.Clumsy.controller;

import org.Clumsy.entity.User;
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
public class UserInfoControllerTest {

    @Autowired
    private UserInfoController userInfoController;


    @Test
    public void testLogin() throws Exception {

        User user = new User();
        user.setUsername("tydety97");
        user.setPassword("123456");
        System.out.println(userInfoController.login("tydety97", "123456"));
    }
}