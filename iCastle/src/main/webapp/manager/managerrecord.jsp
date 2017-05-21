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
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
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
<title>iCastle管理者中心</title>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/iCastleManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class=".col-xs-12">
					<span>分類:</span>
						<select id="classification" name="classification">
							<option value="0">--</option>
							<option value="飯店相關">飯店相關</option>
							<option value="會員相關">會員相關</option>
							<option value="QA">QA</option>
						</select>
					<span> 管理員編號或姓名:</span><input type="text" name="email"><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="button" name="send" id="buttonsend">搜尋</button>
				</div>
			</div>
			<div class="row" name="content" id="content">
				<table class="table">
					<thead>
						<tr>
							<th>分類</th>
							<th>管理員編號</th>
							<th>姓名</th>
							<th>修改時間</th>
							<th>修改內容</th>
						</tr>
					</thead>
					<tbody id="tb">
					</tbody>
				</table>
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

<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<!-- loading用 -->
<script src="https://cdn.jsdelivr.net/jquery.loadingoverlay/latest/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.loadingoverlay/latest/loadingoverlay_progress.min.js"></script>

<script>
	$(function(){
		
		$('#buttonsend').on('click', function(){
			
			var tb = $('#tb');
			var email = $('input[name="email"]').val();
			var classification = $('#classification').val();
			var action = 'formanager';
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/manager/RecordForManagerSearchManagerServlet',
				data : {
					email : email,
					classification : classification,
					action : action
				},
				beforeSend:function(){
					$.LoadingOverlay("show");
                },
                complete:function(){
                	$.LoadingOverlay("hide", true);
                },
				success : function(data){
					
// 					componentHandler.upgradeDom();
					tb.empty();
					
					$.each(data, function(key, value){
						
						var r = $('<tr></tr>');
						var d0 = $('<td></td>').text(value.classification);
						var d1 = $('<td></td>').text(value.id);
						var d2 = $('<td></td>').text(value.name);
						var d3 = $('<td></td>').text(value.recordTime);
						var d4 = $('<td></td>').text(value.managerRecord);
						
						r.append([d0,d1,d2,d3,d4]);
						tb.append(r);
					})
				}
			})
		})
	})
</script>

</html>