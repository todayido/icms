<form action="/action/actionModifySubmit.htm" method="post">
    <input type="hidden" name="actionid" value="${resultMap.action.actionid}"/>
    <table class="gridtable" cellspacing='1'>
    	<tr>
	        <td class="right">动作地址</td>   
	        <td><input class="easyui-validatebox" type="text" name="actionurl" value="${resultMap.action.actionurl}"/> 
	    </tr>
	    <tr>
	        <td  class="right">视图</td>   
	        <td><input class="easyui-validatebox" type="text" name="viewfile" value="${resultMap.action.viewfile}"/> 
	    </tr>
	    <tr>
	        <td  class="right">模板</td>
	        <td><input class="easyui-validatebox" type="text" name="contentfile" value="${resultMap.action.contentfile}"/> 
	    </tr>
	    <tr>
	        <td  class="right">描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${resultMap.action.description}"/> 
	    </tr>
	</table>
</form>