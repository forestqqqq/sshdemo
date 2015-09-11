package com.learn.ssh.dao;

import com.learn.ssh.dao.IBaseDao;
import com.learn.ssh.model.User;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:52
 * @since jdk1.6.0_27
 */
public interface IUserDao extends IBaseDao<User> {
    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getByUsername(String username);
}
