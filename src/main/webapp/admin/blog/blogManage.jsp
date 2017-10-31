<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客管理页面</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	
	//显示博客名字
	//当是查询当前的时row表获取数据关联则用val表获取数据
	function formatTitle(val, row) {
		return "<a target='_blank' href='${pageContext.request.contextPath}/blog/articles/"+row.id+".html'>"+val+"</a>";
	}
	
	//查询出博客类别名
	function formatBlogType(val, row) {
		return val.typeName;
	}
	
	//模糊查询博客
	function searchBlog(){
	
		/* var s_title=$("#s_title");
		s_title = $("#dg").datagrid("getSelections");
		
		if(s_title==""||s_title==null) {
			
			$.messager.alert("系统提示", "请输入要查询的标题字段");
			return;
		} */
		$("#dg").datagrid("load",{
				"title":$("#s_title").val()
			});
	}
	
	//删除博客信息
	function deleteBlog() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的数据");
			return;
		}
		var idsStr = [];
		for(var i = 0; i < selectedRows.length; i++) {
			idsStr.push(selectedRows[i].id);
		}
		var ids = idsStr.join(","); //1,2,3,4
		$.messager.confirm("系统提示", "<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>", function(r) {
			if(r) {
				$.post("${pageContext.request.contextPath}/admin/blog/delete.do",
						{ids: ids}, function(result){
							if(result.success) {
								$.messager.alert("系统提示", "数据删除成功！");
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("系统提示", "数据删除失败！");
							}
						}, "json");
			}
		});
	}
	
	//跳到修改博客页面
	function openBlogModifyTab(){
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length != 1) {
			$.messager.alert("系统提示", "请选择一个要修改的博客");
			return;
		}
		var row = selectedRows[0];
		window.parent.openTab("修改博客","blog/modifyBlog.jsp?id=" + row.id,"icon-writeblog");
	}
	
	//刷新
	function reload() {
		$("#dg").datagrid("reload");
	}
	
</script>

<style type="text/css">
	
	.tb{
		margin-left: 5px;
	}
	a{
		margin-left:50px;
		margin-top: 10px;
		margin-bottom: 10px;
	}

</style>

</head>

<body style="margin: 1px; font-family: microsoft yahei">
<table id="dg" title="博客管理" class="easyui-datagrid" fitColumns="true" pagination="true"
	url="${pageContext.request.contextPath}/admin/blog/listBlog.do" toolbar="#tb">
	<thead>
		<tr>
			<th field="cb" checkbox="true" align="center"></th>
			<th field="id" width="20" align="center">编号</th>
			<th field="title" width="200" align="center" formatter="formatTitle">标题</th>
			<th field="releaseDate" width="100" align="center">发布日期</th> 
			<th field="blogType" width="100" align="center" formatter="formatBlogType">博客类型</th>
		</tr>
	</thead>
</table>
<div id="tb"> 
	<div>
		&nbsp;标题&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()">
		<a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		<a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		<a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>		
		<a href="javascript:reload()" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>		
	</div>
</div>
</body>
</html>