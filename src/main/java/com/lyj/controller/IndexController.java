package com.lyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lyj.entity.Blog;
import com.lyj.entity.PageBean;
import com.lyj.service.BlogService;
import com.lyj.util.PageUtil;
import com.lyj.util.StringUtil;

/**
 * ��ҳ
 * @author asus
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private BlogService blogService;
	
	/**
	 * ������ҳ
	 * @return
	 */
	@RequestMapping("/index")
	private ModelAndView index(
			@RequestParam(value = "page",required=false)String page,
			@RequestParam(value = "typeId",required=false) String typeId,
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception{
		
		ModelAndView modelAndView =new ModelAndView();
		
		if(StringUtil.isNotEmpty(releaseDateStr)) {
			releaseDateStr=new String(releaseDateStr.getBytes("iso-8859-1"),"utf-8");
		}
		
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		//��ȡ�OҲ��bean
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10); //ÿҳ��ʾ10������
		
		// map�з�װ��ʼҳ��ÿҳ�ļ�¼
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		
		//��ȡ������Ϣ
		List<Blog> blogList=blogService.listBlog(map);
		for(Blog blog:blogList){
			List<String> imageList=blog.getImageList();
			String blogInfo =blog.getContent(); //��ȡ��������
			Document doc=Jsoup.parse(blogInfo); //����������(��ҳ��Ҳ����һЩhtml)תΪjsoup��Document
			Elements jpgs=doc.select("img[src$=.jpg]"); //��ȡ<img>��ǩ�����к�׺��.jpg��Ԫ��
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i); //��ȡ������Ԫ��
				imageList.add(jpg.toString()); //��ͼƬ��Ϣ�浽imageList��
				if(i == 2)
					break; //ֻ������ͼƬ��Ϣ
			}
		}
		
				// ��ҳ
				StringBuffer param = new StringBuffer();
				//ƴ�Ӳ�������Ҫ���ڵ�����·���������ڷ���󣬲�����ķ�ҳ��Ҫƴ�Ӿ���Ĳ���
				if(StringUtil.isNotEmpty(typeId)) {
					param.append("typeId=" + typeId + "&");
				}
				
				if(StringUtil.isNotEmpty(releaseDateStr)) {
					releaseDateStr=new String(releaseDateStr.getBytes("iso-8859-1"),"utf-8");
					param.append("releaseDateStr=" + releaseDateStr + "&");
				}
		
		modelAndView.addObject("pageCode", PageUtil.genPagination( //���ô������ɵĹ���������ǰ̨��ʾ
				request.getContextPath() + "/index.html", //���������controller��index����
				blogService.getTotal(map), 
				Integer.parseInt(page), 10,
				param.toString()));
		
		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("commonPage", "foreground/blog/blogList.jsp");
		modelAndView.addObject("title", "������ҳ - LYJ����");
		modelAndView.setViewName("mainTemp");
		
		return modelAndView;
	}
}
