<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>药房药品</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>

<body>
    <div id="durglist">
        <div class="tools form-inline">
            <ul class="toolbar">
                <input id="search" class="form-control" placeholder="请输入药品名或药品类型">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchDrug()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
            </ul>

            <div style="float: right;">
                <button class="btn btn-default" v-on:click="queryMap()"><img src="../images/time.png" style="margin-top: -5px"/>刷新
                </button>
            </div>

        </div>

    <table class="table table-hover text-nowrap">
        <thead>
        <th>药品id</th>
        <th>药品编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>药品价格</th>
        <th>药品规格</th>
        <th>药品方法</th>
        <th>药品用量</th>
        <th>药品库房</th>
        <th>有效日期</th>
        <th>操作</th>
        </thead>

        <tr v-for="drugs in Drug_list">
            <td>{{drugs.drug_id}}</td>
            <td>{{drugs.drug_dno}}</td>
            <td>{{drugs.drug_name}}</td>
            <td>{{drugs.type_name}}</td>
            <td>{{drugs.drug_price}}</td>
            <td>{{drugs.drug_spec}}</td>
            <td>{{drugs.drug_use}}</td>
            <td>{{drugs.drug_dosage}}</td>
            <td>{{drugs.bank_count}}</td>
            <td>{{drugs.drug_time}}</td>
            <td class="toolbar" style="text-align: center">
                <button class="btn btn-default"><img src="../images/t02.png" v-on:click="updatedrug(drugs.drug_id)">修改</button>
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
        <div class="modal fade" id="drugModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">{{modalTitle}}</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group form-inline">
                                <label class="control-label">药品名称:</label>
                                <input type="text" class="form-control" id="drug_name" v-model="Drug.drug_name">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">药品价格:</label>
                                <input type="text" class="form-control" id="drug_price" v-model="Drug.drug_price">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">药品规格:</label>
                                <input type="text" class="form-control" id="drug_spec" v-model="Drug.drug_spec">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">药品方法:</label>
                                <input type="text" class="form-control" id="drug_use" v-model="Drug.drug_use">
                            </div>
                            <div class="form-group form-inline">
                                <label class="control-label">药品用量:</label>
                                <input type="text" class="form-control" id="drug_dosage" v-model="Drug.drug_dosage">
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
    var pageIndex=1;
    var DrugVue=new Vue({
        el:"#durglist",
        data:{
            Drug_list:[],
            Drug:{drug_id:"",drug_dno:"",drug_name:"",type_name:"",drug_price:"",drug_spec:"",drug_use:"",drug_dosage:"",bank_count:"",drug_time:""},
            modalTitle:"",
            maxPage:"",
            url:"",
            currnetIndex:1,

        },
        methods:{
            queryMap:function () {
                var _this=this;
                $.ajax({
                    url:"../queryMap-drug.action",
                    type:"post",
                    success:function (data) {
                        _this.Drug_list = data.listData;
                        _this.maxPage = data.maxPage;
                    }
                })
            },
            //查询单个
            queryById : function (id) {
                var _this = this;
                $.ajax({
                    url : "../queryById-drug.action",
                    data :{id:id},
                    type : "post",
                    success : function(data){
                        _this.Drug = data;
                    }
                })
            },
            //修改
            save :function(){
                var _this = this;
                $.ajax({
                    url : _this.url,
                    data :{drug : JSON.stringify(_this.Drug)},
                    success : function(data){
                        _this.hideModal();//隐藏modal
                        _this.queryMap();//刷新页面
                    }
                })
            },
            updatedrug : function(id){
                this.modalTitle = "修改药品";//设置 modal 标题
                this.url = "../updateDrug.action";//设置请求路径
                this.queryById(id);
                this.showModal();//调用显示modal的方法
            },
            //隐藏模态框
            hideModal : function(){
                $("#drugModal").modal("hide");
            },
            //显示模态框
            showModal : function (){
                $("#drugModal").modal("show");
            }

        },

        created:function () {
            this.queryMap();
        }

    })

    //分页
    $(function(){
        //控制每页条数
        $(".page").click(function(){
            var selectPage = $(this).text();
            var maxPage = DrugVue._data.maxPage;
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
                url : "../queryMap-drug.action",
                data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                type : "post",
                success : function(data){
                    DrugVue._data.Drug_list = data.listData;
                    DrugVue._data.maxPage = data.maxPage;
                    DrugVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

        //控制每页条数
        $(".pagedown").change(function(){
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url : "../queryMap-drug.action",
                data : "count="+selectPageCount,
                type : "post",
                success : function(data){
                    DrugVue._data.Drug_list = data.listData;
                    DrugVue._data.maxPage = data.maxPage;
                    DrugVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })



    //模糊查询的方法
    function searchDrug () {
        var searchValue = $("#search").val();//得到搜索框中的值
        console.log(searchValue);
        if(searchValue != null && searchValue != ""){
            $.ajax({
                url : "../queryMap-drug.action",
                data : {search : searchValue},
                success : function(data){
                    DrugVue._data.Drug_list = data.listData;
                    DrugVue._data.maxPage = data.maxPage;
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
