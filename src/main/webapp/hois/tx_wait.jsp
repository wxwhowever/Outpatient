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
<title>特需门诊分诊</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>

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
<div id="tx_waitList">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">分诊叫号管理</a></li>
    <li><a href="#">神经科分诊</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools form-inline">
    	<ul class="toolbar">
            <input id="search" class="form-control" placeholder="输入候诊编号或姓名查询">
            &nbsp; &nbsp; &nbsp;
            <button class="btn btn-default" onclick="searchTx_wait()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
        </ul>


    </div>
    
    <table class="tablelist table">
    	<thead>
        <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>病人编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>患病类型</th>
        <th>患病描述</th>
        <th>患病等级</th>
        <th>候诊时间</th>
        <th>就诊卡号</th>
        <th>分诊人</th>
        <th>操作</th>
        </thead>

        <tr v-for="tx_wait in tx_wait_List">
            <td>{{tx_wait.wno}}</td>
            <td>{{tx_wait.pno}}</td>
            <td>{{tx_wait.name}}</td>
            <td>{{tx_wait.sex}}</td>
            <td>{{tx_wait.age}}</td>
            <td>{{tx_wait.type}}</td>
            <td>{{tx_wait.remark}}</td>
            <td>{{tx_wait.level}}</td>
            <td>{{tx_wait.date}}</td>
            <td>{{tx_wait.jzno}}</td>
            <td>{{tx_wait.dno}}</td>
            <td class="toolbar" style="text-align: center">
                <button class="btn btn-default"><img src="../images/t02.png" v-on:click="updateTx_wait(tx_wait.id)">队列调整</button>
                <button class="btn btn-default"><img src="../images/t03.png" v-on:click="deleteById(deleteId=tx_wait.id)"> 完成就诊</button>
            </td>
            </tr>
    </table>
        <%-- 分页 begin--%>
        <div class="form-inline page-style">
            <div style="float: left;">
            <h4>每页条数:<select class="pagedown" >
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
            </select></h4></div>
            <button class="btn btn-default page pageBackground" id="firstpage">首页</button>
            <button class="btn btn-default page">上一页</button>
            <input class="form-control" v-bind:value = "currnetIndex +'/'+ maxPage" readonly="readonly" style="width: 100px;text-align: center">
            <button class="btn btn-default page">下一页</button>
            <button class="btn btn-default page " id="lastpage">末页</button>
        </div>
        <%-- 分页 end--%>

        <!-- 模态弹出框 begin -->
        <div class="modal fade" id="tx_waitModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 模态弹出框 end -->

    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="../images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" v-on:click="deleteTx_wait()"/>&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    </div>
    </div>
</div>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/vue.js"></script>
</body>
     <script>
            var pageIndex = 1;
            var tx_waitVue = new Vue({
                el : "#tx_waitList",
                data : {
                    tx_wait_List : [],
                    tx_wait : {pno:"", name:"", height:"", weight:"", dno:"", jzno:""},//产科信息记录
                    modalTitle : "",
                    maxPage : "",
                    url : "",
                    currnetIndex : 1,
                    deleteId:"",
                },
                methods : {
//                   查询所有的方法
                    queryMap : function () {
                        var _this = this;
                        $.ajax({
                            url : "/queryMap-tx_wait.action",
                            type : "post",
                            success : function(data){
                                _this.tx_wait_List = data.listData;
                                _this.maxPage = data.maxPage;
                            }
                        })
                    },
//                  查询单个
                    queryById : function (id) {
                        var _this = this;
                      $.ajax({
                          url : "/queryById-tx_wait.action",
                          data : {id :id},
                          type : "post",
                          success : function(data){
                              _this.doctor = data;
                          }
                      })
                    },
//                  增加、修改
                    save :function(){
                        var _this = this;
                        $.ajax({
                            url : _this.url,
                            data :{tx_wait : JSON.stringify(_this.tx_wait)},
                            success : function(data){
                                _this.hideModal();//隐藏modal
                                _this.queryMap();//刷新页面
                            }
                        })
                    },
                    //            退卡
                    deleteById : function(id){
                        $(".tip").attr("style","display:block;");
                    },
                    deleteTx_wait: function(){
                        var _this = this;
                        $.ajax({
                            url: "/deleteTx_wait.action",
                            data: {id: _this.deleteId},
                            success: function (data) {
                                _this.queryMap();//刷新页面
                            }
                        })
                    },
                    insertTx_wait : function(){
                        this.modalTitle = "记录病人信息";//设置 modal 标题
                        this.url = "/insertTx_wait.action";//设置请求路径
                        this.tx_wait = {};//初始化银医卡
                        this.showModal();//调用显示modal 的方法
                    },
                    updateSj_wait : function(id){
                        this.modalTitle = "修改银医卡";//设置 modal 标题
                        this.url = "/updateTx_wait.action";//设置请求路径
                        this.queryById(id);
                        this.showModal();//调用显示modal 的方法
                    },
//                    隐藏模态框
                    hideModal : function(){
                        $("#tx_waitModal").modal("hide");
                    },
//                    显示模态框
                    showModal : function (){
                        $("#tx_waitModal").modal("show");
                    },

                },

                created : function(){
                    this.queryMap();
                }
            })

//            分页
            $(function(){
                //    控制每页条数
                $(".page").click(function(){
                    var selectPage = $(this).text();
                    var maxPage = tx_waitVue._data.maxPage;
                    if(selectPage == "首页"){
                        pageIndex = 1;
                        $("#lastpage").removeClass("pageBackground");
                        $("#firstpage").addClass("pageBackground");
                    }
                    else if(selectPage == "上一页"){
                        if(pageIndex > 1){
                            pageIndex = pageIndex - 1;
                        }
                       if(pageIndex == 1){
                            $("#lastpage").removeClass("pageBackground");
                            $("#firstpage").addClass("pageBackground");
                        }
                    }
                    else if(selectPage == "下一页"){
                        if(pageIndex < maxPage){
                            pageIndex = pageIndex + 1;
                        }
                        if(pageIndex == maxPage){
                            $("#lastpage").addClass("pageBackground");
                            $("#firstpage").removeClass("pageBackground");
                        }
                    }
                    else if(selectPage == "末页"){
                        if(pageIndex !=  maxPage){
                            pageIndex = maxPage;
                            $("#lastpage").addClass("pageBackground");
                            $("#firstpage").removeClass("pageBackground");
                        }
                    }
                    var searchValue = $("#search").val();//得到搜索框中的值
                    var selectPageCount = $(".pagedown").val();//得到每页显示条数
                    $.ajax({
                        url : "/queryMap-tx_wait.action",
                        data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                        type : "post",
                        success : function(data){
                            tx_waitVue._data.tx_wait_List = data.listData;
                            tx_waitVue._data.maxPage = data.maxPage;
                            tx_waitVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                        }
                    })
                })

//                控制每页条数
                $(".pagedown").change(function(){
                    var selectPageCount = $(".pagedown").val();//得到每页显示条数
                    $.ajax({
                        url : "/queryMap-tx_wait.action",
                        data : "count="+selectPageCount,
                        type : "post",
                        success : function(data){
                            tx_waitVue._data.tx_wait_List = data.listData;
                            tx_waitVue._data.maxPage = data.maxPage;
                            tx_waitVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                        }
                    })
                })
            })



//            模糊查询的方法
           function searchTx_wait () {
                var searchValue = $("#search").val();//得到搜索框中的值
                if(searchValue != null && searchValue != ""){
                    $.ajax({
                        url : "/queryMap-tx_wait.action",
                        data : {search : searchValue},
                        success : function(data){
                            tx_waitVue._data.tx_wait_List = data.listData;
                            tx_waitVue._data.maxPage = data.maxPage;
                        }
                    })
                }else{
                    alert("请输入你要搜索的值");
                }
           }

     </script>



<style>
    <%--表格居中--%>
    .table tr td ,.table thead th{
        text-align: center;
        line-height: 53px;
    }
    /*分页的居中*/
    .page-style{
        text-align: center;
        margin-top: 10px;
    }
    .page{
        border-color: #2aabd2;
    }
    /*每页条数*/
    .pagedown{
        border-color: #2aabd2;
        font-size: 16px;
        height: 30px;
        width: 50px;
    }
    /*分页后*/
    .pageBackground{
        background-color: #00a4ac;
    }
</style>
</html>
