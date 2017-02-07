<form action="/menuPermission/menuPermissionAddSubmit.htm" method="post">
    <input type="hidden" name="parent_id" value="${parent_id}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">权限名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="permission_name" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">资源(动作URI)</td>   
	        <td><input class="easyui-validatebox" type="text" name="resource" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description"/></td>
	    </tr>
	</table>
</form>