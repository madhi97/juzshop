package com.ecommerce.juzshop.model;

public class UserModel {

	private int user_id;
	private String user;
	private String pwd;
	private String token;
	private String user_role;

	public UserModel( String user, String pwd,  String user_role) {
		
		this.user = user;
		this.pwd = pwd;
		this.user_role = user_role;
	}
	public UserModel() {
	}
	





	public int getUser_id() {
		return this.user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser() {
		return user;
	}

	public String getUser_role() {
		return this.user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	@Override
	public String toString() {
		return "{" +
			" user_id='" + getUser_id() + "'" +
			", user='" + getUser() + "'" +
			", pwd='" + getPwd() + "'" +
			", token='" + getToken() + "'" +
			", user_role='" + getUser_role() + "'" +
			"}";
	}

    
}