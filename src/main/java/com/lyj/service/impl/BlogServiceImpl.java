package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BlogDao;
import com.lyj.entity.Blog;
import com.lyj.service.BlogService;

/**
 * 博客service实现类
 * @author asus
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{

	@Resource
	private BlogDao blogDao;
	
	/**
	 * 获取博客信息，按照时间分类的
	 */
	public List<Blog> getBlogData() {
		
		return blogDao.getBlogData();
	}

	/**
	 * 获取博客信息
	 */
	public List<Blog> listBlog(Map<String, Object> map) {
		
		return blogDao.listBlog(map);
	}

	/**
	 * 获取博客的总数量
	 */
	public long getTotal(Map<String, Object> map) {

		return blogDao.getTotal(map);
	}

	/**
	 * 根据id获取博客
	 */
	public Blog findById(Integer id) {
		
		return blogDao.findById(id);
	}

	/**
	 * 更新博客
	 */
	public Integer update(Blog blog) {
		
		return blogDao.update(blog);
	}

	/**
	 * 获取上一篇博客
	 */
	public Blog getPrevBlog(Integer id) {
		
		return blogDao.getPrevBlog(id);
	}

	/**
	 * 获取下一篇博客
	 */
	public Blog getNextBlog(Integer id) {
		
		return blogDao.getNextBlog(id);
	}

	/**
	 * 根据博客类型的id查询该类型下的博客数量
	 */
	public int getBlogByTypeId(Integer id) {
		
		return blogDao.getBlogByTypeId(id);
	}

	/**
	 * 添加博客
	 */
	public int addBlog(Blog blog) {
	
		return blogDao.addBlog(blog);
	}

	/**
	 * 根据博客Id删除博客
	 */
	public Integer deleteByBlogId(int id) {
		
		return blogDao.deleteByBlogId(id);
	}

}
