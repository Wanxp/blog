package com.wanxp.blog.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wanxp.blog.interceptor.MyFilter;
import com.wanxp.blog.interceptor.MyHttpSessionListener;
import com.wanxp.blog.interceptor.TokenInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new TokenInterceptor()).excludePathPatterns("/static/**");
//    }
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(new MyHttpSessionListener());
//        System.out.println("listener");
//        return srb;
//    }
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public FilterRegistrationBean filterRegist() {
//        FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new MyFilter());
//        frBean.addUrlPatterns("/*","^static");
//
//        System.out.println("filter");
//        return frBean;
//    }
}