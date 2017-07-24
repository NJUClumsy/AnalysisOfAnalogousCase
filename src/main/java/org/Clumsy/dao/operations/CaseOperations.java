package org.Clumsy.dao.operations;

import org.Clumsy.entity.Case;

import java.util.List;

/**
 * Created by slow_time on 2017/7/17.
 */
public interface CaseOperations {

    /**
     * 获得所有案由
     * @return
     */
    List<Case> findCauses();


    /**
     * 通过案号获得Id
     * @param caseNumber
     * @return
     */
    Case findIdByCaseNumber(String caseNumber);


    /**
     * 获得所有主案由相同的文书
     * @param majorCause
     * @return
     */
    List<Case> findAllByMajorCause(String majorCause);

}
