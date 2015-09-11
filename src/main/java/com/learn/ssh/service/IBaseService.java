package com.learn.ssh.service;

import java.io.Serializable;
import java.util.List;

/**
 * 基础service接口
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:59
 * @since jdk1.6.0_27
 */
public interface IBaseService<T> {
    /**
     * 保存实体
     * @param obj
     */
    public void save(T obj);

    /**
     * 更新实体
     * @param obj
     */
    public void update(T obj);
    /**
     * 保存或者更新实体
     * @param obj
     */
    public void saveOrUpdate(T obj);

    /**
     * 删除实体
     * @param obj
     */
    public void delete(T obj);

    /**
     * 根据实体id删除实体对象
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据id获得实体
     * @param id
     */
    public T findById(Serializable id);

    /**
     * 根据hql查询list数据
     * @param hql
     * @param params
     * @return
     */
    public List<T> findListByHQL(String hql, Object... params);

    /**
     * 根据hql查询唯一结果的数据
     * @param hql
     * @param params
     * @return
     */
    public Object findUniqueResultByHQL(String hql, Object... params);
}
