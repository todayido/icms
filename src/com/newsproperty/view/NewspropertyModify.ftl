<form action="/newsproperty/newspropertyModifySubmit.htm" method="post">
    <input type="hidden" name="blockid" value="${newsproperty.blockid}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">栏目标题</td>   
	        <td><input class="easyui-validatebox" type="text" name="title" value="${newsproperty.title}" data-options="required:true"/><a class="info-tips">*</a></td>   
	    </tr>
	    <tr>
	        <td class="right">首页显示条数</td>   
	        <td><input class="easyui-validatebox" type="text" name="blockpage" validType="number" value="${newsproperty.blockpage}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">列表显示条数</td>   
	        <td><input class="easyui-validatebox" type="text" name="listpage" validType="number" value="${newsproperty.listpage}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">是否允许评论</td>   
	        <td><select name="iscomments">
	        	<#list DictionaryService.getDicList('yes_or_no') as yes_or_no>
	        		<option value="${yes_or_no.dic_key}" <#if '${newsproperty.iscomments}'=='${yes_or_no.dic_key}'>selected</#if>>${yes_or_no.dic_value}</option>
	        	</#list></td></td>
	    </tr>
	    <tr>
	        <td class="right">栏目描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${newsproperty.description}"/></td>
	    </tr>
</form>