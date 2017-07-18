package org.Clumsy.service.impl;

import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by slow_time on 2017/7/17.
 */

@Service("similarCaseService")
public class SimilarCaseServiceImpl implements SimilarCaseService {


    @Override
    public List<CaseNumberVO> recommendCases(String id) {
        return null;
    }
}
