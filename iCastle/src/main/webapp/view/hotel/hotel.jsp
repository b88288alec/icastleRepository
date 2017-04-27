<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="/iCastle/css/material-kit.css" rel="stylesheet" />
    <link href="/iCastle/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->
    <link href="/iCastle/css/hotel.css" rel="stylesheet" />

    <title>愛客宿-iCastle</title>
</head>
<body>
    <!--開始導覽列-->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" height:55px;">
        <div class="container-fluid">
            <!--logo-->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/iCastle/view/index.jsp">
                    <img alt="Brand" height="30" src="/iCastle/img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/iCastle/view/index.jsp">首頁</a>
                    </li>
                    <li>
                        <a href="#">活動</a>
                    </li>
                    <li>
                        <a href="#">討論區</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#"><span class="glyphicon glyphicon-cog"></span>會員中心</a>
                    </li>
                    <li>
                        <a href="#"><span class="glyphicon glyphicon-user"></span> 登入</a>
                    </li>
                    <li>
                        <a href="#"><span class="glyphicon glyphicon-log-in"></span> 登出</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!--結束導覽列-->
    <!--上方搜尋列-->
    <div class="container-fluid search-row">
        <div class="row" style="background-color:#607D8B;width:100%">
            <div class="col-md-10 col-md-offset-1">
                <form action="#" method="get">
                    <div class="col-md-2 col-xs-12 col-sm-4" style="margin:15px;">
                        <input type="text" class="form-control" placeholder="輸入區域或飯店名稱" name="type" value="${param.type}"/>
                    </div>
                    <div class="clearfix visible-xs-block"></div>
                    <div class="col-md-2 col-xs-12 col-sm-4" style="margin:15px;">
                        <input type="text" id="startDate" class="form-control datepicker" placeholder="輸入入住日期" name="start" value="${param.start}"/>
                    </div>
                    <div class="clearfix visible-xs-block"></div>
                    <div class="col-md-2 col-xs-12 col-sm-4" style="margin:15px;">
                        <input type="text" id="endDate" class="form-control datepicker" placeholder="輸入退房日期" name="end" value="${param.end}"/>
                    </div>
                    <div class="clearfix visible-xs-block"></div>
                    <div class="col-md-2 col-xs-12 col-sm-4" style="margin:15px;">
                        <input type="text" class="form-control" placeholder="輸入入住人數" name="peopleNum" value="${param.peopleNum}"/>
                    </div>
                    <div class="clearfix visible-xs-block"></div>
                    <div class="col-md-2 col-xs-12 col-sm-4">
                        <input type="submit" class="btn btn-success" style="width:80%;margin-bottom:0px;margin-top:20px" value="搜尋" />
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--結束上方搜尋列-->

    <div class="container" style="background-color:white;padding-bottom:100px;">
        <div class="row">
            <div class="col-md-10" style="margin-bottom:1%">
                <h1>${hotel.hotelName}</h1>
                <div style="margin-bottom:5px">
                	<!-- 飯店星等 -->
						<c:forEach var="i" varStatus="varsts" begin="1" end="5" >
							<c:choose>
								<c:when test="${i<=hotel.star}">
									<img src="/iCastle/img/star.png" width="20px" />
								</c:when>
								<c:otherwise>
									<img src="/iCastle/img/unstar.png" width="20px" />
								</c:otherwise>
							</c:choose>
						</c:forEach>
					<!-- 飯店星等結束 -->
                </div>
                <small>${hotel.addr}</small>
            </div>
            <div class="col-md-2">
                <div class="gradeRound">
                    <p>${hotel.point}</p>
                </div>
                <p class="hot">熱門度:${hotel.hot}</p>
            </div>

            <!--飯店圖片-->
            <div class="col-md-12">
                <div class="gallery">
                    <div class="frist-img">
                        <img src="/iCastle/img/fakeImg/908412_17040615450052164275.jpg" width="700" height="389" />
                    </div>
                    <div class="second-img">
                        <img src="/iCastle/img/fakeImg/908412_17040615450052164261.jpg" width="550" height="189" />
                    </div>
                    <div class="thrid-img">
                        <img src="/iCastle/img/fakeImg/908412_17040615450052164309.jpg" width="268" height="189" />
                    </div>
                    <div class="fourth-img">
                        <img src="/iCastle/img/fakeImg/908412_17040615450052164302.jpg" width="268" height="189" />
                    </div>
                    <div style="clear:both"></div>
                </div>
            </div>
            <!--結束飯店圖片-->
            <!--聯絡與設施-->
            <div class="col-md-12 connect-checkin">
                <div class="col-md-4">
                    <p style="font-size:20px;">聯絡資訊&入/退房時間</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">call</i>
                    <p>02 2375 7777</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">mail</i>
                    <p>${hotel.email}</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">access_time</i>
                    <p>PM 3:00</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">access_time</i>
                    <p>PM 12:00</p>
                </div>
            </div>
            <div class="col-md-12 facility-service">
                <div class="col-md-4">
                    <p style="font-size:20px;">熱門設施&服務</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">casino</i>
                    <p>遊樂場</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">fitness_center</i>
                    <p>健身房</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">pool</i>
                    <p>游泳池</p>
                </div>
                <div class="col-md-2">
                    <i class="material-icons green200">spa</i>
                    <p>spa</p>
                </div>
                <!--<div class="col-md-2">
                    <i class="material-icons green200">wifi</i>
                    <p>無線網路</p>
                </div>-->
                <!--<div class="col-md-2">
                    <i class="material-icons green200">hot_tub</i>
                    <p>溫泉</p>
                </div>-->
            </div>
            <!--結束聯絡與設施-->



        </div>

        <div class="row" style="margin-bottom:50px;">

            <!--房型資訊-->
            <div class="col-md-12">
                <div class="page-header">
                    <h3>房型資訊:</h3>
                </div>
                <table class="table table-bordered table-condensed" style="">
                    <thead>
                        <tr>
                            <th class="text-center col-md-2">房型名稱與照片</th>
                            <th class="text-left col-md-3">附設服務</th>
                            <th class="text-center col-md-1">可否加床</th>
                            <th class="text-center col-md-3">每晚均價/每房</th>
                            <th class="text-center">預定房數</th>
                            <th class="text-center">我要預訂</th>
                        </tr>
                    </thead>
                    <!--迴圈從這裡開始-->
                    <tbody>
                    <!-- 一筆又一筆的房間 -->
					<c:forEach var="room" items="${rooms}">
					<form action="../rooms/Rooms.do" name="form">
<!-- 					<form action="Test2Servlet" name="form"> -->
                        <tr>
                            <!--房型照片-->
                            <td class="text-center" style="vertical-align:middle">
                                <strong style="font-size:18px">${room.roomTypeName}</strong>
                                <div style="margin:20px;">
                                    <img src="/iCastle/img/fakeImg/908412_17040613590052160185.jpg" width="180" height="90" />
                                </div>
                            </td>
                            <!--結束房型照片-->
                            <!--房間附設服務-->
                            <td style="vertical-align:middle">
                                <c:if test="${room.breakfast}">
                                <div class="check">
                                    <div>
                                        <i class="material-icons green200">check</i>
                                    </div>
                                    <div>
                                        <p>早餐</p>
                                    </div>
                                </div>
                                </c:if>
                                <c:if test="${room.afternoonTea}">
                                <div class="check">
                                    <div>
                                        <i class="material-icons green200">check</i>
                                    </div>
                                    <div>
                                        <p>下午茶</p>
                                    </div>
                                </div>
                                </c:if>
                                <c:if test="${room.dinner}">
                                <div class="check">
                                    <div>
                                        <i class="material-icons green200">check</i>
                                    </div>
                                    <div>
                                        <p>晚餐</p>
                                    </div>
                                </div>
                                </c:if>
<!--                                 <div class="check"> -->
<!--                                     <div> -->
<!--                                         <i class="material-icons green200">check</i> -->
<!--                                     </div> -->
<!--                                     <div> -->
<!--                                         <p>免費Wi-Fi</p> -->
<!--                                     </div> -->
<!--                                 </div> -->
                            </td>
                            <!--結束房間附設服務-->
                            <!--可否加床-->
                            <td class="text-center" style="vertical-align:middle">
                            
                            	<c:choose>
									<c:when test="${room.bedAddable}">
										<div class="check">
	                                    	<div>
	                                        <i class="material-icons green200">check</i>
	                                    	</div>
	                                   		<div>
	                                        	<p>可加床</p>
	                                        	<div class="bed">
	                                        		<select name="bedAdding">
														<option value="true">加床</option>
														<option value="false" selected>不加床</option>
													</select>
	                                        	</div>
	                                    	</div>
	                                	</div>
									</c:when>
									<c:otherwise>
										<div class="uncheck">
		                                    <div>
		                                        <i class="material-icons orange500 md-28">not_interested</i>
		                                    </div>
		                                    <div>
		                                        <p>不可加床</p>
		                                    </div>
		                                </div>
									</c:otherwise>
								</c:choose>  
                            </td>
                            <!--可否加床-->
                            <!--每晚均價-->
                            <td class="text-center" style="vertical-align:middle">
                                <div class="price">
                                    <span>NT </span>
                                    <span>${room.price}</span>
                                    <button type="button" rel="tooltip" title="${room.remark}" class="btn btn-primary btn-simple btn-xs">
                                        <i class="material-icons md-24">info</i>
                                    </button>
                                </div>
                            </td>
                            <!--結束每晚均價-->
                            <!--預定房數-->
                            <td class="text-center" style="vertical-align:middle">
                                <select name="roomCount">
								<c:forEach var="i" begin="1" end="${room.roomNumber-room.bookedNum}">
									<option value="${i}">${i}</option>
								</c:forEach>
								</select>
                            </td>
                            <!--結束預定房數-->
							<!-- 預訂按鈕以及傳送資訊 -->
                            <td class="text-center" style="vertical-align:middle">
                                    <input type="submit" class="btn btn-success" value="預定" /><br>
                                    <p style="color:red">剩下${room.roomNumber-room.bookedNum}間</p>
                                    <input type="hidden" name="roomId" value="${room.roomId}" />
                                    <input type="hidden" name="hotelId" value="${room.hotelId}" />
                                    <input type="hidden" name="hotelName" value="${hotel.hotelName}" />
                                    <input type="hidden" name="roomTypeId" value="${room.roomTypeId}" />
                                    <input type="hidden" name="roomTypeName" value="${room.roomTypeName}" />
                                    <input type="hidden" name="start" value="${param.start}" />
                                    <input type="hidden" name="end" value="${param.end}" />
                                    <input type="hidden" name="peopleNum" value="${param.peopleNum}" />
                                    <input type="hidden" name="breakfast" value="${room.breakfast}" />
                                    <input type="hidden" name="dinner" value="${room.dinner}" />
                                    <input type="hidden" name="afternoonTea" value="${room.afternoonTea}" />
                                    <input type="hidden" name="price" value="${room.price}" />
<%--                                     <input type="hidden" name="bedAddable" value="${room.bedAddable}" /> --%>
                                    <input type="hidden" name="pricePerPerson" value="${room.pricePerPerson}" />
                                    <input type="hidden" name="remark" value="${room.remark}" />
                                    <input type="hidden" name="action" value="getOrder" />
                            </td>
                            <!-- 結束預訂按鈕以及傳送資訊 -->
                        </tr>
                    </form>
                    </c:forEach>
					<!-- 一筆又一筆的房間結束 -->
                    </tbody>
                    <!--迴圈到這裡結束-->


                </table>
            </div>
            <!--結束房型資訊-->
        </div>

        <div class="row">

            <div class="col-md-12" style="border-bottom:1px solid #ECEFF1;padding-top:20px;padding-bottom:20px;">
                <div class="page-header">
                    <h3>關於德立莊酒店</h3>
                </div>
                <div class="col-md-2">
                    <h4>簡介</h4>
                </div>
                <div class="col-md-10">
                    <p>
                        如果您想尋找一家交通方便的台北市住宿，那沒有比德立莊酒店更合適的選擇了。 在這裡，旅客可輕鬆前往市區內各大旅遊、購物、餐飲地點。 住宿位置優越讓旅客前往市區內的熱門景點變得方便快捷。
                        德立莊酒店一直致力於為您提供最尊貴的服務與一流的設施，確保您下榻期間愉快、愜意。 入住期間，客人可享受所有房型皆附免費WiFi, 便利商店, 24小時前台服務, 可寄放行李, 公共區域WiFi。
                        您將能真切地感受到德立莊酒店的特有的氛圍，它體現在每一間精心規劃的客房中。完善的貼心設施與服務隨處可見，如：平面電視, 地毯, 免費即溶咖啡, 免費茶包, 寢具用品， 除此之外，住宿的各種娛樂設施一定會讓您在留宿期間享受更多樂趣。 德立莊酒店地理位置優越，設施先進，是最熱門的飯店之一。
                    </p>
                </div>
            </div>
            <div class="col-md-12" style="border-bottom:1px solid #ECEFF1;padding-top:20px;padding-bottom:20px;">
                <div class="col-md-2">
                    <h4>服務設施</h4>
                </div>
                <div class="col-md-10">
                    <p>網路服務</p>
                    <div class="facility-detail">
                        <div>
                            <i class="material-icons md-dark">language</i>
                        </div>
                        <div>
                            <small>有線網路</small>
                        </div>
                    </div>
                    <div class="facility-detail">
                        <div>
                            <i class="material-icons md-dark">wifi</i>
                        </div>
                        <div>
                            <small>公共區域免費Wi-Fi</small>
                        </div>
                    </div>
                    <div class="facility-detail">
                        <div>
                            <i class="material-icons md-dark">hotel</i>
                        </div>
                        <div>
                            <small>所有房型皆附免費Wi-Fi</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12" style="border-bottom:1px solid #ECEFF1;padding-top:20px;padding-bottom:20px;">
                <div class="col-md-2">
                    <h4>交通方式</h4>
                </div>
                <div class="col-md-10">
                    <p>1.酒店提供付費接機服務，預約諮詢 information@richardson.com.tw</p>
                    <p>
                        2.搭乘國光客運1819號直達台北車站，轉乘台北捷運藍線至西門站4號出口，
                        即可抵達酒店。
                    </p>
                    <p>
                        3.搭乘高鐵從桃園站到台北車站，轉乘台北捷運藍線至西門站4號出口，
                        即可抵達酒店。
                    </p>
                </div>
            </div>
        </div>
    </div>

    <!--footer-->
    <div class="footer">
        <img src="/iCastle/img/logo.png" width="100" />
        <h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        <h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
    </div>
    <!--結束footer-->

    <script src="/iCastle/js/jquery.min.js"></script>
    <script src="/iCastle/js/bootstrap.min.js"></script>
    <script src="/iCastle/js/material.min.js"></script>

    <script src="/iCastle/js/nouislider.min.js"></script>

    <script src="/iCastle/js/bootstrap-datepicker.js"></script>

    <script src="/iCastle/js/material-kit.js"></script>
</body>
</html>