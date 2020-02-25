//package com.zy.socket.config.shiro;
//
//
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
//    @Override  //登录拦截到首页
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)throws Exception{
//        String successUrl="/login";
//        WebUtils.issueRedirect(request,response,successUrl);
//        System.out.println("登录首页拦截");
//        return false;
//    }
//}
