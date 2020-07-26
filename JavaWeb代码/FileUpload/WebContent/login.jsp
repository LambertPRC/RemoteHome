
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>你发现了我哟</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/9style.css" />
<link type="text/css" rel="stylesheet" href="css/login.css" />
<script>
  
	window.onload = function ()
	{
		var oLi = document.getElementById("tab").getElementsByTagName("li");
		var oUl = document.getElementById("content").getElementsByTagName("ul");
		
		
		
		for(var i = 0; i < oLi.length; i++)
		{
			oLi[i].index = i;
			oLi[i].onclick = function ()
			{
				
				for(var n = 0; n < oLi.length; n++)
					oLi[n].className="";
					
				this.className = "current";
				
				for(var n = 0; n < oUl.length; n++) 
					oUl[n].style.display = "none";
					
				oUl[this.index].style.display = "block";
				if(oUl[this.index].title == ""){			
					$.parser.parse(oUl[this.index]);
					oUl[this.index].title = "parsed";
				}
			}	
		}
	}
	</script>
</head>

<body>

<div class="log_main">
   <h1>花卉识别<br />基于深度学习以及socket应用的实现</h1>
   <div class="rygl_up">
      <ul id="tab">
         <li class="current">注册</li>
         <li>登录</li>
      </ul>
      <div id="content">
         <ul style="display:block;">
             <div class="zhuce">
           <form action="${pageContext.request.contextPath }/register">
             
              <input name="id" type="text" placeholder="请输入ID" class="denglu_num"/>
                <input name="password" type="text" placeholder="请输入密码" class="denglu_psd"/>
  
                <input name="" type="submit" value="立即注册" class="zhuce_btn"/>
             
             
             </form>
               
             </div>      
         </ul>
         <ul> 
         <form action="${pageContext.request.contextPath }/login">
                     <div class="denglu">
                <input name="id" type="text" placeholder="请输入ID" class="denglu_num"/>
                <input name="password" type="text" placeholder="请输入密码" class="denglu_psd"/>
  
                <a href="#"><input name="" type="submit" value="登录" class="denglu_btn"/></a>
             </div>   
         
         </form>
         
         
         </ul>
      </div>
   </div>
</div>


<div style=" clear:both"></div>
<!--尾部开始-->
<div class="footer" style="margin-top:2px;">
   <div class="footer-1">
      <ul class="footer-1-ion">
         <li class="f-qq"><img src="images/qq.png" /></li>
         <li class="f-xl"><img src="images/xl.png" /></li>
         <li class="f-ma"><img src="images/ma.png" /></li>
         <li class="f-zf"><img src="images/zf.png" /></li>
      </ul>
      <div style="clear:both"></div>

    
   </div>
</div>
</body>
</body>
</html>
