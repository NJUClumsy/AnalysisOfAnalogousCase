package org.Clumsy.service;

import org.Clumsy.entity.UserInfoPO;

import java.util.List;

/**
 * Created by slow_time on 2017/7/12.
 */
public interface UserInfoService {

    List<UserInfoPO> login(UserInfoPO cond);
}
