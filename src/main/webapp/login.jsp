<%--
  Created by IntelliJ IDEA.
  User: WXW
  Date: 2018-01-23
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统--模板之家 www.cssmoban.com</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <%--<li><a href="#">回首页</a></li>--%>
    <%--<li><a href="#">帮助</a></li>--%>
    <%--<li><a href="#">关于</a></li>--%>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span>
    <div class="loginbox">
        <form action="/userLogin.action" method="post">
    <ul>
    <li><input name="name" id = "name" type="text" class="loginuser" placeholder="用户名"/></li>
    <li><input name="password" id = "password" type="password" class="loginpwd" placeholder="密码"/></li>
    <li><input type="submit" class="loginbtn" value="登录" onclick="login()"/></li>
    </ul>
        </form>
    </div>
    
    </div>
    

    
    <div class="loginbm">版权所有  2013  .com 仅供学习交流，勿用于任何商业用途</div>
</body>
<script>
    function login(){
        var name = $("#name").val();
        var password = $("#password").val();
        $.ajax({
            url : "/login.action",
            data : {name : name , password : password},
            dataType : "text",
            success : function(data){
                if(data=="1"){
//                    location.href="main.jsp";
//                }
//                else{
                    alert("用户名或密码错误");
                }
            }
        });
    }
</script>
</html>
