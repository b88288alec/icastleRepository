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
<link href="${pageContext.servletContext.contextPath}/favicon.ico"
	rel="icon" type="image/x-icon" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.amber-orange.min.css" />
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
<link href="${pageContext.servletContext.contextPath}/css/checkbox.css"
	rel="stylesheet" />
<title>iCastle飯店管理中心</title>
<style>
table label {
	margin-bottom: 0px;
}

@media screen and (max-width:1366px) {
	.mycheckbox {
		margin-bottom: 35px;
	}
}

@media screen and (max-width:1366px) {
	.myradio {
		margin-bottom: 50px;
	}
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
				<div class="card">
					<div class="card-content">
						<div class="row">
							<div class="col-md-2">
								<h5>選擇房型</h5>
								<div class="select">
									<select style="margin-top: 15px;" id="roomTypeId">
										<option value="all" selected>全部</option>
										<c:forEach var="roomType" items="${roomTypeList}">
											<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
										</c:forEach>
									</select>
									<div class="select__arrow" style="margin-top: 15px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card">
					<div class="card-content">
						<div class="row">
							<div class="col-md-12 table-full-width">
								<table class="table table-bordered">
									<thead class="text-warning">
										<tr>
											<th class="text-center col-md-1">房型名稱</th>
											<th class="text-center col-md-1">入住人數</th>
											<th class="text-center col-md-1">每晚價格</th>
											<th class="text-center col-md-1">三餐供應</th>
											<th class="text-center col-md-1">加床</th>
											<th class="text-center col-md-1">加床費用/人</th>
											<th class="text-center col-md-1">備註</th>
											<th class="text-center col-md-1">房間數量</th>
										</tr>
									</thead>
									<tbody id="room">
									</tbody>
								</table>
							</div>
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

<script
	src="${pageContext.servletContext.contextPath}/js/chartist.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-notify.js"></script>

<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-dashboard.js"></script>
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<script>
$(function(){
	$('#roomTypeId').change(function(){
		var id = $(this).val();
		
		if(id == 'all'){
			$.getJSON("${pageContext.servletContext.contextPath}/json/HotelIdRecordToJson",{"hotelId":"${HotelLoginOK.hotelId}"},
					function(data){
					var tbody = $('#room');
					tbody.empty();
				$.each(data, function(i,record) {
					console.log(data[i]);
					gentr(i,data[i],tbody);
				})
			})
		}else{
			$.getJSON("${pageContext.servletContext.contextPath}/hotelcenter/RoomTypeRecordToJosn",{"roomTypeId":id},
					function(data){
					var tbody = $('#room');
					tbody.empty();
				$.each(data, function(i,record){
					gentr(i,record,tbody);
				})
			})
		}
	});
	
	function gentr(i,record, tbody){
           
        var tr = $('<tr></tr>');
        
        var tr_time = $('<tr></tr>').css("background-color","#E0E0E0");
        var time_td = $('<td></td>').attr("colspan","8").addClass("text-center");
        var time_h6 = $('<h6></h6>').text(record[0].recordTime + '前的房型紀錄');
        time_td.append(time_h6);
        tr_time.append(time_td);
        
        var roomTypeName_td = $('<td></td>').css("vertical-align", "middle");
        var roomTypeName_row = $('<div></div>').addClass("row");
        var roomTypeName_col = $('<div></div>').addClass('col-md-12');
        var roomTypeName_p = $('<p></p>').text(record[0].roomTypeName);
        roomTypeName_td.append([roomTypeName_row,roomTypeName_col,roomTypeName_p]);
        
        var peopleNum_td = $('<td></td>').css("vertical-align", "middle").addClass("text-center");
        var peopleNum_row = $('<div></div>').addClass("row");
        var peopleNum_col = $('<div></div>').addClass('col-md-12');
        var peopleNum_p = $('<p></p>').text(record[0].peopleNum + '人');
        peopleNum_td.append([peopleNum_row,peopleNum_col,peopleNum_p]);
        
        var price_td = $('<td></td>').css("vertical-align", "middle");
        var price_table = $('<table></table>');
        var price_tbody = $('<tbody></tbody>');
        
        var weekdaysPrice_tr = $('<tr></tr>');
        var weekdaysPrice_td1 = $('<td></td>');
        var weekdaysPrice_p = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text("平日價");
        var weekdaysPrice_td2 = $('<td></td>');
        var weekdaysPrice_p2 = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text(record[0].weekdaysPrice);
        weekdaysPrice_td2.append(weekdaysPrice_p2);
        weekdaysPrice_td1.append(weekdaysPrice_p);
        weekdaysPrice_tr.append([weekdaysPrice_td1, weekdaysPrice_td2]);
        
        var holidayPrice_tr = $('<tr></tr>');
        var holidayPrice_td1 = $('<td></td>');
        var holidayPrice_p = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text("假日價");
        var holidayPrice_td2 = $('<td></td>');
        var holidayPrice_p2 = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text(record[0].holidayPrice);
        holidayPrice_td2.append(holidayPrice_p2);
        holidayPrice_td1.append(holidayPrice_p);
        holidayPrice_tr.append([holidayPrice_td1, holidayPrice_td2]);
        
        var seasonPrice_tr = $('<tr></tr>');
        var seasonPrice_td1 = $('<td></td>');
        var seasonPrice_p = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text("旺季價");
        var seasonPrice_td2 = $('<td></td>');
        var seasonPrice_p2 = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text(record[0].seasonPrice);
        seasonPrice_td2.append(seasonPrice_p2);
        seasonPrice_td1.append(seasonPrice_p);
        seasonPrice_tr.append([seasonPrice_td1, seasonPrice_td2]);
        
        var customizedPrice_tr = $('<tr></tr>');
        var customizedPrice_td1 = $('<td></td>');
        var customizedPrice_p = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text(record[0].customizedName);
        var customizedPrice_td2 = $('<td></td>');
        var customizedPrice_p2 = $('<p></p>').css({ "font-size": "16px", "padding-top": "10px" }).text(record[0].customizedPrice);
        customizedPrice_td2.append(customizedPrice_p2);
        customizedPrice_td1.append(customizedPrice_p);
        customizedPrice_tr.append([customizedPrice_td1, customizedPrice_td2]);
        
        price_tbody.append([weekdaysPrice_tr, holidayPrice_tr, seasonPrice_tr, customizedPrice_tr]);
        price_table.append(price_tbody);
        price_td.append(price_table);
        
        var meals_td = $('<td></td>').css("vertical-align", "middle");
        var meals_row = $('<div></div>').addClass("row");
        var meals_col = $('<div></div>').addClass('col-md-12');
        var breakfast_row = $('<div></div>').addClass("row");
        var breakfast_col = $('<div></div>').addClass('col-md-12');
        if(record[0].breakfast == 'true'){
       	 var breakfast_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-checked is-upgraded").attr("for", "meals0" + "_" + i);
            var breakfast_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals0" + "_" + i,}).prop({checked: "true", disabled: "true"});
        }else{
       	 var breakfast_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-upgraded").attr("for", "meals0" + "_" + i);
            var breakfast_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals0" + "_" + i,}).prop({disabled: "true"});
        }
        var breakfast_span = $('<span></span>').addClass("mdl-checkbox__label").text("早餐");
        breakfast_label.append([breakfast_input, breakfast_span]);
        breakfast_col.append(breakfast_label);
        breakfast_row.append(breakfast_col);
        
        var afternoonTea_row = $('<div></div>').addClass("row");
        var afternoonTea_col = $('<div></div>').addClass('col-md-12');
        if(record[0].afternoonTea == 'true'){
       	 var afternoonTea_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-checked is-upgraded").attr("for", "meals1" + "_" + i);
            var afternoonTea_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals1" + "_" + i,}).prop({checked: "true", disabled: "true"});
        }else{
       	 var afternoonTea_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-upgraded").attr("for", "meals1" + "_" + i);
            var afternoonTea_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals1" + "_" + i,}).prop({disabled: "true"});
        }
        var afternoonTea_span = $('<span></span>').addClass("mdl-checkbox__label").text("下午茶");
        afternoonTea_label.append([afternoonTea_input, afternoonTea_span]);
        afternoonTea_col.append(afternoonTea_label);
        afternoonTea_row.append(afternoonTea_col);
        
        var dinner_row = $('<div></div>').addClass("row");
        var dinner_col = $('<div></div>').addClass('col-md-12');
        if(record[0].dinner == 'true'){
       	 var dinner_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-checked is-upgraded").attr("for", "meals2" + "_" + i);
            var dinner_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals2" + "_" + i,}).prop({checked: "true", disabled: "true"});
        }else{
       	 var dinner_label = $('<label></label>').addClass("mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mycheckbox mdl-js-ripple-effect--ignore-events is-disabled is-upgraded").attr("for", "meals2" + "_" + i);
            var dinner_input = $('<input/>').addClass("mdl-checkbox__input").attr({ type: "checkbox", id: "meals2" + "_" + i,}).prop({disabled: "true"});
        }
        var dinner_span = $('<span></span>').addClass("mdl-checkbox__label").text("晚餐");
        dinner_label.append([dinner_input, dinner_span]);
        dinner_col.append(dinner_label);
        dinner_row.append(dinner_col);
        
        meals_col.append([breakfast_row, afternoonTea_row, dinner_row]);
        meals_row.append(meals_col);
        meals_td.append(meals_row);
        
        var bedAddable_td = $('<td></td>').css("vertical-align", "middle");
        var bedAddable_col = $('<div></div>').addClass('col-md-12');
        if(record[0].bedAddable == 'true'){
       	 var bedAddable_label_yes = $('<label></label>').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect myradio mdl-js-ripple-effect--ignore-events is-disabled is-checked is-upgraded").attr("for", "bedAddable" + i + "_yes");
            var bedAddable_input_yes = $('<input/>').addClass("mdl-radio__button").attr({ type: "radio", id: "bedAddable" + i + "_yes" }).prop({checked: "true", disabled: "true"});
            var bedAddable_label_no = $('<label></label>').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect myradio mdl-js-ripple-effect--ignore-events is-disabled is-upgraded").attr("for", "bedAddable" + i + "_no");
            var bedAddable_input_no = $('<input/>').addClass("mdl-radio__button").attr({ type: "radio", id: "bedAddable" + i + "_no" }).prop({disabled: "true"});
        }else{
       	 var bedAddable_label_yes = $('<label></label>').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect myradio mdl-js-ripple-effect--ignore-events is-disabled is-upgraded").attr("for", "bedAddable" + i + "_yes");
            var bedAddable_input_yes = $('<input/>').addClass("mdl-radio__button").attr({ type: "radio", id: "bedAddable" + i + "_yes" }).prop({disabled: "true"});
            var bedAddable_label_no = $('<label></label>').addClass("mdl-radio mdl-js-radio mdl-js-ripple-effect myradio mdl-js-ripple-effect--ignore-events is-disabled is-checked is-upgraded").attr("for", "bedAddable" + i + "_no");
            var bedAddable_input_no = $('<input/>').addClass("mdl-radio__button").attr({ type: "radio", id: "bedAddable" + i + "_no" }).prop({checked: "true", disabled: "true"});
        }
        var bedAddable_span_yes = $('<span></span>').addClass("mdl-radio__label").text("可加床");
        var bedAddable_span_no = $('<span></span>').addClass("mdl-radio__label").text("不可加床");
        bedAddable_label_yes.append([bedAddable_input_yes, bedAddable_span_yes]);
        bedAddable_label_no.append([bedAddable_input_no, bedAddable_span_no]);
        bedAddable_col.append([bedAddable_label_yes, bedAddable_label_no]);
        bedAddable_td.append(bedAddable_col);
        
        var pricePerPerson_td = $('<td></td>').css("vertical-align", "middle");
        var pricePerPerson_row = $('<div></div>').addClass("row");
        var pricePerPerson_col = $('<div></div>').addClass('col-md-12');
        var pricePerPerson_p = $('<p></p>').text(record[0].PrcePerPerson);
        pricePerPerson_td.append([pricePerPerson_row,pricePerPerson_col,pricePerPerson_p]);
        
        var remark_td = $('<td></td>').css("vertical-align", "middle");
        var remark_row = $('<div></div>').addClass("row");
        var remark_col = $('<div></div>').addClass('col-md-12');
        var remark_pre = $('<pre></pre>').text(record[0].remark);
        remark_col.append(remark_pre);
        remark_row.append(remark_col);
        remark_td.append(remark_row);
        
        var roomNumber_td = $('<td></td>').css("vertical-align", "middle");
        var roomNumber_row = $('<div></div>').addClass("row");
        var roomNumber_col = $('<div></div>').addClass('col-md-12');
        var roomNumber_p = $('<p></p>').text(record[0].roomNumber);
        roomNumber_td.append([roomNumber_row,roomNumber_col,roomNumber_p]);
        
        tr.append([roomTypeName_td, peopleNum_td, price_td, meals_td, bedAddable_td, pricePerPerson_td, remark_td, roomNumber_td]);
        tbody.append([tr_time, tr]);
		componentHandler.upgradeDom();
	}
})
</script>
</html>