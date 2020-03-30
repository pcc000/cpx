package com.project.cpx;


import com.project.cpx.common.util.CookieUtil;
import com.project.cpx.common.util.CpxException;
import com.project.cpx.common.util.ErrorEnum;
import com.project.cpx.entity.CommonBuilder;
import com.project.cpx.entity.LoginLogEntity;
import com.project.cpx.service.LoginLogService;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/9 10:32
 * @Description:
 */
public class CpxFilter  implements Filter {

    private static List<String> whiteURL = new ArrayList();

    private LoginLogService loginLogService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        initWhiteURL();

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURI();
        this.addCross(httpServletRequest,httpServletResponse);
        if(isWhiteURI(url)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String sessionId = this.getSessionid(httpServletRequest);
//        String sessionId = httpServletRequest.getHeader("sessionId");
        if(StringUtils.isEmpty(sessionId)){
            throw new CpxException(ErrorEnum.NOT_LOGIN.getCode(),ErrorEnum.NOT_LOGIN.getMsg());
        }
        LoginLogEntity query = CommonBuilder.buildLoginQuery(sessionId);
        ServletContext sc = httpServletRequest.getSession().getServletContext();
        AnnotationConfigServletWebServerApplicationContext cxt = (AnnotationConfigServletWebServerApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
        if(cxt != null && cxt.getBean("loginLogServiceImpl") != null){
            loginLogService = (LoginLogService) cxt.getBean("loginLogServiceImpl");
            List<LoginLogEntity> loginList = loginLogService.query(query);
            if(CollectionUtils.isEmpty(loginList)){
                throw new CpxException(ErrorEnum.NOT_LOGIN.getCode(),ErrorEnum.NOT_LOGIN.getMsg());
            }
            if(System.currentTimeMillis() - loginList.get(0).getGmtModify().getTime()>=2*24*60*60*1000){
                throw new CpxException(ErrorEnum.LONG_TIME_NOT_LOGIN.getCode(),ErrorEnum.LONG_TIME_NOT_LOGIN.getMsg());
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    /**
     * 解决跨域问题
     * @param request
     * @param response
     */
    private void addCross(HttpServletRequest request, HttpServletResponse response){
        String currentOrigin = request.getHeader("Origin");
        String method = request.getMethod();response.setHeader("Access-Control-Allow-Origin", currentOrigin);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        String requestHeaders = request.getHeader("Access-Control-Request-Headers");
        if(!StringUtils.isEmpty(requestHeaders) && method.equals("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Headers", requestHeaders);
        }
    }

    private void initWhiteURL(){
        whiteURL.add("/user/login");
    }

    private boolean isWhiteURI(String uri) {
        return true;
//        if (whiteURL.isEmpty()) {
//            return Boolean.FALSE;
//        } else {
//            Iterator var2 = whiteURL.iterator();
//            String whiteURI;
//            do {
//                if (!var2.hasNext()) {
//                    return Boolean.FALSE;
//                }
//                whiteURI = (String)var2.next();
//            } while(!uri.matches(whiteURI));
//            return Boolean.TRUE;
//        }
    }

    private String getSessionid(HttpServletRequest request) {
        return CookieUtil.getCookieValue(request, "sid");
    }
}
