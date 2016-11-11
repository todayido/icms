<form action="/component/componentAddSubmit.htm" method="post">
	 <table class="gridtable" cellspacing='1'>
	 	<tr>
		    <td class="right">组件名称</td>   
		    <td><input style="width:300px" class="easyui-validatebox" type="text" name="componentname" data-options="required:true" missingMessage="不能为空"/></td>
		</tr>
		<tr>
		    <td class="right">组件类型</td>   
		    <td><input style="width:300px" class="easyui-validatebox" type="text" name="componenttype" data-options="required:true,validType:'notnull'" missingMessage="不能为空"/>(配置文件中的package属性值) </td>
		</tr>
	    <tr>
		    <td class="right">组件配置文件</td>   
		    <td><input style="width:300px" class="easyui-validatebox" type="text" name="confpath" data-options="required:true" missingMessage="不能为空"/></td>
		</tr>
		<tr>
		    <td class="right">实例类型</td>   
		    <td><select name="issingleton" style="width:300px">
		    	<option value="0">多实例</option>
		    	<option value="1">单实例</option>
		    </select></td>
		</tr>
		<tr>
	        <td class="right">组件描述</td>   
	        <td><input style="width:300px" class="easyui-validatebox" type="text" name="description"/></td>  
	    </tr>
	</table>
</form>