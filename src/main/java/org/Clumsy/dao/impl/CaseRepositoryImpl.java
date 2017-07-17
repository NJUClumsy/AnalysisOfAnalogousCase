package org.Clumsy.dao.impl;

import org.Clumsy.dao.operations.CaseOperations;
import org.Clumsy.entity.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by slow_time on 2017/7/17.
 */
public class CaseRepositoryImpl implements CaseOperations {

    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Case> findCauses() {
        Query query = new Query();
        query.fields().include("cause");
        return mongo.find(query, Case.class);
    }
}
