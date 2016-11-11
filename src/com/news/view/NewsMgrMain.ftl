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
/**
 *  zTree树
 */
    var setting = {
        view: {
            selectedMulti: false
        },
        async: {
            enable: true,
            url:"/news/newsMgrMenu.htm",
            autoParam:["id"],
            otherParam:{"otherParam":"zTreeAsyncTest"},
            dataFilter: null
        }
    };

    $(document).ready(function(){
        $.fn.zTree.init($("#treeMenu"), setting);
    });
    
    function Open(text,blockid){
        var url = "news/newsMgrIndex.htm?blockid="+blockid;
        if($("#tabs").tabs('exists',text)){
            $('#tabs').tabs('select', text);
        }else{
          $('#tabs').tabs('add',{
            title:text,
            closable:true,
            content:"<iframe frameborder='0' scrolling='scroll' width='100%' height='100%' src='/"+url+"'></iframe>"
          });
        }
    }
    
    function OpenNewsAddOrEdit(text,url){
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
    
    //-->
    
</SCRIPT>
<body class="easyui-layout">
  <div region="west" class="west" title="">
     <div class="easyui-panel" style="width:100%!important;margin:0px;overflow:auto;border:0px;" data-options="fit:true">
        <ul id="treeMenu" class="ztree"></ul>
     </div>
  </div>
  <div region="center" id="center">
     <div class="easyui-tabs" fit="true" border="false" id="tabs"></div>
  </div>
  <div id="tabsMenu" class="easyui-menu" style="width:120px;">  
    <div name="close">关闭</div>
    <div name="Other">关闭其他</div>
    <div name="All">关闭所有</div>
  </div>
</body>