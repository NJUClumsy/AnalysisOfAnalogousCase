package org.Clumsy.dao.impl;

import org.Clumsy.dao.operations.CaseOperations;
import org.Clumsy.entity.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
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

    @Override
    public Case findIdByCaseNumber(String caseNumber) {
        Criteria where = Criteria.where("caseNumber").is(caseNumber);
        Query query = new Query(where);
        query.fields().include("id");
        return mongo.findOne(query, Case.class);
    }

    @Override
    public List<Case> findAllByMajorCause(String majorCause) {
        Criteria where = Criteria.where("majorCause.accusationCode").is(majorCause);
        Query query = new Query(where);
        return mongo.find(query, Case.class);
    }
}
