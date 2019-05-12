package com.wanxp.blog.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyFilter implements Filter {  
	 
    @Override  
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {  
        System.out.println(MyFilter.class.getName() + servletRequest.getParameter("name"));
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        //防xss,sql注入
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) servletRequest);


        if(hrequest.getRequestURI().indexOf("/index") != -1 ||
                hrequest.getRequestURI().indexOf("/asd") != -1 ||
                hrequest.getRequestURI().indexOf("/online") != -1 ||
                hrequest.getRequestURI().indexOf("/login") != -1
                ) {
            //filterChain.doFilter(servletRequest, servletResponse);
            filterChain.doFilter(xssRequest, servletResponse);
        }else {
        	HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
            wrapper.sendRedirect("/login");
        }
    }  
    @Override  
    public void destroy() {  
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }    
}  