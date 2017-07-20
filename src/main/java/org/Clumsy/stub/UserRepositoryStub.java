package org.Clumsy.stub;

import org.Clumsy.dao.operations.UserOperations;
import org.Clumsy.entity.User;

/**
 * Created by green-cherry on 2017/7/20.
 */
public class UserRepositoryStub implements UserOperations {
    @Override
    public User getUserCases(String userId) {
        User user=new User();
        user.setId("1");
        user.setUsername("1");
        user.setPassword("1");
        return user;
    }

    @Override
    public void saveUserCases(String userId, String caseID, String caseNumber) {

    }
}
