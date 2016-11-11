<form action="/permission/permissionAddSubmit.htm" method="post">
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td width="25%" class="right">权限名称</td>   
	        <td><input class="easyui-validatebox" data-options="required:true" type="text" name="permission_name"/><span class="info-tips">*</span></td> 
	    </tr>
	    <tr>
	        <td class="right">资源(动作URI)</td>   
	        <td><input class="easyui-validatebox" data-options="required:true" type="text" name="resource"/><span class="info-tips">*</span></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description"/></td>
	    </tr>
	</table>
</form>