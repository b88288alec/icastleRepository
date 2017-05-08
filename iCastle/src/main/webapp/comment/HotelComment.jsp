<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>

<p>平均評分 : </p>${comment.avgScore}<br>
<p>服務評分 : </p>${comment.serviceScore}<br>
<p>品質評分 : </p>${comment.qualityScore}<br>
<p>風景評分 : </p>${comment.sceneScore}<br>
<p>按讚人數 : </p>${comment.good}<br>
<p>上傳圖片: </p>

<img id="photo" alt="我是圖片" src="http://localhost:8081/iCastle/comment/CommentPhotosServlet?id=${ShowPhoto}"><br>	
<p>評論內容 : </p>${comment.comment}<br>


</body>
</html>