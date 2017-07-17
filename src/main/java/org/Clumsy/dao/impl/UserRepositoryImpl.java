package org.Clumsy.dao.impl;

import org.Clumsy.dao.operations.UserOperations;
import org.Clumsy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by slow_time on 2017/7/17.
 */
public class UserRepositoryImpl implements UserOperations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public User getUserCases(String username) {
        Criteria where = Criteria.where("username").is(username);
        Query query = new Query(where);
        query.fields().include("cases");
        return mongo.findOne(query, User.class);
    }

    @Override
    public void saveUserCases(String username, String caseNumber) {
        Criteria where = Criteria.where("username").is(username);
        Query query = new Query(where);
        Update update = new Update().addToSet("cases", caseNumber);
        mongo.updateFirst(query, update, User.class);
    }
}
