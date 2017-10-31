package com.lyj.dao;

import com.lyj.entity.Blogger;

public interface BloggerDao {

	//获取博主信息
	public Blogger getBloggerData();

	// 根据用户名从数据库中查询出博主信息
	public Blogger getByUsername(String username);

	//修改博主密码
	public int updateBlogger(Blogger blogger);

}
