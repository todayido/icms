<form action="/permission/permissionAddSubmit.htm" method="post">
    <div class="form-div">
        <span>权限名称：</span>   
        <input class="easyui-validatebox" type="text" name="permission_name"/> 
    </div>
    <div class="form-div">
        <span>资源(动作URI)：</span>   
        <input class="easyui-validatebox" type="text" name="resource"/> 
    </div>
    <input class="easyui-validatebox" type="hidden" name="parent_id" value="${parent_id}"/> 
    <div class="form-div">
        <span>描述：</span>   
        <input class="easyui-validatebox" type="text" name="description"/>
    </div>
</form>