<#include "/classes/com/manager/view/ManagerTop.html"/>
    <div class="div-edit">
        <a class="search-btn" href="javascript:void(0);" onclick="$('#saveForm').utilsJsonPost()">保存</a>
        <a class="search-btn" href="javascript:void(0);" onclick="parent.$('#tabs').tabs('close','新闻编辑')">取消</a>
    </div>
    <div style="overflow:auto">
<form id="saveForm" action="/news/newsAddSubmit.htm" method="post">
    <input type="hidden" name="blockid" value="${newsProperty.blockid}"/>
    <table class="gridtable" cellspacing="1">
        <tr>
            <td class="right">所属栏目</td>
            <td colspan="3"><input class="easyui-validatebox readonly" type="text" readonly="true" value="${newsProperty.title}"/></td>
        </tr>
        <tr>
            <td class="right">新闻标题</td>
            <td colspan="3"><input class="easyui-validatebox" type="text" name="title" data-options="required:true" missingMessage="不能为空" style="width:663px;"/><span class="info-tips">*</span></td>
        </tr>
        <tr>
            <td class="right">新闻短标题</td>
            <td colspan="3"><input class="easyui-validatebox" type="text" name="shorttitle" style="width:663px;"/></td>
        </tr>
        <tr>
            <td class="right">关键字</td>
            <td><input class="easyui-validatebox" type="text" name="keywords"/></td>
            <td class="right">内容来源</td>
            <td><input class="easyui-validatebox" type="text" name="source"/></td>
        </tr>
        <tr> 
            <td class="right">作者</td>   
            <td><input class="easyui-validatebox" type="text" name="author"/><<<a href="javascript:;">当前用户</a> <<<a href="javascript:;">佚名</a></td>
            <td class="right">编辑</td>   
            <td><input class="easyui-validatebox" type="text" name="editor"/><<<a href="javascript:;">当前用户</a> <<<a href="javascript:;">佚名</a></td> 
        </tr>
        <tr> 
            <td class="right">访问量</td>   
            <td><input class="easyui-validatebox" type="text" name="count" value="0"/></td> 
            <td class="right">评论量</td>   
            <td><input class="easyui-validatebox" type="text" name="commentcount" value="0"/></td> 
        </tr>
    </table>
    <script>
        var editorOption = {
            //自动出现滚动条
            autoHeightEnabled:true,
            //工具栏随滚动条滚动
            autoFloatEnabled:false,
            elementPathEnabled:false,
            //启用自动保存
            enableAutoSave: false,
            //自动保存间隔时间， 单位ms
            saveInterval: 500000000
        };
        var editor_a = new baidu.editor.ui.Editor(editorOption);
        editor_a.render( 'content' );
    </script>
    <script id="content" name="content" type="text/plain" style="height:400px;width:95%"></script>
</form>
</div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>