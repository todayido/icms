<form action="/menu/menuAddSubmit.htm" method="post">
	<input class="easyui-validatebox" type="hidden" name="parentid" value="${parentid}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td width="25%" class="right">菜单名称</span>   
	        <td><input class="easyui-validatebox" type="text" name="menuname" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">菜单URI</td>   
	        <td><input class="easyui-validatebox" type="text" name="menuurl" data-options="required:true"/><a class="info-tips">*</a></td> 
	    </tr>
	</table>
</form>