package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Link;

public interface LinkService {

	/*
	 * ��ȡ����������Ϣ
	 */
	public List<Link> getLinkData();

	/**
	 * ��ѯ�������� 
	 * @param map
	 * @return
	 */
	public List<Link> listLinkData(Map<String, Object> map);

	/**
	 * ��ȡ������������
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * �����������
	 * @param link
	 * @return
	 */
	public int addLink(Link link);

	/**
	 * �޸���������
	 * @param link
	 * @return
	 */
	public int update(Link link);

	/**
	 * ��������ɾ��
	 * @param id
	 */
	public Integer deleteLink(int id);

}
