package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.LinkDao;
import com.lyj.entity.Link;
import com.lyj.service.LinkService;

/**
 * 友情链接service实现类
 * @author asus
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;
	
	/**
	 * 获取友情链接信息
	 */
	public List<Link> getLinkData() {
		
		return linkDao.getLinkData();
	}

	/**
	 * 查询友情链接
	 */
	public List<Link> listLinkData(Map<String, Object> map) {
		
		return linkDao.listLinkData(map);
	}

	/**
	 * 获取友情链接总数
	 */
	public Long getTotal(Map<String, Object> map) {
		
		return linkDao.getTotal(map);
	}

	/**
	 * 添加友情链接
	 */
	public int addLink(Link link) {
		
		return linkDao.addLink(link);
	}

	/**
	 * 修改友情链接
	 */
	public int update(Link link) {

		return linkDao.update(link);
	}

	/**
	 * 友情里链接删除
	 */
	public Integer deleteLink(int id) {
	
		return linkDao.deleteLink(id);
	}

}
