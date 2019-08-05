package com.zy.zy_filesystem.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
/**  
*   
* 项目名称：bookSystem  
* 类名称：Log  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月13日 下午7:50:50  
* 修改人：zhangyi  
* 修改时间：2019年2月13日 下午7:50:50  
* 修改备注：  
* @version   
*   
*/
@Target({ElementType.PARAMETER, ElementType.METHOD}) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented 
public @interface Log {
  /** 是否记录日志  true记录   false不记录**/ 
  public boolean record() default true; 
    
  /** 要执行的具体操作比如：添加用户 **/ 
  public String operationName() default "";
}
