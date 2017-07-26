package org.Clumsy.service.impl;

import org.Clumsy.dao.CaseRepository;
import org.Clumsy.dao.UserRepository;
import org.Clumsy.entity.Case;
import org.Clumsy.service.CaseService;
import org.Clumsy.util.BytesToFile;
import org.Clumsy.util.ReadXMLHelper;
import org.Clumsy.vo.CaseVO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by slow_time on 2017/7/16.
 */

@Service("caseService")
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private UserRepository userRepository;


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
        Case c = caseRepository.findOne(id);
        return transfer(c);
    }

    @Override
    public List<Case> getCasesByCause(String cause) {
        return caseRepository.findAllByMajorCause(cause);
    }

    @Override
    public Map<String, Long> getAllCauses() {
        List<Case> cases = caseRepository.findCauses();
        return cases.stream().filter(c->c.getMajorCause() != null).collect(groupingBy(c -> c.getMajorCause().getAccusationName(), counting()));
    }

    /**
     * 判断文书是否被处理过
     * @param caseFile
     * @return boolean
     */
    @Override
    public Boolean isCreated(MultipartFile caseFile) throws IOException, DocumentException {
        boolean isCreated = false;

        Case thisCase = initialize(caseFile);
        String caseNumber = thisCase.getCaseNumber();

        List<Case> caseList = caseRepository.findByCaseNumber(caseNumber);
        if (caseList != null && !caseList.isEmpty()) {
            isCreated = true;
        }
        return isCreated;
    }

    /**
     * 文书未曾处理过，需要处理过后存储，再将处理结果返回
     * @param caseFile
     * @return String
     */
    @Override
    public String createCase(MultipartFile caseFile, String userId) throws IOException, DocumentException {
        Case thisCase = initialize(caseFile);

        caseRepository.save(thisCase);

        String caseNumber = thisCase.getCaseNumber();
        Case found = caseRepository.findIdByCaseNumber(caseNumber);
        userRepository.saveUserCases(userId, found.getId(), caseNumber);
        return found.getId();
    }

    /**
     * 文书已经处理过，直接解析出文件中的案号，去数据库获取处理结果
     * @param caseFile
     * @return String
     */
    @Override
    public String constructCase(MultipartFile caseFile) throws IOException, DocumentException {
        Case thisCase = initialize(caseFile);
        String caseNumber = thisCase.getCaseNumber();
        Case found = caseRepository.findIdByCaseNumber(caseNumber);
        return found.getId();
    }



    /**
     * 初始化文件
     * @param caseFile
     * @return Case
     */
    private Case initialize(MultipartFile caseFile) throws IOException, DocumentException {
        //处理文件
        Document document = BytesToFile.multipartFileToDocument(caseFile);
        Case thisCase = ReadXMLHelper.getCase(document);
        return thisCase;
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
