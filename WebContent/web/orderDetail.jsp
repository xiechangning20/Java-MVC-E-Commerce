<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OrderDetail</title>
<link href="web/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function pay(oId){
		location.href="${pageContext.request.contextPath}/order?method=pay&oId="+oId;
	}
	
</script>
</head>
<%@ include file="header.jsp" %>
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
	<div class="panel-heading">
	    <h3 class="panel-title"><span class="glyphicon glyphicon-equalizer"></span>&nbsp;&nbsp;Order Detail</h3>
	</div>
	<div class="panel-body">
	<table cellpadding="0" cellspacing="0" align="center" width="100%" class="table table-striped table-bordered table-hover">

		<tr>
			<td>Order Id:</td>
			<td>${order.oId}</td>
			<td>Order Time:</td>
			<td>${order.oTime}</td>
		</tr>
		<tr>
			<td>Recipient:</td>
			<td>${order.address.aReceiver}</td>
			<td>Phone:</td>
			<td>${order.address.aPhone}</td>
		</tr>
		<tr>
			<td>Delivery Address:</td>
			<td>${order.address.aAddress}</td>
			<td>Total:</td>
			<td>${order.oTotal}</td>
		</tr>
		<tr>
			<td align="center">Product List:</td>
			<td colspan="3">
				<table align="center" cellpadding="0" cellspacing="0" width="100%"  class="table table-striped table-bordered table-hover">
					<tr align="center"  class="info">
						<th>id</th>
						<th>Image</th>
						<th>Name</th>
						
						<th>Date Added</th>
						<th>Price</th>
						<th>Amount</th>
						<th>Count</th>
					</tr>
					<c:forEach items="${order.orderDetail}" var="item" varStatus="i">
						<tr align="center">
							<th>${i.count}</th>
							<th>
				         <img src="${pageContext.request.contextPath}/web/${item.product.pImage}" width="50px" height="50px"> 
							</th>
							<th>${item.product.pName}</th>
							
							<th>${item.product.pDate}</th>
							<th>${item.product.pPrice}</th>
							<th>${item.odNum}</th>
							<th>${item.odTotal}</th>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="4" style="margin-right: 40px;">
				<a href="${pageContext.request.contextPath }/order?method=showOrder" class="btn btn-danger btn-sm">Return to OrderList</a>
				&nbsp;&nbsp;
				 <c:if test="${order.oStatus eq 1 }">
					
					<button type="button" onclick="pay('${order.oId}')" class="btn btn-success btn-sm">Pay</button>
				</c:if> 
			</td>
		</tr>
	</table>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>