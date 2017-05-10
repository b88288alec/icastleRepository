<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>


</head>
<body>
<!-- <form METHOD="POST" ACTION="LineLogin.do"> -->
</form>
<script src="../js/jquery.min.js"></script>

<script>
// <script type="text/javascript" 
// src="https://api.line.me/v1/oauth/accessToken?
// grant_type='authorization_code'
// &client_id='1514098572'
// &client_secret='75358cffd533e94be20e515004d34c97'
// &code='${param.code}'
// &redirect_uri:'http://localhost:8081/iCastle/members/forLineLogin.jsp'">


//   $(function(){
// 	$.getJSON('https://api.line.me/v1/oauth/accessToken',
// 			{grant_type:"authorization_code",
// 		     client_id:"1514098572",
// 		     client_secret:'75358cffd533e94be20e515004d34c97',
// 		     code:'${param.code}',
// 		     redirect_uri:'http://localhost:8081/iCastle/members/forLineLogin.jsp',
	
		
// 		});

// 	})

$(function(){

	$.ajax({
	  url: "https://api.line.me/v1/oauth/accessToken",
	  type:"POST",
	  dataType:"jsonp",
	  data:{grant_type:"authorization_code",
		     client_id:"1514098572",
		     client_secret:'75358cffd533e94be20e515004d34c97',
		     code:'${param.code}',
		     redirect_uri:'http://localhost:8081/iCastle/general/members/LineLogin.do'
	
	 }
	  
	
	}).done(function(datas){
		console.log($(datas).children('mid').text());
		
	});
	
})

</script>




</body>
</html>