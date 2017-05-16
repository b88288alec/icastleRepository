<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/material-dashboard.css"
	rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.servletContext.contextPath}/css/manager_template.css"
	rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<link
	href="${pageContext.servletContext.contextPath}/css/hotelphoto.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>iCastle飯店管理中心</title>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/hotelManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="row bigImagediv" ondragover="dragoverHandler(event)"
					ondrop="dropHandler(event)">
					<img class="bigImage" src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${firstPhotovo.id}" data-img=""><br>
					<input type="hidden" id="index" value="${originpage+1}"/>
				</div>
		
				<!-- 輸入區域 -->
				<div class="row inputzone">
					說明:<input type="text" id="description" maxlength="20" value="${firstPhotovo.pohtoDescription}"/>
					對應房型:
		<!-- 			<input type="text" id="roomTypeId" maxlength="20"/> -->
					<select id="roomTypeId">
						<option value="無">無</option>
						<c:forEach var="roomType" items="${roomTypeVOs}">
							<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
						</c:forEach>
					</select>
				</div>
		
				<!-- 下面一排 -->
				<div class="row">
					<form method="post" action="UploadPhoto.do"
						enctype="multipart/form-data">
						<div class="col-md-2">
							<button type="button" id="left">左</button>
						</div>
		
						<div class="col-md-8">
							<div id="abgneBlock">
								<ul id="list" class="list">
									<c:forEach var="photo" items="${photovos}" varStatus="loop">
										<li>
											<img src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${photo.id}" id="img${loop.index+1}" class="imgs"/>
											<input type="hidden" name="update"/>
											<input type="hidden" name="imgdescription${loop.index+1}" id="inpimg${loop.index+1}" value="${photo.pohtoDescription}"/>
											<input type="hidden" name="imgroomTypeId${loop.index+1}" id="roomTypeIdimg${loop.index+1}" value="
												<c:choose>
													<c:when test="${empty photo.roomTypeId}">
														無
													</c:when>
													<c:otherwise>
														${photo.roomTypeId}
													</c:otherwise> 
												</c:choose>
											"/>
										</li> 
									</c:forEach>  
								</ul>
							</div>
						</div>
		
						<div class="col-md-2">
							<button type="button" id="right">右</button>
							<button type="button" id="delete">刪除</button>
							<input type="file" id="file" name="image" multiple /> <input
								type="submit" value="上傳" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--內容區塊-->

	<!--開始footer-->
	<jsp:include page="../fragment/hotelManagementFooter.jsp" />
	<!--結束footer-->
</body>

<script
	src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
<script src="${pageContext.servletContext.contextPath}/js/hotelphoto.js"></script>
</html>