package com.lyj.service;

import com.lyj.entity.Blogger;

public interface BloggerService {

	//��ȡ������Ϣ
	public Blogger getBloggerData();

	// �����û��������ݿ��в�ѯ��������Ϣ
	public Blogger getByUsername(String username);

	//�޸Ĳ�������
	public int updateBlogger(Blogger blogger);

}
