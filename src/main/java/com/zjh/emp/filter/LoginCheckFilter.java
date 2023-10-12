package com.zjh.emp.filter;

import com.alibaba.fastjson2.JSONObject;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/****************************
 * @project empservice
 * @package com.zjh.emp.filter
 * @className LoginCheckFilter
 * @author Zjiah
 * @date 2023/10/12 21:40
 * @Description:   *
 ****************************/
@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURI().toString();

        if (url.contains("login")) {
            log.info("登录---》放行");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = httpServletRequest.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            log.info("请求头为空 ====》未登录");
            Result error = Result.error("NOT_LOGIN");
            String serrorjson = JSONObject.toJSONString(error);

            httpServletResponse.getWriter().write(serrorjson);
            return;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败*------》过期");
            Result error = Result.error("NOT_LOGIN");
            String serrorjson = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(serrorjson);
            return;
        }


    }
}
