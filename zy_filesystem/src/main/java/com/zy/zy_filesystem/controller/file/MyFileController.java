package com.zy.zy_filesystem.controller.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zy.zy_filesystem.aop.Log;
import com.zy.zy_filesystem.pojo.MyFile;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.impl.MyFileServiceImpl;

/**
 * 文件管理--控制层
 * @author zhangyi
 *
 */
@Controller
public class MyFileController {
	
	
	@GetMapping("/fileUpList")
	public String fileUp() {
		return "fileUp/fileUp";
	}

	@Autowired
	private MyFileServiceImpl myFileServiceImpl;
	Result<MyFile> result = null;
	/**
	 * 上传文件
	 * @param request
	 * @param file 前台文件对象
	 * @param session
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	@Log(operationName="上传文件")
	public Result<MyFile> upload(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		boolean success = myFileServiceImpl.upload(file, user);
		result = new Result<MyFile>();
		if (success) {
			result.setSuccess(success);
			result.setDate(new Date());
			result.setMessage("文件上传成功");
		} else {
			result.setSuccess(!success);
			result.setDate(new Date());
			result.setMessage("文件上传失败");
		}
		return result;
	}

	/**
	 * 下载文件
	 * @param path 文件路径
	 * @param name 文件名
	 * @param type 文件类型
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@PostMapping("/download")
	@Log(operationName="下载文件")
	public void download(String path,String name,String type,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String fileName=name+"."+type;//拼接文件全名
		response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            // 得到要下载的文件
            File file = new File(path);
            //如果文件不存在，则显示下载失败

                // 设置相应头，控制浏览器下载该文件，这里就是会出现当你点击下载后，出现的下载地址框
                response.setHeader("content-disposition",
                        "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
                // 读取要下载的文件，保存到文件输入流
                FileInputStream in = new FileInputStream(file);
                // 创建输出流
                OutputStream out = response.getOutputStream();
                // 创建缓冲区
                byte buffer[] = new byte[1024];
                int len = 0;
                // 循环将输入流中的内容读取到缓冲区中
                while ((len = in.read(buffer)) > 0) {
                    // 输出缓冲区内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }
                // 关闭文件流
                in.close();
                // 关闭输出流
                out.close();
        } catch (Exception e) {
            // TODO: handle exception

        }
		/*if (StringUtils.isBlank(path) && StringUtils.isBlank(fileName)){
			return;
			}
			//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
			response.setContentType("multipart/form-data");
			//2.设置文件头
			String userAgent = request.getHeader("User-Agent");
			if (StringUtils.isBlank(userAgent)) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
			 } else {
			if (userAgent.indexOf("MSIE") != -1) {
			// IE使用URLEncoder
			fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
			// FireFox使用ISO-8859-1
			 fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			}
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setDateHeader("Expires", (System.currentTimeMillis() + 1000));
			File file = new File(path);
			OutputStream out = null;
			InputStream inputStream = null;
			try {
			 inputStream = new FileInputStream(file);
			 out = response.getOutputStream();
			 byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = inputStream.read(buffer)) != -1) {
				 out.write(buffer, 0, count);
				}
				out.close();
				out.flush();
				return ;
			} catch (IOException e) {
				
			 } finally {
				response.reset();
				IOUtils.closeQuietly(inputStream);
			}*/

	}


//	@GetMapping("/queryCondition")
//	@ResponseBody
//	@Log(operationName="条件查询文件")
//	public Result<MyFile> queryMyFile(HttpServletRequest request, HttpSession session) {
//		User user = (User) session.getAttribute("loginUser");
//		return myFileServiceImpl.queryAll(user.getUserId());
//	}

	@PostMapping("/deleteFile")
	@ResponseBody
	@Log(operationName="删除文件")
	public Result<MyFile> deleteFile(@RequestBody MyFile myFile) {

		return myFileServiceImpl.deletFile(myFile);
	}
	 
	@GetMapping("/queryAll")
	@ResponseBody
	@Log(operationName="查询所有文件")
	public Result<MyFile> queryAll(MyFile myFile) {
		System.out.println(myFile);
		return myFileServiceImpl.queryAll(myFile);
	}
	
	//给条件查询select下拉框渲染数据
	@PostMapping("/querySelectValue")
	@ResponseBody
//	@Log(operationName="文件")
	public Result<MyFile> querySelectValue() {
		//System.out.println(myFileServiceImpl.querySelectValue());
		return myFileServiceImpl.querySelectValue();
	}
	
	//条件查询
	/*@PostMapping("/conditionQuery")
	@ResponseBody
	@Log(operationName="条件查询文件")
	public Result<MyFile> conditionQuery(@RequestBody MyFile myFile) {
		//User user = (User) session.getAttribute("loginUser");
		System.out.println(myFile);
		return myFileServiceImpl.conditinQuery(myFile);
	}*/
}
