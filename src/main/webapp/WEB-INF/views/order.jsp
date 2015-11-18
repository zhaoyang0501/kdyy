<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:if test="${tip!=null}"><div class="alert alert-success" role="alert">注册成功</div></c:if>
	<div class='row'>
	
        <div class="col-md-12 col-md-offset-3">
        
						<div class="panel panel-default">
						 <div class="panel-heading">快递预约</div>
						 <div class="panel-body">
						<form role="form">
						   <div class="form-group">
							  <label for="rt1-first-name">快递公司*</label>
							  	<select class='form-control'>
			                  	 	<c:forEach items="${companty }" var="bean">
			                  	 		<option value="${bean.id }">${bean.name }</option>
			                  	 	</c:forEach>
			                  	 </select>
						   </div>
						   <div class="form-group">
							  <label for="rt1-first-name">寄送地*</label>
			                  	 <select class='form-control'>
			                  	 	<c:forEach items="${areas }" var="bean">
			                  	 		<option value="${bean.id }">${bean.name}</option>
			                  	 	</c:forEach>
			                  	 </select>
						   </div>
						   <div class="form-group">
							   <label for="rt1-first-name">目的地*</label>
			                  	 <select class='form-control'>
			                  	 	<c:forEach items="${areas }" var="bean">
			                  	 		<option value="${bean.id }">${bean.name }</option>
			                  	 	</c:forEach>
			                  	 </select>
						   </div>
						   <div class="form-group">
							     <label >重量*</label><input type="text"  name='user.email' class='form-control'>
						   </div>
						    <div class="form-group">
							      <label >联系电话*</label><input type="text"  name='user.address' class='form-control'>
						   </div>
						   
						   <button type="submit" class="btn btn-sm btn-default">下单</button>
						</form>
						 </div>
				</div>
        </div>
        </div>
    </div>
    <%@include file="./foot.jsp" %>
</body>
</html>