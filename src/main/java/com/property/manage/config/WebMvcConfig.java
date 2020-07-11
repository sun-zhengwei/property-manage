package com.property.manage.config;

import com.property.manage.demo.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: WebMvcConfig
 * @description: 拦截器需要注册在这里
 * @author: sunzhengwei
 * @create: 2020/7/9 15:07
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addInterceptor 注册拦截器
         * addPathPatterns 配置拦截规则
         */
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/demoproject/test/get/**");

        // 也可以排除拦截规则
        /*registry.addInterceptor(myInterceptor)
                .excludePathPatterns("/**");*/

        //也可以拦截多个路径
        /*registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**", "/test");*/

    }
}
