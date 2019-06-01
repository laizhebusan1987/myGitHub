package com.shirotest.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shirotest.mapper.TPermissionMapper;
import com.shirotest.mapper.TRoleMapper;
import com.shirotest.mapper.TUserMapper;
import com.shirotest.pojo.TPermission;
import com.shirotest.pojo.TPermissionExample;
import com.shirotest.pojo.TPermissionExample.Criteria;
import com.shirotest.pojo.TRole;
import com.shirotest.pojo.TUser;
import com.shirotest.pojo.TUserExample;
import com.shirotest.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper userMapper;
	@Autowired
	private TRoleMapper roleMapper;
	@Autowired
	private TPermissionMapper permissionMapper;

	@Override
	public int save(TUser entity) {
		return userMapper.insertSelective(entity);
	}

	@Override
	public int update(TUser entity) {
		return userMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public TUser findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TUser> getAll() {
		TUserExample example = new TUserExample();

		return userMapper.selectByExample(example);
	}

	

	@Override
	public Set<String> getRoleSet(String username) {
		TUser tUser = userMapper.selectByPrimaryKey(username);
		Set<String> roleSet=new HashSet<String>();
		if(tUser.getRoleId()!=null)
		{
			TRole tRole = roleMapper.selectByPrimaryKey(tUser.getRoleId());
			roleSet.add(tRole.getRolename());
			
		}
		return roleSet;
	}

	@Override
	public Set<String> getPermissionSet(String username) {
		Set<String> permissionSet=new HashSet<String>();
		TUser user = userMapper.selectByPrimaryKey(username);
		TRole role = roleMapper.selectByPrimaryKey(user.getRoleId());
		if(role!=null)
		{
			TPermissionExample example=new TPermissionExample();
			Criteria criteria = example.createCriteria();
			criteria.andRoleIdEqualTo(role.getId());
			List<TPermission> list = permissionMapper.selectByExample(example);
			for (TPermission tPermission : list) {
				permissionSet.add(tPermission.getPermissionname());
			}
		}
		return permissionSet;
	}

	@Override
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}


}
