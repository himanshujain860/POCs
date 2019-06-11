package com.app.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDetail {
	
	private Integer id;
	private String userName;
	private String password;
	
	public UserDetail(){
		
	}
	
	public UserDetail(Integer id, String userName, String password){
		this.id= id;
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "UserName : "+userName+" Password : "+password;
	}
}
