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
<link href="${pageContext.servletContext.contextPath}/css/sweetalert2.css" rel="stylesheet" />
<title>iCastle飯店管理中心</title>
<style> 
	.container {
	    width: 1300px;
	    margin-top: 100px;
	}
	td {
		height: 30px;
	}
	#hotelname1 {
		width: 110px;
	}
	.facility {
		color:black;
	}
</style>
</head>
<body>
	<!--開始左側及上方導覽列-->
	<jsp:include page="../fragment/hotelManagement.jsp" />
	<!--開始左側及上方導覽列-->

	<!--內容區塊-->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header" data-background-color="green">
                                    <h4 class="title">編輯我的飯店</h4>
                                    <p class="category">避免消費糾紛，確實填寫</p>
                                </div>
                                <div class="card-content">
                                    <form action="UpdateHotelInfo.do" method="post">
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">電話:</p>
                                                <input type="text" placeholder="請輸入電話" class="form-control"  name="tel" value="${HotelInfo.tel}" />
                                                <font color="red">${errMap.telErr}</font>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">官方網站:</p>
                                                <input type="text" placeholder="請輸入官方網站" class="form-control" name="website" value="${HotelInfo.website}" />
                                                <font color="red">${errMap.websiteErr}</font>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">交通方式:</p>
                                                <textarea class="form-control" placeholder="請輸入交通方式" name="transport" rows="5">${HotelInfo.transport}</textarea>
												<font color="red">${errMap.transportErr}</font>                                            
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">飯店介紹:</p>
                                                <textarea class="form-control" placeholder="請輸入飯店介紹" name="hotelProfile" rows="5">${HotelInfo.hotelProfile}</textarea>
                                            	<font color="red">${errMap.hotelProfileErr}</font> 
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">Check-in時間:</p>
                                                <select name="checkin" value="${HotelInfo.checkin}" class="form-control" style="width:100px">
                                                	
                                                	<option value="3:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '3:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>3:00 PM</option>
                                                	<option value="4:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '4:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>4:00 PM</option>
                                                	<option value="5:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '5:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>5:00 PM</option>
                                                	<option value="6:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '6:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>6:00 PM</option>
                                                	<option value="7:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '7:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>7:00 PM</option>
                                                	<option value="8:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '8:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>8:00 PM</option>
                                                	<option value="9:00 PM"
                                                	<c:if test="${HotelInfo.checkin == '9:00 PM'}">
                                                		selected
                                                	</c:if>
                                                	>9:00 PM</option>
                                                </select>
                                                <font color="red">${errMap.checkinErr}</font> 
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">Check-out時間:</p>
                                                <select name="checkout" value="${HotelInfo.checkout}" class="form-control" style="width:100px">
	                                                <option value="7:00 AM"
	                                                	<c:if test="${HotelInfo.checkout == '7:00 AM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>7:00 AM</option>
	                                                <option value="8:00 AM"
	                                                	<c:if test="${HotelInfo.checkout == '8:00 AM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>8:00 AM</option>
	                                                <option value="9:00 AM"
	                                                	<c:if test="${HotelInfo.checkout == '9:00 AM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>9:00 AM</option>
	                                                <option value="10:00 AM"
	                                                	<c:if test="${HotelInfo.checkout == '10:00 AM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>10:00 AM</option>
	                                                <option value="11:00 AM"
	                                                	<c:if test="${HotelInfo.checkout == '11:00 AM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>11:00 AM</option> 
	                                                <option value="12:00 PM"
	                                                	<c:if test="${HotelInfo.checkout == '12:00 PM'}">
	                                                		selected
	                                                	</c:if>
	                                                	>12:00 PM</option>
	                                            </select>
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">入住須知:</p>
                                                <textarea class="form-control" placeholder="請輸入入住須知" rows="5" name="guestPolicies">${HotelInfo.guestPolicies}</textarea>
                                                <font color="red">${errMap.guestPoliciesErr}</font> 
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <p style="font-size: 16px;">取消規定:</p>
                                                <textarea class="form-control" placeholder="請輸入取消規定" name="cancelPolicies" rows="5">${HotelInfo.cancelPolicies}</textarea>
                                                <font color="red">${errMap.cancelPoliciesErr}</font> 
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <p style="font-size: 16px;">設施:</p>
                                            <div class="col-md-4">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="roomWifi"
                                                        <c:if test="${HotelInfo.roomWifi == true}">
															checked
														</c:if>
                                                        >
                                                        室內WiFi
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="hallWifi"
                                                        <c:if test="${HotelInfo.hallWifi == true}">
															checked
														</c:if>
                                                        >
                                                        大廳WiFi
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="internet"
                                                        <c:if test="${HotelInfo.internet == true}">
															checked
														</c:if>
                                                        >
                                                        網際網路
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="mineralWater"
                                                        <c:if test="${HotelInfo.mineralWater == true}">
															checked
														</c:if>
                                                        >
                                                        礦泉水
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="toiletUtensils"
                                                        <c:if test="${HotelInfo.toiletUtensils == true}">
															checked
														</c:if>
                                                        >
                                                        盥洗用具
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="hairDryer"
                                                        <c:if test="${HotelInfo.hairDryer == true}">
															checked
														</c:if>
                                                        >
                                                        吹風機
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="tv"
                                                        <c:if test="${HotelInfo.tv== true}">
															checked
														</c:if>
                                                        >
                                                        電視
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="gameRoom"
                                                        <c:if test="${HotelInfo.gameRoom== true}">
															checked
														</c:if>
                                                        >
                                                        遊戲室
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="gym"
                                                        <c:if test="${HotelInfo.gym== true}">
															checked
														</c:if>
                                                        >
                                                        健身房
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="spa"
                                                        <c:if test="${HotelInfo.spa== true}">
															checked
														</c:if>
                                                        >
                                                        溫泉
                                                    </label>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="swimPool"
                                                        <c:if test="${HotelInfo.swimPool== true}">
															checked
														</c:if>
                                                        >
                                                        游泳池
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        
                                        <button type="reset" class="btn btn-danger pull-right">重設</button>
                                        <button type="submit" class="btn btn-success pull-right">送出修改</button>
                                        <button class="btn btn-default pull-right" id="onekey">一鍵輸入</button>
                                    </form>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card card-profile">
                                <div class="card-avatar">
                                    <img src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${HotelLoginOK.hotelId}&type=hotelid" class="img" style="width:130px;height:130px"/>
                                    
                                </div>
                                <div class="content">
                                    <h4 class="card-title">${HotelLoginOK.hotelName}</h4>
                                    <h6 class="category text-gray">${HotelLoginOK.email}</h6>
                                    <div style="margin-bottom:5px">
                                    	<!-- 飯店星等 -->
										<c:forEach var="i" varStatus="varsts" begin="1" end="5">
											<c:choose>
												<c:when test="${i<=HotelLoginOK.star}">
													<img src="${pageContext.servletContext.contextPath}/img/star.png" style="width:20px;" />
												</c:when>
												<c:otherwise>
													<img src="${pageContext.servletContext.contextPath}/img/unstar.png" style="width:20px;" />
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<!-- 飯店星等結束 -->

                                    </div>
                                    <h6 class="category text-gray">登記人: ${HotelInfo.registerName}</h6>
                                    <h6 class="category text-gray">登記證號: ${HotelLoginOK.registerId}</h6>
                                    <h6 class="category text-gray">地區:${HotelLoginOK.zone}</h6>
                                    <h6 class="category text-gray">地址:${HotelLoginOK.addr}</h6>
                                </div>
                            </div>
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

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/sweetalert2.min.js"></script>
<script>
	$(function() {
		
		//修改成功提示
 		<c:if test="${not empty OK}">
			swal({
	    		title: '成功修改飯店資料',
				type: 'success'
			});	
     	</c:if>
		
	
		$('#onekey').click(function() {
			event.preventDefault();
			$('input[name = "hotelName"]').val('涵碧樓酒店');
			$('input[name = "email"]').val('eeit93no1@gmail.com');
			$('input[name = "pw"]').val('123456');
			$('input[name = "pwcheck"]').val('123456');
			$('#star').val('5');
			$('input[name = "registerName"]').val('小智');
			$('input[name = "registerId"]').val('南投縣第560號');
			$('input[name = "tel"]').val('0225694586');
			$('input[name = "addr"]').val('南投縣魚池鄉中興路142號');
			$('input[name = "zone"]').val('南投縣魚池鄉');
			$(':input[name = "transport"]').text('搭乘火車到南投火車站接著轉6路公車');
			$('input[name = "website"]').val('http://www.bilo.com');
			$(':input[name = "hotelProfile"]').val('位於日月潭湖畔');
			$('input[name = "checkin"]').val('5:00 PM');
			$('input[name = "checkout"]').val('9:00 AM');
			$(':input[name = "guestPolicies"]').val('不可攜帶寵物入內');
			$(':input[name = "cancelPolicies"]').val('不可以取消');
			$('input[name = "roomWifi"]').prop('checked');
		});
		

	});
</script>	
</html>