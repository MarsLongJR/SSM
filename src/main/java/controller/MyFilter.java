package controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class MyFilter implements Filter {
        private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("log成功");
        this.filterConfig=filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext=filterConfig.getServletContext();
        long before=System.currentTimeMillis();
        System.out.println("开始");
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        servletContext.log(""+httpServletRequest.getServletPath());
        filterChain.doFilter(servletRequest,servletResponse);

        long after=System.currentTimeMillis();
        servletContext.log("");
        servletContext.log("");
    }

    public void destroy() {
        filterConfig=null;
    }
}
