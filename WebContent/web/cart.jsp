<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cart</title>
<link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.min.js"></script>
<script type="text/javascript">
    function sNum(cId,cNum,pPrice){
    	  if(cNum == 1){
    		 if(confirm("Deleteting this content?")){
    			 location.href="${pageContext.request.contextPath}/cart?method=delete&cId="+cId;
    		 }
    		 }
    	  else{
    		  cNum --;
 			 location.href="${pageContext.request.contextPath}/cart?method=update&cId="+cId+"&cNum="+cNum+"&pPrice="+pPrice;
    	  }
    }
    function pNum(cId,cNum,pPrice){
    	cNum++;
    	location.href="${pageContext.request.contextPath}/cart?method=update&cId="+cId+"&cNum="+cNum+"&pPrice="+pPrice;
    }
	
	function clearCart(cId){
		if(confirm("Deleting this content?")){
			location.href="${pageContext.request.contextPath}/cart?method=delete&cId="+cId;
		}
	}
	
	function clearAll(uId){
		if(confirm("Deleting all content?")){
			location.href="${pageContext.request.contextPath}/cart?method=clearAll&uId="+uId;
		}
	}
</script>
</head>
<body style="background-color:#f5f5f5">
<%@ include file="header.jsp"%>
<div class="container" style="background-color: white;">
	<div class="row" style="margin-left: 40px">
		<h3>My Shopping Cart</h3>
	</div>
	<div class="row" style="margin-top: 40px;">
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-bordered table-striped table-hover">
 				<tr>
 					<th>ID</th>
 					<th>Name</th>
 					<th>Price</th>
 					<th>Amount</th>
 					<th>Count</th>
 					<th>Action</th>
 				</tr>
 				<c:set value="0" var="sum"></c:set>
 				<c:forEach items="${cartList}" var="c" varStatus="i">
	 				<tr>
	 					<th>${i.count}</th>
	 					<th>${c.product.pName}</th>
	 					<th>${c.product.pPrice}</th>
	 					<th width="100px">
		 					<div class="input-group">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="sNum(${c.cId},${c.cNum},${c.product.pPrice})">-</button>
		 						</span>
		 						<input type="text" class="form-control" id="num_count${i.count}" value="${c.cNum}" readonly="readonly" style="width:40px">
		 						<span class="input-group-btn">
		 							<button class="btn btn-default" type="button" onclick="pNum(${c.cId},${c.cNum},${c.product.pPrice})">+</button>
		 						</span>
	 						</div>
	 					</th>
	 					<th>¥&nbsp;${c.cTotal}</th>
	 					<th>
	 						<button type="button" class="btn btn-default" onclick="clearCart(${c.cId})">Delete</button>
	 					</th>
	 				</tr>
	 				<c:set var="sum" value="${sum+c.cTotal}"></c:set>
 				</c:forEach>
			</table>
		</div>
	</div>
	<hr>
	<div class="row">
	   <div class="col-md">
		<div class="pull-right" style="margin-right: 40px;">
			
	            <div>
	            	
	            	<c:if test="${!empty cartList}">
	            	<a id="removeAllProduct"  onclick = "clearAll(${loginUser.uId})"class="btn btn-default btn-lg">Clear All</a>
	            	&nbsp;&nbsp;
	            	<a href="${pageContext.request.contextPath}/order?method=preview&uId=${loginUser.uId}" class="btn  btn-danger btn-lg">Generate Order</a>
	            	</c:if>
	            </div>
	            <br><br>
	            <div style="margin-bottom: 20px;">        		  
	            	Total：<span id="total" class="text-danger"><b>$&nbsp;&nbsp;${sum}</b></span>
	            </div>
		</div>
		</div>
	</div>
</div>
	
    
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>