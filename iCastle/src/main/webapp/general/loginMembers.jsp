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
    <link href="../css/material-kit.css" rel="stylesheet" />
    <link href="../css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->
	<link href="../css/loginhotel.css" rel="stylesheet" />
	
    <title>愛客宿-iCastle</title>
</head>
<body>





    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
    <!--content start!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container">
	<h1>會員登入</h1>
    
    
    
    
    
    <form action="Login.do" method="post">
		<table class="">
			<tbody>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${param.email}"/>${errMap.accountErr}${errMap.emailErr}</td>
			</tr>
			<tr>
				<td>密碼</td>
				<td><input type="password" name="pw" />${errMap.pwErr}</td>
			</tr>
		<tr>
		<td>請輸入驗證碼</td>
		
		<td> <img border=0 src="${pageContext.servletContext.contextPath}/general/ImageMaskServlet.do"  id ="imageMask"/></td>
<!-- <img border=0 src="DynamicImage.do" width="80" height="80" id ="imageMask"/><br/> -->
 <td>    <a href = "#" style = "font-size: 13px;margin-left: 5px;" onclick = "myReload()">換一張</a></td>
    <td> <input type="text" name="value">${errMap.cdErr}</input> </td></tr>
    
    
			<tr>
				<td><input type="submit" value="確定"></td>
				<td><input id="onekey" type="submit" value="一鍵輸入"></td>
				<td><a href="createPw.jsp">忘記密碼</a></td>
			</tr>
			</tbody>
		</table>
		</form>
    
    
    <button onclick="Auth();">點選這裡連結到Line Login</button>
    </div>
    
    
    
    
    
    
    
    
    <!--content end!!!!!!!!!!!!~~~~~~~~~~-->
    
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
	
</body>

<script>
        function Auth() {
            var URL = 'https://access.line.me/dialog/oauth/weblogin?';
            URL += 'response_type=code';
            URL += '&client_id=1514098572';
            URL += '&redirect_uri=http://localhost:8081/iCastle/members/LineLogin.do';
//             URL += '&state=abcde';
            window.location.href = URL;
        }
    </script>



<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/material.min.js"></script>

<script src="../js/nouislider.min.js"></script>

<script src="../js/bootstrap-datepicker.js"></script>

<script src="../js/material-kit.js"></script>

<script>
	$(function(){
		$('#onekey').click(function() {
			event.preventDefault();
			$('input[name = "email"]').val("sally@gmail.com");
			$('input[name = "pw"]').val("sally123");
		
		});
	})
</script>


<script type="text/javascript">  
       
         function myReload(){    
            document.getElementById("imageMask").src=document.getElementById("imageMask").src+"?nocache="+new Date().getTime();    
        }    
        </script>  


</html>