package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.BlogType;

public interface BlogTypeService {

	/**
	 * ��ȡ���������Ϣ
	 * @return
	 */
	public List<BlogType> getBlogTypeData();

	/**
	 * ��ҳ��ѯ�������
	 * @param map
	 * @return
	 */
	public List<BlogType> listBlogType(Map<String, Object> map);

	/**
	 * ��ȡ�����������
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);

	/**
	 * ��Ӳ������
	 * @param blogType
	 * @return
	 */
	public int addBlogType(BlogType blogType);

	/**
	 * �޸Ĳ������
	 * @param blogType
	 * @return
	 */
	public int updateBlogType(BlogType blogType);

	/**
	 * ɾ���������
	 * @param id
	 */
	public Integer deleteBlogType(Integer id);

}
