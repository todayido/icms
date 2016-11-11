<form action="/component/componentModifySubmit.htm" method="post">
    <input type="hidden" name="componentid" value="${component.componentid}"/>
    <table class="gridtable" cellspacing='1'>
    	<tr>
	        <td class="right">组件名称</td>   
	        <td><input style="width:300px" class="easyui-validatebox" type="text" name="componentname" value="${component.componentname}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">组件类型</td>   
	        <td><input style="width:300px" class="easyui-validatebox" type="text" name="componenttype" value="${component.componenttype}" data-options="required:true"/><a class="info-tips">*</a>(配置文件中的package属性值)</td> 
	    </tr>
	    <tr>
	        <td class="right">组件配置文件</td>   
	        <td><input style="width:300px" class="easyui-validatebox" type="text" name="confpath"  value="${component.confpath}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
		    <td class="right">实例类型</td>   
		    <td><select name="issingleton" style="width:300px">
		    	<option value="0" <#if '${component.issingleton}'=='0'>selected="selected"</#if> >多实例</option>
		    	<option value="1" <#if '${component.issingleton}'=='1'>selected="selected"</#if> >单实例</option>
		    </select></td>
		</tr>
	    <tr>
	        <td class="right">组件描述</td>   
	        <td><input style="width:300px" class="easyui-validatebox" type="text" name="description"  value="${component.description}"/></td> 
	    </tr>
    </table>
</form>