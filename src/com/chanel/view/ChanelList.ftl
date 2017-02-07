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
function format(value,row,index){return row.chanelid;}
function sortRules(a,b){return (a>b?1:-1);}

//操作
function option(value,row,index){return '<a class="search-btn" href="javascript:void(0);" onclick="javascript:window.parent.Open(\''+row.chanelname+'\',\'chanel/chanelEdit.htm?chanelid='+row.chanelid+'\')">内容修改</a> '+
	'<a class="search-btn" href="/'+row.chanelname.substr(0,row.chanelname.length-4)+'.htm" target="_blank">预览</a>';}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        chanelname:$('#chanelname').val()
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
	        <span class="search-desc">频道名称：</span><input type="text" id="chanelname" name="chanelname"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#chanelDlg').utilsOpenDialogAdd('dataTable',500,350,'添加','/chanel/chanelAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#chanelDlg').utilsOpenDialogModify('dataTable','chanelid',500,350,'修改','/chanel/chanelModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#chanelDlg').utilsDeleteRows('dataTable','chanelid','/chanel/chanelDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/chanel/chanelList.htm" iconCls="icon-edit" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" idField="chanelid" fit="true" striped="true">
    <thead>
        <tr>
            <th field="chanelid" checkbox="true"></th>
	        <th field="chanelname" sortable="true" sorter="sortRules">频道名称</th>
	        <th field="description" sortable="true" sorter="sortRules">频道描述</th>
	        <th field="null-2" formatter="option">操作</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="chanelDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>