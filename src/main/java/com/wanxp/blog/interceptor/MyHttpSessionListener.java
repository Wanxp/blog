package com.wanxp.blog.interceptor;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    public int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("创建session");
        online ++;
        arg0.getSession().getServletContext().setAttribute("count", online);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("销毁session");
        online --;
        arg0.getSession().getServletContext().setAttribute("count", online);
    }
}
