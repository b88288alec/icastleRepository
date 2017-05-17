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
					<span>會員帳號或姓名:</span><input type="text" name="email"><button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="button" name="send" id="buttonsend">搜尋</button>
				</div>
			</div>
			<div class="row" name="content" id="content">
				<table class="table">
					<thead>
						<tr><th>會員編號</th><th>會員帳號</th><th>姓名</th><th>性別</th><th>生日</th><th>地址</th><th>電話</th><th>身分證字號</th><th>國籍</th><th>護照號碼</th><th>管理員</th><th>停權</th></tr>
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
	
<script>
	$(function(){
		
		$('#tb').on('click', 'input[name="manager"]', function(){
			
			var memberId = $(this).attr('id');
			var manager = $(this).prop('checked');
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/manager/NewManagerServlet',
				data : {
					memberId : memberId,
					manager : manager,
					action : 'forMemberPage'
				},
				success : function(data){
				}
			})
			
		})
		
		$('#tb').on('click', 'input[name="suspension"]', function(){
			
			var memberId = $(this).attr('id');
			var suspension = $(this).prop('checked');
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/manager/SuspensionServlet',
				data : {
					memberId : memberId,
					suspension : suspension
				},
				success : function(data){
				}
			})
			
		})
		
		$('#buttonsend').on('click', function(){
			
			var tb = $('#tb');
			var email = $('input[name="email"]').val();
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/manager/MembersForManagerServlet',
				data : {
					email : email
				},
				success : function(data){
					
					componentHandler.upgradeDom();
					tb.empty();
					
					$.each(data, function(key, value){
						
						var r = $('<tr></tr>');
						var d1 = $('<td></td>').text(value.memberId);
						var d2 = $('<td></td>').text(value.email);
						var d3 = $('<td></td>').text(value.name);
						var d4 = $('<td></td>').text(value.gender);
						var d5 = $('<td></td>').text(value.bdate);
						var d6 = $('<td></td>').text(value.addr);
						var d7 = $('<td></td>').text(value.tel);
						var d8 = $('<td></td>').text(value.personId);
						var d9 = $('<td></td>').text(value.country);
						var d10 = $('<td></td>').text(value.passport);
						
						var msp = $('<span></span>').addClass('mdl-switch__label');
						var mid = ('man' + value.memberId);
						var minp = $('<input>').attr('type','checkbox').attr('name', 'manager').attr('id', mid).addClass('mdl-switch__input');
						var mlab = $('<label></label>').addClass('mdl-switch mdl-js-switch mdl-js-ripple-effect').attr('for', mid);
						var d11 = $('<td></td>');

						var ssp = $('<span></span>').addClass('mdl-switch__label');
						var sid = ('sus' + value.memberId);
						var sinp = $('<input>').attr('type','checkbox').attr('name', 'suspension').attr('id', sid).addClass('mdl-switch__input');
						var slab = $('<label></label>').addClass('mdl-switch mdl-js-switch mdl-js-ripple-effect').attr('for', sid);
						var d12 = $('<td></td>');
						
						if(value.manager == 'true'){
							minp.prop('checked', true);
						}

						if(value.suspension == 'true'){
							minp.prop('checked', true);
						}
						
						mlab.append([minp,msp]);
						d11.append(mlab);
						slab.append([sinp,ssp]);
						d12.append(slab);
						r.append([d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12]);
						tb.append(r);
					})
				}
			})
		})
	})
</script>

</html>