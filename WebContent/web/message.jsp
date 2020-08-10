<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.min.js"></script>
		
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/login.css">

<title>ActiveSuccess</title>
</head>
<body>
	<div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;Account Activation</div>
				<div class="right fr">
					<a href="${pageContext.request.contextPath}/web/index.jsp" target="_black">ClayMusic</a>
				</div>
				<div class="clear"></div>
				<div class="xian center"></div>
			</div>
			<div  style="margin-top: 80px;margin-left: 100px;">
					
					<p class="text-info" style="font-size: 20px;">${msg }</p>
					
					<a class="btn btn-default" href="${pageContext.request.contextPath }/web/index.jsp" target="_blank">Return</a>
					
			</div>
		</div>
	</div>
	
</body>
</html>