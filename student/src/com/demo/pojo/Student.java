package com.demo.pojo;

public class Student {
	
	
	private int id;
	
	private String name;
	
	private int age;
	
	private int sex;

	

	public int getId() {
	
		return id;
	}

	public void setId(int id) {
	
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

	public void setAge(int i) {
	
		this.age = i;
	}

	public int getSex() {
	
		return sex;
	}

	public void setSex(int sex) {
	
		this.sex = sex;
	}
	
	public Student() {
		super();
	}

	public Student(String name, int age, int sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Student(int id, String name, int age, int sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
 
}

	