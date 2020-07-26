<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>上传图片</title>
</head>
<body>



		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/getfile" method="post" enctype="multipart/form-data">
	
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
						</td>
						<input type="submit" value="提交">
						</form>

</body>
</html>