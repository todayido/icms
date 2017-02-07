<div class="content-title">
	<span> 任务中心</span>
</div>
<script>
function doSearch(){
	$("#searchForm").submit();
}

function clearSearch(){
	$('input').val('');
	$('select').val('');
}
</script>
<form id="searchForm" action="/item/itemBlock.htm" method="post">
<div class="item-block">
    <div style="text-align:center">任务金范围：<input class="item-jin" type="text" name="jin_min" value="<#if map?exists>${map.jin_min?default('')}</#if>"/> 至 <input class="item-jin" type="text" name="jin_max" value="<#if map?exists>${map.jin_max?default('')}</#if>">
    	<select name="item_source">
    		<option value="">未选择</option>
			<option value="淘宝">淘宝</option>
			<option value="京东">京东</option>
    	</select>
    	<a class="item-get" href="javascript:void(0)" onclick="doSearch()">查询</a></span>
    	<a class="item-get" href="javascript:void(0)" onclick="clearSearch()">清空提交</a></span>
    </div>
    <ul>
		<li>
		<table class="item-table">
			<tr>
				<td width="50">序号</td>
				<td>任务发布人</td>
				<td>单个任务金</td>
				<td>任务来源</td>
				<td>发布时间</td>
            	<td>操作</td>
			</tr>
			<#if map.itemList?size==0>
			<tr>
				<td colspan='6'>下手晚了，所有单子被抢光了...</td>
			</tr>
			<#else>
			<#list map.itemList as item>
			<tr>
				<td><span>${item_index+1}</span></td>
				<td><span>${item.user_id?default('')}</span></td>
				<td><span><font style="color:#F3726D">${item.item_one_cost?default('0')}</font>/金</span></td>
				<td><span>${item.item_source}</span></td>
				<td><span>${(item.item_time?date)}</span></td>
				<td><a class="item-get" href="">接单</a><a class="item-details" style="margin-left:10px;" href="">详细</a></td>
			</tr>
			</#list>
			</#if>
			
		</table>
		 </li>
		
	</ul>
	<div style="text-align:center;margin-top:10px;">
	<#include "/classes/com/manager/view/SimplePage.ftl"/>
	</div>
</div>
</form>
