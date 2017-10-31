package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BlogTypeDao;
import com.lyj.entity.BlogType;
import com.lyj.service.BlogTypeService;

/**
 * 博客类别service实现类
 * @author asus
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;
	
	/**
	 * 前台分页查询博客类别
	 */
	public List<BlogType> getBlogTypeData() {
		
		return blogTypeDao.getBlogTypeData();
	}

	/**
	 * 后台分页查询博客类别
	 */
	public List<BlogType> listBlogType(Map<String, Object> map) {
		
		return blogTypeDao.listBlogType(map);
	}

	/**
	 * 获取博客类别总数
	 */
	public Long getTotal(Map<String, Object> map) {
	
		return blogTypeDao.getTotal(map);
	}

	/**
	 * 添加博客类别
	 * @param blogType
	 * @return
	 */
	public int addBlogType(BlogType blogType) {
		
		return blogTypeDao.addBlogType(blogType);
	}

	/**
	 * 修改博客类别
	 * @param blogType
	 * @return
	 */
	public int updateBlogType(BlogType blogType) {
		
		return blogTypeDao.updateBlogType(blogType);
	}

	/**
	 * 删除博客类别
	 */
	public Integer deleteBlogType(Integer id) {
		
		return blogTypeDao.deleteBlogType(id);
	}

}
