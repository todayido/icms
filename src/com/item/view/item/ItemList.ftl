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
function format(value,row,index){return row.item_id;}
function sortRules(a,b){return (a>b?1:-1);}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        user_name:$('#user_name').val()
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
	        <span class="search-desc">条件：</span><input type="text" id="user_name" name="user_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#itemDlg').utilsOpenDialogAdd('dataTable',500,350,'添加信息','/item/itemAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" 
				    onclick="javascript:$('#itemDlg').utilsOpenDialogModify('dataTable','item_id',500,350,'信息修改','/item/itemModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#itemDlg').utilsDeleteRows('dataTable','item_id','/item/itemDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/item/itemList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="item_id"  fit="true">
    <thead>
        <tr>
            <th field="item_id" checkbox="true"></th>
	        <th field="user_id" sortable="true" sorter="sortRules">任务发布人</th>
	        <th field="item_count" sortable="true" sorter="sortRules">任务个数</th>
	        <th field="item_source" sortable="true" sorter="sortRules">任务来源</th>
	        <th field="item_all_cost" sortable="true" sorter="sortRules">总任务消耗金额</th>
	        <th field="item_one_cost" sortable="true" sorter="sortRules">单个任务消耗金额</th>
	        <th field="comments_after" sortable="true" sorter="sortRules">几天后评价</th>
	        <th field="comments_stars" sortable="true" sorter="sortRules">几星评价</th>
	        <th field="item_state" sortable="true" sorter="sortRules">状态</th>
	        <th field="item_time" sortable="true" sorter="sortRules">发布时间</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="itemDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>