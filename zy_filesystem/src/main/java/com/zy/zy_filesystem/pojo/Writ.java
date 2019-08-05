package com.zy.zy_filesystem.pojo;
/**  
*   
* 项目名称：bookSystem  
* 类名称：Writ  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年3月29日 下午2:38:27  
* 修改人：zhangyi  
* 修改时间：2019年3月29日 下午2:38:27  
* 修改备注：  
* @version   
*   
*/

public class Writ {
	
	private Integer id;//主键
	private String title;//标题
	private String content;//内容
	private String userId;//上传用户
	private String ct;//创建时间
	private String mt;//修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	public String getMt() {
		return mt;
	}
	public void setMt(String mt) {
		this.mt = mt;
	}
	@Override
	public String toString() {
		return "Writ [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId + ", ct=" + ct
				+ ", mt=" + mt + "]";
	}
	
	
}
