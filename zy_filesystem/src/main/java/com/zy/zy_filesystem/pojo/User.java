package com.zy.zy_filesystem.pojo;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class User {
	//@JsonIgnore  //参数注解，在返回对象时，该属性不会被返回
	private Integer id;
	private String userId;
	private String nickName;
	private Integer age;
	@JsonFormat(pattern="yyyy-MM-dd",locale="zh",timezone="GMT+8") //参数注解，Date对象返回时，格式化日期 yyyy-MM-dd  HH:mm:ss a
	private Date date;
	private String password;
	private String sex;
	private Integer tel;
	private String email;
	private String salt;
	
	private Role role;//该用户拥有的角色
	private String roleName;
	
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
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
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", nickName=" + nickName + ", age=" + age + ", date=" + date
				+ ", password=" + password + ", sex=" + sex + ", tel=" + tel + ", email=" + email + ", role=" + role
				+ "]";
	}
	
	
	
	
	
}
