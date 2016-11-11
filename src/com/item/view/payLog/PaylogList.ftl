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
function format(value,row,index){return row.user_pay_log_id;}
function sortRules(a,b){return (a>b?1:-1);}

//搜索
function searchData(){
    $('#dataTable').datagrid('load',{
        user_name:$('#user_name').val(),
        state:$('#state').val()
        }
    );
}  

//清空查询条件
function clearSearch(){
    $('input').val('');
}
//支付方式
function methodPay(value,row,index){
	if(value=="1"){
		return "支付宝";
	}else if(value=="2"){
		return "银行卡";
	}else{
		return "微信";
	}
}

//
function payId(value,row,index){return row.user_pay_log_id;}

//支付状态
function payState(value,row,index){
	if(value=="0"){
		return "审核中";
	}else if(value=="1"){
		return "通过";
	}else{
		return "驳回";
	}
}
</script>
<body>
<div id="toolbars">
	<table>
	    <tr>
	        <td>
	        <span class="search-desc">用户名：</span><input type="text" id="user_name" name="user_name"/>
	        <select name="state" id="state">
	        	<option value="">全部</option>
	        	<option value="0">审核中</option>
	        	<option value="1">已充值</option>
	        	<option value="2">驳回</option>
	        </select>
	        <a class="search-btn" href="javascript:void(0);" onclick="searchData();">查 找</a>
	        <a class="search-btn" href="javascript:void(0);" onclick="clearSearch();">清 空</a>
	        </td>
		</tr>
		<tr>
			<td>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" 
				   onclick="javascrip:$('#payLogDlg').utilsOpenDialogAdd('dataTable',500,350,'添加信息','/payLog/payLogAdd.htm');">新增</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" 
				    onclick="javascript:$('#payLogDlg').utilsOpenDialogModify('dataTable','user_pay_log_id',500,350,'信息修改','/payLog/payLogModify.htm')">修改</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-save" plain="true" 
				    onclick="javascript:$('#payLogDlg').utilsOpenDialogModify('dataTable','user_pay_log_id',500,350,'支付审核','/payLog/audit.htm')">审核</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" 
				    onclick="javascript:$('#payLogDlg').utilsDeleteRows('dataTable','user_pay_log_id','/payLog/payLogDelete.htm')">删除</a> 
			</td>
		</tr>
	</table>
</div>
<table id="dataTable" class="easyui-datagrid" url="/payLog/payLogList.htm" iconCls="icon-save" loadMsg="数据加载中,请稍后……"
       nowrap="true" toolbar="#toolbars" rownumbers="true" pagination="true" remoteSort="false" idField="user_pay_log_id"  fit="true">
    <thead>
        <tr>
            <th field="user_pay_log_id" checkbox="true"></th>
            <th field="null" formatter="payId">支付编号</th>
	        <th field="user_id" sortable="true" sorter="sortRules">用户ID</th>
	        <th field="user_name" sortable="true" sorter="sortRules">用户名</th>
	        <th field="type" sortable="true" sorter="sortRules" formatter="methodPay">支付方式</th>
	        <th field="pay_zhanghao" sortable="true" sorter="sortRules">充值账号</th>
	        <th field="money" sortable="true" sorter="sortRules">充值金额(元)</th>
	        <th field="beizhu" sortable="true" sorter="sortRules">备注</th>
	        <th field="apply_time" sortable="true" sorter="sortRules">申请时间</th>
	        <th field="state" sortable="true" sorter="sortRules" formatter="payState">审核状态</th>
	        <th field="reason" sortable="true" sorter="sortRules">驳回原因</th>
	        <th field="check_time" sortable="true" sorter="sortRules">审核时间</th>
        </tr>
    </thead>
</table>
<!-- 对话框 -->
<div id="payLogDlg"></div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>