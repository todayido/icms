<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sys_html_title}</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <script src="/global/scripts/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/easyui.css">
    <link rel="stylesheet" href="/global/scripts/jquery-easyui/jquery.ui.theme.min.css" type="text/css"></link>
    <link rel="stylesheet" type="text/css" href="/global/styles/sg-manager-1.0.css" />
    <link rel="stylesheet" href="/global/scripts/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
    <script type="text/javascript" src="/global/scripts/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/global/scripts/sg-easyui-validate-1.0.js"></script>
    <script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="/global/scripts/sg-easyui-utils-1.0.js"></script>
  </head>
  <script>
    $(function(){
      //绑定tabs的右键菜单
      $("#tabs").tabs({
        onContextMenu:function(e,title){
          e.preventDefault();
          $('#tabsMenu').menu('show', {  
            left: e.pageX,  
            top: e.pageY  
          }).data("tabTitle",title);
        }
      });   
      
      //实例化menu的onClick事件
      $("#tabsMenu").menu({
        onClick:function(item){
          CloseTab(this,item.name);
        }
      });
      
    });

    //几个关闭事件的实现
    function CloseTab(menu,type){
        var curTabTitle = $(menu).data("tabTitle");
        var tabs = $("#tabs");
      
        if(type === "close"){
           tabs.tabs("close",curTabTitle);
          return;
        }
        
        var allTabs = tabs.tabs("tabs");
        var closeTabsTitle = [];
        
        $.each(allTabs,function(){
          var opt = $(this).panel("options");
          if(opt.closable && opt.title != curTabTitle && type === "Other"){
            closeTabsTitle.push(opt.title);
          }else if(opt.closable && type === "All"){
            closeTabsTitle.push(opt.title);
          }
        });
        
        for(var i = 0;i<closeTabsTitle.length;i++){
          tabs.tabs("close",closeTabsTitle[i]);
        }
    }
    function Open(text,url){
        if($("#tabs").tabs('exists',text)){
            $('#tabs').tabs('select', text);
        }else{
          $('#tabs').tabs('add',{
            title:text,
            closable:true,
            content:"<iframe frameborder='0' scrolling='auto' width='100%' height='100%' src='/"+url+"'></iframe>"
          });
        }
    }
 
/**
 *  zTree树
 */
    var setting = {
        view: {
            selectedMulti: false
        },
        async: {
            enable: true,
            url:"/manage/leftTree.htm",
            autoParam:["id"],
            otherParam:{"otherParam":"zTreeAsyncTest"},
            dataFilter: filter
        },
        callback: {
            onAsyncSuccess: onAsyncSuccess,
        }
    };

    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }
    function beforeClick(treeId, treeNode) {
        if (!treeNode.isParent) {
            alert("请选择父节点");
            return false;
        } else {
            return true;
        }
    }
    var log, className = "dark";
    function beforeAsync(treeId, treeNode) {
        className = (className === "dark" ? "":"dark");
        showLog("[ "+getTime()+" beforeAsync ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
        return true;
    }
    function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
        showLog("[ "+getTime()+" onAsyncError ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
    }
    function onAsyncSuccess(event, treeId, treeNode, msg) {
        showLog("[ "+getTime()+" onAsyncSuccess ]&nbsp;&nbsp;&nbsp;&nbsp;" + ((!!treeNode && !!treeNode.name) ? treeNode.name : "root") );
    }
    
    function showLog(str) {
        if (!log) log = $("#log");
        log.append("<li class='"+className+"'>"+str+"</li>");
        if(log.children("li").length > 8) {
            log.get(0).removeChild(log.children("li")[0]);
        }
    }
    function getTime() {
        var now= new Date(),
        h=now.getHours(),
        m=now.getMinutes(),
        s=now.getSeconds(),
        ms=now.getMilliseconds();
        return (h+":"+m+":"+s+ " " +ms);
    }

    function refreshNode(e) {
        var zTree = $.fn.zTree.getZTreeObj("treeMenu"),
        type = e.data.type,
        silent = e.data.silent,
        nodes = zTree.getSelectedNodes();
        if (nodes.length == 0) {
            alert("请先选择一个父节点");
        }
        for (var i=0, l=nodes.length; i<l; i++) {
            zTree.reAsyncChildNodes(nodes[i], type, silent);
            if (!silent) zTree.selectNode(nodes[i]);
        }
    }

    $(document).ready(function(){
        $.fn.zTree.init($("#treeMenu"), setting);
        //$("#refreshNode").bind("click", {type:"refresh", silent:false}, refreshNode);
    });
    //-->
    
</SCRIPT>
<body class="easyui-layout">
  <div region="north" class="north">
    <div style="position:fixed;top:1px;">
        <h1 style="padding-left:10px;color:#1D6BA3">后台管理，Ours For You.</h1>
    </div>
    <div class="top">
        <span class="seq">当前用户：${user.user_alias}</span>
        <span class="seq">|</span> <a href="/main.htm" target="_blank">首页 </a> 
        <span class="seq">|</span> <a href="#" onclick="javascrip:$('#frameDlg').utilsOpenDialogWithOutBth('600','400','账号设置','/manage/setup.htm')" >设置</a> 
        <span class="seq">|</span> <a href="/login/manageLogout.htm" >注销</a>
    </div>
  </div>
  <div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
      <div title="首页">
        <div style="text-align:center;margin-top:50px;padding:50px;color:#1D6BA3">
            <h1 style="margin-top:10px;">欢迎登陆！</h1>
            <h2 style="margin-top:10px;">Ours For You.</h2>
        </div>
      </div>
    </div>
  </div>
  <div region="west" class="west" title="导航菜单">
     <div class="easyui-panel" style="width:100%!important;margin:0px;overflow:auto;border:0px;" data-options="fit:true">
        <ul id="treeMenu" class="ztree"></ul>
     </div>
  </div>
  <div id="tabsMenu" class="easyui-menu" style="width:120px;">  
    <div name="close">关闭</div>
    <div name="Other">关闭其他</div>
    <div name="All">关闭所有</div>
  </div>
  <div region="south" class="south">
    Copyright © 2013 - 2014 OFY. All Rights Reserved OFY公司 版权所有
  </div>
  <div id="frameDlg"></div>
</body>