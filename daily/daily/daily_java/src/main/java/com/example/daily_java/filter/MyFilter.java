//package com.example.daily_java.filter;
//
////判断是否登陆的 filter
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//// /* 表示全部拦截
//@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
//public class MyFilter implements Filter {
//    //这里面 填写不需要 被拦截的地址
//    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(
//            new HashSet<String>( Arrays.asList("/api","/isLogin","/findCategory") )
//    );
//
//    //初始化调用的方法
//    //当服务器 被启动的时候，调用
//    public void init(FilterConfig filterConfig) throws ServletException { }
//
//    //拦截的方法
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
//
//
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        //解决跨域的问题
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
//        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//
//
//        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$","");
//        boolean allowePath =  ALLOWED_PATHS.contains(path);
//
//        filterChain.doFilter(request,response);
//
//
//
//    }
//
//    //销毁时候调用的方法
//    public void destroy() { }
//}
