<script>
//组织机构选择
function choseDepartUserModify(){
	$('#deptSelectDlgForUserModifyFrame')[0].src = '/depart/departTreeIndex.htm';
	$("#deptSelectDlgForUserModify").dialog({
		 title:'请选择',
		 height: 400,
		 width:350,
      	 modal: true,
	     cache: false,    
	     maximizable:true,
	     resizable:true
	});
}

function returnValue(nodes){
	$("#deptSelectDlgForUserModify").dialog('close');
	$('#dept_idUserModify').val(nodes[0].id);
	$('#dept_nameUserModify').val(nodes[0].name);
}
</script>
<form action="/user/userModifySubmit.htm" method="post">
    <input type="hidden" name="user_id" value="${userMap.USER_ID}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td  class="right">账号</td>   
	        <td><input readonly="readonly" class="readonly" value="${userMap.USER_NAME}"/></td> 
	        <td class="right">姓名</td>
	        <td><input class="easyui-validatebox" type="text" name="user_alias" value="${userMap.USER_ALIAS?default('')}" data-options="required:true" missingMessage="不能为空"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">部门</td>   
	        <td><input style="float:left;" class="easyui-validatebox readonly" readonly="readonly" type="text" id="dept_nameUserModify" name="depart_name" value="${userMap.DEPART_NAME?default('')}"/>
		        <a href="javascript:void(0)" onclick="choseDepartUserModify()" class="icon-select"></a>
		        <input class="easyui-validatebox" type="hidden" id="dept_idUserModify" name="depart_id" value="${userMap.DEPART_ID?default('')}"/>
	        <td class="right">职务</td>   
	        <td><select name="duty_id" id="duty_id">
	        	<option value="">请选择</option>
	        	<#list DictionaryService.getDicList('duty_type') as duty>
	        		<option value="${duty.dic_key}" <#if '${userMap.DUTY_ID}'=='${duty.dic_key}'>selected=selected</#if>>${duty.dic_value}</option>
	        	</#list>
	        	</select>
	        </td>
	    </tr>
	    <tr>
	        <td class="right">邮箱</td>   
	        <td><input class="easyui-validatebox" type="text" name="email" value="${userMap.EMAIL?default('')}" data-options="required:true" missingMessage="不能为空"/><a class="info-tips">*</a></td>
	        <td class="right">qq号</td>   
	        <td><input class="easyui-validatebox" type="text" name="qq_number" value="${userMap.QQ_NUMBER?default('')}"/></td>
	    </tr>
	    <tr>
	        <td class="right">手机号</td>   
	        <td><input class="easyui-validatebox" type="text" name="phone" value="${userMap.PHONE?default('')}" data-options="required:true" missingMessage="不能为空"/><a class="info-tips">*</a></td>
	        <td class="right">状态</td>   
	        <td><select name="status" id="status">
	        	<#list DictionaryService.getDicList('user_state') as status>
	        		<option value="${status.dic_key}" <#if '${userMap.STATUS}'=='${status.dic_key}'>selected=selected</#if>>${status.dic_value}</option>
	        	</#list>
	        	</select></td>
	    </tr>
	    <tr>
	        <td class="right">安全问题</td>   
	        <td><select name="question" id="question">
		        <option value="">请选择</option>
	        	<#list DictionaryService.getDicList('security_question') as question>
	        		<option value="${question.dic_key}" <#if '${userMap.QUESTION}'=='${question.dic_key}'>selected=selected</#if>>${question.dic_value}</option>
	        	</#list>
	        </select></td>
	        <td class="right">安全问题答案</td>   
	        <td><input class="easyui-validatebox" type="text" name="answer" value="${userMap.ANSWER}"/></td>
	    </tr>
	</table>
</form>
<div id="deptSelectDlgForUserModify">
	<iframe scrolling="auto" id="deptSelectDlgForUserModifyFrame" frameborder="0"  src="" style="width:100%;height:100%;">
</div>