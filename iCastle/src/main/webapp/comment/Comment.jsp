<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    .photodiv{ 
    border:3px black solid; 
	height:300px; 
    width:500px; 
    } 


</style>
<script>

window.onload = function(){
	
	var x = 0
	
	document.getElementById("star1").onclick = function(){
		document.getElementById("serviceScore").value="1";
		document.getElementById("star1").src="../img/star.png";
		document.getElementById("star2").src="../img/unstar.png";
		document.getElementById("star3").src="../img/unstar.png";
		document.getElementById("star4").src="../img/unstar.png";
		document.getElementById("star5").src="../img/unstar.png";
		console.log("1&1");
	}
	
	document.getElementById("star2").onclick = function(){
		document.getElementById("serviceScore").value="2";
		document.getElementById("star1").src="../img/star.png";
		document.getElementById("star2").src="../img/star.png";
		document.getElementById("star3").src="../img/unstar.png";
		document.getElementById("star4").src="../img/unstar.png";
		document.getElementById("star5").src="../img/unstar.png";
		console.log("2&2");
	}
	
	document.getElementById("star3").onclick = function(){
		document.getElementById("serviceScore").value="3";
		document.getElementById("star1").src="../img/star.png";
		document.getElementById("star2").src="../img/star.png";
		document.getElementById("star3").src="../img/star.png";
		document.getElementById("star4").src="../img/unstar.png";
		document.getElementById("star5").src="../img/unstar.png";
		console.log("3&3");
	}
	
	document.getElementById("star4").onclick = function(){
		document.getElementById("serviceScore").value="4";
		document.getElementById("star1").src="../img/star.png";
		document.getElementById("star2").src="../img/star.png";
		document.getElementById("star3").src="../img/star.png";
		document.getElementById("star4").src="../img/star.png";
		document.getElementById("star5").src="../img/unstar.png";
		console.log("4&4");
	}
	
	document.getElementById("star5").onclick = function(){
		document.getElementById("serviceScore").value="5";
		document.getElementById("star1").src="../img/star.png";
		document.getElementById("star2").src="../img/star.png";
		document.getElementById("star3").src="../img/star.png";
		document.getElementById("star4").src="../img/star.png";
		document.getElementById("star5").src="../img/star.png";
		console.log("5&5");
	}
	
	document.getElementById("star6").onclick = function(){
		document.getElementById("qualityScore").value="1";
		document.getElementById("star6").src="../img/star.png";
		document.getElementById("star7").src="../img/unstar.png";
		document.getElementById("star8").src="../img/unstar.png";
		document.getElementById("star9").src="../img/unstar.png";
		document.getElementById("star10").src="../img/unstar.png";
		console.log("6&1");
	}
	
	document.getElementById("star7").onclick = function(){
		document.getElementById("qualityScore").value="2";
		document.getElementById("star6").src="../img/star.png";
		document.getElementById("star7").src="../img/star.png";
		document.getElementById("star8").src="../img/unstar.png";
		document.getElementById("star9").src="../img/unstar.png";
		document.getElementById("star10").src="../img/unstar.png";
		console.log("7&2");
	}
	
	document.getElementById("star8").onclick = function(){
		document.getElementById("qualityScore").value="3";
		document.getElementById("star6").src="../img/star.png";
		document.getElementById("star7").src="../img/star.png";
		document.getElementById("star8").src="../img/star.png";
		document.getElementById("star9").src="../img/unstar.png";
		document.getElementById("star10").src="../img/unstar.png";
		console.log("8&3");
	}
	
	document.getElementById("star9").onclick = function(){
		document.getElementById("qualityScore").value="4";
		document.getElementById("star6").src="../img/star.png";
		document.getElementById("star7").src="../img/star.png";
		document.getElementById("star8").src="../img/star.png";
		document.getElementById("star9").src="../img/star.png";
		document.getElementById("star10").src="../img/unstar.png";
		console.log("9&4");
	}
	
	document.getElementById("star10").onclick = function(){
		document.getElementById("qualityScore").value="5";
		document.getElementById("star6").src="../img/star.png";
		document.getElementById("star7").src="../img/star.png";
		document.getElementById("star8").src="../img/star.png";
		document.getElementById("star9").src="../img/star.png";
		document.getElementById("star10").src="../img/star.png";
		console.log("10&5");
	}
	
	document.getElementById("star11").onclick = function(){
		document.getElementById("sceneScore").value="1";
		document.getElementById("star11").src="../img/star.png";
		document.getElementById("star12").src="../img/unstar.png";
		document.getElementById("star13").src="../img/unstar.png";
		document.getElementById("star14").src="../img/unstar.png";
		document.getElementById("star15").src="../img/unstar.png";
		console.log("11&1");
	}
	
	document.getElementById("star12").onclick = function(){
		document.getElementById("sceneScore").value="2";
		document.getElementById("star11").src="../img/star.png";
		document.getElementById("star12").src="../img/star.png";
		document.getElementById("star13").src="../img/unstar.png";
		document.getElementById("star14").src="../img/unstar.png";
		document.getElementById("star15").src="../img/unstar.png";
		console.log("12&2");
	}
	
	document.getElementById("star13").onclick = function(){
		document.getElementById("sceneScore").value="3";
		document.getElementById("star11").src="../img/star.png";
		document.getElementById("star12").src="../img/star.png";
		document.getElementById("star13").src="../img/star.png";
		document.getElementById("star14").src="../img/unstar.png";
		document.getElementById("star15").src="../img/unstar.png";
		console.log("13&3");
	}
	
	document.getElementById("star14").onclick = function(){
		document.getElementById("sceneScore").value="4";
		document.getElementById("star11").src="../img/star.png";
		document.getElementById("star12").src="../img/star.png";
		document.getElementById("star13").src="../img/star.png";
		document.getElementById("star14").src="../img/star.png";
		document.getElementById("star15").src="../img/unstar.png";
		console.log("14&4");
	}
	
	document.getElementById("star15").onclick = function(){
		document.getElementById("sceneScore").value="5";
		document.getElementById("star11").src="../img/star.png";
		document.getElementById("star12").src="../img/star.png";
		document.getElementById("star13").src="../img/star.png";
		document.getElementById("star14").src="../img/star.png";
		document.getElementById("star15").src="../img/star.png";
		console.log("15&5");
		
	}
	
// 	document.getElementById("star1").onclick = function(){
// 		if(x==0){
// 			document.getElementById("star1").onmouseout = function(){
// 				document.getElementById("star1").src="unstar.png";
// 				document.getElementById("star2").src="unstar.png";
// 				document.getElementById("star3").src="unstar.png";
// 				document.getElementById("star4").src="unstar.png";
// 				document.getElementById("star5").src="unstar.png";
// 			}
			
// 		}else{
			
// 		}
		
// 	}
  
  
	
}


</script>
 
</head>
<body>
<H2>飯店評論</H2>
<!-- enctype="multipart/form-data" -->
<form action = "CommentServlet" method = "POST" enctype="multipart/form-data">



<%-- 訂單編號:<input type = "text" name="orderId"><span style="color:red">${error.orderIdKey}</span><br> --%>
<%-- 飯店編號:<input type = "text" name = "hotelId"><span style="color:red">${error.hotelIdKey}</span><br> --%>
服務評分:
<img src="../img/unstar.png" width="50" id="star1">
<img src="../img/unstar.png" width="50" id="star2">
<img src="../img/unstar.png" width="50" id="star3">
<img src="../img/unstar.png" width="50" id="star4">
<img src="../img/unstar.png" width="50" id="star5">
<input type="hidden" id="serviceScore" value="0" name="service"><span style="color:red">${error.serviceKey}</span><br>


品質評分:
<img src="../img/unstar.png" width="50" id="star6">
<img src="../img/unstar.png" width="50" id="star7">
<img src="../img/unstar.png" width="50" id="star8">
<img src="../img/unstar.png" width="50" id="star9">
<img src="../img/unstar.png" width="50" id="star10">
<input type="hidden" id="qualityScore" value="0" name="quality"><span style="color:red">${error.qualityKey}</span><br>


風景評分:
<img src="../img/unstar.png" width="50" id="star11">
<img src="../img/unstar.png" width="50" id="star12">
<img src="../img/unstar.png" width="50" id="star13">
<img src="../img/unstar.png" width="50" id="star14">
<img src="../img/unstar.png" width="50" id="star15">
<input type="hidden" id="sceneScore" value="0" name="scene"><span style="color:red">${error.sceneKey}</span><br>

<div class="photodiv">
</div>
上傳照片:
<input type="file" name="uploadphoto" multiple><br>


會員評論<textarea name = "comment" value="${error.comment}"></textarea><span style="color:red">${error.commentKey}</span><br>


<Input type = "submit"  value = "送出" >

</form>

</body>
</html>