<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>



<form method="post" action="Verification.jsp">
    <img border=0 src="ImageMaskServlet.do" width="80" height="80" id ="imageMask"/><br/>
<!-- <img border=0 src="DynamicImage.do" width="80" height="80" id ="imageMask"/><br/> -->
    <a href = "#" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">換一張</a>
    <input type="text" name="value"></input>
    <input type="submit"></input>
</form>


<script type="text/javascript">  
       
         function myReload(){    
            document.getElementById("imageMask").src=document.getElementById("imageMask").src+"?nocache="+new Date().getTime();    
        }    
        </script>  

</body>
</html>