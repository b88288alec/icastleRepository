<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->
	<link href="${pageContext.servletContext.contextPath}/css/hotelphoto.css" rel="stylesheet" />

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->
    <div class="container">
		<h1>編輯照片</h1>
		<div class="row bigImagediv">
			<img class="bigImage" src="../img/hotelphoto/101.jpg">
		</div>
	<div id="div1"></div>
	<!-- 下面一排 -->
	<div class="row">
		<div class="col-md-2">
			<button type="button" id="left">左</button>
		</div>
		
		<div class="col-md-8">
			<div id="abgneBlock">
				<ul id="list" class="list">
					<li><a href="#"><img src="../img/hotelphoto/101.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/102.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/103.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/104.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/105.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/106.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/107.jpg"></a></li>
					<li><a href="#"><img src="../img/hotelphoto/108.jpg"></a></li>
				</ul>
			</div>
		</div>
		
		<div class="col-md-2">
			<button type="button" id="right">右</button>
		</div>		
	</div>
    
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/hotelphoto.js"></script>
</html>