//package com.zy.zy_filesystem.component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
////定义拦截器	
//@Component   //把类加入到IOC容器中 
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//	
//	//目标方法之前
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//			Object obj=request.getSession().getAttribute("loginUser");
//			if(obj==null){
//				//未登录
//				request.setAttribute("msg", "你还未登录，去请登录");
//				request.getRequestDispatcher("/").forward(request, response);//拦截器拦截后，会进入这里
//				return false;
//			}else {
//				//已登录，放行
//				return true;
//			}
//	}
//	
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
//	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
//	
//	
//	
//}
