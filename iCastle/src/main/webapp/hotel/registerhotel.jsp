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
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<div class="container">
		<div class="row col-md-offset-2" style="margin-top: 50px">
			<div class="col-md-10">
				<div class="card " style="padding: 0px 50px">
					<h2>業者註冊</h2>
				</div>
				<div class="card " style="padding: 0px 50px 50px 50px">
					<form action="Registerhotel.do" method="post"
						enctype="multipart/form-data">
						<div class="row modal-body ">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">飯店名稱:</label>
									<div class="col-md-9">
										<input name="hotelName" type="text" class="form-control" 
											placeholder="輸入hotelName" value="${param.hotelName}" />${errMap.hotelNameErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">E-mail:</label>
									<div class="col-md-9">
										<input name="email" type="text" class="form-control" 
											placeholder="輸入email" value="${param.email}" />${errMap.emailErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">密碼:</label>
									<div class="col-md-9">
										<input name="pw" type="password" class="form-control" 
											placeholder="輸入密碼"/>${errMap.pwErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">確認密碼:</label>
									<div class="col-md-9">
										<input name="pwcheck" type="password" class="form-control" 
											placeholder="輸入密碼"/>${errMap.pwcheckErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">飯店星等:</label>
									<div class="col-md-9">
										<select name="star" id="star" class="form-control" >
											<option value="0">-</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
										</select>${errMap.starErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 17px;">登記人姓名:</label>
									<div class="col-md-9">
										<input name="registerName" type="text" class="form-control" 
											placeholder="輸入登記人姓名" value="${param.registerName}" />${errMap.registerNameErrs}
									</div>
								</div>
							</div>							
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">登記證號:</label>
									<div class="col-md-9">
										<input name="registerId" type="text" class="form-control" 
											placeholder="輸入登記證號" value="${param.registerId}" />${errMap.registerNameErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">連絡電話:</label>
									<div class="col-md-9">
										<input name="tel" type="text" class="form-control" 
											placeholder="輸入電話" value="${param.tel}" />${errMap.telErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">地址:</label>
									<div class="col-md-9">
										<input name="addr" type="text" class="form-control" 
											placeholder="輸入地址" value="${param.addr}" />${errMap.addrErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">地區:</label>
									<div class="col-md-9">
										<input name="zone" type="text" class="form-control" 
											placeholder="輸入地區" value="${param.zone}" />${errMap.zoneErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">交通方式:</label>
									<div class="col-md-9">
										<textarea name="transport"  class="form-control" 
											placeholder="輸入交通方式"  >${param.transport}</textarea>${errMap.transportErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">官方網站:</label>
									<div class="col-md-9">
										<input name="website" type="text" class="form-control" 
											placeholder="輸入官方網站網址" value="${param.website}" />${errMap.websiteErr}
									</div>
								</div>
							</div>
							
							<%-- 原本的code		<td><input type="file" name="photo"/>${errMap.photoErr}</td>									 --%>
							<div class="form-group col-md-12">
								<div class="col-md-3">
									<label class="control-label " style="font-size: 18px;">上傳照片:</label>
								</div>
    							<input type="file" name="photo" multiple=""> 
   									<div class="input-group col-md-9s"> 
        								<input type="text" readonly="" class="form-control" placeholder="上傳照片">${errMap.photoErr} 
        									<span class="input-group-btn input-group-sm"> 
            									<button type="button" class="btn btn-just-icon btn-warning"> 
                									<i class="material-icons">attach_file</i> 
             									</button>
        									</span> 
    								</div>
								</div>										
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">飯店介紹:</label>
									<div class="col-md-9">
										<textarea name="hotelProfile"  class="form-control" 
											placeholder="輸入飯店介紹(基本300個字)"  >${param.hotelProfile}</textarea>${errMap.hotelProfileErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">Check-in:</label>
									<div class="col-md-9">
										<input name="checkin" type="text" class="form-control " 
											placeholder="輸入Check-in時間，例:08:00 AM" value="${param.checkin}" />${errMap.checkinErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 17px;">Check-out:</label>
									<div class="col-md-9">
										<input name="checkout" type="text" class="form-control " 
											placeholder="輸入Check-out時間，例:15:00 PM" value="${param.checkout}" />${errMap.checkoutErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">入住須知:</label>
									<div class="col-md-9">
										<textarea name="hotelProfile"  class="form-control" rows="5"
											placeholder="入住須知介紹(基本300個字)"  >${param.guestPolicies}</textarea>${errMap.guestPoliciesErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">取消規定:</label>
									<div class="col-md-9">
										<textarea name="cancelPolicies"  class="form-control" 
											placeholder="取消規定介紹(基本300個字)"  >${param.cancelPolicies}</textarea>${errMap.cancelPoliciesErr}
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-3" style="font-size: 18px;">設施:</label>
									<div class="col-md-12">
										<div class="checkbox" >
											<label style="margin-left:20px">
												<input type="checkbox" name="roomWifi" checked>室內wifi
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="hallWifi" checked>大廳wif
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="internet" checked>大廳網際網路
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="mineralWater" checked>礦泉水
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="toiletUtensils" checked>盥洗用具
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="hairDryer" checked>吹風機
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="tv" checked>電視
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="gameRoom" checked>遊戲室 
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="gym" checked>健身房
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="spa" checked>溫泉
											</label>
											<label style="margin-left:20px">
												<input type="checkbox" name="swimPools" checked>游泳池
											</label>																																																																																																			
										</div>
									</div>
								</div>
							</div>
							
							<input type="submit" class="btn btn-danger" value="註冊" style="float:right; margin:50px 50px 0px 50px; width:280px ">
							<input type="reset" class="btn btn-default" value="清除" style="float:left; margin:50px 50px 0px 50px; width:280px ">
							<button type="button" id="onekey" class="btn btn-primary btn-simple" style="float: right; margin:0px 50px 0px 20px">一鍵輸入</button>
							<button type="button" id="but" class="btn btn-primary btn-simple" style="float: right; margin:0px 50px 0px 0px">秀value</button>	
																																																																																																																								
						</div><!-- <div class="row modal-body "> -->
					</form>
				</div> <!-- class="card " -->
			</div><!-- <div class="col-md-8"> -->
		</div><!-- div class="row col-md-offset-3" -->
	</div><!-- div class="container" -->
	
	<!-- 本頁內容從這裡開始 -->
	<!-- 	<div class="container" -->
	<!-- 		style="background-color: white; padding-bottom: 100px;"> -->
	<!-- 		<h1>業者註冊</h1> -->

	<!-- 		<form action="Registerhotel.do" method="post" enctype="multipart/form-data"> -->
	<!-- 		<table class=""> -->
	<!-- 			<tbody> -->
	<!-- 			<tr> -->
	<!-- 				<td>飯店名稱</td> -->
	<%-- 				<td><input type="text" name="hotelName" value="${param.hotelName}"/>${errMap.hotelNameErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>E-mail</td> -->
	<%-- 				<td><input type="text" name="email" value="${param.email}"/>${errMap.emailErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>密碼</td> -->
	<%-- 				<td><input type="password" name="pw" />${errMap.pwErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>確認密碼</td> -->
	<%-- 				<td><input type="password" name="pwcheck" />${errMap.pwcheckErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>飯店星等</td> -->
	<!-- 				<td> -->
	<!-- 					<select id="star" name="star"> -->
	<!-- 						<option value="0">-</option> -->
	<!-- 						<option value="1">1</option> -->
	<!-- 						<option value="2">2</option> -->
	<!-- 						<option value="3">3</option> -->
	<!-- 						<option value="4">4</option> -->
	<!-- 						<option value="5">5</option> -->
	<%-- 					</select>${errMap.starErr} --%>
	<!-- 				</td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>登記人姓名</td> -->
	<%-- 				<td><input type="text" name="registerName" value="${param.registerName}"/>${errMap.registerNameErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>登記證號</td> -->
	<%-- 				<td><input type="text" name="registerId" value="${param.registerId}"/>${errMap.registerIdErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>連絡電話</td> -->
	<%-- 				<td><input type="text" name="tel" value="${param.tel}"/>${errMap.telErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>地址</td> -->
	<%-- 				<td><input type="text" name="addr" value="${param.addr}"/>${errMap.addrErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>地區</td> -->
	<%-- 				<td><input type="text" name="zone" value="${param.zone}"/>${errMap.zoneErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>交通方式</td> -->
	<%-- 				<td><textarea name="transport" >${param.transport}</textarea>${errMap.transportErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>官方網站</td> -->
	<%-- 				<td><input type="text" name="website" value="${param.website}"/>${errMap.websiteErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>上傳照片</td> -->
	<%-- 				<td><input type="file" name="photo"/>${errMap.photoErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>飯店介紹</td> -->
	<%-- 				<td><textarea name="hotelProfile" >${param.hotelProfile}</textarea>${errMap.hotelProfileErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Check-in時間</td> -->
	<%-- 				<td><input type="text" class="timepicker1" name="checkin" value="${param.checkin}"/>${errMap.checkinErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Check-out時間</td> -->
	<%-- 				<td><input type="text" class="timepicker2" name="checkout" value="${param.checkout}"/>${errMap.checkoutErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>入住須知</td> -->
	<%-- 				<td><textarea name="guestPolicies" >${param.guestPolicies}</textarea>${errMap.guestPoliciesErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>取消規定</td>  -->
	<%-- 				<td><textarea name="cancelPolicies" >${param.cancelPolicies}</textarea>${errMap.cancelPoliciesErr}</td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>設施</td> -->
	<!-- 				<td> -->
	<!-- 					<input type="checkbox" name="roomWifi"/>室內wifi -->
	<!-- 					<input type="checkbox" name="hallWifi"/>大廳wifi -->
	<!-- 					<input type="checkbox" name="internet"/>網際網路 -->
	<!-- 					<input type="checkbox" name="mineralWater"/>礦泉水 -->
	<!-- 					<input type="checkbox" name="toiletUtensils"/>盥洗用具 -->
	<!-- 					<input type="checkbox" name="hairDryer"/>吹風機 -->
	<!-- 					<input type="checkbox" name="tv"/>電視 -->
	<!-- 					<input type="checkbox" name="gameRoom"/>遊戲室 -->
	<!-- 					<input type="checkbox" name="gym"/>健身房 -->
	<!-- 					<input type="checkbox" name="spa"/>溫泉 -->
	<!-- 					<input type="checkbox" name="swimPool"/>游泳池 -->
	<!-- 				</td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td><input type="submit" value="送出"></td> -->
	<!-- 				<td><input type="reset" value="清除"></td> -->
	<!-- 				<td><input id="onekey" type="submit" value="一鍵輸入"></td> -->
	<!-- 				<td><button type="button" id="but">秀value</button></td> -->
	<!-- 			</tr> -->
	<!-- 			</tbody> -->
	<!-- 		</table> -->
	<!-- 		</form> -->
	<!-- 	</div> -->

	<!-- 本頁內容結束 -->

	<!--開始footer-->
	<jsp:include page="../fragment/footer.jsp" />
	<!--結束footer-->

	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/material.min.js"></script>

	<script src="../js/material-kit.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
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
		$('#but').click(function(){
			console.log($('#photo'));
		});
	});
	</script>
</body>
</html>