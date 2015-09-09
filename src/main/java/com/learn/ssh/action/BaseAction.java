package com.learn.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/8 12:25
 * @since jdk1.6.0_27
 */
public class BaseAction extends ActionSupport
        implements ServletRequestAware,ServletResponseAware,SessionAware,ModelDriven,Preparable {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Map<String, Object> session;

    public HttpServletResponse getResponse() {
        return response;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }


    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public void prepare() throws Exception {

    }
}