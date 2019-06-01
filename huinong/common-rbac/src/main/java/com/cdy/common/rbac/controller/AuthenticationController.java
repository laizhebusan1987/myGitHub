package com.cdy.common.rbac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/authentication")
public class AuthenticationController {

	@RequestMapping("/login")
	@ResponseBody
	public void login(String username,String password) {
		
	}
}
