package com.zy.common.base.config;

import com.zy.common.base.util.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: ota
 * @description: 全局异常处理器
 * @author: zhang yi
 * @create: 2020-04-02 15:25
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    public ReturnResult intercept(HttpServletRequest req, Exception e) {
    	log.error(e.getMessage());
        return ReturnResult.error("系统异常");
    }
}
