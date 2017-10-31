package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.CommentDao;
import com.lyj.entity.Comment;
import com.lyj.service.CommentService;

/**
 * �û�����serviceʵ����
 * @author asus
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentDao commentDao;
	
	/**
	 * ��ѯ������Ϣ
	 */
	public List<Comment> getCommentData(Map<String, Object> map) {

		return commentDao.getCommentData(map);
	}

	/**
	 * �������
	 */
	public int addComment(Comment comment) {
		
		return commentDao.addComment(comment);
	}

	/**
	 * ������۵��ܼ�¼��
	 */
	public Long getTotal(Map<String, Object> map) {

		return commentDao.getTotal(map);
	}

	/**
	 * ɾ��������Ϣ
	 */
	public Integer deleteComment(Integer id) {
		
		return commentDao.deleteComment(id);
	}

	/**
	 * �޸�������Ϣ
	 */
	public Integer update(Comment comment) {
		
		return commentDao.update(comment);
	}

	/**
	 * ���ݲ���idɾ����Ӧ������
	 */
	public Integer deleteCommentByBlogId(Integer blogId) {
	
		return commentDao.deleteCommentByBlogId(blogId);
	}

}
