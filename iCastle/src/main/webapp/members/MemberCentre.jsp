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

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->

	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->

	<div class="container" style="margin-top: 100px;">
		<form
			action="${pageContext.servletContext.contextPath}/MemberInformationCentre.do"
			method="POST">
			<div class="form">
				<p>姓名:</p>
				<input class="form-control" placeholder="輸入姓名" name="nameId"
					value="${membersKey.name}" />
				<p>性別:</p>
				<div class="radio">
					<label><input type="radio" name="gender" value="男">男生</label>
					<label><input type="radio" name="gender" value="女">女生</label>
				</div>
				<p>生日:</p>
				<input class="form-control" placeholder="輸入生日" name="bdateId"
					value="${membersKey.bdate}" />
				<p>電話:</p>
				<input class="form-control" placeholder="輸入電話" name="telId"
					value="${membersKey.tel}" />
				<p>身分證號碼:</p>
				<input class="form-control" placeholder="輸入身分證" name="personId"
					value="${membersKey.personId}" />
				<p>護照號碼:</p>
				<input class="form-control" placeholder="輸入護照號碼" name="passportId"
					value="${membersKey.passport}" />
				<p>email:</p>
				<input class="form-control" placeholder="輸入email" name="email"
					value="${membersKey.email}" />
				<p>密碼:</p>
				<input class="form-control" placeholder="輸入密碼" name="pw"
					value="${membersKey.pw}" />
				<p>國家:</p>
				<input class="form-control" placeholder="輸入國家" name="country"
					value="${membersKey.country}" />
				<p>地址:</p>
				<input class="form-control" placeholder="輸入地址" name="addr"
					value="${membersKey.addr}" />

				<p>歷史訂單:</p>
				<table class="table">
					<!--標題列 -->
					<thead>
						<tr>
							<th>hotelName飯店名稱</th>
							<th>roomCount訂購房間數</th>
							<th>price價錢</th>
							<th>pricePerPerson個人價錢</th>
							<th>roomTypeName房型</th>
							<th>reservationer訂購人</th>
							<th>tel</th>
							<th>country國家</th>
							<th>addr地址</th>
							<th>orderState訂單狀態</th>
							<th>cancelDate取銷日期</th>
						</tr>
					</thead>
					<c:forEach var="myData" items="${ordersKey}">
						<!--取出VO裡的List-->
						<!--此orderKey相當於List概念-->
<%-- 					${myData.orderId} ${myData.orderedDate} ${myData.memberId} ${myData.roomId} ${myData.hotelId} ${myData.hotelName} --%>
<%-- 					${myData.roomTypeId} ${myData.roomTypeName} ${myData.checkinDay} ${myData.checkoutDay} ${myData.roomCount} --%>
<%-- 					${myData.peopleNum} ${myData.breakfast} ${myData.dinner} ${myData.afternoonTea} ${myData.price}${myData.roomNo} --%>
<%-- 					${myData.reservationer} ${myData.bdate} ${myData.tel} ${myData.email} ${myData.addr} ${myData.personId} ${myData.country} --%>
<%-- 					${myData.passport} ${myData.bedAdding} ${myData.pricePerPerson} --%>
<%-- 					${myData.customerRemark} ${myData.hotelRemark} ${myData.memo} ${myData.orderState} ${myData.cancelDate}		 --%>
					<tbody>
							<tr>
							<td>${myData.hotelName}</td>
							<td>${myData.roomCount}</td>
							<td>${myData.price}</td>
							<td>${myData.pricePerPerson}</td>
							<td>${myData.roomTypeName}</td>
							<td>${myData.reservationer}</td>
							<td>${myData.tel}</td>
							<td>${myData.country}</td>
							<td>${myData.addr}</td>
							<td>${myData.orderState}</td>
							<td>${myData.cancelDate}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>

				<input type="submit" class="btn btn-success" value="確定" />
			</div>
		</form>
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