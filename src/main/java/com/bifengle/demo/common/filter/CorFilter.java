package com.bifengle.demo.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Arrays;

@WebFilter(filterName = "corsFilter", urlPatterns = "/*")
public class CorFilter implements Filter {

    @Value("${cors-origin-whitelist}")
    String corsOriginWhitelist = "";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String[] whitelistOrigins = corsOriginWhitelist.split(";");
        String origin = request.getHeader("Origin");

        if (Arrays.asList(whitelistOrigins).contains(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "csrf-token");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }


        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
