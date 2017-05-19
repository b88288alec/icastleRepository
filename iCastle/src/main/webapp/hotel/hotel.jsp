<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
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
<link
	href="${pageContext.servletContext.contextPath}/css/material-kit.css"
	rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css"
	rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<link href="${pageContext.servletContext.contextPath}/css/hotel.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/lightbox.min.css"
	rel="stylesheet" />

<title>愛客宿-iCastle</title>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
	#map {
        height: 600px;
        width: 850px;  
	}
	#smallImg{
		width:300px;
/*         -webkit-filter: brightness(70%); /* Safari 6.0 - 9.0 */ */
/* 		filter: brightness(70%); */
	}
	#smallImg:hover{
		width:300px;
         -webkit-filter: brightness(80%); /* Safari 6.0 - 9.0 */ 
 		filter: brightness(80%); 
	}

</style>
</head>
<body>
	<!--開始導覽列--> 
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->

	<!--上方搜尋列-->
	<div class="container-fluid search-row">
		<div class="row" style="background-color: #607D8B; width: 100%">
			<div class="col-md-10 col-md-offset-1">
				<form action="ShowHotel.do" method="get">
					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
						<input type="text" class="form-control" placeholder="輸入區域或飯店名稱"
							name="type" value="${param.type}" />
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
						<input type="text" id="startDate" class="form-control datepicker"
							placeholder="輸入入住日期" name="start" value="${param.start}" />
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
						<input type="text" id="endDate" class="form-control datepicker"
							placeholder="輸入退房日期" name="end" value="${param.end}" />
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
						<input type="text" class="form-control" placeholder="輸入入住人數"
							name="peopleNum" value="${param.peopleNum}" />
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="col-md-2 col-xs-12 col-sm-4">
						<input type="submit" class="btn btn-success"
							style="width: 80%; margin-bottom: 0px; margin-top: 20px"
							value="搜尋" />
						<input type="hidden" name="hotelId" value="${hotelId}">
					</div>
					
				</form>
			</div>
		</div>
	</div>
	<!--結束上方搜尋列-->

	<div class="container"
		style="background-color: white; padding-bottom: 100px;">
		<div class="row">
			<div class="col-md-10" style="margin-bottom: 1%">
				<h1>${hotel.hotelName}</h1>
				<div style="margin-bottom: 5px">
					<!-- 飯店星等 -->
					<c:forEach var="i" varStatus="varsts" begin="1" end="5">
						<c:choose>
							<c:when test="${i<=hotel.star}">
								<img
									src="${pageContext.servletContext.contextPath}/img/star.png"
									width="20px" />
							</c:when>
							<c:otherwise>
								<img
									src="${pageContext.servletContext.contextPath}/img/unstar.png"
									width="20px" />
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 飯店星等結束 -->
				</div>
				<small>${hotel.addr}</small>
			</div>
			<div class="col-md-2">
				<div class="gradeRound">
					<p>${hotel.point}</p>
				</div>
				<p class="hot">熱門度:${hotel.hot}</p>
			</div>

			<!--飯店圖片-->
			<div class="col-md-12">
				<div class="gallery">

					<!--秀出飯店圖片 -->
					<c:forEach var="photo" items="${photos}" varStatus="loop">

						<c:if test="${loop.index == 0}">
							<div class="frist-img">
								<img
									src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									width="700" height="389" /> <a
									href="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									data-lightbox="hotel-imgs"
									data-title="${photo.pohtoDescription}">
									<div class="overlay">
										<h3
											style="color: white; position: absolute; bottom: 10px; left: 10px;">${photo.pohtoDescription}</h3>
									</div>
								</a>
							</div>
						</c:if>

						<c:if test="${loop.index == 1}">
							<div class="second-img">
								<img
									src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									width="550" height="189" /> <a
									href="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									data-lightbox="hotel-imgs"
									data-title="${photo.pohtoDescription}">
									<div class="overlay">
										<h3
											style="color: white; position: absolute; bottom: 10px; left: 10px;">${photo.pohtoDescription}</h3>
									</div>
								</a>
							</div>
						</c:if>

						<c:if test="${loop.index == 2}">
							<div class="thrid-img">
								<img
									src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									width="268" height="189" /> <a
									href="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									data-lightbox="hotel-imgs"
									data-title="${photo.pohtoDescription}">
									<div class="overlay">
										<h3
											style="color: white; position: absolute; bottom: 10px; left: 10px;">${photo.pohtoDescription}</h3>
									</div>
								</a>
							</div>
						</c:if>

						<c:if test="${loop.index == 3}">
							<div class="fourth-img">
								<img
									src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									width="268" height="189" /> <a
									href="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									data-lightbox="hotel-imgs"
									data-title="${photo.pohtoDescription}">
									<div class="overlay">
										<h3
											style="color: white; position: absolute; bottom: 10px; left: 10px;">${photo.pohtoDescription}</h3>
									</div>
								</a>
							</div>
						</c:if>

						<c:if test="${loop.index > 3}">
							<!-- 第5張以後的圖片 -->
							<div style="display: none">
								<a
									href="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}"
									data-lightbox="hotel-imgs"
									data-title="${photo.pohtoDescription}"> <img
									src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}" /></a>
							</div>
						</c:if>

					</c:forEach> 


					<div style="clear: both"></div>
				</div>
			</div>
			<!--結束飯店圖片-->
			
			<!-- 地圖預覽 -->
			<div id="smallImgDiv">
				<img id="smallImg" src="../img/map.jpg">
			</div>
			
			<!-- 開始google地圖的Modal -->
			<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
			  <div class="modal-dialog modal-lg" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">地圖</h4>
			      </div>
			      <div class="modal-body">
			        
			        <div id="map"></div>
			        
			      </div>
<!-- 			      <div class="modal-footer"> -->
<!-- 			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
<!-- 			        <button type="button" class="btn btn-primary">Save changes</button> -->
<!-- 			      </div> -->
			    </div>
			  </div>
			</div>
			<!-- 結束google地圖的Modal -->
			
			<!--聯絡與設施-->
			<div class="col-md-12 connect-checkin">
				<div class="col-md-4">
					<p style="font-size: 20px;">聯絡資訊&入/退房時間</p>
				</div>
				<div class="col-md-2">
					<i class="material-icons green200">call</i>
					<p>${hotelInfo.tel}</p>
				</div>
				<div class="col-md-2">
					<i class="material-icons green200">mail</i>
					<p>${hotel.email}</p>
				</div>
				<div class="col-md-2">
					<i class="material-icons green200">access_time</i>
					<p>${hotelInfo.checkin}</p>
				</div>
				<div class="col-md-2">
					<i class="material-icons green200">access_time</i>
					<p>${hotelInfo.checkout}</p>
				</div>
			</div>
			<div class="col-md-12 facility-service">
				<div class="col-md-4">
					<p style="font-size: 20px;">熱門設施&服務</p>
				</div>

				<c:if test="${hotelInfo.roomWifi}">
					<div class="col-md-2">
						<i class="material-icons green200">wifi</i>
						<p>室內wifi</p>
					</div> 
				</c:if>

				<c:if test="${hotelInfo.gameRoom}">
					<div class="col-md-2">
						<i class="material-icons green200">casino</i>
						<p>遊戲室</p>
					</div>
				</c:if>

				<c:if test="${hotelInfo.gym}">
					<div class="col-md-2">
						<i class="material-icons green200">fitness_center</i>
						<p>健身房</p>
					</div>
				</c:if>

				<c:if test="${hotelInfo.gym}">
					<div class="col-md-2">
						<i class="material-icons green200">pool</i>
						<p>游泳池</p>
					</div>
				</c:if>
				<!-- 				<div class="col-md-2"> -->
				<!-- 					<i class="material-icons green200">spa</i> -->
				<!-- 					<p>spa</p> -->
				<!-- 				</div> -->


				<!--<div class="col-md-2">
                    <i class="material-icons green200">hot_tub</i>
                    <p>溫泉</p>
                </div>-->
			</div>
			<!--結束聯絡與設施-->
 
		</div> 

		<div class="row" style="margin-bottom: 50px;">

			<!--房型資訊-->
			<div class="col-md-12">
				<div class="page-header">
					<h3>房型資訊:</h3>
				</div>
				<table class="table table-bordered table-condensed" style="">
					<thead>
						<tr>
							<th class="text-center col-md-2">房型名稱與照片</th>
							<th class="text-left col-md-3">附設服務</th>
							<th class="text-center col-md-1">可否加床</th>
							<th class="text-center col-md-3">每晚均價/每房</th>
							<th class="text-center">預定房數</th>
							<th class="text-center">我要預訂</th>
						</tr>
					</thead>
					<!--迴圈從這裡開始-->
					<tbody>
						<!-- 一筆又一筆的房間 -->
						<c:forEach var="room" items="${rooms}">
							<form action="${pageContext.servletContext.contextPath}/members/rooms/Rooms.do" name="form">
								<!-- 					<form action="Test2Servlet" name="form"> -->
								<tr>
									<!--房型照片-->
									<td class="text-center" style="vertical-align: middle"><strong
										style="font-size: 18px">${room.roomTypeName}</strong>
										<div style="margin: 20px;"> 
											<img src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${room.roomTypeId}&type=roomtypeid"
												width="180" height="90" />
										</div></td>
									<!--結束房型照片-->
									<!--房間附設服務-->
									<td style="vertical-align: middle"><c:if
											test="${room.breakfast}">
											<div class="check">
												<div>
													<i class="material-icons green200">check</i>
												</div>
												<div>
													<p>早餐</p>
												</div>
											</div>
										</c:if> <c:if test="${room.afternoonTea}">
											<div class="check">
												<div>
													<i class="material-icons green200">check</i>
												</div>
												<div>
													<p>下午茶</p>
												</div>
											</div>
										</c:if> <c:if test="${room.dinner}">
											<div class="check">
												<div>
													<i class="material-icons green200">check</i>
												</div>
												<div>
													<p>晚餐</p>
												</div>
											</div>
										</c:if> <!--                                 <div class="check"> -->
										<!--                                     <div> --> <!--                                         <i class="material-icons green200">check</i> -->
										<!--                                     </div> --> <!--                                     <div> -->
										<!--                                         <p>免費Wi-Fi</p> -->
										<!--                                     </div> --> <!--                                 </div> -->
									</td>
									<!--結束房間附設服務-->
									<!--可否加床-->
									<td class="text-center" style="vertical-align: middle"><c:choose>
											<c:when test="${room.bedAddable}">
												<div class="check">
													<div>
														<i class="material-icons green200">check</i>
													</div>
													<div>
														<p>可加床</p>
														<div class="bed">
															<select name="bedAdding">
																<option value="true">加床</option>
																<option value="false" selected>不加床</option>
															</select>
														</div>
													</div>
												</div>
											</c:when>
											<c:otherwise>
												<div class="uncheck">
													<div>
														<i class="material-icons orange500 md-28">not_interested</i>
													</div>
													<div>
														<p>不可加床</p>
													</div>
												</div>
											</c:otherwise>
										</c:choose></td>
									<!--可否加床-->
									<!--每晚均價-->
									<td class="text-center" style="vertical-align: middle">
										<div class="price">
											<span>NT </span> <span>${room.price}</span>
											<button type="button" rel="tooltip" title="${room.remark}"
												class="btn btn-primary btn-simple btn-xs">
												<i class="material-icons md-24">info</i>
											</button>
										</div>
									</td>
									<!--結束每晚均價-->
									<!--預定房數-->
									<td class="text-center" style="vertical-align: middle"><select
										name="roomCount">
											<c:forEach var="i" begin="1"
												end="${room.roomNumber-room.bookedNum}">
												<option value="${i}">${i}</option>
											</c:forEach>
									</select></td>
									<!--結束預定房數-->
									<!-- 預訂按鈕以及傳送資訊 -->
									<td class="text-center" style="vertical-align: middle"><input
										type="submit" class="btn btn-success" value="預定" /><br>
										<p style="color: red">剩下${room.roomNumber-room.bookedNum}間</p>
										<input type="hidden" name="roomId" value="${room.roomId}" />
										<input type="hidden" name="hotelId" value="${room.hotelId}" />
										<input type="hidden" name="hotelName"
										value="${hotel.hotelName}" /> <input type="hidden"
										name="roomTypeId" value="${room.roomTypeId}" /> <input
										type="hidden" name="roomTypeName" value="${room.roomTypeName}" />
										<input type="hidden" name="start" value="${param.start}" /> <input
										type="hidden" name="end" value="${param.end}" /> <input
										type="hidden" name="peopleNum" value="${param.peopleNum}" />
										<input type="hidden" name="breakfast"
										value="${room.breakfast}" /> <input type="hidden"
										name="dinner" value="${room.dinner}" /> <input type="hidden"
										name="afternoonTea" value="${room.afternoonTea}" /> <input
										type="hidden" name="price" value="${room.price}" /> <%--                                     <input type="hidden" name="bedAddable" value="${room.bedAddable}" /> --%>
										<input type="hidden" name="pricePerPerson"
										value="${room.pricePerPerson}" />
										<input type="hidden" name="remark" value="${room.remark}" />
										<input type="hidden" name="action" value="getOrder" /></td>
										<input type="hidden" name="guestPolicies" value="${hotelInfo.guestPolicies}"/>
										<input type="hidden" name="cancelPolicies" value="${hotelInfo.cancelPolicies}"/>
									<!-- 結束預訂按鈕以及傳送資訊 -->
								</tr>
							</form>
						</c:forEach>
						<!-- 一筆又一筆的房間結束 -->
					</tbody>
					<!--迴圈到這裡結束-->


				</table>
			</div>
			<!--結束房型資訊-->
		</div>

		<div class="row">

			<div class="col-md-12"
				style="border-bottom: 1px solid #ECEFF1; padding-top: 20px; padding-bottom: 20px;">
				<div class="page-header">
					<h3>關於${hotel.hotelName}</h3>
				</div>
				<div class="col-md-2"> 
					<h4>簡介</h4>
				</div>
				<div class="col-md-10">
					<p>${hotelInfo.hotelProfile}</p>
				</div>
			</div>
			<div class="col-md-12"
				style="border-bottom: 1px solid #ECEFF1; padding-top: 20px; padding-bottom: 20px;">
				<div class="col-md-2">
					<h4>服務設施</h4>
				</div>
				<div class="col-md-10">
					<p>網路服務</p>
					<div class="facility-detail">
						<div>
							<i class="material-icons md-dark">language</i>
						</div>
						<div>
							<small>有線網路</small>
						</div>
					</div>
					<div class="facility-detail">
						<div>
							<i class="material-icons md-dark">wifi</i>
						</div>
						<div>
							<small>公共區域免費Wi-Fi</small>
						</div>
					</div>
					<div class="facility-detail">
						<div>
							<i class="material-icons md-dark">hotel</i>
						</div>
						<div>
							<small>所有房型皆附免費Wi-Fi</small>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-md-12"
				style="border-bottom: 1px solid #ECEFF1; padding-top: 20px; padding-bottom: 20px;">
				<div class="col-md-2">
					<h4>交通方式</h4>
				</div>
				<div class="col-md-10">
					<pre>${hotelInfo.transport}</pre>
				</div>
			</div>
			
			<div class="col-md-12"
				style="border-bottom: 1px solid #ECEFF1; padding-top: 20px; padding-bottom: 20px;">
				<div class="col-md-2">
					<h4>入住須知</h4>
				</div>
				<div class="col-md-10">
					<pre>${hotelInfo.guestPolicies}</pre>
				</div>
			</div>
			
			<div class="col-md-12"
				style="border-bottom: 1px solid #ECEFF1; padding-top: 20px; padding-bottom: 20px;">
				<div class="col-md-2">
					<h4>取消規定</h4>
				</div>
				<div class="col-md-10">
					<pre>${hotelInfo.cancelPolicies}</pre>
				</div>
			</div>
			
		</div>
	</div>

	<!-- 開始飯店評論 -->
	<!-- ================原本code============================== -->
<!-- 	<div> -->
<%-- 	   <c:forEach var="comment" items="${NETList}"> --%>
<%--     <h5>${comment.name}</h5> --%>
<%--     <h5>${comment.email}</h5> --%>
<%--     <h5>${comment.comment}</h5> --%>
<%--     	<c:forEach var="photo" items="${comment.ids}"> --%>
<%--     	<img src="http://localhost:8081/iCastle/comment/CommentPhotosServlet?id=${photo}"> --%>
<%--     	</c:forEach> --%>
<%--     </c:forEach> --%>
<!-- 	</div> -->
	<!-- ===================================================== -->
	<div class="container" >		
		<div class="row">
			<div class="col-md-12" style="padding-bottom: 20px;">
				<div calss="col-md-2" style="border-bottom: 1px solid #ECEFF1"><h3>評論</h3></div>
				<c:forEach var="comment" items="${NETList}">
					<div class="row" style="border-bottom: 1px solid #ECEFF1;"> <!-- 每一個則評論都是row -->
						<div class="col-md-4" style="float: left;padding:50px;text-align:center">
							<h4>${comment.name}</h4>
							<h5>${comment.email}</h5>
							<!-- 這裡加入星星分數 -->
							
						</div>
						<div class="col-md-8" style="padding:20px;float:right">	
							<h5>${comment.comment}</h5>
						</div>
						<div class="col-md-8" style="float:right;padding:20px 0px">	
							<c:forEach var="photo" items="${comment.ids}">
								<div class="col-md-4">
									<img src="${pageContext.servletContext.contextPath}/comment/CommentPhotosServlet?id=${photo}" 
									class="img-rounded" width="100%" style="padding:5px 0px" ></div>
							</c:forEach>
						</div>
					</div><!-- div class="row" -->
				</c:forEach>
			</div><!-- div class="col-md-12" -->
		</div>
</div>				
	<!-- 結束飯店評論 -->
	
	<!--開始footer-->
	<jsp:include page="../fragment/footer.jsp" />
	<!--結束footer-->

	<script
		src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

	<script src="../js/magnific-popup.js"></script>
	<script src="../js/lightbox.min.js"></script>
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCn7jC3DDQXAbDR9-IDsCnNL79Hsuz-55k&callback=initMap"
  type="text/javascript"></script>

	<script>
		
	//取得地址陣列
	var address = [
	<c:forEach var="addr" items="${address}" varStatus="loop">
		'${addr}'
		<c:choose>
			<c:when test="${loop.last}">
				];
			</c:when>
			<c:otherwise>
				,
			</c:otherwise>
		</c:choose>
		
	</c:forEach>
	
	//初始化地圖
	
	var map = null;
	var currentCenter = null;
	var geocoder = null;
	
	function initMap(){
		map = new google.maps.Map(document.getElementById("map"), {
			center: {
	                   "lat" : 25.042787,
	                   "lng" : 121.509309
	                },
			zoom:14
		});
		geocoder  = new google.maps.Geocoder();
		geocodeAddress(geocoder, map);
	} 
	
	//將地址轉換成坐標
	function geocodeAddress(geocoder, map){
		console.log(address[0]);
		//設定center
		geocoder.geocode( {"address" : address[0]}, function(results, status){
			if (status == google.maps.GeocoderStatus.OK) {
				//設定新的center
				currentCenter = results[0].geometry.location; 
				map.setCenter(currentCenter);
				
				//設定做為center的marker
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location
				});
				
			} else 
				console.log("無法轉換..."+ status);
		})
	}
	
	var j=1;
	
	setTimeout(setMarker, 1000);
	
	//取得地址並設定marker唷
	function setMarker(){
		geocoder.geocode( {"address" : address[j]}, function(results, status){
			if (status == google.maps.GeocoderStatus.OK) {
				console.log("成功轉換...地址:" + address[j] + results[0].geometry.location);
				//設定marker
				var pinColor = "66B3FF";
				var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + pinColor,
			        new google.maps.Size(21, 34),
			        new google.maps.Point(0,0));
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location,
					icon : pinImage
				});
				j++;
				if (j<address.length)
					setMarker();
			} else {
				console.log("無法轉換...地址:" + address[j] + status);
				setTimeout(setMarker, 200);
			}
		})	
	}
	
	$(document)
	.ready(
			function() {
				$('.popup-gallery')
						.magnificPopup(
								{
									delegate : 'a',
									type : 'image',
									tLoading : 'Loading image #%curr%...',
									mainClass : 'mfp-img-mobile',
									gallery : {
										enabled : true,
										navigateByImgClick : true,
										preload : [ 0, 1 ]
									// Will preload 0 - before current, and 1 after the current image
									},
									image : {
										tError : '<a href="%url%">The image #%curr%</a> could not be loaded.',
										titleSrc : function(item) {
											return item.el
													.attr('title')
													+ '<small>by Marsel Van Oosten</small>';
										}
									}
								});
				lightbox.option({
					'wrapAround' : true
				})
				
				$('#smallImg').click(function(){
					$('#myModal').modal('show');
					
				})
				
				$("#myModal").on("shown.bs.modal", function () {
				    google.maps.event.trigger(map, "resize");
					map.setCenter(currentCenter);
				});
			});
	</script>
</body>
</html>