package org.Clumsy.controller;

import org.Clumsy.entity.User;
import org.Clumsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by slow_time on 2017/7/15.
 */

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(User user) {
        return userService.login(user);
    }

}
