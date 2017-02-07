<form action="/payLog/auditSubmit.htm" method="post">
    <input type="hidden" name="user_pay_log_id" value="${payLog.user_pay_log_id}"/>
    <input class="easyui-validatebox" type="hidden" name="user_id" value="${payLog.user_id}"/> 
    <input class="easyui-validatebox" type="hidden" name="user_name" value="${payLog.user_name}"/> 
    <div class="form-div">
        <span><span><#if payLog.type=='1'>支付宝：<#elseif payLog.type=='2'>银行卡：<#else>微信：</#if></span></span>${payLog.pay_zhanghao}   
    </div>
    <div class="form-div">
        <span>充值金额：</span>
        <input class="easyui-validatebox" type="text" name="money" value="${payLog.money?default('0')}"/>   
    </div>
    <div class="form-div">
        <span>备注：</span>${payLog.beizhu?default('')}
    </div>
    <div class="form-div">
        <span>申请时间：</span>${payLog.apply_time}
    </div>
    <div class="form-div">
        <span>状态：</span>   
        <select name="state" id="state">	
        	<option value="2">审核不通过</option>
        	<option value="1">审核通过</option>
        </select>
    </div>
    <div class="form-div">
        <span>审核不通过原因：</span>   
        <input class="easyui-validatebox" type="text" name="reason" value="${payLog.reason?default('')}"/> 
    </div>
</form>









