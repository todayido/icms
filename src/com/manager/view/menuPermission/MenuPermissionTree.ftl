<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sys_html_title}</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <script src="/global/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/global/scripts/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/global/scripts/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="/global/scripts/sg-easyui-utils-1.0.js"></script>
    <link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/easyui.css">
    <link rel="stylesheet" href="/global/scripts/jquery-easyui/jquery.ui.theme.min.css" type="text/css"></link>
    <link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/global/styles/sg-manager-1.0.css" />
    <link rel="stylesheet" href="/global/scripts/jquery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
  </head>
  <script>

/**
 *  zTree树
 */
    var setting = {
    	checkable : true,
        view: {
            selectedMulti: false
        },
        async: {
            enable: true,
            url:"/menuPermission/menuPermissionTree.htm",
            autoParam:["id"],
            otherParam:{"otherParam":"zTreeAsyncTest"},
            dataFilter: null
        }
    };

    $(document).ready(function(){
        $.fn.zTree.init($("#treeMenu"), setting);
    });
    
    function Open(text,parent_id){
    	var url = "menuPermission/menuPermissionIndex.htm?parent_id="+parent_id;
        if($("#tabs").tabs('exists','权限列表')){
            var tab = $('#tabs').tabs('getSelected');
		    $("#tabs").tabs('update',{
		        tab: tab,
		        options:{
		            content:"<iframe frameborder='0' scrolling='scroll' width='100%' height='100%' src='/"+url+"'></iframe>"
		        }
		    });
		    tab.panel('refresh');
        }else{
          $('#tabs').tabs('add',{
            title:'权限列表',
            closable:true,
            content:"<iframe frameborder='0' scrolling='scroll' width='100%' height='100%' src='/"+url+"'></iframe>"
          });
        }
    }
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
</body>