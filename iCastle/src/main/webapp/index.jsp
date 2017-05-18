<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/index.css" rel="stylesheet" />

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
		<jsp:include page="fragment/nav.jsp"/>
	<!--結束導覽列-->

	<!--header背景-->
	<div clsaa="container-fluid" style="position: relative;">
		<img src="${pageContext.servletContext.contextPath}/img/header.jpg" class="header-bg" /> <img
			src="${pageContext.servletContext.contextPath}/img/overlay.png" class="logoheader img-responsive" />
		<div class="header-overlay"></div>
		<!--結束header背景-->

		<!--搜尋列表-->
		<div class="row query-overlay">
			<form action="Query.do" method="get">
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>關鍵字</p>
						<input type="text" class="form-control" placeholder="輸入區域或飯店名稱" id="type"
							name="type" autocomplete="off"/>
					</div>
					<div id="div1"></div>
				</div>
				

				
				
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>入住日期</p>
						<input type="text" id="startDate" class="form-control datepicker"
							placeholder="輸入入住日期" name="start" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>退房日期</p>
						<input type="text" id="endDate" class="form-control datepicker"
							placeholder="輸入退房日期" name="end" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<div class="input-group input-group-sm">
						<p>入住人數</p>
						<input type="text" class="form-control" placeholder="輸入入住人數"
							name="peopleNum" />
					</div>
				</div>
				<div class="clearfix visible-xs-block"></div>
				<div class="col-md-2 col-xs-12 col-sm-4" style="margin: 15px;">
					<br />
					<div class="btn-group">
						<input type="submit" class="btn btn-success" value="搜尋" />
						<input type="button" class="btn" id="onekey" value="一鍵輸入" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--結束搜尋列表-->
	<!--精選飯店-->
	<div class="container page-wrap">
		<div class="page-header">
			<h1>精選飯店</h1>
		</div>
		
			<c:forEach var="hotel" items="${hotels}" varStatus="loop">
				<c:if test="${loop.index%3==0}">
					<div class="row arowHotel">			
				</c:if>
			
				<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;">
					<div class="card" style="width:300px; heigth:225px">
						<div class="crop">					
							<img src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${hotel.hotelId}&type=hotelid"
							style="width: 100%; max-height: 100%" />
						</div>
						<div class="cardContext">
							<h4>${hotel.hotelName}</h4>
							<p>${hotel.zone}</p>
						</div>
					</div>
				</div>
				
				<c:if test="${loop.index%3==2 || loop.end}">
					</div>			
				</c:if>
			</c:forEach>
	</div>
	</div>
<!-- 			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;"> -->
<!-- 				<div class="card" style="width: 300px;"> -->
<%-- 					<img src="${pageContext.servletContext.contextPath}/img/3843_15070211000031541467.jpg" --%>
<!-- 						style="width: 100%;" /> -->
<!-- 					<div class="cardContext"> -->
<!-- 						<h4>漢來大飯店</h4> -->
<!-- 						<p>高雄前金區</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;"> -->
<!-- 				<div class="card" style="width: 300px;"> -->
<%-- 					<img src="${pageContext.servletContext.contextPath}/img/201242_16042216170041722027.jpg" --%>
<!-- 						style="width: 100%;" /> -->
<!-- 					<div class="cardContext"> -->
<!-- 						<h4>蘭城晶英酒店</h4> -->
<!-- 						<p>宜蘭市</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-3 col-xs-12 col-sm-4" style="margin-right: 60px;"> -->
<!-- 				<div class="card" style="width: 300px;"> -->
<%-- 					<img src="${pageContext.servletContext.contextPath}/img/104996_110408145504225.jpg" --%>
<!-- 						style="width: 100%;" /> -->
<!-- 					<div class="cardContext"> -->
<!-- 						<h4>礁溪老爺酒店</h4> -->
<!-- 						<p>宜蘭縣礁溪鄉</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

	<!--結束精選飯店-->
<%
	HttpSession sess = request.getSession();
	sess.removeAttribute("hotels");
%>

    <!--開始footer-->
		<jsp:include page="fragment/footer.jsp"/>
	<!--結束footer-->

	<!--<script src="js/jquery.min.js"></script>-->
	<script src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

	<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

	<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/locales/bootstrap-datepicker.zh-TW.min.js"></script>

	<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>
	<script src="${pageContext.servletContext.contextPath}/js/index.js"></script>
	<script>
		$(function() {
			$('#onekey').click(function() {
				event.preventDefault();
    			$('input[name = "type"]').val('台北');
    			$('input[name = "start"]').val('2017/06/02'); 
    			$('input[name = "end"]').val('2017/06/04');
    			$('input[name = "peopleNum"]').val(4);
			});

			$('input[name = "end"]').focus(function() {
				$('input[name = "start"]').datepicker('hide');
			})
			$('input[name = "start"]').focus(function() {
				$('input[name = "end"]').datepicker('hide');
			})
			
			//輸入關鍵字後會自動完成
// 			$('#type').keyup(function(){
				
				
// 				$.ajax({
// 				     'type':'get',
// 				     'url':'AutoCompleteServlet.do',
// 				     'dataType':'json',
// 				     'data':{'type':$(this).val()}
// 				}).done(function(datas){
// 					console.log(datas);
// 				});

// 			});
		});
		
		
		//改呼叫 JsonSimpleDemo servlet 會回傳陣列的資料
		var ajax = null, show = null, txt = null;
		window.addEventListener("load", init, false);
		
		//載入網頁，進行初始化
		function init() {
			txt = document.getElementById("type");
			txt.addEventListener("keyup", inputData, false);
			show = document.getElementById("div1");
		}
		
		//輸入資料後
		function inputData(){
			ajax = new XMLHttpRequest();
			if (ajax != null){
				console.log(txt.value);
				if (txt.value == "" || txt.value == null){
					if (show.childNodes.length > 0) {
						show.removeChild(show.childNodes[0]); 
					}
				}
					
				ajax.addEventListener("readystatechange", getData);
				ajax.open("GET", "AutoCompleteServlet.do?keyword="+txt.value, true);
				ajax.send();
				
			}else
				console.log('您的瀏覽器不支援AJAX');
		}
		
		//servlet回傳資料
		function getData() {
			if (ajax.readyState==4){
				if (ajax.status==200){
					var datas = JSON.parse(ajax.responseText);
					
					if (show.childNodes.length > 0) {
						show.removeChild(show.childNodes[0]);
					}
					
					//建立List
					createList(datas);
					
				}else
					console.log(ajax.status+": "+ajax.statusText);
			}
		}
		
		//建立List
		function createList(datas){
			show.style.display = "block";
			show.style.position = "absolute";
			var eleDiv = document.createElement("div");
			eleDiv.className = "list-group";
			for (var j = 0, max = datas.length; j < max; j++) {
				var txtBtn = document.createTextNode(datas[j]);
				var eleBtn = document.createElement("button");
				eleBtn.className = "list-group-item";
				eleBtn.setAttribute("type", "button");
				eleBtn.appendChild(txtBtn);

				eleBtn.addEventListener("blur", function() {
					show.style.display = "none";
				}, false)
					
				//點擊選項後
				eleBtn.addEventListener("click", function() {
					
					txt.value = this.firstChild.nodeValue;
					show.style.display = "none";
				}, false)
				eleDiv.appendChild(eleBtn);
			}
			show.appendChild(eleDiv);
		}
	</script>
</body>
</html>