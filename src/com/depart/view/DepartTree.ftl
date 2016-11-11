<#include "/classes/com/manager/view/ManagerTop.html"/>
<link rel="stylesheet" href="/global/scripts/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script>
var setting = {
	check: {
		chkStyle: "radio",
        enable: true,
        radioType: "all"
    },
    async: {
        enable: true,
        url:"/depart/departTree.htm",
        autoParam:["id"]
    }
};

$(function(){
	zTreeObj = $.fn.zTree.init($("#departTree"), setting);
});

function onCheck(){
	var treeObj=$.fn.zTree.getZTreeObj("departTree");
    nodes=treeObj.getCheckedNodes(true);
    v="";
    if(nodes.length<=0){
    	$.messager.alert('提示','请选择一条记录','');
    	return false;
	}
	//调用父页面函数处理返回数据
    window.parent.returnValue(nodes);
}

function Nodes(id,name){
	this.id=id;
	this.name=name;
}

function noCheck(){
	var nodes = new Array();
	nodes[0]= new Nodes('','');
    //调用父页面函数处理返回数据
    window.parent.returnValue(nodes);
}

</script>
<div style="height:30px;">
	<a class="search-btn" href="javascript:void(0);" onclick="onCheck()">确定</a>
	<a class="search-btn" href="javascript:void(0);" onclick="noCheck()">取消选择</a>
</div>
<ul id="departTree" class="ztree"></ul>
<#include "/classes/com/manager/view/ManagerBottom.html"/>