package com.lyj.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.lyj.entity.Blog;
import com.lyj.entity.BlogType;
import com.lyj.entity.Blogger;
import com.lyj.entity.Link;
import com.lyj.service.BlogService;
import com.lyj.service.BlogTypeService;
import com.lyj.service.BloggerService;
import com.lyj.service.LinkService;
import com.lyj.util.ResponseUtil;

/**
 * 管理员系统controllr层
 * @author asus
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {
	
	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;

	// 刷新系统缓存
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(
		HttpServletRequest request,
		HttpServletResponse response) throws Exception{
		
		ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
		
		// 获取博主信息
		Blogger blogger = bloggerService.getBloggerData();
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);

		// 获取友情链接信息
		List<Link> linkList = linkService.getLinkData(); 
		application.setAttribute("linkList", linkList);

		// 获取博客类别信息
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);

		// 获取博客信息，按照时间分类的
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
