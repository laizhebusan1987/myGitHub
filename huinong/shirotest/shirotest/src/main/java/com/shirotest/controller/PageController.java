package com.shirotest.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shirotest.pojo.TUser;
import com.shirotest.service.UserService;
import com.shirotest.utils.MD5Code;

@Controller
public class PageController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/loginto")	
	public String  login(TUser user) {
		if (user==null) {
			return "login";
		}
		Subject subject=SecurityUtils.getSubject();
		MD5Code md5=new MD5Code();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			subject.login(token); // 登录认证
			String username=(String) SecurityUtils.getSubject().getPrincipal();
			token.setRememberMe(true);
			TUser currentUser=userService.findById(username);
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", currentUser);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "index";
		}
	@RequestMapping("/unauthorized")	
	public String  unauthorized() {
		return "UNsuccess";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";

	}
	@RequestMapping("/logOut")
	public String logOut() {
		Subject subject = SecurityUtils.getSubject();  
	    if (subject.isAuthenticated()) {  
	        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
	        return "login";
	    }
	    return "login";
	}
//	@RequiresPermissions(value = { "admin:create"})
	@RequestMapping("/toPage")
	public String toPage() {
		return "page";

	}
	@RequiresPermissions(value = { "user:create"})
	@RequestMapping("/tocreate")
	public String create() {
		return "create";
		
	}
	@RequiresPermissions(value = { "user:delete"})
	@RequestMapping("/todelete")
	public String delete() {
		return "delete";
		
	}
}
