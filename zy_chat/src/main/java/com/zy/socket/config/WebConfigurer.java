package com.zy.socket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: SpringCloud
 * @description: 拦截器配置
 * @author: zhang yi
 * @create: 2019-10-10 16:40
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 这个方法是用来配置静态资源的，比如html，js，css，等等
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    /**
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                //表示拦截所有的请求，
                .addPathPatterns("/**")
                //表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
                .excludePathPatterns("/login", "/index","/layui/**","/img/**","/css/**","/fonts/**","/images/**","/js/**");
    }

    /**
     * 设置默认页面
     *
     * @param registry
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        System.out.println("跳转界面》》》》》》");
//        registry.addViewController("/").setViewName("/login");
//        // 设置优先级  当请求地址有重复的时候  执行优先级最高的
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        WebMvcConfigurer.super.addViewControllers(registry);
//    }
}
