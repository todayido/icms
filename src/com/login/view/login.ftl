
<link rel="stylesheet" type="text/css" href="/global/styles/sg-login-1.0.css" />
<div class="login">用户登录</div><br>
<div class="ours"></div>
<div style="width:300px;margin:auto;">
 <form action="/login/doLogin.htm<#if map?exists>?redirectUrl2=${map.redirectUrl?default('')}<#else>?redirectUrl=${redirectUrl?default('')}</#if>" method="post">
  <#if map?exists>
	 <div style="margin-left:20px;">
		<span style="color:red">${map.messages?default('')}</span> 
	 </div>
  </#if>
  <div class="div-form-item">
   	  <label class="icon-username"></label>
	  <input type="text" id="user_name" name="user_name" placeholder="用户名" maxlength="29" class="login-text" tabindex="1" value="<#if map?exists>${map.user_name?default('')}</#if>"/>    
  </div>
  <div class="div-form-item">
  	   <label class="icon-password"></label>
	   <input type="password" id="password" name="password" placeholder="密码" maxlength="35" class="login-text" tabindex="2">
  </div>
  <div class="div-form-item">
	   <input type="submit" value="立即登陆" class="button-width-280 red01" tabindex="3">
	   <input type="button" value="没有账号，移步注册" class="button-width-280 red01" tabindex="4" style="margin-top:10px;" onclick="javascrtpt:window.location.href='/register/register.htm'">
  </div>
  <div class="div-form-item">
	<input type="checkbox"> 记住我</input>
	<a href="javascript:void(0);" style="margin-left:50px;">忘记密码？</a>
  </div>
 </form>
</div>
