<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
				<td><input type="submit" value="確定"></td>
				<td><input id="onekey" type="submit" value="一鍵輸入"></td>
			</tr>
			</tbody>
		</table>
		</form>
    
    
    
    </div>
    <!--content end!!!!!!!!!!!!~~~~~~~~~~-->
    
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
	
</body>
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
			$('input[name = "email"]').val("andy@yahoo.com.tw");
			$('input[name = "pw"]').val("123");
		
		});
	})
</script>



</html>