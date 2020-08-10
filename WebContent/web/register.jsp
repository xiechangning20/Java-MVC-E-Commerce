<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/Login-register.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.validate.js"></script>
		
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
	
	 function check(){
       //定义 xhr对象
       var v = document.getElementById("username").value;
       var xhr = new XMLHttpRequest();
       xhr.onreadystatechange = function(ev){
       	  
             if(xhr.readyState == 4 && xhr.status == 200){
             	var check = xhr.responseText;
             	console.log(check);
             	if(check == 1){
             		document.getElementById("usernameMsg").innerText="username already exsist!";
             		document.getElementById("usernameMsg").style.color = "red";
             	}else{
             		document.getElementById("usernameMsg").innerText="username is available!";
             		document.getElementById("usernameMsg").style.color = "green";
             		$("#RegisterSubmit").removeAttr("disabled");
             		
             	}
             }

        }

        xhr.open("get","${pageContext.request.contextPath}/user?method=checkUname&username="+v,true);
        xhr.send();

	 }
	 
	 function eMsg(){
		 document.getElementById("eMsg").innerText="Please wait for a few seconds before we set up the email environment.";
		 document.getElementById("eMsg").style.color = "red";
		 
		 
	 }


</script>

<script type="text/javascript">
/* check input info */

 
   $(function(){
	  $("#Register").validate({
		  rules:{
			  uName:"required",
			  uPassword:{"required":true,"digits":true,"rangelength":[5,10]},
			  rePassword:{equalTo:"#uPassword"},
			  uEmail:{"email":true,"required":true}
		  },
		  messages:{
			  uName:"Username required!",
			  uPassword:"Pleas enter digits between 5-10 characters length!"
		  }
		  
	  })
  
  })
</script>

<title>Register</title>
</head>
<body> 
   <div class="container-sm" style="margin-top: 100px;">
      <div class="register-div" >
       <div class="register-center"> 
        <div class="register-top">
          <div class="top-left"><a href="${pageContext.request.contextPath}/web/index.jsp">ClayMusicShop</a></div> 
          <div class="top-right"><a href="${pageContext.request.contextPath}/web/login.jsp">Already registered?Login here</a></div>  
        </div>   
        
         <form action="${pageContext.request.contextPath}/user?method=register" method="post" id="Register">
            <div class="form-group">
                <label for="exampleInputPassword1" >Username</label>
                <input type="username" id="username" name="uName"   class="form-control" onchange = "check()">
              </div>
              <div class="col-sm-2">
						<p class="text-danger"><span class="help-block " id="usernameMsg" ></span></p>
						</div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" class="form-control" id="uPassword" name="uPassword">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Confirm Password</label>
                <input type="password" class="form-control" name="rePassword">
              </div>
            <div class="form-group" >
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" name="uEmail" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">We'll send you an email for activation.</small>
              </div>
            
            <button type="submit" id ="RegisterSubmit"class="btn btn-primary" onclick="eMsg();"  disabled>Submit</button>
            <div>
            <span id="eMsg"></span>
            </div>
          </form>
        
       </div> 
      </div>

    </div>

   
	<%-- <div class="regist">
		<div class="regist_center">
			<div class="regist_top">
				<div class="left fl"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;会员注册</div>
				<div class="right fr">
					<a href="index.jsp" target="_black">小米商城</a>
				</div>
				<div class="clear"></div>
,				<div class="xian center"></div>
			</div>
			<div class="center-block" style="margin-top: 80px;">
				<form class="form-horizontal" action="${pageContext.request.contextPath}/user?method=register" method="post" id="Register">

					<div class="form-group">
						<label class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="text" id="username" name="uName" class="form-control col-sm-10"
								placeholder="Username" onchange = "check()"/>
						</div>
						<div class="col-sm-2">
						<p class="text-danger"><span class="help-block " id="usernameMsg" ></span></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password" name="uPassword" id="uPassword"
								class="form-control col-sm-10" placeholder="Password" />
						</div>
						<div class="col-sm-2">
						<!-- <p class="text-danger"><span id="helpBlock" class="help-block ">请不输入6位以上字符</span></p> -->
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="password"  class="form-control col-sm-10" name="rePassword"
								placeholder="Password Again" />
						</div>
						<div class="col-sm-2">
						<!-- <p class="text-danger"><span id="helpBlock" class="help-block ">两次密码要输入一致哦</span></p> -->
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-8" style="width: 40%">
							<input type="text" name="uEmail" class="form-control col-sm-10"
								placeholder="Email" />
						</div>
						<div class="col-sm-2">
						<!-- <p class="text-danger"><span id="helpBlock" class="help-block ">填写正确邮箱格式</span></p> -->
						</div>
					</div>
					
					<hr>
					<div class="form-group">
						<div class="col-sm-7 col-sm-push-2">
							<input id="registerBtn" type="submit" value="注册" class="btn btn-primary  btn-lg" style="width: 200px;" disabled/> &nbsp; &nbsp;
							<input type="reset" value="重置" class="btn btn-default  btn-lg" style="width: 200px;"  />
						</div>
					</div>
					<div>${registerMsg}</div>
				</form> --%>

			</div>
		</div>
	</div>
	
</body>
</html>