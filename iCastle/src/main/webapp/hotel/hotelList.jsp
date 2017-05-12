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
		<jsp:include page="../fragment/nav.jsp"/>
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
                                <div id="priceSlider" class="sliders slider-info noUi-connect"></div>
                                <div class="row">
	                                <div class="col-md-4">
	                                	<span id="lowprice">0</span>
	                                </div>
	                                <div class="col-md-4 col-md-offset-4">
	                                	<span id="highprice">20000</span>
	                                </div>
                                </div>
                                <input type="hidden" id="price-input-min" name="maxPrice" />
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
<!--                 <div class="sort"> -->
<!--                     <ul> -->
<!--                         排序方式: -->
<!--                         <li><a href="#">熱門度</a></li> -->
<!--                         <li><a href="#">最低價格</a></li> -->
<!--                         <li><a href="#">星級排行</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
                
                
                <!--飯店列表-->
                <c:forEach var="hotel" items="${hotels}">
                <a class="ahotel" href="hotel/ShowHotel.do?hotelId=${hotel.hotelId}&type=${param.type}&start=${param.start}&end=${param.end}&peopleNum=${param.peopleNum}">
                    <div class="card hotelcard">
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
							<div class="hotelstar" style="display:none">${hotel.star}</div>
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
                                <p class="point">${hotel.point}</p>
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

    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
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
                        console.log("hotelLevle="+ hotelLevle);
                        change();
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
                //飯店評分被更改了
                    hotelPoint = $(this).attr("id").charAt(2);
                    $('#hotelPoint input').val(hotelPoint);
                    for (var i = 1; i <= hotelPoint; i++) {
                        $('#hp' + i).attr("src", "img/star.png");
                        hotelPointStatus.text(hotelPoint + '顆星');
                    }
                        console.log("hotelPoint="+ hotelPoint);
                        change();
                });
            //結束飯店評分

            
            //進階搜尋伸縮
            $('#adHide').click(function () {
                $(this).css("transform", "rotate(90deg)")
                $('#adSearchBlock').toggle(1000);
            })
            //結束進階搜尋伸縮
            
            
			/*價錢篩選開始*/
            //價錢篩選
            var lowprice = 0;
            var highprice = 20000;
            var priceSlider = document.getElementById('priceSlider');

            //初始化價錢bar
            noUiSlider.create(priceSlider, {
            	start: [ 0, 20000 ],
            	range: {
            		'min': [  0 ],
            		'max': [ 20000 ]
            	},
                step: 5,
                connect: true,

                format: wNumb({
                    decimals: 0,
//                     thousand: ',',
//                     postfix: '元',
                })
            });
            
            //調整價錢時
            priceSlider.noUiSlider.on('update', function(){
            	console.log("更新");
            	var price = priceSlider.noUiSlider.get();
            	//將價錢秀出來
            	$('#lowprice').text(price[0]+"元");
            	$('#highprice').text(price[1]+"元");
            });
            
            
            //調整價錢後
            priceSlider.noUiSlider.on('end', function(){
            	console.log("更新");
            	var price = priceSlider.noUiSlider.get();
            	lowprice = price[0];
            	highprice = price[1];

            	change();  
            });
            /*結束價錢篩選*/
            
            
            //進行篩選
            function change(){
            	//先將飯店全部顯示出來
            	$(".ahotel").css("display", "initial");
            	//將價錢超出範圍的隱藏起來
            	$('.price>span:nth-child(3)').filter(function(index){
					return ( parseInt($(this).text()) < lowprice 
					          || parseInt($(this).text()) > highprice );            		
            	}).parents(".ahotel").css("display", "none");
            	//將評分超出範圍的隱藏起來
            	$('.point').filter(function(index){
            		console.log( parseInt($(this).text()) );
					return parseInt($(this).text()) < hotelPoint           		
          		}).parents(".ahotel").css("display", "none");
            	//將飯店星級超出範圍的隱藏起來
            	$('.hotelstar').filter(function(index){
            		console.log("星級:" + parseInt($(this).text()) );
					return parseInt($(this).text()) < hotelLevle           		
          		}).parents(".ahotel").css("display", "none");
            }

            
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