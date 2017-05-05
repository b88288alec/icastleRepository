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
<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link
	href="${pageContext.servletContext.contextPath}/css/material-kit.css"
	rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/fullcalendar.css"
	rel="stylesheet" />
<!--以下請加入各自頁面的css-->

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->

	<div class="container" style="margin-top: 100px;">

		<select>
			<c:forEach var="roomType" items="${roomTypeList}">
				<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
			</c:forEach>
		</select>
		<div class="togglebutton">
			<label> <input type="checkbox" checked=""> Toggle is
				on
			</label>
		</div>
		<button class="btn btn-info" id="plusFri">+Fri</button>
		<button class="btn btn-info" id="plusSat">+Sat</button>
		<button class="btn btn-info" id="plusSun">+Sun</button>
		<button class="btn btn-info" id="showJson">showJson</button>
		<div id="calendar"></div>
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

<script>
	$(function() {
		$('select').change(function() {
			var events = {
				url : '/iCastle/rooms/MonthRoomsToJason',
				data : {
					hotelId : '5',
					roomTypeId : $('select').val(),
				}
			}

			//         		$('#calendar').fullCalendar( 'removeEventSource', events);
			$('#calendar').fullCalendar('removeEventSources');
			$('#calendar').fullCalendar('addEventSource', events);
			$('#calendar').fullCalendar('refetchEvents');
		})

		$('#calendar').fullCalendar({
			eventSources : [ {
				url : '/iCastle/rooms/MonthRoomsToJason',
				data : {
					hotelId : '5',
					roomTypeId : $('select').val(),
				},
				error : function() {
					alert('there was an error while fetching events!');
				}
			} ]
		})

		$('#plusFri').click(function(e) {
			addFri()
		})
		$('#plusSat').click(function(e) {
			addSat()
		})
		$('#plusSun').click(function(e) {
			addSun()
		})

		var json = [];

		$('#showJson').click(function() {
			alert(JSON.stringify(json))
		})

		function addFri() {
			$('#calendar')
					.fullCalendar(
							'addEventSource',
							function(start, end, timezone, callback) {
								var events = [];
								var startd = new Date(start);
								var endd = new Date(end);
								//         			console.log(startd.getTime())
								//         			console.log(endd.getTime())
								var end = endd.getTime()
								for (var loop = startd.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
									var date = new Date(loop);
									//         				console.log('loop = ' + date.getTime())
									if (date.getDay() == 5) {
										events.push({
											title : 'test',
											start : moment(date).format(),
											color : 'red'
										});
										json.push({
											roomTypeId : $('select').val(),
											start : moment(date).format()
										});
									}
								}
								callback(events);
							})
		}

		function addSat() {
			$('#calendar')
					.fullCalendar(
							'addEventSource',
							function(start, end, timezone, callback) {
								var events = [];
								var startd = new Date(start);
								var endd = new Date(end);
								//         			console.log(startd.getTime())
								//         			console.log(endd.getTime())
								var end = endd.getTime()
								for (var loop = startd.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
									var date = new Date(loop);
									//         				console.log('loop = ' + date.getTime())
									if (date.getDay() == 6) {
										events.push({
											title : 'test',
											start : moment(date).format(),
											color : 'green'
										});
										json.push({
											roomTypeId : $('select').val(),
											start : moment(date).format()
										});
									}
								}
								callback(events);
							})
		}

		function addSun() {
			$('#calendar')
					.fullCalendar(
							'addEventSource',
							function(start, end, timezone, callback) {
								var events = [];
								var startd = new Date(start);
								var endd = new Date(end);
								//         			console.log(startd.getTime())
								//         			console.log(endd.getTime())
								var end = endd.getTime()
								for (var loop = startd.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
									var date = new Date(loop);
									//         				console.log('loop = ' + date.getTime())
									if (date.getDay() == 0) {
										events.push({
											title : 'test',
											start : moment(date).format(),
											color : 'pink'
										});
										json.push({
											roomTypeId : $('select').val(),
											start : moment(date).format()
										});
									}
								}
								callback(events);
							})
		}
	});
</script>

</html>