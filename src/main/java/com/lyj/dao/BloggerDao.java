package com.lyj.dao;

import com.lyj.entity.Blogger;

public interface BloggerDao {

	//��ȡ������Ϣ
	public Blogger getBloggerData();

	// �����û��������ݿ��в�ѯ��������Ϣ
	public Blogger getByUsername(String username);

	//�޸Ĳ�������
	public int updateBlogger(Blogger blogger);

}
