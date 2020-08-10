<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery.validate.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/Login-register.css">

<title>Login</title>
<script type="text/javascript">

</script>

<!-- validate form authentication-->
<script type="text/javascript" >
  $(function(){
	  $("#userLogin").validate({
		  rules:{
			  username:"required",
			  password:"required"
		  },
		  messages:{
			  username:"Username required!",
			  password:"Password required!"
		  }
		  
	  })
  
  })
 
</script>

</head>
<body>
    <div class="container-sm" style="margin-top: 100px;">
     <div class="row">
      <div class="col-sm">
       <div class="register-div" >
       <div class="register-center"> 
        <div class="register-top">
          <div class="top-left"><a href="${pageContext.request.contextPath }/web/index.jsp">ClayMusicShop</a></div> 
          <div class="top-right"><a href="${pageContext.request.contextPath}/web/register.jsp">Do not have an account?Register here</a></div>  
        </div>   
        
         <form action="${pageContext.request.contextPath}/user?method=login" method="post" class="form center" id="userLogin">
            <div class="form-group">
                <label for="exampleInputPassword1">Username</label>
                <input type="username" name="username" class="form-control" id="exampleInputPassword1">
              </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <input type="password" name="password" class="form-control" id="exampleInputPassword1">
            </div>
            
            <div class="form-group">
                <input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;Auto-login within two month
						<span id="autoLoginMsg"></span>
            </div>
            
            <button type="submit" class="btn btn-primary">Submit</button>
            <span style="color:red">${msg}</span>
          </form>
        
       </div> 
      </div>
      </div>
     </div>
    </div>
		<%-- <!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${pageContext.request.contextPath }/index.jsp" target="_blank"><img src="/Myshop/web/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  action="${pageContext.request.contextPath}/user?method=login" method="post" class="form center" id="userLogin" >
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="${pageContext.request.contextPath }/Myshop/web/register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">
						<div class="left fl">用户名:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="text" name="username" id="username"  placeholder="请输入你的用户名"/>
						<label id="nameMsg"></label>
						</div>
					</div>
					<div class="username">
						<div class="left fl">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="password" name="password"  id="pwd"  placeholder="请输入你的密码"/>	
						</div>
					</div>
					<!-- <div class="username">
						<div class="left fl">验证码:&nbsp;</div>
						<div class="right fl"><input class="yanzhengma" id="vcode" type="text" placeholder="验证码"/>
						<img  id="pagecode" src="code"><label id="checkMsg"></label></div>					
					</div> -->
					<div class="username">
						<div class="left fl">&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="right fl"><label id="checkMsg"></label></div>
					</div>
					<div class="username">
						<input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
						<span id="autoLoginMsg"></span>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录" id="btn" >
					</div>
					<span style="color:red">${msg}</span>
				</div>	
			</div>
		</div>
		</form> --%>
		
	</body>
</html>