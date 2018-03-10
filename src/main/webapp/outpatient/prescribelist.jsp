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
    <title>开药清单</title>
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
<div id="prescribeList">
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
                <button class="btn btn-default" id="insertCk_info" v-on:click="insertCk_info()">
                    <img src="../images/t01.png" />新建开药单</button>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <input id="search" class="form-control" placeholder="输入医生编号或姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchCk_info()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
            </ul>


        </div>

        <table class="tablelist table">
            <thead>
            <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>患者姓名</th>
            <th>医生姓名</th>
            <th>药品名称</th>
            <th>药品规格</th>
            <th>发药数量</th>
            <th>使用方法</th>
            <th>每次用量</th>
            <th>单个金额</th>
            <th>合计</th>
            <th>备注</th>
            <th>开药时间</th>
            <th>操作</th>
            </thead>

            <tr v-for="p in prescribeParam">
                <td>{{p.pno}}</td>
                <td>{{p.patientName}}</td>
                <td>{{p.doctorName}}</td>
                <td>{{p.drugName}}</td>
                <td>{{p.drug_spec}}</td>
                <td>{{p.drugnum}}</td>
                <td>{{p.drug_use}}</td>
                <td>{{p.drug_dosage}}</td>
                <td>{{p.drug_price}}</td>
                <td>{{p.total}}</td>
                <td>{{p.remarks}}</td>
                <td>{{p.date}}</td>
                <td class="toolbar" style="text-align: center">
                    <button class="btn btn-default"><img src="../images/t02.png" v-on:click="updateCk_info(ck_info.id)">修改</button>
                    <button class="btn btn-default"><img src="../images/t03.png" v-on:click="deleteById(deleteId=ck_info.id)"> 删除</button>
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
        <div class="modal fade" id="ck_infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group form-inline">
                                <label class="control-label">姓名:</label>
                                <input type="text" class="form-control" id="name" v-model="ck_info.name">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">性别:</label>
                                <input type="text" class="form-control" id="sex" v-model="ck_info.sex">
                                <div style="float: right;">
                                    <label class="control-label">年龄:</label>
                                    <input type="text" class="form-control" id="age" v-model="ck_info.age">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label  class="control-label">职位:</label>
                                <input type="text" class="form-control" id="position" v-model="ck_info.position">
                                <div style="float: right;">
                                    <label class="control-label">科室编号:</label>
                                    <input type="text" class="form-control" id="officeno" v-model="ck_info.officeno">
                                </div>
                            </div>
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
                <input name="" type="button"  class="sure" value="确定" v-on:click="deleteCk_info()"/>&nbsp;
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
    var prescribeVue = new Vue({
        el : "#prescribeList",
        data : {
            prescribeParam : [],
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
                    url : "/resultmap.action",
                    type : "post",
                    success : function(data){
                        _this.prescribeParam = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },
//                  查询单个
            queryById : function (id) {
                var _this = this;
                $.ajax({
                    url : "/queryById-ck_info.action",
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
                    data :{ck_info : JSON.stringify(_this.ck_info)},
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
            deleteCk_info: function(){
                var _this = this;
                $.ajax({
                    url: "/deleteCk_info.action",
                    data: {id: _this.deleteId},
                    success: function (data) {
                        _this.queryMap();//刷新页面
                    }
                })
            },
            insertCk_info : function(){
                this.modalTitle = "新建银医卡";//设置 modal 标题
                this.url = "/insertCk_info.action";//设置请求路径
                this.ck_info = {};//初始化银医卡
                this.showModal();//调用显示modal 的方法
            },
            updateCk_info : function(id){
                this.modalTitle = "修改银医卡";//设置 modal 标题
                this.url = "/updateCk_info.action";//设置请求路径
                this.queryById(id);
                this.showModal();//调用显示modal 的方法
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
            var maxPage = prescribeVue._data.maxPage;
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
                url : "/resultmap.action",
                data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                type : "post",
                success : function(data){
                    prescribeVue._data.prescribeParam = data.listData;
                    prescribeVue._data.maxPage = data.maxPage;
                    prescribeVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function(){
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url : "/resultmap.action",
                data : "count="+selectPageCount,
                type : "post",
                success : function(data){
                    prescribeVue._data.prescribeParam = data.listData;
                    prescribeVue._data.maxPage = data.maxPage;
                    prescribeVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })



    //            模糊查询的方法
    function searchCk_info () {
        var searchValue = $("#search").val();//得到搜索框中的值
        if(searchValue != null && searchValue != ""){
            $.ajax({
                url : "/resultmap.action",
                data : {search : searchValue},
                success : function(data){
                    prescribeVue._data.prescribeParam = data.listData;
                    prescribeVue._data.maxPage = data.maxPage;
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

