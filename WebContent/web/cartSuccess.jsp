<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="web/css/bootstrap.min.css" />
<title>Cart</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container">
<hr>
	<div class="row" style="width: 30%;margin: 0 auto;padding-top: 20px">
		<div class="panel panel-success">
			<div class="panel-heading">
			    <h3 class="panel-title">Shopping Cart</h3>
			</div>
			<div class="panel-body">
			    <h4 class="text-default"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;&nbsp;&nbsp;&nbsp;Item has been added!</h4>
				<hr>
				<a href="${pageContext.request.contextPath}/cart?method=show&uId=${loginUser.uId}" class="btn btn-primary">Check Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/web/index.jsp" class="btn btn-default">keep Shopping</a>
			</div>
		</div>
		
	</div>
	
</div>

<%@ include file="footer.jsp" %>
</body>
</html>