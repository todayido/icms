<form action="/template/templateAddSubmit.htm" method="post">
	<table class="gridtable" cellspacing='1'>
    <tr>
        <td class="right">模板名称</td>   
        <td><input class="easyui-validatebox" type="text" name="templatename" data-options="required:true"/><a class="info-tips">*</a></td>
    </tr>
    <tr>
        <td class="right">是否默认</td>
        <td><select name="isdefault">
        	<#list DictionaryService.getDicList('template_default') as template_default>
        		<option value="${template_default.dic_key}" <#if '${template_default.dic_key}'=='0'>selected=selected</#if> >${template_default.dic_value}</option>
        	</#list>
        </select></td>
    </tr>
    <tr>
        <td class="right">模板描述</td>   
        <td><input class="easyui-validatebox" type="text" name="description"/></td> 
    </tr>
</form>