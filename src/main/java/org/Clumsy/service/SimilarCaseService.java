package org.Clumsy.service;

import org.Clumsy.vo.CauseVO;

/**
 * Created by slow_time on 2017/7/17.
 */
public interface SimilarCaseService {

    /**
     * 类案推荐
     * @param id 文书id
     * @return 相似案件的案号集合
     */
    CauseVO recommendCases(String id);
}
