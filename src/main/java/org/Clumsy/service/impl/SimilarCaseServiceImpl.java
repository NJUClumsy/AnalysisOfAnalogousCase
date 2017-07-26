package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.SimilarCaseService;
import org.Clumsy.vo.CaseNumberVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by slow_time on 2017/7/17.
 */

@Service("similarCaseService")
public class SimilarCaseServiceImpl implements SimilarCaseService {

    @Autowired
    CaseRepository caseRepository;

    private static Logger logger=Logger.getLogger(SimilarCaseServiceImpl.class);

    @Override
    public List<CaseNumberVO> recommendCases(String id) {
        List<CaseNumberVO> list = new ArrayList<>();


        try {
            String cp = "/python/Recommend.py";
            Process process = Runtime.getRuntime().exec("python3 " + SimilarCaseServiceImpl.class.getResource(cp).getFile() + " " + id);

            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errLine;
            while ((errLine = err.readLine()) != null) {
                logger.info(errLine);
            }
            String line= in.readLine();
            if (line == null)
                return list;
            in.close();
            process.waitFor();
            String[] strList = line.split(",");
            if (strList.length == 1) {
                return list;
            }
            for (String o : strList){
                Case instantCase = caseRepository.findOne(o);
                CaseNumberVO ins = new CaseNumberVO(instantCase.getId(),instantCase.getCaseNumber());
                list.add(ins);
            }
        } catch (IOException | InterruptedException e) {
            logger.info(e);
        }
        return list;

    }
}
