package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.LinkDao;
import com.lyj.entity.Link;
import com.lyj.service.LinkService;

/**
 * ��������serviceʵ����
 * @author asus
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkDao linkDao;
	
	/**
	 * ��ȡ����������Ϣ
	 */
	public List<Link> getLinkData() {
		
		return linkDao.getLinkData();
	}

	/**
	 * ��ѯ��������
	 */
	public List<Link> listLinkData(Map<String, Object> map) {
		
		return linkDao.listLinkData(map);
	}

	/**
	 * ��ȡ������������
	 */
	public Long getTotal(Map<String, Object> map) {
		
		return linkDao.getTotal(map);
	}

	/**
	 * �����������
	 */
	public int addLink(Link link) {
		
		return linkDao.addLink(link);
	}

	/**
	 * �޸���������
	 */
	public int update(Link link) {

		return linkDao.update(link);
	}

	/**
	 * ����������ɾ��
	 */
	public Integer deleteLink(int id) {
	
		return linkDao.deleteLink(id);
	}

}
