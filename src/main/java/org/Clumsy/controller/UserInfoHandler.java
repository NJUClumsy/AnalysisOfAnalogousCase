package org.Clumsy.controller;

import org.Clumsy.entity.UserInfoPO;
import org.Clumsy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("/returnJson")
    public List<UserInfoPO> returnJson() {
        return userInfoService.login(new UserInfoPO(1, "tydety97", "123456"));
    }
}
