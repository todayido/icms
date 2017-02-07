<form action="/role/roleModifySubmit.htm" method="post">
    <input type="hidden" name="role_id" value="${role.role_id}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">角色名</td>   
	        <td><input class="easyui-validatebox" type="text" name="role_name" value="${role.role_name}" data-options="required:true"/><a class="info-tips">*</a></td> 
	    </tr>
	    <tr>
	        <td  class="right">角色描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${role.description}" data-options="required:true"/><a class="info-tips">*</a></td> 
	    </tr>
	    <tr>
	        <td  class="right">优先级排序字段</td>   
	        <td><input class="easyui-validatebox" type="text" name="priority"validType="number" value="${role.priority}"/></td>
	    </tr>
	</table>
</form>