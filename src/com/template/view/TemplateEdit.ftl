<#include "/classes/com/manager/view/ManagerTop.html"/>
    <div class="div-edit">
        <a class="search-btn" href="javascript:void(0);" onclick="$('#saveForm').utilsJsonPost()">保存</a>
        <a class="search-btn" href="javascript:void(0);" onclick="">导入模板</a>
        <a class="search-btn" href="javascript:void(0);" onclick="parent.$('#tabs').tabs('close','${map.template.templatename}')">取消修改</a>
        <span>模板名称:[${map.template.templatename}]</span>
    </div>
    <form id="saveForm" action="/template/templateEditSubmit.htm" method="post">
        <input type="hidden" value="${map.template.templatename}" name="templatename"/>
        <textarea id="fileContent" name="fileContent">${map.fileContent}</textarea>
        <script>
          var editor = CodeMirror.fromTextArea(document.getElementById("fileContent"), {
            lineNumbers: true
          });
          //设置代码编辑器的高度
          $('.CodeMirror').height(($(window).height()-90)+'px');//36
        </script>
     </form>
     <div class="div-tips">
        <div>模板中的@block标签说明（<span>至少有一个：$\n{content}该元素输出动作返回的视图。</span>）</div>
        <div>组件名称：component（<span>必填</span>），动作ID：action_id（<span>必填</span>），视图路径：view_id（<span>空时默认</span>），多实例ID：block_id（<span>多实例必填，单实例不做要求</span>）</div>
        <div>例：${"<@block component='fragment' action_id='fragmentBlock' view_id='templates/fragment/daohang.ftl' block_id='5'/>"}</div>
     </div>
<#include "/classes/com/manager/view/ManagerBottom.html"/>