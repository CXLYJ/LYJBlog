package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Blog;

public interface BlogService {

	/**
	 * ��ȡ������Ϣ������ʱ������
	 * @return
	 */
	public List<Blog> getBlogData();

	/**
	 *  ��ȡ������Ϣ
	 * @param map
	 * @return
	 */
	public List<Blog> listBlog(Map<String, Object> map);

	/**
	 * ��ȡ���͵�������
	 * @param map
	 * @return
	 */
	public long getTotal(Map<String, Object> map);

	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public Blog findById(Integer id);

	/**
	 * ���²���
	 * @param blog
	 */
	public Integer update(Blog blog);

	/**
	 * // ��ȡ��һƪ����
	 * @param id
	 * @return
	 */
	public Blog getPrevBlog(Integer id);

	/**
	 * // ��ȡ�� һƪ����
	 * @param id
	 * @return
	 */
	public Blog getNextBlog(Integer id);

	/**
	 * ���ݲ������͵�id��ѯ�������µĲ�������
	 * @param id
	 * @return
	 */
	public int getBlogByTypeId(Integer id);

	/**
	 * ��Ӳ���
	 * @param blog
	 * @return
	 */
	public int addBlog(Blog blog);

	/**
	 * ���ݲ���IDɾ������
	 * @param id
	 * @return
	 */
	public Integer deleteByBlogId(int id);
}
