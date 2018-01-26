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
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

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
        <button class="btn btn-default" id="insertMedicalcard" v-on:click="insertMedicalcard()">
            <img src="images/t01.png" />新建就诊卡</button>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <input id="search" class="form-control" placeholder="输入就诊卡编号或姓名查询">
            &nbsp; &nbsp; &nbsp;
            <button class="btn btn-default" onclick="searchMedicalcard()"><img src="images/ico06.png"  style="margin-top: -5px"/>搜索</button>
        </ul>


    </div>
    
    <table class="tablelist table">
    	<thead>
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
        </thead>

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
            <button class="btn btn-default"><img src="images/t02.png" v-on:click="updateMedicalcard(medical.id)">修改</button>
            <button class="btn btn-default"><img src="images/t03.png" v-on:click="deleteById(medical.id)"> 删除</button>
        </td>
        </tr>
    </table>
        <%-- 分页 begin--%>
        <div class="form-inline page-style">
            <div style="float: left;">
            <h4>每页条数:<select id="pagedown">
                <option class="pagedown">10</option>
                <option class="pagedown">15</option>
                <option class="pagedown">20</option>
            </select></h4></div>
            <button class="btn btn-default page pageBackground" id="firstpage">首页</button>
            <button class="btn btn-default page">上一页</button>
            <input class="form-control" v-bind:value = "currnetIndex +'/'+ maxPage" readonly="readonly" style="width: 100px;text-align: center">
            <button class="btn btn-default page">下一页</button>
            <button class="btn btn-default page " id="lastpage">末页</button>
        </div>
        <%-- 分页 end--%>

        <!-- 模态弹出框 begin -->
        <div class="modal fade" id="medicalcardModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label  class="control-label">就诊卡编号:</label>
                                <input type="text" class="form-control" id="jzno" v-model="medicalcard.jzno">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">姓名:</label>
                                <input type="text" class="form-control" id="name" v-model="medicalcard.name">
                                <div style="float: right;">
                                <label class="control-label">密码:</label>
                                <input type="text" class="form-control" id="password" v-model="medicalcard.password">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">密码:</label>
                                <input type="text" class="form-control" id="password" v-model="medicalcard.password">
                                <div style="float: right;">
                                <label class="control-label">密码:</label>
                                <input type="text" class="form-control" id="password" v-model="medicalcard.password">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">性别:</label>
                                <input type="text" class="form-control" id="sex" v-model="medicalcard.sex">
                                <div style="float: right;">
                                <label class="control-label">年龄:</label>
                                <input type="text" class="form-control" id="age" v-model="medicalcard.age">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label  class="control-label">职业:</label>
                                <input type="text" class="form-control" id="profession" v-model="medicalcard.profession">
                                <div style="float: right;">
                                <label class="control-label">住址:</label>
                                <input type="text" class="form-control" id="address" v-model="medicalcard.address">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">余额:</label>
                                <input type="text" class="form-control" id="money" v-model="medicalcard.money">
                                <div style="float: right;">
                                <label  class="control-label">电话:</label>
                                <input type="text" class="form-control" id="phone" v-model="medicalcard.phone">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">银医卡卡号:</label>
                                <input type="text" class="form-control" id="yyno" v-model="medicalcard.yyno">
                                <div style="float: right;">
                                <label class="control-label">医保卡卡号:</label>
                                <input type="text" class="form-control" id="ybno" v-model="medicalcard.ybno">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label  class="control-label">是否预约:</label>
                                <input type="text" class="form-control" id="Subscribe" v-model="medicalcard.subscribe">
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
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认 ？</p>
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
            var pageIndex = 1;
            var medicalcardVue = new Vue({
                el : "#medicalcardList",
                data : {
                    medicalcard_List : [],
                    medicalcard : {jzno:"", name:"", password:"", card:"", sex:"", age:"", profession:"", address:"", money:"",createdate:"", phone:"", yyno:"", ybno:"", subscribe:""},
                    modalTitle : "",
                    maxPage : "",
                    url : "",
                    currnetIndex : 1,
                },
                methods : {
//                   查询所有的方法
                    queryMap : function () {
                        var _this = this;
                        $.ajax({
                            url : "/queryMap.action",
                            type : "post",
                            success : function(data){
                                _this.medicalcard_List = data.listData;
                                _this.maxPage = data.maxPage;
                            }
                        })
                    },
//                  查询单个就诊卡
                    queryById : function (id) {
                        var _this = this;
                      $.ajax({
                          url : "/queryMap.action",
                          data : {id :id},
                          type : "post",
                          success : function(data){
                              _this.medicalcard = data;
                          }
                      })
                    },
//                  增加、修改就诊卡
                    save :function(){
                        var _this = this;
                        $.ajax({
                            url : _this.url,
                            success : function(data){
                                _this.hideModal();//隐藏modal
                                _this.queryMap();//刷新页面
                            }
                        })
                    },
                    insertMedicalcard : function(){
                        this.modalTitle = "新建就诊卡";//设置 modal 标题
                        this.url = "/insertMedicalcard.action";//设置请求路径
                        this.medicalcard = {};//初始化就诊卡
                        this.showModal();//调用显示modal 的方法
                    },
                    updateMedicalcard : function(id){
                        this.modalTitle = "修改就诊卡";//设置 modal 标题
                        this.url = "/updateMedicalcard.action";//设置请求路径
                        this.queryById(id);
                        this.showModal();//调用显示modal 的方法
                    },
//                    隐藏模态框
                    hideModal : function(){
                        $("#medicalcardModal").modal("hide");
                    },
//                    显示模态框
                    showModal : function (){
                        $("#medicalcardModal").modal("show");
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
                    var maxPage = medicalcardVue._data.maxPage;
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
                    $.ajax({
                        url : "/queryMap.action",
                        data : "page="+pageIndex+"&search="+searchValue,
                        type : "post",
                        success : function(data){
                            medicalcardVue._data.medicalcard_List = data.listData;
                            medicalcardVue._data.maxPage = data.maxPage;
                            medicalcardVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                        }
                    })
                })
            })


           $(function(){
               //    控制每页条数
               $(".pagedown").click(function(){
                   var pageCount = $(this).text();
                   alert(pageCount);
               })
           })

//            模糊查询的方法
           function searchMedicalcard () {
                var searchValue = $("#search").val();//得到搜索框中的值
                alert(searchValue);
                $.ajax({
                    url : "/queryMap.action",
                    data : {search : searchValue},
                    success : function(data){
                        medicalcardVue._data.medicalcard_List = data.listData;
                        medicalcardVue._data.maxPage = data.maxPage;
                    }
                })
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
