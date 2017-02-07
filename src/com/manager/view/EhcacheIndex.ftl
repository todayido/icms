<#include "/classes/com/manager/view/ManagerTop.html"/>
<script>
function clearCache(_actionId){
	var $form = $("#ehcacheForm");
	$form.form('submit',{
		url:_actionId,
		success:function(data){
			if(data>0){
				//$.messager.alert('提示','缓存清理成功！','');
				location.reload();
			}else{
				$.messager.alert('提示','缓存清理失败，请联系管理员！','');
			}
		}
	});
}
</script>
<div><button href="javascript:void(0);" onclick="javascript:location.reload();" style="margin:3px">刷新缓存</button>
<button href="javascript:void(0);" onclick="clearCache('/manage/removeAllCaches.htm');">清除全部缓存</button></div>
<form id="ehcacheForm" action="" method="post">
<table class="easyui-datagrid" rownumbers="true" loadMsg="数据加载中,请稍后……" striped="true">  
    <thead>  
        <tr>  
            <th data-options="field:'name'" width="300">缓存名称</th>  
            <th data-options="field:'content'" width="300">缓存数量</th>  
            <th data-options="field:'option'">操作</th>  
        </tr>  
    </thead>  
    <tbody>  
        <tr>  
            <td>用户缓存</td><td>${countMap.userCacheCount?default(0)}</td><td><input type="button" onclick="clearCache('/manage/removeCache.htm?cacheName=user');" value="清 除"></input></td>
        </tr>
        <tr>  
            <td>权限缓存</td><td>${countMap.permissionCacheCount?default(0)}</td><td><input type="button" onclick="clearCache('/manage/removeCache.htm?cacheName=permission');" value="清 除"></input></td>
        </tr>
        <tr>  
            <td>模板缓存</td><td>${countMap.templateCacheCount?default(0)}</td><td><input type="button" onclick="clearCache('/manage/removeCache.htm?cacheName=template');" value="清 除"></input></td>
        </tr>
        <tr>  
            <td>动作缓存</td><td>${countMap.actionCacheCount?default(0)}</td><td><input type="button" onclick="clearCache('/manage/removeCache.htm?cacheName=action');" value="清 除"></input></td>
        </tr>
        <tr>
            <td>字典缓存</td><td>${countMap.dictionaryCacheCount?default(0)}</td><td><input type="button" onclick="clearCache('/manage/removeCache.htm?cacheName=dictionary');" value="清 除"></input></td>
        </tr>
    </tbody>  
</table>
</form>
<#include "/classes/com/manager/view/ManagerBottom.html"/>
