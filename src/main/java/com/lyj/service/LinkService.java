package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Link;

public interface LinkService {

	/*
	 * 获取友情链接信息
	 */
	public List<Link> getLinkData();

	/**
	 * 查询友情链接 
	 * @param map
	 * @return
	 */
	public List<Link> listLinkData(Map<String, Object> map);

	/**
	 * 获取友情链接总数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * 添加友情链接
	 * @param link
	 * @return
	 */
	public int addLink(Link link);

	/**
	 * 修改友情链接
	 * @param link
	 * @return
	 */
	public int update(Link link);

	/**
	 * 友情链接删除
	 * @param id
	 */
	public Integer deleteLink(int id);

}
