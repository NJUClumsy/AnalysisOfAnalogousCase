package org.Clumsy.dao.operations;

import org.Clumsy.entity.User;

/**
 * Created by slow_time on 2017/7/17.
 */
public interface UserOperations {

    User getUserCases(String username);

    void saveUserCases(String username, String caseNumber);
}
