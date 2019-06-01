package com.shirotest.service;

import java.util.List;


public interface BaseService <K, V> {
			
		public int save(V entity);// 保存
		
		public int delete(K id);// 删除用户
		
		public int update(V entity);// 更新用户
		
		public V findById(K id);// 根据主键查找用户
		
		public List<V> getAll();// 查看所有
		
	
}
