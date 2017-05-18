<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
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
<link href="${pageContext.servletContext.contextPath}/css/normalize.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/vicons-font.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/buttons.css" rel="stylesheet" />


<title>愛客宿-iCastle</title>
<style>
.container {
	width: 1300px;
	margin-top: 100px;
	background-color: white;
	padding-bottom: 100px;
}
/* 複寫 */
.button--ujarak::before {
	background: #a0a4a7;
}
</style>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../../fragment/nav.jsp" />
	<!--結束導覽列-->

	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container">
		
		<div class="hero-unit row col-md-offset-4" style="padding:50px 0px 0px 0px">

		<h1 style="font-size:30pt">是否忘記密碼?</h1>
		<form action="${pageContext.servletContext.contextPath}/general/members/CreatePw.do" method="post">
			<div class="col-sm-6">
				<div class="form-group label-floating">
					<label class="control-label">請輸入您的Email</label> 
					<input type="text" name="email" class="form-control" value="${param.email}"/>${errMap.emailErr}${errMap.emailErr2}
				</div>
				<section class="content">
					<div class="box bg-1">
						<button type="submit" id="onekey" class="button button--ujarak button--border-thin button--text-thick">一鍵輸入</button>
						<button type="submit"  class="button button--ujarak button--border-thin ">確定</button>
					</div>
				</section>
			</div>
			</form>
		</div>
<!-- ==============原始code============================= -->		
		<!--     	<h1>是否忘記密碼?</h1> -->
		<%--     	<form action="${pageContext.servletContext.contextPath}/general/members/CreatePw.do" method="post"> --%>
		<!-- 		<table class=""> -->
		<!-- 			<tbody> -->
		<!-- 			<tr> -->
		<!-- 				<td>請輸入您的Email</td> -->
		<%-- 				<td><input type="text" name="email" value="${param.email}"/>${errMap.emailErr}${errMap.emailErr2}</td> --%>
		<!-- 			</tr>			 -->
		<!-- 			<tr> -->
		<!-- 				<td><input type="submit" value="確定"></td> -->
		<!-- 				<td><input id="onekey" type="submit" value="一鍵輸入"></td> -->
		<!-- 			</tr> -->
		<!-- 			</tbody> -->
		<!-- 		</table> -->
		<!-- 		</form> -->
<!-- ==============原始code============================= -->					
	</div>

	<!--開始footer-->
	<jsp:include page="../../fragment/footer.jsp" />
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
		$('#onekey').click(function() {
			event.preventDefault();
			$('input[name = "email"]').val("eeit93no1@gmail.com");
		});
	})
</script>
</html>