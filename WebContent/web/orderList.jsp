<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Orders</title>
<link href="web/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript">
	function showOrder(oId){
		location.href="${pageContext.request.contextPath}/order?method=detail&oId="+oId;
	}
	function changeStatus(oId){
		location.href="${pageContext.request.contextPath}/changeStatus?oid="+orderId;
	}
	function deleteOrder(oId){
		if(confirm("Delete this order?")){
			location.href="${pageContext.request.contextPath}/order?method=delete&oId="+oId;	
		}
	}
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container-lg" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>MyOrders&nbsp;&nbsp;
		
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table id="tb_list" class="table table-striped table-hover table-bordered table-condensed">
			<tr>
				<th>id</th>
				<th>Order Id</th>
				<th>Total</th>
				<th>Status</th>
				<th>Order Time</th>
				<th>Delivery Address</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${orderList}" var="order" varStatus="i">
				<tr>
					<th>${i.count}</th>
					<th>${order.oId}</th>
					<th>${order.oTotal}</th>
					<th>
						<font color="red">
							<c:if test="${order.oStatus eq 1 }">
								Awaiting for Payment
							</c:if>
							<c:if test="${order.oStatus eq 2 }">
								Paid
							</c:if>
							<c:if test="${order.oStatus eq 3 }">
								Sent,waiting for confirmation
							</c:if>
							<c:if test="${order.oStatus eq 4 }">
								Completed
							</c:if>
						</font>
					</th>
					<th>${order.oTime}</th>
					<th>${order.address.aAddress}</th>
					<th>
						<button type="button" class="btn btn-danger btn-sm" onclick="showOrder('${order.oId}')">Detail&Payment</button>
						
						<button type="button" class="btn btn-danger btn-sm" onclick="deleteOrder('${order.oId}')">Delete</button>
						<c:if test="${order.oStatus eq 3 }">
							<button type="button" class="btn btn-warning btn-sm" onclick="changeStatus('${order.oId}')">Confirm Felivery</button>
						</c:if>
					</th>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
	
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>