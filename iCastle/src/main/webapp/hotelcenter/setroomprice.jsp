<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.amber-orange.min.css" />
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/material-dashboard.css" rel="stylesheet" />
    <!--<link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />-->
    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
    <link href="${pageContext.servletContext.contextPath}/css/manager_template.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/checkbox.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/fullcalendar.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/_materialFullCalendar.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/sweetalert2.css" rel="stylesheet" />
    <title>iCastle飯店管理中心</title>
    <style>
        #calendar {
            /* 		float: right; */
            margin: 0 auto;
            padding: 15px;
            width: 80%; 
            background-color: #FFFFFF;
            border-radius: 6px;
            /*box-shadow: 0 1px 2px #C3C3C3;*/
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
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-content">
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="select">
                                                <select style="margin-top:15px;">
                                                    <option selected>請選擇房型</option>
                                                    <c:forEach var="roomType" items="${roomTypeList}">
                                                    	<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
                                                    </c:forEach>
                                                </select>
                                                <div class="select__arrow" style="margin-top:15px;"></div>
                                            </div>
                                        </div>
                                        <div class="col-md-7">
                                            <div id="priceradio">
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="weekdaysPrice">
                                                    <input type="radio" id="weekdaysPrice" class="mdl-radio__button" name="price" value="1">
                                                    <span class="mdl-radio__label">平日價</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="holidayPrice">
                                                    <input type="radio" id="holidayPrice" class="mdl-radio__button" name="price" value="1">
                                                    <span class="mdl-radio__label">假日價</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="seasonPrice">
                                                    <input type="radio" id="seasonPrice" class="mdl-radio__button" name="price" value="1">
                                                    <span class="mdl-radio__label">旺季價</span>
                                                </label>
                                                <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="customizedPrice">
                                                    <input type="radio" id="customizedPrice" class="mdl-radio__button" name="price" value="1">
                                                    <span class="mdl-radio__label">情侶甜蜜價</span>
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" name="weekday" value="0">
                                                    星期日
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday"
                                                           value="1"> 星期一
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday"
                                                           value="2"> 星期二
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday" value="3">
                                                    星期三
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday" value="4">
                                                    星期四
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday" value="5">
                                                    星期五
                                                </label>
                                                <label>
                                                    <input type="checkbox" name="weekday" value="6">
                                                    星期六
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <button class="btn btn-info" id="plus">+</button>
                                            <button class="btn btn-info" id="submit">確認送出</button>
                                            <button class="btn btn-info" id="showJson">showJson</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-content">
                                    <div class="col-md-12">
                                        <div id="calendar"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel"></h4>
                            </div>
                            <div class="modal-body">
                                <h3>請選擇價錢</h3>
                                <div id="price-select"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info btn-simple" id="submit-single">修改</button>
                                <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">取消</button>
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

<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<!-- <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script> -->

<script src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/moment.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/fullcalendar.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/locale/zh-tw.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/sweetalert2.min.js"></script>
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<script>
    $(function () {
        $('.modal').appendTo("body");
        //選擇房型後更新日曆
        $('select').change(function () {
            var events = {
                url: '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
                data: {
                    hotelId: '${HotelLoginOK.hotelId}',
                    roomTypeId: $('select').val(),
                }
            }

            // 			$('#calendar').fullCalendar( 'removeEventSource', events);
            $('#calendar').fullCalendar('removeEventSources');
            $('#calendar').fullCalendar('addEventSource', events);
            $('#calendar').fullCalendar('refetchEvents');

            genPriceSelect('#priceradio', 'price');
            json.length = 0;

        })

        //生成價錢選擇器
        function genPriceSelect(selector, inputName) {
                    var checkbox_div = $(selector);
            $.getJSON("${pageContext.servletContext.contextPath}/json/roomtype/RoomTypePriceToJson", { "roomTypeId": $('select').val() },
                function (data) {
                    checkbox_div.empty();
                    $.each(data, function (i, price) {
                        var label_weekdaysPrice = $('<label></label>').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect").attr("for", "weekdaysPrice" + selector);
                        var input_weekdaysPrice = $('<input/>').attr({ type: "radio", value: price.weekdaysPrice, name: inputName, id: "weekdaysPrice" + selector });
                        var span_weekdaysPrice = $('<span></span>').addClass("mdl-radio__label").text("平日價");
                        label_weekdaysPrice.append([input_weekdaysPrice, span_weekdaysPrice]);

                        var label_holidayPrice = $('<label></label').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect").attr("for", "holidayPrice" + selector);
                        var input_holidayPrice = $('<input/>').attr({ type: "radio", value: price.holidayPrice, name: inputName, id: "holidayPrice" + selector });
                        var span_holidayPrice = $('<span></span>').addClass("mdl-radio__label").text("假日價");
                        label_holidayPrice.append([input_holidayPrice, span_holidayPrice]);

                        var label_seasonPrice = $('<label></label').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect").attr("for", "seasonPrice" + selector);
                        var input_seasonPrice = $('<input/>').attr({ type: "radio", value: price.seasonPrice, name: inputName, id: "seasonPrice" + selector });
                        var span_seasonPrice = $('<span></span>').addClass("mdl-radio__label").text("旺季價");
                        label_seasonPrice.append([input_seasonPrice, span_seasonPrice]);

                        var label_customizedPrice = $('<label></label').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect").attr("for", price.customizedName + selector);
                        var input_customizedPrice = $('<input/>').attr({ type: "radio", value: price.customizedPrice, name: inputName, id: price.customizedName + selector });
                        var span_customizedPrice = $('<span></span>').addClass("mdl-radio__label").text(price.customizedName);
                        label_customizedPrice.append([input_customizedPrice,span_customizedPrice]);
                        checkbox_div.append([label_weekdaysPrice, label_holidayPrice, label_seasonPrice, label_customizedPrice]);
                    })
                })
//                    componentHandler.upgradeElements($(selector + ' label.mdl-radio').get());
//                 console.log($(selector + ' label.mdl-radio').get());
//                    componentHandler.upgradeElements($('input[type=radio]').get());
//                 componentHandler.upgradeDom();
        }

        //初始化fullCalendar，並註冊dayClick及eventClick事件
        $('#calendar').fullCalendar({
            header: {
                left: 'title',
                right: 'prev,next today'
            },
            eventSources: [{
                url: '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
                data: {
                    hotelId: '${HotelLoginOK.hotelId}',
                    roomTypeId: $('select').val(),
                },
                error: function () {
                    swal({
                        title: '請先選擇房型',
                        type: 'info',
                    })
                }
            }],
            dayClick: function (date, jsEvent, view) {
                $('#myModalLabel').text(moment(date).format('YYYY-MM-DD'));
                genPriceSelect('#price-select', 'priceBySingle');
                $('#myModal').modal('show');
            },
            eventClick: function (calEvent, jsEvent, view) {
                $('#myModalLabel').text(calEvent.start._i);
                genPriceSelect('#price-select', 'priceBySingle');
                $('#myModal').modal('show');
            }
        })

        $('#plus').click(function (e) {
            add()
        })

        //存放使用者勾選的星期
        var weekdaycheck = [];
        //存放新增或修改價錢的json資料
        var json = [];

        //註冊勾選星期事件
        $('input[name=weekday]').click(function () {
            var weekdayNum = ($(this).prop("checked")) ? $(this).val() : null;
            if (weekdaycheck.length > 0 && weekdayNum != null) {
                for (var i = 0; i < weekdaycheck.length; i++) {
                    if (weekdaycheck[i] == parseInt(weekdayNum)) {
                        delete weekdaycheck[i];
                    }
                }
            } else if (weekdayNum == null) {
                for (var i = 0; i < weekdaycheck.length; i++) {
                    if (weekdaycheck[i] == parseInt($(this).val())) {
                        delete weekdaycheck[i];
                    }
                }
            }
            weekdaycheck.push(parseInt(weekdayNum));
        });

        $('#showJson').click(function () {
            alert(JSON.stringify(json))
        })

        //新增日期事件
        function add() {
            $('#calendar')
                .fullCalendar(
                'addEventSource',
                function (start, end, timezone, callback) {
                    var events = [];
                    var startd = new Date(start);
                    var endd = new Date(end);
                    var currentDate = new Date(endd.getFullYear(), (endd.getMonth()) - 1);
                    var end = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
                    console.log(end);
                    var price = $('input[name=price]:checked').val();

                    //判斷是否有勾選星期及價錢
                    if (weekdaycheck.length > 0 && !(price == null)) {
                        //根據目前月分跑每日迴圈
                        for (var loop = currentDate.getTime(); loop <= end; loop += (24 * 60 * 60 * 1000)) {
                            var date = new Date(loop);
                            var eventoObj = $("#calendar").fullCalendar('clientEvents', moment(date).format('YYYY-MM-DD'))[0];
                            //抓取weekdaycheck陣列的值
                            for (var i = 0; i < weekdaycheck.length; i++) {
                                //判斷現在日期星期是否與使用捨勾選的相同及該日期是否有已存在的價錢
                                if (date.getDay() == weekdaycheck[i] && eventoObj == null) {
                                    //新增事件
                                    events.push({
                                        id: moment(date).format('YYYY-MM-DD'),
                                        title: price,
                                        start: moment(date).format('YYYY-MM-DD'),
                                        color: 'lightgreen',
                                        allDay: 'true',
                                        className: 'success',
                                    });
                                    //將新增事件的資料儲存至json準備新增
                                    json.push({
                                        date: moment(date).format('YYYY-MM-DD'),
                                        price: $('input[name=price]:checked').val(),
                                    });
                                    //如果該日期是已有存在的價錢，則更新原有價錢
                                } else if (date.getDay() == weekdaycheck[i]) {
                                    eventoObj.title = price;
                                    eventoObj.color = 'lightgreen';
                                    $('#calendar').fullCalendar('updateEvent', eventoObj);
                                    json.push({
                                        roomId: eventoObj.roomId,
                                        date: moment(date).format('YYYY-MM-DD'),
                                        price: $('input[name=price]:checked').val(),
                                    });
                                }
                            }
                        }
                    } else {
                        swal({
                            title: '請先選擇價錢及星期',
                            type: 'error',
                        })
                    }
                    weekdaycheck.length = 0;
                    $('input[name=weekday]').removeAttr("checked");
                    callback(events);
                })
        }

        //註冊單一更改價錢事件
        $('#submit-single').click(function () {
            var date = $('#myModalLabel').text();
            var price = $('input[name=priceBySingle]:checked').val()
            var eventoObj = $("#calendar").fullCalendar('clientEvents', date)[0];
            if (eventoObj != null) {
                eventoObj.title = price;
                eventoObj.color = 'lightgreen';
                $('#myModal').modal('hide');
                $('#calendar').fullCalendar('updateEvent', eventoObj);
                json.push({
                    roomId: eventoObj.roomId,
                    date: date,
                    price: price,
                });
            } else {
                $("#calendar").fullCalendar('addEventSource',
                    function (start, end, timezone, callback) {
                        var events = [];
                        events.push({
                            id: $('#myModalLabel').text(),
                            title: price,
                            start: moment(date).format('YYYY-MM-DD'),
                            color: 'lightgreen',
                            allDay: 'true',
                        });
                        //將新增事件的資料儲存至json準備新增
                        json.push({
                            date: moment(date).format('YYYY-MM-DD'),
                            price: price,
                        });
                        $('#myModal').modal('hide');
                        callback(events);
                    })
            }

        });

        //將暫存於json內的資料傳送至server新增到資料庫，並重新整理頁面
        $('#submit').click(function () {
        	if(json.length != 0){
        		$.ajax({
                    type: 'POST',
                    url: '${pageContext.servletContext.contextPath}/hotelcenter/rooms/SetRoomPrice.do',
                    data: {
                        jsonData: JSON.stringify(json),
                        roomTypeId: $('select').val(),
                    },
//                     success: function () {
//                         swal({
//                             title: '新增成功',
//                             type: 'success',
//                         })
//                     }
                }).done(function(date){
                	swal({
                        title: '成功新增' + date + '筆資料',
                        type: 'success',
                    })
                	json.length = 0;
                    var events = {
                        url: '${pageContext.servletContext.contextPath}/json/rooms/MonthRoomsToJson',
                        data: {
                            hotelId: '${HotelLoginOK.hotelId}',
                            roomTypeId: $('select').val(),
                        }
                    }

                    //	 			$('#calendar').fullCalendar( 'removeEventSource', events);
                    $('#calendar').fullCalendar('removeEventSources');
                    $('#calendar').fullCalendar('addEventSource', events);
                    $('#calendar').fullCalendar('refetchEvents');
                })
        	}else{
        		swal({
                    title: '沒有要新增的價錢',
                    type: 'error',
                })
        	}
            
            
            
        })

    });
</script>
</html>