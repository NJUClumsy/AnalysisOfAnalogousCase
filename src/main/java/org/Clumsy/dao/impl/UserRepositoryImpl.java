package org.Clumsy.dao.impl;

import org.Clumsy.dao.operations.UserOperations;
import org.Clumsy.entity.CaseNumber;
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
    public User getUserCases(String userId) {
        Criteria where = Criteria.where("id").is(userId);
        Query query = new Query(where);
        query.fields().include("cases");
        return mongo.findOne(query, User.class);
    }

    @Override
    public void saveUserCases(String userId, String caseId, String caseNumber) {
        Criteria where = Criteria.where("id").is(userId);
        Query query = new Query(where);
        CaseNumber c = new CaseNumber();
        c.setCaseId(caseId);
        c.setCaseNumber(caseNumber);
        Update update = new Update().addToSet("cases", c);
        mongo.updateFirst(query, update, User.class);
    }
}
