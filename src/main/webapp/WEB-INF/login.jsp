<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:23 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>超市库存管理系统 - 登录</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="${ctxStatic}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${ctxStatic}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet">
    <link href="${ctxStatic}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div style="padding-top: 15%" class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div style="width: 100%;margin: 0 auto">

            <h1 class="logo-name" style="font-size: 36px;letter-spacing: 1px;color: green">超市库存管理系统</h1>

        </div>
        <h3>欢迎使用 超市库存管理系统</h3>

        <form class="m-t" role="form" action="/login" method="post">
            <p style="color: red">${errorMessage}</p>
            <div class="form-group">
                <input type="text" class="form-control" name="usinUsername" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="usinPassword" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            </p>

        </form>
    </div>
</div>
<script src="${ctxStatic}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctxStatic}/js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>
