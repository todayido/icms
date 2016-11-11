<form action="/fragment/fragmentModifySubmit.htm" method="post">
    <input type="hidden" name="blockid" value="${fragment.blockid}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">片段名称</td>   
	        <td><input class="easyui-validatebox" type="text" name="fragmentname" value="${fragment.fragmentname}" data-options="required:true"/><a class="info-tips">*</a></td>
	    </tr>
	    <tr>
	        <td class="right">片段描述</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${fragment.description}"/></td>
	    </tr>
	</table>
</form>