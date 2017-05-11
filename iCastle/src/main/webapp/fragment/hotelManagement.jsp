<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>

<body>
	<div class="wrapper">
		<!-- ====	下方為左側菜單 -->
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<!-- 菜單文字符合邊界 -->
			<div class="sidebar-wrapper">
				<div class="logo" style="background-color: #f5e345; margin: 0px">
					<a href="${pageContext.servletContext.contextPath}/index.jsp"
						class="simple-text"> <img alt="Brand" height="30"
						src="${pageContext.servletContext.contextPath}/img/logo.png" />
					</a>
				</div>

				<ul class="nav">
					<li class="active"><a href="dashboard.html"> <i
							class="ti-panel"></i>
							<p>Dashboard</p>
					</a></li>
					<li><a href="user.html"> <i class="ti-user"></i>
							<p>修改飯店資料</p>
					</a></li>
					<li><a href="table.html"> <i class="ti-view-list-alt"></i>
							<p>編輯圖片</p>
					</a></li>
					<li><a href="typography.html"> <i class="ti-text"></i>
							<p>新增房型</p>
					</a></li>
					<li><a href="icons.html"> <i class="ti-pencil-alt2"></i>
							<p>新增每日房價</p>
					</a></li>
					<li><a href="maps.html"> <i class="ti-map"></i>
							<p>訂單查詢</p>
					</a></li>
					<li><a href="notifications.html"> <i class="ti-bell"></i>
							<p>Notifications</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default"
				style="position: fixed; top: 0px; z-index: 2; height: 75px;">
				<div class="container-fluid"
					style="position: fixed; top: 0px; right: 5px; z-index: 3;">
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
							<li><a
								href="${pageContext.servletContext.contextPath}/hote/Logout.do"><span
									class="glyphicon glyphicon-log-in"></span> 登出</a></li>
						</ul>

					</div>
				</div>
			</nav>

</body>