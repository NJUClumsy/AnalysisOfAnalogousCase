package org.Clumsy.service.impl;

import org.Clumsy.dao.UserRepository;
import org.Clumsy.entity.User;
import org.Clumsy.service.UserService;
import org.Clumsy.vo.CaseNumberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slow_time on 2017/7/15.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String login(String username, String password) {
        List<User> users = userRepository.findAllByUsernameAndPassword(username, password);
        if (users.size() > 0) {
            return users.get(0).getId();
        }
        else {
            return null;
        }
    }

    @Override
    public String signUp(String username, String password) {
        // 如果此用户名已经存在
        if (userRepository.findByUsername(username).size() > 0) {
            return null;
        }
        // 此用户名可用
        else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setCases(new ArrayList<>());
            User user1 = userRepository.save(user);
            return user1.getId();
        }
    }

    @Override
    public void saveCase(String username, String caseId, String caseNumber) {
        userRepository.saveUserCases(username, caseId, caseNumber);
    }

    @Override
    public List<CaseNumberVO> getUserCases(String userId) {
        User user = userRepository.getUserCases(userId);
        return user.getCases().stream().map(CaseNumberVO::new).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
