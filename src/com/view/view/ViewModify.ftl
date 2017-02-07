<form action="/view/viewModifySubmit.htm" method="post">
    <input type="hidden" name="viewid" value="${view.viewid}"/>
    <input type="hidden" name="viewtype" value="${view.viewtype}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">视图名称：</td>   
	        <td><input class="easyui-validatebox" type="text" name="viewpath" value="${view.viewname}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">视图描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${view.description}"/></td> 
	    </tr>
    </table>
</form>