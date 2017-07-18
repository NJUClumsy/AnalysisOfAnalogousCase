package org.Clumsy.service;

import org.Clumsy.entity.Case;
import org.Clumsy.vo.CaseVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by slow_time on 2017/7/16.
 */
public interface CaseService {

    /**
     * 获得所有案件信息
     * @return
     */
    List<Case> getAllCases();

    /**
     * 通过案号获得案件信息
     * @param caseNumber
     * @return
     */
    CaseVO getCaseInfoByCaseNumber(String caseNumber);


    /**
     * 通过案件Id获得案件信息
     * @param id
     * @return
     */
    CaseVO getCaseInfoById(String id);


    /**
     * 通过案由所得一组案件信息
     * @param cause
     * @return
     */
    List<Case> getCasesByCause(String cause);


    /**
     * 获得所有的案由，以及其对应的出现的次数
     * @return
     */
    Map<String, Integer> getAllCauses();

    /**
     * 判断文书是否被处理过
     * @param caseFile
     * @return
     */
    Boolean isCreated(MultipartFile caseFile);

    /**
     * 文书未曾处理过，需要处理过后存储，再将处理结果返回
     * @param caseFile
     * @return
     */
    String createCase(MultipartFile caseFile);

    /**
     * 文书已经处理过，直接解析出文件中的案号，去数据库获取处理结果
     * @param caseFile
     * @return
     */
    String constructCase(MultipartFile caseFile);
}
