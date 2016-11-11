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
	//check: {
		//chkStyle: "radio",
        //enable: true,
        //radioType: "all"
    //},
    async: {
        enable: true,
        url:"/depart/departTreeShow.htm",
        autoParam:["id"],
        otherParam:{"otherParam":"zTreeAsyncTest"}
    }
};

function Nodes(id,name){
	this.id=id;
	this.name=name;
}

function beforeAsync() {
			curAsyncCount++;
		}
		
		function onAsyncSuccess(event, treeId, treeNode, msg) {
			curAsyncCount--;
			if (curStatus == "expand") {
				expandNodes(treeNode.children);
			} else if (curStatus == "async") {
				asyncNodes(treeNode.children);
			}

			if (curAsyncCount <= 0) {
				if (curStatus != "init" && curStatus != "") {
					asyncForAll = true;
				}
				curStatus = "";
			}
		}

		function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
			curAsyncCount--;

			if (curAsyncCount <= 0) {
				curStatus = "";
				if (treeNode!=null) asyncForAll = true;
			}
		}

		var curStatus = "init", curAsyncCount = 0, asyncForAll = false,
		goAsync = false;
		function expandAll() {
			if (!check()) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("departTree");
			if (asyncForAll) {
				zTree.expandAll(true);
			} else {
				expandNodes(zTree.getNodes());
				if (!goAsync) {
					curStatus = "";
				}
			}
		}
		function expandNodes(nodes) {
			if (!nodes) return;
			curStatus = "expand";
			var zTree = $.fn.zTree.getZTreeObj("departTree");
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.expandNode(nodes[i], true, false, false);
				if (nodes[i].isParent && nodes[i].zAsync) {
					expandNodes(nodes[i].children);
				} else {
					goAsync = true;
				}
			}
		}

		function asyncAll() {
			if (!check()) {
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("departTree");
			if (asyncForAll) {
			} else {
				asyncNodes(zTree.getNodes());
				if (!goAsync) {
					curStatus = "";
				}
			}
		}
		function asyncNodes(nodes) {
			if (!nodes) return;
			curStatus = "async";
			var zTree = $.fn.zTree.getZTreeObj("departTree");
			for (var i=0, l=nodes.length; i<l; i++) {
				if (nodes[i].isParent && nodes[i].zAsync) {
					asyncNodes(nodes[i].children);
				} else {
					goAsync = true;
					zTree.reAsyncChildNodes(nodes[i], "refresh", true);
				}
			}
		}

		function reset() {
			if (!check()) {
				return;
			}
			asyncForAll = false;
			goAsync = false;
			$.fn.zTree.init($("#departTree"), setting);
		}

		function check() {
			if (curAsyncCount > 0) {
				return false;
			}
			return true;
		}

$(document).ready(function(){
    $.fn.zTree.init($("#departTree"), setting);
    $("#expandAllBtn").bind("click", expandAll);
});
</SCRIPT>
<body onload="asyncAll()">
<div style="height:30px;">
	<a id="expandAllBtn" class="search-btn" href="#" onclick="return false;">展开</a>
</div>
<form id="departForm" action="" method="post"></form>
<ul id="departTree" class="ztree"></ul>
<#include "/classes/com/manager/view/ManagerBottom.html"/>