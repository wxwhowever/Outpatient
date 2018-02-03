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

<div id="registrationList">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">建卡挂号管理</a></li>
    <li><a href="#">已挂号数据展示</a></li>
    </ul>
    </div>
    <div class="rightinfo">
    <div class="tools form-inline">
    	<ul class="toolbar">
        <button class="btn btn-default" id="insertRegistration" v-on:click="insertRegistration()">
            <img src="../images/t01.png" />挂号</button>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <input id="search" class="form-control" placeholder="输入挂号编号或姓名查询">
            &nbsp; &nbsp; &nbsp;
            <button class="btn btn-default" onclick="searchRegistration()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
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
        <th>银医卡</th>
        <th>就诊卡</th>
        <th>医保卡</th>
        <th>操作</th>
        </thead>

        <tr v-for="registration in registration_List">
        <td>{{registration.rsno}}</td>
        <td>{{registration.name}}</td>
        <td>{{registration.card}}</td>
            <td>{{registration.type}}</td>
        <td>{{registration.sex}}</td>
        <td>{{registration.age}}</td>
        <td>{{registration.profession}}</td>
        <td>{{registration.address}}</td>
            <td>{{registration.phone}}</td>
            <td>{{registration.createdate}}</td>
        <td>{{registration.YYNO}}</td>
        <td>{{registration.JZNO}}</td>
        <td>{{registration.YBNO}}</td>
        <td class="toolbar">
            <button class="btn btn-default"><img src="../images/t02.png" v-on:click="updateRegistration(registration.id)">修改</button>
            <button class="btn btn-default"><img src="../images/t03.png" v-on:click="deleteRegistartion(deleteId=registration.id)"> 退号</button>
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
        <div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
                                <input type="text" class="form-control" id="name" v-model="registration.name">
                                <div style="float: right;">
                                <label class="control-label">挂号类型:</label>
                                <input type="text" class="form-control" id="type" v-model="registration.type">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">性别:</label>
                                <input type="text" class="form-control" id="sex" v-model="registration.sex">
                                <div style="float: right;">
                                <label class="control-label">年龄:</label>
                                <input type="text" class="form-control" id="age" v-model="registration.age">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label  class="control-label">职业:</label>
                                <input type="text" class="form-control" id="profession" v-model="registration.profession">
                                <div style="float: right;">
                                <label class="control-label">住址:</label>
                                <input type="text" class="form-control" id="address" v-model="registration.address">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">电话:</label>
                                <input type="text" class="form-control" id="phone" v-model="registration.phone">
                                <div style="float: right;">
                                <label  class="control-label">身份证:</label>
                                <input type="text" class="form-control" id="card" v-model="registration.card">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">银医卡号:</label>
                                <input type="text" class="form-control" id="yyno" v-model="registration.yyno">
                                <div style="float: right;">
                                <label class="control-label">医保卡号:</label>
                                <input type="text" class="form-control" id="ybno" v-model="registration.ybno">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label  class="control-label">就诊卡号:</label>
                                <input type="text" class="form-control" id="jzno" v-model="registration.jzno">
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
        <input name="" type="button"  class="sure" value="确定" v-on:click="deleteRegistartion()"/>&nbsp;
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
            var registrationVue = new Vue({
                el : "#registrationList",
                data : {
                    registration_List : [],
                    registration : {name:"", card:"",type:"", sex:"", age:"", profession:"", address:"",createdate:"", phone:"", doctorcard:{yyno:""}, medicardcar:{ybno:""}, medicalcard:{jzno:""}},
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
                            url : "/queryMap-registration.action",
                            type : "post",
                            success : function(data){
                                _this.registration_List = data.listData;
                                _this.maxPage = data.maxPage;
                            }
                        })
                    },
//                  查询单个
                    queryById : function (id) {
                        var _this = this;
                      $.ajax({
                          url : "/queryById-registration.action",
                          data : {id :id},
                          type : "post",
                          success : function(data){
                              _this.registration = data;
                          }
                      })
                    },
//                  增加、修改
                    save :function(){
                        var _this = this;
                        $.ajax({
                            url : _this.url,
                            data :{registration : JSON.stringify(_this.registration)},
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
                    deleteRegistartion: function(){
                        var _this = this;
                        $.ajax({
                            url: "/deleteRegistration.action",
                            data: {id: _this.deleteId},
                            success: function (data) {
                                _this.queryMap();//刷新页面
                            }
                        })
                    },
                    insertRegistration : function(){
                        this.modalTitle = "新建挂号信息";//设置 modal 标题
                        this.url = "/insertRegistration.action";//设置请求路径
                        this.registration = {};//初始化
                        this.showModal();//调用显示modal 的方法
                    },
                    updateRegistration : function(id){
                        this.modalTitle = "修改挂号信息";//设置 modal 标题
                        this.url = "/updateRegistration.action";//设置请求路径
                        this.queryById(id);
                        this.showModal();//调用显示modal 的方法
                    },
//                    退号，查询是否完成就诊
                    unRegistration : function (id) {
                        alert(id);
                    },
//                    隐藏模态框
                    hideModal : function(){
                        $("#registrationModal").modal("hide");
                    },
//                    显示模态框
                    showModal : function (){
                        $("#registrationModal").modal("show");
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
                    var maxPage = registrationVue._data.maxPage;
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
                        url : "/queryMap-registration.action",
                        data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                        type : "post",
                        success : function(data){
                            registrationVue._data.registration_List = data.listData;
                            registrationVue._data.maxPage = data.maxPage;
                            registrationVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                        }
                    })
                })

//                控制每页条数
                $(".pagedown").change(function(){
                    var selectPageCount = $(".pagedown").val();//得到每页显示条数
                    $.ajax({
                        url : "/queryMap-registration.action",
                        data : "count="+selectPageCount,
                        type : "post",
                        success : function(data){
                            registrationVue._data.registration_List = data.listData;
                            registrationVue._data.maxPage = data.maxPage;
                            registrationVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                        }
                    })
                })
            })

//            模糊查询的方法
           function searchRegistration () {
                var searchValue = $("#search").val();//得到搜索框中的值
                console.log(searchValue);
                if(searchValue != null && searchValue != ""){
                    $.ajax({
                        url : "/queryMap-registration.action",
                        data : {search : searchValue},
                        success : function(data){
                            registrationVue._data.registration_List = data.listData;
                            registrationVue._data.maxPage = data.maxPage;
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
