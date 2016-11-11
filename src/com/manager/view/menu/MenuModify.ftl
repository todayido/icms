<form action="/menu/menuModifySubmit.htm" method="post">
    <input type="hidden" name="menuid" value="${menu.menuid}"/> 
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">菜单名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="menuname" value="${menu.menuname}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">菜单URL</td>   
	        <td><input class="easyui-validatebox" type="text" name="resource" value="${menu.menuurl}" data-options="required:true"/><a class="info-tips">*</a></td>    
	    </tr>
	    <tr>
	        <td class="right">是否有子菜单</td>   
	        <td><select name="hasnext" id="hasnext">
	        	<#list DictionaryService.getDicList('yes_or_no') as status>
	        		<option value="${status.dic_key}" <#if '${menu.hasnext}'=='${status.dic_key}'>selected=selected</#if>>${status.dic_value}</option>
	        	</#list>
	        </select></td>   
	    </tr>
	    <tr>
	        <td class="right">是否显示</td>   
	        <td><select name="status" id="status">
	        	<#list DictionaryService.getDicList('yes_or_no') as status>
	        		<option value="${status.dic_key}" <#if '${menu.display}'=='${status.dic_key}'>selected=selected</#if>>${status.dic_value}</option>
	        	</#list>
	        </select></td>   
	    </tr>
	    <tr>
	        <td class="right">排序字段</td>   
	        <td><input class="easyui-validatebox" type="text" name="priority" validType="number" value="${menu.priority}"/>（升序）</td>   
	    </tr>
	 </table>
</form>