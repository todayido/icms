<!DOCTYPE HTML>
<html>
  <head>
    <title>主页</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <script src="/global/scripts/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/global/styles/ours4u-1.0.css">
  </head>
<body>
<@block component='fragment' action_id='fragmentBlock' block_id='5' description="首页导航"/>
<@block component='fragment' action_id='fragmentBlock' block_id='2' description="首页顶部banner"/>
<div style="width:1000px;margin:5px auto">
   	<div>
   		${content}
   	</div>
</div>
<@block component='fragment' action_id='fragmentBlock' block_id='9' description="返回顶部" />
<@block component='fragment' action_id='fragmentBlock' block_id='4' description="首页bottom版权信息"/>
</body>
</html>