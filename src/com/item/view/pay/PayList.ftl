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
function format(value,row,index){return row.pay_id;}
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
	        <span class="search-desc">用户账号：</span><input type="text" id="user_name" name="user_name"/>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#payDlg').utilsOpenDialogAdd('dataTable',500,350,'添加信息','/pay/payAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" 
				    onclick="javascript:$('#payDlg').utilsOpenDialogModify('dataTable','pay_id',500,350,'信息修改','/pay/payModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#payDlg').utilsDeleteRows('dataTable','pay_id','/pay/payDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/pay/payList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="pay_id"  fit="true">
    <thead>
        <tr>
            <th field="pay_id" checkbox="true"></th>
	        <th field="user_id" sortable="true" sorter="sortRules">用户ID</th>
	        <th field="user_name" sortable="true" sorter="sortRules">用户账号</th>
	        <th field="user_jine" sortable="true" sorter="sortRules">总金额（元）（可取现）</th>
	        <th field="user_dongjie" sortable="true" sorter="sortRules">冻结的金额（元）</th>
	        <th field="zhifubao" sortable="true" sorter="sortRules">支付宝账号</th>
	        <th field="zhifubao_name" sortable="true" sorter="sortRules">支付宝姓名</th>
	        <th field="yinhangka" sortable="true" sorter="sortRules">银行卡号</th>
	        <th field="yinhangka_name" sortable="true" sorter="sortRules">银行卡姓名</th>
	        <th field="weigui_cishu" sortable="true" sorter="sortRules">操作违规次数</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="payDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>