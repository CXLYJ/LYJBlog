package com.lyj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BloggerDao;
import com.lyj.entity.Blogger;
import com.lyj.service.BloggerService;

/**
 * ����serviceʵ����
 * @author asus
 *
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerDao bloggerDao;
	
	//��ȡ������Ϣ
	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	// �����û��������ݿ��в�ѯ��������Ϣ
	public Blogger getByUsername(String username) {
		
		return bloggerDao.getByUsername(username);
	}

	//�޸Ĳ�������
	public int updateBlogger(Blogger blogger) {
		
		return bloggerDao.updateBlogger(blogger);
	}

}
