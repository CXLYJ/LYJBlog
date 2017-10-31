package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Comment;

public interface CommentDao {
	
	//��ѯ������Ϣ
	public List<Comment> getCommentData(Map<String, Object> map);

	//�������
	public int addComment(Comment comment);

	//��������ܼ�¼��
	public Long getTotal(Map<String, Object> map);

	//ɾ��������Ϣ
	public Integer deleteComment(Integer id);

	//�޸�������Ϣ
	public Integer update(Comment comment);

	//���ݲ���idɾ����Ӧ������
	public Integer deleteCommentByBlogId(Integer blogId);

}
