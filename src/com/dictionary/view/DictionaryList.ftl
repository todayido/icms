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
        dic_name:$('#dic_name').val()
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
	        <span class="search-desc">字典名称：</span><input type="text" id="dic_name" name="dic_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#dictionaryDlg').utilsOpenDialogAdd('dataTable',500,230,'添加','/dictionary/dictionaryAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#dictionaryDlg').utilsOpenDialogModify('dataTable','dic_id',500,230,'修改','/dictionary/dictionaryModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#dictionaryDlg').utilsDeleteRows('dataTable','dic_id','/dictionary/dictionaryDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/dictionary/dictionaryList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="dic_id"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="dic_id" checkbox="true"></th>
	        <th field="dic_name" sortable="true" sorter="sortRules">字典名称</th>
	        <th field="dic_key" sortable="true" sorter="sortRules">键</th>
	        <th field="dic_value" sortable="true" sorter="sortRules">值</th>
	        <th field="description" sortable="true" sorter="sortRules">描述</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="dictionaryDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>