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
	.qu{
		width:500px;
	}
	.an textarea{
		width:500px;
		height:250px;
		margin-left:6.4%;
	}
	.msp{
		position:absolute;
	}
	.updatebutton{
		width:50px;
	}
	.que{
		font-weight:bold;
		font-size:18px;
	}
</style>

<title>iCastle管理者中心</title>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/iCastleManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
		<table class="table">
		<c:forEach var="QA" items="${QA}">
			<tr id="del${QA.id}">
			<div class="row">
			
				<td>
				<div class="row">
					<div class="col-xs-2">
						<span>問題: </span>
					</div>
					<div class="col-xs-9">
						<span class="que" id="showq${QA.id}">${QA.question}</span>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-2">
						<span>回答: </span>
					</div>
					<div class="col-xs-9">
						<span id="showa${QA.id}">${QA.answer}</span>
					</div>
				</div>
				</td>
				
				<td>
					<button class="updatebutton" data-toggle="modal" data-target="#show${QA.id}" name="update">修改</button>
				</td>
				
				<td>
					<button class="updatebutton" type="button" name="delete" value="${QA.id}">刪除</button>
				</td>
					
					<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="show${QA.id}">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">修改QA</h4>
								</div>
								<div class="modal-body myselfdiv">
									<div class=".col-xs-3">
										<span>問題: </span><input class="qu" type="text" name="question" id="q${QA.id}" value="${QA.question}" />
									</div>
									<div class=".col-xs-8 an">
										<span class="msp">回答: </span><textarea name="answer" id="a${QA.id}">${QA.answer}</textarea>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" id="${QA.id}" class="btn btn-info btn-simple" name="updatechange" data-dismiss="modal">修改</button>
									<button type="button" class="btn btn-default btn-simple" data-dismiss="modal">關閉</button>
								</div>
							</div>
						</div>
					</div>
					
			</div>
			</tr>
		</c:forEach>
		</table>
			<div class="row">
				
				<div class="col-xs-5">
					<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" id="newqa">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">新增QA</h4>
								</div>
								<form action="NewQAServlet" method="post">
								<div class="modal-body myselfdiv">
									<div class=".col-xs-3">
										<span>問題: </span><input class="qu" type="text" name="question" id="newq" />
									</div>
									<div class=".col-xs-8 an">
										<span class="msp">回答: </span><textarea name="answer" id="newa"></textarea>
									</div>
								</div>
								<div class="modal-footer">
									<input type="submit" id="newsend" class="btn btn-info btn-simple" name="updatechange" />
									<button type="button" class="btn btn-default btn-simple" data-dismiss="modal">關閉</button>
								</div>
								</form>
							</div>
						</div>
					</div>
					
					<button class="updatebutton" data-toggle="modal" data-target="#newqa" name="update">新增</button>

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
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>

<script>
	$(function(){
// 		跳出modal用
		$('button[name="update"]').on('click', function(){
			$('.modal').appendTo("body");
		})
		
// 		修改用
		$('button[name="updatechange"]').on('click',function(){
			
			var id = $(this).attr('id');
			var qid = ('#q' + id);
			var aid = ('#a' + id);
			var question = $(qid).val();
			var answer = $(aid).val();
			
			$.ajax({
				type : 'POST',
				url : '${pageContext.servletContext.contextPath}/manager/UpdateQAServlet',
				data : {
					id : id,
					question : question,
					answer : answer
				},
				success : function(data){
					var showqid = ('#showq' + id);
					var showaid = ('#showa' + id);
					$(showqid).empty().append(question);
					$(showaid).empty().append(answer);
				}
			})
			
		})
		
// 		刪除用
		$('button[name="delete"]').on('click', function(){
			
			var id = $(this).val();
			
			console.log($('input[name="del"]:checked').val());
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/manager/DeleteQAServlet',
				data : {
					id : id
				},
				success : function(data){
					$.each(data, function(key, value){
						var delid = ('#del' + value.id);
						$(delid).remove();
					})
				}
			})
		})
		
	})
</script>

</html>