package com.duan.pojo;

import java.sql.Date;

public class Teacher {

	private int id;
	private String name;
	private String gender;
	private Date birthDate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Teacher(int id, String name, String gender, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", gender=" + gender + ", birthDate=" + birthDate + "]";
	}
	
}
