package com.zy.zy_filesystem.no;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

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



class demo{
	public static void main(String[] args){
			Scanner sc=new Scanner(System.in);
			System.out.print("输入矩形宽度:");
			//宽度
			int i=sc.nextInt();
			int j=9;
			int zj=0;
			boolean flag=false;
			if(i%2==0){//偶数
				i++;
				zj=i/2;
				flag=true;
			}else{//奇数
				zj=i/2;
			}
		Object [][] arr=new Object[i][i];//存储数据的
//		System.out.println("中心点为:（"+zj+","+zj+")");
		int zjz=j-zj;
//		System.out.println("中心点值:"+zjz);
		arr[zj][zj]=zjz;
		//纵
		for (int a = 0; a < i; a++) {
			//横
			for (int b = 0; b < i; b++) {
				arr[a][b]=Math.abs(zj-a) - Math.abs(zj-b) >0 ? zjz+Math.abs(zj-a):zjz+Math.abs(zj-b);
			}
		}

		if(flag){
			//纵
			for (int a = 0; a < i; a++) {
				//横
				for (int b = 0; b < i; b++) {
					if(a==zj || b==zj){
						arr[a][b]=null;
					}
				}
			}
		}

		//偶数特殊处理
		for(Object [] temp:arr)
		{
			for(Object a:temp)
			{
				if(a!=null){
					System.out.print(a);
				}
			}
//			if(temp)
			System.out.println();
		}
	}
}

enum meiju{
	a,b,c,d
}

class User{
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

