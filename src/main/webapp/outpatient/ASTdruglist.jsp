<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
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
<div id="astdrugList">
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">门诊处置治疗管理</a></li>
            <li><a href="#">皮试用药单管理</a></li>
        </ul>
    </div>
    <div style=" text-align: center;">
            <table style="margin: auto; margin-top: 50px; border-collapse: separate; border-spacing: 25px; font-size: 30px">
                <tr>
                    <td style="display: none">${map.id}</td>
                    <td>编号：${map.skinno}</td>
                    <td>患者姓名：${map.patientName}</td>
                </tr>
                <tr>
                    <td>医生姓名：${map.doctorName}</td>
                    <td>药品名称：${map.drugName}</td>
                </tr>
                <tr>
                    <td>试敏溶液浓度：${map.mmol}</td>
                    <td>剂量：${map.drugnum}</td>
                </tr>
                <tr>
                    <td>合计：${map.total}</td>
                    <td>备注：${map.remarks}</td>
                </tr>
                <tr>
                    <td>开药时间：${map.date}</td>
                    <td>治疗状态：待治疗</td>
                </tr>
                <tr>
                    <td><button  data-toggle="modal" data-target="#myModal" class="btn btn-info dropdown-toggle"><img src="../images/t02.png">记录结果</button></td>
                    <td><button class="btn btn-success dropdown-toggle">结束治疗</button></td>
                </tr>

            </table>

    </div>
    <!-- 模态弹出框 begin -->
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">治疗结果记录</h4>
                </div>
                <div class="modal-body">
                    <input type="text" id="treatresult" class="form-control" placeholder="治疗结果">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 模态弹出框 end -->
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/vue.js"></script>
</body>
<script>
    var pageIndex = 1;

    var id = "${map.id}";
    var type = "${map.skinno}";
    var pno = "${map.pno}";
    var dno = "${map.dno}";

    var astdrugVue = new Vue({
        el : "#astdrugList",
        data : {
            astdrugParam : [],
            astdrug : {jzno:"", name:"", sex:"", age:"", position:"", officeno:""},
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
                    url : "/astdrug_queryById.action",
                    type : "post",
                    success : function(data){
                        this.astdrugParam = data.listData;
                        this.maxPage = data.maxPage;
                    }
                })
            },

            save : function () {
                var result = $("#treatresult").val();
                $.ajax({
                   url : "addTreat.action",
                    type : "post",
                    data:{
                        id : id,
                        type : type,
                        pno : pno,
                        dno : dno,
                        result : result
                    },
                    success:function (data) {
                        if(data){
                            $("#myModal").find(".close").click();
                            alert("保存成功！");
                        }
                    }
                });
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
            var maxPage = astdrugVue._data.maxPage;
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
                url : "/astdrug_resultmap.action",
                data : "page="+pageIndex+"&search="+searchValue+"&count="+selectPageCount,
                type : "post",
                success : function(data){
                    astdrugVue._data.astdrugParam = data.listData;
                    astdrugVue._data.maxPage = data.maxPage;
                    astdrugVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })

//                控制每页条数
        $(".pagedown").change(function(){
            var selectPageCount = $(".pagedown").val();//得到每页显示条数
            $.ajax({
                url : "/astdrug_resultmap.action",
                data : "count="+selectPageCount,
                type : "post",
                success : function(data){
                    astdrugVue._data.astdrugParam = data.listData;
                    astdrugVue._data.maxPage = data.maxPage;
                    astdrugVue._data.currnetIndex = pageIndex;//设置当前页码为选中的页码
                }
            })
        })
    })



    //            模糊查询的方法
    function searchastdrug () {
        var searchValue = $("#search").val();//得到搜索框中的值
        if(searchValue != null){
            $.ajax({
                url : "/astdrug_resultmap.action",
                data : {search : searchValue},
                success : function(data){
                    astdrugVue._data.astdrugParam = data.listData;
                    astdrugVue._data.maxPage = data.maxPage;
                }
            })
        }
    }

</script>



<style>
    <%--表格居中--%>
    .table tr td ,.table tread tr{
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
        widtr: 50px;
    }
    /*分页后*/
    .pageBackground{
        background-color: #00a4ac;
    }
</style>
</html>

