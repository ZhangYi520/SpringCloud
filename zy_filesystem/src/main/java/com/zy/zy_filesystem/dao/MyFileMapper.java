package com.zy.zy_filesystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zy.zy_filesystem.pojo.MyFile;
//@Mapper
public interface MyFileMapper {
	//获取文件数量
	public Integer queryCount(MyFile m);
	public List<MyFile> queryMyFile(String userId);
	
	public MyFile queryById(MyFile m);
	
	public int add(MyFile m);
	
//	删除文件
	public int deleteFile(Integer id);
	//查询所有文件
	public List<MyFile> queryAll(MyFile myFile);
	
	//查询下拉框的值-账号
	public List<String> selectConditionUserName();
	//查询下拉框的值-文件类型
	public List<String> selectConditionType();
	//条件查询
	public List<MyFile> conditionQuery(MyFile myFile);
}
