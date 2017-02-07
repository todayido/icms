<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台登录...</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<link rel="stylesheet" type="text/css" href="/global/styles/sg-login-1.0.css" />
  </head>
  <script type="text/javascript">
  	function AddFavorite(sURL, sTitle)
	{
	    try
	    {
	        window.external.addFavorite(sURL, sTitle);
	    }
	    catch (e)
	    {
	        try
	        {
	            window.sidebar.addPanel(sTitle, sURL, "");
	        }
	        catch (e)
	        {
	            alert("加入收藏失败，请使用Ctrl+D进行添加");
	        }
	    }
	}
	function SetHome(obj,url){
        try{
        	obj.style.behavior='url(#default#homepage)';
        	obj.setHomePage(url);
        }catch(e){     if(window.netscape){      try{
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");     
                 }catch(e){        
        alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'"); 
             }  
           }else{     alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+url+"】设置为首页。");     }  } 
	}
  </script>
<body>
<div class="login-div-top">
	<span class="left"> 
		<span><a href="javascript:void(0);" onclick="SetHome(this,window.location)">设为首页</a></span>
		<span class="seq">|</span>
		<span><a href="javascript:void(0);" onclick="AddFavorite(window.location,document.title)">加入收藏</a></span>
	</span>
	<span class="right">
		<span><a href="/login/doManageLogin.htm">登录</a></span>
		<span class="seq">|</span>
		<span><a href="javascript:void(0);">注册</a></span>
	</span>
</div>

<div class="ours">
	<h1>一切为了你！</h1>
	<h3>——————  Ours For You.</h3>
</div>

<div style="width:300px;margin:auto;">
 <form action="/login/doManageLogin.htm" method="post">
  <#if map?exists>
	 <div style="margin-left:20px;">
		<span style="color:red">${map.messages?default('')}</span> 
	 </div>
  </#if>
  <div class="div-form-item">
   	  <label class="icon-username"></label>
	  <input type="text" id="username" name="username" placeholder="用户名" maxlength="29" class="login-text" tabindex="1" value="<#if map?exists>${map.username?default('')}</#if>"/>    
  </div>
  <div class="div-form-item">
  	   <label class="icon-password"></label>
	   <input type="password" id="password" name="password" placeholder="密码" maxlength="35" class="login-text" tabindex="2">    
  </div>
  <div class="div-form-item">
	   <a href="javscript:void(0);">忘记密码？</a>
	   <a href="/register/Register_pageList.do" style="margin-left:50px;">立即注册</a>
  </div>
  <div class="div-form-item">
	   <input type="submit" value="立即登陆" class="button-width-280 blue" tabindex="3"> 
  </div>
 </form>
</div>
<div class="copyright">版权所有 ©ours4u 2015</div>
</body>
</html>