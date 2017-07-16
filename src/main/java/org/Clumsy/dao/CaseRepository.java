package org.Clumsy.dao;

import org.Clumsy.entity.Case;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by slow_time on 2017/7/16.
 */
public interface CaseRepository extends MongoRepository<Case, String> {

    Case findFirstByCaseNumber(String caseNumber);
}
