package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Link;

public interface LinkDao {

	/**
	 * 获取友情链接信息
	 * @return
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
	 * 友情链接添加
	 * @param link
	 * @return
	 */
	public int addLink(Link link);

	/**
	 * 友情链接修改
	 * @param link
	 * @return
	 */
	public int update(Link link);

	/**
	 * 友情链接删除
	 * @param id
	 * @return 
	 */
	public Integer deleteLink(int id);

}
