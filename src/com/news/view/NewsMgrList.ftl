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
function format(value,row,index){return row.newsid;}
function sortRules(a,b){return (a>b?1:-1);}

//格式化时间
function formatDatebox(value,row,index) {
    var d = new Date(value.time);
    return d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate()+' '+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds();
} 

//操作
function addNews(){
    window.parent.OpenNewsAddOrEdit('新闻编辑','news/newsAdd.htm?blockid=${blockid}');
}
function modifyNews(){
    var tableid = "#dataTable";
    var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
        $.messager.alert('提示','请选择要操作的对象！','');
    }else if(rows.length>1){
        $.messager.alert('提示','只能选择一条记录！','');
    }else{
        var id = $(tableid).datagrid('getSelected')['newsid'];
        window.parent.OpenNewsAddOrEdit('新闻修改','news/newsModify.htm?newsid='+id);
    }
}

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
	        <span class="search-desc">新闻标题：</span><input type="text" id="title" name="title"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addNews()">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="modifyNews()">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#newsDlg').utilsDeleteRows('dataTable','newsid','/news/newsDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/news/newsMgrList.htm?blockid=${blockid}" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="newsid"  fit="true" striped="true">
    <thead>
        <tr>
            <th field="newsid" checkbox="true"></th>
            <th field="null" formatter="format">ID</th>
	        <th field="title" sortable="true" sorter="sortRules">新闻标题</th>
	        <th field="author" sortable="true" sorter="sortRules">作者</th>
	        <th field="editor" sortable="true" sorter="sortRules">编辑</th>
	        <th field="audit" sortable="true" sorter="sortRules">审核状态</th>
	        <th field="lastedittime" formatter="formatDatebox" sortable="true" sorter="sortRules">最后编辑时间</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="newsDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>