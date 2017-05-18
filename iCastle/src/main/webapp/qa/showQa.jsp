<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ page import="java.util.*"%>
<%@ page import="com.icastle.qa.model.*"%>
    
<%
    QaDAO_interface dao = new QaJNDIDAO();
    List<QaVO> list = dao.getAll();
    pageContext.setAttribute("list",list);
%>
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
>	
			
 	<div class="row col-md-offset-2" style="margin-top:80px">
		<div class="col-md-8" >
			<div  style="padding:0px 50px " ><h1 style="font-weight:bold">飯店Q&A</h1></div>
			<div  style="padding:0px 50px 50px 50px">
 	
    <!--開始本頁內容!!!!!!!!!!!!~~~~~~~~~~-->
    

    
    
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
    <c:forEach var="QaVO" items="${list}" varStatus="qa">
      <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#${QaVO.question}" aria-expanded="false" aria-controls="${QaVO.question}" style="font-size:20px">
        
          ${QaVO.question}
          
        </a>
      </h4>
    </div>
    <div id="${QaVO.question}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      
          ${QaVO.answer}

        </div>
    </div>
   </div>
   </c:forEach>
  </div>
 
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