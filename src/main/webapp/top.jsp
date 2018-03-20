﻿<%--
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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">
<div id = "powerVue">
    <div class="topleft">
    <a href="main.jsp" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
    <ul class="nav">
    <li><a href="hois/triage.jsp" target="rightFrame" class="selected"><img src="images/icon01.png" title="分诊台" /><h2>分诊台</h2></a></li>
    <li><a href="hois/doctor.jsp" target="rightFrame"><img src="images/icon02.png" title="医生管理" /><h2>医生管理</h2></a></li>
    <li><a href="imglist.jsp" target="rightFrame"><img src="images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
    <li><a href="tools.jsp" target="rightFrame"><img src="images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
    <li><a href="computer.jsp" target="rightFrame"><img src="images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
    <li><a href="tab.jsp" target="rightFrame"><img src="images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    </ul>

    <div class="topright">
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="login.jsp" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">亲爱的
    <span v-html="username" style="color: red"></span>，欢迎您!
    <%--<i>消息</i>--%>
    <%--<b>5</b>--%>
    </div>    
    
    </div>
</div>
</body>
<script src="js/vue.js"></script>
<script>

    var powerVue = new Vue({
        el : "#powerVue",
        data : {
            powerList : [],
            username : "",
        },
        methods : {
            query : function () {
                var _this = this;
                $.ajax({
                    url : "/powerList.action",
                    dataType : "JSON",
                    success : function(data){
                        _this.powerList = $.parseJSON(data);
                        $.each($.parseJSON(data),function (index,obj) {
                            _this.username = obj.name;
                        })
                    }
                })

            }
        },
        created:function () {
            this.query();
        }
    })

</script>
</html>
