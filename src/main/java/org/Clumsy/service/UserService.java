package org.Clumsy.service;

import org.Clumsy.entity.User;
import java.util.List;
/**
 * Created by slow_time on 2017/7/15.
 */
public interface UserService {

    Boolean login(User user);

    List<User> getAllUsers();
}
