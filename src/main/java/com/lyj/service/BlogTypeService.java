package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.BlogType;

public interface BlogTypeService {

	/**
	 * 获取博客类别信息
	 * @return
	 */
	public List<BlogType> getBlogTypeData();

	/**
	 * 分页查询博客类别
	 * @param map
	 * @return
	 */
	public List<BlogType> listBlogType(Map<String, Object> map);

	/**
	 * 获取博客类别总数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加博客类别
	 * @param blogType
	 * @return
	 */
	public int addBlogType(BlogType blogType);

	/**
	 * 修改博客类别
	 * @param blogType
	 * @return
	 */
	public int updateBlogType(BlogType blogType);

	/**
	 * 删除博客类别
	 * @param id
	 */
	public Integer deleteBlogType(Integer id);

}
