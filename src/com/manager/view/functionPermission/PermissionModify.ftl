<form action="/permission/permissionModifySubmit.htm" method="post">
    <input type="hidden" name="permission_id" value="${permission.permission_id}"/>
    <table class="gridtable" cellspacing='1'>
    	<tr>
        	<td width="25%" class="right">权限名称</td>
        	<td><input class="easyui-validatebox" data-options="required:true" missingMessage="必填选项" type="text" name="permission_name" value="${permission.permission_name}"/><span class="info-tips">*</span></td> 
    	</tr>
	    <tr>
	        <td class="right">资源(动作URI)</td>
	        <td><input class="easyui-validatebox" data-options="required:true" missingMessage="必填选项" type="text" name="resource" value="${permission.resource}"/><span class="info-tips">*</span></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${permission.description}"/></td>
	    </tr>
    </table>
</form>