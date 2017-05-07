<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty HotelLoginOK}">
	<c:redirect url="/hotel/loginhotel.jsp"></c:redirect>
</c:if>
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
<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link
	href="${pageContext.servletContext.contextPath}/css/material-kit.css"
	rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/fullcalendar.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/sweetalert2.css"
	rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<style>
	#calendar {
/* 		float: right; */
        margin: 0 auto;
        padding: 15px;
/*  		width: 900px; */
		background-color: #FFFFFF;
		  border-radius: 6px;
        box-shadow: 0 1px 2px #C3C3C3;
		}
</style>


<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->

	<div class="container" style="margin-top: 100px;">

		<select>
				<option selected>請選擇房型</option>
			<c:forEach var="roomType" items="${roomTypeList}">
				<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
			</c:forEach>
		</select>
		<div id="checkbox">
		</div>
		<div class="checkbox">
					<label> <input type="checkbox" name="weekday"
						value="1"> 星期一
					</label> <label> <input type="checkbox" name="weekday"
						value="2"> 星期二
					</label> <label> <input type="checkbox" name="weekday" value="3">
						星期三
					</label>
					<label> <input type="checkbox" name="weekday" value="4">
						星期四
					</label>
					<label> <input type="checkbox" name="weekday" value="5">
						星期五
					</label>
					<label> <input type="checkbox" name="weekday" value="6">
						星期六
					</label>
					<label> <input type="checkbox" name="weekday" value="0">
						星期日
					</label>
				</div>
		<button class="btn btn-info" id="plus">+</button>
		<button class="btn btn-info" id="showJson">showJson</button>
		<div id="calendar"></div>
		<button class="btn btn-info" id="submit">新增</button>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <p></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-info btn-simple">Save</button>
      </div>
    </div>
  </div>
</div>
	</div>

	<!--開始footer-->
	<jsp:include page="../fragment/footer.jsp" />
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
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

<script src="${pageContext.servletContext.contextPath}/js/moment.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/fullcalendar.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/jquery-ui.custom.min.js"></script>
	
<script
	src="${pageContext.servletContext.contextPath}/js/sweetalert2.min.js"></script>

<script>
	$(function() {
		//選擇房型後更新日曆，並生成價錢選擇
		$('select').change(function() {
			var events = {
				url : '/iCastle/rooms/MonthRoomsToJson',
				data : {
					hotelId : '${HotelLoginOK.hotelId}',
					roomTypeId : $('select').val(),
				}
			}

// 			$('#calendar').fullCalendar( 'removeEventSource', events);
			$('#calendar').fullCalendar('removeEventSources');
			$('#calendar').fullCalendar('addEventSource', events);
			$('#calendar').fullCalendar('refetchEvents');
			
			
			$.getJSON("/iCastle/roomtype/RoomTypePriceToJson",{"roomTypeId" : $('select').val()},
					function(data){
						var checkbox_div = $('#checkbox');
						checkbox_div.empty();
						$.each(data, function(i, price){
							var label_weekdaysPrice = $('<label></label>');
							var input_weekdaysPrice = $('<input/>').attr({type : "radio", value : price.weekdaysPrice, name : "price"});
							label_weekdaysPrice.append(input_weekdaysPrice);
							label_weekdaysPrice.append("平日價");
							
							var label_holidayPrice = $('<label></label');
							var input_holidayPrice = $('<input/>').attr({type : "radio", value : price.holidayPrice, name : "price"});
							label_holidayPrice.append(input_holidayPrice);
							label_holidayPrice.append("假日價");
							
							var label_seasonPrice = $('<label></label');
							var input_seasonPrice = $('<input/>').attr({type : "radio", value : price.seasonPrice, name : "price"});
							label_seasonPrice.append(input_seasonPrice);
							label_seasonPrice.append("旺季價");
							
							var label_customizedPrice = $('<label></label');
							var input_customizedPrice = $('<input/>').attr({type : "radio", value : price.customizedPrice, name : "price"});
							label_customizedPrice.append(input_customizedPrice);
							label_customizedPrice.append(price.customizedName);
							checkbox_div.append([label_weekdaysPrice, label_holidayPrice, label_seasonPrice, label_customizedPrice]);
						})
				
			})
			
			json.length = 0;
			
		})

		$('#calendar').fullCalendar({
			header: {
				left: 'title',
				right: 'prev,next today'
			},
			eventSources : [ {
				url : '/iCastle/rooms/MonthRoomsToJson',
				data : {
					hotelId : '${HotelLoginOK.hotelId}',
					roomTypeId : $('select').val(),
				},
				error : function() {
					swal({
						title : '請先選擇房型',
						type : 'info',
					})
				}
			} ],
			dayClick: function(date, jsEvent, view){
				$('#myModal').modal('show');
			},
			eventClick: function(calEvent, jsEvent, view){
				$('.modal-body p').text("roomId = " + calEvent.roomId);
				$('#myModal').modal('show');
				console.log(calEvent.id);
				console.log(calEvent.start._i);
				console.log(calEvent);
			}
		})

		$('#plus').click(function(e) {
			add()
		})

		var weekdaycheck = [];
		var json = [];
		
		$('input[name=weekday]').click(function(){
			var weekdayNum = $(this).val();
			if(weekdaycheck.length > 0){
				for(var i = 0; i < weekdaycheck.length; i++){
					if(weekdaycheck[i] == parseInt(weekdayNum)){
						delete weekdaycheck[i];
					}
				}
			}
			weekdaycheck.push(parseInt(weekdayNum));
		});

		$('#showJson').click(function() {
			alert(JSON.stringify(json))
		})

		function add() {
			$('#calendar')
					.fullCalendar(
							'addEventSource',
							function(start, end, timezone, callback) {
								var events = [];
								var startd = new Date(start);
								var endd = new Date(end);
								var end = endd.getTime();
								var price = $('input[name=price]:checked').val();
								
								if(weekdaycheck.length > 0 && !(price == null)){
									for (var loop = startd.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
										var date = new Date(loop);
										var eventoObj = $("#calendar").fullCalendar( 'clientEvents', moment(date).format('YYYY-MM-DD'))[0];
										for(var i = 0; i < weekdaycheck.length; i++){
											if (date.getDay() == weekdaycheck[i] && eventoObj == null) {
												events.push({
													id : moment(date).format('YYYY-MM-DD'),
													title : price,
													start : moment(date).format('YYYY-MM-DD'),
													color : 'lightgreen',
													allDay : 'true',
													className : 'success',
												});
												json.push({
													date : moment(date).format('YYYY-MM-DD'),
													price : $('input[name=price]:checked').val(),
												});
											}else if(date.getDay() == weekdaycheck[i]){
												eventoObj.title = price;
												eventoObj.color = 'lightgreen';
												$('#calendar').fullCalendar('updateEvent', eventoObj);
												json.push({
													roomId : eventoObj.roomId,
													date : moment(date).format('YYYY-MM-DD'),
													price : $('input[name=price]:checked').val(),
												});
											}
										}
									}
								}else{
									swal({
										title : '請先選擇價錢及星期',
										type : 'error',
									})
								}
								weekdaycheck.length = 0;
								$('input[name=weekday]').removeAttr("checked");
								callback(events);
							})
		}
		
		$('#submit').click(function(){
			$.ajax({
				type : 'POST',
				url : '/iCastle/rooms/SetRoomPrice',
				data : {
					jsonData : JSON.stringify(json),
					roomTypeId : $('select').val(),
				},
				success : function(){
					swal({
						title : '新增成功',
						type : 'success',
					})
				}
			})
			json.length = 0;
			var events = {
					url : '/iCastle/rooms/MonthRoomsToJson',
					data : {
						hotelId : '${HotelLoginOK.hotelId}',
						roomTypeId : $('select').val(),
					}
				}

//	 			$('#calendar').fullCalendar( 'removeEventSource', events);
				$('#calendar').fullCalendar('removeEventSources');
				$('#calendar').fullCalendar('addEventSource', events);
				$('#calendar').fullCalendar('refetchEvents');
		})

	});
</script>

</html>