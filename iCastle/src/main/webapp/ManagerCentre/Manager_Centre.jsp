<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8" />

<title>會員中心</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link
	href="${pageContext.servletContext.contextPath}/css/paper-dashboard.css"
	rel="stylesheet" />
<!--  Paper Dashboard core CSS    -->
<%-- 	href="${pageContext.servletContext.contextPath}/css/material-kit.css" --%>
<!-- 	rel="stylesheet" /> -->
	<link href="${pageContext.servletContext.contextPath}/css/manager_template.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/animate.min.css"
	rel="stylesheet" />
<!-- Animation library for notifications   -->

<link
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Bootstrap core CSS     -->


<!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.servletContext.contextPath}/css/themify-icons.css" rel="stylesheet">
    
<style>
.box{
background:green;
margin:10px;
}
</style>
</head>
<body>

	<jsp:include page="../fragment/hotelManagement.jsp" />


			<div class="content" style="margin-top:100px;">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card card-stats" style="height: 500pt">
								<div class="header">
									<h4 class="title">帝王飯店</h4>
									<p class="category">新北市</p>
								</div>
								<div class="content">
									<div id="chartHours" class="ct-chart">
									
									<div class="box" >
									00
									</div>
											插入圖片

									</div>
									<div class="footer">
										<div class="stats">Updated 3 minutes ago</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<jsp:include page="../fragment/hotelManagementFooter.jsp" />

		</div>
	</div>

</body>

<!--   Core JS Files   -->
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="${pageContext.servletContext.contextPath}/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="${pageContext.servletContext.contextPath}/js/paper-dashboard.js"></script>
</html>
