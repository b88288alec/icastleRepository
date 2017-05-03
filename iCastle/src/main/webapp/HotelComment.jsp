<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%-- ${comment.orderId}<br> --%>
<%-- ${comment.hotelId}<br> --%>
<p>平均評分 : </p>${requestScope.comment.avgScore}<br>
<p>服務評分 : </p>${requestScope.comment.serviceScore}<br>
<p>品質評分 : </p>${requestScope.comment.qualityScore}<br>
<p>風景評分 : </p>${requestScope.comment.sceneScore}<br>
<p>按讚人數 : </p>${requestScope.comment.good}<br>
<p>評論內容 : </p>${requestScope.comment.comment}<br>
<%-- ${comment.response}<br> --%>

</body>
</html>