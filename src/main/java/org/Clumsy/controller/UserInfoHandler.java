package org.Clumsy.controller;

import org.Clumsy.entity.UserInfoPO;
import org.Clumsy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * Created by slow_time on 2017/7/12.
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoHandler {

    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/login")
    public String login(UserInfoPO ui) {
        List<UserInfoPO> uilist = userInfoService.login(ui);
        if (uilist.size() > 0) {
            // 登录成功
            return "index";
        }
        else {
            // 登录失败，重定向到login.jsp
            return "redirect:/login.jsp";
        }
    }
}
