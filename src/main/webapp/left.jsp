<%--
  Created by IntelliJ IDEA.
  User: WXW
  Date: 2018-01-23
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>门急诊系统</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>建卡挂号管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="right.jsp" target="rightFrame">就诊卡管理</a><i></i></li>
        <li><cite></cite><a href="registration.jsp" target="rightFrame">挂号管理</a><i></i></li>
        <li><cite></cite><a href="patient.jsp" target="rightFrame">病人管理</a><i></i></li>
        <li><cite></cite><a href="medical.jsp" target="rightFrame">病案管理</a><i></i></li>
        <li><cite></cite><a href="medicarecard.jsp" target="rightFrame">医保卡</a><i></i></li>
        <li><cite></cite><a href="doctorcard.jsp" target="rightFrame">银医卡</a><i></i></li>
        </ul>
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>分诊叫号管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#">产科门诊</a><i></i></li>
        <li><cite></cite><a href="#">外科门诊</a><i></i></li>
        <li><cite></cite><a href="#">卫干门诊</a><i></i></li>
        <li><cite></cite><a href="#">卫干门诊</a><i></i></li>
        <li><cite></cite><a href="imglist.jsp" target="rightFrame">口腔科门诊</a><i></i></li>
        <li><cite></cite><a href="imglist1.jsp" target="rightFrame">门诊治疗室</a><i></i></li>
        <li><cite></cite><a href="tools.jsp" target="rightFrame">神经科门诊</a><i></i></li>
        <li><cite></cite><a href="filelist.jsp" target="rightFrame">特需门诊</a><i></i></li>
        <li><cite></cite><a href="tab.jsp" target="rightFrame">眼科门诊</a><i></i></li>
        <li><cite></cite><a href="#">中医门诊</a><i></i></li>
        <li><cite></cite><a href="#">儿科门诊</a><i></i></li>
        <li><cite></cite><a href="error.jsp" target="rightFrame">404页面</a><i></i></li>
    </ul>
    </dd>
    
    
    <dd><div class="title"><span><img src="images/leftico03.png" /></span>门诊处置治疗管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>药房管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
</body>
</html>
