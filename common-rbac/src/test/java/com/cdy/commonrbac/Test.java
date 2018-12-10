package com.cdy.commonrbac;

import java.util.Date;

import com.cdy.common.rbac.entiy.Role;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Test {

	@org.junit.Test
	public void test() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Role role = new Role();
		role.setCreateTime(new Date());
		role.setId(1);
		role.setStatus(true);
		role.setName("superman");
		role.setUpdateTime(new Date());
		String roleJson = gson.toJson(role);
		System.out.println(roleJson);
		Role role1 = gson.fromJson(roleJson, Role.class);
		System.out.println(role1);
	}
}
