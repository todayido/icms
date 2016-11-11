<#include "/classes/com/manager/view/ManagerTop.html"/>
    <div class="div-edit">
        <a class="search-btn" href="javascript:void(0);" onclick="$('#saveForm').utilsJsonPost()">保存</a>
        <a class="search-btn" href="javascript:void(0);" onclick="">导入</a>
        <a class="search-btn" href="javascript:void(0);" onclick="parent.$('#tabs').tabs('close','${map.fragment.fragmentname}')">取消修改</a>
        <span>片段名称:[${map.fragment.fragmentname}]</span>
    </div>
    <form id="saveForm" action="/fragment/fragmentEditSubmit.htm" method="post">
        <input type="hidden" value="${map.fragment.fragmentname}" name="fragmentname"/>
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
                saveInterval: 500000000
            };
            var editor_a = new baidu.editor.ui.Editor(editorOption);
            editor_a.render( 'fileContent' );
        </script>
        <script id="fileContent" name="fileContent" type="text/plain" style="height:70%;">${map.fileContent}</script>
     </form>
<#include "/classes/com/manager/view/ManagerBottom.html"/>

