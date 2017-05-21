<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
<link
	href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.servletContext.contextPath}/css/material-dashboard.css"
	rel="stylesheet" />
<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.servletContext.contextPath}/css/manager_template.css"
	rel="stylesheet" />
<!--     圖表用CSS -->
    <link href="${pageContext.servletContext.contextPath}/css/chartist.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/chartist-plugin-tooltip.css" rel="stylesheet" />
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
    	text.ct-label{
    		font-size:32px;
    	}
/*     	.mastype{ */
/*     		text-align:center; */
/*     	} */
    	.gradeRound1{
    		border:3px solid #75c2df;
    		background-color:#75c2df;
    		width: 0px;
	    	height: 5px;
    		margin-top: 6px;
    	}
    	.gradeRound2{
    		border:3px solid #f05b4f;
    		background-color:#f05b4f;
    		width: 0px;
	    	height: 5px;
    		margin-top: 6px;
    	}
    </style>

<title>iCastle飯店管理中心</title>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/hotelManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
	<div class="content">
		<div class="container-fluid">
			<div class="row">
			
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
    			<option value="3">圓餅圖</option>
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
    
			</div>
		</div>
	</div>
	<!--內容區塊-->

	<!--開始footer-->
	<jsp:include page="../fragment/hotelManagementFooter.jsp" />
	<!--結束footer-->
</body>

<script
	src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>


<script src="${pageContext.servletContext.contextPath}/js/calendar.js"></script>
<!-- 圖表用JS -->
<%-- <script src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script> --%>
<script src="${pageContext.servletContext.contextPath}/js/chartist-plugin-tooltip.js"></script>
<!-- loading用 -->
<script src="https://cdn.jsdelivr.net/jquery.loadingoverlay/latest/loadingoverlay.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.loadingoverlay/latest/loadingoverlay_progress.min.js"></script>

<script>
	$(function(){
		
// 		事件觸發
		$('#idSelectYear').on("change", orders);
		$('#idSelectRoomTypeName').on("change", orders);
		$('#idSelectOrderState').on("change", orders);
		$('#idSelectMonth').on("change", orders);
		$('#idSelectDate').on("change", orders);
		$('body').on("click","button[name='updatechange']", updatememo);
		
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
				beforeSend:function(){
                    $.LoadingOverlay("show");
                },
                complete:function(){
                	$.LoadingOverlay("hide", true);
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
				beforeSend:function(){
                    $.LoadingOverlay("show");
                },
                complete:function(){
                	$.LoadingOverlay("hide", true);
                },
				success : function(data){
					var tb = $('#idtbody');
					
					tb.empty();
					$.each(data, function(key, value){
						
// 						訂單詳細資料
						var tdid = ('td' + value.orderId);
						var content = ('<div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title" id="myModalLabel">訂單明細</h4></div><div class="modal-body myselfdiv"><table class="table"><tbody><tr><td>訂單編號</td><td>'+value.orderId+'</td></tr><tr><td>下訂日期</td><td>'+value.orderedDate+'</td></tr><tr><td>房型名稱</td><td>'+value.roomTypeName+'</td></tr><tr><td>入住日期</td><td>'+value.checkinDay+'</td></tr><tr><td>退房日期</td><td>'+value.checkoutDay+'</td></tr><tr><td>訂房數量</td><td>'+value.roomCount+'</td></tr><tr><td>入住人數</td><td>'+value.peopleNum+'</td></tr><tr><td>早餐</td><td>'+value.breakfast+'</td></tr><tr><td>晚餐</td><td>'+value.dinner+'</td></tr><tr><td>下午茶</td><td>'+value.afternoonTea+'</td></tr><tr><td>入住人姓名</td><td>'+value.reservationer+'</td></tr><tr><td>生日</td><td>'+value.bdate+'</td></tr><tr><td>電話</td><td>'+value.tel+'</td></tr><tr><td>E-mail</td><td>'+value.email+'</td></tr><tr><td>地址</td><td>'+value.addr+'</td></tr><tr><td>身分證字號</td><td>'+value.personId+'</td></tr><tr><td>國籍</td><td>'+value.country+'</td></tr><tr><td>護照號碼</td><td>'+value.passport+'</td></tr><tr><td>加床</td><td>'+value.bedAdding+'</td></tr><tr><td>總金額</td><td>'+value.price+'</td></tr><tr><td>旅客備註</td><td>'+value.customerRemark+'</td></tr><tr><td>備忘錄</td><td><textarea class="myselfwidth" name="writememo" id="w'+value.orderId+'">'+value.memo+'</textarea></td></tr><tr><td>訂單狀態</td><td>'+value.orderState+'</td></tr><tr><td>取消日期</td><td>'+value.cancelDate+'</td></tr></tbody></table></div><div class="modal-footer"><button type="button" id="'+value.orderId+'" class="btn btn-info btn-simple" name="updatechange" data-dismiss="modal">修改</button><button type="button" class="btn btn-default btn-simple" data-dismiss="modal">取消</button></div></div></div>');
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
						var btn = $('<button></button>').attr('data-toggle', 'modal').attr('data-target', oId).text(value.orderState);
						
						if(value.orderState == '已取消'){
							btn.attr('class', 'btn btn-primary btn-danger');
						}else{
							btn.attr('class', 'btn btn-primary btn-success');
						}
						
						d13.append(btn);
						d0.append(content);
						r.append([d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13]);
						tb.append([r,d0]);
					})
//				 	修正modal的bug
					$('.modal').appendTo("body");
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
					beforeSend:function(){
	                    $.LoadingOverlay("show");
	                },
	                complete:function(){
	                	$.LoadingOverlay("hide", true);
	                },
					success : function(data){
						var chart = new Chartist.Bar('.ct-chart', data ,{distributeSeries: true, plugins: [Chartist.plugins.tooltip()]});
						// Let's put a sequence number aside so we can use it in the event callbacks
						var seq = 0,
						  delays = 10,
						  durations = 200;

						// Once the chart is fully created we reset the sequence
						chart.on('created', function() {
						  seq = 0;
						});

						// On each drawn element by Chartist we use the Chartist.Svg API to trigger SMIL animations
						chart.on('draw', function(data) {
						  seq++;

						  if(data.type === 'bar') {
						    // If the drawn element is a line we do a simple opacity fade in. This could also be achieved using CSS3 animations.
						    data.element.animate({
						      opacity: {
						        // The delay when we like to start the animation
						        begin: seq * delays,
						        // Duration of the animation
						        dur: durations,
						        // The value where the animation should start
						        from: 0,
						        // The value where it should end
						        to: 1
						      }
						    });
						  }
						});

						// For the sake of the example we update the chart every time it's created with a delay of 10 seconds
						chart.on('created', function() {
						  if(window.__exampleAnimateTimeout) {
						    clearTimeout(window.__exampleAnimateTimeout);
						    window.__exampleAnimateTimeout = null;
						  }
						  window.__exampleAnimateTimeout = setTimeout(chart.update.bind(chart), 600000);
						});
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
					beforeSend:function(){
	                    $.LoadingOverlay("show");
	                },
	                complete:function(){
	                	$.LoadingOverlay("hide", true);
	                },
					success : function(datas){
						$('#showdatapic').remove();
						var chart = new Chartist.Line('.ct-chart', datas, {fullWidth:true, chartPadding:{right: 40}, lineSmooth: Chartist.Interpolation.simple({divisor: 99}),showArea: true, plugins: [Chartist.plugins.tooltip()]});
					
						// Let's put a sequence number aside so we can use it in the event callbacks
						var seq = 0,
						  delay = 10,
						  delays = 15,
						  durations = 600;

						// Once the chart is fully created we reset the sequence
						chart.on('created', function() {
						  seq = 0;
						});

						// On each drawn element by Chartist we use the Chartist.Svg API to trigger SMIL animations
						chart.on('draw', function(data) {
						  seq++;

						  if(data.type === 'line' || data.type === 'area') {
						    // If the drawn element is a line we do a simple opacity fade in. This could also be achieved using CSS3 animations.
						    data.element.animate({
						      opacity: {
						        // The delay when we like to start the animation
						        begin: seq * delays + 1000,
						        // Duration of the animation
						        dur: durations,
						        // The value where the animation should start
						        from: 0,
						        // The value where it should end
						        to: 1
						      }
						    });
						  } else if(data.type === 'label' && data.axis === 'x') {
						    data.element.animate({
						      y: {
						        begin: seq * delay,
						        dur: durations,
						        from: data.y + 100,
						        to: data.y,
						        // We can specify an easing function from Chartist.Svg.Easing
						        easing: 'easeOutQuart'
						      }
						    });
						  } else if(data.type === 'label' && data.axis === 'y') {
						    data.element.animate({
						      x: {
						        begin: seq * delay,
						        dur: durations,
						        from: data.x - 100,
						        to: data.x,
						        easing: 'easeOutQuart'
						      }
						    });
						  } else if(data.type === 'point') {
						    data.element.animate({
						      x1: {
						        begin: seq * delay,
						        dur: durations,
						        from: data.x - 10,
						        to: data.x,
						        easing: 'easeOutQuart'
						      },
						      x2: {
						        begin: seq * delay,
						        dur: durations,
						        from: data.x - 10,
						        to: data.x,
						        easing: 'easeOutQuart'
						      },
						      opacity: {
						        begin: seq * delay,
						        dur: durations,
						        from: 0,
						        to: 1,
						        easing: 'easeOutQuart'
						      }
						    });
						  } else if(data.type === 'grid') {
						    // Using data.axis we get x or y which we can use to construct our animation definition objects
						    var pos1Animation = {
						      begin: seq * delays,
						      dur: durations,
						      from: data[data.axis.units.pos + '1'] - 30,
						      to: data[data.axis.units.pos + '1'],
						      easing: 'easeOutQuart'
						    };

						    var pos2Animation = {
						      begin: seq * delays,
						      dur: durations,
						      from: data[data.axis.units.pos + '2'] - 100,
						      to: data[data.axis.units.pos + '2'],
						      easing: 'easeOutQuart'
						    };
						  }
						});

						// For the sake of the example we update the chart every time it's created with a delay of 10 seconds
						chart.on('created', function() {
						  if(window.__exampleAnimateTimeout) {
						    clearTimeout(window.__exampleAnimateTimeout);
						    window.__exampleAnimateTimeout = null;
						  }
						  window.__exampleAnimateTimeout = setTimeout(chart.update.bind(chart), 600000);
						});
						
						var dataname1 = datas.series[0].name;
						var datapic1 = $('<div></div>').addClass('col-md-1 gradeRound1');
						var datashowname1 = $('<div></div>').addClass('col-md-1').append($('<p></p>').text(dataname1));
						var dataname2 = datas.series[1].name;
						var datapic2 = $('<div></div>').addClass('col-md-1 gradeRound2');
						var datashowname2 = $('<div></div>').addClass('col-md-1').append($('<p></p>').text(dataname2));
						var dataground = $('<div></div>').addClass('row').attr('id','showdatapic').append([datapic1,datashowname1,datapic2,datashowname2]);
						$('#showData').after(dataground);
						
					}
				})
			}else{
				$.ajax({
					type : 'GET',
					url : '${pageContext.servletContext.contextPath}/hotelcenter/OrdersPieChartServlet',
					data : {
						hotelId : ${HotelLoginOK.hotelId},
						year : $('#idSelectYear').val(),
						month : $('#idSelectMonth').val(),
						state : $('#idSelectOrderState').val()
					},
					success : function(data){
						var options = {
							labelInterpolationFnc: function(value) {
								return value[0]
							}
						};

						var responsiveOptions = [
							['screen and (min-width: 640px)', {
								chartPadding: 30,
								labelOffset: 100,
								labelDirection: 'explode',
								labelInterpolationFnc: function(value) {
									return value;
								}
							}],
							['screen and (min-width: 1024px)', {
								labelOffset: 10,
								chartPadding: 20
							}]
						];

						new Chartist.Pie('.ct-chart', data, options, responsiveOptions);

						var totalcount = 0;
						for(i = 0; i < data.labels.length; i++){
							totalcount = totalcount + data.series[i];
						}
						
					}
				})
			}
		}
		
	});
</script>
</html>