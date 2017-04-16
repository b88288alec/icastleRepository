<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="Content-Type" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="../css/material-kit.css" rel="stylesheet" />
    <link href="../css/template.css" rel="stylesheet" />
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
                <a class="navbar-brand" href="HtmlPage.html">
                    <img alt="Brand" height="30" src="../img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="HtmlPage.html">首頁</a></li>
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
    <div class="container" style="margin-top:56px">
    <form action="OrdersServlet" method="post">
		<table>
			<tr><td><span>客戶編號:</span></td><td><input type="text" name="memberId"><br></td></tr>
			<tr><td><span>房間編號:</span></td><td><input type="text" name="roomId"><br></td></tr>
			<tr><td><span>價格:</span></td><td><input type="text" name="price"><br></td></tr>
			<tr><td><span>入住天數:</span></td><td><input type="text" name="dates"><br></td></tr>
			<tr><td><span>房間號碼:</span></td><td><input type="text" name="roomNum"><br></td></tr>
			<tr><td><span>入住人姓名:</span></td><td><input type="text" name="reservationer"><br></td></tr>
			<tr><td><span>生日:</span></td><td><input type="text" name="bdate"><br></td></tr>
			<tr><td><span>電話:</span></td><td><input type="text" name="tel"><br></td></tr>
			<tr><td><span>E-mail:</span></td><td><input type="text" name="email"><br></td></tr>
			<tr><td><span>地址:</span></td><td><input type="text" name="addr"><br></td></tr>
			<tr><td><span>身分證字號:</span></td><td><input type="text" name="personId"><br></td></tr>
			<tr><td><span>國籍:</span></td><td><input type="text" name="country"><br></td></tr>
			<tr><td><span>護照號碼:</span></td><td><input type="text" name="passport"><br></td></tr>
			<tr><td><span>是否加床:</span></td><td><input type="radio" name="bedAdding" value="true"><span>加床</span><input type="radio" name="bedAdding" value="false" checked="checked"><span>不加床</span><br></td></tr>
			<tr><td><span>備註:</span></td><td><textarea rows="4" cols="50" name="remark"></textarea><br></td></tr>
			<tr><td></td><td><input type="submit"></td></tr>
		</table>
	</form>
	</div>
    <!--footer-->
    <div class="footer">
        <img src="../img/logo.png" width="100" />
        <h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        <h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
    </div>
    <!--結束footer-->
</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/material.min.js"></script>

<script src="../js/nouislider.min.js"></script>

<script src="../js/bootstrap-datepicker.js"></script>

<script src="../js/material-kit.js"></script>

</html>