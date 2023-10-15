package com.vijani.TODOApp.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class ManualCorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {


        httpServletResponse.addHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods","GET, POST, PUT, PATCH, DELETE, OPTIONS");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials","true");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token, location");
        httpServletResponse.addHeader("Access-Control-Expose-Headers", "content-type, location");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }


}