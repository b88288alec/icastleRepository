<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>


<body>
<%
	String servletPath = request.getServletPath();
	request.setAttribute("servletPath", servletPath);
%>
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
                <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/index.jsp">
                    <img alt="Brand" height="30" src="${pageContext.servletContext.contextPath}/img/logo.png" />
                </a>
            </div>
            <!--結束logo-->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
					<c:choose>
						<c:when test="${servletPath  == '/index.jsp'}">
							<li class="active"><a href="${pageContext.servletContext.contextPath}/index.jsp">首頁</a></li>	
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.servletContext.contextPath}/index.jsp">首頁</a></li>							
						</c:otherwise>
				    </c:choose>
    				
    				
    				<c:choose>
						<c:when test="${servletPath  == '/qa/showQa.jsp'}">
							<li class="active"><a href="${pageContext.servletContext.contextPath}/qa/showQa.jsp">Q&A</a></li>	
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.servletContext.contextPath}/qa/showQa.jsp">Q&A</a></li>						
						</c:otherwise>
				    </c:choose>
    				   
    				<c:choose>
    					<c:when test="${not empty MemberLoginOK}">
							<!--會員標頭使用區塊 -->
    					</c:when>
    					<c:when test="${not empty HotelLoginOK}">
							<!--飯店標頭使用區塊 -->
    					</c:when>
    					<c:when test="${not empty ManagerLoginOK}">
    						<!--管理員標頭使用區塊 -->
    						<c:choose>
	    						<c:when test="${servletPath  == '/manager/manager_index.jsp'}">
    								<li class="active"><a href="${pageContext.servletContext.contextPath}/manager/GetAllhotel.do">管理員首頁</a></li>
	    						</c:when>
	    						<c:otherwise>
	    							<li><a href="${pageContext.servletContext.contextPath}/manager/GetAllhotel.do">管理員首頁</a></li>
	    						</c:otherwise>
    						</c:choose>
    					</c:when>
    					<c:otherwise>
    					  
    					</c:otherwise>
    				</c:choose>
                    
                </ul>
                <ul class="nav navbar-nav navbar-right">
					<c:choose>
    					<c:when test="${not empty MemberLoginOK}">
							<!--會員標頭使用區塊 -->
							<li><a href="${pageContext.servletContext.contextPath}/members/MemberCentre.jsp"><span class="glyphicon glyphicon-user"></span>${MemberLoginOK.email}</a></li>
    					</c:when>
    					<c:when test="${not empty HotelLoginOK}">
							<!--飯店標頭使用區塊 -->
							<li><a href="${pageContext.servletContext.contextPath}/hotelcenter/ShowHotelInfo.do"><span class="glyphicon glyphicon-user"></span>${HotelLoginOK.email}</a></li>
    					</c:when>
    					<c:when test="${not empty ManagerLoginOK}">
							<!--管理員標頭使用區塊 -->
    					</c:when>
    					<c:otherwise>
    					</c:otherwise>
    				</c:choose>

                    <c:choose>
						<c:when test="${empty HotelLoginOK && empty MemberLoginOK && empty ManagerLoginOK}">
						<!-- 沒有登入 -->
							<c:choose>
								<c:when test="${servletPath  == '/hotel/register.jsp' || servletPath == '/hotel/registerhotel.jsp'}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/general/register.jsp"><span class="glyphicon glyphicon-registration-mark"></span> 註冊</a></li>	
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.servletContext.contextPath}/general/register.jsp"><span class="glyphicon glyphicon-registration-mark"></span> 註冊</a></li>	
								</c:otherwise>
		    				</c:choose>
							<c:choose>
								<c:when test="${servletPath == '/hotel/login.jsp' || servletPath == '/hotel/loginhotel.jsp'}">
									<li class="active"><a href="${pageContext.servletContext.contextPath}/general/login.jsp"><span class="glyphicon glyphicon-user"></span> 登入</a></li>	
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.servletContext.contextPath}/general/login.jsp"><span class="glyphicon glyphicon-user"></span> 登入</a></li>
								</c:otherwise>
			   				</c:choose>	
						</c:when>
						<c:otherwise>
						<!-- 已經登入 -->
							<li><a href="${pageContext.servletContext.contextPath}/hote/Logout.do"><span class="glyphicon glyphicon-log-in"></span> 登出</a></li>	
						</c:otherwise>
    				</c:choose>
                </ul>
            </div>
        </div>
    </nav>
    <!--結束導覽列-->
</body>