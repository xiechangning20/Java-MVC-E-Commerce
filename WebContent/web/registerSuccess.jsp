<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="web/css/bootstrap.min.css" rel="stylesheet">
		<script type="text/javascript" src="web/js/jquery.min.js"></script>
		
<link rel="stylesheet" type="text/css" href="web/css/login.css">

<title>Register Success</title>
</head>
<body>
	<div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl">&nbsp;&nbsp;Registration</div>
				<div class="right fr">
					<a href="${pageContext.request.contextPath}/web/index.jsp" target="_black">ClayMusic</a>
				</div>
				<div class="clear"></div>
				<div class="xian center"></div>
			</div>
			<div  style="margin-top: 80px;margin-left: 30px;">
					
					<p class="text-info" style="font-size: 20px;">An email for activation has been sent to your email,dont't for get to activate before logining in!</p>
					
					
					<a class="btn btn-default" href="${pageContext.request.contextPath}/web/login.jsp" target="_blank">Login</a>
					
			</div>
		</div>
	</div>
	
</body>
</html>