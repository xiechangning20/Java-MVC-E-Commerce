<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>GoodsDetail</title>

</head>
<body>
	<%@ include file="header.jsp"%>
  
    	<%-- <div style="margin: 0 auto;width: 80%;">
	   <ol class="breadcrumb">
		  <li><a href="#">ClayMusic</a></li>
		 
		  <li class="active"><a href="getGoodsListByTypeId?typeid=${product.ptId}">Guitar</a></li>
	   </ol>
   </div> --%>
   
	<div class="container-lg">
		<div class="row">
		  <div class="col-md">
		    <a href="#" class="thumbnail">
		      <img src="${pageContext.request.contextPath}/web/${product.pImage}"  width="560" height="560"  alt="${product.pName}" />
		    </a>
		  </div>
		  <div class="col-md">
		   	<div class="panel panel-default" style="height: 560px">
			  <div class="panel-heading">Product's detail</div>
			  <div class="panel-body">
			    <h3>${product.pName}</h3>
			    <div style="margin-left: 10px;">
				    
				   <p>&nbsp;&nbsp;&nbsp;<span class="text-danger" style="font-size: 15px;">$${product.pPrice}</span>&nbsp;&nbsp;&nbsp;</p> 
				  
				     
						<c:forEach begin="1" end="${product.pStar}">
				        		<img src="web/image/star_red.gif" alt="star"/>
				        	</c:forEach>
					</p>
				    <p>Description:</p>
				    <p>&nbsp;&nbsp;${product.pDescription }</p>
				    <a href="${pageContext.request.contextPath}/cart?method=create&pId=${product.pId}" class="btn btn-warning">Add to Cart&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-shopping-cart"></span></a>&nbsp;&nbsp;&nbsp;
				<!--     <button class="btn btn-danger">Buy now</button> -->
			    </div>
			  </div>
			</div>
		  </div>
		</div>
	</div>
   <!-- 底部 -->
   <%@ include file="footer.jsp"%>


</body>
</html>