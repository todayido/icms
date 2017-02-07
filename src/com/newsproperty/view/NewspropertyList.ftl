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
function format(value,row,index){return row.blockid;}
function sortRules(a,b){return (a>b?1:-1);}
function isComment(value,row,index){if(value=='0'){return '否';}else{return '是';}}
//操作
function viewAndTemplate(value,row,index){return '<a class="search-btn" href="javascript:void(0);" onclick="javascript:window.parent.Open(\''+row.title+'配置\',\'action/componentActionIndex.htm?confpath=com/news/conf/component-news.xml&blockid='+row.blockid+'\')">配置</a>';}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        blockid:$('#blockid').val(),
        title:$('#title').val()
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
	        <span class="search-desc">新闻ID：</span><input type="text" id="blockid" name="blockid"/>
	        <span class="search-desc">新闻标题：</span><input type="text" id="title" name="title"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#newspropertyDlg').utilsOpenDialogAdd('dataTable',500,265,'添加','/newsproperty/newspropertyAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" 
				    onclick="javascript:$('#newspropertyDlg').utilsOpenDialogModify('dataTable','blockid',500,265,'修改','/newsproperty/newspropertyModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#newspropertyDlg').utilsDeleteRows('dataTable','blockid','/newsproperty/newspropertyDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/newsproperty/newspropertyList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="blockid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="blockid" checkbox="true"></th>
	        <th field="null-1" formatter="format" sortable="true"  sorter="sortRules">新闻ID</th>
	        <th field="title" sortable="true" sorter="sortRules">新闻标题</th>
	        <th field="blockpage" sortable="true" sorter="sortRules">首页显示条数</th>
	        <th field="listpage" sortable="true" sorter="sortRules">列表显示条数</th>
	        <th field="iscomments" formatter="isComment" sorter="sortRules">是否允许评论</th>
	        <th field="description" sortable="true" sorter="sortRules">新闻描述</th>
	        <th field="null-2" formatter="viewAndTemplate">操作</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="newspropertyDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>