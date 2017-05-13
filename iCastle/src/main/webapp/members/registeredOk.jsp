<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <meta http-equiv=refresh content="5;url=../../index.jsp">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" height:55px;">
        <div class="container-fluid">
            <!--logo-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/index.jsp">
                    <img alt="Brand" height="30" src="${pageContext.servletContext.contextPath}/img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.servletContext.contextPath}/index.jsp">首頁</a></li>
                    <li><a href="#">活動</a></li>
                    <li><a href="#">討論區</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-cog"></span>會員中心</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> 登入</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登出</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--結束導覽列-->
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->

<div class="member" style="margin-top:56px">
<h1>恭喜您註冊成功</h1>
<table>
<tr><td><span>帳號:${membersVO.email}</span></td><td><br></td></tr>
<tr><td><span>密碼:${membersVO.pw}</span></td><td><br></td></tr>
<tr><td><span>性名:${membersVO.name}</span></td><td><br></td></tr>
<tr><td><span>性別:${membersVO.gender}</span></td><td><br></td></tr>
<tr><td><span>生日:${membersVO.bdate}</span></td><td><br></td></tr>
<tr><td><span>地址:${membersVO.addr}</span></td><td><br></td></tr>
<tr><td><span>電話:${membersVO.tel}</span></td><td><br></td></tr>
<tr><td><span>身分證字號:${membersVO.personId}</span></td><td><br></td></tr>
<tr><td><span>國家:${membersVO.country}</span></td><td><br></td></tr>
<tr><td><span>護照:${membersVO.passport}</span></td><td><br></td></tr>

</table>
<input type="button" value="回首頁" onclick="location.href='${pageContext.servletContext.contextPath}/index.jsp'">
</div>

    
    
    
    
    
    
    <!--footer-->
    <div class="footer">
        <img src="${pageContext.servletContext.contextPath}/img/logo.png" width="100" />
        <h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        <h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
    </div>
    <!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

</html>