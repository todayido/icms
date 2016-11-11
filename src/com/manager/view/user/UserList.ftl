<#include "/classes/com/manager/view/ManagerTop.html"/>
<script type="text/javascript">
//分页
$(function(){
    var p = $('#dataTable').datagrid('getPager');
    $(p).pagination({
        pageNumber:1,
        pageSize:10,//每页显示的记录条数，默认为10  
        pageList:[10,20,30,40,50],//可以设置每页记录条数的列表  
        beforePageText:'第',//页数文本框前显示的汉字  
        afterPageText:'页    共 {pages} 页',  
        displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',  
    });  
});

//排序
function sortRules(a,b){return a>b?1:-1;}

//用户是否有效
function isAble(value,row,index) {
	if(value=="1"){
		return "有效";
	}else{
		return "<font color='red'>无效</font>";
	}
}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        user_name:$('#user_name').val(),
        depart_id:$('#depart_id').val(),
        duty_id:$('#duty_id').val(),
        status:$('#status').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
    $('#status').val('');
    $('#duty_id').val('');
}
//查询条件部门选择
function choseDepartUserList(){
	var node = window.showModalDialog("/depart/departTreeIndex.htm",window,"dialogWidth=800px,dialogHeight=600px,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	document.getElementById("depart_id").value=node[0].id;
	document.getElementById("depart_name").value=node[0].name;
}
//用户的角色列表
function userRoleList(){
    var table_id = '#dataTable';
	var rows = $(table_id).datagrid('getSelections')
    if(rows.length==0){
    	$.messager.alert('提示','请选择要操作的对象！','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录！','');
    }else{
    	var user_id = rows[0]['USER_ID'];
		$('#userRoleListFrame')[0].src = '/user/userRoleListIndex.htm?USER_ID='+user_id;
		$('#userRoleList').dialog({
			 title:'权限角色列表',
			 height: 450,
			 width:750,
	      	 modal: true,
		     cache: false,    
		     maximizable:true,
		     resizable:true
		});
    }
}
</script>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">账号：</span><input type="text" name="user_name" id="user_name"/>
	        <span class="search-desc">所属部门：</span>
	        <input type="hidden" id="depart_id" name="depart_id"/>
	        <input type="text" id="depart_name" name="depart_name" onclick="choseDepartUserList()"/>
	        <span class="search-desc">职务：</span>
	        <select name="duty_id" id="duty_id">
	        	<option value="">全部</option>
	        	<#list DictionaryService.getDicList('duty_type') as duty>
	        		<option value="${duty.dic_key}">${duty.dic_value}</option>
	        	</#list>
	        </select>
	        <span class="search-desc">状态：</span>
	        <select name="status" id="status">
	        	<option value="">全部</option>
	        	<#list DictionaryService.getDicList('user_state') as status>
	        		<option value="${status.dic_key}">${status.dic_value}</option>
	        	</#list>
	        </select>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#userDlg').utilsOpenDialogAdd('dataTable',700,350,'添加信息','/user/userAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#userDlg').utilsOpenDialogModify('dataTable','USER_ID',750,300,'账号信息修改','/user/userModify.htm');">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#userDlg').utilsDeleteRows('dataTable','USER_ID','/user/userDelete.htm')">删除</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascrip:userRoleList()">对应角色</a>
				<!--a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#userDlg').utilsOpenDialogWithoutBtn('dataTable','USER_ID',900,450,'用户角色列表','/user/userRoleListIndex.htm');">对应角色</a -->
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/user/userList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="USER_ID"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="USER_ID" checkbox="true"></th>
	        <th field="USER_NAME" sortable="true" sorter="sortRules">账号</th>
	        <th field="USER_ALIAS" sortable="true" sorter="sortRules">姓名</th>
	        <th field="DEPART_NAME" sortable="true" sorter="sortRules">所属部门</th>
	        <th field="DUTY_NAME" sortable="true" sorter="sortRules">职务</th>
	        <th field="EMAIL" sortable="true" sorter="sortRules">邮箱</th>
	        <th field="QQ_NUMBER" sortable="true" sorter="sortRules">qq号</th>
	        <th field="PHONE" sortable="true" sorter="sortRules">手机号</th>
	        <th field="LOGIN_TIMES" sortable="true" sorter="sortRules">登录系统次数</th>
	        <th field="STATUS" sortable="true" sorter="sortRules" formatter="isAble">状态</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="userDlg"></div>
<div id="userRoleList"><iframe scrolling="auto" id='userRoleListFrame' frameborder="0"  src="" style="width:100%;height:100%;"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>