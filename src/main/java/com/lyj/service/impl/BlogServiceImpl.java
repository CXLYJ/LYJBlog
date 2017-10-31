package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BlogDao;
import com.lyj.entity.Blog;
import com.lyj.service.BlogService;

/**
 * ����serviceʵ����
 * @author asus
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{

	@Resource
	private BlogDao blogDao;
	
	/**
	 * ��ȡ������Ϣ������ʱ������
	 */
	public List<Blog> getBlogData() {
		
		return blogDao.getBlogData();
	}

	/**
	 * ��ȡ������Ϣ
	 */
	public List<Blog> listBlog(Map<String, Object> map) {
		
		return blogDao.listBlog(map);
	}

	/**
	 * ��ȡ���͵�������
	 */
	public long getTotal(Map<String, Object> map) {

		return blogDao.getTotal(map);
	}

	/**
	 * ����id��ȡ����
	 */
	public Blog findById(Integer id) {
		
		return blogDao.findById(id);
	}

	/**
	 * ���²���
	 */
	public Integer update(Blog blog) {
		
		return blogDao.update(blog);
	}

	/**
	 * ��ȡ��һƪ����
	 */
	public Blog getPrevBlog(Integer id) {
		
		return blogDao.getPrevBlog(id);
	}

	/**
	 * ��ȡ��һƪ����
	 */
	public Blog getNextBlog(Integer id) {
		
		return blogDao.getNextBlog(id);
	}

	/**
	 * ���ݲ������͵�id��ѯ�������µĲ�������
	 */
	public int getBlogByTypeId(Integer id) {
		
		return blogDao.getBlogByTypeId(id);
	}

	/**
	 * ��Ӳ���
	 */
	public int addBlog(Blog blog) {
	
		return blogDao.addBlog(blog);
	}

	/**
	 * ���ݲ���Idɾ������
	 */
	public Integer deleteByBlogId(int id) {
		
		return blogDao.deleteByBlogId(id);
	}

}
