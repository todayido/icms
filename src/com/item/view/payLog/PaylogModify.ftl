<form action="/payLog/payLogModifySubmit.htm" method="post">
    <input type="hidden" name="user_pay_log_id" value="${payLog.user_pay_log_id}"/>
    <div class="form-div">
        <span>用户ID：</span>   
        <input class="easyui-validatebox" type="text" name="user_id" value="${payLog.user_id}"/> 
    </div>
    <div class="form-div">
        <span>用户名：</span>   
        <input class="easyui-validatebox" type="text" name="user_name" value="${payLog.user_name}"/> 
    </div>
    <div class="form-div">
        <span>充值账号</span>   
        <input class="easyui-validatebox" type="text" name="pay_zhanghao" value="${payLog.pay_zhanghao}"/> 
    </div>
    <div class="form-div">
        <span>充值金额：</span>   
        <input class="easyui-validatebox" type="text" name="money" value="${payLog.money}"/> 
    </div>
    <div class="form-div">
        <span>1、支付宝；2、银行卡；3、微信：</span>   
        <input class="easyui-validatebox" type="text" name="type" value="${payLog.type}"/> 
    </div>
    <div class="form-div">
        <span>备注：</span>   
        <input class="easyui-validatebox" type="text" name="beizhu" value="${payLog.beizhu?default('')}"/> 
    </div>
    <div class="form-div">
        <span>申请时间：</span>   
        <input class="easyui-validatebox" type="text" name="apply_time" value="${payLog.apply_time}"/> 
    </div>
    <div class="form-div">
        <span>状态：0、审核中；1、审核通过；2、审核不通过：</span>   
        <input class="easyui-validatebox" type="text" name="state" value="${payLog.state}"/> 
    </div>
    <div class="form-div">
        <span>审核不通过原因：</span>   
        <input class="easyui-validatebox" type="text" name="reason" value="${payLog.reason?default('')}"/> 
    </div>
</form>