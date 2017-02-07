<div class="member-title">欢迎 ${member.user_name} 先生/女士</div>
<div class="member-info">
	<ul>
		<li>真实姓名：${member.user_alias?default('')}</li>
		<li>手机号码：${member.phone?default('')}</li>
		<li>注册邮箱：${member.email?default('')}</li>
		<li>上次登陆：${member.last_login_time?datetime}</li>
	</ul>
</div>
<div class="div-dashed"></div>
<div class="member-title">安全设置 <span style="font-size:14px;color:#CCC"> 绑定多个账号，账号更安全</span></div>
<div class="member-info">
	<ul>
		<li>手机号码：<#if member.phone?exists && member.phone!=''><a href=""> 修改 </a><#else><a href=""> 未设置</a></#if></li>
		<li>注册邮箱：<#if member.email?exists && member.email!=''>${member.email} <a href=""> 修改 </a><#else><a href=""> 未设置</a></#if></li>
	</ul>
</div>