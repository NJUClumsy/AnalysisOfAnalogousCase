package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.Clumsy.vo.CaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public CaseVO getCaseInfoByCaseNumber(String caseNumber) {
        Case c = caseRepository.findFirstByCaseNumber(caseNumber);
        return transfer(c);
    }

    @Override
    public CaseVO getCaseInfoById(String id) {
        Case c = caseRepository.findById(id);
        return transfer(c);
    }

    @Override
    public List<Case> getCasesByCause(String cause) {
        return caseRepository.findAllByCause(cause);
    }

    @Override
    public Map<String, Integer> getAllCauses() {
        List<Case> cases = caseRepository.findCauses();
        Map<String, Integer> causes = new HashMap<>();
        for(Case i : cases) {
            if (i.getCause() != null) {
                if (causes.containsKey(i.getCause()))
                    causes.put(i.getCause(), causes.get(i.getCause()) + 1);
                else
                    causes.put(i.getCause(), 1);
            }
        }
        return causes;
    }

    @Override
    public Boolean isCreated(MultipartFile caseFile) {
        return null;
    }

    @Override
    public CaseVO createCase(MultipartFile caseFile) {
        return null;
    }

    @Override
    public CaseVO constructCase(MultipartFile caseFile) {
        return null;
    }



    /**
     * 将Case转换为CaseVO
     * @param c
     * @return
     */
    private CaseVO transfer(Case c) {
        if (c == null)
            return null;
        else {
            if (c.getId() == null)
                return null;
            else
                return new CaseVO(c);
        }
    }
}
