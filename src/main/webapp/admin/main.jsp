<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>L Y J SSM个人博客系统后台管理页面</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<link rel="SHORTCUT ICON" href="favicon.ico">
<script src="${pageContext.request.contextPath}/../static/javascript/index.js"></script>

<script type="text/javascript">

function openTab(text,url,iconCls){
	if($("#tabs").tabs("exists",text)){
		$("#tabs").tabs("select",text);
	}else{
		 var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
		$("#tabs").tabs("add",{
			title:text,
			iconCls:iconCls,
			closable:true,
			content:content
		}) ;
	}
}	
	
	function openPasswordModifyDialog(){
		$("#dlg").dialog("open").dialog("setTitle","修改密码");
	}
	
	function modifyPassword() {
		$("#fm").form("submit",{
			url: "${pageContext.request.contextPath}/admin/blogger/modifyPassword.do",
			onSubmit: function() {
				var newPassword = $("#password").val();
				var newPassword2 = $("#password2").val();
				if(!$(this).form("validate")) {
					return false; //验证不通过直接false，即没填
				} 
				if(newPassword != newPassword2) {
					$.messager.alert("系统提示", "两次密码必须填写一致");
					return false
				}
				return true;
			}, //进行验证，通过才让提交
			success: function(result) {
				var result = eval("(" + result + ")"); //将json格式的result转换成js对象
				if(result.success) {
					$.messager.alert("系统提示", "密码修改成功，下一次登陆生效");
					closePasswordModifyDialog();
				} else {
					$.messager.alert("系统提示", "密码修改失败");
					return;
				} 
			}
		});
	}
	
	function closePasswordModifyDialog(){
		$("#password").val(""); //保存成功后将内容置空
		$("#password2").val("");
		$("#dlg").dialog("close"); //关闭对话框
	}
	
	function refreshSystemCache(){
		$.post("${pageContext.request.contextPath}/admin/system/refreshSystemCache.do",{},function(result){
			if(result.success){
				$.messager.alert("系统提示","已成功刷新系统缓存！");
			}else{
				$.messager.alert("系统提示","刷新系统缓存失败！");
			}
		},"json");
	}
	
	function logout(){
		$.messager.confirm("系统提示","您确认要退出系统吗？",function(r){
			if(r){
				window.location.href="${pageContext.request.contextPath}/admin/blogger/logout.do";
			}
		});
	}

</script>

<style type="text/css">
body, ul, li, ol,form,img,a{margin:0; padding:0; border:0; list-style:none;}
	/*banner*/
.banner{
 	width:870px;
 	height:300px;
 	margin:0px auto 0px auto;
 	position:relative;
 	overflow: hidden;
 	padding-top:10px;
 }
 .banner .banner_pic .pic{display:none;}
 .banner .banner_pic .current{display:block;}
 .banner ol{
 	position:absolute;
 	left:400px;
 	bottom:26px;
 }
 .banner ol .but{
 	float:left;
 	width:10px;
 	height:20px;
 	border:1px solid #FF7101;
 	margin-right:12px;
 	text-align:center;
 	line-height:22px;
 	background:#fff;
 	color:#FF7101;
 	font-size:14px;
 	font-weight:bold;
 }
 .banner ol li{cursor:pointer;}
 .banner ol .current{
 	color:#fff;
 	background:#FF7101;
 	float:left;
 	width:10px;
 	height:20px;
 	border:1px solid #FF7101;
 	margin-right:12px;
 	text-align:center;
 	line-height:22px;
 	font-size:14px;
 	font-weight:bold;
 }
/*banner*/
</style>

</head>
<body class="easyui-layout">
	<div region="north" style="height: 88px;background-color: #ffECFF">
		<table style="padding: 5px" width="100%">
			<tr>
				<td width="50%">
					
					<img alt="logo" src="${pageContext.request.contextPath}/static/images/logo.png">
			
				</td>
				<td valign="bottom" align="right" width="50%">
					<font size="3">&nbsp;&nbsp;<strong >欢迎大佬：</strong><font style="color: red;">${currentUser.username }</font></font>
				</td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
			<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎来到LYJ个人博客系统后台</font></div>
			
			<!--nav end-->
			<!--banner begin-->
				<div class="banner">
					<div class="banner_pic" id="banner_pic">
						<div class="current"><a href="#"><img src="${pageContext.request.contextPath}/static/images/jss01.jpg" alt="" /></a></div>
						<div class="pic"><a href="#"><img src="${pageContext.request.contextPath}/static/images/jss02.jpg" alt="" /></a></div>
						<div class="pic"><a href="#"><img src="${pageContext.request.contextPath}/static/images/js03.jpg" alt="" /></a></div>
						<div class="pic"><a href="#"><img src="${pageContext.request.contextPath}/static/images/jss04.jpg" alt="" /></a></div>
					</div>
					<ol id="button">
						<li class="current">1</li>
						<li class="but">2</li>
						<li class="but">3</li>
						<li class="but">4</li>
					</ol>
				</div>
			<!--banner end-->
			<!--stages begin-->
			
		</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="常用操作" data-options="selected:true,iconCls:'icon-item'" style="padding: 10px">
					<a href="javascript:openTab('写博客','blog/writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px">写博客</a>
					<a href="javascript:openTab('评论审核','comment/commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
				</div>
				<div title="博客管理" data-options="iconCls:'icon-bkgl'" style="padding: 10px">
					<a href="javascript:openTab('写博客','blog/writeBlog.jsp','icon-writeblog')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-writeblog'" style="width: 150px;">写博客</a>
					<a href="javascript:openTab('博客信息管理','blog/blogManage.jsp','icon-bkgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bkgl'" style="width: 150px;">博客信息管理</a>
				</div>
				<div title="博客类别管理" data-options="iconCls:'icon-bklb'" style="padding: 10px">
					<a href="javascript:openTab('博客类别信息管理','blogType/blogTypeManage.jsp','icon-bklb')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bklb'" style="width: 150px;">博客类别信息管理</a>
				</div>
				<div title="评论管理"  data-options="iconCls:'icon-plgl'" style="padding:10px">
					<a href="javascript:openTab('评论审核','comment/commentReview.jsp','icon-review')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论审核</a>
					<a href="javascript:openTab('评论信息管理','comment/commentManage.jsp','icon-plgl')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-plgl'" style="width: 150px;">评论信息管理</a>
				</div>
				<div title="个人信息管理"  data-options="iconCls:'icon-grxx'" style="padding:10px">
					<a href="javascript:openTab('修改个人信息','aboutme/modifyMe.jsp','icon-grxxxg')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-grxxxg'" style="width: 150px;">修改个人信息</a>
				</div>
				<div title="系统管理" data-options="iconCls:'icon-system'" style="padding: 10px">
					<a href="javascript:openTab('友情链接管理','link/linkManage.jsp','icon-link')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-link'" style="width: 150px">友情链接管理</a>
					<a href="javascript:openPasswordModifyDialog()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
					<a href="javascript:refreshSystemCache()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 150px;">刷新系统缓存</a>
					<a href="javascript:logout()" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">安全退出</a>
				</div>
			</div>
		</div>
<div region="south" style="height: 25px;padding: 10px" align="center">
	Copyright © 2012-2016 L Y J的SSM博客系统 版权所有
</div>

<div id="dlg" class="easyui-dialog" style="width: 400px; height:200px; padding:10px 20px "
	closed="true" buttons="#dlg-buttons">
	
	<form id="fm" method="post">
		<table cellspacing="8px">
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" id="username" name="username" value="${blogger.username }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>新密码</td>
				<td>
					<input type="password" id="password" name="password" class="easyui-validatebox" 
						 required="true" style="width:200px"/>
				</td>
			</tr>
			<tr>
				<td>确认新密码</td>
				<td>
					<input type="password" id="password2" name="password2" class="easyui-validatebox" 
						required="true" style="width:200px">
				</td>
			</tr>
		</table>
	</form>
	
</div>

<div id="dlg-buttons">
	<div>
		<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">保存</a>
		<a href="javascript:closePasswordModifyDialog()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">关闭</a>
	</div>
</div>
</body>
</html>
<!-- 防止页面回退 -->
<script type="text/javascript">
	
		window.onload=function(){
			history.forward();
		}
		
</script>