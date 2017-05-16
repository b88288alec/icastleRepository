<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
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
<style>
.container {
	width: 1400px;
}
</style>

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<div class="row col-md-offset-3" style="margin-top: 100px">
		<div class="col-md-8" >
			<div class="page-header">
 				<h1>修改會員資料 </h1>
			</div>
			<div class="card " style="padding: 0px 50px 50px 50px">

				<form action="${pageContext.servletContext.contextPath}/members/MemberInformationCentre.do" method="POST">
					<div class="row modal-body">
						<input type="hidden" name="member_Id"
							value="${MemberLoginOK.memberId}" />

						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2"
									style="font-size: 16px;">姓名:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入姓名" name="nameId"
										value="${MemberLoginOK.name}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2"
									style="font-size: 16px;">性別:</label>
								<div class="col-md-8">
									<div class="radio">
										<c:choose>
											<c:when test="${MemberLoginOK.gender == '男'}">
												<label><input type="radio" name="gender" value="男"
													checked>男生</label>
												<label><input type="radio" name="gender" value="女">女生</label>
											</c:when>
											<c:otherwise>
												<label><input type="radio" name="gender" value="男">男生</label>
												<label><input type="radio" name="gender" value="女"
													checked>女生</label>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">生日:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入生日" name="bdateId" value="${MemberLoginOK.bdate}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">電話:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入電話" name="telId" value="${MemberLoginOK.tel}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">身分證號碼:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入身分證" name="personId" readonly="readonly" value="${MemberLoginOK.personId}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">護照號碼:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入護照號碼" name="passportId" value="${MemberLoginOK.passport}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">email:</label>
								<div class="col-md-8">
									<input class="form-control" name="email" readonly="readonly" value="${MemberLoginOK.email}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">密碼:</label>
								<div class="col-md-8">
									<input type="password" class="form-control" placeholder="輸入密碼" name="pw" value="${MemberLoginOK.pw}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">國家:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入國家" name="country" value="${MemberLoginOK.country}" />
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="email" class="control-label col-md-2" style="font-size: 16px;">地址:</label>
								<div class="col-md-8">
									<input class="form-control" placeholder="輸入地址" name="addr" value="${MemberLoginOK.addr}" />
								</div>
							</div>
						</div>																		
						<input type="submit" class="btn btn-success" value="確定" style="float:right; width:250px ;margin-top:50px" />

					</div><!-- div class="row modal-body" -->
				</form>

			</div><!-- div class="card " -->
		</div><!-- div class="col-md-8" -->
	</div><!-- div class="row col-md-offset-3" -->

	<!-- <div class="container" style="margin-top: 100px;"> -->
	<!-- 		<div role="tabpanel"> -->
	<!-- 			<div class="tab-content"> -->
	<%-- 				<form action="${pageContext.servletContext.contextPath}/members/MemberInformationCentre.do" method="POST"> --%>
	<!-- 					<div class="form"> -->
	<%-- 						<input type="hidden" name="member_Id" value="${MemberLoginOK.memberId}" /> --%>
	<!-- 						<p>姓名:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入姓名" name="nameId" value="${MemberLoginOK.name}" /> --%>
	<!-- 						<p>性別:</p> -->
	<!-- 						<div class="radio"> -->
	<%-- 							<c:choose> --%>
	<%-- 								<c:when test="${MemberLoginOK.gender == '男'}"> --%>
	<!-- 									<label><input type="radio" name="gender" value="男" -->
	<!-- 										checked>男生</label> -->
	<!-- 									<label><input type="radio" name="gender" value="女">女生</label> -->
	<%-- 								</c:when> --%>
	<%-- 								<c:otherwise> --%>
	<!-- 									<label><input type="radio" name="gender" value="男">男生</label> -->
	<!-- 									<label><input type="radio" name="gender" value="女" -->
	<!-- 										checked>女生</label> -->
	<%-- 								</c:otherwise> --%>
	<%-- 							</c:choose> --%>
	<!-- 						</div> -->
	<!-- 						<p>生日:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入生日" name="bdateId" value="${MemberLoginOK.bdate}" /> --%>
	<!-- 						<p>電話:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入電話" name="telId" value="${MemberLoginOK.tel}" /> --%>
	<!-- 						<p>身分證號碼:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入身分證" name="personId" readonly="readonly" value="${MemberLoginOK.personId}" /> --%>
	<!-- 						<p>護照號碼:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入護照號碼" name="passportId" value="${MemberLoginOK.passport}" /> --%>
	<!-- 						<p>email:</p> -->
	<%-- 						<input class="form-control" name="email" readonly="readonly" value="${MemberLoginOK.email}" /> --%>
	<!-- 						<p>密碼:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入密碼" name="pw" value="${MemberLoginOK.pw}" /> --%>
	<!-- 						<p>國家:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入國家" name="country" value="${MemberLoginOK.country}" /> --%>
	<!-- 						<p>地址:</p> -->
	<%-- 						<input class="form-control" placeholder="輸入地址" name="addr" value="${MemberLoginOK.addr}" /> --%>
	<!-- 						<input type="submit" class="btn btn-success" value="確定" /> -->

	</div>
	<!-- div class="form" -->
	</form>
	</div>
	<!-- div class="tab-content" -->
	</div>
	<!-- div role="tabpanel" -->

	</div>
	<!-- <div class="container" -->
	<!-- ======================================================================================== -->
	<!-- <div class="container" style="margin-top: 100px;"> -->
	<!-- 		<div role="tabpanel"> -->
	<!-- 			<div class="tab-content"> -->
	<!-- 				<form -->
	<%-- 					action="${pageContext.servletContext.contextPath}/members/MemberInformationCentre.do" --%>
	<!-- 					method="POST"> -->
	<!-- 					<div class="form"> -->
	<!-- 						<input type="hidden" name="member_Id" -->
	<%-- 							value="${MemberLoginOK.memberId}" /> --%>
	<!-- 						<p>姓名:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入姓名" name="nameId" -->
	<%-- 							value="${MemberLoginOK.name}" /> --%>
	<!-- 						<p>性別:</p> -->
	<!-- 						<div class="radio"> -->
	<%-- 							<c:choose> --%>
	<%-- 								<c:when test="${MemberLoginOK.gender == '男'}"> --%>
	<!-- 									<label><input type="radio" name="gender" value="男" -->
	<!-- 										checked>男生</label> -->
	<!-- 									<label><input type="radio" name="gender" value="女">女生</label> -->
	<%-- 								</c:when> --%>
	<%-- 								<c:otherwise> --%>
	<!-- 									<label><input type="radio" name="gender" value="男">男生</label> -->
	<!-- 									<label><input type="radio" name="gender" value="女" -->
	<!-- 										checked>女生</label> -->
	<%-- 								</c:otherwise> --%>
	<%-- 							</c:choose> --%>
	<!-- 															<label><input type="radio" name="gender" value="男">男生</label> -->
	<!-- 															<label><input type="radio" name="gender" value="女">女生</label> -->
	<!-- 						</div> -->
	<!-- 						<p>生日:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入生日" name="bdateId" -->
	<%-- 							value="${MemberLoginOK.bdate}" /> --%>
	<!-- 						<p>電話:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入電話" name="telId" -->
	<%-- 							value="${MemberLoginOK.tel}" /> --%>
	<!-- 						<p>身分證號碼:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入身分證" name="personId" -->
	<%-- 							readonly="readonly" value="${MemberLoginOK.personId}" /> --%>
	<!-- 						<p>護照號碼:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入護照號碼" name="passportId" -->
	<%-- 							value="${MemberLoginOK.passport}" /> --%>
	<!-- 						<p>email:</p> -->
	<!-- 						<input class="form-control" name="email" readonly="readonly" -->
	<%-- 							value="${MemberLoginOK.email}" /> --%>
	<!-- 						<p>密碼:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入密碼" name="pw" -->
	<%-- 							value="${MemberLoginOK.pw}" /> --%>
	<!-- 						<p>國家:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入國家" name="country" -->
	<%-- 							value="${MemberLoginOK.country}" /> --%>
	<!-- 						<p>地址:</p> -->
	<!-- 						<input class="form-control" placeholder="輸入地址" name="addr" -->
	<%-- 							value="${MemberLoginOK.addr}" /> <input type="submit" --%>
	<!-- 							class="btn btn-success" value="確定" /> -->
	<!-- 					</div> -->
	<!-- 				</form> -->
	<!-- 			</div> -->
	<!-- 		</div> -->

	<!-- 	</div> -->
	<!-- ======================================================================================== -->

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