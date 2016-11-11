<#include "/classes/com/manager/view/ManagerTop.html"/>
<link rel="stylesheet" href="/global/scripts/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script>
//分页
$(function(){
    var p = $('#dataTable').datagrid('getPager');  
    $(p).pagination({
        pageNumber:1,
        pageSize:10,//每页显示的记录条数，默认为10  
        pageList:[10,20,40,60],//可以设置每页记录条数的列表  
        beforePageText:'第',//页数文本框前显示的汉字  
        afterPageText:'页    共 {pages} 页',  
        displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',  
    });  
});

//排序
function format(value,row,index){return row.role_id;}
function sortRules(a,b){return (a>b?1:-1);}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        role_name:$('#role_name').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
}
//菜单权限
function openMenuPermissionDialog(){
	var table_id = '#dataTable';
	var rows = $(table_id).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择一条记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录！','');
    }else{
    	var id = rows[0]['role_id'];
    	$('#menuPermissionFrame')[0].src = '/role/menuRoleTreeIndex.htm?role_id='+id;
		$('#menuPermission').dialog({
			 title:'权限角色列表',
			 height:450,
			 width:400,
	      	 modal: true,
		     cache: false,    
		     maximizable:true,
		     resizable:true
		});
	}
}
//功能权限
function actionPermissionList(){
    var table_id = '#dataTable';
	var rows = $(table_id).datagrid('getSelections')
    if(rows.length==0){
    	$.messager.alert('提示','请选择一条记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录','');
    }else{
    	var role_id = rows[0]['role_id'];
    	$('#actionPermissionFrame')[0].src = '/role/rolePermissionListIndex.htm?role_id='+role_id;
		$('#actionPermission').dialog({
			 title:'角色功能权限列表',
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
	        <span class="search-desc">角色名称：</span><input type="text" id="role_name" name="role_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#roleDlg').utilsOpenDialogAdd('dataTable',600,350,'添加信息','/role/roleAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#roleDlg').utilsOpenDialogModify('dataTable','role_id',600,350,'信息修改','/role/roleModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#roleDlg').utilsDeleteRows('dataTable','role_id','/role/roleDelete.htm')">删除</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				   onclick="javascrip:openMenuPermissionDialog()">菜单权限</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
					onclick="javascrip:actionPermissionList()">功能权限</a>
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/role/roleList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="role_id"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="role_id" checkbox="true"></th>
	        <th field="role_name" sortable="true" sorter="sortRules">角色名</th>
	        <th field="description" sortable="true" sorter="sortRules">角色描述</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="roleDlg"></div>
<div id="menuPermission"><iframe scrolling="auto" id='menuPermissionFrame' frameborder="0"  src="" style="width:100%;height:100%;"></iframe></div>
<div id="actionPermission"><iframe scrolling="auto" name="actionPermissionFrame" id='actionPermissionFrame' frameborder="0"  src="" style="width:100%;height:100%;"></iframe></div>
<#include "/classes/com/manager/view/ManagerBottom.html" />