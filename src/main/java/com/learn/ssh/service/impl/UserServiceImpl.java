package com.learn.ssh.service.impl;

import com.learn.ssh.dao.IUserDao;
import com.learn.ssh.model.User;
import com.learn.ssh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 17:15
 * @since jdk1.6.0_27
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
