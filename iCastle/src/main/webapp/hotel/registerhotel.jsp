<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
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
<link href="../css/registerhotel.css" rel="stylesheet" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

<title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->

	<!-- 本頁內容從這裡開始 -->
	<div class="container"
		style="background-color: white; padding-bottom: 100px;">
		<h1>業者註冊</h1>
	
		<form action="Registerhotel.do" method="post" enctype="multipart/form-data">
		<table class="">
			<tbody>
			<tr>
				<td>飯店名稱</td>
				<td><input type="text" name="hotelName" value="${param.hotelName}"/>${errMap.hotelNameErr}</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" value="${param.email}"/>${errMap.emailErr}</td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="password" name="pw" />${errMap.pwErr}</td>
			</tr>
			<tr>
				<td>確認密碼</td>
				<td><input type="password" name="pwcheck" />${errMap.pwcheckErr}</td>
			</tr>
			<tr>
				<td>飯店星等</td>
				<td>
					<select id="star" name="star">
						<option value="0">-</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>${errMap.starErr}
				</td>
			</tr>
			<tr>
				<td>登記人姓名</td>
				<td><input type="text" name="registerName" value="${param.registerName}"/>${errMap.registerNameErr}</td>
			</tr>
			<tr>
				<td>登記證號</td>
				<td><input type="text" name="registerId" value="${param.registerId}"/>${errMap.registerIdErr}</td>
			</tr>
			<tr>
				<td>連絡電話</td>
				<td><input type="text" name="tel" value="${param.tel}"/>${errMap.telErr}</td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="addr" value="${param.addr}"/>${errMap.addrErr}</td>
			</tr>
			<tr>
				<td>地區</td>
				<td><input type="text" name="zone" value="${param.zone}"/>${errMap.zoneErr}</td>
			</tr>
			<tr>
				<td>交通方式</td>
				<td><textarea name="transport" >${param.transport}</textarea>${errMap.transportErr}</td>
			</tr>
			<tr>
				<td>官方網站</td>
				<td><input type="text" name="website" value="${param.website}"/>${errMap.websiteErr}</td>
			</tr>
			<tr>
				<td>上傳照片</td>
				<td><input type="file" name="photo"/></td>
			</tr>
			<tr>
				<td>飯店介紹</td>
				<td><textarea name="hotelProfile" >${param.hotelProfile}</textarea>${errMap.hotelProfileErr}</td>
			</tr>
			<tr>
				<td>Check-in時間</td>
				<td><input type="text" class="timepicker1" name="checkin" value="${param.checkin}"/>${errMap.checkinErr}</td>
			</tr>
			<tr>
				<td>Check-out時間</td>
				<td><input type="text" class="timepicker2" name="checkout" value="${param.checkout}"/>${errMap.checkoutErr}</td>
			</tr>
			<tr>
				<td>入住須知</td>
				<td><textarea name="guestPolicies" >${param.guestPolicies}</textarea>${errMap.guestPoliciesErr}</td>
			</tr>
			<tr>
				<td>取消規定</td> 
				<td><textarea name="cancelPolicies" >${param.cancelPolicies}</textarea>${errMap.cancelPoliciesErr}</td>
			</tr>
			<tr>
				<td>設施</td>
				<td>
					<input type="checkbox" name="roomWifi"/>室內wifi
					<input type="checkbox" name="hallWifi"/>大廳wifi
					<input type="checkbox" name="internet"/>網際網路
					<input type="checkbox" name="mineralWater"/>礦泉水
					<input type="checkbox" name="toiletUtensils"/>盥洗用具
					<input type="checkbox" name="hairDryer"/>吹風機
					<input type="checkbox" name="tv"/>電視
					<input type="checkbox" name="gameRoom"/>遊戲室
					<input type="checkbox" name="gym"/>健身房
					<input type="checkbox" name="spa"/>溫泉
					<input type="checkbox" name="swimPool"/>游泳池
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="送出"></td>
				<td><input type="reset" value="清除"></td>
				<td><input id="onekey" type="submit" value="一鍵輸入"></td>
			</tr>
			</tbody>
		</table>
		</form>
	</div>

	${pageContext.request.servletPath}

<!-- 本頁內容結束 -->

    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/material.min.js"></script>

	<script src="../js/material-kit.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
	<script>
	$(function() {
		$('#star').val(${param.star});
		
		$('.timepicker1').timepicker({
		    timeFormat: 'h:mm p',
		    interval: 60,
		    minTime: '1:00pm',
		    maxTime: '11:00pm',
		    defaultTime: '6:00pm',
		    startTime: '0:00',
		    dynamic: false,
		    dropdown: true,
		    scrollbar: true
		});
		
		$('.timepicker2').timepicker({
		    timeFormat: 'h:mm p',
		    interval: 60,
		    minTime: '6',
		    maxTime: '12',
		    defaultTime: '10',
		    startTime: '0:00',
		    dynamic: false,
		    dropdown: true,
		    scrollbar: true
		});
		$('#onekey').click(function() {
			event.preventDefault();
			$('input[name = "hotelName"]').val('涵碧樓酒店');
			$('input[name = "email"]').val('bilo@gmail.com');
			$('input[name = "pw"]').val('123456');
			$('input[name = "pwcheck"]').val('123456');
			$('#star').val('5');
			$('input[name = "registerName"]').val('小智');
			$('input[name = "registerId"]').val('南投縣第560號');
			$('input[name = "tel"]').val('0225694586');
			$('input[name = "addr"]').val('南投縣魚池鄉中興路142號');
			$('input[name = "zone"]').val('南投縣魚池鄉');
			$(':input[name = "transport"]').text('搭乘火車到南投火車站接著轉6路公車');
			$('input[name = "website"]').val('http://www.bilo.com');
			$(':input[name = "hotelProfile"]').val('位於日月潭湖畔');
			$('input[name = "checkin"]').val('5:00 PM');
			$('input[name = "checkout"]').val('9:00 AM');
			$(':input[name = "guestPolicies"]').val('不可攜帶寵物入內');
			$(':input[name = "cancelPolicies"]').val('不可以取消');
			$('input[name = "roomWifi"]').prop('checked');
		});
	});
	</script>
</body>
</html>