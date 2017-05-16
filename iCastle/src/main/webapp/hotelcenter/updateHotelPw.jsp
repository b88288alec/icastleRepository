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
<style>
.submit {
	margin-right: 15px; 
}
#oldpw {
	width:100px;
}
</style>
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
				
				<form method="post" action="../hotelcenter/UpdateHotelPw.do">
					<table>
					<tbody>
						<tr>
							<td id="oldpw">舊密碼:</td>
							<td>
								<div class="form-group label-floating">
									<label class="control-label">請輸入舊密碼</label>
									<input type="text" class="form-control" name="oldpw">
								
								</div>
							</td>
							<td>
								<font color="red">${errMap.oldpwErr}${errMap.oldpwnotcorrect}</font>
							</td>
						</tr>
						
						<tr>
							<td>新密碼:</td>
							<td>
								<div class="form-group label-floating">
									<label class="control-label">請輸入新密碼</label>
									<input type="text" class="form-control" name="newpw">
								</div>
							</td>
							<td>
								<font color="red">${errMap.newpwErr}</font>
							</td>
						</tr>
						
						<tr>
							<td>確認新密碼:</td>
							<td>
								<div class="form-group label-floating">
									<label class="control-label">請輸入確認新密碼</label>
									<input type="text" class="form-control" name="checkNewpw">
								</div>
							</td>
							<td>
								<font color="red">${errMap.chechNewpwErr}${errMap.pwcheckErr}</font>
							</td>
						</tr>
					</tbody>
					</table>
					<input class="submit btn btn-success" type="submit" value="送出" />
					<input class="btn  btn-danger" type="reset" value="清除" />
				</form>		
			
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
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>

</html>