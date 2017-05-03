<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="Content-Type" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!--<link href="../css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="../css/material-kit.css" rel="stylesheet" />
    <link href="../css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->

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
                <a class="navbar-brand" href="../index.jsp">
                    <img alt="Brand" height="30" src="../img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="../index.jsp">首頁</a></li>
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
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->
    <div class="container" style="margin-top:56px">
    <form action="../orders/OrdersServlet.do" method="post">
		<table>
			<tr><td><span>飯店名稱:</span></td><td><span>${orderMap.hotelName }</span><br></td></tr>
			<tr><td><span>房型名稱:</span></td><td><span>${orderMap.roomTypeName }</span><br></td></tr>
			<tr><td><span>入住日:</span></td><td><span>${orderMap.checkinDay }</span><br></td></tr>
			<tr><td><span>退房日:</span></td><td><span>${orderMap.checkoutDay }</span><br></td></tr>
			<tr><td><span>預定間數:</span></td><td><span>${orderMap.roomCount}</span><br></td></tr>
			<tr><td><span>入住人數:</span></td><td><span>${orderMap.peopleNum }</span><br></td></tr>
			
			<tr><td><span>含餐:</span></td>
			<td>
				<c:if test="${orderMap.breakfast}">
					<span name="breakfast" value="true">含早餐   </span>
				</c:if>
				<c:if test="${orderMap.dinner}">
					<span name="dinner" value="true">含晚餐   </span><br>
				</c:if>
				<c:if test="${orderMap.afternoonTea}">
					<span name="afternoonTea" value="true">含下午茶</span>
				</c:if>
			</td></tr>
			<c:forEach var="PerPrice" items="${PerPrice}">
				<tr><td>${PerPrice.key}:</td><td>${PerPrice.value} /房/晚</td></tr>
				<tr><td><span>加床價格:</span></td><td><span>${orderMap.pricePerPerson } /位/晚</span></td></tr>
			</c:forEach>
			<c:choose>
				<c:when test="${orderMap.bedAdding}">
					<tr><td><span>總房價:</span></td><td><span>${(totalPrice+orderMap.pricePerPerson*stayDayNum)*orderMap.roomCount}</span><br></td></tr>
							<input type="hidden" name="price" value="${(totalPrice+orderMap.pricePerPerson*stayDayNum)*orderMap.roomCount}"/>
				</c:when>
				<c:otherwise>
					<tr><td><span>總房價:</span></td><td><span>${totalPrice*orderMap.roomCount}</span><br></td></tr>
							<input type="hidden" name="price" value="${totalPrice*orderMap.roomCount}"/>
				</c:otherwise>
			</c:choose>
			<tr><td><span>入住人姓名:</span></td><td><input type="text" name="reservationer" value="${param.reservationer}">${errorMsgs.reservationer}<br></td></tr>
			<tr><td><span>生日:</span></td><td><input type="text" name="bdate" value="${param.bdate}">${errorMsgs.bdate}<br></td></tr>
			<tr><td><span>電話:</span></td><td><input type="text" name="tel" value="${param.tel}">${errorMsgs.tel}<br></td></tr>
			<tr><td><span>信箱:</span></td><td><input type="text" name="email" value="${param.email}"><br></td></tr>
			<tr><td><span>地址:</span></td><td><input type="text" name="addr" value="${param.addr}"><br></td></tr>
			<tr><td><span>身分證字號:</span></td><td><input type="text" name="personId" value="${param.personId}">${errorMsgs.country}${errorMsgs.personId}<br></td></tr>
			<tr><td><span>國籍:</span></td><td><input type="text" name="country" value="${param.country}">${errorMsgs.country}<br></td></tr>
			<tr><td><span>護照號碼:</span></td><td><input type="text" name="passport" value="${param.passport}">${errorMsgs.country}<br></td></tr>
			<tr><td><span>顧客備註:</span></td><td><textarea rows="4" cols="50" name="customerRemark" value="${param.customerRemark}"></textarea><br></td></tr>
			<tr><td><span>飯店備註:</span></td><td><span>${orderMap.remark }</span><br></td></tr>
			<tr><td><input type="button" onclick="history.back()" value="上一頁"></td><td><input type="submit" value="下一步"></td></tr>
		</table>
<!-- 		memberId先寫死，之後再改 -->
		<input type="hidden" name="memberId" value="1"/>
		<input type="hidden" name="action" value="keyin"/>

	</form>
	</div>
    <!--footer-->
    <div class="footer">
        <img src="../img/logo.png" width="100" />
        <h6>版權所有©2005 – 2017, iCastle Company Pte. Ltd.保留所有權利</h6>
        <h6>iCastle.com隸屬於Priceline集團—線上旅遊業及相關服務的全球領導品牌。</h6>
    </div>
    <!--結束footer-->
</body>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/material.min.js"></script>

<script src="../js/nouislider.min.js"></script>

<script src="../js/bootstrap-datepicker.js"></script>

<script src="../js/material-kit.js"></script>

</html>