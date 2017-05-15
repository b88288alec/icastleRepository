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
<!--<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" />-->
<link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
<!--以下請加入各自頁面的css-->

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
		<jsp:include page="../../fragment/nav.jsp"/>
	<!--結束導覽列-->
	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container" style="margin-top: 56px">
		<form action="check.jsp" method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2"><img src="${pageContext.servletContext.contextPath}/img/creditCard/visa.png" height="80" width="120" style="margin:0px 20px"><img src="${pageContext.servletContext.contextPath}/img/creditCard/mastercard.png" height="80" width="120" style="margin:0px 20px"><img src="${pageContext.servletContext.contextPath}/img/creditCard/jcb.jpg" height="100" width="150" style="margin:0px 20px"></th>
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
    <!--開始footer-->
		<jsp:include page="../../fragment/footer.jsp"/>
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>
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