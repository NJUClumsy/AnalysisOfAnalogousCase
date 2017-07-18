package org.Clumsy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by slow_time on 2017/7/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-config.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    public void testReturnJson() throws Exception {
        System.out.println(userService.getAllUsers().get(0));
    }

    @Test
    public void testLogin() throws Exception {
        assertTrue(userService.login("tydety97", "123456"));
    }

    @Test
    public void testSignUp() throws Exception {
        assertFalse(userService.signUp("slowtime", "123456789"));
    }

//    @Test
//    public void tesSaveCase() throws Exception {
//        userService.saveCase("slowtime", "（2008）丽民初字第3531号");
//    }


    @Test
    public void tesGetUserCases() throws Exception {
        System.out.println(userService.getUserCases("slowtime"));
    }

}
