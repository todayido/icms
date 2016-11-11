<div class="top">
	<div class="top" style="width:1000px;">
		<div class="nva">
			<ul>
				<li><a href="/main.htm">首页</a></li>
				<li><a href="/new.htm">新手必看</a></li>
				<li><a href="/related.htm">相关文档</a></li>
                <li><a href="/news.htm">本站资讯</a></li>
                <li><a href="/about.htm">关于我们</a></li>
			</ul>
		</div>
		<div class="online-service">
			<ul>
				<li><a href="">在线咨询</a></li>
			</ul>
		</div>
		<div class="nva" style="float:right">
			<ul>
				<#if userModel?exists>
				<li><a style="color:#FFF">欢迎：${userModel.user_alias}</a></li>
				<#if payModel?exists>
				<li><a style="color:#FFF">金额：${payModel.user_jine}  冻结：${payModel.user_dongjie}</a></li>
				</#if>
				<li><a href="/login/logout.htm">退出</a></li>
				<#else>
				<li><a href="/login/login.htm">登陆</a></li>
				<li><a href="/register/register.htm">注册</a></li>
				</#if>
			</ul>
		</div>
	</div>
</div>
