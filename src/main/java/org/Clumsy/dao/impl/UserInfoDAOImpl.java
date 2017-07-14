package org.Clumsy.dao.impl;

import org.Clumsy.dao.UserInfoDAO;
import org.Clumsy.entity.UserInfoPO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by slow_time on 2017/7/11.
 */

@Repository("userInfoDAO")
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<UserInfoPO> search(UserInfoPO cond) {
        List<UserInfoPO> uiList = null;
        // 获得session
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(UserInfoPO.class);
        Example example = Example.create(cond);
        c.add(example);
        uiList = c.list();
        return uiList;
    }
}
