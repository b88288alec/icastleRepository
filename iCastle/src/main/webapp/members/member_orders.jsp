<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.servletContext.contextPath}/favicon.ico" rel="icon" type="image/x-icon" />
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
<!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
<link
	href="${pageContext.servletContext.contextPath}/css/material-kit.css"
	rel="stylesheet" />
<link href="${pageContext.servletContext.contextPath}/css/template.css"
	rel="stylesheet" />
<!--以下請加入各自頁面的css-->
<style>
.container {
	width: 1400px;
}
.myselfdiv{
    		width:600px;
    		overflow:auto;
    	}
tr{
	height:80px;
}
</style>

<title>愛客宿-iCastle</title>
</head>
<body>
	<!--開始導覽列-->
	<jsp:include page="../fragment/nav.jsp" />
	<!--結束導覽列-->
	<!--content here!!!!!!!!!!!!~~~~~~~~~~-->
	<div class="container" style="margin-top: 100px;">
		<!-- 歷史訂單 -->
			<table class="table" align="center">
				<!--標題列 -->
				<thead>
					<tr>
						<th>訂單號碼</th>
						<th>飯店名稱</th>
						<th>房型名稱</th>
						<th>入住日期</th>
						<th>退房日期</th>
						<th>房間數</th>
						<th>加床</th>
						<th>價錢</th>
						<th>入住人姓名</th>
						<th>旅客備註</th>
						<th>下單日期</th>
						<th>訂單狀態</th>
						<th>取消訂單</th>
				</thead>
				<tbody id='idtbody'>
				<c:forEach var="myData" items="${orders}">
					
					<!--取出VO裡的List 此orderKey相當於List概念-->
					<%-- 						${myData.orderId} ${myData.orderedDate} ${myData.memberId} ${myData.roomId} ${myData.hotelId} ${myData.hotelName} --%>
					<%-- 						${myData.roomTypeId} ${myData.roomTypeName} ${myData.checkinDay} ${myData.checkoutDay} ${myData.roomCount} --%>
					<%-- 						${myData.peopleNum} ${myData.breakfast} ${myData.dinner} ${myData.afternoonTea} ${myData.price}${myData.roomNo} --%>
					<%-- 						${myData.reservationer} ${myData.bdate} ${myData.tel} ${myData.email} ${myData.addr} ${myData.personId} ${myData.country} --%>
					<%-- 						${myData.passport} ${myData.bedAdding} ${myData.pricePerPerson}${myData.customerRemark} ${myData.hotelRemark} ${myData.memo}  --%>
					<%-- 						${myData.orderState} ${myData.cancelDate}		 --%>
						<tr>
						    
						    <input type="hidden" name="myinput" value="${myData.hotelId}">
						    

						    
							<td>${myData.orderId}</td>
							<td>${myData.hotelName}</td>
							<td>${myData.roomTypeName}</td>
							<td>${myData.checkinDay}</td>
							<td>${myData.checkoutDay}</td>
							<td>${myData.roomCount}</td>
							<td><c:choose>
									<%--orderState布林值判斷改顯示字串--%>
									<c:when test="${myData.bedAdding == true}">加一床</c:when>
									<c:otherwise>無</c:otherwise>
								</c:choose></td>
							<td>${myData.price}</td>
							<td>${myData.reservationer}</td>
							<td>${myData.customerRemark}</td>
							<td><c:choose>
									<%--判斷下單日期--%>
									<c:when test="${myData.orderedDate == null}"> - </c:when>
									<c:otherwise> ${myData.orderedDate} </c:otherwise>
								</c:choose></td>
							<td id="state${myData.orderId}"><c:choose>
									<%--orderState布林值判斷改顯示字串 --%>
									<c:when test="${myData.orderState == true}">訂單成立</c:when>
									<c:otherwise>取消訂單</c:otherwise>
								</c:choose></td>
								<td>
								<c:choose>
									<c:when test="${myData.cancelDate == null}">
									<div id="td${myData.orderId}">
										<button class="btn btn-primary" data-toggle="modal" data-target="#cancelModal" type="button" name="cancelOrder" id="" value="cancel">取消訂單</button>
									</div>
										<div class="modal fade" id="cancelModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  											<div class="modal-dialog">
   												<div class="modal-content">
      												<div class="modal-header">
        												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        												<h4 class="modal-title" id="myModalLabel">訂單取消規定</h4>
      												</div>
      												<div class="modal-body myselfdiv">
   													<p>※因各該飯店取消規定不盡相同，如旅客訂購之飯店取消訂房收取之費用高於本網站之規定時，則依各該飯店規定收取取消費，為配合飯店業者之作業時間，超過當天下午5:00後通知取消訂房者，視為次日通知取消。</p>
      												<ul>
      													<li><p>旅客透過本網進行訂房作業，視為同意並履行本網所公告之作業須知，旅客於本網完成訂房後，自行與飯店人員達成之任何協議或其他消費等等，均非本網之服務範圍，旅客應自行處理，本網恕不負責。</p></li>
      													<li><p>旅客於本網完成訂房手續並付款完成後，於入住之三天前（不含入住日）得更改原定之入住日期一次，變更後之入住日期自原定之入住日期以三個月內為限（例：原購買之入住日期為１月１０日，旅客可於１月６日前變更入住日，但最晚須於４月１０日前入住原飯店並使用完畢），本網不收取任何變更手續費用。惟須提醒！此服務以一次為限，並僅限於變更入住日期，不得更換訂購完成之飯店及旅客名單。旅客若變更入住日期後，恕不接受取消或退費；如變更入住日期造成費用增加，旅客應補足，如費用減少，本網將予以退還（例：旺季入住變更為淡季入住）。旅客變更入住日期後。如屬專案訂房，相關之專屬優惠權益將依旅客實際入住日期為準，無法保留（例如：專案訂房，贈送一月入住之旅客享用免費下午茶，旅客變更入住日期改為二月入住，則無法再提供免費下午茶）。</p></li>
      													<ol>
      														<li><p>旅客若於入住日七天前（不含入住日當天）取消已訂購完成之訂房，本網全額退費。</p></li>
      														<li><p>旅客若於入住日前四～七天內（含入住日當天）取消已訂購完成之訂房，除該飯店有對於取消費有特約規定外，本網將酌收每間房NTD150的作業處理費後，剩餘款項全數退還。</p></li>
      														<li><p>旅客若於入住日三天內（含入住日當天）取消已訂購完成之訂房，本網將收取全額30%住宿費用。</p></li>
      														<li><p>旅客若於入住日當天取消或更改已訂購完成之訂房，本網將收取全額100%住宿費用。</p></li>
      														<li><p>旅客若因個人因素未能於指定日期入住原預訂之飯店，視同當日取消訂房，本網恕無法提供退費服務。</p></li>
      													</ol>
      													<li><p>旅客如因故須縮減原入住天數（例：原購買三日住宿，縮減為二日或一日），均應通知並透過本網客服人員處理，本網將協助旅客與飯店業者確認退費相關之事宜，以免生後續費用退還之爭議。</p></li>
	      												<ol>
	      													<li><p>旅客於入住日七天前(不含入住當天)通知者，扣除飯店業者規定之相關費用後，其餘未住宿天數之費用本網將全數退還。</p></li>
    	  													<li><p>旅客於入住日一天前~七天內通知者，扣除飯店業者規定之相關費用，本網將酌收每間房NTD150元之作業處理費，其餘未住宿天數之費用再予以退還。</p></li>
      														<li><p>旅客於入住後始縮減原入住天數者，旅客需提出飯店業者所開具不收費證明之證明文件（需蓋有飯店戳章）交予本網服務人員，本網將酌收每間房NTD150元之作業處理費，其餘未住宿天數之費用本網將全數退還。惟須提 醒，縮減入住天數而未提供飯店之不收費證明文件，或不收費證明文件未蓋飯店戳章，或逾期申請者，恕本網不予受理退費。</p></li>
	      												</ol>
      												</ul>
      												<input type="checkbox" id="checkcancel" name="checkcancel" value="confirm"><label for="checkcancel">本人已詳閱並同意上述取消規定，並願意支付因取消時所產生的費用。</label>
      												</div>
      												<div class="modal-footer">
        												<input type="hidden" name="myOrderId" value="${myData.orderId}">
        												<button type="button" class="btn btn-info btn-simple" name="cancelButton" id="confirmcancel">確認取消</button>
        												<button type="button" class="btn btn-default btn-simple" data-dismiss="modal">返回</button>
      												</div>
    											</div>
  											</div>
										</div>
									</c:when>
									<c:when test="${myData.cancelDate != null}">${myData.cancelDate}</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose>
								</td>

						</tr>

				</c:forEach>
					</tbody>
			</table>
	</div>

	<!--開始footer-->
	<jsp:include page="../fragment/footer.jsp" />
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script
	src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>

<script>
//讀取button的value值
$(function(){
// 	取消訂單用
	$('#idtbody').on('click','button[name="cancelButton"]', cancelOrder);
	
// 	取消方法
	function cancelOrder(){
		console.log("test");
		var orderid = $('input[name="myOrderId"]').val();
		var tdid = ('#td' + orderid);
		var commenttdid = ('#comment' + orderid);
		var statettdid = ('#state' + orderid);
		if($('#checkcancel').prop('checked')){
			$('#cancelModal').modal('hide');
			$.ajax({
				type : 'GET',
				url : '${pageContext.servletContext.contextPath}/member/OrdersCancelServlet',
				data : {
					orderId : orderid
				},
				success : function(data){
					$(tdid).empty().append(data.cancelTime);
					$(commenttdid).empty();
					$(statettdid).empty().append("取消訂單");
				}
			})
		}
	}
})
</script>
</html>