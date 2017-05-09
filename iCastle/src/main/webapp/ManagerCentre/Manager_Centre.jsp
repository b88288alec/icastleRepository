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

	<div class="wrapper">
		<!-- ====	下方為左側菜單 -->
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<!-- 菜單文字符合邊界 -->
			<div class="sidebar-wrapper">
				<div class="logo" style="background-color:#f5e345;margin:0px">
					<a href="${pageContext.servletContext.contextPath}/index.jsp" class="simple-text">
						<img alt="Brand" height="30" src="${pageContext.servletContext.contextPath}/img/logo.png" /> </a>
				</div>

				<ul class="nav">
					<li class="active"><a href="dashboard.html"> <i class="ti-panel"></i>
							<p>Dashboard</p>
					</a></li>
					<li><a href="user.html"> <i class="ti-user"></i>
							<p>User Profile</p>
					</a></li>
					<li><a href="table.html"> <i class="ti-view-list-alt"></i>
							<p>Table List</p>
					</a></li>
					<li><a href="typography.html"> <i class="ti-text"></i>
							<p>Typography</p>
					</a></li>
					<li><a href="icons.html"> <i class="ti-pencil-alt2"></i>
							<p>Icons</p>
					</a></li>
					<li><a href="maps.html"> <i class="ti-map"></i>
							<p>Maps</p>
					</a></li>
					<li><a href="notifications.html"> <i class="ti-bell"></i>
							<p>Notifications</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default" style="position:fixed;top:0px;z-index: 2;height:75px;">
			<div class="container-fluid" style="position:fixed;top:0px;right:5px;z-index: 3;">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					</button>
					<a class="navbar-brand" href="#"></a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"> <i class="ti-settings"></i>
								<p>Settings</p>
						</a></li>
						<li><a href="${pageContext.servletContext.contextPath}/hote/Logout.do"><span class="glyphicon glyphicon-log-in"></span> 登出</a></li>	
					</ul>

				</div>
			</div>
			</nav>


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
										<!-- 	插入圖片 -->

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


			<footer class="footer manager_footer">
			<div class="container-fluid">
				<nav class="pull-left">
				</nav>
				<div class="copyright pull-center">
					<img src="${pageContext.servletContext.contextPath}/img/logo.png" width="100" />
        			<h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        			<h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
				</div>
			</div>
			</footer>

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
