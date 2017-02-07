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
function format(value,row,index){return row.permission_id;}

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
</script>
<body>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">权限名称：</span><input type="text" id="permission_name" name="permission_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#menuPermissionDlg').utilsOpenDialogAdd('dataTable',500,200,'添加信息','/menuPermission/menuPermissionAdd.htm?parent_id=${parent_id}');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#menuPermissionDlg').utilsOpenDialogModify('dataTable','permission_id',500,300,'信息修改','/menuPermission/menuPermissionModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#menuPermissionDlg').utilsDeleteRows('dataTable','permission_id','/menuPermission/menuPermissionDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/menuPermission/menuPermissionList.htm?parent_id=${parent_id}" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="permission_id"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="permission_id" checkbox="true"></th>
            <th field="null" formatter="format">序号</th>
	        <th field="permission_name" sortable="true" sorter="sortRules">权限名称</th>
	        <th field="resource" sortable="true" sorter="sortRules">资源(动作URI)</th>
	        <th field="parent_id" sortable="true" sorter="sortRules">父节点</th>
	        <th field="description" sortable="true" sorter="sortRules">描述</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="menuPermissionDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>