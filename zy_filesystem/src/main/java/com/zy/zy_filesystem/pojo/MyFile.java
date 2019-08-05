package com.zy.zy_filesystem.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MyFile {
	
	private Integer id;//主键
	private String userId;	//上传用户名
	private String fileName;//文件名
	private String path;//文件路径
	private String size;//大小
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",locale="zh",timezone="GMT+8") //参数注解，Date对象返回时，格式化日期
	private Date date;//上传时间
	private String fileType;//文件类型
	
	
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
