package com.zjh.emp.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.zjh.emp.pojo.Result;
import com.zjh.emp.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****************************
 * @project empservice
 * @package com.zjh.emp.interceptor
 * @className LoginCheckInterceptor
 * @author Zjiah
 * @date 2023/10/13 13:16
 * @Description:   *
 ****************************/
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override//目标资源运行前运行，返回值是ture是放行 FALSE 不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----------------》preHandle拦截到");
        String url = request.getRequestURI();

        if (url.contains("login")) {
            log.info("登录---》放行");

            return true;
        }

        String token = request.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            log.info("请求头为空 ====》未登录");
            Result error = Result.error("NOT_LOGIN");
            String serrorjson = JSONObject.toJSONString(error);
            response.getWriter().write(serrorjson);
            return false;
        }

        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析失败*------》过期");
            Result error = Result.error("NOT_LOGIN");
            String serrorjson = JSONObject.toJSONString(error);
            response.getWriter().write(serrorjson);
            return false;
        }

        log.info("令牌校验通过");
        return true;
    }

    @Override//目标资源运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("-----------------》postHandle");
    }

    @Override//视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("-----------------》afterCompletion");
    }
}
