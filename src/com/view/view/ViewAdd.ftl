<form action="/view/viewAddSubmit.htm" method="post">
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">视图名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="viewname" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">视图类型</td>   
	        <td><select name="viewtype">
	        	<#list DictionaryService.getDicList('view_type') as viewtype>
	        		<option value="${viewtype.dic_value}">${viewtype.dic_value}</option>
	        	</#list>
	        </select></td>
	    </tr>
	    <tr>
	        <td class="right">视图描述</td>
	        <td><input class="easyui-validatebox" type="text" name="description"/></td> 
	    </tr>
    </table>
</form>