//package com.zy.zy_filesystem.aop;
//
//import java.lang.reflect.Method;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import com.zy.zy_filesystem.pojo.LogPojo;
//import com.zy.zy_filesystem.pojo.User;
//import com.zy.zy_filesystem.service.impl.LogPojoServiceImpl;
//
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.reflect.MethodSignature;
///**  
//*   
//* 项目名称：bookSystem  
//* 类名称：WebLogAspect  
//* 类描述：  
//* 创建人：zhangyi  
//* 创建时间：2019年2月13日 下午7:33:55  
//* 修改人：zhangyi  
//* 修改时间：2019年2月13日 下午7:33:55  
//* 修改备注：  
//* @version   
//*   
//*/
//@Aspect     // 表示一个切面bean
//@Component  // bean容器的组件注解。虽然放在contrller包里，但它不是控制器。如果注入service,但我们又没有放在service包里
//@Order(3)   // 有多个日志时，ORDER可以定义切面的执行顺序（数字越大，前置越后执行，后置越前执行）
//public class WebLogAspect {
//	//定义日志记录器--获取sl4j包下提供的logger
//    Logger logger = LoggerFactory.getLogger(this.getClass());
//    ThreadLocal<Long> startTime = new ThreadLocal<>();  //线程副本类去记录各个线程的开始时间
//    @Autowired
//    private LogPojoServiceImpl logPojoServiceImpl;
//    //在com.zy.zy_filesystem.controller包下,任意返回值(第一个*)、任意类(第二个*)、任意方法(第三个*)上插入切点
//    @Pointcut("execution(public * com.zy.zy_filesystem.controller.*.*(..))")
//    public void weblog() {
//
//    }
//
//    //方法的返回值注入给ret
//    @AfterReturning(returning = "ret", pointcut = "weblog()")
//    public void doafter(JoinPoint joinPoint,Object ret) {
//    	try {
//    		//获得注解
//        	Log controllerLog = getAnnotationLog(joinPoint);
//            logger.info("后置返回通知：");                     //info ,debug ,warn ,erro四种级别，这里我们注入info级别
//            startTime.set(System.currentTimeMillis());
//
//            //获取servlet请求对象---因为这不是控制器，这里不能注入HttpServletRequest，但springMVC本身提供ServletRequestAttributes可以拿到
//            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//            HttpServletRequest request = attributes.getRequest();
//            User userObj= (User) request.getSession().getAttribute("loginUser");//获取登录用户
//            String userId=userObj.getUserId();//获取账号
//            String nickName=userObj.getNickName();//获取昵称
//            String ip=request.getRemoteAddr();// 获取ip
//            int port=request.getRemotePort();//获取端口
//            String url=request.getRequestURL().toString(); //想那个url发的请求
//            String method=request.getMethod();//提交方式
//            String cls=joinPoint.getSignature().getDeclaringTypeName();//类
//            String classMethod=joinPoint.getSignature().getName();//方法
//            String para=Arrays.toString(joinPoint.getArgs());// 方法本传了哪些参数
//            String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//操作时间
//            long time=System.currentTimeMillis()-startTime.get();
//            logger.info("登录用户昵称:" +  nickName);
//            logger.info("ip:" +   ip);
//            logger.info("端口:" + port);
//            logger.info("URL:" + url);
//            logger.info("提交方式:" + method);
//            logger.info("类:" + cls);
//            logger.info("调用方法:" + classMethod);                     //
//            logger.info("接收参数:" + para);     // 方法本传了哪些参数
//            logger.info("操作时间:" + date);
//            //logger.info("返回值:" + ret);       // 响应的内容---方法的返回值responseEntity
//            logger.info("耗时:" + time);
//            if(controllerLog!=null) {
//            	String operationName=controllerLog.operationName();//获取模块名称
//            	 logger.info("模块:" + operationName);
//            	 //是否需要记录日志
//             	 boolean isRecord=controllerLog.record();
//             	 LogPojo logPojo=new LogPojo();
//            	 if(isRecord) {
//            		 logPojo.setNickName(nickName);
//            		 logPojo.setUserId(userId);
//            		 logPojo.setOperationName(operationName);
//            		 logPojo.setIp(ip);
//            		 logPojo.setPort(port);
//            		 logPojo.setUrl(url);
//            		 logPojo.setMethod(method);
//            		 logPojo.setCls(cls);
//            		 logPojo.setClassMethod(classMethod);
//            		 logPojo.setPara(para);
//            		 logPojo.setDate(date);
//            		 logPojo.setTime(time);
//            		 logPojo.setSuccess(1);
//            		 logPojoServiceImpl.insertLogPojo(logPojo);//把日志数据保存进数据库
//            		 logger.info(isRecord+"该日志需要记录-------------------------------");
//
//            	 }else {
//            		 logger.info(isRecord+"该日志不需要记录-------------------------------");
//            	 }
//            }
//            logger.info("---------------------------------------------------------------------");
//		} catch (Exception e) {
//			// 记录本地异常日志
//			logger.error("==通知异常==");
//			logger.error("异常信息:{}", e.getMessage());
//		    e.printStackTrace();
//		}
//
//    }
//
//    /**
//     * 是否存在注解，如果存在就获取
//     */
//    private static Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
//	Signature signature = joinPoint.getSignature();
//	MethodSignature methodSignature = (MethodSignature) signature;
//	Method method = methodSignature.getMethod();
//	if (method != null) {
//	    return method.getAnnotation(Log.class);
//	}
//	return null;
//    }
//
//}
