package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Comment;

public interface CommentService {

	/**
	 * ��ѯ������Ϣ
	 * @param map
	 * @return
	 */
	List<Comment> getCommentData(Map<String, Object> map);

	/**
	 * �������
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);

	/**
	 * ������۵��ܼ�¼��
	 * @param map
	 * @return
	 */
	Long getTotal(Map<String, Object> map);

	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public Integer deleteComment(Integer id);

	 /**
	  * �޸�������Ϣ
	  * @param comment
	  * @return
	  */
	public Integer update(Comment comment);

	/**
	 * ���ݲ���idɾ�����Ͷ�Ӧ������
	 * ���ݲ���idɾ��������Ϣ������ɾ��ĳƪ����ǰ����ɾ���ò��͵����ۣ���Ϊ�����
	 * @param id
	 * @return
	 */
	public Integer deleteCommentByBlogId(Integer blogId);

}
