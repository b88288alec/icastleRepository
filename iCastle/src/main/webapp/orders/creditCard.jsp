<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--     Fonts and icons     -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!--<link href="../css/bootstrap.min.css" rel="stylesheet" />-->
<link href="../css/material-kit.css" rel="stylesheet" />
<link href="../css/template.css" rel="stylesheet" />
<!--以下請加入各自頁面的css-->

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation"height:55px;">
		<div class="container-fluid">
			<!--logo-->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="../index.jsp"> <img alt="Brand"
					height="30" src="../img/logo.png" />
				</a>
			</div>
			<!--結束logo-->
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="../index.jsp">首頁</a></li>
					<li><a href="#">活動</a></li>
					<li><a href="#">討論區</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-cog"></span>會員中心</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							登入</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							登出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--結束導覽列-->
	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container" style="margin-top: 56px">
		<form action="check.jsp" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2"><img src="../img/creditCard/visa.png" height="80" width="120" style="margin:0px 20px"><img src="../img/creditCard/mastercard.png" height="80" width="120" style="margin:0px 20px"><img src="../img/creditCard/jcb.jpg" height="100" width="150" style="margin:0px 20px"></th>
				</tr>
			</thead>
			<tbody>
				<tr><td>信用卡別:</td><td><input type="radio" name="card" value="visa" checked>VISA <input type="radio" name="card" value="mastercard">Master Card <input type="radio" name="card" value="jcb">JCB</td></tr>
				<tr><td>信用卡號:</td><td><input type="text" name="cardnum1" size="3" maxlength="4"> － <input type="text" name="cardnum2" size="3" maxlength="4"> － <input type="text" name="cardnum3" size="3" maxlength="4"> － <input type="text" name="cardnum4" size="3" maxlength="4"></td></tr>
				<tr><td>背面末三碼:</td><td><input type="text" name="threenum" size="3" maxlength="3"></td></tr>
				<tr><td>卡片效期:</td><td><input type="text" name="month" size="4" maxlength="2">月<input type="text" name="year" maxlength="2" size="4">年</td></tr>
				<tr><td>付款金額:</td><td>${OrdersVO.price}</td></tr>
				<tr><td>持卡人姓名:</td><td><input type="text" name="name"></td></tr>
				<tr><td>持卡人身分證字號:</td><td><input type="text" name="ID"></td></tr>
				<tr><td>持卡人電話:</td><td><input type="text" name="phone"></td></tr>
				<tr><td><input type="button" onclick="history.back()" value="上一頁"></td><td><input type="submit" class="btn btn-success" value="送出"><input type="button" class="btn" id="onekey" value="一鍵輸入" /></td></tr>
			</tbody>
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
<script>
		$(function() {
			$('#onekey').click(function() {
				event.preventDefault();
    			$('input[name = "cardnum1"]').val('1234');
    			$('input[name = "cardnum2"]').val('5678');
    			$('input[name = "cardnum3"]').val('9012');
    			$('input[name = "cardnum4"]').val('3456');
    			$('input[name = "threenum"]').val('246');
    			$('input[name = "month"]').val('12');
    			$('input[name = "year"]').val('20');
			});
		});
	</script>

</html>