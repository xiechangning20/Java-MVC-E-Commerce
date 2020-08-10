<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

<link href="${pageContext.request.contextPath}/web/css/login2.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/web/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/web/css/bootstrap.min.css" rel="stylesheet">

<title>Header</title>
    <script type="text/javascript">
/*         $(document).ready(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/goodsTypeAjax",
                type:"GET",
                dataType:"json",
                success:function(data){
                    for(var i in data){
                        var a = $("<a href='${pageContext.request.contextPath}/getGoodsListByTypeId?typeid="+data[i].id+"'>"+data[i].name+"</a>");
                        $("#goodsType").append(a);

                    }
                },
                error:function(){
                    alert("Fail to get product type list!");
                }
            })
        }) */
        
    	
    	
    /* 	$(function(){
    		$.ajax({
    			url:"/Myshop/goodsType?method=findAll",
    			type:"GET",
    			dataType:"json",
    			success:function(data){
    				for(var i in data){
    					var a = $("<a href='${pageContext.request.contextPath}/product?method=show&ptId="+data[i].ptId+"'>"+data[i].ptName+"</a>");
    					$("#goodsType").append(a);
    				}
    			},
    			error:function(){
    				alert("Fail to get product type list!");
    			}
    		})
    	}) */
    </script>
</head>
<body>

<div class="container-lg">
       
        <div class="nav-div" style="margin-top: 30px;"> 
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="web/index.jsp">ClayMusic</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/product?method=show&ptId=1">Guitar</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/product?method=show&ptId=2">Drums</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/product?method=show&ptId=3">Keyboard</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/product?method=show&ptId=4">Bass</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="${pageContext.request.contextPath}/product?method=show&ptId=5">Orchestra</a>
                </li>
                
              </ul>
            </div>
               <div class="nav-right">
           		<c:if test="${empty loginUser}">
           		
           		<a href="${pageContext.request.contextPath}/web/register.jsp"  style="float:right";>Register</a>
                 <a href="${pageContext.request.contextPath}/web/login.jsp" " style="float:right";>Login&nbsp;&nbsp;&nbsp;</a>
                </c:if>
       			<c:if test="${not empty loginUser}">
       			    <li class="nav-item dropdown" style="float:right";>
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${loginUser.uName}
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/order?method=showOrder">My Order</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/cart?method=show&uId=${loginUser.uId}">Shopping Cart</a>
               
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/add?method=showAddress">Delivery Address</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user?method=logOut">Log-Out</a>
                    
                  </div>
                </li>
       			
                 
                </c:if>
               </div>
              
           </nav>
    
        </div>
        
    </div>
				
 <%-- <div id="top">
    	<div id="topdiv">
            <span>
                <a href="index.jsp" id="a_top" target="_blank">小米商城</a>
                <li>|</li>
                <a href="" id="a_top">小米商城移动版</a>
                <li>|</li>
                <a href="" id="a_top">问题反馈</a>
            </span>

            <span style="float:right">
           		<c:if test="${empty loginUser}">
                    <a href="login.jsp" id="a_top">登录</a>
                    <li>|</li>
                    <a href="register.jsp" id="a_top">注册</a>
                </c:if>
       			<c:if test="${not empty loginUser}">
                    <a href="${pageContext.request.contextPath}/web/self_info.jsp" id="a_top">${loginUser.uName}</a>
                    <li>|</li>
                    <a href="${pageContext.request.contextPath}/user?method=logOut" id="a_top">注销</a>
                    <li>|</li>
                    <a href="getOrderList" id="a_top">我的订单</a>
                    <li>|</li>
                    <a href="${pageContext.request.contextPath}/add?method=showAddress" id="a_top">地址管理</a>
                </c:if>
                <li>|</li>
                <a href="" id="a_top">消息通知</a>
                <a href="${pageContext.request.contextPath}/cart?method=show&uId=${loginUser.uId}" id="shorpcar">购物车</a>
            </span>
        </div>
 </div>
<div id="second">
	    <a href="" id="seimg" style=" margin-top:23px;"><img id="logo" src="/Myshop/web/image/logo_top.png" width="55" height="54"/></a>
        <a href="" id="seimg" style=" margin-top:17px;"><img id="gif" src="/Myshop/web/image/yyymix.gif" width="180" height="66" /></a>
        <p id="goodsType">
			<!-- 根据ajax 回调函数 填写数据 到此id中 -->

        </p>
       <form class="form-inline pull-right" style="margin-top: 40px;margin-right: 10px;">
		
		  <div class="form-group">
		    <input type="text" class="form-control" style="width: 400px"  placeholder="搜索一下好东西...">
		  </div>
		  <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;搜索</button>
	  </form> --%>
<!-- </div> -->

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>