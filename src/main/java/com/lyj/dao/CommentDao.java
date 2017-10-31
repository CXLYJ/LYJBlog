package com.lyj.dao;

import java.util.List;
import java.util.Map;

import com.lyj.entity.Comment;

public interface CommentDao {
	
	//查询评论信息
	public List<Comment> getCommentData(Map<String, Object> map);

	//添加评论
	public int addComment(Comment comment);

	//获得评论总记录数
	public Long getTotal(Map<String, Object> map);

	//删除博客信息
	public Integer deleteComment(Integer id);

	//修改评论信息
	public Integer update(Comment comment);

	//根据博客id删除对应的评论
	public Integer deleteCommentByBlogId(Integer blogId);

}
