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

    List<Case> getAllCases();

    Case getCaseInfoByCaseNumber(String caseNumber);

    List<Case> getCasesByCause(String cause);

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
    CaseVO createCase(MultipartFile caseFile);

    /**
     * 文书已经处理过，直接解析出文件中的案号，去数据库获取处理结果
     * @param caseFile
     * @return
     */
    CaseVO constructCase(MultipartFile caseFile);
}
