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
function option(value,row,index){return '<a class="search-btn" href="javascript:void(0);" onclick="javascript:window.parent.Open(\''+row.viewname+'\',\'view/viewEdit.htm?viewid='+row.viewid+'\')">内容修改</a>';}


//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        viewname:$('#viewname').val(),
        viewtype:$('#viewtype').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
    $('#viewtype').val('');
}
</script>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">视图名称：</span><input type="text" id="viewname" name="viewname"/>
	        <span class="search-desc">类型：</span>
	        <select name="viewtype" id="viewtype">
	        	<option value="">全部</option>
	        	<#list DictionaryService.getDicList('view_type') as viewtype>
	        		<option value="${viewtype.dic_value}">${viewtype.dic_value}</option>
	        	</#list>
	        </select>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#viewDlg').utilsOpenDialogAdd('dataTable',500,195,'添加','/view/viewAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#viewDlg').utilsOpenDialogModify('dataTable','viewid',500,158,'修改','/view/viewModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#viewDlg').utilsDeleteRows('dataTable','viewid','/view/viewDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/view/viewList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="viewid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="viewid" checkbox="true"></th>
            <th field="viewname" sortable="true" sorter="sortRules">视图名称</th>
	        <th field="viewpath" sortable="true" sorter="sortRules">视图文件</th>
	        <th field="viewtype" sortable="true" sorter="sortRules">视图类型</th>
	        <th field="description" sortable="true" sorter="sortRules">视图描述</th>
	        <th field="null-2" formatter="option">操作</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="viewDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>