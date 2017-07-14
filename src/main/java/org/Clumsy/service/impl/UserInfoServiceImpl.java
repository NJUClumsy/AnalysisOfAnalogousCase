package org.Clumsy.service.impl;

import org.Clumsy.dao.UserInfoDAO;
import org.Clumsy.entity.UserInfoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.Clumsy.service.UserInfoService;

import java.util.List;

/**
 * Created by slow_time on 2017/7/12.
 */

//使用@Service注解在Spring容器中注册名为userInfoService的UserInfoServiceImpl实例
@Service("userInfoService")
//使用@Transactional注解实现事务管理
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    public List<UserInfoPO> login(UserInfoPO cond) {
        return userInfoDAO.search(cond);
    }

    @Override
    public List<UserInfoPO> getAllUsers() {
        return null;
    }
}
