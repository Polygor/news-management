package com.epam.polygor.testapp.news.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(filterName = "CharsetFilter", urlPatterns = "/*", dispatcherTypes = DispatcherType.FORWARD)
public class CharsetFilter implements Filter {
    private static final String UTF_8 = "UTF-8";
    private static final String PARAMETERS_ONE ="text/html; charset=UTF-8";
    private static final String PARAMETERS_TWO="jsp; charset=UTF-8";
    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        servletRequest.setCharacterEncoding(UTF_8);
        servletResponse.setContentType(PARAMETERS_ONE);
        servletResponse.setContentType(PARAMETERS_TWO);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}