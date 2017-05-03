<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			action="${pageContext.servletContext.contextPath}/RegisterRoomType.do"
			method="GET">
			<div class="form">
				<p>飯店ID</p>
				<input type="text" class="form-control" placeholder="輸入飯店ID"
					name="hotelId" />
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
					<label> <input type="checkbox" name="breakfast"
						value="true"> 早餐
					</label> <label> <input type="checkbox" name="afternoonTea"
						value="true"> 下午茶
					</label> <label> <input type="checkbox" name="dinner" value="true">
						晚餐
					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="bedAddable" value="true">
						加床
					</label> <label> <input type="radio" name="bedAddable" value="true">
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
		$('#plus').click(function(){
			var form = $('.form:last')
			
			var hr = $('<hr/>')
			var hotelIdp = $('<p></p>').text("飯店ID");
			var hotelId_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入飯店ID", name : "hotelId"});
			var roomTypeNamep = $('<p></p>').text("房型名稱");
			var roomTypeName_input = $('<input/>').attr({type : "text", class : "form-control", placeholder : "輸入房型名稱", name : "roomTypeName"});
			
			form.append([hr,hotelIdp,hotelId_input,roomTypeNamep,roomTypeName_input]);
		})
	})
</script>

</html>