package org.Clumsy.controller;

import org.Clumsy.service.UserService;
import org.Clumsy.vo.CauseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by slow_time on 2017/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;


    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 登录成功，返回状态码200
        if (userService.login(username, password)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        // 登录失败，返回状态码401
        else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 注册成功，返回状态码201
        if (userService.signUp(username, password)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        // 注册失败，返回状态码409
        else {
            return new ResponseEntity<>("用户名：" + username + "已被占用", HttpStatus.CONFLICT);
        }
    }


    /**
     * 用户获取自己上传的所有文书的案号
     * @param username
     * @return
     */
    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    public ResponseEntity<CauseVO> getUserCases(@RequestParam("username") String username) {
        CauseVO causeVO = userService.getUserCases(username);
        if (causeVO != null) {
            if (causeVO.causes != null) {
                if (causeVO.causes.size() > 0) {
                    return new ResponseEntity<>(causeVO, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

}