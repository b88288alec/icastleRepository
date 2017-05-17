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
<style>
.leftzone {
	margin-left:100px;
}
</style>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/hotelManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
			
				<!-- 上面的大圖 -->
				<div class="row bigImagediv" ondragover="dragoverHandler(event)"
					ondrop="dropHandler(event)">
					<img class="bigImage" src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${firstPhotovo.id}" data-img=""><br>
					<input type="hidden" id="index" value="${originpage+1}"/>
				</div>
				
				<div class="row">
					<form method="post" action="UploadPhoto.do"
							enctype="multipart/form-data">
						<div class="col-md-8">	
							<!-- 輸入區域 -->
							<div class="row inputzone">
								<table id="table">
									<tr>
										<td id="td1">
											<span>說明</span>
										</td>
										<td id="td2">
											<div class="form-group">
										    	<input type="text" id="description" value="${firstPhotovo.pohtoDescription}" placeholder="輸入說明文字" class="form-control" />
											</div>
										</td>
										<td id="td3">
											<span>對應房型</span>
										</td>
										<td>
											<select id="roomTypeId" class="form-control">
											<option value="無">無</option>
											<c:forEach var="roomType" items="${roomTypeVOs}">
												<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
											</c:forEach>
											</select>
										</td>
									<tr>
								</table>
							</div>
							<!-- 輸入區域 -->
			
							<!-- 下面一排圖片 -->
							<div class="row">
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
							<!-- 下面一排圖片 -->
						</div>
						
						<!-- 開始按鈕區塊 -->
						<div class="col-md-4">
							<div class="col-md-2">
								<div class="form-group">
	    							<input type="file" id="file" name="image" multiple> 
									<div class="input-group col-md-9s"> 
	   									<span class="input-group-btn input-group-sm"> 
	       									<button type="button" class="btn btn-just-icon btn-warning"> 
	           									<i class="material-icons">attach_file</i> 
	        								</button>
	   									</span>
									</div>
								</div>
								
								<button type="button" id="delete" class="btn btn-danger">刪除</button>
								<input type="submit" class="btn btn-success" value="修改" />
							</div>
						</div>
						<!-- 結束按鈕區塊 -->
						
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