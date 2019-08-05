package com.zy.zy_filesystem.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.zy.zy_filesystem.pojo.MyFile;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;

public interface MyFileService {
	//文件上传
	public boolean upload(MultipartFile file,User user);
	//查询所有
	public Result<MyFile> queryAll(MyFile myFile);
	//删除单个文件
	public Result<MyFile> deletFile(MyFile myFile);
	//获取下拉框的词汇
	public Result<MyFile> querySelectValue();
	//条件查询
	//public Result<MyFile> conditinQuery(MyFile myFile);
}
