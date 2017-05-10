<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	

    <title>愛客宿-iCastle</title>
	<style>
		.container {
		    width: 1300px;
		    margin-top: 100px;
		}
	</style>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	
    <!-- 本頁內容從這裡開始 -->
	<div class="container"
		style="background-color: white; padding-bottom: 100px;">
		<h1>修改飯店資料</h1>
	
		<form action="UpdateHotelInfo.do" method="post">
		<table class="">
			<tbody>
			<tr>
				<td>飯店名稱</td>
				<td><span>${HotelLoginOK.hotelName}</span></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><span>${HotelLoginOK.email}</span></td>
			</tr>
			<tr>
				<td>飯店星等</td>
				<td><span>${HotelLoginOK.star}</span></td>
			</tr>
			<tr>
				<td>登記人姓名</td>
				<td><span>${HotelInfo.registerName}</span></td>
			</tr>
			<tr>
				<td>登記證號</td>
				<td><span>${HotelLoginOK.registerId}</span></td>
			</tr>
			<tr>
				<td>連絡電話</td>
				<td><input type="text" size="15" name="tel" value="${HotelInfo.tel}"/>${errMap.telErr}</td>
			</tr>
			<tr>
				<td>地址</td>
				<td><span>${HotelLoginOK.addr}</span></td>
			</tr>
			<tr>
				<td>地區</td>
				<td><span>${HotelLoginOK.zone}</span></td>
			</tr>
			<tr>
				<td>交通方式</td>
				<td><textarea name="transport" rows="6" cols="100">${HotelInfo.transport}</textarea>${errMap.transportErr}</td>
			</tr>
			<tr>
				<td>官方網站</td>
				<td><input type="text" size="50" name="website" value="${HotelInfo.website}"/>${errMap.websiteErr}</td>
			</tr>
			<tr>
				<td>飯店介紹</td>
				<td><textarea name="hotelProfile" rows="6" cols="100">${HotelInfo.hotelProfile}</textarea>${errMap.hotelProfileErr}</td>
			</tr>
			<tr>
				<td>Check-in時間</td>
				<td><input type="text" class="timepicker1" name="checkin" value="${HotelInfo.checkin}"/>${errMap.checkinErr}</td>
			</tr>
			<tr>
				<td>Check-out時間</td>
				<td><input type="text" class="timepicker2" name="checkout" value="${HotelInfo.checkout}"/>${errMap.checkoutErr}</td>
			</tr>
			<tr>
				<td>入住須知</td>
				<td><textarea name="guestPolicies" rows="6" cols="100">${HotelInfo.guestPolicies}</textarea>${errMap.guestPoliciesErr}</td>
			</tr>
			<tr>
				<td>取消規定</td> 
				<td><textarea name="cancelPolicies" rows="6" cols="100">${HotelInfo.cancelPolicies}</textarea>${errMap.cancelPoliciesErr}</td>
			</tr>
			<tr>
				<td>設施</td>
				<td>
					<input type="checkbox" name="roomWifi" 
						<c:if test="${HotelInfo.roomWifi == true}">
							checked
						</c:if>
					/>室內wifi
					<input type="checkbox" name="hallWifi"
						<c:if test="${HotelInfo.hallWifi == true}">
							checked
						</c:if>
					/>大廳wifi
					<input type="checkbox" name="internet"
						<c:if test="${HotelInfo.internet == true}">
							checked
						</c:if>
					/>網際網路
					<input type="checkbox" name="mineralWater"
						<c:if test="${HotelInfo.mineralWater == true}">
							checked
						</c:if>
					/>礦泉水
					<input type="checkbox" name="toiletUtensils"
						<c:if test="${HotelInfo.toiletUtensils == true}">
							checked
						</c:if>
					/>盥洗用具
					<input type="checkbox" name="hairDryer"
						<c:if test="${HotelInfo.hairDryer == true}">
							checked
						</c:if>
					/>吹風機
					<input type="checkbox" name="tv"
						<c:if test="${HotelInfo.tv == true}">
							checked
						</c:if>
					/>電視
					<input type="checkbox" name="gameRoom"
						<c:if test="${HotelInfo.gameRoom == true}">
							checked
						</c:if>
					/>遊戲室
					<input type="checkbox" name="gym"
						<c:if test="${HotelInfo.gym == true}">
							checked
						</c:if>
					/>健身房
					<input type="checkbox" name="spa"
						<c:if test="${HotelInfo.spa == true}">
							checked
						</c:if>
					/>溫泉
					<input type="checkbox" name="swimPool"
						<c:if test="${HotelInfo.swimPool == true}">
							checked
						</c:if>
					/>游泳池
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="送出"></td>
				<td><input type="reset" value="清除"></td>
				<td><input id="onekey" type="submit" value="一鍵輸入"></td>
				<td><button type="button" id="but">秀value</button></td>
			</tr>
			</tbody>
		</table>
		</form>
	</div>
	<!-- 本頁內容結束 -->
    
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
<script>
	$(function() {
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
			$('input[name = "email"]').val('eeit93no1@gmail.com');
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

</html>