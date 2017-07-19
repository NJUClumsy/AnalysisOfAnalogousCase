package org.Clumsy.dao.operations;

import org.Clumsy.entity.User;

/**
 * Created by slow_time on 2017/7/17.
 */
public interface UserOperations {


    /**
     * 获得用户上传的案件文书
     * @param userId
     * @return
     */
    User getUserCases(String userId);


    /**
     * 用户上传未处理过的文书后，保存上传的记录
     * @param userId
     * @param caseID
     * @param caseNumber
     */
    void saveUserCases(String userId, String caseID, String caseNumber);
}
