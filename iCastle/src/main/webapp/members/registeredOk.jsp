<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
 	<!--結束導覽列-->
 	<div class="row col-md-offset-3" style="margin-top: 100px">
		<div class="col-md-8" >
			<div class="page-header">


    <!--開始本頁內容!!!!!!!!!!!!~~~~~~~~~~-->

<h1 style="font-weight:bold">恭喜您註冊成功</h1>

<div class="card " style="padding: 0px 50px 50px 50px">
<div class="member" style="margin-top:30px">
<div class="row modal-body">
<div class="container-fluid" style="font-weight:bold ; font-size: 20px ">
<div class="row">
  <div class="col-md-2">帳號:</div>
  <div class="col-md-1">${membersVO.email}</div>
</div>
<div class="row">
  <div class="col-md-2">密碼:</div>
  <div class="col-md-1">${membersVO.pw}</div>
</div>
<div class="row">
  <div class="col-md-2">姓名:</div>
  <div class="col-md-2">${membersVO.name}</div>
</div>
<div class="row">
  <div class="col-md-2">性別:</div>
  <div class="col-md-1">${membersVO.gender}</div>
</div>
<div class="row">
  <div class="col-md-2">生日:</div>
  <div class="col-md-3">${membersVO.bdate}</div>
</div>
<div class="row">
  <div class="col-md-2">地址:</div>
  <div class="col-md-5">${membersVO.addr}</div>
</div>
<div class="row">
  <div class="col-md-2">電話:</div>
  <div class="col-md-1">${membersVO.tel}</div>
</div>
<div class="row">
  <div class="col-md-2">身分證字號:</div>
  <div class="col-md-1">${membersVO.personId}</div>
</div>
<div class="row">
  <div class="col-md-2">國家:</div>
  <div class="col-md-2">${membersVO.country}</div>
</div>
<div class="row">
  <div class="col-md-2">護照:</div>
  <div class="col-md-1">${membersVO.passport}</div>
</div>

</div>

</div>
</div>
</div>


<button class="btn btn-success"  onclick="location.href='${pageContext.servletContext.contextPath}/index.jsp'">回首頁</button>
<%-- <input type="button" value="回首頁" onclick="location.href='${pageContext.servletContext.contextPath}/index.jsp'"> --%>

</div>
</div>
</div>
 <!--結束本頁內容!!!!!!!!!!!!~~~~~~~~~~-->
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

</html>