package com.lyj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BloggerDao;
import com.lyj.entity.Blogger;
import com.lyj.service.BloggerService;

/**
 * 博主service实现类
 * @author asus
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerDao bloggerDao;
	
	//获取博主信息
	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	// 根据用户名从数据库中查询出博主信息
	public Blogger getByUsername(String username) {
		
		return bloggerDao.getByUsername(username);
	}

	//修改博主密码
	public int updateBlogger(Blogger blogger) {
		
		return bloggerDao.updateBlogger(blogger);
	}

}
