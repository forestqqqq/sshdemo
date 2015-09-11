package com.learn.ssh.service.impl;

import com.learn.ssh.dao.impl.BaseDaoImpl;
import com.learn.ssh.service.IBaseService;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:31
 * @since jdk1.6.0_27
 */

public class BaseServiceImpl<T> implements IBaseService<T> {

    /**
     * 注入BaseDao
     */
    private BaseDaoImpl<T> dao;
    @Resource
    public void setDao(BaseDaoImpl<T> dao) {
        this.dao = dao;
    }

    @Transactional
    public void save(T entity) {
        dao.save(entity);
    }

    @Transactional
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdate(T obj) {
        dao.saveOrUpdate(obj);
    }

    @Override
    @Transactional
    public void delete(T obj) {
        dao.delete(obj);
    }

    @Override
    @Transactional
    public void delete(Serializable id) {
        dao.delete(id);
    }

    @Override
    public T findById(Serializable id) {
        return dao.findById(id);
    }

    public List<T> findListByHQL(String hql, Object... params) {
        return dao.findListByHQL(hql, params);
    }

    @Override
    public Object findUniqueResultByHQL(String hql, Object... params) {
        return dao.findUniqueResultByHQL(hql,params);
    }
}