<style type="text/css"> 
#scroll-right-2-left{height:30px;overflow:hidden;line-height:30px}
#scroll_div a{color:#999}
#scroll_begin{color:#999}
#scroll_div a:hover{text-descoration:none;}
.scroll-news-block-title{width:30px;height:30px;position:absolute;margin:5px 0px 0px -30px;background:url("/global/images/gonggao.png") no-repeat;background-size:20px;}
</style> 
<script type="text/javascript"> 
function ScrollImgLeft(){ 
	var speed=50; 
	var scroll_begin = document.getElementById("scroll_begin"); 
	var scroll_end = document.getElementById("scroll_end"); 
	var scroll_div = document.getElementById("scroll_div"); 
	scroll_end.innerHTML=scroll_begin.innerHTML; 
	
	function Marquee(){ 
		if(scroll_end.offsetWidth-scroll_div.scrollLeft<=0) 
			scroll_div.scrollLeft-=scroll_begin.offsetWidth; 
		else 
			scroll_div.scrollLeft++; 
	} 
	
	var MyMar=setInterval(Marquee,speed); 
	
	scroll_div.onmouseover=function() {
		clearInterval(MyMar);
	} 
	
	scroll_div.onmouseout=function() {
		MyMar=setInterval(Marquee,speed);
	} 
} 
</script>
<div style="width:900px;margin:auto">
	<div class="scroll-news-block-title"></div>
	<div id="scroll-right-2-left">
		<div id="scroll_div" style="width:900px;height:30px;white-space:nowrap;overflow:hidden;margin:auto">
			<div id="scroll_begin"> 
				<#list map.newsList as news>
					【<a href="/news/details.htm?newsid=${news.newsid}">${news.title}</a>】
				</#list> 
			</div> 
			<div id="scroll_end"></div> 
		</div> 
	</div>
</div>
<script type="text/javascript">ScrollImgLeft();</script>