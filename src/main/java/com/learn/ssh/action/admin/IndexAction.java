package com.learn.ssh.action.admin;

import com.learn.ssh.action.BaseAction;
import com.learn.ssh.model.User;
import com.learn.ssh.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

import javax.annotation.Resource;

/**
 * 管理员页面
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/8 12:05
 * @since jdk1.6.0_27
 */
public class IndexAction extends BaseAction {

    @Resource
    private IUserService userService;

    /**
     * 后台首页
     * @return
     */
    public String index(){
        User user = userService.getByUsername("forest");
        this.getRequest().setAttribute("user",user);
        return SUCCESS;
    }
}
