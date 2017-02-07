<#include "/classes/com/manager/view/ManagerTop.html"/>
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
function sortRules(a,b){return (a>b?1:-1);}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        permission_name:$('#permission_name').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
}
//权限的角色列表
function permissionRoleList(){
    var table_id = '#dataTable';
	var rows = $(table_id).datagrid('getSelections')
    if(rows.length==0){
    	$.messager.alert('提示','请选择一条记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录','');
    }else{
    	var permission_id = rows[0]['permission_id'];
    	$('#prDlg')[0].src = '/permission/permissionRoleListIndex.htm?permission_id='+permission_id;
		$("#permissionRoleList").dialog({
			 title:'权限角色列表',
			 height: 450,
			 width:750,
	      	 modal: true,
		     cache: false,    
		     maximizable:true,
		     resizable:true,
		});
    }
}
</script>
<body>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc"> 权限名称 </span><input type="text" id="permission_name" name="permission_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#permissionDlg').utilsOpenDialogAdd('dataTable',500,200,'新增权限','/permission/permissionAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#permissionDlg').utilsOpenDialogModify('dataTable','permission_id',500,200,'权限修改','/permission/permissionModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#permissionDlg').utilsDeleteRows('dataTable','permission_id','/permission/permissionDelete.htm')">删除</a> 
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="javascrip:permissionRoleList()">所属角色</a>
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/permission/permissionList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="permission_id"  fit="true">
    <thead>
        <tr>
            <th field="permission_id" checkbox="true"></th>
	        <th field="permission_name" sortable="true" sorter="sortRules">权限名称</th>
	        <th field="resource" sortable="true" sorter="sortRules">资源(动作URI)</th>
	        <th field="description" sortable="true" sorter="sortRules">描述</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="permissionDlg"></div>
<div id="permissionRoleList">
	<iframe scrolling="auto" id='prDlg' frameborder="0"  src="" style="width:100%;height:100%;">
</div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>