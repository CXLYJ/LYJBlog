package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.BlogType;

public interface BlogTypeDao {

	/**
	 * 获取博客信息
	 * @return
	 */
	public List<BlogType> getBlogTypeData();

	// 根据id查找博客类型信息
	public BlogType findById(Integer id);

	//后台分页查询博客类别
	public List<BlogType> listBlogType(Map<String, Object> map);

	//获取博客类别总数
	public Long getTotal(Map<String, Object> map);

	//添加博客类别
	public int addBlogType(BlogType blogType);

	//修改博客类别
	public int updateBlogType(BlogType blogType);

	//删除博客类别
	public Integer deleteBlogType(Integer id);
}
