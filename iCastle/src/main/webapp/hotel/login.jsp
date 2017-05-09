<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<button type="button" class="btn btn-warning" style="width: 250px; height: 250px" data-toggle="modal" data-target="#myModal">
					<i class="material-icons md-170 ">location_city</i>
					<p style="font-size: 20px">業 者 登 入</p>
				</button>
			</div>
			<div class="col-md-6">
				<button type="button" class="btn btn-warning" style="width: 250px; height: 250px">
					<i class="material-icons md-170">account_circle</i>
					<p style="font-size: 20px">會 員 登 入</p>
				</button>
			</div>
		</div>

		<!-- 模态框（Modal）程式開始執行 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"aria-hidden="true">×</button>
						<p class="modal-title" id="myModalLabel" style="font-size: 20px">業  者  登  入</p>
					</div>
					<div class="row modal-body">
						<div class="col-md-6 col-md-offset-2" style="padding:5px;">Email :
						<input type="text" placeholder="輸入Email" style="margin-left:20px; padding:5px;"></div>
						<div class="col-md-6 col-md-offset-2" style="padding:5px;">密  碼 :
						<input type="text" placeholder="輸入密碼" style="margin-left:20px; padding:5px;"></div>	
						<!-- ================================================= -->
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2" style="font-size: 16px;">Email :</label>
                                <div class="col-md-8">
                                    <input id="Name" name="Name" type="text" class="form-control" placeholder="輸入Email" />
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="control-label col-md-2" style="font-size: 16px;">密  碼 :</label>
                                <div class="col-md-8">
                                    <input id="Name" name="Name" type="text" class="form-control" placeholder="輸入密碼" />
                                </div>
                            </div>
                        </div>                        
                        
                        											
					</div>
					
					<div class="modal-body"></div><!-- 【modal-body】是按下 ESC 按钮退出。 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary">登入</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<script>
			$(function() {
				$('#myModal').modal({
					keyboard : true
				})
			});
		</script>
		<!--尚未美化的code-->
		<!-- 		<div class="row"> -->
		<!-- 			<div class="col-md-6"> -->
		<%-- 				<a href="${pageContext.servletContext.contextPath}/hotel/loginhotel.jsp">業者登入</a> --%>
		<!-- 			</div> -->
		<!-- 			<div class="col-md-6"> -->
		<%-- 				<a href="${pageContext.servletContext.contextPath}/members/loginMembers.jsp">會員登入</a> --%>
		<!-- 			</div> -->
		<!-- 		</div> -->

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

</html>