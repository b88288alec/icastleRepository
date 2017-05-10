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
	href="${pageContext.servletContext.contextPath}/css/_materialFullCalendar.css"
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
					<label> <input type="checkbox" name="weekday" value="0">
						星期日
					</label>
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
        <h4 class="modal-title" id="myModalLabel"></h4>
      </div>
      <div class="modal-body">
      	<h3>請選擇價錢</h3>
        <div id="price-select"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-info btn-simple" id="submit-single">修改</button>
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
	src="${pageContext.servletContext.contextPath}/js/sweetalert2.min.js"></script>

<script>
	$(function() {
		//選擇房型後更新日曆
		$('select').change(function() {
			var events = {
				url : '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
				data : {
					hotelId : '${HotelLoginOK.hotelId}',
					roomTypeId : $('select').val(),
				}
			}

// 			$('#calendar').fullCalendar( 'removeEventSource', events);
			$('#calendar').fullCalendar('removeEventSources');
			$('#calendar').fullCalendar('addEventSource', events);
			$('#calendar').fullCalendar('refetchEvents');
			
			genPriceSelect('#checkbox','price');
			json.length = 0;
			
		})
		
		//生成價錢選擇器
		function genPriceSelect(selector, inputName){
			$.getJSON("${pageContext.servletContext.contextPath}/json/roomtype/RoomTypePriceToJson",{"roomTypeId" : $('select').val()},
					function(data){
						var checkbox_div = $(selector);
						checkbox_div.empty();
						$.each(data, function(i, price){
							var label_weekdaysPrice = $('<label></label>');
							var input_weekdaysPrice = $('<input/>').attr({type : "radio", value : price.weekdaysPrice, name : inputName});
							label_weekdaysPrice.append(input_weekdaysPrice);
							label_weekdaysPrice.append("平日價");
							
							var label_holidayPrice = $('<label></label');
							var input_holidayPrice = $('<input/>').attr({type : "radio", value : price.holidayPrice, name : inputName});
							label_holidayPrice.append(input_holidayPrice);
							label_holidayPrice.append("假日價");
							
							var label_seasonPrice = $('<label></label');
							var input_seasonPrice = $('<input/>').attr({type : "radio", value : price.seasonPrice, name : inputName});
							label_seasonPrice.append(input_seasonPrice);
							label_seasonPrice.append("旺季價");
							
							var label_customizedPrice = $('<label></label');
							var input_customizedPrice = $('<input/>').attr({type : "radio", value : price.customizedPrice, name : inputName});
							label_customizedPrice.append(input_customizedPrice);
							label_customizedPrice.append(price.customizedName);
							checkbox_div.append([label_weekdaysPrice, label_holidayPrice, label_seasonPrice, label_customizedPrice]);
						})
				
			})
		}

		//初始化fullCalendar，並註冊dayClick及eventClick事件
		$('#calendar').fullCalendar({
			header: {
				left: 'title',
				right: 'prev,next today'
			},
			eventSources : [ {
				url : '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
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
				$('#myModalLabel').text(moment(date).format('YYYY-MM-DD'));
				genPriceSelect('#price-select', 'priceBySingle');
				$('#myModal').modal('show');
			},
			eventClick: function(calEvent, jsEvent, view){
				$('#myModalLabel').text(calEvent.start._i);
				genPriceSelect('#price-select', 'priceBySingle');
				$('#myModal').modal('show');
			}
		})

		$('#plus').click(function(e) {
			add()
		})

		//存放使用者勾選的星期
		var weekdaycheck = [];
		//存放新增或修改價錢的json資料
		var json = [];
		
		//註冊勾選星期事件
		$('input[name=weekday]').click(function(){
			var weekdayNum = ($(this).prop("checked"))? $(this).val() : null;
			if(weekdaycheck.length > 0 && weekdayNum != null){
				for(var i = 0; i < weekdaycheck.length; i++){
					if(weekdaycheck[i] == parseInt(weekdayNum)){
						delete weekdaycheck[i];
					}
				}
			}else if(weekdayNum == null){
				for(var i = 0; i < weekdaycheck.length; i++){
					if(weekdaycheck[i] == parseInt($(this).val())){
						delete weekdaycheck[i];
					}
				}
			}
			weekdaycheck.push(parseInt(weekdayNum));
		});

		$('#showJson').click(function() {
			alert(JSON.stringify(json))
		})

		//新增日期事件
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
								
								//判斷是否有勾選星期及價錢
								if(weekdaycheck.length > 0 && !(price == null)){
									//根據目前月分跑每日迴圈
									for (var loop = startd.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
										var date = new Date(loop);
										var eventoObj = $("#calendar").fullCalendar( 'clientEvents', moment(date).format('YYYY-MM-DD'))[0];
										//抓取weekdaycheck陣列的值
										for(var i = 0; i < weekdaycheck.length; i++){
											//判斷現在日期星期是否與使用捨勾選的相同及該日期是否有已存在的價錢
											if (date.getDay() == weekdaycheck[i] && eventoObj == null) {
												//新增事件
												events.push({
													id : moment(date).format('YYYY-MM-DD'),
													title : price,
													start : moment(date).format('YYYY-MM-DD'),
													color : 'lightgreen',
													allDay : 'true',
													className : 'success',
												});
												//將新增事件的資料儲存至json準備新增
												json.push({
													date : moment(date).format('YYYY-MM-DD'),
													price : $('input[name=price]:checked').val(),
												});
											//如果該日期是已有存在的價錢，則更新原有價錢
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
		
		//註冊單一更改價錢事件
		$('#submit-single').click(function(){
			var date = $('#myModalLabel').text();
			var price = $('input[name=priceBySingle]:checked').val()
			var eventoObj = $("#calendar").fullCalendar( 'clientEvents', date)[0];
			if(eventoObj != null){
				eventoObj.title = price;
				eventoObj.color = 'lightgreen';
				$('#myModal').modal('hide');
				$('#calendar').fullCalendar('updateEvent', eventoObj);
				json.push({
					roomId : eventoObj.roomId,
					date : date,
					price : price,
				});
			}else{
				$("#calendar").fullCalendar('addEventSource',
						function(start, end, timezone, callback){
					var events = [];
					events.push({
						id : $('#myModalLabel').text(),
						title : price,
						start : moment(date).format('YYYY-MM-DD'),
						color : 'lightgreen',
						allDay : 'true',
					});
					//將新增事件的資料儲存至json準備新增
					json.push({
						date : moment(date).format('YYYY-MM-DD'),
						price : price,
					});
					$('#myModal').modal('hide');
					callback(events);
				})
			}
			
		});
		
		//將暫存於json內的資料傳送至server新增到資料庫，並重新整理頁面
		$('#submit').click(function(){
			$.ajax({
				type : 'POST',
				url : '${pageContext.servletContext.contextPath}/json/rooms/SetRoomPrice',
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
					url : '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
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