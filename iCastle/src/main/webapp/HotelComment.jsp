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
<p>�������� : </p>${requestScope.comment.avgScore}<br>
<p>�A�ȵ��� : </p>${requestScope.comment.serviceScore}<br>
<p>�~����� : </p>${requestScope.comment.qualityScore}<br>
<p>�������� : </p>${requestScope.comment.sceneScore}<br>
<p>���g�H�� : </p>${requestScope.comment.good}<br>
<p>���פ��e : </p>${requestScope.comment.comment}<br>
<%-- ${comment.response}<br> --%>

</body>
</html>