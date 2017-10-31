package com.lyj.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lyj.dao.CommentDao;
import com.lyj.entity.Comment;
import com.lyj.service.CommentService;

/**
 * 用户评论service实现类
 * @author asus
 *
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentDao commentDao;
	
	/**
	 * 查询评论信息
	 */
	public List<Comment> getCommentData(Map<String, Object> map) {

		return commentDao.getCommentData(map);
	}

	/**
	 * 添加评论
	 */
	public int addComment(Comment comment) {
		
		return commentDao.addComment(comment);
	}

	/**
	 * 获得评论的总记录数
	 */
	public Long getTotal(Map<String, Object> map) {

		return commentDao.getTotal(map);
	}

	/**
	 * 删除博客信息
	 */
	public Integer deleteComment(Integer id) {
		
		return commentDao.deleteComment(id);
	}

	/**
	 * 修改评论信息
	 */
	public Integer update(Comment comment) {
		
		return commentDao.update(comment);
	}

	/**
	 * 根据博客id删除对应的评论
	 */
	public Integer deleteCommentByBlogId(Integer blogId) {
	
		return commentDao.deleteCommentByBlogId(blogId);
	}

}
