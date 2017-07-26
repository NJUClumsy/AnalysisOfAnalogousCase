package org.Clumsy.controller;

import org.junit.Assert;
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
        Assert.assertEquals(200, userInfoController.login("tydety97", "123456").getStatusCodeValue());
//        Assert.assertEquals(200, userInfoController.login("tydety", "12344533").getStatusCodeValue());
    }

    @Test
    public void testSignUp() throws Exception {
//        ResponseEntity<String> responseEntity = userInfoController.signUp("tydety97", "12344533");
//        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
//        Assert.assertEquals("用户名：tydety97已被占用", responseEntity.getBody());
//        ResponseEntity<String> responseEntity = userInfoController.signUp("tydety", "12344533");
//        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
//        Assert.assertEquals("用户名：tydety97已被占用", responseEntity.getBody());
    }


    @Test
    public void testGetUserCases() throws Exception {
//        ResponseEntity<CaseNumberVO> responseEntity = userInfoController.getUserCases("tydety");
//        Assert.assertEquals(204, responseEntity.getStatusCodeValue());
//        ResponseEntity<List<CaseNumberVO>> responseEntity = userInfoController.getUserCases("tydety97");
//        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
//
//        System.out.println(responseEntity.getBody());
//        System.out.println(responseEntity.getHeaders());
    }
}