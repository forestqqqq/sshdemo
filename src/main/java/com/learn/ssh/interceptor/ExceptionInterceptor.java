package com.learn.ssh.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 13:55
 * @since jdk1.6.0_27
 */
public class ExceptionInterceptor extends AbstractInterceptor {

    private static final String RESULT_CODE = "exception";

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        try {
            return invocation.invoke();
        }catch (Exception e){
            e.printStackTrace();
            return RESULT_CODE;
        }

    }
}
