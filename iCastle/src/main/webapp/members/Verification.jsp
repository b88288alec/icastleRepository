<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

<%
    if( request.getParameter("value").equals(session.getAttribute("imageMask")) ){
        out.print("驗證碼正確");
    }else{
        out.print("驗證碼錯誤");
    }
%>


</body>
</html>