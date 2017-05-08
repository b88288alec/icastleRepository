<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <style>
     .myStyle{
        border:3px solid black;
     }
    </style>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	   <div style="margin-top:60px">
    <table class="table">
    <thead>
        <tr>
            <th class="text-center">編號</th>
            <th>會員姓名</th>
            <th>會員信箱</th>
            <th>會員評論時間</th>
            <th class="text-right">Actions</th>
        </tr>
    </thead>
    <tbody>
 
         <c:forEach var="comment" items="${commentData}">
         <tr>       
            <td class="text-center">
            ${comment.id}
            </td>
                     
            <td>
            ${comment.name}
            </td>
   
            <td>
            ${comment.email}
            </td>
            
            <td>
            ${comment.commentTime}
            </td>
            <td class="td-actions text-right">
                <button type="button" rel="tooltip" title="View Profile" class="btn btn-info btn-simple btn-xs">
                    <i class="fa fa-user"></i>
                </button>
                <button type="button" rel="tooltip" title="Edit Profile" class="btn btn-success btn-simple btn-xs">
                    <i class="fa fa-edit"></i>
                </button>
                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
                    <i class="fa fa-times"></i>
                </button>
            </td>
            </tr>
       </c:forEach> 
    </tbody>
</table>
</div>
	
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->
    
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