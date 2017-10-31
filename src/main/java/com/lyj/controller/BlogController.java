package com.lyj.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lyj.entity.Blog;
import com.lyj.entity.Comment;
import com.lyj.lucene.BlogIndex;
import com.lyj.service.BlogService;
import com.lyj.service.CommentService;
import com.lyj.util.PageUtil;
import com.lyj.util.StringUtil;

/**
 * 博客Controller层
 * @author asus
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	private BlogIndex blogIndex=new BlogIndex();

	// 请求博客详细信息
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request) {
		
		ModelAndView modelAndView =new ModelAndView();
		Blog blog = blogService.findById(id); //根据id获取博客
		
		// 获取关键字
		String KeyWords = blog.getKeyWord();
		if(StringUtil.isNotEmpty(KeyWords)){
			String[] strArray= KeyWords.split(" ");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays.asList(strArray));
			modelAndView.addObject("keyWords", keyWordsList);
		}else{
			modelAndView.addObject("keyWords", null);
		}
		
		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit()+1); // 将博客访问量加1
		blogService.update(blog); // 更新博客
		
		//查询评论信息
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("blogId",blog.getId());
		map.put("state", 1);
		List<Comment> commentList =commentService.getCommentData(map);
		
		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " - LYJ的博客");
		
		// 存入上一篇和下一篇的显示代码
		modelAndView.addObject("pageCode", PageUtil.getPrevAndNextPageCode(
			blogService.getPrevBlog(id), blogService.getNextBlog(id),
			request.getServletContext().getContextPath()));

			modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}
	
	//根据关键字查询博客信息
	@RequestMapping(value="/search",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(
			@RequestParam(value="q",required=false)String q,
			@RequestParam(value="page",required=false)String page,
			HttpServletRequest request) throws Exception{
		
		 request.setCharacterEncoding("UTF-8");
		
		int pageSize=10;
		ModelAndView modelAndView=new ModelAndView();
		if(page == null){ //page为空表示第一次收索
			page="1";
		}
		modelAndView.addObject("commonPage", "foreground/blog/searchResult.jsp");
		
		//q=new String(q.trim().getBytes("iso-8859-1"),"utf-8"); //解决前台传进的值乱码问题
		//request.setCharacterEncoding("utf-8");
			
		List<Blog> blogIndexList = blogIndex.searchBlog(q.trim());
		int fromIndex=(Integer.parseInt(page)-1)*pageSize; //开始索引
		int toIndex =blogIndexList.size()>=Integer.parseInt(page) * 
				pageSize ? Integer.parseInt(page)*pageSize:blogIndexList.size();
		modelAndView.addObject("blogIndexList", blogIndexList.subList(fromIndex, toIndex));
		modelAndView.addObject("pageCode", PageUtil.getUpAndDownPageCode(Integer.parseInt(page),
				blogIndexList.size(), q, pageSize, request.getServletContext().getContextPath()));
		modelAndView.addObject("q", q); // 用于数据的回显
		modelAndView.addObject("resultTotal", blogIndexList.size()); // 查询到的总记录数
		
		modelAndView.addObject("title", "搜索'" + q + "'的结果 - LYJ的博客");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
