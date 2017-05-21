<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
<!--     Fonts and icons     -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link
	href="${pageContext.servletContext.contextPath}/css/material-kit.css"
	rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css"
	rel="stylesheet" />
	
<link href="${pageContext.servletContext.contextPath}/css/QueryPage.css" rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<style>
.container {
	width: 1400px;
}
.myselfdiv{
    		width:600px;
    		overflow:auto;
    	}
tr{
	height:80px;
}
</style>

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      <form action="CommentServlet" method="post" enctype="multipart/form-data">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <input type="hidden" name="hotelId">
        <input type="hidden" name="orderId">
 
        <h4 class="modal-title" id="myModalLabel">
        
        
        </h4>
      </div>
      <div class="modal-body" id="myDiv">
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
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>
        <button type="sumit" class="btn btn-info btn-simple">Save</button>
       </form>
      </div>
    </div>
  </div>
</div>

	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container" style="margin-top: 100px;">
		<!-- 歷史訂單 -->
			<table class="table" align="center">
				<!--標題列 -->
				<thead>
					<tr>
						<th>訂單號碼</th>
						<th>飯店名稱</th>
						<th>房型名稱</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>房間數</th>
						<th>加床</th>
						<th>價錢</th>
						<th>入住人姓名</th>
						<th>旅客備註</th>
						<th>下單日期</th>
						<th>訂單狀態</th>
						<th class="text-right">評論</th>
						<!--評論 -->
					</tr>
				</thead>
				<tbody id='idtbody'>
				<c:forEach var="myData" items="${ordersKey}">
					
					<!--取出VO裡的List 此orderKey相當於List概念-->
					<%-- 						${myData.orderId} ${myData.orderedDate} ${myData.memberId} ${myData.roomId} ${myData.hotelId} ${myData.hotelName} --%>
					<%-- 						${myData.roomTypeId} ${myData.roomTypeName} ${myData.checkinDay} ${myData.checkoutDay} ${myData.roomCount} --%>
					<%-- 						${myData.peopleNum} ${myData.breakfast} ${myData.dinner} ${myData.afternoonTea} ${myData.price}${myData.roomNo} --%>
					<%-- 						${myData.reservationer} ${myData.bdate} ${myData.tel} ${myData.email} ${myData.addr} ${myData.personId} ${myData.country} --%>
					<%-- 						${myData.passport} ${myData.bedAdding} ${myData.pricePerPerson}${myData.customerRemark} ${myData.hotelRemark} ${myData.memo}  --%>
					<%-- 						${myData.orderState} ${myData.cancelDate}		 --%>
						<tr>
						    
						    <input type="hidden" name="myinput" value="${myData.hotelId}">
						    

						    
							<td>${myData.orderId}</td>
							<td>${myData.hotelName}</td>
							<td>${myData.roomTypeName}</td>
							<td>${myData.checkinDay}</td>
							<td>${myData.checkoutDay}</td>
							<td>${myData.roomCount}</td>
							<td><c:choose>
									<%--orderState布林值判斷改顯示字串--%>
									<c:when test="${myData.bedAdding == true}">加一床</c:when>
									<c:otherwise>無</c:otherwise>
								</c:choose></td>
							<td>${myData.price}</td>
							<td>${myData.reservationer}</td>
							<td>${myData.customerRemark}</td>
							<td><c:choose>
									<%--判斷下單日期--%>
									<c:when test="${myData.orderedDate == null}"> - </c:when>
									<c:otherwise> ${myData.orderedDate} </c:otherwise>
								</c:choose></td>
							<td id="state${myData.orderId}"><c:choose>
									<%--orderState布林值判斷改顯示字串 --%>
									<c:when test="${myData.orderState == true}">訂單成立</c:when>
									<c:otherwise>取消訂單<br>${myData.cancelDate}</c:otherwise>
								</c:choose></td>
							<!--評論 -->
							<c:choose>
							
							<c:when test="${myData.orderState}">   <%-- 訂單成立的話 --%> 
							<c:choose>
							<c:when test="${nocomment}">   <%-- 表示Comment table裡，這email帳號有訂單是已經下過評論的--%> 
							
							<c:set value="false" var="iscomment" />
							<c:forEach var="orderId" items="${alreadycomment}" varStatus="loop">
								
								<c:if test="${!iscomment}">  <%-- true --%>
								<c:choose>
									<c:when test="${myData.orderId == orderId.orderId}">
										<td></td>
										<c:set value="true" var="iscomment" />
									</c:when>
									<c:when test="${loop.last && myData.orderId!=orderId.orderId  && myData.checkoutDay.time > commentTime && myData.checkinDay.time < currentTime}">
										<td class="td-actions text-right" id="comment${myData.orderId}">
												<button type="button" rel="tooltip" title="評論" value="${myData.orderId}" name="comment" id="${myData.orderId}"
													class="btn btn-success btn-simple btn-xs">
													<i class="fa fa-edit"></i>
												</button>

										</td>
<!-- 										<td class="td-actions text-right"><a -->
<%-- 											href="../comment/Comment.jsp?hotelId=${myData.hotelId}&orderId=${myData.orderId}&email=${myData.email}"> --%>
<%-- 												<button type="button" rel="tooltip" title="評論" value="${myData.orderId}" name = "comment" id="${myData.orderId}" --%>
<!-- 													class="btn btn-success btn-simple btn-xs"> -->
<!-- 													<i class="fa fa-edit"></i> -->
<!-- 												</button> -->
<!-- 										</a></td> -->
									</c:when>
								</c:choose>
								</c:if>
								
							</c:forEach>
							</c:when>
							<c:otherwise>
								<c:choose>
								<c:when test="${myData.checkoutDay.time > commentTime && myData.checkinDay.time < currentTime}">
								<td class="td-actions text-right" id="comment${myData.orderId}">
<!-- 								多一行超連結沒刪，導致部分功能還是會導到新的頁面 -->
<%-- 								<a href="../comment/Comment.jsp?hotelId=${myData.hotelId}&orderId=${myData.orderId}&email=${myData.email}"> --%>
												<button type="button" rel="tooltip" title="評論" name="comment" id="${myData.orderId}"
													class="btn btn-success btn-simple btn-xs">
													<i class="fa fa-edit"></i>
												</button>
								</td>
								</c:when>
								<c:otherwise><td></td></c:otherwise>
								</c:choose>
							</c:otherwise>
							</c:choose>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
							</c:choose>

						</tr>

				</c:forEach>
					</tbody>
			</table>
	</div>

	<!--開始footer-->
	<jsp:include page="../fragment/footer.jsp" />
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

<script>
//讀取button的value值
$(function(){
	$('button[name="comment"]').click(function(){
		$("#myModal").modal('show');
		
		//讀取button的id值(orderId)
		var orderId = $(this).attr("id");
		
		//設定input標籤id值，並讀取該標籤的value值
		var hotelId = $("input[name ='myinput']").attr("id",orderId).val();
		//設定給跳出視窗的input標籤
		$("input[name = 'hotelId']").val(hotelId);
		//設定給跳出視窗的input標籤
		$("input[name ='orderId']").val(orderId);		
		
	});
})
</script>
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
	
  	
}


</script>
</html>