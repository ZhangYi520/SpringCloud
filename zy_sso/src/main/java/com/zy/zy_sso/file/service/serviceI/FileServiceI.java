package com.zy.zy_sso.file.service.serviceI;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.zy.zy_sso.base.result.PageRequest;
import com.zy.zy_sso.base.result.Result;
import com.zy.zy_sso.file.entity.FileEntity;


public interface FileServiceI {
	
	/**
	 * @Description:文件上传
	 * @author:ZY
	 * @date:2019年01月21日
	 */	
	public Integer uploadFile(HttpServletRequest request, MultipartFile multipartFile);
	
	
	/**
	 * @Description:根据ID修改文件上传
	 * @author:ZY
	 * @date:2019年01月21日
	 */	
	public Integer modifyFile(HttpServletRequest request, MultipartFile multipartFile,Integer oldFileId);
	

	/**
	 * @Description:根据ID删除文件
	 * @author:ZY
	 * @date:2019年01月21日
	 */	
	public void deleteFile(Integer fileId);
	
	/**
	 * @Description:根据ID查询文件
	 * @author:ZY
	 * @date:2019年01月21日
	 */	
	public FileEntity getFileById(Integer fileId);
	
	/**
	 * @Description:查询上传的所有文件
	 * @author:ZY
	 * @date:2019年01月21日
	 */	
	public Result<List<FileEntity>> getFile(PageRequest vo);
}
