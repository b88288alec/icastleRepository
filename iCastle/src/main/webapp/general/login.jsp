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

<title>愛客宿-iCastle</title>
<style>
.container {
	width: 1300px;
	margin-top: 150px;
}

/* Rules for sizing the icon. */
.material-icons.md-170 {
	font-size: 170px;
}
/* Rules for using icons as black on a light background. */
.material-icons.md-dark {
	color: rgba(0, 0, 0, 0.54);
}

.material-icons.md-dark.md-inactive {
	color: rgba(0, 0, 0, 0.26);
}

/* Rules for using icons as white on a dark background. */
.material-icons.md-light {
	color: rgba(255, 255, 255, 1);
}

.material-icons.md-light.md-inactive {
	color: rgba(255, 255, 255, 0.3);
}
</style>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container">


		<div class="row col-md-offset-2">
			<div class="col-md-6">
				<!--按钮触发模态框  data-toggle="modal" data-target="#myModal"-->
				<button type="button" class="btn btn-warning"
					style="width: 250px; height: 250px" data-toggle="modal"
					data-target="#hotel">
					<i class="material-icons md-170 ">location_city</i>
					<p style="font-size: 20px">業 者 登 入</p>
				</button>
			</div>
			<div class="col-md-6">
				<button type="button" class="btn btn-warning"
					style="width: 250px; height: 250px" data-toggle="modal"
					data-target="#member">
					<i class="material-icons md-170">account_circle</i>
					<p style="font-size: 20px">會 員 登 入</p>
				</button>
			</div>
		</div>

		<!-- 飯店模态框（Modal）程式開始執行 -->
		<div class="modal fade" id="hotel" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<p class="modal-title" id="myModalLabel" style="font-size: 20px">業  者 登 入</p>
					</div>
					<div class="row modal-body">
						<form
							action="${pageContext.servletContext.contextPath}/hotel/Login.do"
							method="POST">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2" style="font-size: 16px;">Email:</label>
									<div class="col-md-8">
										<input name="email" type="text" class="form-control"
											placeholder="輸入Email" value="${param.email}" /><span
											style="color: red">${errMap.accountErr}${errMap.emailErr}</span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2" style="font-size: 16px;">密  碼 :</label>
									<div class="col-md-8">
										<input name="pw" type="password" class="form-control"
											placeholder="輸入密碼" /><span style="color: red">${errMap.pwErr}</span>
									</div>
								</div>
							</div>
							
							<!-- 開始驗證碼 -->
							<div class="col-md-12">
								<div class="form-group">
								<label class="control-label col-md-2" style="font-size: 16px;"><img 
										src="${pageContext.servletContext.contextPath}/general/ImageMaskServlet.do"
										id="imageMask" />
										<a href = "#" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">換一張</a>
										</label>
									<div class="col-md-8">
										<input type="text" name="value" class="form-control"
											placeholder="輸入驗證碼" style="width: 200px" /><span style="color: red">${errMap.cdErr}</span>
									</div>
								</div>
							</div>
							<!-- 結束驗證碼 -->
							
							<div class="col-md-12">
								<a
									href="${pageContext.servletContext.contextPath}/hotel/createrandompw.jsp"
									style="float: right">忘記密碼</a>
							</div>
							<button type="button" id="onekey1"
								class="btn btn-primary btn-simple" style="margin-left: 15%;">eeit93一鍵輸入</button>
							<button type="button" id="onekey2"
								class="btn btn-primary btn-simple">德立莊一鍵輸入</button>
							<button type="button" class="btn btn-default "
								data-dismiss="modal">取消</button>
							<input type="submit" class="btn btn-primary" value="登入"
								style="float: right">
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

		<!-- 會員模态框（Modal）程式開始執行 -->
		<div class="modal fade" id="member" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<p class="modal-title" id="myModalLabel" style="font-size: 20px">會 員 登 入</p>
					</div>
					<div class="row modal-body">
						<form action="${pageContext.servletContext.contextPath}/general/members/Login.do" method="POST">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2" style="font-size: 16px;">Email:</label>
									<div class="col-md-8">
										<input name="email" type="text" class="form-control"
											placeholder="輸入Email" value="${param.email}" /><span
											style="color: red">${errMap.accountErr}${errMap.emailErr}</span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2" style="font-size: 16px;">密碼 :</label>
									<div class="col-md-8">
										<input name="pw" type="password" class="form-control"
											placeholder="輸入密碼" /><span style="color: red">${errMap.pwErr}</span>
									</div>
								</div>
							</div>
							
							<!-- 開始驗證碼 -->
							<div class="col-md-12">
								<div class="form-group">
								<label class="control-label col-md-2" style="font-size: 16px;"><img 
										src=""
										id="imageMask2" />
										<a href = "#" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">換一張</a>
										</label>
									<div class="col-md-8">
										<input type="text" name="value" class="form-control"
											placeholder="輸入驗證碼" style="width: 200px" /><span style="color: red">${errMap.cdErr}</span>
									</div>
								</div>
							</div>
							<!-- 結束驗證碼 -->
							
							<div class="col-md-12">
								<a
									href="${pageContext.servletContext.contextPath}/general/members/createPw.jsp"
									style="float: right">忘記密碼</a>
							</div>
							<button type="button" class="btn btn-primary btn-simple btn-sm" style="margin-left:13%;" onclick="Auth();">點選這裡連結到Line Login</button>
							<button type="button" id="member-onekey"
								class="btn btn-primary btn-simple btn-sm">一鍵輸入</button>
							<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
							<input type="submit" class="btn btn-primary btn-sm" value="登入"
								style="float: right">
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
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

<script>
	$(function() {
		$('#onekey1').click(function() {
			event.preventDefault();
			$('input[name = "email"]').val("eeit93no1@gmail.com");
			$('input[name = "pw"]').val("123456");

		});
		$('#onekey2').click(function() {
			event.preventDefault();
			$('input[name = "email"]').val("midtown@richardson.com");
			$('input[name = "pw"]').val("123456");

		});
		$('#member-onekey').click(function() {
			event.preventDefault();
			$('input[name = "email"]').val("sally@gmail.com");
			$('input[name = "pw"]').val("sally123");
		
		});
		
		
		/*在JSTL裡包裝JS，過濾器判斷*/
		<c:if test="${loginPath  == '/hotel/Login.do'}">
		$('#hotel').modal('show');
		</c:if>
		<c:if test="${loginPath  == '/general/members/Login.do'}">
		$('#member').modal('show');
		</c:if>
	})
</script>
<script>

document.getElementById("imageMask2").src = document.getElementById("imageMask").src;

function myReload(){    
    var newVifiCode = document.getElementById("imageMask").src+"?nocache="+new Date().getTime();
    document.getElementById("imageMask").src = newVifiCode; 
    document.getElementById("imageMask2").src = newVifiCode;
}    

function Auth() {
    var URL = 'https://access.line.me/dialog/oauth/weblogin?';
    URL += 'response_type=code';
    URL += '&client_id=1514098572';
    URL += '&redirect_uri=http://localhost:8081/iCastle/general/members/LineLogin.do';
//     URL += '&state=abcde';
    window.location.href = URL;
}
</script>

</html>