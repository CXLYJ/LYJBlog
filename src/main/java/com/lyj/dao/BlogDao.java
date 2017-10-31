package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Blog;

public interface BlogDao {

	//��ȡ������Ϣ������ʱ������
	public List<Blog> getBlogData();

	// ��ȡ������Ϣ
	public List<Blog> listBlog(Map<String, Object> map);

	//��ȡ���͵�������
	public long getTotal(Map<String, Object> map);

	//����id��ȡ����
	public Blog findById(Integer id);

	//���²���
	public Integer update(Blog blog);

	 //��ȡ��һƪ����
	public Blog getPrevBlog(Integer id);

	//��ȡ��һƪ����
	public Blog getNextBlog(Integer id);

	//���ݲ������͵�id��ѯ�������µĲ�������
	public int getBlogByTypeId(Integer id);

	//��Ӳ���
	public int addBlog(Blog blog);

	//���ݲ���Idɾ������
	public Integer deleteByBlogId(int id);

}
