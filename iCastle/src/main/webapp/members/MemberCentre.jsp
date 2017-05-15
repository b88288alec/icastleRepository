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
<style>
.container {
	width: 1300px;
	margin-top: 100px;
}

</style>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<div class="container" style="background-color: white; padding-bottom: 100px;">
			<div class="col-md-12">
				<div class="row col-md-offset-5 " style="padding: 0px 50px">
					<h2>會員中心</h2>
				</div>
					<div class="row col-md-offset-1" stdyle="padding: 0px 50px 50px 50px">
						<div class="col-md-4">
							<!--如下-- 先進到member_profile.jsp頁面，當修改資料(送出表單時候)直接呼叫sevlet程式-->
							<a href="${pageContext.servletContext.contextPath}/members/member_profile.jsp">
								<button type="button" class="btn btn-white"
									style="width: 250px; height: 250px">
									<i class="material-icons md-170 ">location_city</i>
									<p style="font-size: 20px">修改會員資料</p>
								</button>
							</a>
						</div>
						<div class="col-md-4">
							<!--如下--直接呼叫sevlet將資料丟到member_historical_order.jsp顯示-->
							<a href="${pageContext.servletContext.contextPath}/members/MemberInformationCentre.do">
								<button type="button" class="btn btn-white"
									style="width: 250px; height: 250px">
									<i class="material-icons md-170">account_circle</i>
									<p style="font-size: 20px">歷史訂單查詢</p>
								</button>
							</a>
						</div>
						<div class="col-md-4">
							<a href="${pageContext.servletContext.contextPath}/members/#">
								<button type="button" class="btn btn-white"
									style="width: 250px; height: 250px">
									<i class="material-icons md-170">account_circle</i>
									<p style="font-size: 20px">評論</p>
								</button>
							</a>
						</div>
						
					</div> <!-- div class="row col-md-offset-1" -->
			</div><!-- <div class="col-md-12"> -->
	</div><!-- div class="container" -->







	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<!--     <div class="container" -->
	<!-- 		style="background-color: white; padding-bottom: 100px;"> -->
	<!-- 			<h1>會員中心</h1> -->
	<!--如下-- 先進到member_profile.jsp頁面，當修改資料(送出表單時候)直接呼叫sevlet程式-->
	<%-- 			<a href="${pageContext.servletContext.contextPath}/members/member_profile.jsp">修改會員資料</a> --%>
	<!--如下--直接呼叫sevlet將資料丟到member_historical_order.jsp顯示-->
	<%-- 			<a href="${pageContext.servletContext.contextPath}/members/MemberInformationCentre.do">歷史訂單查詢</a> --%>
	<%-- 			<a href="${pageContext.servletContext.contextPath}/members/#">評論</a> --%>
	<!-- 	</div> -->

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

</html>