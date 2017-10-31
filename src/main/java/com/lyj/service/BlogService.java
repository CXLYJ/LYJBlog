package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Blog;

public interface BlogService {

	/**
	 * 获取博客信息，按照时间分类的
	 * @return
	 */
	public List<Blog> getBlogData();

	/**
	 *  获取博客信息
	 * @param map
	 * @return
	 */
	public List<Blog> listBlog(Map<String, Object> map);

	/**
	 * 获取博客的总数量
	 * @param map
	 * @return
	 */
	public long getTotal(Map<String, Object> map);

	/**
	 * 根据id获取博客
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);

	/**
	 * 更新博客
	 * @param blog
	 */
	public Integer update(Blog blog);

	/**
	 * // 获取上一篇博客
	 * @param id
	 * @return
	 */
	public Blog getPrevBlog(Integer id);

	/**
	 * // 获取下 一篇博客
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);

	/**
	 * 根据博客类型的id查询该类型下的博客数量
	 * @param id
	 * @return
	 */
	public int getBlogByTypeId(Integer id);

	/**
	 * 添加博客
	 * @param blog
	 * @return
	 */
	public int addBlog(Blog blog);

	/**
	 * 根据博客ID删除博客
	 * @param id
	 * @return
	 */
	public Integer deleteByBlogId(int id);
}
