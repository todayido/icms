<form action="/permission/permissionModifySubmit.htm" method="post">
    <div class="form-div">
        <span>权限ID：</span>   
        <input class="easyui-validatebox" type="text" name="permission_id" value="${permission.permission_id}"/> 
    </div>
    <div class="form-div">
        <span>权限名称：</span>   
        <input class="easyui-validatebox" type="text" name="permission_name" value="${permission.permission_name}"/> 
    </div>
    <div class="form-div">
        <span>资源(动作URI)：</span>   
        <input class="easyui-validatebox" type="text" name="resource" value="${permission.resource}"/> 
    </div>
    <div class="form-div">
        <span>父节点：</span>   
        <input class="easyui-validatebox" type="text" name="parent_id" value="${permission.parent_id}"/> 
    </div>
    <div class="form-div">
        <span>描述：</span>   
        <input class="easyui-validatebox" type="text" name="description" value="${permission.description}"/> 
    </div>
</form>