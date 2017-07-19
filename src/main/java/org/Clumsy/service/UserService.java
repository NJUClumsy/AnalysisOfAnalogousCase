package org.Clumsy.service;

import org.Clumsy.entity.User;
import org.Clumsy.vo.CaseNumberVO;

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
    String login(String username, String password);


    /**
     * 用户注册
     * @param username
     * @param password
     * @return
     */
    String signUp(String username, String password);


    /**
     * 保存用户的上传文书的记录
     * @param username
     * @param caseId
     * @param caseNumber
     */
    void saveCase(String username, String caseId, String caseNumber);


    /**
     * 获得用户上传的所有文书
     * @param userId
     * @return
     */
    List<CaseNumberVO> getUserCases(String userId);


    /**
     * 获得所有的用户
     * @return
     */
    List<User> getAllUsers();
}
