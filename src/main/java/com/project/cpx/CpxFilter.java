package com.project.cpx;


import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/9 10:32
 * @Description:
 */
public class CpxFilter  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        this.addCross(httpServletRequest,httpServletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
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
}
