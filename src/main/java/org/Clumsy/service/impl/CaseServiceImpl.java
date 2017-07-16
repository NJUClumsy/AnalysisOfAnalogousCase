package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slow_time on 2017/7/16.
 */

@Service("caseService")
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public Case getCaseInfoByCaseNumber(String caseNumber) {
        return caseRepository.findFirstByCaseNumber(caseNumber);
    }
}
