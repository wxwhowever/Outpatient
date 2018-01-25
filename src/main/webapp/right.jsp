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
<title>建卡管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

<div id="medicalcardList">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">建卡挂号管理</a></li>
    <li><a href="#">建卡数据展示</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools form-inline">
    	<ul class="toolbar">
        <button class="btn btn-default"><img src="images/t01.png" />新建就诊卡</button>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <input id="search" class="form-control" placeholder="输入就诊卡编号或姓名查询">
            &nbsp; &nbsp; &nbsp;
            <button class="btn btn-default"><img src="images/ico06.png"  style="margin-top: -5px"/>搜索</button>
        <%--<li class="click"><span><img src="images/t01.png" /></span>添加</li>--%>
        <%--<li class="click"><span><img src="images/t02.png" /></span>修改</li>--%>
        <%--<li><span><img src="images/t03.png" /></span>删除</li>--%>
        <%--<li><span><img src="images/t04.png" /></span>统计</li>--%>

        </ul>


    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>姓名</th>
        <th>身份证号</th>
        <th>性别</th>
        <th>年龄</th>
        <th>职业</th>
        <th>住址</th>
        <th>账户余额</th>
        <th>开卡时间</th>
        <th>开卡人电话</th>
        <th>银医卡</th>
        <th>医保卡</th>
        <th>是否预约</th>
        <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <tr v-for="medical in medicalcard_List">
        <td>{{medical.jzno}}</td>
        <td>{{medical.name}}</td>
        <td>{{medical.card}}</td>
        <td>{{medical.sex}}</td>
        <td>{{medical.age}}</td>
        <td>{{medical.profession}}</td>
        <td>{{medical.address}}</td>
        <td>{{medical.money}}</td>
        <td>{{medical.createdate}}</td>
        <td>{{medical.phone}}</td>
        <td>{{medical.YYNO}}</td>
        <td>{{medical.YBNO}}</td>
        <td>{{medical.subscribe}}</td>
        <td class="toolbar">
            <a><img src="images/t02.png">修改</a>
            <a><img src="images/t03.png"> 删除</a>
        </td>
        </tr>
        </tbody>
    </table>
        <div>
            <h4>每页条数:<select id="pagedown">
            <option>10</option>
            <option>15</option>
            <option>20</option>
        </select></h4>
        </div>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页
            </div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="javascript:">1</a></li>
        <li class="paginItem current"><a href="javascript:">2</a></li>
        <li class="paginItem"><a href="javascript:">3</a></li>
        <li class="paginItem"><a href="javascript:">4</a></li>
        <li class="paginItem"><a href="javascript:">5</a></li>
        <li class="paginItem more"><a href="javascript:">...</a></li>
        <li class="paginItem"><a href="javascript:">10</a></li>
        <li class="paginItem"><a href="javascript:"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
    </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
<script src="js/bootstrap.min.js"></script>
<script src="js/vue.js"></script>
</body>
     <script>
            var medicalcardVue = new Vue({
                el : "#medicalcardList",
                data : {
                    medicalcard_List : [],
                    medicalcard:{},
                    maxPage : "",
                },
                methods : {
//                   查询所有的方法
                    queryMap : function () {
                        var _this = this;
                        $.ajax({
                            url : "/queryMap.action",
                            type : "post",
                            success : function(data){
                                console.log(data.listData)
                                _this.medicalcard_List = data.listData;
                                _this.maxPage = data.maxPage;

                                console.log(_this.medicalcard_List);
                                console.log(_this.maxPage)
                            }
                        })
                    },

                },

                created : function(){
                    this.queryMap();
                }
            })
     </script>
</html>
