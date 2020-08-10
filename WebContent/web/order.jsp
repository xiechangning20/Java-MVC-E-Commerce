<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Order Preview</title>
<link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.min.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("#btn_add").click(function(){
			location.href = "addOrder?aid="+$("#address").val();
		})
	}) */
	
	function createOrder(uId,sum){
		
		 location.href="${pageContext.request.contextPath}/order?method=createOrder&uId="+uId+"&sum="+sum+"&aId="+$("#address").val();
		
		
	}
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>Order Preview</h3>
	</div>
	
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>id</th>
 					<th>Product Name</th>
 					<th>Price</th>
 					<th>Amount</th>
 					<th>Total</th>
 					
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${cartList}" var="c" varStatus="i">
	 				<tr>
	 					<th>${i.count}</th>
	 					<th>${c.product.pName}</th>
	 					<th>${c.product.pPrice}</th>
	 					<th>${c.cNum}</th>
	 					<th>${c.cTotal}</th>
	 				</tr>
	 				<c:set var="sum" value="${sum+c.cTotal}"></c:set>
 				</c:forEach>
 				<tr>
 				 <td colspan="5">
 				 	<h5>Delivery Address</h5>
 				 	<select id="address" style="width:60%" class="form-control">
 				 		<c:forEach items="${addList}" var="a" varStatus="ai">
 				 			<option value="${a.aId}">${a.aReceiver}&nbsp;&nbsp;${a.aPhone}&nbsp;&nbsp;${a.aAddress}</option>
 				 		</c:forEach>
 				 	</select>
 				 	<c:if test="${empty addList}">
 				 		<a href="${pageContext.request.contextPath}/web/self_info.jsp">Add Delivery Address</a>
 				 	</c:if>
 				 </td>
 				</tr>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
		<div style="margin-left: 40px;">	  
	            <h4>Sum：<span id="total" class="text-danger"><b>$&nbsp;&nbsp;${sum}</b></span></h4>
		</div>
	</div>
	<div class="row pull-right" style="margin-right: 40px;">
		 <div style="margin-bottom: 20px;">
	            <button  id="btn_add" onclick="createOrder(${loginUser.uId},${sum})" class="btn  btn-danger btn-lg" type="button">Place Order</button>
	     </div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>