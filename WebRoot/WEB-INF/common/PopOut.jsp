<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script>
function Pop_Out_Close(){
	$('.pop-out-mask').hide();
	$('.pop-out').hide();
	$("#iframePop").attr("src","");
}
function Pop_Out(title,toUrl,popWidth,popHeight){
	//$('.pop-out-mask').fadeIn(100);
	//$('.pop-out').slideDown(200);
	$('.pop-out-mask').show();
	$('.pop-out').show();
	$('.pop-tips .title').html(title);
	$("#iframePop").attr("height",popHeight-36);
	$('.pop-out').css("width",popWidth).css("height",popHeight);
	$('.pop-out').css("margin-left",-popWidth/2).css("margin-top",-popHeight/2);
	$("#iframePop").attr("src",toUrl);
}
</script>
<style>
a{
	text-decoration:none}
.pop-out-mask {
	z-index: 9998;
	position:fixed;
	top:0;
	left:0;
	width:100%;
	height:100%;
	background:#666;
	opacity:0.4;
	filter:alpha(opacity=50);
	display:none
}
.pop-out {
	z-index:9999;
	position:fixed;
	top:50%;
	left:50%;
	border-radius:5px;
	border:solid 5px #666;
	background-color:#fff;
	display:none;
}
.pop-tips{
	height:35px;
	line-height:35px;
	border-bottom:solid #DEDEDE 1px;}
.pop-tips .title{
	margin-left:8px;
}
.pop-tips .close {
	float:right;
	color:#CCC;
	margin:5px 5px;
	height:20px;
	width:20px;
	text-align:center;
	line-height:20px;
	font:bold 14px/14px;
	text-shadow:0 1px 0 #CCC;
}
.pop-tips .close:hover {
	color:#666;
}
</style>
<div class="pop-out">
     <div class="pop-tips">
     	  <span class="title"></span>
          <a href="javascript:;" class="close" onclick="Pop_Out_Close('iframePop')">×</a>
     </div>
	<iframe id="iframePop" src="" width="100%" scrolling="no" frameborder="0"></iframe>
</div>
<div class="pop-out-mask"></div>