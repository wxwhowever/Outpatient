<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>药品库房</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>

<body>
<div id="banklist">
    <div class="tools form-inline">
        <ul class="toolbar">
            <button class="btn btn-default" id="insertBank" v-on:click="insertbank()"><img src="../images/t01.png"/>增加库房</button>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            <input id="search" class="form-control" placeholder="库房类型">
            &nbsp; &nbsp; &nbsp;
            <button class="btn btn-default" onclick="searchbank()">
            <img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
        </ul>

        <div style="float: right;">
            <button class="btn btn-default" v-on:click="queryMap()">
            <img src="../images/time.png" style="margin-top: -5px"/>刷新</button>
        </div>
    </div>

    <table class="table table-hover text-nowrap">
        <thead>
            <th>库房id<i class="sort"><img src="../images/px.gif"/></i></th>
            <th>药品类型</th>
            <th>药品数量</th>
            <th>操作</th>
        </thead>

        <tr v-for="banks in bank_list">
            <td>{{banks.bank_id}}</td>
            <td>{{banks.type_name}}</td>
            <td>{{banks.bank_count}}</td>
            <td class="toolbar" style="text-align: center">
            <button class="btn btn-default">
            <img src="../images/t02.png" v-on:click="updatebank(banks.bank_id)">修改</button>
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
        <input class="form-control" v-bind:value="currnetIndex +'/'+ maxPage" readonly="readonly" style="width: 100px;text-align: center">
        <button class="btn btn-default page">下一页</button>
        <button class="btn btn-default page " id="lastpage">末页</button>
    </div>
    <%-- 分页 end--%>

    <!-- 模态弹出框 begin -->
    <div class="modal fade" id="bankModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group form-inline">
                            <label>库房类型:</label>
                            <select class="control-label" id="typeSelect">
                                    <option v-for="types in drug_type":value="types.type_id">{{types.type_name}}</option>
                            </select>
                        </div>
                        <div class="form-group form-inline">
                            <label class="control-label">库房数量:</label>
                            <input type="text" class="form-control" id="count" v-model="bank.bank_count">
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

</div>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/vue.js"></script>
</body>

<script>
    var pageIndex = 1;
    var BankVue = new Vue({
        el: "#banklist",
        data: {
            bank_list: [],
            bank: {bank_id: "", drug_type: "", bank_count: ""},
            modalTitle: "",
            maxPage: "",
            url: "",
            currnetIndex: 1,
            drug_type:[],
        },
        methods: {
            queryMap: function () {
                var _this = this;
                $.ajax({
                    url: "../queryMap-bank.action",
                    type: "post",
                    success: function (data) {
                        _this.bank_list = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },
            //查询单个
            queryById : function (id) {
                var _this = this;
                $.ajax({
                    url : "../queryById-bank.action",
                    data :{id:id},
                    type : "post",
                    success : function(data){
                        _this.bank = data;

                    }
                })
            },
            //增加、修改
            save :function(){
                var _this = this;
                $.ajax({
                    url : _this.url,
                    data :{bank : JSON.stringify(_this.bank),
                           type : $("#typeSelect").val()
                    },
                    success : function(data){
                        _this.hideModal();//隐藏modal
                        _this.queryMap();//刷新页面
                    }
                })
            },
            insertbank : function(){
                this.modalTitle = "新建库房";//设置 modal 标题
                this.url = "../insertbank.action";//设置请求路径
                this.bank = {};//初始化
                this.selects();
                this.showModal();//调用显示modal 的方法

            },
            updatebank : function(id){
                this.modalTitle = "修改库房";//设置 modal 标题
                this.url = "../updatebank.action";//设置请求路径
                this.queryById(id);
                this.selects();
                this.showModal();//调用显示modal的方法
            },
            //隐藏模态框
            hideModal : function(){
                $("#bankModal").modal("hide");
            },
            //显示模态框
            showModal : function (){
                $("#bankModal").modal("show");
            },
            //查询类型
            selects:function () {
                var _this = this;
                $.ajax({
                    url :"../queryType.action",
                    success : function(data){
                        _this.drug_type = data;
                    }
                })
            }
        },
        created: function () {
            this.queryMap();
        }

    })

    //分页
    $(function () {
        //控制每页条数
        $(".page").click(function () {
            var selectPage = $(this).text();
            var maxPage = BankVue._data.maxPage;
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
                url: "../queryMap-bank.action",
                data: "page=" + pageIndex + "&search=" + searchValue + "&count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    BankVue._data.bank_list = data.listData;
                    BankVue._data.maxPage = data.maxPage;
                    BankVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

        //控制每页条数
        $(".pagedown").change(function () {
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url: "../queryMap-bank.action",
                data: "count=" + selectPageCount,
                type: "post",
                success: function (data) {
                    BankVue._data.bank_list = data.listData;
                    BankVue._data.maxPage = data.maxPage;
                    BankVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })


    //模糊查询的方法
    function searchbank() {
        var searchValue = $("#search").val();//得到搜索框中的值
        console.log(searchValue);
        if (searchValue != null && searchValue != "") {
            $.ajax({
                url: "../queryMap-bank.action",
                data: {search: searchValue},
                success: function (data) {
                    BankVue._data.bank_list = data.listData;
                    BankVue._data.maxPage = data.maxPage;
                }
            })
        } else {
            alert("请输入你要搜索的值");
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
