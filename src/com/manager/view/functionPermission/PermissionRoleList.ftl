<#include "/classes/com/manager/view/ManagerTop.html"/>
<script>
//分页
$(function(){
    var p1 = $('#dataTable1').datagrid('getPager');  
    $(p1).pagination({
        pageNumber:1,
        pageSize:10,//每页显示的记录条数，默认为10  
        pageList:[10,20,30,40,50],//可以设置每页记录条数的列表  
        beforePageText:'第',//页数文本框前显示的汉字  
        afterPageText:'页    共 {pages} 页',  
        displayMsg:'当前显示 {from} - {to} 条记录   共 {total} 条记录',  
    });
    
    var p2 = $('#dataTable2').datagrid('getPager');  
    $(p2).pagination({
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

//搜索
function searchData1(){
    $('#dataTable1').datagrid('load',{
        role_name:$('#role_name1').val()
        }
    );
}
//搜索
function searchData2(){
    $('#dataTable2').datagrid('load',{
        role_name:$('#role_name2').val()
        }
    );
}
//清空条件
function clearSearch1(){
    $('#role_name1').val('');
}
//清空条件
function clearSearch2(){
    $('#role_name2').val('');
}
//删除已选择的角色
function removeRoles(){
	$('#permissionRoleDlg').permissionRoleAddOrDelete('删除','dataTable1','role_permission_id','/permission/permissionRoleDelete.htm');
}

//添加已选择的角色
function addRolesToPermission(){
	$('#permissionRoleDlg').permissionRoleAddOrDelete('添加','dataTable2','ROLE_ID','/permission/addRolesToPermission.htm?permission_id=${permission_id}');
}

$.fn.permissionRoleAddOrDelete = function(tips,tableid,primarykey,action){
	//删除操作
	var tableid = "#"+tableid;
	var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择要操作的记录','');
    }else{
    	$.messager.confirm('提示','确定要进行该操作吗？',function(r){
    		if(r){
    			var selectedRow = $(tableid).datagrid('getSelections');
    			var ids=[];
    			for ( var i = 0; i < selectedRow.length;i++) {
    				ids.push(selectedRow[i][primarykey]);
				}
				$.getJSON(action,
					{"params[]":ids},
					function(data){
						if(data>0){
							$.messager.alert('提示',tips+'成功','',function(){
								$('#dataTable1').datagrid('clearSelections');
								$('#dataTable2').datagrid('clearSelections');
								$('#dataTable1').datagrid("reload");
								$('#dataTable2').datagrid("reload");
            				});
						}else{
							$.messager.alert("提示","操作失败 ，请重新尝试");
						}
					}
				);
          	}
		});
	}
}
</script>
<div style="height:202px;">
	<div id="toolbars1">
		<table>
			<tr>
				<td>
					<span class="search-desc">角色名称：</span><input type="text" id="role_name1"/>
				</td>
				<td>
					<a class="search-btn" href="javascript:void(0);" onclick="searchData1();">查 找</a>
					<a class="search-btn" href="javascript:void(0);" onclick="clearSearch1();">清 空条件</a>
					<a class="search-btn" href="javascript:void(0);" onclick="removeRoles()">删 除</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataTable1" class="easyui-datagrid" url="/permission/permissionRoleList.htm?permission_id=${permission_id}" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
	       nowrap="true" toolbar="#toolbars1" rownumbers="true" pagination="true" remoteSort="false" fit="true" striped="true">
	    <thead>
	        <tr>
	            <th field="role_id" checkbox="true"></th>
		        <th field="role_name" sortable="true" sorter="sortRules">角色名称</th>
		        <th field="description" sortable="true" sorter="sortRules">角色描述</th>
	        </tr>
	    </thead>
	</table>
</div>
<div style="height:202px;margin-top:3px;">
	<div id="toolbars2">
		<table>
			<tr>
				<td>
					<span class="search-desc">角色名称：</span><input type="text" id="role_name2"/>
				</td>
				<td>
					<a class="search-btn" href="javascript:void(0);" onclick="searchData2();">查 找</a>
					<a class="search-btn" href="javascript:void(0);" onclick="clearSearch2();">清 空条件</a>
					<a class="search-btn" href="javascript:void(0);" onclick="addRolesToPermission();">添 加</a>
				</td>
			</tr>
		</table>
	</div>
	<table id="dataTable2" class="easyui-datagrid" url="/permission/otherPermissionRoleList.htm?permission_id=${permission_id}" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
	       nowrap="true" toolbar="#toolbars2" rownumbers="true" pagination="true" remoteSort="false" fit="true" striped="true">
	    <thead>
	        <tr>
	            <th field="ROLE_ID" checkbox="true"></th>
		        <th field="ROLE_NAME" sortable="true" sorter="sortRules">角色名称</th>
		        <th field="DESCRIPTION" sortable="true" sorter="sortRules">角色描述</th>
	        </tr>
	    </thead>
	</table>
</div>
<div id="permissionRoleDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>