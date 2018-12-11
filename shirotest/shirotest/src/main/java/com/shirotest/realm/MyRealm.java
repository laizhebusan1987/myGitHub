package com.shirotest.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.shirotest.pojo.TUser;
import com.shirotest.service.UserService;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Set<String> roleSet = userService.getRoleSet(username);
		Set<String> permissionSet = userService.getPermissionSet(username);
		info.setRoles(roleSet);
		info.setStringPermissions(permissionSet);
		return info;
	}
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = token.getPrincipal().toString();
		TUser user = userService.findById(username);
		if (user != null) {
			// 将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
					getName());
			return authenticationInfo;
		} else {
			return null;
		}
	}

}
