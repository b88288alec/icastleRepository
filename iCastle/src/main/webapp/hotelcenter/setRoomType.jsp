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
<!--以下請加入各自頁面的css-->

<title>愛客宿-iCastle</title>
</head>
<body>

	<!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->

	<div class="container" style="margin-top: 100px;">
		<form
			action="${pageContext.servletContext.contextPath}/hotelcenter/roomtype/RegisterRoomType.do"
			method="GET">
			<div class="form">
				<p>飯店ID</p>
				<input type="text" class="form-control" placeholder="輸入飯店ID"
					name="hotelId" value="${HotelLoginOK.hotelId}" disabled/>
				<p>房型名稱</p>
				<input type="text" class="form-control" placeholder="輸入房型名稱"
					name="roomTypeName" />
				<p>房型人數</p>
				<input type="text" class="form-control" placeholder="輸入房型人數"
					name="peopleNum" />
				<p>房間數量</p>
				<input type="text" class="form-control" placeholder="輸入房間數量"
					name="roomNumber" />
				<p>平日價格</p>
				<input type="text" class="form-control" placeholder="輸入平日價格"
					name="weekdaysPrice" />
				<p>假日價格</p>
				<input type="text" class="form-control datepicker"
					placeholder="輸入假日價格" name="holidayPrice" />
				<p>旺季價格</p>
				<input type="text" class="form-control" placeholder="輸入旺季價格"
					name="seasonPrice" />
				<p>自訂價格</p>
				<input type="text" class="form-control" placeholder="輸入自訂價格"
					name="customizedPrice" />
				<p>自訂價格名稱</p>
				<input type="text" class="form-control" placeholder="輸入自訂價格名稱"
					name="customizedName" />
				<div class="checkbox">
					<label> <input type="checkbox" name="meals0"
						value="0"> 早餐
					</label> <label> <input type="checkbox" name="meals0"
						value="1"> 下午茶
					</label> <label> <input type="checkbox" name="meals0" value="2">
						晚餐
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="bedAddable0" value="true">
						加床
					</label> <label> <input type="radio" name="bedAddable0" value="false">
						不加床
					</label>
				</div>
				<p>加床價錢/每人</p>
				<input type="text" class="form-control" placeholder="輸入加床價錢"
					name="pricePerPerson" />
				<p>備註</p>
				<textarea class="form-control" placeholder="輸入備註" rows="5"
					name="remark"></textarea>

			</div>
			<div class="btn-group">
			<input type="hidden" name="times"/>
				<input type="submit" class="btn btn-success" value="新增" />
			</div>
			<input type="button" class="btn btn-info" id="plus" value="+">
		</form>
	</div>

	<!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
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

<script>
	$(function() {
		var count = 0;
		
		$('#plus').click(function(){
			count += 1;

			var form = $('.form:last')
			
			var hr = $('<hr/>')
			var hotelIdp = $('<p></p>').text("飯店ID");
			var hotelId_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入飯店ID", name : "hotelId", value : "${HotelLoginOK.hotelId}", disabled : "true"});
			var roomTypeNamep = $('<p></p>').text("房型名稱");
			var roomTypeName_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入房型名稱", name : "roomTypeName"});
			var peopleNump = $('<p></p>').text("房型人數");
			var peopleNump_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入房型人數", name : "peopleNum"});
			var roomNumberp = $('<p></p>').text("房型數量");
			var roomNumber_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入房型數量", name : "roomNumber"});
			var weekdaysPricep = $('<p></p>').text("平日價格");
			var weekdaysPrice_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入平日價格", name : "weekdaysPrice"});
			var holidayPricep = $('<p></p>').text("假日價格");
			var holidayPrice_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入假日價格", name : "holidayPrice"});
			var seasonPricep = $('<p></p>').text("旺季價格");
			var seasonPrice_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入旺季價格", name : "seasonPrice"});
			var customizedPricep = $('<p></p>').text("自訂價格");
			var customizedPrice_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入自訂價格", name : "customizedPrice"});
			var customizedNamep = $('<p></p>').text("自訂價格名稱");
			var customizedName_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入自訂價格名稱", name : "customizedName"});
			
			var checkbox_div = $('<div></div>');
			var breakfast_label = $('<label></label>');
			var breakfast_input = $('<input/>').attr({type : "checkbox",  name : "meals"+count, value : "0"});
			breakfast_label.append(breakfast_input);
			breakfast_label.append("早餐");
			
			var afternoonTea_label = $('<label></label>');
			var afternoonTea_input = $('<input/>').attr({type : "checkbox",  name : "meals"+count, value : "1"});
			afternoonTea_label.append(afternoonTea_input);
			afternoonTea_label.append("下午茶");
			
			var dinner_label = $('<label></label>');
			var dinner_input = $('<input/>').attr({type : "checkbox",  name : "meals"+count, value : "2"});
			dinner_label.append(dinner_input);
			dinner_label.append("晚餐");
			
			checkbox_div.append([breakfast_label,afternoonTea_label,dinner_label]);
			
			var radio_div = $('<div></div>');
			var bedAddable_label = $('<label></label>');
			var bedAddable_input = $('<input/>').attr({type : "radio",  name : "bedAddable"+count, value : "true"});
			bedAddable_label.append(bedAddable_input);
			bedAddable_label.append("加床");
			
			var bedAddable_label_n = $('<label></label>');
			var bedAddable_input_n = $('<input/>').attr({type : "radio",  name : "bedAddable"+count, value : "false"});
			bedAddable_label_n.append(bedAddable_input_n);
			bedAddable_label_n.append("不加床");
			
			radio_div.append([bedAddable_label,bedAddable_label_n]);
			
			var pricePerPersonp = $('<p></p>').text("加床價錢/每人");
			var pricePerPerson_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入加床價錢/每人", name : "pricePerPerson"});
			var remarkp = $('<p></p>').text("備註");
			var remark_input = $('<textarea></textarea>').attr({class : "form-control", placeholder : "輸入備註", name : "remark", row : "5"});
			
			
			
			form.append([hr,hotelIdp,hotelId_input,roomTypeNamep,roomTypeName_input,peopleNump,peopleNump_input,roomNumberp,roomNumber_input,
				weekdaysPricep,weekdaysPrice_input,holidayPricep,holidayPrice_input,seasonPricep,seasonPrice_input,customizedPricep,customizedPrice_input,
				customizedNamep,customizedName_input,checkbox_div,radio_div,pricePerPersonp,pricePerPerson_input,remarkp,remark_input]);
			
			$('input[name="times"]').val(count);
		})
		
			
	})
</script>

</html>