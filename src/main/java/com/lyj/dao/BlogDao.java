package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Blog;

public interface BlogDao {

	//获取博客信息，按照时间分类的
	public List<Blog> getBlogData();

	// 获取博客信息
	public List<Blog> listBlog(Map<String, Object> map);

	//获取博客的总数量
	public long getTotal(Map<String, Object> map);

	//根据id获取博客
	public Blog findById(Integer id);

	//更新博客
	public Integer update(Blog blog);

	 //获取上一篇博客
	public Blog getPrevBlog(Integer id);

	//获取下一篇博客
	public Blog getNextBlog(Integer id);

	//根据博客类型的id查询该类型下的博客数量
	public int getBlogByTypeId(Integer id);

	//添加博客
	public int addBlog(Blog blog);

	//根据博客Id删除博客
	public Integer deleteByBlogId(int id);

}
