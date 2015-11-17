<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@include file="./validatelogin.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Smart - UI Elements</title>

		<!-- Bootstrap -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
		<!-- DataTables http://www.datatables.net/  -->
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/ace.js"></script>
		<script src="${pageContext.request.contextPath}/js/problem.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/dataTables.bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/admin/js/falgun/TableTools.min.js"></script>
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<script type="text/javascript">
	$(document).ready(function(){
		$.ace.setContextPath('${pageContext.request.contextPath}');
	});
</script>
	</head>
<body>
<%@include file="./header.jsp" %>
<!-- nav end -->

<!-- custom body begin -->
<div class="container main">
    <div class="container">
     <div class="row">
     <div class="col-lg-12 col-sm-12 ">
     	<h3>所有快递公司</h3>
     </div>
	     <c:forEach items="${companys }" var="bean">
	     	  <div class="col-lg-3 col-sm-3 ">
							<div class="thumbnail">
							  <img src="http://pic.baike.soso.com/p/20130619/20130619104631-73943716.jpg" alt="" style="max-height:120px ">
							  <div class="caption">
								<h3>${bean.name}</h3>
								<p>地址：${bean.addr}</p>
								<p>电话：${bean.tel}</p>
								<p>网站：<a>${bean.site }</a></p>
								<p><a href="company/${bean.id}" class="btn btn-primary">查看详情</a> </p>
							  </div>
							</div>
				</div>
	     </c:forEach>
		</div>
    </div>
</div>
    <%@include file="./foot.jsp" %>
</body>
</html>