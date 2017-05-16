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
    <!--<link href="css/bootstrap.min.css" rel="stylesheet" />-->
    <link href="${pageContext.servletContext.contextPath}/css/material-kit.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/template.css" rel="stylesheet" />
    <!--以下請加入各自頁面的css-->

    <title>愛客宿-iCastle</title>
    <style>
     .myStyle{
        border:3px solid black;
     }
     
     textarea{
    	width:550px;
    	height:400px;
    	max-width:550px;
    	max-height:400px;  	
    }
    </style>
    

</head>
<body>
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
	<!--結束導覽列-->
	   <div style="margin-top:60px">
       		<table class="table">
    		<thead>
        		<tr>
            		<th class="text-center">編號</th>
            		<th>會員姓名</th>
            		<th>會員信箱</th>
            		<th>會員評論時間</th>
            		<th class="text-right">查看評論</th>
            		<th class="text-right">回覆評論</th>
        		</tr>
    		</thead>
    		<tbody>
 
         		<c:forEach var="comment" items="${commentData}">
         			<c:if test="${comment.response == null }">
         				<tr>       
            			<td name="firstId" class="text-center">
            			${comment.id}
            			</td>
                     
            			<td  id="memberName${comment.commentId}">
            			${comment.name}
            			</td>
   
            			<td>
            			${comment.email}
            			</td>
            
            			<td>
            			${comment.commentTime}
            			</td>
            
            			<td class="td-actions text-right">
                       	
            			<button type="button"  class="btn btn-info btn-simple btn-xs" id="${comment.commentId}" value="${comment.commentId}" name="ButtonCheck">
                			<i class="fa fa-user"></i>
                		</button>
                             
            			</td>
            			<td class="td-actions text-right">
            
            			<button type="button"  class="btn btn-info btn-simple btn-xs" name="ButtonResponse" value="${comment.commentId}">
                    		<i class="fa fa-user"></i>
               			</button>	
            
            
           				 </td>
           				 </tr>
            		</c:if>
            	</c:forEach> 
    		</tbody>
			</table>
		</div>
	
    <!--content here!!!!!!!!!!!!~~~~~~~~~~-->
    <!-- Modal Core -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">
        
        
        </h4>
      </div>
      <div class="modal-body" id="myDiv">
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-info btn-simple">Save</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel2">
        
        
        </h4>
      </div>
      <form id="myform" action="Response" method="post">
      <div class="modal-body" id="myDiv2">
        <input type="hidden" name="hiddeninput">
      	<textarea name="textareavalue">
      	
      	
      	
      	
      	</textarea>             
      </div>
      <div class="modal-footer">
        <input type="submit" class="btn btn-info btn-simple" value="回覆" id="mysubmit">
        <button type="button" class="btn btn-default btn-simple" data-dismiss="modal">Close</button>  
      </div>
      </form>
    </div>
  </div>
</div>
    
    <!--開始footer-->
		<jsp:include page="../fragment/footer.jsp"/>
	<!--結束footer-->
</body>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/material.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/nouislider.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/bootstrap-datepicker.js"></script>

<script src="${pageContext.servletContext.contextPath}/js/material-kit.js"></script>
 <script>
 $(document).ready(
		 function(){
			 
			 $('button[name="ButtonCheck"]').click(function(){
				 
				 $("#myDiv").empty();
				 $("#myModalLabel").empty();
				
				 var commentId =  $(this).val();
				 $.getJSON("CommentCheck",{"ButtonCheck":commentId},function(data){
					 
					 console.log(data);
					

			
					 $.each(data, function(i,value){


					     var len = data[i].ids.length;
           
						 var div = $("#myDiv");
						 div.empty();
						 div.append($("<h2></h2>").text());
						 div.append($("<h5>訂單編號</h5>"));
						 div.append($("<p></p>").text(data[i].orderId)); 
						 div.append($("<h5>平均評分</h5>"));
						 genimg(data[i].avgScore);
                         div.append($("<h5>服務評分</h5>"));
                         genimg(data[i].serviceScore);
                         div.append($("<h5>品質評分</h5>"));
                         genimg(data[i].qualityScore);
                         div.append($("<h5>風景評分</h5>"));
                         genimg(data[i].sceneScore);
                         div.append($("<h5>評論內容</h5>"));
                         div.append($("<p></p>").text(data[i].comment));
                         for(var j=0; j<len; j++){
                        	 div.append($("<img>").attr("src","http://localhost:8081/iCastle/comment/CommentPhotosServlet?id="+data[i].ids[j]));
                        	 
                         }

                         $('#myModalLabel').text($("#memberName"+commentId).text()+"的評論");
                       
						 					 

					 })
					 $("#myModal").modal('show');
					 
				 })
			 });
			 			 
			 function genimg(score){
				 
				 var img1 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
				 var img2 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
				 var img3 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
				 var img4 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
				 var img5 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
				 var div = $("#myDiv");
				 
				 if(score == 1){
					 
					 img1 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img2 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img3 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img4 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img5 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 
				 }else if(score == 2){
					 
					 img1 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img2 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img3 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img4 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img5 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 
					 
				 }else if(score == 3){
					 
					 img1 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img2 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img3 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img4 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 img5 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 
					 
				 }else if(score == 4){
					 
					 img1 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img2 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img3 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img4 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img5 = $("<img>").attr({src : "../img/unstar.png",width : "5%"});
					 
					 
				 }else{
					 
					 img1 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img2 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img3 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img4 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 img5 = $("<img>").attr({src : "../img/star.png",width : "5%"});
					 
					 
				 }

				
				 div.append([img1, img2, img3, img4, img5]);
				 
			 }
			 

			 
			 $('button[name="ButtonResponse"]').click(function(){
// 				 $("#myDiv").empty();
// 				 $("#myModalLabel").empty();	
// 				 $("#myModalLabel2").empty();
                 //清掉
				 $("textarea[name='textareavalue']").val(null);
				 $("#myModal2").modal('show');

				 
			 
				 var commentId= $(this).attr("value");
				 //設定隱藏input標籤的value值
				 $("input[name='hiddeninput']").val(commentId);				 
				
				
				 //抓到名字
				 var z = $("#memberName"+commentId).text();
				 
			     //在<h4>裡產生文字
				 $("#myModalLabel2").text("回應 "+z+" 的評論");
				 		 
			 });
			 
			 
			 $('#mysubmit').click(function(){
				 

				 
				 
				 
				
				 

				 

                 
				 
			 });
			 
			
			 
		 });
</script>


</html>