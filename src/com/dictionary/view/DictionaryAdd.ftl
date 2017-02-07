<form action="/dictionary/dictionaryAddSubmit.htm" method="post">
	<table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">字典名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_name" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">键</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_key" validType="number" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">值</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_value" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description"/></td>
	    </tr>
	</table>
</form>