<%--
  Created by IntelliJ IDEA.
  User: ZhangYu
  Date: 2018-03-09
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>皮试结果单</title>
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
<div id="ASTresultList">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">门诊处置治疗管理</a></li>
            <li><a href="#">开药清单管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
        <div class="tools form-inline">
            <ul class="toolbar">
                <input id="search" class="form-control" placeholder="输入医生编号或姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchCk_info()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
            </ul>


        </div>

        <table class="tablelist table">
            <thead>
            <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>患者姓名</th>
            <th>皮试操作人</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>皮试结果</th>
            </thead>

            <tr v-for="a in ASTresultParam">
                <td>{{a.pno}}</td>
                <td>{{a.patientName}}</td>
                <td>{{a.doctorName}}</td>
                <td>{{a.starttime}}</td>
                <td>{{a.endtime}}</td>
                <td>{{a.result}}</td>
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
    var ASTresultVue = new Vue({
        el : "#ASTresultList",
        data : {
            ASTresultParam : [],
            ck_info : {jzno:"", name:"", sex:"", age:"", position:"", officeno:""},
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
                    url : "/astresult_resultmap.action",
                    type : "post",
                    success : function(data){
                        _this.ASTresultParam = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },


//                    隐藏模态框
            hideModal : function(){
                $("#ck_infoModal").modal("hide");
            },
//                    显示模态框
            showModal : function (){
                $("#ck_infoModal").modal("show");
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
            var maxPage = ASTresultVue._data.maxPage;
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
                url : "/astresult_resultmap.action",
                data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                type : "post",
                success : function(data){
                    ASTresultVue._data.ASTresultParam = data.listData;
                    ASTresultVue._data.maxPage = data.maxPage;
                    ASTresultVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function(){
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url : "/astresult_resultmap.action",
                data : "count="+selectPageCount,
                type : "post",
                success : function(data){
                    ASTresultVue._data.ASTresultParam = data.listData;
                    ASTresultVue._data.maxPage = data.maxPage;
                    ASTresultVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })



    //            模糊查询的方法
    function searchCk_info () {
        var searchValue = $("#search").val();//得到搜索框中的值
        if(searchValue != null && searchValue != ""){
            $.ajax({
                url : "/astresult_resultmap.action",
                data : {search : searchValue},
                success : function(data){
                    ASTresultVue._data.ASTresultParam = data.listData;
                    ASTresultVue._data.maxPage = data.maxPage;
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

