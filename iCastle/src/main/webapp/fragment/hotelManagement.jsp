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
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${servletPath  == '/hotelcenter/hotelcenter.jsp'}"> --%>
<%-- 							<li class="active"><a href="${pageContext.servletContext.contextPath}/hotelcenter/hotelcenter.jsp"> <i --%>
<!-- 									class="material-icons">dashboard</i> -->
<!-- 									<p>總覽</p> -->
<!-- 							</a></li> -->
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 							<li><a href="${pageContext.servletContext.contextPath}/hotelcenter/hotelcenter.jsp"> <i class="material-icons">dashboard</i> --%>
<!-- 									<p>總覽</p> -->
<!-- 							</a></li> -->
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/updateHotelInfo.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelInfo.do">
									<i class="material-icons">location_city</i>
									<p>修改飯店資料</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelInfo.do">
									<i class="material-icons">location_city</i>
									<p>修改飯店資料</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/updateHotelPw.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/updateHotelPw.jsp">
									<i class="material-icons">location_city</i>
									<p>修改密碼</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/updateHotelPw.jsp">
									<i class="material-icons">location_city</i>
									<p>修改密碼</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/hotelphoto.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelPhoto.do">
									<i class="material-icons">picture_in_picture_alt</i>
									<p>編輯飯店照片</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelPhoto.do">
									<i class="material-icons">picture_in_picture_alt</i>
									<p>編輯飯店圖片</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/setRoomType.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowRoomType.do">
									<i class="material-icons">add_circle_outline</i>
									<p>編輯飯店房型</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ShowRoomType.do">
									<i class="material-icons">add_circle_outline</i>
									<p>編輯飯店房型</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when
							test="${servletPath == '/hotelcenter/setroomprice.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/rooms/SetRoomPrice.do">
									<i class="material-icons">attach_money</i>
									<p>設定每日房型價錢</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/rooms/SetRoomPrice.do">
									<i class="material-icons">attach_money</i>
									<p>設定每日房型價錢</p>
							</a></li>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when
							test="${servletPath == '/hotelcenter/record.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/HotelUpdateRecord">
									<i class="material-icons">receipt</i>
									<p>查詢修改紀錄</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/HotelUpdateRecord">
									<i class="material-icons">receipt</i>
									<p>查詢修改紀錄</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/hotelorders.jsp'}">
							<li class="active"><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ToHotelOrders">
									<i class="material-icons">bookmark_border</i>
									<p>查詢訂單紀錄</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="${pageContext.servletContext.contextPath}/hotelcenter/ToHotelOrders">
									<i class="material-icons">bookmark_border</i>
									<p>查詢訂單紀錄</p>
							</a></li>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${servletPath == '/hotelcenter/HotelCommentManager.jsp'}">
							<li class="active"><a href="#"> <i
									class="material-icons">comment</i>
									<p>查詢評論</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.servletContext.contextPath}/hotelcenter/HostComment?page=1"> <i class="material-icons">comment</i>
									<p>查詢評論</p>
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
						<a class="navbar-brand" href="#">飯店管理中心</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<!--home-->
							<li><a href="#pablo" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="material-icons">dashboard</i>
									<p class="hidden-lg hidden-md">Dashboard</p>
							</a></li>
							<!--home-->
						</ul>
					</div>
				</div>
			</nav>
			<!--上方導覽列-->
</body>