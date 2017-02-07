<form action="/dictionary/dictionaryModifySubmit.htm" method="post">
    <input type="hidden" name="dic_id" value="${dictionary.dic_id}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">字典名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_name" value="${dictionary.dic_name}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">键</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_key" validType="number" value="${dictionary.dic_key}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">值</td>   
	        <td><input class="easyui-validatebox" type="text" name="dic_value" value="${dictionary.dic_value}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${dictionary.description}"/></td>
	    </tr>
	</table>
</form>