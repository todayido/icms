<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sys_html_title}</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
	<script src="/global/scripts/jquery-1.11.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/easyui.css">
	<link rel="stylesheet" href="/global/scripts/jquery-easyui/jquery.ui.theme.min.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="/global/styles/sg-manager-1.0.css" />
	<script type="text/javascript" src="/global/scripts/jquery-easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href="/global/scripts/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
	<script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<SCRIPT>
/**
 *  zTree树
 */
var setting = {
	check: {
        enable: true,
        chkboxType : { "Y" : "", "N" : "" }
    },
    async: {
        enable: true,
        url:"/role/menuRoleTree.htm?role_id=${role_id}",
        autoParam:["id"]
    }
};

$(document).ready(function(){
    $.fn.zTree.init($("#prTree"), setting);
});

function doSubmit(flag){
	var _url,tips = '';
	if(flag=='add'){
		_url = '/role/addMenuPermissionToRole.htm?role_id=${role_id}';
		tips = '添加';
	}else{
		_url = '/role/deleteMenuPersmissionFromRole.htm?role_id=${role_id}';
		tips = '删除';
	}
	var $form = $("#rP");
	var zTreeObj =$.fn.zTree.getZTreeObj("prTree");
	var s = zTreeObj.getCheckedNodes();
	if(s.length<1){
		alert('至少选择一条记录');
	}else{
		for(var i=0;i<s.length;i++){
			$form.append('<input type="hidden" name="params" value="'+s[i].id+'" />');
	    }
	    
		$form.form('submit',{
			url:_url,
			success:function(data){
				if(data>0){
					$.messager.alert('提示',tips+'成功','',function(){
								window.close();
            				});
				}else{
					$.messager.alert('提示',tips+'成功','',function(){
								window.close();								
            				});
				}
			}
		});
	}
}
</SCRIPT>
<body onload="asyncAll()">
<div style="height:30px;">
	<a class="search-btn" href="javascript:void(0);" onclick="doSubmit('add');">添加已选</a>
    <a class="search-btn" href="javascript:void(0);" onclick="doSubmit('delete');">删除已选</a>
</div>
<form id="rP" action="" method="post"></form>
<ul id="prTree" class="ztree"></ul>

<#include "/classes/com/manager/view/ManagerBottom.html"/>