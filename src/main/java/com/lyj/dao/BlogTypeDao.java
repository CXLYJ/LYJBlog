package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.BlogType;

public interface BlogTypeDao {

	/**
	 * ��ȡ������Ϣ
	 * @return
	 */
	public List<BlogType> getBlogTypeData();

	// ����id���Ҳ���������Ϣ
	public BlogType findById(Integer id);

	//��̨��ҳ��ѯ�������
	public List<BlogType> listBlogType(Map<String, Object> map);

	//��ȡ�����������
	public Long getTotal(Map<String, Object> map);

	//��Ӳ������
	public int addBlogType(BlogType blogType);

	//�޸Ĳ������
	public int updateBlogType(BlogType blogType);

	//ɾ���������
	public Integer deleteBlogType(Integer id);
}
