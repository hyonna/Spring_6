package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

public class DBConnector {

	private String user;
	private String password;
	private String url;
	private String driver;

	public Connection getConnect() throws Exception{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		return con; 
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	
}
