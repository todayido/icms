<form action="/menuPermission/menuPermissionModifySubmit.htm" method="post">
    <input type="hidden" name="permission_id" value="${menuPermission.permission_id}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">权限名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="permission_name" value="${menuPermission.permission_name}" data-options="required:true"/><a class="info-tips">*</a></td> 
	    </tr>
	    <tr>
	        <td class="right">资源(动作URI)</td>   
	        <td><input class="easyui-validatebox" type="text" name="resource" value="${menuPermission.resource}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${menuPermission.description}"/></td>
	    </tr>
	    <tr>
	        <td class="right">排序字段</td>   
	        <td><input class="easyui-validatebox" type="text" name="priority" value="${menuPermission.priority}" validType="number"/>（升序）</td>   
	    </tr>
	</table>
</form>