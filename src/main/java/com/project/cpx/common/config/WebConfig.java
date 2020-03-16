package com.project.cpx.common.config;

import com.project.cpx.CpxFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/9 10:38
 * @Description:
 */
@Configuration
public class WebConfig {

    /**
     * 登陆校验
     * @return
     */
    @Bean
    public FilterRegistrationBean sessionFilterBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        CpxFilter cpxFilter = new CpxFilter();
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setFilter(cpxFilter);
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(Integer.MIN_VALUE);
        return registrationBean;
    }
}
