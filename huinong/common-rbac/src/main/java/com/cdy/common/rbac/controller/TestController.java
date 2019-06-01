package com.cdy.common.rbac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdy.common.rbac.entiy.Permission;
import com.cdy.common.rbac.mapper.PermissionMapper;

@Controller
public class TestController {
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@RequestMapping("/test")
	@ResponseBody
	public List<Permission> test() {
		return permissionMapper.selectAll();
	}
}
