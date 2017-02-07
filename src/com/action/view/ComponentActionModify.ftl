<form action="/action/componentActionModifySubmit.htm" method="post">
    <input type="hidden" name="actionid" value="${resultMap.action.actionid}"/>
    <table class="gridtable" cellspacing='1'>
    <tr>
        <td  class="right">动作地址</td>   
        <td><input style="width:450px;" class="easyui-validatebox" type="text" name="actionurl" value="${resultMap.action.actionurl}"/></td>
    </tr>
    <tr>
        <td  class="right">视图</td>   
        <td><select class="easyui-validatebox" type="text" name="viewfile" style="width:450px;">
        	<option value="">--请选择--</option>
        	<#list resultMap.viewList as view>
        	<option value="${view.viewpath}" <#if '${view.viewpath}'=='${resultMap.action.viewfile}'>selected="selected"</#if>>${view.viewname}:${view.viewpath}</option>
        	</#list>
        </select></td>
    </tr>
    <tr>
        <td  class="right">模板</td>
        <td><select class="easyui-validatebox" type="text" name="contentfile" style="width:450px;">
        	<option value="">--请选择--</option>
        	<#list resultMap.templateList as template>
        	<option value="${template.templatename}" <#if '${template.templatename}'=='${resultMap.action.contentfile}'>selected="selected"</#if>>${template.templatename}:${template.description}</option>
        	</#list>
        </select></td>
    </tr>
    <tr>
        <td  class="right">描述</td>   
        <td><input style="width:450px;" class="easyui-validatebox" type="text" name="description" value="${resultMap.action.description}"/></td>  
    </tr>
</form>