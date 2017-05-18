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
<title>iCastle飯店管理中心</title>

<style>
.myStyle {
	border: 3px solid black;
}

textarea {
	width: 550px;
	height: 400px;
	max-width: 550px;
	max-height: 400px;
}

.material-icons.md-48.md-dark {
	font-size: 48px;
	color: rgba(0, 0, 0, 0.54);
}

/* ----------------圖片輪播css------------------- */

		.carousel-control.left
			{
				background: none;
			}
			.carousel-control.right
			{
				background: none;
			}

			.carousel-control
			{
				position: absolute;
				top: 45%;
				bottom: 0;
				left: 0;
				width: 15%;
				font-size: auto;
				color: #fff;
				text-align: center;
				opacity: 1;
				text-shadow: none;
			}
			.carousel-control:hover
			{
				color: #000;
			}
			.carousel-indicators
			{
				bottom: -50px;
			}
			.carousel-indicators li
			{
				display: inline-block;
				width: 10px;
				height: 10px;
				margin: 1px;
				text-indent: -999px;
				cursor: pointer;
				background-color: #000\9;
				background-color: rgba(0,0,0,0);
				border: 1px solid #16a085;
				border-radius: 50%;
			}
			.carousel-indicators .active
			{
				width: 12px;
				height: 12px;
				margin: 0;
				background-color: #16a085;
			}
			.carousel-caption
			{
				position: absolute;
				right: 0;
				bottom: 0;
				left: 0;
				z-index: 10;
				padding-top: 20px;
				padding-bottom: 20px;
				color: #fff;
				text-align: center;
				background: rgba(0,0,0,0.4);
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
				<!-- ------------------------------------------------------ -->
				<div class="card">
					<div class="card-header" data-background-color="green">
						<h4 class="title">顧客評論</h4>
					</div>
					<div class="card-content table-responsive table-full-width" id="divStyle">
						<input type="hidden" value="${page}" name="myInput">
						<input type="hidden" value="${pageContext.servletContext.contextPath}" id="path">

						<table class="table">
							<thead class="text-danger">


				                 
								<th class="text-center">會員姓名</th>
								<th class="text-center">會員信箱</th>
								<th class="text-center">評論時間</th>
								<th class="text-center">查看評論</th>
								<th class="text-center">回覆評論</th>
								<th class="text-center">刪除</th>


							</thead>
							<tbody>
								<!-- 																forEach開始 -->
								<c:forEach var="comment" items="${commentData}">

										<tr>
							
											<td id="memberName${comment.commentId}" class="text-center">${comment.name}</td>
											<td class="text-center">${comment.email}</td>
											<td class="text-primary text-center" >${comment.commentTime}</td>

											<td class="text-center">
												<button type="button" class="btn btn-info btn-simple btn-xs"
													id="${comment.commentId}" value="${comment.commentId}"
													name="ButtonCheck">
													<i class="material-icons md-48 md-dark">message</i>
												</button>
											</td>

											<td class="text-center">
												<button type="button" class="btn btn-info btn-simple btn-xs"
													name="ButtonResponse" value="${comment.commentId}">
													<i class="material-icons md-48 md-dark">rate_review</i>
												</button>


											</td>
											
											<td class="text-center">
												<button type="button" class="btn btn-info btn-simple btn-xs"
													name="ButtonResponse" value="${comment.commentId}">
													<i class="material-icons md-48 md-dark">rate_review</i>
												</button>


											</td>
											
																				

										</tr>

								</c:forEach>

								<!-- 																forEach結束 -->
							</tbody>
						</table>

					</div>
				</div>
<!-- 	上一頁、下一頁 -->

                
				<ul class="pagination pagination-primary text-center" name="myul">
                <c:forEach begin="1" end="${DataNumbers/5+1}" varStatus="number">
                
                <li><a href="${pageContext.servletContext.contextPath}/hotelcenter/HostComment?page=${number.count}">${number.count}</a></li>
                
               
                
                </c:forEach>
				
				
					
                	
				</ul>

				<!-- 	上一頁、下一頁 -->



				<!-- 				Modal Core -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h3 class="text-center" id="myModalLabel"></h3>
							</div>
							<div class="modal-body" id="myDiv">


                                                               

							</div>
<!-- 圖 -->
<!-- <div class="container"> -->

<!-- 		<div id="myCarousel" class="carousel slide" data-ride="carousel"> -->

<!-- 			<div class="carousel-inner" role="listbox" id="outerDiv"> -->
			
			
			
<!-- 			</div> -->

<!-- 			<a class="left carousel-control" href="#myCarousel" role="button" -->
<!-- 				data-slide="prev"> <span class="fa fa-angle-left" -->
<!-- 				aria-hidden="true"></span> <span class="sr-only">Previous</span> -->
<!-- 			</a> <a class="right carousel-control" href="#myCarousel" role="button" -->
<!-- 				data-slide="next"> <span class="fa fa-angle-right" -->
<!-- 				aria-hidden="true"></span> <span class="sr-only">Next</span> -->
<!-- 			</a> -->

<!-- 		</div> -->
<!-- 	</div> -->

<!-- 圖 -->
							<div class="modal-footer">
								<button type="button" class="btn btn-default btn-simple"
									data-dismiss="modal">關閉</button>
							</div>
						</div>
					</div>
				</div>

				
				
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel2"></h4>
							</div>
							<form id="myform" action="Response" method="post">
								<div class="modal-body" id="myDiv2">
									<input type="hidden" name="hiddeninput">
									<input type="hidden" name="formInput">
									<textarea name="textareavalue">
      	
      	
      	
      	
      	                            </textarea>
								</div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-info btn-simple" value="回覆"
										id="mysubmit">
									<button type="button" class="btn btn-default btn-simple"
										data-dismiss="modal">關閉</button>									
								</div>
							</form>
						</div>
					</div>
				</div>


				<!-- ------------------------------------------------------- -->
			</div>
		</div>
	</div>



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

<script>
	$(document).ready(
			function() {
				//修正跳出視窗bug
				$('.modal').appendTo("body");
				$('button[name="ButtonCheck"]').click(
						function() {

							$("#myDiv").empty();
							$("#myModalLabel").empty();
                            
							var path = $("#path").val();
							var commentId = $(this).val();
							$.getJSON("CommentCheck", {
								"ButtonCheck" : commentId
							}, function(data) {

								console.log(data);

								$.each(data, function(i, value) {

									var len = data[i].ids.length;

									var div = $("#myDiv");
									div.empty();
									div.append($("<h2></h2>").text());
									div.append($("<h5>訂單編號</h5>"));
									div.append($("<p></p>").text(
											data[i].orderId));
									div.append($("<h5>平均評分</h5>"));
									genimg(data[i].avgScore);
									div.append($("<h5>服務評分</h5>"));
									genimg(data[i].serviceScore);
									div.append($("<h5>品質評分</h5>"));
									genimg(data[i].qualityScore);
									div.append($("<h5>風景評分</h5>"));
									genimg(data[i].sceneScore);
									div.append($("<h5>評論內容</h5>"));
									div.append($("<p></p>").text(
											data[i].comment));
									for (var j = 0; j < len; j++) {
										div.append($("<img>").attr(
												"src",
												 path+"/comment/CommentPhotosServlet?id="
														+ data[i].ids[j]).attr("width","400"));

//                                         var imgRotation = $("<img>").attr("src",path+"/comment/CommentPhotosServlet?id="+ data[i].ids[j]).attr("width","400");
                                        
//                                         var outerDiv = $("#outerDiv");
//                                         outerDiv.append("<h1></h1>");
                                        
                                        
//                                         if(j==0){
//                                         	outerDiv.append($("<div></div>").addClass("item active").append(imgRotation));

                                        	
                                        	
//                                         }else{
                                        	
//                                         	outerDiv.append($("<div></div>").addClass("item").append(imgRotation));
                                        	
//                                         }
									}

									$('#myModalLabel').text(
											$("#memberName" + commentId).text()
													+ "的評論");

								})
								$("#myModal").modal('show');

							})
						});

				function genimg(score) {

					var img1 = $("<img>").attr({
						src : "../img/unstar.png",
						width : "5%"
					});
					var img2 = $("<img>").attr({
						src : "../img/unstar.png",
						width : "5%"
					});
					var img3 = $("<img>").attr({
						src : "../img/unstar.png",
						width : "5%"
					});
					var img4 = $("<img>").attr({
						src : "../img/unstar.png",
						width : "5%"
					});
					var img5 = $("<img>").attr({
						src : "../img/unstar.png",
						width : "5%"
					});
					var div = $("#myDiv");

					if (score == 1) {

						img1 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img2 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img3 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img4 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img5 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});

					} else if (score == 2) {

						img1 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img2 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img3 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img4 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img5 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});

					} else if (score == 3) {

						img1 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img2 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img3 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img4 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});
						img5 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});

					} else if (score == 4) {

						img1 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img2 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img3 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img4 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img5 = $("<img>").attr({
							src : "../img/unstar.png",
							width : "5%"
						});

					} else {

						img1 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img2 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img3 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img4 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});
						img5 = $("<img>").attr({
							src : "../img/star.png",
							width : "5%"
						});

					}

					div.append([ img1, img2, img3, img4, img5 ]);

				}

				$('button[name="ButtonResponse"]').click(function() {
					// 				 $("#myDiv").empty();
					// 				 $("#myModalLabel").empty();	
					// 				 $("#myModalLabel2").empty();
					//清掉
					$("textarea[name='textareavalue']").val(null);
					$("#myModal2").modal('show');

					var commentId = $(this).attr("value");
					
					//設定隱藏input標籤的value值
					$("input[name='hiddeninput']").val(commentId);
					
					//取得input name為 myInput的page值
					var inputValue = $("input[name='myInput']").val();
					$("input[name='formInput']").attr("value",inputValue);


					//抓到名字
					var z = $("#memberName" + commentId).text();

					//在<h4>裡產生文字
					$("#myModalLabel2").text("回應 " + z + " 的評論");

				});

				$('#mysubmit').click(function() {

				});
				
				
				$("li").click(function(){
					
					
				});

			});
</script>

</html>