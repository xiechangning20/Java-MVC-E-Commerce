<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link rel="stylesheet" href="js/bootstrap.min.css" />
<script src="web/js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Address</title>
<script type="text/javascript">
	function deleteAddr(aId){
		var res = confirm("Deleting this content?");
		if(res==true){
		  location.href="${pageContext.request.contextPath}/add?method=delete&aId="+aId;
		}
	}
	function defaultAddr(aId){
		var res = confirm("Set as default address?");
		if(res==true){
			window.location.href="${pageContext.request.contextPath}/add?method=setDefault&aId="+aId;
			
		}
	}
	
	 
</script>
</head>
<body>
<%@ include file="header.jsp"%>


     
         <div class="container-md">
	         <h3>Delivery Address</h3>
	         <hr>
	         <table class="table table-striped table-hover table-bordered">
				<tr>
					<th>Id</th><th>Recipient</th>
					<th>Phone</th><th>Address</th>
					<th>Action</th>
				</tr>
				<c:forEach var="address" items="${addressList}" varStatus="i" >
					<tr>
						<Td>${i.count}</Td>
						<td>${address.aReceiver}</td>
						<td>${address.aPhone}</td>
						<td>${address.aAddress}</td>
						<td>
							<button onclick="deleteAddr(${address.aId})" class="btn btn-danger btn-sm">Delete</button>&nbsp;&nbsp;
						<%-- 	<button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal${address.aId}">Modify</button>&nbsp;&nbsp; --%>
							<!-- 弹出模态框 -->
							
							<div class="modal fade" tabindex="-1" role="dialog" id="myModal${address.aId}">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span>&times;</span>
										</button>
										<h4 class="modal-title">Modify Address</h4>
									</div>
									<form action="userAddress?flag=update" method="post" class="form-horizontal">
										<div class="motal-body">
											<div class="form-group">
												<label class="col-sm-2 control-label">Recipient</label>
												<div class="col-sm-10">
													<input type="hidden" name="id" value="${address.aId}">
													<input type="hidden" name="level" value="${address.isDefault}">
													<input type="text" name="name" class="form-control" value="${address.aReceiver}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">Phone</label>
												<div class="col-sm-10">
													<input type="text" name="phone" class="form-control" value="${address.aPhone}">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-2 control-label">Recipient</label>
												<div class="col-sm-10">
													<input type="text" name="detail" class="form-control" value="${address.aAddress}">
												</div>
											</div>
											
										</div>
										<div class="motal-footer">
											<button type="submit" class="btn btn-primary">Modify</button>
										</div>
									</form>
								</div>
							</div>
							</div>
							
							<button onclick="defaultAddr(${address.aId})" class="btn btn-primary btn-sm">Set as default</button>
							<c:if test="${address.isDefault==1}">
								<span class="badge" style="background-color:red;">Default</span>
							</c:if>
							<c:if test="${address.isDefault==0}">
								<span class="badge">Regular</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<div class="container" style="width:960px;">
		
			<form action="${pageContext.request.contextPath}/add?method=add&uId=${loginUser.uId}" method="post" class="form-horizontal">
				<div class="form-group">
				    <label class="col-sm-2 form-label">Recipient</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="aReceiver"/>
				    </div>
				</div>
		  		<div class="form-group">
				    <label class="col-sm-2 form-label">Phone</label>
				    <div class="col-sm-3">
				      <input type="text" class="form-control" name="aPhone"/>
				    </div>
				</div>	
				<div class="form-group">
					<label class="form-label">Address</label>
					<textarea rows="3" class="form-control" name="aAddress" ></textarea>	
				</div>
				<div class="form-group col-md-12">
					<input type="submit" class="btn btn-primary" value="Add address">
				</div>
				<input type="hidden" value="${loginUser.uId}" name="uid">
			</form>
	      </div>
       </div>
    </div>
</div>
</div>
	
<!-- 底部 -->
<%@ include file="footer.jsp"%>

</body>
</html>