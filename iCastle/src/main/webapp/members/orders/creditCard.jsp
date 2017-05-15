<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" http-equiv="Content-Type" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv=refresh content="3;url=${pageContext.servletContext.contextPath}/members/orders/success.jsp">
<!--     Fonts and icons     -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
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
<!--<link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" />-->
<link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<style>
	.myDiv{
		margin:0 auto;
		text-align:center;
	}
</style>

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<!--結束導覽列-->
	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container" style="margin-top: 56px">
		<div class="myDiv">信用卡授權中...</div>
		<!-- MDL Progress Bar with Indeterminate Progress -->
		<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate myDiv"></div>
	</div>
    <!--開始footer-->
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

</html>