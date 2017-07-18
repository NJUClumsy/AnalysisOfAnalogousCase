package org.Clumsy.service.impl;

import org.Clumsy.dao.UserRepository;
import org.Clumsy.entity.User;
import org.Clumsy.service.UserService;
import org.Clumsy.vo.CauseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Boolean login(String username, String password) {
        return userRepository.findAllByUsernameAndPassword(username, password).size() > 0;
    }

    @Override
    public Boolean signUp(String username, String password) {
        // 如果此用户名已经存在
        if (userRepository.findByUsername(username).size() > 0) {
            return false;
        }
        // 此用户名可用
        else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setCases(new ArrayList<>());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public void saveCase(String username, String caseNumber) {
        userRepository.saveUserCases(username, caseNumber);
    }

    @Override
    public CauseVO getUserCases(String username) {
        User user = userRepository.getUserCases(username);
        return new CauseVO(user.getCases());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
