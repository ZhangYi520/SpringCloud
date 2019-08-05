package com.zy.zy_filesystem.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zy.zy_filesystem.dao.MyFileMapper;
import com.zy.zy_filesystem.pojo.MyFile;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.MyFileService;
import com.zy.zy_filesystem.util.Change;
@Service
public class MyFileServiceImpl implements MyFileService{
	@Autowired
	MyFileMapper myFileMapper;
	MyFile myFile = null;
	Result<MyFile> result = null;
	@Value("${spring.http.url}")	
	private String url;
	@Override
	public boolean upload(MultipartFile file,User user) {
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(url + file.getOriginalFilename());//路径写死.后期得改
//			Path path = Paths.get("/home/file/" + file.getOriginalFilename());//路径写死.后期得改
			Files.write(path, bytes);
			String fileName=file.getOriginalFilename();//获取文件全名称
			myFile = new MyFile();
			myFile.setUserId(user.getUserId());
			myFile.setPath(path.toString());
			myFile.setDate(new Date());
			myFile.setSize(new Change().ChangeSize(file.getSize()));
			myFile.setFileName(fileName.substring(0,fileName.lastIndexOf(".")));//获取文件名
			myFile.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));//获取文件类型
			myFile.setDate(new Date());
			myFileMapper.add(myFile);//保存插入的文件信息
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Result<MyFile> queryAll(MyFile myFile) {
		result=new Result<MyFile>();
     	List<MyFile> myFileList=myFileMapper.queryAll(myFile);//获取数据
     	result.setMessage("查询成功");
     	result.setStatus(0);
     	result.setData(myFileList);
     	result.setTotal(myFileMapper.queryCount(myFile));
		return result;//查询所有文件信息;
	}
	
	@Override
	public Result<MyFile> deletFile(MyFile myFile) {
		result=new Result<MyFile>();
		int i=myFileMapper.deleteFile(myFile.getId());
		if(i>0) {
			result.setDate(new Date());
			result.setMessage("删除成功");
			result.setStatus(0);
			result.setTotal(i);//记录删除条数
			result.setSuccess(true);
		}else {
			result.setDate(new Date());
			result.setMessage("删除失败");
			result.setStatus(200);
			result.setTotal(0);//记录删除条数
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public Result<MyFile> querySelectValue() {
		result=new Result<MyFile>();
		List<String> userNameList=myFileMapper.selectConditionUserName();
		List<String> typeList=myFileMapper.selectConditionType();
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("userName", userNameList);
		map.put("type", typeList);
		result.setSelectCondition(map);
		result.setDate(new Date());
		result.setMessage("条件获取成功");
		result.setStatus(0);
		result.setTotal(0);//记录删除条数
		result.setSuccess(true);
		
		return result;
	}

//	@Override
//	public Result<MyFile> conditinQuery(MyFile myFile) {
//		result=new Result<MyFile>();
//		
//		List<MyFile> myFileList=myFileMapper.conditionQuery(myFile);
//		System.out.println(myFileList);
//		if(!myFileList.isEmpty()) {
//			result.setData(myFileList);
//			result.setDate(new Date());
//			result.setMessage("条件查询成功");
//			result.setStatus(0);
//			result.setTotal(myFileMapper.queryCount(myFile));
//			result.setSuccess(true);
//		}else {
//			result.setDate(new Date());
//			result.setMessage("条件查询失败,无数据");
//			result.setStatus(200);
//			result.setTotal(0);
//			result.setSuccess(false);
//		}
//		return result;
//	}
}
