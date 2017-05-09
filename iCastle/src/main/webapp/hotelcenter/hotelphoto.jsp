<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link
	href="${pageContext.servletContext.contextPath}/css/hotelphoto.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->

	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container">
		<h1>編輯照片</h1>
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

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/hotelphoto.js"></script>

</html>