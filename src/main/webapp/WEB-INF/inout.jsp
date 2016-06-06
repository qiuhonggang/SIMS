<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/include/taglibs.jsp" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_jqgrid.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:02 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>进出库管理</title>


    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctxStatic}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${ctxStatic}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <!-- jqgrid-->
    <link href="${ctxStatic}/css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">

    <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/css/style.min862f.css?v=4.1.0" rel="stylesheet">

    <style>
        /* Additional style to fix warning dialog position */

        #alertmod_table_list_2 {
            top: 900px !important;
        }
    </style>
    <script>
        function RepNumber(obj) {
            var reg = /^[\d]+$/g;
            if (!reg.test(obj.value)) {
                var txt = obj.value;
                txt.replace(/[^0-9]+/, function (char, index, val) {//匹配第一次非数字字符
                    obj.value = val.replace(/\D/g, "");//将非数字字符替换成""
                    var rtextRange = null;
                    if (obj.setSelectionRange) {
                        obj.setSelectionRange(index, index);
                    } else {//支持ie
                        rtextRange = obj.createTextRange();
                        rtextRange.moveStart('character', index);
                        rtextRange.collapse(true);
                        rtextRange.select();
                    }
                })
            }
        };
    </script>

</head>

<body class="gray-bg top-navigation">
<div class="wrapper wrapper-content  animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox ">
                <div class="ibox-content">
                    <!--导航条开始-->
                    <div class="jqGrid_wrapper ">
                        <div id=" wrapper">
                            <div id="page-wrapper" class="gray-bg">
                                <div class="row border-bottom white-bg">
                                    <nav class="navbar navbar-static-top" role="navigation">
                                        <div class="navbar-header">
                                            <button aria-controls="navbar" aria-expanded="false" data-target="#navbar"
                                                    data-toggle="collapse" class="navbar-toggle collapsed"
                                                    type="button">
                                                <i class="fa fa-reorder"></i>
                                            </button>
                                            <a href="#" class="navbar-brand">${sessionScope.get("user").getUsinUsername()}</a>
                                        </div>
                                        <div class="navbar-collapse " id="navbar">
                                            <ul class="nav navbar-nav">
                                                <li>
                                                    <a href="/index">首页</a>
                                                </li>
                                                <li>
                                                    <a href="/goods"> 商品</a>
                                                </li>
                                                <li>
                                                    <a href="/record"> 记录</a>
                                                </li>
                                                <li  class="active">
                                                    <a href="/inout"> 库存</a>
                                                </li>
                                                <li>
                                                    <a href="/supplier"> 供应商</a>
                                                </li>
                                                <li >
                                                    <a href="/userList"> 用户</a>
                                                </li>
                                            </ul>
                                            <ul class="nav navbar-top-links navbar-right">
                                                <li>
                                                    <a href="/logout">
                                                        <i class="fa fa-sign-out"> </i>退出
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--导航条结束-->
                    <div>
                        <form action="/stock" method="post">
                            <p style="color: red">${message}</p>
                            <input type="text" name="pkId" placeholder="请输入商品编号" required="required"  onkeyup="javascript:RepNumber(this)"/>
                            <input type="text" name="goodsInventory" placeholder="请输入数量" required="required"  onkeyup="javascript:RepNumber(this)"/>
                            入库: <input type="radio" name="inout" value="in" checked="checked" />
                            出库: <input type="radio" name="inout" value="out"/>
                            <input type="submit" value="提交" />
                        </form>
                    </div>
                    <table id="table_list_2"></table>
                    <div id="pager_list_2"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctxStatic}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctxStatic}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctxStatic}/js/plugins/peity/jquery.peity.min.js"></script>
<script src="${ctxStatic}/js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
<script src="${ctxStatic}/js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
<script src="${ctxStatic}/js/content.min.js?v=1.0.0"></script>
<script>
    $(document).ready(function () {
        $.jgrid.defaults.styleUI = "Bootstrap";
        var mydata = ${tblGoodsList1};
        $("#table_list_2").jqGrid({
            data: mydata,
            datatype: "local",
            height: 450,
            autowidth: true,
            shrinkToFit: true,
            rowNum: 20,
            rowList: [10, 20, 30],
            colNames: ["商品编号", "商品名称", "库存"],
            colModel: [{
                name: "pkId",
                index: "pkId",
                editable: false,
                width: 100
            }, {
                name: "goodsName",
                index: "goodsName",
                editable: false,
                width: 100
            },{
                name: "goodsInventory",
                index: "goodsInventory",
                editable: true,
                width: 100,
                editrules:{
                    edithidden:true,
                    required:true,
                    number:true
                }
            }],
            pager: "#pager_list_2",
            viewrecords: true,
            sortname: 'pkId',
            sortorder: "asc",
            editurl: "/operIn",
            hidegrid: false
        });
        $("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
            edit: false,
            add: false,
            del: false,
            search: false,
            refresh: false
        }, {
            height: 400, reloadAfterSubmit: false
        }, {
            height: 400, reloadAfterSubmit: false,
        }, {
            reloadAfterSubmit: false,
        }, {});


        $(window).bind("resize", function () {
            var width = $(".jqGrid_wrapper").width();
            $("#table_list_2").setGridWidth(width)
        })
    });


</script>
</body>
</html>


