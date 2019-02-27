package com.commonEntity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.annotation.IsEmptyAnnotation;
import com.annotation.MaxSize;
import com.annotation.MinSize;
import com.annotation.Mobile;

public class Student {
	private String id;
	
	//@IsEmptyAnnotation(message = "学生名字不能为空！")
	@NotNull(message = "名字不能为空")
	@Size(min = 2, max = 6, message = "名字应该在2-6个字符")
	private String name;
	
	//@MinSize(min = 12)//校样的是字符长度，数字大小要自定义
	//@MaxSize(max = 29)
	private int age;
	
	//@Mobile(message = "学生电话号码格式不对")
	private String mobile;
	
	private String birth;
	
	@Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
	private String mail;
	
	private String address;
	
	private Date createTime;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	//获取姓氏（取第一个）
	public String getFirstName() {
		return name.substring(0, 1);
	}

	public Student(String id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

}
