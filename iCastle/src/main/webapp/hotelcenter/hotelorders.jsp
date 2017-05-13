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
<!-- <link -->
<%-- 	href="${pageContext.servletContext.contextPath}/css/paper-dashboard.css" --%>
<!-- 	rel="stylesheet" /> -->
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
<!--     圖表用CSS -->
    <link href="${pageContext.servletContext.contextPath}/css/chartist.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->
    <style>
    	.myselfwidth{
    		height:150px;
    		width:380px;
    	}
    	.myselfdiv{
    		width:600px;
    		overflow:auto;
    	}
    </style>

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	
    <div class="container" style="margin-top:56px">
<%--     <form action="${pageContext.servletContext.contextPath}/hotelcenter/OrdersListServlet" method="post"> --%>
    <table class="table">
    	<tr>
    		<td><span>房型名稱:</span>
    			<select id='idSelectRoomTypeName' name="RTN">
    				<option value="null">--</option>
    				<c:forEach var="rtVO" items="${roomTypeList}">
    					<option value="${rtVO.roomTypeId }">${rtVO.roomTypeName }</option>
    				</c:forEach>
    			</select></td>
    		<td><span>訂單狀態:</span>
    			<select id='idSelectOrderState' name="OS">
    				<option value="null">--</option>
    				<option value="true">成立訂單</option>
    				<option value="false">取消訂單</option>
    			</select></td>
    		<td><select id='idSelectYear' name="year"></select><span>年</span></td>
    		<td><select id='idSelectMonth' name="month"></select><span>月</span></td>
    		<td><select id='idSelectDate' name="day"></select><span>日</span></td>
    		<td><select id='idButton' name="buttonType">
    			<option value="0">列表</option>
    			<option value="1">長條圖</option>
    			<option value="2">折線圖</option>
    		</select></td>
    	</tr>
    </table>
    <div id="showData" class="ct-chart ct-golden-section">
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
<!--     </form> -->
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
<!-- 圖表用JS -->
<script src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script>
	$(function(){
		
// 		事件觸發
		$('#idSelectYear').on("change", orders);
		$('#idSelectRoomTypeName').on("change", orders);
		$('#idSelectOrderState').on("change", orders);
		$('#idSelectMonth').on("change", orders);
		$('#idSelectDate').on("change", orders);
		$('#idtbody').on("click","button[name='updatechange']", updatememo);
		
// 		觸發的方法

		function updatememo(){
			var orderid = $(this).attr('id');
			var tdid = ('#td' + orderid);
			var myMemoId = ('#w' + orderid);
			var myMemo = $(myMemoId).val();
			
			$.ajax({
				type : 'POST',
				url : '${pageContext.servletContext.contextPath}/hotelcenter/OrdersListServlet',
				data : {
					orderId : orderid,
					memo : myMemo
				},
				success : function(data){
					$(tdid).empty().append(myMemo);
				}
			})
		}

		function orders(){
			if($('#idButton').val() == '0'){
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/hotelcenter/OrdersListServlet',
				data : {
					hotelId : ${HotelLoginOK.hotelId},
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
						
// 						訂單詳細資料
						var tdid = ('td' + value.orderId);
						var content = ('<div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title" id="myModalLabel">訂單明細</h4></div><div class="modal-body myselfdiv"><table class="table"><tbody><tr><td>訂單編號</td><td>'+value.orderId+'</td></tr><tr><td>下訂日期</td><td>'+value.orderedDate+'</td></tr><tr><td>房型名稱</td><td>'+value.roomTypeName+'</td></tr><tr><td>入住日期</td><td>'+value.checkinDay+'</td></tr><tr><td>退房日期</td><td>'+value.checkoutDay+'</td></tr><tr><td>訂房數量</td><td>'+value.roomCount+'</td></tr><tr><td>入住人數</td><td>'+value.peopleNum+'</td></tr><tr><td>早餐</td><td>'+value.breakfast+'</td></tr><tr><td>晚餐</td><td>'+value.dinner+'</td></tr><tr><td>下午茶</td><td>'+value.afternoonTea+'</td></tr><tr><td>入住人姓名</td><td>'+value.reservationer+'</td></tr><tr><td>生日</td><td>'+value.bdate+'</td></tr><tr><td>電話</td><td>'+value.tel+'</td></tr><tr><td>E-mail</td><td>'+value.email+'</td></tr><tr><td>地址</td><td>'+value.addr+'</td></tr><tr><td>身分證字號</td><td>'+value.personId+'</td></tr><tr><td>國籍</td><td>'+value.country+'</td></tr><tr><td>護照號碼</td><td>'+value.passport+'</td></tr><tr><td>加床</td><td>'+value.bedAdding+'</td></tr><tr><td>總金額</td><td>'+value.price+'</td></tr><tr><td>旅客備註</td><td>'+value.customerRemark+'</td></tr><tr><td>備忘錄</td><td><textarea class="myselfwidth" name="writememo" id="w'+value.orderId+'">'+value.memo+'</textarea></td></tr><tr><td>訂單狀態</td><td>'+value.orderState+'</td></tr><tr><td>取消日期</td><td>'+value.cancelDate+'</td></tr></tbody></table></div><div class="modal-footer"><button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button><button type="button" id="'+value.orderId+'" class="btn btn-info btn-simple" name="updatechange" data-dismiss="modal">修改</button></div></div></div>');
						var did = ('d' + value.orderId);
						var d0 = $('<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>').attr('id', did);
						
// 						主頁上的訂單資料
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
						var d12 = $('<td></td>').attr("id", tdid).text(value.memo);
						var d13 = $('<td></td>');
						
// 						綁定跳出彈跳頁面
						var oId = ('#' + did);
						var btn = $('<button></button>').attr('class', 'btn btn-primary').attr('data-toggle', 'modal').attr('data-target', oId).text(value.orderState);
						
						d13.append(btn);
						d0.append(content);
						r.append([d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13]);
						tb.append([r,d0]);
					})
				}
			})
			}else if($('#idButton').val() == '1'){
				$.ajax({
					type : 'GET',
					url : '${pageContext.servletContext.contextPath}/hotelcenter/OrdersChartServlet',
					data : {
						hotelId : ${HotelLoginOK.hotelId},
						year : $('#idSelectYear').val(),
						roomTypeId : $('#idSelectRoomTypeName').val(),
						month : $('#idSelectMonth').val(),
						state : $('#idSelectOrderState').val()
					},
					success : function(data){
						new Chartist.Bar('.ct-chart', data ,{distributeSeries: true});
					}
				})
			}else if($('#idButton').val() == '2'){
				$.ajax({
					type : 'GET',
					url : '${pageContext.servletContext.contextPath}/hotelcenter/OrdersLineChartServlet',
					data : {
						hotelId : ${HotelLoginOK.hotelId},
						roomTypeId : $('#idSelectRoomTypeName').val(),
						month : $('#idSelectMonth').val(),
						state : $('#idSelectOrderState').val()
					},
					success : function(data){
						new Chartist.Bar('.ct-chart', data ,{fullWidth: true, chartPadding: {right: 40}});
					}
				})
			}else{
				
			}
		}
		
	});
</script>
</html>