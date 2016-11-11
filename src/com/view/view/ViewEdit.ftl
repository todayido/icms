<#include "/classes/com/manager/view/ManagerTop.html"/>
    <div class="div-edit">
        <a class="search-btn" href="javascript:void(0);" onclick="$('#saveForm').utilsJsonPost()">保存</a>
        <a class="search-btn" href="javascript:void(0);" onclick="">导入视图</a>
        <a class="search-btn" href="javascript:void(0);" onclick="parent.$('#tabs').tabs('close','${map.view.viewname}')">取消修改</a>
        <span>视图名称:[${map.view.viewname}]</span>
    </div>
    <form id="saveForm" action="/view/viewEditSubmit.htm" method="post">
        <input type="hidden" value="${map.view.viewpath}" name="viewfile"/>
        <input type="hidden" value="${map.view.viewtype}" name="viewtype"/>
        <textarea id="fileContent" name="fileContent">${map.fileContent}</textarea>
        <script>
          var editor = CodeMirror.fromTextArea(document.getElementById("fileContent"), {
            lineNumbers: true
          });
          //设置代码编辑器的高度
          $('.CodeMirror').height(($(window).height()-30)+'px');//36
        </script>
     </form>
<#include "/classes/com/manager/view/ManagerBottom.html"/>