package com.lyj.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.lyj.entity.Blog;
import com.lyj.entity.BlogType;
import com.lyj.entity.Blogger;
import com.lyj.entity.Link;
import com.lyj.service.BlogService;
import com.lyj.service.BlogTypeService;
import com.lyj.service.BloggerService;
import com.lyj.service.LinkService;

@Component
public class InitBloggerData implements ServletContextListener,ApplicationContextAware {

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		InitBloggerData.applicationContext=applicationContext;
	}
	
	private static ApplicationContext applicationContext;
	
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println(applicationContext);
		//�Ȼ�ȡservlet������
		ServletContext application=sce.getServletContext();
		
		//����spring�������Ļ�ȡbloggerService���bean
		BloggerService bloggerService=(BloggerService) applicationContext.getBean("bloggerService");
		//��ȡ������Ϣ
		Blogger blogger=bloggerService.getBloggerData();
		//��������Ҳ��ȡ���ˣ��Ƚ����У�����Ҳ����Ҫ��������԰�������յ�
		blogger.setPassword(null);
		//��������Ϣ����application����
		application.setAttribute("blogger", blogger);
		
		//ͬ�ϣ���ȡ����������Ϣ
		LinkService linkService = (LinkService) applicationContext.getBean("linkService");
		List<Link> linkList = linkService.getLinkData(); 
		application.setAttribute("linkList", linkList);
		
		//ͬ�ϣ���ȡ���������Ϣ
		BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
		List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
		application.setAttribute("blogTypeList", blogTypeList);
		
		//ͬ�ϣ���ȡ������Ϣ������ʱ������
		BlogService blogService = (BlogService) applicationContext.getBean("blogService");
		List<Blog> blogTimeList = blogService.getBlogData();
		application.setAttribute("blogTimeList", blogTimeList);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
