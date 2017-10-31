package com.lyj.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyj.entity.Blog;
import com.lyj.entity.PageBean;
import com.lyj.lucene.BlogIndex;
import com.lyj.service.BlogService;
import com.lyj.service.CommentService;
import com.lyj.util.DateJsonValueProcessor;
import com.lyj.util.ResponseUtil;
import com.lyj.util.StringUtil;

/**
 * ���͹���Controller��
 * @author asus
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	private BlogIndex blogIndex=new BlogIndex();
	
	//��̨��ҳ��ѯ������Ϣ
	@RequestMapping("/listBlog")
	public String listBlog(
			@RequestParam(value="page",required=false)String page,
			@RequestParam(value="rows",required=false) String rows,
			Blog s_blog,
			HttpServletResponse response) throws Exception{
		
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("title", StringUtil.formatLike(s_blog.getTitle())); //ģ����ѯ
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogList=blogService.listBlog(map);
		Long total=blogService.getTotal(map);
		
		JSONObject result=new JSONObject();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyy-MM-dd"));
		JSONArray jsonArray=JSONArray.fromObject(blogList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		
		
		return null;
	}
	
	//��Ӻ��޸Ĳ���
	@RequestMapping("/save")
	public String save(Blog blog,HttpServletResponse response)throws Exception{
		
		int resultTotal=0; //�����Ƿ���ӳɹ����صĲ���
		if(blog.getId()==null){ //�����
			resultTotal=blogService.addBlog(blog);
			blogIndex.addIndex(blog);
		}else{ //��ʾ�޸�
			resultTotal=blogService.update(blog);
			blogIndex.updateIndex(blog);
		}
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		
		return null;
	}
	
	//ɾ������
	@RequestMapping("/delete")
	public String delete(
			@RequestParam(value="ids",required=false)String ids,
			HttpServletResponse response)throws Exception{
		
		String[] idsStr=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			commentService.deleteCommentByBlogId(id);
			blogService.deleteByBlogId(id);
			blogIndex.deleteIndex(idsStr[i]);
		}
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		
		return null;
	}
	
	//ͨ��id��ȡ����ʵ��
	@RequestMapping("/findById")
	public String findById(
			@RequestParam(value="id") String id,
			HttpServletResponse response) throws Exception{
		
		Blog blog=blogService.findById(Integer.parseInt(id));
		JSONObject result=JSONObject.fromObject(blog);
		ResponseUtil.write(response, result);
		
		return null;
	}
}
