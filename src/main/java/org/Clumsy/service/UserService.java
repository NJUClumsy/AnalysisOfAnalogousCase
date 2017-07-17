package org.Clumsy.service;

import org.Clumsy.entity.User;
import org.Clumsy.vo.CauseVO;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */
public interface UserService {


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Boolean login(String username, String password);


    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    Boolean signUp(String username, String password);


    /**
     * 保存用户的上传文书的记录
     * @param username
     * @param caseNumber
     */
    void saveCase(String username, String caseNumber);


    /**
     * 获得用户上传的所有文书
     * @param username
     * @return
     */
    CauseVO getUserCases(String username);


    /**
     * 获得所有的用户
     * @return
     */
    List<User> getAllUsers();
}
