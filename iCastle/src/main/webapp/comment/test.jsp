<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <!--開始導覽列-->
		<jsp:include page="../fragment/nav.jsp"/>
 	<!--結束導覽列--
 	
    <!--開始本頁內容!!!!!!!!!!!!~~~~~~~~~~-->
    <div class="container">
    <!-- Indicators -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="http://synicsys.com/wp-content/uploads/2014/08/seo-banner-bgd.jpg" alt="Chania">
             
            </div>
            <div class="item">
                <img src="http://allpoints.ph/wp-content/uploads/2013/10/banner.jpg" alt="Chania">
          
            </div>
            <div class="item">
                <img src="http://www.nimble-solution.com/images/slider/banner4.png" alt="Flower">
               
            </div>
        </div>
        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="fa fa-angle-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="fa fa-angle-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
    </div>
</div>
    
    <!--結束本頁內容!!!!!!!!!!!!~~~~~~~~~~-->
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

</html>