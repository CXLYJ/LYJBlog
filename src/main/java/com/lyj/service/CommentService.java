package com.lyj.service;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Comment;

public interface CommentService {

	/**
	 * 查询评论信息
	 * @param map
	 * @return
	 */
	List<Comment> getCommentData(Map<String, Object> map);

	/**
	 * 添加评论
	 * @param comment
	 * @return
	 */
	int addComment(Comment comment);

	/**
	 * 获得评论的总记录数
	 * @param map
	 * @return
	 */
	Long getTotal(Map<String, Object> map);

	/**
	 * 删除博客信息
	 * @param id
	 * @return
	 */
	public Integer deleteComment(Integer id);

	 /**
	  * 修改评论信息
	  * @param comment
	  * @return
	  */
	public Integer update(Comment comment);

	/**
	 * 根据博客id删除博客对应的评论
	 * 根据博客id删除评论信息，用于删除某篇博客前，先删掉该博客的评论，因为有外键
	 * @param id
	 * @return
	 */
	public Integer deleteCommentByBlogId(Integer blogId);

}
