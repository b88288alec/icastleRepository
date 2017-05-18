<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
    <title>愛客宿-iCastle</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.amber-orange.min.css" />
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/paper-bootstrap-wizard.css" rel="stylesheet" />
    <!-- Fonts and Icons -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.servletContext.contextPath}/css/themify-icons.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    <link href="${pageContext.servletContext.contextPath}/css/font-awesome.css" rel="stylesheet" />


    <style>
        body {
            font-family: 'Microsoft JhengHei';
        }

        .hotleinfo p {
            margin-top: 10px;
            color: gray;
        }

        .hotleinfo span {
            margin-left: 8%;
        }

        .freeOffer {
            display: flex;
            width: 130px;
            padding-left: 13px;
            margin-top: 5px;
        }

            .freeOffer div:first-child {
                width: 20px;
                padding-top: 2px;
                padding-bottom: 2px;
            }

            .freeOffer div:nth-child(2) {
                margin-left: 10px;
            }

        .personalinfo div {
            margin-left: 8%;
        }

        .personalinfo label {
            margin-bottom: 0px;
        }

        .personalinfo p {
            margin-top: 10px;
            color: gray;
        }

        .credit p {
            margin-top: 10px;
            color: gray;
        }

        .credit label {
            margin-bottom: 0px;
        }

        .credit span {
            margin-left: 8%;
            color:#FF5722;
        }

        .credit .input div {
            margin-left: 8%;
        }

        .material-icons.orange600 { color: #FB8C00; }
        
        .errormsg{
        	color:red;
        }
    </style>
</head>
<body>
    <div class="image-container set-full-height" style="background-image: url('${pageContext.servletContext.contextPath}/img/fullimg.jpg');">
        <!--   Creative Tim Branding   -->
        <a href="${pageContext.servletContext.contextPath}/index.jsp">
            <div class="logo-container" style="padding:30px;">
                <div class="logo">
                    <img src="${pageContext.servletContext.contextPath}/img/logoround.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive" width="120" height="120"/>
                </div>
            </div>
        </a>

        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card wizard-card" data-color="orange" id="wizard">
                        <form action="${pageContext.servletContext.contextPath}/members/orders/OrdersServlet.do" method="post">
                            <div class="wizard-header">
                                <h3 class="wizard-title">填寫訂單資料</h3>
                                <p class="category">為了自身權益，請確實填寫</p>
                            </div>
                            <div class="wizard-navigation">
                                <div class="progress-with-circle">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="4" style="width: 15%;"></div>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#hotleinfo" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-info"></i>
                                            </div>
                                            飯店資訊
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#personalinfo" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-marker-alt"></i>
                                            </div>
                                            填寫資料
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#credit" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-credit-card"></i>
                                            </div>
                                            付款方式
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#check" data-toggle="tab">
                                            <div class="icon-circle">
                                                <i class="ti-check"></i>
                                            </div>
                                            確認訂單
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane" id="hotleinfo">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text">STEP 1. 請先確認飯店資訊</h5>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 hotleinfo">
                                            <p>飯店名稱:</p>
                                            <span>${orderMap.hotelName}</span>
                                            <p>房型名稱:</p>
                                            <span>${orderMap.roomTypeName}</span>
                                            <p>預定間數:</p>
                                            <span>${orderMap.roomCount}</span>
                                            <p>入住人數:</p>
                                            <span>${orderMap.peopleNum}</span>
                                            <p>三餐供應:</p>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.breakfast == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">free_breakfast</span>
                                                    </div>
                                                    <div>
                                                        <small>免費早餐</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.afternoonTea == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">free_breakfast</span>
                                                    </div>
                                                    <div>
                                                        <small>免費下午茶</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.dinner == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">room_service</span>
                                                    </div>
                                                    <div>
                                                        <small>免費晚餐</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <p>飯店備註:</p>
                                            <span>${orderMap.guestPolicies}</span>
                                            <p>取消規定:</p>
                                            <span>${orderMap.cancelPolicies}</span>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 hotleinfo">
                                            <p>入住日期:</p>
                                            <span>${orderMap.checkinDay}</span>
                                            <p>退房日期:</p>
                                            <span>${orderMap.checkoutDay}</span>
                                            <p>是否加床:</p>
                                            <span>
                                            <c:choose>
                                            	<c:when test="${orderMap.bedAdding == true}">
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-1">
                                                    <input type="radio" id="bedAdding-1" class="mdl-radio__button" name="options" value="1" checked disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">加床</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-2">
                                                    <input type="radio" id="bedAdding-2" class="mdl-radio__button" name="options" value="1" disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">不加床</span>
                                                </label>
                                                </c:when>
                                                <c:otherwise>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-1">
                                                    <input type="radio" id="bedAdding-1" class="mdl-radio__button" name="options" value="1" disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">加床</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-2">
                                                    <input type="radio" id="bedAdding-2" class="mdl-radio__button" name="options" value="1" checked disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">不加床</span>
                                                </label>
                                                </c:otherwise>
                                            </c:choose>
                                            </span>
                                            <p>加床價格:</p>
                                            <span>${orderMap.pricePerPerson} /位/晚</span>
                                            <p>每晚價格:</p>
                                            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left:8%;">
                                                <thead>
                                                    <tr>
                                                        <th class="mdl-data-table__cell--non-numeric">日期</th>
                                                        <th>價格</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="perPrice" items="${PerPrice}">
                                                    <tr>
                                                        <td class="mdl-data-table__cell--non-numeric">${perPrice.key}</td>
                                                        <td>${perPrice.value}</td>
                                                    </tr>
                                                </c:forEach>
                                                    <tr style="background-color:#FDD835">
                                                        <td class="mdl-data-table__cell--non-numeric">
                                                            總房價
                                                        </td>
                                                        <td>
                                                        	<c:choose>
                                                        		<c:when test="${orderMap.bedAdding == true}">
                                                        			${(totalPrice+(orderMap.pricePerPerson*stayDayNum))*orderMap.roomCount} 元
                                                        		</c:when>
                                                        		<c:otherwise>
                                                        			${totalPrice*orderMap.roomCount} 元
                                                        		</c:otherwise>
                                                        	</c:choose>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                                <div class="tab-pane" id="personalinfo">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text">STEP 2. 填寫個人資料</h5>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 personalinfo">
                                            <div class="mdl-textfield mdl-js-textfield">
                                            	<input type="button" class="btn" id="onekey" value="帶入會員資料" />
                                            </div>
                                            <p>入住人姓名:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="reservationer" name="reservationer" value="${param.reservationer}">
                                                <label class="mdl-textfield__label" for="reservationer">請輸入入住人姓名</label>
                                                <span class="errormsg">${errorMsgs.reservationer}</span>
                                            </div>
                                            <p>生日:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="bdate" name="bdate" value="${param.bdate}">
                                                <label class="mdl-textfield__label" for="bdate">請輸入生日</label>
                                            	<span class="errormsg">${errorMsgs.bdate}</span>
                                            </div>
                                            <p>電話:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="tel" name="tel" value="${param.tel}">
                                                <label class="mdl-textfield__label" for="tel">請輸入電話號碼</label>
                                                <span class="errormsg">${errorMsgs.tel}</span>
                                            </div>
                                            <p>email:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="email" name="email" value="${param.email}">
                                                <label class="mdl-textfield__label" for="email">請輸入email</label>
                                            </div>
                                            <p>地址:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="addr" name="addr" value="${param.addr}">
                                                <label class="mdl-textfield__label" for="addr">請輸入地址</label>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 personalinfo">
                                            <p>身分證字號:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="personId" name="personId" value="${param.personId}">
                                                <label class="mdl-textfield__label" for="personId">請輸入身分證字號</label>
                                                <span class="errormsg">${errorMsgs.personId}</span>
                                            </div>
                                            <p>國籍:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="country" name="country" value="${param.country}">
                                                <label class="mdl-textfield__label" for="country">請輸入國籍</label>
                                                <span class="errormsg">${errorMsgs.country}</span>
                                            </div>
                                            <p>護照號碼:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="passport" name="passport" value="${param.passport}">
                                                <label class="mdl-textfield__label" for="passport">請輸入護照號碼</label>
                                                <span class="errormsg">${errorMsgs.country}</span>
                                            </div>
                                            <p>顧客備註:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <textarea class="mdl-textfield__input" type="text" rows="6" id="customerRemark" name="customerRemark" value="${param.customerRemark}"></textarea>
                                                <label class="mdl-textfield__label" for="customerRemark">請輸入備註</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="tab-pane" id="credit">
                                    <div class="row credit">
                                        <div class="col-sm-12">
                                            <h5 class="info-text">STEP 3. 填寫付款資訊</h5>
                                        </div>
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <p>請選擇信用卡別:</p>
                                            <div class="col-sm-4">
                                                <div class="choice active" data-toggle="wizard-radio">
                                                    <input type="radio" name="card" value="visa" checked>
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="fa fa-cc-visa" aria-hidden="true"></i>
                                                        <p>visa</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-radio">
                                                    <input type="radio" name="card" value="mastercard">
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="fa fa-cc-mastercard" aria-hidden="true"></i>
                                                        <p>mastercard</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-4">
                                                <div class="choice" data-toggle="wizard-radio">
                                                    <input type="radio" name="card" value="jcb">
                                                    <div class="card card-checkboxes card-hover-effect">
                                                        <i class="fa fa-cc-jcb" aria-hidden="true"></i>
                                                        <p>mastercard</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 input">
                                            <p>信用卡號:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="cardnum1" name="cardnum1">
                                                <label class="mdl-textfield__label" for="cardnum1">請輸入信用卡號</label>
                                            </div>
                                            <p>背面末三碼:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="threenum" name="threenum">
                                                <label class="mdl-textfield__label" for="threenum">請輸入背面末三碼</label>
                                            </div>
                                            <p>卡片效期:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="month" name="month">
                                                <label class="mdl-textfield__label" for="month">請輸入卡片效期</label>
                                            </div>
                                        </div>
                                        <div class="col-sm-5 input">
                                            <p>持卡人姓名:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="name" name="name">
                                                <label class="mdl-textfield__label" for="name">請輸入持卡人姓名</label>
                                            </div>
                                            <p>持卡人身分證字號:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="ID" name="ID">
                                                <label class="mdl-textfield__label" for="ID">請輸入身分證字號</label>
                                            </div>
                                            <p>持卡人電話:</p>
                                            <div class="mdl-textfield mdl-js-textfield">
                                                <input class="mdl-textfield__input" type="text" id="phone" name="phone">
                                                <label class="mdl-textfield__label" for="phone">請輸入持卡人電話</label>
                                            </div>
                                            <p>付款金額:</p>
                                            <span>${totalPrice} 元</span><br>
                                            <input type="button" class="btn" id="creditcard" value="一鍵輸入" />
                                        </div>
                                    </div>
                                </div>

                                <div class="tab-pane" id="check">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <h5 class="info-text">STEP 4. 請確認訂單資料</h5>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 hotleinfo">
                                            <p>飯店名稱:</p>
                                            <span>${orderMap.hotelName}</span>
                                            <p>房型名稱:</p>
                                            <span>${orderMap.roomTypeName}</span>
                                            <p>預定間數:</p>
                                            <span>${orderMap.roomCount} 間</span>
                                            <p>入住人數:</p>
                                            <span>${orderMap.peopleNum} 人</span>
                                            <p>三餐供應:</p>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.breakfast == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">free_breakfast</span>
                                                    </div>
                                                    <div>
                                                        <small>免費早餐</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.afternoonTea == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">free_breakfast</span>
                                                    </div>
                                                    <div>
                                                        <small>免費下午茶</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <div style="display:inline-block">
                                                <div class="freeOffer">
                                                <c:if test="${orderMap.dinner == true}">
                                                    <div>
                                                        <span class="material-icons md-light orange600">room_service</span>
                                                    </div>
                                                    <div>
                                                        <small>免費晚餐</small>
                                                    </div>
                                                </c:if>
                                                </div>
                                            </div>
                                            <p>入住日期:</p>
                                            <span>${orderMap.checkinDay}</span>
                                            <p>退房日期:</p>
                                            <span>${orderMap.checkoutDay}</span>
                                            <p>是否加床:</p>
                                            <span>
                                            <c:choose>
                                            	<c:when test="${orderMap.bedAdding == true}">
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-1">
                                                    <input type="radio" id="bedAdding-1" class="mdl-radio__button" name="options" value="1" checked disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">加床</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-2">
                                                    <input type="radio" id="bedAdding-2" class="mdl-radio__button" name="options" value="1" disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">不加床</span>
                                                </label>
                                                </c:when>
                                                <c:otherwise>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-1">
                                                    <input type="radio" id="bedAdding-1" class="mdl-radio__button" name="options" value="1" disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">加床</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="bedAdding-2">
                                                    <input type="radio" id="bedAdding-2" class="mdl-radio__button" name="options" value="1" checked disabled>
                                                    <span class="mdl-radio__label" style="margin-left:0px;">不加床</span>
                                                </label>
                                                </c:otherwise>
                                            </c:choose>
                                            </span>
                                            <p>加床價格:</p>
                                            <span>${orderMap.pricePerPerson} /位/晚</span>
                                            <p>每晚價格:</p>
                                            <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp" style="margin-left:8%;">
                                                <thead>
                                                    <tr>
                                                        <th class="mdl-data-table__cell--non-numeric">日期</th>
                                                        <th>價格</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="perPrice" items="${PerPrice}">
                                                    <tr>
                                                        <td class="mdl-data-table__cell--non-numeric">${perPrice.key}</td>
                                                        <td>${perPrice.value}</td>
                                                    </tr>
                                                </c:forEach>
                                                    <tr style="background-color:#FDD835">
                                                        <td class="mdl-data-table__cell--non-numeric">
                                                            總房價
                                                        </td>
                                                        <td>
                                                            ${totalPrice} 元
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="col-sm-5 col-sm-offset-1 hotleinfo">
                                            <p>入住人姓名:</p>
                                            <span name="reservationer">--</span>
                                            <p>生日:</p>
                                            <span name="bdate">--</span>
                                            <p>電話:</p>
                                            <span name="tel">--</span>
                                            <p>信箱:</p>
                                            <span name="email">--</span>
                                            <p>地址:</p>
                                            <span name="addr">--</span>
                                            <p>身分證字號:</p>
                                            <span name="personId">--</span>
                                            <p>國籍:</p>
                                            <span name="country">--</span>
                                            <p>護照號碼:</p>
                                            <span name="passport">--</span>
                                            <p>顧客備註:</p>
                                            <span name="customerRemark">--</span>
                                            <p>付款方式:</p>
                                            <span>信用卡</span>
                                            <p>飯店備註:</p>
                                            <span>${orderMap.guestPolicies}</span>
                                            <p>取消規定:</p>
                                            <span>${orderMap.cancelPolicies}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="wizard-footer">
                                    <div class="pull-right">
                                        <input type='button' class='btn btn-next btn-fill btn-warning btn-wd' name='next' value='下一步' />
                                        <input type='submit' class='btn btn-finish btn-fill btn-success btn-wd' name='finish' value='完成' />
                                    </div>
                                    <div class="pull-left">
                                        <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='上一步' />
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <input type="hidden" name="action" value="keyin"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.bootstrap.wizard.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/paper-bootstrap-wizard.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.validate.min.js"></script>
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<script>
		$(function() {
			
// 			註冊事件帶入備註
			$('#customerRemark').on('blur',function(){
				var remark = $('#customerRemark').val();
    			$('span[name = "customerRemark"]').empty().append(remark);
				
			})
			
// 			代入會員資料
			$('#onekey').click(function() {
				event.preventDefault();
    			$('input[name = "reservationer"]').val('${MemberLoginOK.name}');
    			$('input[name = "bdate"]').val('${MemberLoginOK.bdate}');
    			$('input[name = "tel"]').val('${MemberLoginOK.tel}');
    			$('input[name = "email"]').val('${MemberLoginOK.email}');
    			$('input[name = "addr"]').val('${MemberLoginOK.addr}');
    			$('input[name = "personId"]').val('${MemberLoginOK.personId}');
    			$('input[name = "country"]').val('${MemberLoginOK.country}');
    			$('input[name = "passport"]').val('${MemberLoginOK.passport}');
    			
    			$('label[for = "reservationer"]').empty();
    			$('label[for = "bdate"]').empty();
    			$('label[for = "tel"]').empty();
    			$('label[for = "email"]').empty();
    			$('label[for = "addr"]').empty();
    			$('label[for = "personId"]').empty();

    			$('span[name = "reservationer"]').empty().append('${MemberLoginOK.name}');
    			$('span[name = "bdate"]').empty().append('${MemberLoginOK.bdate}');
    			$('span[name = "tel"]').empty().append('${MemberLoginOK.tel}');
    			$('span[name = "email"]').empty().append('${MemberLoginOK.email}');
    			$('span[name = "addr"]').empty().append('${MemberLoginOK.addr}');
    			$('span[name = "personId"]').empty().append('${MemberLoginOK.personId}');
    			$('span[name = "country"]').empty().append('${MemberLoginOK.country}');
    			$('span[name = "passport"]').empty().append('${MemberLoginOK.passport}');
			});
			
// 			一鍵輸入信用卡
			$('#creditcard').click(function() {
				event.preventDefault();
    			$('input[name = "cardnum1"]').val('1234-5678-9012-3456');
//     			$('input[name = "cardnum2"]').val('5678');
//     			$('input[name = "cardnum3"]').val('9012');
//     			$('input[name = "cardnum4"]').val('3456');
    			$('input[name = "threenum"]').val('246');
    			$('input[name = "month"]').val('12');
    			$('input[name = "year"]').val('20');
    			$('input[name = "name"]').val('${MemberLoginOK.name}');
    			$('input[name = "ID"]').val('${MemberLoginOK.personId}');
    			$('input[name = "phone"]').val('${MemberLoginOK.tel}');

    			$('label[for = "cardnum1"]').empty();
//     			$('label[for = "cardnum2"]').empty();
//     			$('label[for = "cardnum3"]').empty();
//     			$('label[for = "cardnum4"]').empty();
    			$('label[for = "threenum"]').empty();
    			$('label[for = "month"]').empty();
    			$('label[for = "year"]').empty();
    			$('label[for = "name"]').empty();
    			$('label[for = "ID"]').empty();
    			$('label[for = "phone"]').empty();
			});
		});
</script>

</html>