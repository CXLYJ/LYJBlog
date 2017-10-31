<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>

<title>${title }</title>
<link rel="SHORTCUT ICON" href="favicon.ico">
<style type="text/css">
	body{
		padding-top:10px;
		padding-bottom:40px;
		background-color: #F8F8FF;
		font-family: microsoft yahei;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<jsp:include page="/foreground/common/head.jsp"/>
		</div>		
			
		<div class="row" style="padding-top: 20px">
			<jsp:include page="/foreground/common/menu.jsp"/>
		</div>
			
		<div class="row">	
		
				<div class="col-md-9">
				  	<jsp:include page="${commonPage }" />
				 </div>  
			
			  	<div class="col-md-3">		  	
					  <jsp:include page="/foreground/blog/rightList.jsp"/>		  	
				 </div>
		</div>
		
		<div class="row">
			<jsp:include page="/foreground/common/footer.jsp"/>
		</div>
	</div>
	
<script>
	window._bd_share_config = {
		"common" : {
			"bdSnsKey" : {},
			"bdText" : "",
			"bdMini" : "2",
			"bdMiniList" : false,
			"bdPic" : "",
			"bdStyle" : "0",
			"bdSize" : "32"
		},
		"share" : {},
		"image" : {
			"viewList" : [ "weixin", "tsina", "qzone", "tieba", "renren",
					"linkedin" ],
			"viewText" : "分享到：",
			"viewSize" : "24"
		},
		"selectShare" : {
			"bdContainerClass" : null,
			"bdSelectMiniList" : [ "weixin", "tsina", "qzone", "tieba",
					"renren", "linkedin" ]
		}
	};
	with (document)
		0[(getElementsByTagName('head')[0] || body)
				.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
				+ ~(-new Date() / 36e5)];
</script>
</body>
</html>