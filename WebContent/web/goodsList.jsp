<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ProductList</title>

</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-lg">
		<div class="panel panel-default" style="margin: 0 auto; width: 95%;">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;Product List
				</h3>
			</div>
			<div class="panel-body">
				<!--列表开始-->
				<div class="row" style="margin: 0 auto;">
					<c:forEach items="${pageBean.productList}" var="g" varStatus="i">
						<div class="col-sm-3">
							<div class="thumbnail">
								<img src="${pageContext.request.contextPath}/web/${g.pImage}"
									width="180" height="180" alt="小米6" />
								<div class="caption">
									<h4>
										<a
											href="${pageContext.request.contextPath}/product?method=detail&pId=${g.pId}">${g.pName}</a>
									</h4>
									<p>
										<c:forEach begin="1" end="${g.pStar}">
											<img src="web/image/star_red.gif" alt="pStar" />
										</c:forEach>
									</p>

									<p style="color: orange">$${g.pPrice}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<center>
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="${pageBean.currentPage==1?'disabled':''}"><a class="page-link"
								href="${pageContext.request.contextPath}/product?method=show&ptId=${param.ptId}&currentPage=${pageBean.currentPage-1}" >Previous</a></li>
							<c:forEach begin="1" end="${pageBean.totalPage}" step="1"
								var="index">
							  <c:if test="${pageBean.currentPage==index}">
							   <li class="active"><a class="page-link"
									href="${pageContext.request.contextPath}/product?method=show&ptId=${param.ptId}&currentPage=${index}">${index}</a></li>
							  </c:if>
							  <c:if test="${pageBean.currentPage!=index}">
							   <li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/product?method=show&ptId=${param.ptId}&currentPage=${index}">${index}</a></li>
							  </c:if>		
							  
							</c:forEach>

							<li class="${pageBean.currentPage==pageBean.totalPage?'disabled':''}">
							<a class="page-link" href="${pageContext.request.contextPath}/product?method=show&ptId=${param.ptId}&currentPage=${pageBean.currentPage+1}">Next</a>
							</li>
						</ul>
					</nav>
				</center>
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<%@ include file="footer.jsp"%>
</body>
</html>