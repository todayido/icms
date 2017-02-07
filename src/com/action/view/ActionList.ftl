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
function format(value,row,index){return row.actionid;}
function sortRules(a,b){return (a>b?1:-1);}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        actionid:$('#actionid').val(),
        actionname:$('#actionname').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
}
</script>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">动作名称：</span><input type="text" id="actionname" name="actionname"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#actionDlg').utilsOpenDialogAdd('dataTable',500,265,'添加','/action/actionAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#actionDlg').utilsOpenDialogModify('dataTable','actionid',500,265,'修改','/action/actionModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#actionDlg').utilsDeleteRows('dataTable','actionid','/action/actionDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/action/actionList.htm" iconCls="icon-edit" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="actionid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="actionid" checkbox="true"></th>
	        <!-- th field="actionname" sortable="true" sorter="sortRules">动作名称</th -->
	        <th field="actionurl" sortable="true" sorter="sortRules">动作地址</th>
	        <th field="viewfile" sortable="true" sorter="sortRules">视图</th>
	        <th field="contentfile" sortable="true" sorter="sortRules">模板</th>
	        <th field="description" sortable="true" sorter="sortRules">描述</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="actionDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>