package org.Clumsy.service;

import org.Clumsy.entity.Case;

import java.util.List;

/**
 * Created by slow_time on 2017/7/16.
 */
public interface CaseService {

    List<Case> getAllCases();

    Case getCaseInfoByCaseNumber(String caseNumber);
}
