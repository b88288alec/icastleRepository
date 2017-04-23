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
<link href="/iCastle/css/material-kit.css" rel="stylesheet" />
<link href="/iCastle/css/template.css" rel="stylesheet" />


<!--以下請加入各自頁面的css-->
<link href="hotel/css/hotel.css" rel="stylesheet" />
<link href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.2.0/jquery.rateyo.min.css">


<style>
#container {
	margin-top: 100px;
}

.ahotel {
	margin: 8px;
	border: 2px skyblue solid;
}
</style>
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
				<a class="navbar-brand" href="/iCastle/view/index.jsp"> <img
					alt="Brand" height="30" src="/iCastle/img/logo.png" />
				</a>
			</div>
			<!--結束logo-->
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/iCastle/view/index.jsp">首頁</a></li>
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
	<div class="row" id="container">
		<!-- 左方查詢列 -->
		<div class="col-md-2 col-md-offset-1">
			<!-- 			---地圖---<br> ---您的搜尋條件---<br> -->
			<!-- 			<div class="row query-overlay"> -->
			<!-- 				<form action="Query.do" method="get"> -->
			<!-- 					<div class="input-group input-group-sm"> -->
			<!-- 						<p>查詢型態</p> -->
			<!-- 						<input type="text" class="form-control" placeholder="輸入區域或飯店名稱" -->
			<%-- 							name="type" value="${param.type}" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="clearfix visible-xs-block"></div> -->
			<!-- 					<div class="input-group input-group-sm"> -->
			<!-- 						<p>入住日期</p> -->
			<!-- 						<input type="text" class="form-control datepicker" -->
			<!-- 							data-date-format="yyyy/mm/dd" data-date-start-date="+0d" -->
			<%-- 							placeholder="輸入入住日期" name="start" value="${param.start}" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="clearfix visible-xs-block"></div> -->
			<!-- 					<div class="input-group input-group-sm"> -->
			<!-- 						<p>退房日期</p> -->
			<!-- 						<input type="text" class="form-control datepicker" -->
			<!-- 							data-date-format="yyyy/mm/dd" data-date-end-date="0d" -->
			<%-- 							placeholder="輸入退房日期" name="end" value="${param.end}" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="clearfix visible-xs-block"></div> -->
			<!-- 					<div class="input-group input-group-sm"> -->
			<!-- 						<p>入住人數</p> -->
			<!-- 						<input type="text" class="form-control" placeholder="輸入入住人數" -->
			<%-- 							name="peopleNum" value="${param.peopleNum}" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="clearfix visible-xs-block"></div> -->
			<!-- 					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;"> -->
			<!-- 						<br /> -->
			<!-- 						<div class="btn-group"> -->
			<!-- 							<input type="submit" class="btn btn-success" value="搜尋" disable="disable"/> -->
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 					<input type="button" id="onekey" value="一鍵輸入" /> -->
			<!-- 				</form> -->
			<!-- 			</div> -->
		</div>
		<!-- 左方查詢列結束 -->
		<!-- 飯店 -->
		<div class="col-md-8">

			<!-- 飯店基本介紹 -->
			<div class="row">
				<div class="col-md-12">
					<%-- 					${hotel.hotelName}<br> --%>
					<%-- 					${hotel.email}<br> --%>
					<%-- 					${hotel.addr}<br> --%>
					<%-- 					${hotel.zone}<br> --%>
					<%-- 					${hotel.point}<br> --%>
					<%-- 					${hotel.hot}<br> --%>
					<%-- 					${hotel.star}<br> --%>
					<span id="hotelname">${hotel.hotelName}</span>
					${hotel.zone}&nbsp;&nbsp;&nbsp;${hotel.star}星級&nbsp;&nbsp;&nbsp;評分:${hotel.point}<br>
					地址:${hotel.addr}
				</div>
			</div>
			<!-- 飯店基本介紹結束 -->
			<hr>
			<!-- 圖片和介紹 -->
			<div class="row">
				<div class="col-md-5">
					飯店照片<br> 飯店照片<br> 飯店照片<br> 飯店照片<br> 飯店照片<br>
					飯店照片<br> 飯店照片<br>
				</div>
				<div class="col-md-7">
					介紹<br> 這裡是飯店介紹<br>
					<br>
					<br> 設施&服務<br> 這裡是設施介紹

				</div>
			</div>
			<!-- 圖片和介紹結束 -->
			<hr>
			<!-- 房型 -->
			<div class="row">
				<div class="col-md-1">房型介紹</div>
				<div class="col-md-11">
					<!-- 一筆又一筆的房間 -->
					<c:forEach var="room" items="${rooms}">
						<div class="row room">
						
							<!-- 每間房間的資訊 -->
							<div class="col-md-2">${room.roomTypeName}</div>
							<div class="col-md-2">
								<c:if test="${room.breakfast}">
									含早餐<br>
								</c:if>
								<c:if test="${room.dinner}">
									含晚餐<br>
								</c:if>
								<c:if test="${room.afternoonTea}">
									含下午茶 
								</c:if> 
							</div>						
							<div class="col-md-2">
								<c:if test="${room.bedAddable}">
									可加床 
								</c:if>
							</div>
							<div class="col-md-1">
								$${room.price}
							</div>
							<div class="col-md-2">
								${room.remark}<br>
							</div>
							<!-- 每間房間的資訊結束 -->
							
							<!-- 下訂按鈕與傳送資訊 -->
							<form action="../rooms/Rooms.do" name="form">
							<div class="col-md-1">
								間數<br>
								<select name="roomNum">
								<c:forEach var="i" begin="1" end="${room.roomNumber-room.bookedNum}">
									<option value="${i}">${i}</option>
								</c:forEach>
								</select>
							</div>
							<div class="col-md-2">
									<!-- 測試能否抓到資訊 -->
									<!--
									${room.roomId}<br>
									${room.hotelId}<br>
									${room.roomTypeId}<br>
									${room.roomTypeName}<br>
									${param.start}<br>
									${param.end}<br>
									${param.peopleNum}<br>
									${room.breakfast}<br>
									${room.dinner}<br>
									${room.afternoonTea}<br>
									${room.price}<br>
									${room.bedAddable}<br>
									${room.pricePerPerson}<br>
									${room.remark}<br>
									-->
									<!-- 測試能否抓到資訊結束 -->
									剩下${room.roomNumber-room.bookedNum}間<br> 
									<input type="submit" value="下訂"/><br>
									<input type="hidden" name="roomId" value="${room.roomId}"/>
									<input type="hidden" name="hotelId" value="${room.hotelId}"/>
									<input type="hidden" name="roomTypeId" value="${room.roomTypeId}"/>
									<input type="hidden" name="roomTypeName" value="${room.roomTypeName}"/>
									<input type="hidden" name="start" value="${param.start}"/>
									<input type="hidden" name="end" value="${param.end}"/>
									<input type="hidden" name="peopleNum" value="${param.peopleNum}"/>
									<input type="hidden" name="breakfast" value="${room.breakfast}"/>
									<input type="hidden" name="dinner" value="${room.dinner}"/>
									<input type="hidden" name="afternoonTea" value="${room.afternoonTea}"/>
									<input type="hidden" name="price" value="${room.price}"/>
									<input type="hidden" name="bedAddable" value="${room.bedAddable}"/>
									<input type="hidden" name="pricePerPerson" value="${room.pricePerPerson}"/>
									<input type="hidden" name="remark" value="${room.remark}"/>
									<input type="hidden" name="action" value="getOrder"/>
							</div>
							</form>
							<!-- 下訂按鈕與傳送資訊結束 -->
						</div>
						<br>
					</c:forEach>
					<!-- 一筆又一筆的房間結束 -->

				</div>
			</div>
			<!-- 房型結束 -->

		</div>
	</div>
	<!-- container結束 -->

	<!--footer-->
	<div class="footer">
		<img src="/iCastle/img/logo.png" width="100" />
		<h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
		<h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
	</div>
	<!--結束footer-->
</body>

<script src="/iCastle/js/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/iCastle/js/bootstrap.min.js"></script>
<script src="/iCastle/js/material.min.js"></script>

<script src="/iCastle/js/nouislider.min.js"></script>

<script src="/iCastle/js/bootstrap-datepicker.js"></script>

<script src="/iCastle/js/material-kit.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.2.0/jquery.rateyo.min.js"></script>
<script>
	$(function() {
		$('#onekey').click(function() {
			event.preventDefault();
			$('input[name = "type"]').val('高雄');
			$('input[name = "start"]').val('2017/01/02');
			$('input[name = "end"]').val('2017/01/04');
			$('input[name = "peopleNum"]').val(4);
		});

		$('input[name = "end"]').focus(function() {
			$('input[name = "start"]').datepicker('hide');
		})

		$('input[name = "start"]').focus(function() {
			$('input[name = "end"]').datepicker('hide');
		})
		
		$('select[name = "roomNum"]').select(function(){
			console.log("hi");
		})
	});
</script>
</html>