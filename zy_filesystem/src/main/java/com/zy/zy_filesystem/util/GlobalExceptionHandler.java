package com.zy.zy_filesystem.util;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice  //用来监控Multipart上传的文件大小是否受限，当出现此异常时在前端页面给出提示。
public class GlobalExceptionHandler {
	@ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, Map<String,Object> map) {
        map.put("message", e.getCause().getMessage());
        return "fileUp/fileUp";
    }
}
