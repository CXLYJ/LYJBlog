package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Link;

public interface LinkDao {

	/**
	 * ��ȡ����������Ϣ
	 * @return
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
	 * ���������޸�
	 * @param link
	 * @return
	 */
	public int update(Link link);

	/**
	 * ��������ɾ��
	 * @param id
	 * @return 
	 */
	public Integer deleteLink(int id);

}
