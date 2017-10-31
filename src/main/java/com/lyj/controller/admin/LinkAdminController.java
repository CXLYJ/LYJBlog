package com.lyj.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyj.entity.Link;
import com.lyj.entity.PageBean;
import com.lyj.service.LinkService;
import com.lyj.util.ResponseUtil;

/**
 * 管理员友情链接Controller层
 * @author asus
 *
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {

	@Resource
	private LinkService linkService;
	
	// 分页查询友情链接
	@RequestMapping("/listLink")
	public String listLink(
			//required = false当可选参数“notIncludeTypeId”不为空
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Link> linkList = linkService.listLinkData(map);
		Long total = linkService.getTotal(map);

		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(linkList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	//添加和更新友情链接信息
	@RequestMapping("/save")
	public String save(Link link,HttpServletResponse response) throws Exception{
		
		int resultTotal = 0; // 接收返回结果记录数
		if(link.getId() == null){ //说明是添加操作
			resultTotal =linkService.addLink(link);
		}else{ //表示修改
			resultTotal =linkService.update(link);
		}
		JSONObject result =new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		
		return null;
	}
	
	//友情链接删除
	@RequestMapping("/delete")
	public String deleteLink(
			@RequestParam(value="ids",required=false) String ids,
			HttpServletResponse response)throws Exception{

		String[] idsStr = ids.split(",");
		JSONObject result = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			linkService.deleteLink(id);	
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		
		return null;
	}
}
