package com.learn.ssh.dao.impl;

import com.learn.ssh.dao.IUserDao;
import com.learn.ssh.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 16:11
 * @since jdk1.6.0_27
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User getByUsername(String username){
        return (User)findUniqueResultByHQL("from User where username = ? ",username);
    }

}
