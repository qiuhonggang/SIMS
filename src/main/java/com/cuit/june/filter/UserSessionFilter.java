package com.cuit.june.filter;

/**
 * Created by qhg on 16/6/5.
 */

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录过滤
 */
public class UserSessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 请求的url
        String url = request.getRequestURI();

        Object obj = request.getSession().getAttribute("user");

        //请求的url是登录页或者css和js文件则不过滤
        if (url.indexOf("/login") > -1 || url.endsWith(".css") || url.endsWith(".js")) {
            filterChain.doFilter(request, response);
            return;
        }
        if (obj == null) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}