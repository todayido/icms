<form action="/chanel/chanelModifySubmit.htm" method="post">
    <input type="hidden" name="chanelid" value="${chanel.chanelid}"/>
    <table class="gridtable" cellspacing='1'>
	    <tr>
	        <td class="right">频道名称：</td>   
	        <td><input class="easyui-validatebox" type="text" name="chanelname" value="${chanel.chanelname}" data-options="required:true"/><a class="info-tips">*</a></td> 
	    </tr>
	    <tr>
	        <td class="right">频道描述：</td>   
	        <td><input class="easyui-validatebox" type="text" name="description" value="${chanel.description}"/></td> 
	    </tr>
	</table>
</form>