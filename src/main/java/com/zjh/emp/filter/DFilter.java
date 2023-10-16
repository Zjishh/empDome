package com.zjh.emp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/****************************
 * @project empservice
 * @package com.zjh.emp.filter
 * @className Filter
 * @author Zjiah
 * @date 2023/10/11 18:27
 * @Description:  配置拦截器 *
 ****************************/
@WebFilter(urlPatterns = "/login22")
public class DFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("拦截器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到请求");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("拦截器销毁");
    }
}
