package com.learn.ssh.interceptor;

import com.learn.ssh.action.BaseAction;
import com.learn.ssh.util.URLUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问日志拦截器
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/9/9 10:50
 * @since jdk1.6.0_27
 */
public class AccessLogInterceptor extends AbstractInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AccessLogInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object object = invocation.getAction();
        String result=invocation.invoke();
        if(object instanceof BaseAction){
            BaseAction action = (BaseAction) object;
            HttpServletRequest request = action.getRequest();

            StringBuilder sbRecord = new StringBuilder();
            long startTime = System.currentTimeMillis();

            StringBuilder requestParams = new StringBuilder();
            Map<String, String> params = new HashMap<String, String>();
            Enumeration<String> keys = request.getParameterNames();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                params.put(key, request.getParameter(key).toString());

                requestParams.append(key);
                requestParams.append("=");
                requestParams.append(request.getParameter(key).toString());
                requestParams.append("&");
            }


            //组装访问地址和远程的ip和请求信息
            sbRecord.append("URL:");
            sbRecord.append(URLUtil.getRemoteHost(request));
            sbRecord.append(" PATH:");
            sbRecord.append(request.getPathInfo());
            sbRecord.append(" PARAM:");
            sbRecord.append(requestParams.toString());

            sbRecord.append(" TimeUsed:");
            sbRecord.append(System.currentTimeMillis() - startTime);
            sbRecord.append("ms");
            logger.info(sbRecord.toString());
        }

        return result;
    }
}
