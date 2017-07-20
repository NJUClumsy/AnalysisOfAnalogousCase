package org.Clumsy.dao;

import org.Clumsy.dao.operations.CaseOperations;
import org.Clumsy.entity.Case;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by slow_time on 2017/7/16.
 */
public interface CaseRepository extends MongoRepository<Case, String>, CaseOperations {

    Case findFirstByCaseNumber(String caseNumber);

    List<Case> findAllByCause(String cause);

    /**
     * 根据案号返回对应的文书
     * @param causeNumber
     * @return 若文书之前未被处理过，则返回的List的size为0；若已经被处理过，则返回的是一个size为1的List
     */
    List<Case> findByCaseNumber(String causeNumber);

}
