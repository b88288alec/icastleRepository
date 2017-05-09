<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	
    <div class="container" style="margin-top:56px">
    <table class="table">
    	<tr>
    		<td><span>房型名稱:</span>
    			<select id='idSelectRoomTypeName'>
    				<option value="null">--</option>
    				<c:forEach var="rtVO" items="${roomTypeList}">
    					<option value="${rtVO.roomTypeId }">${rtVO.roomTypeName }</option>
    				</c:forEach>
    			</select></td>
    		<td><span>訂單狀態:</span>
    			<select id='idSelectOrderState'>
    				<option value="null">--</option>
    				<option value="true">成立訂單</option>
    				<option value="false">取消訂單</option>
    			</select></td>
    		<td><select id='idSelectYear'></select><span>年</span></td>
    		<td><select id='idSelectMonth'></select><span>月</span></td>
    		<td><select id='idSelectDate'></select><span>日</span></td>
    	</tr>
    </table>
    <table class="table">
    	<thead>
    		<tr>
    			<th>訂單編號</th><th>下訂日期</th><th>房型名稱</th><th>入住日期</th><th>退房日期</th><th>訂房數量</th><th>入住人數</th><th>入住人姓名</th><th>加床</th><th>總金額</th><th>旅客備註</th><th>備忘錄</th><th>訂單狀態</th>
    		</tr>
        </thead>
    	<tbody id='idtbody'>
    		
    	</tbody>
    </table>
    </div>
    
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

<script src="${pageContext.servletContext.contextPath}/js/calendar.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script>
	$(function(){
		
// 		事件觸發
		$('#idSelectYear').on("change", orders);
		$('#idSelectRoomTypeName').on("change", orders);
		$('#idSelectOrderState').on("change", orders);
		$('#idSelectMonth').on("change", orders);
		$('#idSelectDate').on("change", orders);
		
// 		觸發的方法

		function barChart(){
			
		}

		function orders(){
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/orders/OrdersListServlet',
				data : {
					hotelId : "1",
					year : $('#idSelectYear').val(),
					roomTypeId : $('#idSelectRoomTypeName').val(),
					month : $('#idSelectMonth').val(),
					day : $('#idSelectDate').val(),
					state : $('#idSelectOrderState').val()
				},
				success : function(data){
					var tb = $('#idtbody');
					
					tb.empty();
					$.each(data, function(key, value){
						var r = $('<tr></tr>');
						var d1 = $('<td></td>').text(value.orderId);
						var d2 = $('<td></td>').text(value.orderedDate);
						var d3 = $('<td></td>').text(value.roomTypeName);
						var d4 = $('<td></td>').text(value.checkinDay);
						var d5 = $('<td></td>').text(value.checkoutDay);
						var d6 = $('<td></td>').text(value.roomCount);
						var d7 = $('<td></td>').text(value.peopleNum);
						var d8 = $('<td></td>').text(value.reservationer);
						var d9 = $('<td></td>').text(value.bedAdding);
						var d10 = $('<td></td>').text(value.price);
						var d11 = $('<td></td>').text(value.customerRemark);
						var d12 = $('<td></td>').text(value.memo);
						var d13 = $('<td></td>').text(value.orderState);
						
						tb.append([r,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13]);
					})
				}
			})
		}
		
	});
</script>
</html>