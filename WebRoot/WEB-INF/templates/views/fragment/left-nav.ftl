<div id="left-nav" class="menu_list">
	<div class="menu_head current" style="border-top:1px solid #E1E1E1">任务工单</div>
	<div style="display:block" class="menu_body">
		<a href="/item/itemBlock.htm">任务中心</a>
		<a href="/item/itemPublish.htm">我要发单</a>
		<a href="#">我发布的任务</a>
		<a href="#">代办任务</a>
		<a href="#">已完成的任务</a>
	</div>
	<div class="menu_head current menu_top">会员中心</div>
	<div style="display:block" class="menu_body">
		<a href="/member/memberInfo.htm">基本信息</a>
		<a href="/member/modifyPass.htm">密码修改</a>
		<a href="/member/modifyPass.htm">投诉建议</a>
	</div>
	<div class="menu_head current">充值交易</div>
	<div style="display:none" class="menu_body left-nav-bottom">
		<a href="/pay/zhifubao.htm">支付宝充值</a>
		<a href="/weixin.htm">微信支付</a>
		<a href="/unionpay.htm">银联在线</a>
		<a href="/pay/withdraw.htm">提现</a>
	</div>
</div>
<script>
$(document).ready(function(){
	$("#left-nav .menu_body").show();
	$("#left-nav div.menu_head").click(function(){
		$(this).toggleClass("current").next("div.menu_body").slideToggle();
	});
});
</script>
