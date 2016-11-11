<form action="/item/itemModifySubmit.htm" method="post">
    <input type="hidden" name="item_id" value="${item.item_id}"/>
    <div class="form-div">
        <span>任务编号：</span>   
        <input class="easyui-validatebox" type="text" name="item_id" value="${item.item_id}"/> 
    </div>
    <div class="form-div">
        <span>任务发布人：</span>   
        <input class="easyui-validatebox" type="text" name="user_id" value="${item.user_id}"/> 
    </div>
    <div class="form-div">
        <span>任务个数：</span>   
        <input class="easyui-validatebox" type="text" name="item_count" value="${item.item_count}"/> 
    </div>
    <div class="form-div">
        <span>任务来源：</span>   
        <input class="easyui-validatebox" type="text" name="item_source" value="${item.item_source}"/> 
    </div>
    <div class="form-div">
        <span>总任务消耗金额：</span>   
        <input class="easyui-validatebox" type="text" name="item_all_cost" value="${item.item_all_cost}"/> 
    </div>
    <div class="form-div">
        <span>单个任务消耗金额：</span>   
        <input class="easyui-validatebox" type="text" name="item_one_cost" value="${item.item_one_cost}"/> 
    </div>
    <div class="form-div">
        <span>0：已保存但未发布。1：已发布。2：已完成，3：已结算，4：违规冻结：</span>   
        <input class="easyui-validatebox" type="text" name="item_state" value="${item.item_state}"/> 
    </div>
    <div class="form-div">
        <span>几天后评价：</span>   
        <input class="easyui-validatebox" type="text" name="comments_after" value="${item.comments_after}"/> 
    </div>
    <div class="form-div">
        <span>几星评价：</span>   
        <input class="easyui-validatebox" type="text" name="comments_stars" value="${item.comments_stars}"/> 
    </div>
    <div class="form-div">
        <span>评价内容：</span>   
        <input class="easyui-validatebox" type="text" name="comments_content" value="${item.comments_content}"/> 
    </div>
    <div class="form-div">
        <span>其他要求：</span>   
        <input class="easyui-validatebox" type="text" name="other_needs" value="${item.other_needs}"/> 
    </div>
    <div class="form-div">
        <span>发布时间：</span>   
        <input class="easyui-validatebox" type="text" name="item_time" value="${item.item_time}"/> 
    </div>
</form>