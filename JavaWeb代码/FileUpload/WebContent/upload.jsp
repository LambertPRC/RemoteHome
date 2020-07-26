<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图像上传</title>
<script type="text/javascript" src="js/2jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/public.css">
<style type="text/css">
.message{width:320px;margin:120px auto 0px auto;line-height:24px;color:#ffd5bc;overflow:hidden}
.message .input{width:219px;height:28px;line-height:28px;border:none;background:#333333;padding-left:20px;color:#ffffff;font-family:Microsoft YaHei;}
.message .liulan{width:64px;height:28px;border:1px solid #ffb660;background:#fe9e19;color:#ffffff;cursor:pointer;}
.message .files{position:absolute;left:-1000px;top:52px;heigth:26px;cursor:pointer;filter: Alpha(opacity=0);-moz-opacity:0;opacity:0;} 
</style>

<!--[if IE]>
    <script src="js/html5.js"></script>
<![endif]-->
<style>
body {
  background-color: #3498DB;
  overflow: hidden;
}

div {
  margin: 175px auto;
}

.drop {
  position: relative;
	width: 20px;
	height: 20px;
  top: -30px;
  margin: 0 auto;
	background: #FFF;
	-moz-border-radius: 20px;
	-webkit-border-radius: 20px;
	border-radius: 20px;
  -moz-animation-name: drip;
  -webkit-animation-name: drip;
  animation-name: drip;
  -moz-animation-timing-function: cubic-bezier(1,0,.91,.19);
  -webkit-animation-timing-function: cubic-bezier(1,0,.91,.19);
  animation-timing-function: cubic-bezier(1,0,.91,.19);
  -moz-animation-duration: 2s;
  -webkit-animation-duration: 2s;
  animation-duration: 2s;
  -moz-animation-iteration-count: infinite;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

.drop:before {
  content: "";
  position: absolute;
  width: 0;
	height: 0;
	border-left: 10px solid transparent;
	border-right: 10px solid transparent;
	border-bottom: 30px solid rgba(255,255,255,1);
  top: -22px;
}

.wave {
  position: relative;
  opacity: 0;
  top: 0;
	width: 2px;
	height: 1px;
  border: #FFF 7px solid;
	-moz-border-radius: 300px / 150px;
	-webkit-border-radius: 300px / 150px;
	border-radius: 300px / 150px;
  -moz-animation-name: ripple;
  -webkit-animation-name: ripple;
  animation-name: ripple;
  -moz-animation-delay: 2s;
  -webkit-animation-delay: 2s;
  animation-delay: 2s;
  -moz-animation-duration: 2s;
  -webkit-animation-duration: 2s;
  animation-duration: 2s;
  -moz-animation-iteration-count: infinite;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

.wave:after {
  content: "";
  position: absolute;
  opacity: 0;
  top: -5px;
  left: -5px;
	width: 2px;
	height: 1px;
  border: #FFF 5px solid;
	-moz-border-radius: 300px / 150px;
	-webkit-border-radius: 300px / 150px;
	border-radius: 300px / 150px;
  -moz-animation-name: ripple-2;
  -webkit-animation-name: ripple-2;
  animation-name: ripple-2;
  -moz-animation-duration: 2s;
  -webkit-animation-duration: 2s;
  animation-duration: 2s;
  -moz-animation-iteration-count: infinite;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

@keyframes ripple {
    from {
      opacity: 1;
    }
    to {
      width: 600px;
      height: 300px;
      border-width: 1px;
      top: -100px;
      opacity: 0;
    }
}

@keyframes ripple-2 {
    0% {
      opacity: 1;
    }
    50% {
      opacity: 0;
    }
  100% {
    width: 200px;
    height: 100px;
    border-width: 1px;
    top: 100px;
    left: 200px;
  }
}

@keyframes drip {
    to {
      top: 190px;
    }
}
</style>
<style>
body {
  margin-top: 180px;
  background-color: #112;
  background-color: #0c2d41;
  font-family: Roboto, 'helvetica neue', Helvetica, Arial, sans-serif;
}
.container {
  width: 800px;
  margin: auto;
}
.row {
  position: relative;
  height: 50px;
  z-index: 1;
  clear: both;
  margin-bottom: 30px;
  text-align: center;
}
.row--intro {
  padding-top: 20px;
  font-size: 16px;
  line-height: 28px;
  font-weight: 300;
  color: #fff;
  opacity: 0.4;
}
.row--intro span {
  font-size: 11px;
}
.skew-title {
  font-size: 25px;
}
.skew-title span {
  position: relative;
  display: inline-block;
  width: 40px;
  height: 50px;
  margin: auto;
  z-index: 2;
  text-align: center;
  color: #fff;
  font-family: 'roboto condensed';
  font-weight: 700;
  font-size: 35.714285714285715px;
  line-height: 50px;
  -webkit-transform: skewY(-15deg);
          transform: skewY(-15deg);
  -webkit-transform-origin: 0 100%;
          transform-origin: 0 100%;
  transition: all 0.2s;
  cursor: default;
}
.skew-title span:after,
.skew-title span:before {
  display: block;
  top: 0;
  left: 0;
  width: 40px;
  height: 50px;
  position: absolute;
  background: #185a81;
  content: ' ';
  z-index: -1;
  transition: all 0.2s;
}
.skew-title span:before {
  background: rgba(0,0,0,0.1);
  -webkit-transform: skewY(15deg);
          transform: skewY(15deg);
  -webkit-transform-origin: 0 0;
          transform-origin: 0 0;
}
.skew-title span:nth-child(even) {
  background-color: #144c6e;
  -webkit-transform: skewY(15deg);
          transform: skewY(15deg);
  -webkit-transform-origin: 100% 100%;
          transform-origin: 100% 100%;
  color: #d9d9d9;
}
.skew-title span:nth-child(even):after {
  background-color: #144c6e;
}
.skew-title span:nth-child(even):before {
  -webkit-transform-origin: 100% 0;
          transform-origin: 100% 0;
  -webkit-transform: skewY(-15deg);
          transform: skewY(-15deg);
}
.skew-title span.flat {
  -webkit-transform: skewY(0);
          transform: skewY(0);
  color: #fff;
}
.skew-title span.flat:before {
  -webkit-transform: skewY(0);
          transform: skewY(0);
}
.skew-title span.flat:nth-child(even):after {
  background-color: #185a81;
}
.skew-title span.alt:after {
  background-color: #b94a2c;
}
.skew-title span.alt:nth-child(even):after {
  background-color: #9d3f25;
}
.skew-title span.alt.flat:nth-child(even):after {
  background-color: #b94a2c;
}
</style>
</head>

<body>	


<div class="message">

  <h1 class="row skew-title">  
  
    <span>花</span><span>卉</span><span>识</span><span>别</span><span>系</span><span>统</span>
  </h1>

	<form method="post" action="${pageContext.request.contextPath}/getfile" enctype="multipart/form-data">
		<input type="text" id="txt" name="txt" class="input" value="文件域" disabled="disabled"  style="width: 1000px;background-color:grey;"/>
		<input type="button" onMouseMove="f.style.pixelLeft=event.x-60;f.style.pixelTop=this.offsetTop;" value="选择文件" size="30" onClick="f.click()" class="liulan">
		
		<input type="file" id="f" onChange="txt.value=this.value" name="upload" style="height:26px;" class="files"  size="1" hidefocus>
		<input class="liulan" type="submit" value="点击上传" "/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>

</div>

  <p class="row row--intro">基于深度学习以及socket应用的实现</p>



<script type="text/javascript">
(function() {
  // We must use JS as we need to select previous
  // elements which can't be done with CSS.
  $('.skew-title').children('span').hover((function() {
    var $el, n;
    $el = $(this);
    n = $el.index() + 1;
    $el.addClass('flat');
    if (n % 2 === 0) {
      return $el.prev().addClass('flat');
    } else {
      if (!$el.hasClass('last')) {
        return $el.next().addClass('flat');
      }
    }
  }), function() {
    return $('.flat').removeClass('flat');
  });

}).call(this);
</script>


  <br />
	<div class="drop"></div>
<div class="wave"></div>

</body>
</html>
