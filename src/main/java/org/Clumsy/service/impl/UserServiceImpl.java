package org.Clumsy.service.impl;

import org.Clumsy.dao.UserRepository;
import org.Clumsy.entity.User;
import org.Clumsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean login(User user) {
        List<User> users = userRepository.findAllByUsernameAndPassword(user.getUsername(), user.getPassword());
        return users.size() > 0;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
