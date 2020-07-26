<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>识别结果</title>
	
		
	<!--可无视-->
	<link rel="stylesheet" type="text/css" href="css/reset.css">
		
	<!--响应式框架-->
	<link rel="stylesheet" href="css/bootstrap-grid.min.css">
	
	<!--图标库-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<!--主要样式-->
	<link rel="stylesheet" href="css/1style.css">

</head>
<body>

<div class="demo">

	<div class="container">



			
			
			
			<div class="col-md-4 col-sm-6">
				<div class="box">
					<img  src="${pageContext.request.contextPath }/${result.img}">
					<div class="box-content">
					<span class="post">识别结果</span>
						<h3 class="title">${result.name}</h3>
						
					</div>
		
				</div>
			</div>
			

		</div>
	</div>
</div>
	
</body>
</html>