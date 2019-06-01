package com.cdy.common.rbac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MysqlProperties {
	
	@Value("com.mysql.jdbc.Driver")
	private String driverClass;
	
//	@Value("jdbc:mysql://localhost:3306/rbac?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&useSSL=true")
	@Value("jdbc:mysql://localhost:3306/rbac")
	private String url;
	
	@Value("root")
	private String userName;
	
	@Value("123456")
	private String password;

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
}
