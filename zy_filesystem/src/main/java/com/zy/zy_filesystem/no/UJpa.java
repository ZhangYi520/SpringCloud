package com.zy.zy_filesystem.no;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="u")
public class UJpa {
	@Id//	这是一个主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
	private Integer id;
	@Column(name="name",length=50)//对应数据表
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
