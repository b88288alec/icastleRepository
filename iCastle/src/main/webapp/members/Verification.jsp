<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
<title>Insert title here</title>
</head>
<body>

<%
    if( request.getParameter("value").equals(session.getAttribute("imageMask")) ){
        out.print("���ҽX���T");
    }else{
        out.print("���ҽX���~");
    }
%>


</body>
</html>