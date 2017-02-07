<!DOCTYPE HTML>
<html>
  <head>
    <title>银联支付</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <link href="/global/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/global/bootstrap-3.3.5/css/bootstrapValidator.css"/>
	<script src="/global/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/global/bootstrap-3.3.5/js/bootstrapValidator.js"></script>
    <script src="/global/scripts/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/global/styles/ours4u-1.0.css">
    <link rel="stylesheet" type="text/css" href="/global/styles/ours4u-item.1.0.css">
  </head>
<body>
<@block component='fragment' action_id='fragmentBlock' block_id='5' description="首页导航"/>
<@block component='fragment' action_id='fragmentBlock' block_id='2' description="首页顶部banner"/>
<div style="margin-top:-30px;">
<@block component='news' action_id='block' block_id='1' view_id="templates/views/news/news-scroll-right-to-left.ftl" description="水平滚动新闻"/>
</div>
<div style="width:1000px;margin:10px auto">
	<div style="width:77%;float:right;margin:8px;">
			<div class="content-title">
				<span> 微信支付</span>
			</div>
			<div>暂不支持微信支付</div>
	   	</div>
	   	<div style="width:20%;float:left;margin:5px;">
	   		<div>
				<@block component='fragment' action_id='fragmentBlock' block_id='11' description="左侧导航"/>
	        </div> 
	   	</div>
	</div>
</div>
<@block component='fragment' action_id='fragmentBlock' block_id='9' description="返回顶部" />
<@block component='fragment' action_id='fragmentBlock' block_id='4' description="首页bottom版权信息"/>
</body>
</html>
