package com.example.myworkone.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myworkone.beans.Dao_bean;

import com.example.myworkone.dao.Dao_beanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dao_beanDaoConfig;

    private final Dao_beanDao dao_beanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dao_beanDaoConfig = daoConfigMap.get(Dao_beanDao.class).clone();
        dao_beanDaoConfig.initIdentityScope(type);

        dao_beanDao = new Dao_beanDao(dao_beanDaoConfig, this);

        registerDao(Dao_bean.class, dao_beanDao);
    }
    
    public void clear() {
        dao_beanDaoConfig.clearIdentityScope();
    }

    public Dao_beanDao getDao_beanDao() {
        return dao_beanDao;
    }

}
