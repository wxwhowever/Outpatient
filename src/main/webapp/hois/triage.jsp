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
    <title>挂号管理</title>
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

<div id="patientList">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">分诊台管理</a></li>
            <li><a href="#">已挂号数据展示</a></li>
        </ul>
    </div>
    <div class="rightinfo">
        <div class="tools form-inline">
            <ul class="toolbar">
                <input id="search" class="form-control" placeholder="输入挂号编号或姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchPatient()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
            </ul>


        </div>

        <table class="tablelist table">
            <thead>
            <th>编号<i class="sort"><img src="../images/px.gif" /></i></th>
            <th>姓名</th>
            <th>身份证号</th>
            <th>挂号类型</th>
            <th>性别</th>
            <th>年龄</th>
            <th>职业</th>
            <th>住址</th>
            <th>联系电话</th>
            <th>挂号时间</th>
            <%--<th>就诊状态</th>--%>
            <th>操作</th>
            </thead>

            <tr v-for="patient in patient_List">
                <td>{{patient.pno}}</td>
                <td>{{patient.name}}</td>
                <td>{{patient.card}}</td>
                <td>{{patient.type}}</td>
                <td>{{patient.sex}}</td>
                <td>{{patient.age}}</td>
                <td>{{patient.profession}}</td>
                <td>{{patient.address}}</td>
                <td>{{patient.phone}}</td>
                <td>{{patient.createdate}}</td>
                            <%--<td v-if="patient.isOutpatient==1">正在就诊</td>--%>
                            <%--<td v-else>未就诊</td>--%>
                <td class="toolbar">
                    <button class="btn btn-default"><img src="../images/t02.png" v-on:click="triageInsert(patient.id)">分诊</button>
                    <button class="btn btn-default"><img src="../images/t03.png" v-on:click="deletePatient(deleteId=patient.id)"> 退号</button>
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

        <!-- 挂号模态弹出框 begin -->
        <div class="modal fade" id="patientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div style="text-align: center">
                                <select style="width: 400px;" class="triage">
                                    <option value="1">产科</option>
                                    <option value="2">口腔科</option>
                                    <option value="3">门诊治疗室</option>
                                    <option value="4">内科门诊</option>
                                    <option value="5">神经科</option>
                                    <option value="6">特需门诊</option>
                                    <option value="7">外科</option>
                                    <option value="8">卫干门诊</option>
                                    <option value="9">眼科</option>
                                    <option value="10">中医科</option>
                                    <option value="11">儿科</option>
                                </select>
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
        <!-- 挂号模态弹出框 end -->


        <!-- 退号模态弹出框 begin -->
        <div class="modal fade" id="deleteRegistrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- 退号模态弹出框 end -->


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
                <input name="" type="button"  class="sure" value="确定" v-on:click="deletePatient()"/>&nbsp;
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
    var patientVue = new Vue({
        el : "#patientList",
        data : {
            patient_List : [],
            patient : {name:"", card:"",type:"", sex:"", age:"", profession:"", address:"",createdate:"", phone:"", yyno:"", ybno:"", jzno:""},
            modalTitle : "",
            maxPage : "",
            url : "",
            currnetIndex : 1,
            deleteId:"",
            triageId:"",
        },
        methods : {
//                   查询所有的方法
            queryMap : function () {
                var _this = this;
                $.ajax({
                    url : "/queryMap-patient.action",
                    type : "post",
                    success : function(data){
                        _this.patient_List = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },
//                  查询单个
            queryById : function (id) {
                var _this = this;
                $.ajax({
                    url : "/queryById-patient.action",
                    data : {id :id},
                    type : "post",
                    success : function(data){
                        _this.patient = data;
                    }
                })
            },
//                  增加、修改
            save :function(){
                var _this = this;
//                得到分配到的科
                var triage = $(".triage").val();
                $.ajax({
                    url : _this.url,
                    data :{id : _this.triageId,triage : triage},
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
            deletePatient: function(){
                var _this = this;
                $.ajax({
                    url: "/deletePatient.action",
                    data: {id: _this.deleteId},
                    success: function (data) {
                        _this.queryMap();//刷新页面
                    }
                })
            },
            triageInsert : function(id){
                this.modalTitle = "分诊台分诊";//设置 modal 标题
                this.url = "/triageInsert.action";//设置请求路径
                this.triageId = id;
                this.showModal();//调用显示modal 的方法
            },
//                    退号，查询是否完成就诊
            unRegistration : function (id) {
                alert(id);
            },
//                    隐藏模态框
            hideModal : function(){
                $("#patientModal").modal("hide");
            },
//                    显示模态框
            showModal : function (){
                $("#patientModal").modal("show");
            },
//                    显示模态框
            showDeleteModal : function (){
                $("#deleteRegistrationModal").modal("show");
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
            var maxPage = patientVue._data.maxPage;
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
                url : "/queryMap-patient.action",
                data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                type : "post",
                success : function(data){
                    patientVue._data.patient_List = data.listData;
                    patientVue._data.maxPage = data.maxPage;
                    patientVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function(){
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url : "/queryMap-patient.action",
                data : "count="+selectPageCount,
                type : "post",
                success : function(data){
                    patientVue._data.patient_List = data.listData;
                    patientVue._data.maxPage = data.maxPage;
                    patientVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })

    //            模糊查询的方法
    function searchPatient () {
        var searchValue = $("#search").val();//得到搜索框中的值
        console.log(searchValue);
        if(searchValue != null && searchValue != ""){
            $.ajax({
                url : "/queryMap-patient.action",
                data : {search : searchValue},
                success : function(data){
                    patientVue._data.patient_List = data.listData;
                    patientVue._data.maxPage = data.maxPage;
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
