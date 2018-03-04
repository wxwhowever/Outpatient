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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%--设置网页标题左边的小图标--%>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon"/>
    <title>建卡管理</title>
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
                    <img src="../images/t01.png"/>新建就诊卡
                </button>
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <input id="search" class="form-control" placeholder="输入就诊卡编号或姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchMedicalcard()"><img src="../images/ico06.png"
                                                                                   style="margin-top: -5px"/>搜索
                </button>
            </ul>

            <div style="float: right;">
                <button class="btn btn-default" v-on:click="queryMap()"><img src="../images/time.png"
                                                                             style="margin-top: -5px"/>刷新
                </button>
            </div>


        </div>

        <table class="tablelist table">
            <thead>
            <th>编号<i class="sort"><img src="../images/px.gif"/></i></th>
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
                <td>{{medical.yyno}}</td>
                <td>{{medical.ybno}}</td>
                <td>{{medical.subscribe}}</td>
                <td class="toolbar">
                    <button class="btn btn-default"><img src="../images/t02.png"
                                                         v-on:click="updateMedicalcard(medical.id)">修改
                    </button>
                    <button class="btn btn-default"><img src="../images/t03.png" v-on:click="deleteById(deleteId=medical.id)"> 退卡
                    </button>
                </td>
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
        <div class="modal fade" id="medicalcardModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                                <div id="div_name"class="form-group form-inline">
                                    <label class="control-label">姓名:</label>
                                    <input type="text" class="form-control" id="name" v-model="medicalcard.name"
                                           >
                                    <div id="div_password" style="float: right;">
                                        <label class="control-label">密码:</label>
                                        <input type="text" class="form-control" id="password" v-model="medicalcard.password"
                                               >
                                    </div>
                                </div>
                                <div id="div_sex" class="form-group form-inline">
                                        <label class="control-label">性别:</label>
                                        <input type="text" class="form-control" id="sex" v-model="medicalcard.sex"
                                              >
                                    <div id="div_age" style="float: right;">
                                        <label class="control-label">年龄:</label>
                                        <input type="text" class="form-control" id="age" v-model="medicalcard.age"
                                               >
                                    </div>
                                </div>
                                    <div id="div_profession" class="form-group form-inline">
                                        <label class="control-label">职业:</label>
                                        <input type="text" class="form-control" id="profession"
                                               v-model="medicalcard.profession" >
                                    <div id="div_address" style="float: right;">
                                        <label class="control-label">住址:</label>
                                        <input type="text" class="form-control" id="address" v-model="medicalcard.address"
                                               >
                                    </div>
                                </div>
                                <div id="div_money" class="form-group form-inline">
                                        <label class="control-label">余额:</label>
                                    <input type="text" class="form-control" id="money" v-model="medicalcard.money"
                                           >
                                    <div id="div_phone" style="float: right;">
                                        <label class="control-label">电话:</label>
                                        <input type="text" class="form-control" id="phone" v-model="medicalcard.phone"
                                               >
                                    </div>
                                </div>
                            <div class="form-group form-inline" id="div_card">
                                <label class="control-label">身份证:</label>
                                <input type="text" class="form-control" id="card" v-model="medicalcard.card"
                                       >
                                <div id="div_subscribe" style="float: right;">
                                    <label class="control-label">是否预约:</label>
                                    <input type="text" class="form-control" id="Subscribe" v-model="medicalcard.subscribe">
                                </div>
                            </div>
                            <div class="form-group form-inline">
                                    <label class="control-label">银医卡卡号:</label>
                                    <input type="text" class="form-control" id="yyno" v-model="medicalcard.yyno">
                                    <div style="float: right;">
                                        <label class="control-label">医保卡卡号:</label>
                                        <input type="text" class="form-control" id="ybno"
                                               v-model="medicalcard.ybno">
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
                <input name="" type="button" class="sure" value="确定" v-on:click="deleteMedicalcard()"/>&nbsp;
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

//    function Utils() {
//    }

//    Utils.copyFields = function (target, copyObj, cover) {
//        if (!Array.isArray(copyObj) && target instanceof Object) {
//            for (key in copyObj) {
//                if (target[key] == null || cover) target[key] = copyObj[key];
//            }
//            return target;
//        }
//        console.error("Can't copy field!");
//        return {};
//    }

    var medicalCardCopy = {
        jzno: "",
        name: "",
        password: "",
        card: "",
        sex: "",
        age: "",
        profession: "",
        address: "",
        money: "",
        createdate: "",
        phone: "",
        yyno: "",
        ybno: "",
        subscribe: ""
    }
    var pageIndex = 1;
    var medicalcardVue = new Vue({
        el: "#medicalcardList",
        data: {
            medicalcard_List: [],
            medicalcard: medicalCardCopy,
            modalTitle: "",
            maxPage: "",
            url: "",
            currnetIndex: 1,
            deleteId : "",
        },
        methods: {
//                   查询所有的方法
            queryMap: function () {
                var _this = this;
                $.ajax({
                    url: "/queryMap-medicalcard.action",
                    type: "post",
                    success: function (data) {
                        console.log(data.listData)
                        _this.medicalcard_List = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },
//                  查询单个就诊卡
            queryById: function (id) {
                var _this = this;
                $.ajax({
                    url: "/queryById-medicalcard.action",
                    data: {id: id},
                    type: "post",
                    success: function (data) {
                        _this.medicalcard = data;
                    }
                })
            },
//                  增加、修改就诊卡
            save: function () {
                var _this = this;
                $.ajax({
                    url: _this.url,
                    data: {medicalcard: JSON.stringify(_this.medicalcard)},
                    success: function (data) {
                        _this.hideModal();//隐藏modal
                        _this.queryMap();//刷新页面
                    }
                })
            },
//            退卡
            deleteById : function(id){
                $(".tip").attr("style","display:block;");
            },
            deleteMedicalcard: function(){
                var _this = this;
                $.ajax({
                    url: "/deleteMedicalcard.action",
                    data: {id: _this.deleteId},
                    success: function (data) {
                        _this.queryMap();//刷新页面
                    }
                })
            },
            insertMedicalcard: function () {
                this.modalTitle = "新建就诊卡";//设置 modal 标题
                this.url = "/insertMedicalcard.action";//设置请求路径
                this.medicalcard = {};//初始化就诊卡
                this.showModal();//调用显示modal 的方法
            },
            updateMedicalcard: function (id) {
                this.modalTitle = "修改就诊卡";//设置 modal 标题
                this.url = "/updateMedicalcard.action";//设置请求路径
                this.queryById(id);
                this.showModal();//调用显示modal 的方法
            },
//                    隐藏模态框
            hideModal: function () {
                $("#medicalcardModal").modal("hide");
            },
//                    显示模态框
            showModal: function () {
                $("#medicalcardModal").modal("show");
            },
        },
        created: function () {
            this.queryMap();
            console.log(this.medicalcard);
        }
    })

    //            分页
    $(function () {
        //    控制每页条数
        $(".page").click(function () {
            var selectPage = $(this).text();
            var maxPage = medicalcardVue._data.maxPage;
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
                url: "/queryMap-medicalcard.action",
                data: "page=" + pageIndex + "&search=" + searchValue + "&count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    medicalcardVue._data.medicalcard_List = data.listData;
                    medicalcardVue._data.maxPage = data.maxPage;
                    medicalcardVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function () {
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url: "/queryMap-medicalcard.action",
                data: "count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    medicalcardVue._data.medicalcard_List = data.listData;
                    medicalcardVue._data.maxPage = data.maxPage;
                    medicalcardVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })

    //            模糊查询的方法
    function searchMedicalcard() {
        var searchValue = $("#search").val();//得到搜索框中的值
        console.log(searchValue);
        if (searchValue != null && searchValue != "") {
            $.ajax({
                url: "/queryMap-medicalcard.action",
                data: {search: searchValue},
                success: function (data) {
                    medicalcardVue._data.medicalcard_List = data.listData;
                    console.log(medicalcardVue._data.medicalcard_List);
                    medicalcardVue._data.maxPage = data.maxPage;
                }
            })
        } else {
            alert("请输入你要搜索的值");
        }
    }

    //  名字的判断
    function nameOnblur() {
        var name = $("#name").val();
        if (name == null && name == "") {
            $("#div_name").html("<span style='color: red;'>用户名不能为空！</span>")
        }
    }

    //    密码的判断
    function passwordOnblur() {
        var password = $("#password").val();
        if (password == null && password == "") {
            $("#div_password").html("<span style='color: red;'>密码不能为空！</span>")
        }
    }

    //  性别的判断
    function sexOnblur() {
        var sex = $("#sex").val();
        if (sex == null && sex == "") {
            $("#div_sex").html("<span style='color: red;'>性别不能为空！</span>")
        }
        if (sex != "男" && sex != "女") {
            $("#div_sex").html("<span style='color: red;'>性别只能为男或女！</span>")
        }
    }

    //           年龄的判断
    function ageOnblur() {
        var age = $("#age").val();
        if (age == null && age == "") {
            $("#div_age").html("<span style='color: red;'>年龄不能为空！</span>")
        }
        if (age < 0 && age > 120) {
            $("#div_age").html("<span style='color: red;'>年龄必须在0~120岁之间！</span>")
        }
    }

    //           职业的判断
    function professionOnblur() {
        var profession = $("#profession").val();
        if (profession == null && profession == "") {
            $("#div_profession").html("<span style='color: red;'>职业不能为空！</span>")
        }
    }

    //           住址的判断
    function addressOnblur() {
        var address = $("#address").val();
        if (address == null && address == "") {
            $("#div_address").html("<span style='color: red;'>地址不能为空！</span>")
        }
    }

    //           余额的判断
    function moneyOnblur() {
        var money = $("#money").val();
        if (money < 0) {
            $("#div_money").html("<span style='color: red;'>余额不能小于0！</span>")
        }
    }

    //           电话的判断
    function phoneOnblur() {
        var phone = $("#phone").val();
        if (phone == null && phone == "") {
            $("#div_phone").html("<span style='color: red;'>电话不能为空！</span>")
        }
        if (phone.length != 11) {
            $("#div_phone").html("<span style='color: red;'>电话必须在0~11位数之间！</span>")
        }
    }//           名字的判断
    function cardOnblur() {
        var card = $("#card").val();
        if (card == null && card == "") {
            $("#div_card").html("<span style='color: red;'>身份证不能为空！</span>")
        }
        if (card.length != 18) {
            $("#div_card").html("<span style='color: red;'>身份证必须是18位数！</span>")
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
