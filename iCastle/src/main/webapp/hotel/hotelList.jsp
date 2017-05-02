<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="css/material-kit.css" rel="stylesheet" />
    <link href="css/template.css" rel="stylesheet" />
    <link href="css/QueryPage.css" rel="stylesheet" />

    <style>
        .noUi-connect {
            background:#03a9f4;
        }
        .affix {
            top: 56px;
        }
    </style>

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
                <a class="navbar-brand" href="index.jsp">
                    <img alt="Brand" height="30" src="img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.jsp">首頁</a></li>
                    <li><a href="#">活動</a></li>
                    <li><a href="#">討論區</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-cog"></span>會員中心</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> 登入</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登出</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--結束導覽列-->

    <div class="container" style="margin-top:56px">
        <div class="row">
            <div class="col-md-3">
                <div class="card" style="padding:0px;margin-top:5%;">
                    <div style="background-color:#EEEEEE;padding:3%;border-bottom:5px solid #80CBC4">
                        <h4>您的搜尋條件</h4>
                    </div>
                    <div style="background-color:white;padding:5%;" id="searchBox">
                        <form action="Query.do" method="get">
                        		<p>關鍵字</p>
                                <input type="text" class="form-control" placeholder="輸入飯店名稱或地區" name="type" value="${param.type}"/>
                                <p>入住日期</p>
                                <input type="text" id="startDate" class="form-control datepicker" placeholder="輸入入住日期" name="start"  value="${param.start}"/>
                                <p>退房日期</p>
                                <input type="text" id="endDate" class="form-control datepicker" placeholder="輸入退房日期" name="end" value="${param.end}"/>
                                <p>入住人數</p>
                                <input type="text" class="form-control" placeholder="輸入入住人數" name="peopleNum" value="${param.peopleNum}"/>
                                <input type="submit" class="btn btn-success" value="搜尋" style="width:100%;" />
                                <center><input type="submit" class="btn" value="一鍵輸入" id="onekey" style="width:60%;" /></center>
                        </form>
                    </div>
                </div>

                <div class="card" style="padding:0px;margin-top:5%;">
                    <div style="background-color:#EEEEEE;padding:6%;border-bottom:5px solid #80CBC4">
                        <div>
                            <span style="font-size:18px">進階搜尋</span>
                            <i class="material-icons SearchToggleUp" style="float:right" id="adHide">play_arrow</i>
                        </div>
                    </div>
                    <div class="SearchBlockContext" id="adSearchBlock">
                        <form action="#" method="get">
                            <div>
                                <p>每晚最低價格</p>
                                <div id="price-min-bar" class="slider slider-info noUi-connect"></div>
                                <div style="text-align:right;"><span id="price-min"></span></div>
                                <input type="hidden" id="price-input-min" name="maxPrice" />
                            </div>
                            <div>
                                <p>每晚最高價格</p>
                                <div id="price-max-bar" class="slider slider-info noUi-connect"></div>
                                <div style="text-align:right;"><span id="price-max"></span></div>
                                <input type="hidden" id="price-input-max" name="priceMin" />
                            </div>

                            <div>
                                <p>飯店星等</p>
                                <div id="hotelLevle">
                                    <div style="text-align:center;">
                                        <img id="hs1" width="30" src="img/unstar.png" />
                                        <img id="hs2" width="30" src="img/unstar.png" />
                                        <img id="hs3" width="30" src="img/unstar.png" />
                                        <img id="hs4" width="30" src="img/unstar.png" />
                                        <img id="hs5" width="30" src="img/unstar.png" />
                                        <br />
                                        <span>請選擇星等</span>
                                        <input type="hidden" />
                                    </div>
                                </div>
                            </div>

                            <div>
                                <p>飯店評分</p>
                                <div id="hotelPoint">
                                    <div style="text-align:center;">
                                        <img id="hp1" width="30" src="img/unstar.png" />
                                        <img id="hp2" width="30" src="img/unstar.png" />
                                        <img id="hp3" width="30" src="img/unstar.png" />
                                        <img id="hp4" width="30" src="img/unstar.png" />
                                        <img id="hp5" width="30" src="img/unstar.png" />
                                        <br />
                                        <span>請選擇分數</span>
                                        <input type="hidden" />
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="sort">
                    <ul>
                        排序方式:
                        <li><a href="#">熱門度</a></li>
                        <li><a href="#">最低價格</a></li>
                        <li><a href="#">星級排行</a></li>
                    </ul>
                </div>
                <!--飯店列表-->
                <c:forEach var="hotel" items="${hotels}">
                <a href="hotel/ShowHotel.do?hotelId=${hotel.hotelId}&type=${param.type}&start=${param.start}&end=${param.end}&peopleNum=${param.peopleNum}">
                    <div class="card">
                        <img src="${pageContext.servletContext.contextPath}/ShowPhoto.do?id=${hotel.hotelId}&type=hotelid" style="width:300px;" />
                        <div class="cardContext">
                            <h4>${hotel.hotelName}</h4>
                            <h4><span class="label label-info">${hotel.zone}</span></h4>
							
							<!-- 飯店星等 -->
							<c:forEach var="i" varStatus="varsts" begin="1" end="5" >
								<c:choose>
									<c:when test="${i<=hotel.star}">
										<img src="img/star.png" width="20px" />
									</c:when>
									<c:otherwise>
										<img src="img/unstar.png" width="20px" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<!-- 飯店星等結束 -->
                            <br />
                            <c:if test="${hotel.breakfast == true}"> 
	                            <div class="freeOffer">
	                                <div>
	                                    <span class="material-icons md-light md-18">free_breakfast</span>
	                                </div>
	                                <div>
	                                    <small>免費早餐</small>
	                                </div>
	                            </div>
                            </c:if>
                            <c:if test="${hotel.dinner == true}">
	                            <div class="freeOffer">
	                                <div>
	                                    <span class="material-icons md-light md-18">room_service</span>
	                                </div>
	                                <div>
	                                    <small>免費晚餐</small>
	                                </div>
	                            </div>
                            </c:if>
                            <c:if test="${hotel.roomWifi == true}">
	                            <div class="freeOffer">
	                                <div>
	                                    <span class="material-icons md-light md-18">network_wifi</span>
	                                </div>
	                                <div>
	                                    <small>室內wifi</small>
	                                </div>
	                            </div>
                            </c:if>
                        </div>
                        <div class="cardContext" style="left:85%">
                            <div class="gradeRound">
                                <p>${hotel.point}</p>
                            </div>
                            <p class="hot">熱門度:${hotel.hot}</p>
                            <div class="price">
                                <p>最低價格</p>
                                <span style="margin-left:30px;font-size:15px;color:#757575">NT </span>
                                <span style="font-size:15px;color:red">${hotel.price}</span>
                            </div>
                        </div>
                    </div>
                </a>
                </c:forEach>
                <c:if test="${empty hotels}">
					<h2>查無飯店!</h2>
				</c:if>
                <!--結束飯店列表-->
            </div>
            <!--分頁-->
            <div style="float:right">
                <ul class="pagination pagination-warning">
                    <li><a href="#"><</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">></a></li>
                </ul>
            </div>
            <!--結束分頁-->

        </div>
    </div>

    <!--footer-->
    <div class="footer">
        <img src="img/logo.png" width="100" />
        <h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        <h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
    </div>
    <!--結束footer-->

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/material.min.js"></script>

    <!--<script src="../js/nouislider.min.js"></script>-->
    <script src="js/nouislider.min.9.js"></script>
    <script src="js/wNumb.js"></script>

    <script src="js/bootstrap-datepicker.js"></script>

    <script src="js/material-kit.js"></script>

    <script>

        $(function () {
            //飯店星等
            var hotelLevleStatus = $('#hotelLevle span');
            var hotelLevle = 0;

            function clearAll(from) {
                for (var i = 1; i <= 5; i++) {
                    if (from) {
                        $('#hs' + i).attr("src", "img/unstar.png");
                    } else {
                        $('#hp' + i).attr("src", "img/unstar.png");
                    }
                }
            }

            $('#hotelLevle img').hover(function () {
                if (hotelLevle > 0) {
                    clearAll(true);
                }
                var level = $(this).attr("id").charAt(2);
                for (var i = 1; i <= level; i++){
                    $('#hs' + i).attr("src", "img/star.png");
                    hotelLevleStatus.text(level + '星級');
                }
            },
                function () {
                    if (hotelLevle == 0) {
                        clearAll(true);
                        hotelLevleStatus.text('請選擇星等');
                    } else {
                        clearAll(true);
                        for (var i = 1; i <= hotelLevle; i++) {
                            $('#hs' + i).attr("src", "img/star.png");
                            hotelLevleStatus.text(hotelLevle + '星級');
                        }
                    }
                }).click(function () {
                    hotelLevle = $(this).attr("id").charAt(2);
                    $('#hotelLevle input').val(hotelLevle);
                    for (var i = 1; i <= hotelLevle; i++) {
                        $('#hs' + i).attr("src", "img/star.png");
                        hotelLevleStatus.text(hotelLevle + '星級');
                    }
                });
            //結束飯店星等

            //飯店評分
            var hotelPointStatus = $('#hotelPoint span');
            var hotelPoint = 0;

            $('#hotelPoint img').hover(function () {
                if (hotelPoint > 0) {
                    clearAll(false);
                }
                var level = $(this).attr("id").charAt(2);
                for (var i = 1; i <= level; i++) {
                    $('#hp' + i).attr("src", "img/star.png");
                    hotelPointStatus.text(level + '顆星');
                }
            },
                function () {
                    if (hotelPoint == 0) {
                        clearAll(false);
                        hotelPointStatus.text('請選擇分數');
                    } else {
                        clearAll(false);
                        for (var i = 1; i <= hotelPoint; i++) {
                            $('#hp' + i).attr("src", "img/star.png");
                            hotelPointStatus.text(hotelPoint + '顆星');
                        }
                    }
                }).click(function () {
                    hotelPoint = $(this).attr("id").charAt(2);
                    $('#hotelPoint input').val(hotelPoint);
                    for (var i = 1; i <= hotelPoint; i++) {
                        $('#hp' + i).attr("src", "img/star.png");
                        hotelPointStatus.text(hotelPoint + '顆星');
                    }
                });
            //結束飯店評分

            //進階搜尋伸縮
            $('#adHide').click(function () {
                $(this).css("transform", "rotate(90deg)")
                $('#adSearchBlock').toggle(1000);
            })
            //結束進階搜尋伸縮

            //價錢塞選
            var priceMinBar = document.getElementById('price-min-bar');
            var priceMaxBar = document.getElementById('price-max-bar');

            noUiSlider.create(priceMinBar, {
                start: 2500,
                step: 500,
                connect: true,
                range: {
                    min: 2000,
                    max: 6000
                },
                format: wNumb({
                    decimals: 0,
                    thousand: ',',
                    postfix: '元',
                })
            });

            noUiSlider.create(priceMaxBar, {
                start: 6000,
                step: 500,
                connect: true,
                range: {
                    min: 3000,
                    max: 8000
                },
                format: wNumb({
                    decimals: 0,
                    thousand: ',',
                    postfix: '元',
                })
            });

            var minValue = document.getElementById("price-min");
            var maxValue = document.getElementById("price-max");
            var inputMin = document.getElementById("price-input-min");
            var inputMax = document.getElementById("price-input-max");

            priceMinBar.noUiSlider.on('update', function (values, handle) {
                var minPriceStr = priceMinBar.noUiSlider.get().substr(0, 5).split(',');
                var maxPriceStr = priceMaxBar.noUiSlider.get().substr(0, 5).split(',');
                var minPrice = minPriceStr[0] + minPriceStr[1];
                var maxPrice = maxPriceStr[0] + maxPriceStr[1];

                if (minPrice >= maxPrice) {
                    priceMaxBar.noUiSlider.set(parseInt(minPrice) + 2000);
                }
                var price = values[handle];
                minValue.innerHTML = price;
                inputMin.setAttribute("value", price);
            });

            priceMaxBar.noUiSlider.on('update', function (values, handle) {
                var minPriceStr = priceMinBar.noUiSlider.get().substr(0, 5).split(',');
                var maxPriceStr = priceMaxBar.noUiSlider.get().substr(0, 5).split(',');
                var minPrice = minPriceStr[0] + minPriceStr[1];
                var maxPrice = maxPriceStr[0] + maxPriceStr[1];

                if (minPrice >= maxPrice) {
                    priceMinBar.noUiSlider.set(parseInt(maxPrice) - 2000);
                }
                var price = values[handle];
                maxValue.innerHTML = price;
                inputMax.setAttribute("value", price);
            });
            //結束價錢塞選
            
            //一鍵輸入
            $('#onekey').click(function() {
    			event.preventDefault();
    			$('input[name = "type"]').val('台北');
    			$('input[name = "start"]').val('2017/06/02');
    			$('input[name = "end"]').val('2017/06/04');
    			$('input[name = "peopleNum"]').val(4);
    		});
            //一鍵輸入結束
        });

       

    </script>

</body>
</html>