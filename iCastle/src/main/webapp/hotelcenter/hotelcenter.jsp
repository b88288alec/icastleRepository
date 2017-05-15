<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <title>愛客宿-iCastle</title>
	<style>
		.container {
		    width: 1300px;
		    margin-top: 100px;
		}
	</style>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->
    <div class="container"
		style="background-color: white; padding-bottom: 100px;">
		<div>
			<h1>飯店會員中心</h1>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelInfo.do">修改飯店資訊</a>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/updateHotelPw.jsp">修改密碼</a>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelPhoto.do">編輯圖片</a>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/setRoomType.jsp">新增房型</a>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/rooms/SetRoomPrice.do">新增房價</a>
			<a href="${pageContext.servletContext.contextPath}/hotelcenter/ToHotelOrders">訂單</a>
		</div>
		<c:if test="${HotelLoginOK.hotelState == 0}">
			<div>
				您的帳號尚未通過審核，無法使用任何功能，請耐心等候審核
			</div>
		</c:if>
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

</html>