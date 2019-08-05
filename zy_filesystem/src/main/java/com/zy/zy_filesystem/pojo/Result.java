package com.zy.zy_filesystem.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Result<T> {
	private Integer status;//接口状态   0成功   200失败
	private Integer total;//数据总数
	private List<T> data;//结果集
	private boolean success;//是否成功
	private Date date;//操作时间
	private String message;//提示文本
	private Map<String,List<String>> selectCondition;//下拉框查询条件
	
	

	public Map<String, List<String>> getSelectCondition() {
		return selectCondition;
	}
	public void setSelectCondition(Map<String, List<String>> selectCondition) {
		this.selectCondition = selectCondition;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", total=" + total + ", data=" + data + ", success=" + success + ", date="
				+ date + ", message=" + message + ", selectCondition=" + selectCondition + ", getSelectCondition()="
				+ getSelectCondition() + ", getMessage()=" + getMessage() + ", getStatus()=" + getStatus()
				+ ", getTotal()=" + getTotal() + ", getData()=" + getData() + ", isSuccess()=" + isSuccess()
				+ ", getDate()=" + getDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
