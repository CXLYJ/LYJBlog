package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.BlogTypeDao;
import com.lyj.entity.BlogType;
import com.lyj.service.BlogTypeService;

/**
 * �������serviceʵ����
 * @author asus
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;
	
	/**
	 * ǰ̨��ҳ��ѯ�������
	 */
	public List<BlogType> getBlogTypeData() {
		
		return blogTypeDao.getBlogTypeData();
	}

	/**
	 * ��̨��ҳ��ѯ�������
	 */
	public List<BlogType> listBlogType(Map<String, Object> map) {
		
		return blogTypeDao.listBlogType(map);
	}

	/**
	 * ��ȡ�����������
	 */
	public Long getTotal(Map<String, Object> map) {
	
		return blogTypeDao.getTotal(map);
	}

	/**
	 * ��Ӳ������
	 * @param blogType
	 * @return
	 */
	public int addBlogType(BlogType blogType) {
		
		return blogTypeDao.addBlogType(blogType);
	}

	/**
	 * �޸Ĳ������
	 * @param blogType
	 * @return
	 */
	public int updateBlogType(BlogType blogType) {
		
		return blogTypeDao.updateBlogType(blogType);
	}

	/**
	 * ɾ���������
	 */
	public Integer deleteBlogType(Integer id) {
		
		return blogTypeDao.deleteBlogType(id);
	}

}
