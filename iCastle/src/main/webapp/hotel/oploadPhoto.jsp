<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${AppName}</title>

</head>

<div id='main'>
		<!-- 上傳檔案時<form>標籤的 enctype屬性必須是 "multipart/form-data" -->
		<!-- 而且method屬性必須是 "post" -->
		<form name="form1" method="post" action="InsertPhoto.do"
			                                    enctype="multipart/form-data">
			<input type="file" name="uploadFile" size="40" /> 
			<input type="submit" name="Submit" value="新增" />
		</form>
</div>
</body>
</html>