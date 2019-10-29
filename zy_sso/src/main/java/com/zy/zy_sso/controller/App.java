package com.zy.zy_sso.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;

class Function{
	private String id;
	private String name;
	private String icon;
	private Boolean available;
	private String orderLevel;
	private String url;
	private String parentId;
	private Integer level;
	private boolean leaf;
	private Set<Function> children = new HashSet<Function>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getOrderLevel() {
		return orderLevel;
	}
	public void setOrderLevel(String orderLevel) {
		this.orderLevel = orderLevel;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getLeaf() {
		return leaf;
	}
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	public Set<Function> getChildren() {
		return children;
	}
	public void setChildren(Set<Function> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", icon=" + icon + ", available=" + available + ", orderLevel="
				+ orderLevel + ", url=" + url + ", parentId=" + parentId + ", level=" + level + ", leaf=" + leaf
				+ ", children=" + children + "]";
	}
}

public class App {
	public static void main(String[] args) {
		String str = "[{" +
				"	id: 6Ww63wiyn6aGnoPrVBFAtr," +
				"	name: 学生管理," +
				"	icon: site-icon-category-MSG," +
				"	available: true," +
				"	orderLevel: 05" +
				"}, {" +
				"	id: 9SuSC2ZMX1YBS5bFgSJTuh," +
				"	name: 考勤管理," +
				"	icon: ," +
				"	url: ," +
				"	available: true," +
				"	orderLevel: 0504," +
				"	parentId: 6Ww63wiyn6aGnoPrVBFAtr" +
				"}, {" +
				"	id: TgMu3K4bo6gXfBTvHHvCmV," +
				"	name: 即时考勤查看," +
				"	icon: ," +
				"	url: /ea/attendance/attendance/todayAttendance," +
				"	available: true," +
				"	orderLevel: 050403," +
				"	parentId: 9SuSC2ZMX1YBS5bFgSJTuh" +
				"}, {" +
				"	id: 9kQkVBA3im1o4L2qRuiu4U," +
				"	name: 我的考勤," +
				"	icon: ," +
				"	url: /ea/attendance/attendance/myAttendanceWithClass," +
				"	available: true," +
				"	orderLevel: 050404," +
				"	parentId: 9SuSC2ZMX1YBS5bFgSJTuh" +
				"}, {" +
				"	id: 212633835681361920," +
				"	name: 我的班级," +
				"	available: true," +
				"	orderLevel: 0511," +
				"	parentId: 6Ww63wiyn6aGnoPrVBFAtr" +
				"}, {" +
				"	id: 212634138052931584," +
				"	name: 班级信息," +
				"	url: /base/user/student/class," +
				"	available: true," +
				"	orderLevel: 051101," +
				"	parentId: 212633835681361920" +
				"}, {" +
				"	id: 212634436817399808," +
				"	name: 审核信息," +
				"	url: /base/user/student/apply," +
				"	available: true," +
				"	orderLevel: 051102," +
				"	parentId: 212633835681361920" +
				"}]";
		System.out.println(str);
		//将字符串转换成JSON数组对象
		JSONArray jsonArr = JSONArray.parseArray(str);
		//将JSON数组对象根据反射转换成指定JAVA类型的集合
		List<Function> dataList = jsonArr.toJavaList(Function.class);
		List<Function> list = new ArrayList<Function>();
		for(Function item:dataList) {
			//顶级菜单不需要判断父菜单
			if(item.getParentId()!=null) {
				for(Function i:dataList) {
					if(i.getId()!=null && i.getId().equals(item.getParentId())) {
						//确认父菜单与之关联,不需要加入新list,属性关联就行
						i.getChildren().add(item);
						item.setLevel(i.getLevel()+1);
						break;
					}
				}
			}else {
				//顶级菜单
				list.add(item);
				item.setLevel(0);
			}
		}
		String strs = JSONArray.toJSONString(list);

		System.out.println(strs);
	}
}
