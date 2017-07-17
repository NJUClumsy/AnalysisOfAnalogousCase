package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.Clumsy.util.BytesToFile;
import org.Clumsy.util.ReadXMLHelper;
import org.Clumsy.util.VOEntityConvertHelper;
import org.Clumsy.vo.CaseVO;
import org.dom4j.Document;
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
    public Case getCaseInfoByCaseNumber(String caseNumber) {
        return caseRepository.findFirstByCaseNumber(caseNumber);
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

    /**
     * 判断文书是否被处理过
     * @param caseFile
     * @return boolean
     */
    @Override
    public Boolean isCreated(MultipartFile caseFile) {
        boolean isCreated = false;

        Case thisCase = initialize(caseFile);
        String caseNumber = thisCase.getCaseNumber();

        List<Case> caseList = getAllCases();
        for(Case ins: caseList){
            if(ins.getCaseNumber().equals(caseNumber)){
                isCreated = true;
            }
        }
        return isCreated;
    }

    /**
     * 文书未曾处理过，需要处理过后存储，再将处理结果返回
     * @param caseFile
     * @return CaseVO
     */
    @Override
    public CaseVO createCase(MultipartFile caseFile) {
        Case thisCase = initialize(caseFile);
        CaseVO caseVO = VOEntityConvertHelper.convert(thisCase);

        if(!isCreated(caseFile)){
            //存储的接口？？？
        }
        return caseVO;
    }

    /**
     * 文书已经处理过，直接解析出文件中的案号，去数据库获取处理结果
     * @param caseFile
     * @return CaseVO
     */
    @Override
    public CaseVO constructCase(MultipartFile caseFile) {
        Case thisCase = initialize(caseFile);
        String caseNumber = thisCase.getCaseNumber();

        Case found = getCaseInfoByCaseNumber(caseNumber);
        CaseVO caseVO = VOEntityConvertHelper.convert(found);
        return caseVO;
    }

    /**
     * 初始化文件
     * @param caseFile
     * @return Case
     */
    public Case initialize(MultipartFile caseFile){
        //处理文件
        Document document = BytesToFile.multipartFileToDocument(caseFile);
        Case thisCase = ReadXMLHelper.getCase(document);
        return thisCase;
    }
}
