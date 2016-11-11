<script>
function choseDepartUserAdd(){
	$("#deptSelectDlgForUserAddFrame")[0].src = '/depart/departTreeIndex.htm';
	$("#deptSelectDlgForUserAdd").dialog({
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
	$("#deptSelectDlgForUserAdd").dialog('close');
	$('#dept_idUserAdd').val(nodes[0].id);
	$('#dept_nameUserAdd').val(nodes[0].name);
}
</script>
<form action="/user/userAddSubmit.htm" method="post">
    <table class="gridtable" cellspacing='1'>
    	<tr>
	        <td class="right">登录账号</td>   
	        <td><input class="easyui-validatebox" data-options="required:true" missingMessage="不能为空" type="text" name="user_name" placeholder="提交后不能修改"/><a class="info-tips">*</a></td>
	        <td class="right">姓名</td>   
	        <td><input class="easyui-validatebox" data-options="required:true" missingMessage="不能为空" type="text" name="user_alias"/><a class="info-tips">*</a></td> 
	    </tr>
	    <tr>
	        <td class="right">密码</td>   
	        <td><input class="easyui-validatebox" type="password" id="password" name="password" data-options="required:true" missingMessage="不能为空"/><a class="info-tips">*</a></td>
	        <td class="right">确认密码</td>   
	        <td><input class="easyui-validatebox" type="password" name="password2" data-options="required:true" validType="equalTo['#password']" missingMessage="不能为空"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">所属组织机构</td>   
	        <td><input class="easyui-validatebox" type="hidden" id="dept_idUserAdd" name="depart_id"/>
		    	<input style="float:left;" type="text" id="dept_nameUserAdd" name="depart_name" readonly="readonly" class="readonly" data-options="required:true" missingMessage="不能为空"/>
		    	<a href="javascript:void(0)" onclick="choseDepartUserAdd()" class="icon-select"></a></td>
	        <td class="right">职务</td>   
	        <td>
		        <select name="duty_id" id="duty_id">
		        	<option value="">请选择</option>
		        	<#list DictionaryService.getDicList('duty_type') as duty>
		        		<option value="${duty.dic_key}">${duty.dic_value}</option>
		        	</#list>
		        </select>
	        </td>
	    </tr>
	    <tr>
	        <td class="right">邮箱</td>
	        <td><input class="easyui-validatebox" data-options="required:true" missingMessage="不能为空" type="text" name="email"/><a class="info-tips">*</a></td>
	        <td class="right">QQ号</td>   
	        <td><input class="easyui-validatebox" type="text" name="qq_number"/></td>
	    </tr>
	    <tr>
	        <td class="right">手机号</td>   
	        <td colspan="3"><input class="easyui-validatebox" data-options="required:true" missingMessage="不能为空" type="text" name="phone"/><a class="info-tips">*</a>	</td>
	    </tr>
	    <tr>
	    	<td class="right">安全问题</td>
	        <td> 
		        <select name="question" id="question">
			        <option value="">请选择</option>
		        	<#list DictionaryService.getDicList('security_question') as question>
		        		<option value="${question.dic_key}">${question.dic_value}</option>
		        	</#list>
		        </select>
	        </td>
	        <td class="right">安全问题答案</td>   
	        <td><input class="easyui-validatebox" type="text" name="answer"/></td>
	    </tr>
	</table>
</form>
<div id="deptSelectDlgForUserAdd">
	<iframe scrolling="auto" id="deptSelectDlgForUserAddFrame" frameborder="0"  src="" style="width:100%;height:100%;">
</div>