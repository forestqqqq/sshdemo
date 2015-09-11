package com.learn.ssh.dao.impl;

import com.learn.ssh.dao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基础的dao接口实现类
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:20
 * @since jdk1.6.0_27
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

    private Class<T> clazz;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        System.out.println("DAO的真实实现类是：" + this.clazz.getName());
    }

    @Override
    public void save(T obj){
        Session session = getSession();
        session.save(obj);
    }

    @Override
    public void update(T obj){
        Session session = getSession();
        session.update(obj);
    }

    @Override
    public void saveOrUpdate(T obj){
        Session session = getSession();
        session.saveOrUpdate(obj);
    }
    @Override
    public void delete(T obj){
        Session session = getSession();
        session.delete(obj);
    }

    @Override
    public void delete(Serializable id) {
        getSession().delete(findById(id));
    }

    @Override
    public T findById(Serializable id){
        return (T) this.getSession().get(this.clazz, id);
    }

    @Override
    public List<T> findListByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.list();
    }

    @Override
    public Object findUniqueResultByHQL(String hql, Object... params) {
        Query query = this.getSession().createQuery(hql);
        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params);
        }
        return query.uniqueResult();
    }


}
