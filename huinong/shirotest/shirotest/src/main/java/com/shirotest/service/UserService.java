package com.shirotest.service;

import java.util.Set;

import com.shirotest.pojo.TUser;


public interface UserService extends BaseService<String,TUser>{
	public Set<String> getRoleSet(String username);
	public Set<String> getPermissionSet(String username);
}
