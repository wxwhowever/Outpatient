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
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="..//js/jquery.js"></script>

<script type="text/javascript">
$(function(){

	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
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
<div id="powerVue">
	<div class="lefttop"><span></span>门急诊系统</div>
    
    <dl class="leftmenu">



        <dd id="jkgamanager" style="display : none">
            <div class="title">
                <span><img src="images/leftico01.png" /></span>建卡挂号管理
            </div>
            <ul class="menuson">
                <li class="active"><cite></cite><a href="registration/medicalcard.jsp" target="rightFrame">就诊卡管理</a><i></i></li>
                <li><cite></cite><a href="registration/registration.jsp" target="rightFrame">挂号管理</a><i></i></li>
                <li><cite></cite><a href="registration/patient.jsp" target="rightFrame">病人管理</a><i></i></li>
                <li><cite></cite><a href="registration/medical.jsp" target="rightFrame">病案管理</a><i></i></li>
                <li><cite></cite><a href="registration/medicarecard.jsp" target="rightFrame">医保卡</a><i></i></li>
                <li><cite></cite><a href="registration/doctorcard.jsp" target="rightFrame">银医卡</a><i></i></li>
            </ul>
        </dd>

    <dd id="fzjhmanager" style="display : none">
    <div class="title">
    <span><img src="images/leftico02.png" /></span>分诊叫号管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="hois/ck_wait.jsp" target="rightFrame">产科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/kq_wait.jsp" target="rightFrame">口腔科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/mz_wait.jsp" target="rightFrame">门诊治疗室</a><i></i></li>
        <li><cite></cite><a href="hois/nk_wait.jsp" target="rightFrame">内科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/sj_wait.jsp" target="rightFrame">神经科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/wk_wait.jsp" target="rightFrame">外科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/wg_wait.jsp" target="rightFrame">卫干门诊</a><i></i></li>
        <li><cite></cite><a href="hois/tx_wait.jsp" target="rightFrame">特需门诊</a><i></i></li>
        <li><cite></cite><a href="hois/yk_wait.jsp" target="rightFrame">眼科门诊</a><i></i></li>
        <li><cite></cite><a href="hois/zy_wait.jsp" target="rightFrame">中医门诊</a><i></i></li>
        <li><cite></cite><a href="hois/ek_wait.jsp" target="rightFrame">儿科门诊</a><i></i></li>
        <li><cite></cite><a href="error.jsp" target="rightFrame">404页面</a><i></i></li>
    </ul>
    </dd>


    <dd id="mzczmanager" style="display : none"><div class="title">
        <span><img src="images/leftico03.png" /></span>门诊处置治疗管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="outpatient/diagnosisResult.jsp" target="rightFrame">诊疗结果单详情</a><i></i></li>
        <li><cite></cite><a href="outpatient/prescribe.jsp" target="rightFrame">开药清单管理</a><i></i></li>
        <li><cite></cite><a href="outpatient/ASTdrug.jsp" target="rightFrame">皮试用药单管理</a><i></i></li>
        <li><cite></cite><a href="outpatient/injectdrug.jsp" target="rightFrame">注射用药单管理</a><i></i></li>
        <li><cite></cite><a href="outpatient/transfusion.jsp" target="rightFrame">输液用药单管理</a><i></i></li>
        <li><cite></cite><a href="outpatient/treat.jsp" target="rightFrame">治疗单管理</a><i></i></li>
    </ul>
    </dd>


    <dd id="yfmanager" style="display : none"><div class="title"><span><img src="images/leftico04.png" /></span>药房管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="yp/bank.jsp" target="rightFrame">药品库房</a><i></i></li>
        <li><cite></cite><a href="yp/drug.jsp" target="rightFrame">药品信息</a><i></i></li>
        <li><cite></cite><a href="yp/drug.jsp" target="rightFrame">购药记录</a><i></i></li>
        <li><cite></cite><a href="yp/drug.jsp" target="rightFrame">退药记录</a><i></i></li>
    </ul>
    </dd>
    
    </dl>
</div>


</body>

<script src="js/vue.js"></script>
<script>
    var powerVue = new Vue({
        el : "#powerVue",
        data : {
            powerList : [],
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
                            if(obj.pname == "建卡挂号管理"){
                                $("#jkgamanager").css('display','block');
                            }
                            if(obj.pname == "分诊叫号管理"){
                                $("#fzjhmanager").css('display','block');
                            }
                            if(obj.pname == "门诊处置治疗管理"){
                                $("#mzczmanager").css('display','block');
                            }
                            if(obj.pname == "药房管理"){
                                $("#yfmanager").css('display','block');
                            }
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
