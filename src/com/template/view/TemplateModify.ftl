<form action="/template/templateModifySubmit.htm" method="post">
    <input type="hidden" name="templateid" value="${template.templateid}"/>
    <table class="gridtable" cellspacing='1'>
    	<tr>
	        <td class="right">模板名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="templatename" value="${template.templatename}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">是否默认</td>
	        <td><select name="isdefault">
	        	<#list DictionaryService.getDicList('template_default') as template_default>
	        		<option value="${template_default.dic_key}" <#if '${template.isdefault}'=='${template_default.dic_key}'>selected=selected</#if> >${template_default.dic_value}</option>
	        	</#list>
	        </select></td>
	    </tr>
	    <tr>
	        <td class="right">模板描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${template.description}"/></td>
	    </tr>
	</table>
</form>