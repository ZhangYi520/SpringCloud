package com.zy.zy_filesystem.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**  
*   
* 项目名称：bookSystem  
* 类名称：LogPojo  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月14日 下午2:28:11  
* 修改人：zhangyi  
* 修改时间：2019年2月14日 下午2:28:11  
* 修改备注：  
* @version   
*   
*/
public class LogPojo {
	private Integer id;//主键
	private String userId;//登录用户账号
	private String nickName;//登录用户昵称
	private String operationName;//模块
	private String ip;//ip地址
	private Integer port;//端口
	private String url;//url路径
	private String method;//提交方式
	private String cls;//类
	private String classMethod;//调用方法
	private String para;//传递参数
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone="GMT+8") //参数注解，Date对象返回时，格式化日期 yyyy-MM-dd  HH:mm:ss a
	private String date;//操作时间
	private Long time;//耗时
	private Integer success;//是否成功  1成功。0失败
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	
	public Integer getSuccess() {
		return success;
	}
	public void setSuccess(Integer success) {
		this.success = success;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "LogPojo [id=" + id + ", userId=" + userId + ", nickName=" + nickName + ", operationName="
				+ operationName + ", ip=" + ip + ", port=" + port + ", url=" + url + ", method=" + method + ", cls="
				+ cls + ", classMethod=" + classMethod + ", para=" + para + ", date=" + date + ", time=" + time
				+ ", success=" + success + "]";
	}
	
	
	
	
}
