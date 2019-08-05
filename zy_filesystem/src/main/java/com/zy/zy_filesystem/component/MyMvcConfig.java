//package com.zy.zy_filesystem.component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import com.zy.zy_filesystem.component.LoginHandlerInterceptor;
//@Configuration //用于定义配置类，可替换xml配置文件
//public class MyMvcConfig extends WebMvcConfigurerAdapter {
//
////	@Override
////	public void addViewControllers(ViewControllerRegistry registry) {
////		// 携带mycof参数，则跳转到test.html
////		registry.addViewController("/").setViewName("login");
////	}
////	
////	@Bean
////	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
////		WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
//////			@Override
//////			public void addViewControllers(ViewControllerRegistry registry) {
////				//登录重定向
////				//registry.addViewController("/").setViewName("login");
////				//registry.addViewController("/main.html").setViewName("main");
//////			}
////			//注册拦截器
////			@Override
////			public void addInterceptors(InterceptorRegistry registry) {
////				// TODO Auto-generated method stub
////				registry.addInterceptor(new LoginHandlerInterceptor())
////				.addPathPatterns("/**")//拦截
////				.excludePathPatterns("/","/user/login","/static/**","/sel");//放行
////			}
////		};
////		return webMvcConfigurerAdapter;
////	}
//	@Autowired
//	private LoginHandlerInterceptor loginHandlerInterceptor;
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("login");
//		registry.addViewController("/main.html").setViewName("main");
////		registry.addViewController("/uploadStatus").setViewName("fileUp");
//	}
//	
////	@Override
////	public void addInterceptors(InterceptorRegistry registry) {
////		registry.addInterceptor(loginHandlerInterceptor)
////		.addPathPatterns("/**")//拦截
////		.excludePathPatterns("/","/user/login","/static/**","/sel","login.html");//放行;
////	}
//	
//}
