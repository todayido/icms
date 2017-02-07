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
function option(value,row,index){return '<a class="search-btn" onclick="javascript:window.parent.Open(\''+row.componentname+'动作列表\',\'action/componentActionIndex.htm?confpath='+row.confpath+'\')">配置</a>';}
function issingleton(value,row,index){return row.issingleton==1?"单实例":"多实例";}
//搜索
function searchData(){
    $('#dataTable').datagrid('load',
        {issingleton:$('#issingleton').val(),
         componentname:$('#componentname').val()}
    );
}  

//清空查询条件
function clearSearch(){
    $("input").val("");
    $("select").find("option[value='']").attr("selected",true);
}
</script>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">组件名称：</span><input type="text" id="componentname"/>
	        <span class="search-desc">组件类型：</span>
	        <select type="text" id="issingleton">
	            <option value="">请选择</option>
	        	<option value="0">多实例</option>
	        	<option value="1">单实例</option>
	        </select>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#componentDlg').utilsOpenDialogAdd('dataTable',700,265,'添加信息','/component/componentAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#componentDlg').utilsOpenDialogModify('dataTable','componentid',700,265,'信息修改','/component/componentModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#componentDlg').utilsDeleteRows('dataTable','componentid','/component/componentDelete.htm')">删除</a>
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/component/componentList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="componentid"
       idField="componentid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="componentid" checkbox="true"></th>
            <th field="componentname" sortable="true" sorter="sortRules">组件名称</th>
            <th field="componenttype" sortable="true" sorter="sortRules">组件类型</th>
            <th field="null-0" formatter="issingleton">组件类型</th>
            <th field="confpath" sortable="true" sorter="sortRules">配置文件</th>
            <th field="description">组件描述</th>
            <th field="null-1" formatter="option">操作</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="componentDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>