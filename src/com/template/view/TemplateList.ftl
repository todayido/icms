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

//操作
function option(value,row,index){return '<a class="search-btn" href="javascript:void(0);" onclick="javascript:window.parent.Open(\''+row.templatename+'\',\'template/templateEdit.htm?templateid='+row.templateid+'\')">内容修改</a>';}
function isdefault(value, row, index){if(value==0){return '否';}else{return '是'}}
//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        templatename:$('#templatename').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
}
//删除模板
function checkDelete(){
	var selectedRow = $('#dataTable').datagrid('getSelections');
    for ( var i = 0; i < selectedRow.length;i++) {
    	var isdefault = selectedRow[i]['isdefault'];
    	if(1==isdefault){
    		$.messager.alert("提示","默认模板，禁止删除！");
    		return;
    	}else{
    		continue;
    	}
	}
	$('#templateDlg').utilsDeleteRows('dataTable','templateid','/template/templateDelete.htm');
}
</script>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">模板名称：</span><input type="text" id="templatename" name="templatename"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#templateDlg').utilsOpenDialogAdd('dataTable',500,350,'添加信息','/template/templateAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#templateDlg').utilsOpenDialogModify('dataTable','templateid',500,350,'信息修改','/template/templateModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="checkDelete()">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/template/templateList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="templateid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="templateid" checkbox="true"></th>
	        <th field="templatename" sortable="true" sorter="sortRules">模板名称</th>
	        <th field="description" sortable="true" sorter="sortRules">模板描述</th>
	        <th field="isdefault" formatter="isdefault" sortable="true" sorter="sortRules" align="center">默认模板</th>
	        <th field="null-0" formatter="option">操作</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="templateDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>