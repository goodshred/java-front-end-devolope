package com.yourcompany.struts.form;

import org.apache.struts.action.ActionForm;

public class UsersForm extends ActionForm {
	private Integer usersId;
	private String username;
	private String password;
	private String realName;
	private String usersIssueDate;
	private String mark;
	private String email;
	private String city;
	private String sex;
	private String job;
	private String usersRemarks1;
	private String usersRemarks2;

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUsersIssueDate() {
		return this.usersIssueDate;
	}

	public void setUsersIssueDate(String usersIssueDate) {
		this.usersIssueDate = usersIssueDate;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getUsersRemarks1() {
		return this.usersRemarks1;
	}

	public void setUsersRemarks1(String usersRemarks1) {
		this.usersRemarks1 = usersRemarks1;
	}

	public String getUsersRemarks2() {
		return this.usersRemarks2;
	}

	public void setUsersRemarks2(String usersRemarks2) {
		this.usersRemarks2 = usersRemarks2;
	}
}