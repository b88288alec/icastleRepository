<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/material-dashboard.css"
	rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.servletContext.contextPath}/css/manager_template.css"
	rel="stylesheet" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
<title>iCastle飯店管理中心</title>
<style> 
	.container {
	    width: 1300px;
	    margin-top: 100px;
	}
	td {
		height: 30px;
	}
	#hotelname1 {
		width: 110px;
	}
	.facility {
		color:black;
	}
</style>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/hotelManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<form action="UpdateHotelInfo.do" method="post">
				<table class="">
					<tbody>
					
					<tr>
						<td id="hotelname1">飯店名稱</td>
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
						<td>
							<div class="form-group label-floating">
								<label class="control-label">請輸入連絡電話</label>
								<input type="text" name="tel" value="${HotelInfo.tel}" class="form-control" >
								<font color="red">${errMap.telErr}</font>
							</div>
						</td>
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
						<td>
							<textarea name="transport" rows="6" cols="100" class="form-control" placeholder="請輸入交通方式" rows="5">${HotelInfo.transport}</textarea>
							<font color="red">${errMap.transportErr}</font>
						</td>
					</tr>
					<tr>
						<td>官方網站</td>
						<td>
							<div class="form-group label-floating">
								<label class="control-label">請輸入官方網站</label>
								<input type="text" size="50" name="website" value="${HotelInfo.website}" class="form-control" >
								<font color="red">${errMap.websiteErr}</font>
							</div>
						</td>
					</tr>
					<tr>
						<td>飯店介紹</td>
						<td>
							<textarea name="hotelProfile" rows="6" cols="100" class="form-control" placeholder="請輸入飯店介紹" rows="5">${HotelInfo.hotelProfile}</textarea>
							<font color="red">${errMap.hotelProfileErr}</font>
						</td>
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
						<td>
							<textarea name="guestPolicies" rows="6" cols="100" class="form-control" placeholder="請輸入入住須知" rows="5">${HotelInfo.guestPolicies}</textarea>
							<font color="red">${errMap.guestPoliciesErr}</font>
						</td>
					</tr>
					<tr>
						<td>取消規定</td> 
						<td>
							<textarea name="cancelPolicies" rows="6" cols="100" class="form-control" placeholder="請輸入取消規定" rows="5">${HotelInfo.cancelPolicies}</textarea>
							<font color="red">${errMap.cancelPoliciesErr}</font>
						</td>
					</tr>
					<tr>
						<td>設施</td>
						<td>
						
							<div class="checkbox">
								<label>
									<input type="checkbox" name="roomWifi"
										<c:if test="${HotelInfo.roomWifi == true}">
											checked
										</c:if>
									/><span class="facility">室內wifi</span>
								</label>
								<label>
									<input type="checkbox" name="hallWifi"
										<c:if test="${HotelInfo.hallWifi == true}">
											checked
										</c:if>
									/><span class="facility">大廳wifi</span>
								</label>
								<label>
									<input type="checkbox" name="internet"
										<c:if test="${HotelInfo.internet == true}">
											checked
										</c:if>
									/><span class="facility">網際網路</span>
								</label>
								<label>
									<input type="checkbox" name="mineralWater"
										<c:if test="${HotelInfo.mineralWater == true}">
											checked
										</c:if>
									/><span class="facility">礦泉水</span>
								</label>
								<label>
									<input type="checkbox" name="toiletUtensils"
										<c:if test="${HotelInfo.toiletUtensils == true}">
											checked
										</c:if>
									/><span class="facility">盥洗用具</span>
								</label>
								<label>
									<input type="checkbox" name="hairDryer"
										<c:if test="${HotelInfo.hairDryer == true}">
											checked
										</c:if>
									/><span class="facility">吹風機</span>
								</label>
							</div>
							<div class="checkbox">
								<label>
									<input type="checkbox" name="tv"
										<c:if test="${HotelInfo.tv == true}">
											checked
										</c:if>
									/><span class="facility">電視</span>
								</label>
								<label>
									<input type="checkbox" name="gameRoom"
										<c:if test="${HotelInfo.gameRoom == true}">
											checked
										</c:if>
									/><span class="facility">遊戲室</span>
								</label>
								<label>
									<input type="checkbox" name="gym"
										<c:if test="${HotelInfo.gym == true}">
											checked
										</c:if>
									/><span class="facility">健身房</span>
								</label>
								<label>
									<input type="checkbox" name="spa"
										<c:if test="${HotelInfo.spa == true}">
											checked
										</c:if>
									/><span class="facility">溫泉</span>
								</label>
								<label>
									<input type="checkbox" name="swimPool"
										<c:if test="${HotelInfo.swimPool == true}">
											checked
										</c:if>
									/><span class="facility">游泳池</span>
								</label>
							</div>

						</td>
					</tr>
					<tr>
						<td><input type="submit" value="送出" class="btn btn-success"></td>
						<td><input type="reset" value="清除" class="btn btn-danger"></td>
						<td><input class="btn btn-default" id="onekey" type="submit" value="一鍵輸入"></td>
					</tr>
					</tbody>
				</table>
				</form>
			</div>
		</div>
	</div>
	<!--內容區塊-->

	<!--開始footer-->
	<jsp:include page="../fragment/hotelManagementFooter.jsp" />
	<!--結束footer-->
</body>

<script
	src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>

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