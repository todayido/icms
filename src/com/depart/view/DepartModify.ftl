<form action="/depart/departModifySubmit.htm" method="post">
    <input type="hidden" name="depart_id" value="${depart.depart_id}"/>
    <input type="hidden" name="parent_id" value="${depart.parent_id}"/>
    <table class="gridtable" cellspacing='1'>
    	<tr>
        	<td width="25%" class="right">部门名称</td>   
        	<td class="left"><input class="easyui-validatebox" data-options="required:true" missingMessage="必填选项" type="text" name="name" value="${depart.name}"/><span class="info-tips">*</span></td>
        </tr>
    	<tr>
	        <td class="right">部门编号</td>   
	        <td class="left"><input class="easyui-validatebox" data-options="required:true" missingMessage="必填选项" type="text" name="number" value="${depart.number}"/><span class="info-tips">*</span></td>
    	</tr>
    	<tr>
	        <td class="right">是否有子部门</td>
	        <td> 
	        <select name="has_next">
	        	<#list DictionaryService.getDicList('yes_or_no') as status>
	        		<option value="${status.dic_key}" <#if '${depart.has_next}'=='${status.dic_key}'>selected=selected</#if>>${status.dic_value}</option>
	        	</#list>
	        </select>
	        </td>
	    </tr>
    	<tr>
        	<td class="right">优先级排序字段</td>   
        	<td><input class="easyui-validatebox" data-options="required:true,validType:'number'" missingMessage="必填选项" type="text" name="priority" value="${depart.priority}"/><span class="info-tips">*</span>（降序排序，数值越大越靠上）</td>
    	</tr>
    	<tr>
	        <td class="right">是否有效</td>   
	        <td>
	        	<select name="is_show">
	        	<#list DictionaryService.getDicList('yes_or_no') as status>
	        		<option value="${status.dic_key}" <#if '${depart.is_show}'=='${status.dic_key}'>selected=selected</#if>>${status.dic_value}</option>
	        	</#list>
	        	</select>
	        </td>
	      </tr>
	   </tr>
    </table>
</form>