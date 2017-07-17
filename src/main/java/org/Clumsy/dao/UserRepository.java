package org.Clumsy.dao;

import org.Clumsy.dao.operations.UserOperations;
import org.Clumsy.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */
public interface UserRepository extends MongoRepository<User, String>, UserOperations {

    List<User> findAllByUsernameAndPassword(String username, String password);

    List<User> findByUsername(String username);

}
