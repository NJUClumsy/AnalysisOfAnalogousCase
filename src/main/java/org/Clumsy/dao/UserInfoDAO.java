package org.Clumsy.dao;

import org.Clumsy.entity.UserInfoPO;

import java.util.List;

/**
 * Created by slow_time on 2017/7/11.
 */
public interface UserInfoDAO {
    public List<UserInfoPO> search(UserInfoPO cond);
}
