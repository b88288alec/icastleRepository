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
<link href="css/material-kit.css" rel="stylesheet" />
<link href="css/template.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
		<jsp:include page="fragment/nav.jsp"/>
	<!--結束導覽列-->

	<!--header背景-->
	<div clsaa="container-fluid" style="position: relative;">
		<img src="${pageContext.servletContext.contextPath}/img/header.jpg" class="header-bg" /> <img
			src="${pageContext.servletContext.contextPath}/img/overlay.png" class="logoheader img-responsive" />
		<div class="header-overlay"></div>
		<!--結束header背景-->

		<!--搜尋列表-->
		<div class="row query-overlay">
			<form action="Query.do" method="get">
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>查詢型態</p>
						<input type="text" class="form-control" placeholder="輸入區域或飯店名稱"
							name="type" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>入住日期</p>
						<input type="text" id="startDate" class="form-control datepicker"
							placeholder="輸入入住日期" name="start" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>退房日期</p>
						<input type="text" id="endDate" class="form-control datepicker"
							placeholder="輸入退房日期" name="end" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>入住人數</p>
						<input type="text" class="form-control" placeholder="輸入入住人數"
							name="peopleNum" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<br />
					<div class="btn-group">
						<input type="submit" class="btn btn-success" value="搜尋" />
						<input type="button" class="btn" id="onekey" value="一鍵輸入" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--結束搜尋列表-->
	<!--精選飯店-->
	<div class="container">
		<div class="page-header">
			<h1>精選飯店</h1>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;">
				<div class="card" style="width: 300px;">
					<img src="${pageContext.servletContext.contextPath}/img/60395_16042612080041805392.jpg"
						style="width: 100%;" />
					<div class="cardContext">
						<h4>麗尊酒店</h4>
						<p>高雄苓雅區</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;">
				<div class="card" style="width: 300px;">
					<img src="${pageContext.servletContext.contextPath}/img/3843_15070211000031541467.jpg"
						style="width: 100%;" />
					<div class="cardContext">
						<h4>漢來大飯店</h4>
						<p>高雄前金區</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;">
				<div class="card" style="width: 300px;">
					<img src="/iCastle/img/201242_16042216170041722027.jpg"
						style="width: 100%;" />
					<div class="cardContext">
						<h4>蘭城晶英酒店</h4>
						<p>宜蘭市</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;">
				<div class="card" style="width: 300px;">
					<img src="/iCastle/img/104996_110408145504225.jpg"
						style="width: 100%;" />
					<div class="cardContext">
						<h4>礁溪老爺酒店</h4>
						<p>宜蘭縣礁溪鄉</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--結束精選飯店-->

    <!--開始footer-->
		<jsp:include page="fragment/footer.jsp"/>
	<!--結束footer-->

	<!--<script src="js/jquery.min.js"></script>-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/material.min.js"></script>

	<script src="js/nouislider.min.js"></script>

	<script src="js/bootstrap-datepicker.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.zh-TW.min.js"></script>

	<script src="js/material-kit.js"></script>
	<script src="js/index.js"></script>
	<script>
		$(function() {
			$('#onekey').click(function() {
				event.preventDefault();
    			$('input[name = "type"]').val('台北');
    			$('input[name = "start"]').val('2017/06/02');
    			$('input[name = "end"]').val('2017/06/04');
    			$('input[name = "peopleNum"]').val(4);
			});

			$('input[name = "end"]').focus(function() {
				$('input[name = "start"]').datepicker('hide');
			})
			$('input[name = "start"]').focus(function() {
				$('input[name = "end"]').datepicker('hide');
			})
		});
	</script>
</body>
</html>