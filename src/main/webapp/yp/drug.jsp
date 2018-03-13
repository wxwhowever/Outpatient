<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>药房药品</title>
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
<body>
    <div id="durglist">
        <div class="tools form-inline">
            <ul class="toolbar">
                <input id="search" class="form-control" placeholder="输入候诊编号或姓名查询">
                &nbsp; &nbsp; &nbsp;
                <button class="btn btn-default" onclick="searchDrug()"><img src="../images/ico06.png" style="margin-top: -5px"/>搜索</button>
            </ul>
        </div>

    <table class="tablelist table">
        <thead>
        <th>药品编号<i class="sort"><img src="../images/px.gif" /></i></th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>药品价格</th>
        <th>药品规格</th>
        <th>药品方法</th>
        <th>药品用量</th>
        <th>药品库房</th>
        <th>有效日期</th>
        </thead>

        <tr v-for="drugs in Drug_list">
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
                <button class="btn btn-default"><img src="../images/t02.png" v-on:click="updateKq_wait(kq_wait.id)">修改</button>
                <button class="btn btn-default"><img src="../images/t03.png" v-on:click="">增加</button>
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
    </div>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
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
                    DrugVue._data.kq_wait_List = data.listData;
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
                    DrugVue._data.kq_wait_List = data.listData;
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
