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
<link href="hotel/css/hotelList.css" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.2.0/jquery.rateyo.min.css">


<style>
#container {
	margin-top: 100px;
	color: blue;
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
			---地圖---<br> ---您的搜尋條件---<br>
			<div class="row query-overlay">
				<form action="Query.do" method="get">
					<div class="input-group input-group-sm">
						<p>查詢型態</p>
						<input type="text" class="form-control" placeholder="輸入區域或飯店名稱"
							name="type" value="${param.type}"/>
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="input-group input-group-sm">
						<p>入住日期</p>
						<input type="text" class="form-control datepicker"
							data-date-format="yyyy/mm/dd" data-date-start-date="+0d"
							placeholder="輸入入住日期" name="start" value="${param.start}"/>
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="input-group input-group-sm">
						<p>退房日期</p>
						<input type="text" class="form-control datepicker"
							data-date-format="yyyy/mm/dd" data-date-end-date="0d"
							placeholder="輸入退房日期" name="end" value="${param.end}"/>
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="input-group input-group-sm">
						<p>入住人數</p>
						<input type="text" class="form-control" placeholder="輸入入住人數"
							name="peopleNum" value="${param.peopleNum}"/>
					</div>
					<div class="clearfix visible-xs-block"></div>
					<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
						<br /> 
						<div class="btn-group">
							<input type="submit" class="btn btn-success" value="搜尋" />
						</div>
					</div>
					<input type="button" id="onekey" value="一鍵輸入" />
				</form>
			</div>
			<!-- 篩選 -->
			價錢
			<div id="slider-range"></div>
			<div id="price"></div>
			評分
			<div id="rateYo"></div>
		</div>

		<!-- 排序+飯店列表 -->
		<div class="col-md-8">

			<!-- 排序 -->
			<div class="row">排序方式: 熱門度 最低價格 星級排行
				<input type="text" name="order" value="熱門度">
			</div>
			<br>


			<!-- 飯店列表 -->
			<div class="row" id="content">
				<c:forEach var="hotel" items="${hotels}">
					<div class="row ahotel">
						<div class="col-md-2">飯店圖片</div>
						<div class="col-md-5">
							<a href="hotel.jsp">${hotel.hotelName}</a><br>
							${hotel.star}星級<br>
							<c:if test="${hotel.roomWifi == true}">
					    		室內wifi
					    	</c:if>
							<c:if test="${hotel.breakfast == true}">
					    		附早餐
					    	</c:if>
							<c:if test="${hotel.dinner == true}">
					    		附晚餐
					    	</c:if>
						</div>
						<div class="col-md-2">
							評分 ${hotel.point}<br> 熱門度 ${hotel.hot}<br> 最低價格
							${hotel.price}<br>
						</div>
						<input type="text"display="hidden"/>
						<div></div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
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

		var lowprice=0;
		var highprice=20000;
		//slider設定
// 		var slider = $("#slider");
// 		slider.slider({
// 			max : 20000,
// 			value : 20000,
// 			change : function(event, ui) {
// 				price = slider.slider("value");
// 				$("#price").text(price);
// 				change();
// 			}
// 		});
		$( "#slider-range" ).slider({
			range: true,
			min: 0,
			max: 20000,
			values: [ 0, 20000 ],
			change: function( event, ui ) {
				lowprice=ui.values[ 0 ];
				highprice=ui.values[ 1 ];
				change();
			}
		});

		var point=0;
		//評分
		$(function() {
			$("#rateYo").rateYo({
				rating : 0,
				halfStar : true
			});
		}).on("rateyo.set", function(e, data) {
			point = data.rating;
			$(this).next().text(point);
			change();
		});

		//有任何改變
		function change(){
			console.log('lowprice:' + lowprice);
			console.log('highprice:' + highprice);
			console.log('rating:' + point);
			$('#content').empty();
			var type = $('input[name = "type"]').val();
			var start = $('input[name = "start"]').val();
			var end = $('input[name = "end"]').val();
			var peopleNum = $('input[name = "peopleNum"]').val();
			var order = $('input[name = "order"]').val();
			var star = 0;
 			$.get('hotel/Advance.do', {'type':type, 'start':start, 'end':end,
 				             'peopleNum':peopleNum, 'order':order, 'lowprice':lowprice,
 				             'highprice':highprice, 'point':point, 'star':star}, function(data){
 			
				
 			});
		}

	});
// 	$('input[name = "type"]').val('高雄');
// 	$('input[name = "start"]').val('2017/01/02');
// 	$('input[name = "end"]').val('2017/01/04');
// 	$('input[name = "peopleNum"]').val(4);
</script>
</html>