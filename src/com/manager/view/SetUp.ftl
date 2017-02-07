<script>
<#-- 用户信息修改 -->
function modifyUserInfo(){
	var $form = $("#userForm");
	$form.form('submit',{
		url:$form.action,
		success:function(data){
			if(data>0){
				$.messager.alert('提示','已经修改！','');
			}else{
				$.messager.alert('提示','信息修改失败，请联系管理员！','');  
			}
		}
	});
}
<#-- 密码修改 -->
function modifyPassword(){
	var $form = $("#passwordForm");
	$form.form('submit',{
		url:$form.action,
		success:function(data){
			if(data=='-1'){
				$.messager.alert('提示','旧密码不正确！','');
			}else if(data=='0'){
				$.messager.alert('提示','密码修改失败，请联系管理员！','');  
			}else{
				$.messager.alert('提示','密码修改成功！','');
			}
		}
	});
}
	
</script>
<div class="easyui-tabs" style="border:0px;">
	<div title="账号信息">
		<form id="userForm" action="/user/modifyUserInfo.htm" method="post">
		<table class="gridtable" cellspacing="1">
	        <tr>
	            <td width="30%"><span class="right">登录账号</span></td>
	            <td colspan="3"><span class="left">${user.user_name}</span></td>
	        </tr>
	        <tr>
	            <td><span class="right">用户名称</span></td>
	            <td colspan="3"><input name="user_alias" id="user_alias" class="easyui-validatebox" type="text" data-options="required:true" missingMessage="不能为空" value="${user.user_alias}"/><span class="info-tips">*</span></td>
	        </tr>
	        <tr>
	            <td><span class="right">Email账号</span></td>
	            <td colspan="3"><input name="email" class="easyui-validatebox" type="text" value="${user.email}"/></td>
	        </tr>
	        <tr>
	            <td><span class="right">联系方式</span></td>
	            <td><input name="phone" class="easyui-validatebox" type="text" value="${user.phone?default('')}"/></td>
	        </tr>
	        <tr>
	            <td><span class="right">QQ账号</span></td>
	            <td colspan="3"><span class="left"><input name="qq_number" class="easyui-validatebox" type="text" value="${user.qq_number}"/></span></td>
	        </tr>
	    </table>
	    <div style="text-align:center;width:95%">
	    <a class="search-btn" style="margin:10px;" href="javascript:void(0);" onclick="modifyUserInfo()">确认修改</a>
	    <a class="search-btn" style="margin:10px;" href="javascript:void(0);" onclick="javascript:$('#userForm').clearForm()">重新输入</a>
	    </div>
		</form>
	</div>
	<div title="密码修改" style="text-align:center">
		<form id="passwordForm" action="/user/modifyPassword.htm" method="post">
		<table class="gridtable" cellspacing="1">
	        <tr>
	            <td width="30%"><span class="right">旧密码</span></td>
	            <td colspan="3"><input name="oldPassword" class="easyui-validatebox" type="password" data-options="required:true" missingMessage="不能为空"/><span class="info-tips">*</span></td>
	        </tr>
	        <tr>
	            <td><span class="right">新密码</span></td>
	            <td colspan="3"><input name="newPassword" class="easyui-validatebox" type="password" data-options="required:true" missingMessage="不能为空"/><span class="info-tips">*</span></td>
	        </tr>
	        <tr>
	            <td><span class="right">确认新密码</span></td>
	            <td colspan="3"><input name="checkPassword" class="easyui-validatebox" type="password" data-options="required:true" missingMessage="不能为空"/><span class="info-tips">*</span></td>
	        </tr>
	    </table>
	    <div style="text-align:center;width:95%">
		    <a class="search-btn" style="margin:10px;" href="javascript:void(0);" onclick="modifyPassword()">修改密码</a>
		    <a class="search-btn" style="margin:10px;" href="javascript:void(0);" onclick="javascript:$('#passwordForm').clearForm()">重新输入</a>
		</div>
		</form>
	</div>
</div> 
