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
 * ����Controller��
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

	// ���󲩿���ϸ��Ϣ
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request) {
		
		ModelAndView modelAndView =new ModelAndView();
		Blog blog = blogService.findById(id); //����id��ȡ����
		
		// ��ȡ�ؼ���
		String KeyWords = blog.getKeyWord();
		if(StringUtil.isNotEmpty(KeyWords)){
			String[] strArray= KeyWords.split(" ");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays.asList(strArray));
			modelAndView.addObject("keyWords", keyWordsList);
		}else{
			modelAndView.addObject("keyWords", null);
		}
		
		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit()+1); // �����ͷ�������1
		blogService.update(blog); // ���²���
		
		//��ѯ������Ϣ
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("blogId",blog.getId());
		map.put("state", 1);
		List<Comment> commentList =commentService.getCommentData(map);
		
		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " - LYJ�Ĳ���");
		
		// ������һƪ����һƪ����ʾ����
		modelAndView.addObject("pageCode", PageUtil.getPrevAndNextPageCode(
			blogService.getPrevBlog(id), blogService.getNextBlog(id),
			request.getServletContext().getContextPath()));

			modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}
	
	//���ݹؼ��ֲ�ѯ������Ϣ
	@RequestMapping(value="/search",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(
			@RequestParam(value="q",required=false)String q,
			@RequestParam(value="page",required=false)String page,
			HttpServletRequest request) throws Exception{
		
		 request.setCharacterEncoding("UTF-8");
		
		int pageSize=10;
		ModelAndView modelAndView=new ModelAndView();
		if(page == null){ //pageΪ�ձ�ʾ��һ������
			page="1";
		}
		modelAndView.addObject("commonPage", "foreground/blog/searchResult.jsp");
		
		//q=new String(q.trim().getBytes("iso-8859-1"),"utf-8"); //���ǰ̨������ֵ��������
		//request.setCharacterEncoding("utf-8");
			
		List<Blog> blogIndexList = blogIndex.searchBlog(q.trim());
		int fromIndex=(Integer.parseInt(page)-1)*pageSize; //��ʼ����
		int toIndex =blogIndexList.size()>=Integer.parseInt(page) * 
				pageSize ? Integer.parseInt(page)*pageSize:blogIndexList.size();
		modelAndView.addObject("blogIndexList", blogIndexList.subList(fromIndex, toIndex));
		modelAndView.addObject("pageCode", PageUtil.getUpAndDownPageCode(Integer.parseInt(page),
				blogIndexList.size(), q, pageSize, request.getServletContext().getContextPath()));
		modelAndView.addObject("q", q); // �������ݵĻ���
		modelAndView.addObject("resultTotal", blogIndexList.size()); // ��ѯ�����ܼ�¼��
		
		modelAndView.addObject("title", "����'" + q + "'�Ľ�� - LYJ�Ĳ���");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
