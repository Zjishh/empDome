package com.zjh.emp.config;

import com.zjh.emp.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/****************************
 * @project empservice
 * @package com.zjh.emp.config
 * @className WbeConfig
 * @author Zjiah
 * @date 2023/10/13 13:20
 * @Description:   *
 ****************************/
@Configuration
public class WbeConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
