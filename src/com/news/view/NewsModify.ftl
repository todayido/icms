<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>${sys_html_title}</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/global/scripts/codemirror-4.10/codemirror.css">
    <link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/easyui.css">
    <link rel="stylesheet" type="text/css" href="/global/scripts/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/global/styles/sg-manager-1.0.css">
    <script type="text/javascript" src="/global/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="/global/scripts/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="/global/scripts/codemirror-4.10/codemirror.js"></script>
    <script type="text/javascript" src="/global/scripts/ueditor-1.4.3/ueditor.config.js"></script>
    <script type="text/javascript" src="/global/scripts/ueditor-1.4.3/ueditor.all.js"></script>
    <script type="text/javascript" src="/global/scripts/sg-easyui-validate-1.0.js"></script>
    <script type="text/javascript" src="/global/scripts/sg-easyui-utils-1.0.js"></script>
    <script type="text/javascript" src="/global/scripts/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body style="margin:3px;overflow:auto">
<div class="div-edit">
    <a class="search-btn" href="javascript:void(0);" onclick="$('#saveForm').utilsJsonPost()">确定</a>
    <a class="search-btn" href="javascript:void(0);" onclick="parent.$('#tabs').tabs('close','新闻修改')">取消</a>
    <a class="search-btn" href="/news/details.htm?newsid=${map.news.newsid}" target="_blank">预览</a>
</div>
<form id="saveForm" action="/news/newsModifySubmit.htm" method="post">
    <input type="hidden" name="blockid" value="${map.newsProperty.blockid}"/>
    <input type="hidden" name="newsid" value="${map.news.newsid}"/>
    <table class="gridtable" cellspacing="1">
        <tr>
            <td><span class="right">所属栏目：</span></td>
            <td colspan="3"><input class="easyui-validatebox" type="text" readonly="true" value="${map.newsProperty.title}"/></td>
        </tr>
        <tr>
            <td><span class="right">新闻标题：</span></td>
            <td colspan="3"><input class="easyui-validatebox" type="text" name="title" value="${map.news.title!''}" data-options="required:true" missingMessage="不能为空" style="width:500px;"/><span class="info-tips">*</span></td>
        </tr>
        <tr> 
            <td><span class="right">新闻短标题：</span></td>   
            <td colspan="3"><input class="easyui-validatebox" type="text" name="shorttitle" value="${map.news.shorttitle!''}" style="width:500px;"/></td>
        </tr>
        <tr>
            <td><span class="right">关键字：</span></td>
            <td><input class="easyui-validatebox" type="text" name="keywords" value="${map.news.keywords!''}"/></td>
            <td><span class="right">内容来源：</span></td>   
            <td><input class="easyui-validatebox" type="text" name="source" value="${map.news.source!''}"/></td> 
        </tr>
        <tr> 
            <td><span class="right">作者：</span></td>   
            <td><input class="easyui-validatebox" type="text" name="author" value="${map.news.author!''}"/><<<a href="javascript:;">当前用户</a> <<<a href="javascript:;">佚名</a></td>
            <td><span class="right">编辑：</span></td>   
            <td><input class="easyui-validatebox" type="text" name="editor" value="${map.news.editor!''}"/><<<a href="javascript:;">当前用户</a> <<<a href="javascript:;">佚名</a></td> 
        </tr>
        <tr> 
            <td><span class="right">访问量：</span></td>   
            <td><input class="easyui-validatebox" type="text" name="count" value="${map.news.count!'0'}"/></td> 
            <td><span class="right">评论量：</span></td>   
            <td><input class="easyui-validatebox" type="text" name="commentcount" value="${map.news.commentcount!'0'}"/></td> 
        </tr>
    </table>
    <script>
        var editorOption = {
            //自动出现滚动条
            autoHeightEnabled:false,
            //工具栏随滚动条滚动
            autoFloatEnabled:true,
            elementPathEnabled:false,
            //启用自动保存
            enableAutoSave: false,
            //自动保存间隔时间， 单位ms
            saveInterval: 500000000,
        };
        var editor_a = new baidu.editor.ui.Editor(editorOption);
        editor_a.render( 'content' );
    </script>
    <script id="content" name="content" type="text/plain" style="width:99%;height:1000px;margin-top:3px;">${map.news.content!''}</script>
</form>
<#include "/classes/com/manager/view/ManagerBottom.html"/>