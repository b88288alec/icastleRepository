<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>

<body>
	<%
		String servletPath = request.getServletPath();
		request.setAttribute("servletPath", servletPath);
	%>
	<div class="wrapper">
		<!--側邊導覽列-->
		<div class="sidebar" data-color="orange">
			<div class="logo">
				<a href="${pageContext.servletContext.contextPath}/index.jsp"
					class="simple-text"> <img alt="Brand" height="30"
					src="${pageContext.servletContext.contextPath}/img/logo.png" />
				</a>
			</div>

			<div class="sidebar-wrapper">
				<ul class="nav">
					<c:choose>
						<c:when test="${servletPath  == '/manager/managercenter.jsp'}">
							<li class="active"><a href="${pageContext.servletContext.contextPath}/manager/managercenter.jsp"> <i
									class="material-icons">dashboard</i>
									<p>總攬</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.servletContext.contextPath}/manager/managercenter.jsp"> <i class="material-icons">dashboard</i>
									<p>總攬</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/manager/checkhotels.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/manager/GetAllhotel.do">
									<i class="material-icons">location_city</i>
									<p>管理飯店資料</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/manager/GetAllhotel.do">
									<i class="material-icons">location_city</i>
									<p>管理飯店資料</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/manager/membersInfo.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/manager/membersInfo.jsp">
									<i class="material-icons">picture_in_picture_alt</i>
									<p>管理會員資料</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/manager/membersInfo.jsp">
									<i class="material-icons">picture_in_picture_alt</i>
									<p>管理會員資料</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/manager/new_manager.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/manager/ManagerPageServlet">
									<i class="material-icons">add_circle_outline</i>
									<p>管理員權限</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/manager/ManagerPageServlet">
									<i class="material-icons">add_circle_outline</i>
									<p>管理員權限</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when
							test="${servletPath == '/manager/QA.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/manager/SearchQAServlet">
									<i class="material-icons">attach_money</i>
									<p>Q&A設定</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/manager/SearchQAServlet">
									<i class="material-icons">attach_money</i>
									<p>Q&A設定</p>
							</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
		<!--側邊導覽列結束-->

		<!--右側大畫布-->
		<div class="main-panel">
			<!--上方導覽列-->
			<nav class="navbar navbar-transparent navbar-absolute">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">管理者中心</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<!--home-->
							<li><a href="#pablo" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="material-icons">dashboard</i>
									<p class="hidden-lg hidden-md">Dashboard</p>
							</a></li>
							<!--home-->
							<!--dropdown-->
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="material-icons">notifications</i>
									<span class="notification">5</span>
									<p class="hidden-lg hidden-md">Notifications</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Mike John responded to your email</a></li>
									<li><a href="#">You have 5 new tasks</a></li>
									<li><a href="#">You're now friend with Andrew</a></li>
									<li><a href="#">Another Notification</a></li>
									<li><a href="#">Another One</a></li>
								</ul></li>
							<!--dropdown-->
						</ul>
					</div>
				</div>
			</nav>
			<!--上方導覽列-->
</body>