package com.tianqing.web.filter.xss;

import javax.servlet.*;
import java.io.IOException;

/**
 * Xss漏洞过滤器
 * Created by hyb on 2016/4/25.
 */
public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new XssFilterRequest(servletRequest),servletResponse);
    }

    @Override
    public void destroy() {

    }

}
