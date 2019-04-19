package com.netease.trading.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        System.out.println("in Filter: "+path);
        // 从session里获取用户名
        String userName = (String) session.getAttribute("user");
        // 登陆页面无需过滤
        if(path.contains("/login") || path.contains("/logout")) {
            chain.doFilter(servletRequest, servletResponse);
        }
        // 判断如果没有获取用户名,就跳转到登陆页面
        if(userName == null || "".equals(userName)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/trading/html/login");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
