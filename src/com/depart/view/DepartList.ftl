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
function format(value,row,index){return row.depart_id;}
function sortRules(a,b){return (a>b?1:-1);}

//是否有效
function isAble(value,row,index) {
	if(value=="1"){
		return "有效";
	}else{
		return "无效";
	}
}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        name:$('#name').val(),
        is_show:$('#is_show').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
    $('#is_show').val('');
}

function showDepartTree(){
	window.showModalDialog("/depart/departTreeShowIndex.htm","dialogWidth=40px,dialogHeight=60px,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
}
</script>
<body>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc"> 部门名称 </span><input type="text" id="name" name="name"/>
	        <span class="search-desc"> 状态  </span>
	        <select name="is_show" id="is_show">
	        	<option value="">全部</option>
	        	<#list DictionaryService.getDicList('is_able') as status>
	        		<option value="${status.dic_key}">${status.dic_value}</option>
	        	</#list>
	        </select>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				   onclick="javascrip:$('#departDlg').utilsOpenDialogAdd('dataTable',550,300,'新增组织机构','/depart/departAdd.htm?parent_id=${parent_id}');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				   onclick="javascript:$('#departDlg').utilsOpenDialogModify('dataTable','depart_id',550,300,'组织机构信息修改','/depart/departModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				   onclick="javascript:$('#departDlg').utilsDeleteRows('dataTable','depart_id','/depart/departDelete.htm')">删除</a>
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/depart/departList.htm?parent_id=${parent_id}" iconCls="icon-edit" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" fit="true" striped="true">
    <thead>
        <tr>
            <th field="depart_id" checkbox="true"></th>
	        <th field="number" sortable="true" sorter="sortRules">部门编号</th>
	        <th field="name" sortable="true" sorter="sortRules">部门名称</th>
	        <th field="parent_name" sortable="true" sorter="sortRules">上级部门</th>
	        <th field="is_show" sortable="true" sorter="sortRules" formatter="isAble">状态</th>
	        <!-- th field="create_time" sortable="true" sorter="sortRules" formatter="formatDatebox">创建时间</th -->
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="departDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>