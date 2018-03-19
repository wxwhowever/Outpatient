<%--
  Created by IntelliJ IDEA.
  User: ZhangYu
  Date: 2018-03-12
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>开药清单</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

        });
    </script>
    <style>
        b {
            display: inline-block;
            width: 20px;
            height: 18px;
            background: url(../images/msg.png);
            text-align: center;
            font-weight: normal;
            color: #fff;
            font-size: 14px;
            margin-right: 13px;
            margin-top: 7px;
            line-height: 18px;
        }
    </style>
</head>
<body>
<div id="diagnosisList">
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
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <input id="search" class="form-control" placeholder="输入医生姓名或患者姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchdiagnosis()"><img src="../images/ico06.png"
                                                                                 style="margin-top: -5px"/>搜索
                </button>
            </ul>


        </div>

        <table class="tablelist table">
            <thead>
            <th>编号<i class="sort"><img src="../images/px.gif"/></i></th>
            <th>患者姓名</th>
            <th>医生姓名</th>
            <th>诊疗结束时间</th>
            <th>开药单</th>
            <th>皮试用药单</th>
            <th>注射用药单</th>
            <th>输液用药单</th>
            <th>治疗单</th>
            </thead>

            <tr v-for="d in diagnosisParam">
                <td>{{d.drno}}</td>
                <td>{{d.patientName}}</td>
                <td>{{d.doctorName}}</td>
                <td>{{d.endDate}}</td>
                <td><a href="">开药单</a><b>{{prescribeCount}}</b></td>
                <td><a v-on:click="astdurglist(d.pid)">皮试用药单</a><b>{{ASTdrugCount}}</b></td>
                <td><a href="">注射用药单</a><b>{{injectDrugCount}}</b></td>
                <td><a href="">输液用药单</a><b>{{transfusionCount}}</b></td>
                <td><a href="">治疗单</a><b>{{treatCount}}</b></td>
            </tr>
        </table>
        <%-- 分页 begin--%>
        <div class="form-inline page-style">
            <div style="float: left;">
                <h4>每页条数:<select class="pagedown">
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                </select></h4>
            </div>
            <button class="btn btn-default page pageBackground" id="firstpage">首页</button>
            <button class="btn btn-default page">上一页</button>
            <input class="form-control" v-bind:value="currnetIndex +'/'+ maxPage" readonly="readonly"
                   style="width: 100px;text-align: center">
            <button class="btn btn-default page">下一页</button>
            <button class="btn btn-default page " id="lastpage">末页</button>
        </div>
        <%-- 分页 end--%>

        <!-- 模态弹出框 begin -->
        <div class="modal fade" id="diagnosisModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group form-inline">
                                <label class="control-label">姓名:</label>
                                <input type="text" class="form-control" id="name" v-model="diagnosis.name">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">性别:</label>
                                <input type="text" class="form-control" id="sex" v-model="diagnosis.sex">
                                <div style="float: right;">
                                    <label class="control-label">年龄:</label>
                                    <input type="text" class="form-control" id="age" v-model="diagnosis.age">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">职位:</label>
                                <input type="text" class="form-control" id="position" v-model="diagnosis.position">
                                <div style="float: right;">
                                    <label class="control-label">科室编号:</label>
                                    <input type="text" class="form-control" id="officeno" v-model="diagnosis.officeno">
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
                <span><img src="../images/ticon.png"/></span>
                <div class="tipright">
                    <p>是否确认 ？</p>
                    <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
                </div>
            </div>
            <div class="tipbtn">
                <input name="" type="button" class="sure" value="确定" v-on:click="deletediagnosis()"/>&nbsp;
                <input name="" type="button" class="cancel" value="取消"/>
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
    var diagnosisVue = new Vue({
        el: "#diagnosisList",
        data: {
            diagnosisParam: [],
            diagnosis: {jzno: "", name: "", sex: "", age: "", position: "", officeno: ""},
            modalTitle: "",
            maxPage: "",
            prescribeCount: "",
            ASTdrugCount: "",
            ASTresultCount: "",
            injectDrugCount: "",
            transfusionCount: "",
            treatCount: "",
            url: "",
            currnetIndex: 1,
            deleteId: "",
        },
        methods: {

            astdurglist: function (id) {
                location.href = "/astdrug_queryById.action?id="+id;
            },
//                   查询所有的方法
            queryMap: function () {
                var _this = this;
                $.ajax({
                    url: "/diagnosisResult.action",
                    type: "post",
                    success: function (data) {
                        _this.diagnosisParam = data.listData;
                        _this.maxPage = data.maxPage;
                        _this.prescribeCount = data.prescribeCount;
                        _this.ASTdrugCount = data.ASTdrugCount;
                        _this.injectDrugCount = data.injectDrugCount;
                        _this.transfusionCount = data.transfusionCount;
                        _this.treatCount = data.treatCount;
                    }
                })
            },

//                    隐藏模态框
            hideModal: function () {
                $("#diagnosisModal").modal("hide");
            },
//                    显示模态框
            showModal: function () {
                $("#diagnosisModal").modal("show");
            },

        },

        created: function () {
            this.queryMap();
        }
    })

    //            分页
    $(function () {
        //    控制每页条数
        $(".page").click(function () {
            var selectPage = $(this).text();
            var maxPage = diagnosisVue._data.maxPage;
            if (selectPage == "首页") {
                pageIndex = 1;
                $("#lastpage").removeClass("pageBackground");
                $("#firstpage").addClass("pageBackground");
            }
            else if (selectPage == "上一页") {
                if (pageIndex > 1) {
                    pageIndex = pageIndex - 1;
                }
                if (pageIndex == 1) {
                    $("#lastpage").removeClass("pageBackground");
                    $("#firstpage").addClass("pageBackground");
                }
            }
            else if (selectPage == "下一页") {
                if (pageIndex < maxPage) {
                    pageIndex = pageIndex + 1;
                }
                if (pageIndex == maxPage) {
                    $("#lastpage").addClass("pageBackground");
                    $("#firstpage").removeClass("pageBackground");
                }
            }
            else if (selectPage == "末页") {
                if (pageIndex != maxPage) {
                    pageIndex = maxPage;
                    $("#lastpage").addClass("pageBackground");
                    $("#firstpage").removeClass("pageBackground");
                }
            }
            var searchValue = $("#search").val();//得到搜索框中的值
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url: "/diagnosisResult.action",
                data: "page=" + pageIndex + "&search=" + searchValue + "&count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    diagnosisVue._data.diagnosisParam = data.listData;
                    diagnosisVue._data.maxPage = data.maxPage;
                    diagnosisVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function () {
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url: "/diagnosisResult.action",
                data: "count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    diagnosisVue._data.diagnosisParam = data.listData;
                    diagnosisVue._data.maxPage = data.maxPage;
                    diagnosisVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })


    //            模糊查询的方法
    function searchdiagnosis() {
        var searchValue = $("#search").val();//得到搜索框中的值
        if (searchValue != null) {
            $.ajax({
                url: "/diagnosisResult.action",
                data: {search: searchValue},
                success: function (data) {
                    diagnosisVue._data.diagnosisParam = data.listData;
                    diagnosisVue._data.maxPage = data.maxPage;
                }
            })
        }
    }


</script>


<style>
    <%--表格居中--%>
    .table tr td, .table thead th {
        text-align: center;
        line-height: 53px;
    }

    /*分页的居中*/
    .page-style {
        text-align: center;
        margin-top: 10px;
    }

    .page {
        border-color: #2aabd2;
    }

    /*每页条数*/
    .pagedown {
        border-color: #2aabd2;
        font-size: 16px;
        height: 30px;
        width: 50px;
    }

    /*分页后*/
    .pageBackground {
        background-color: #00a4ac;
    }
</style>
</html>
