<form action="/pay/payModifySubmit.htm" method="post">
    <input type="hidden" name="pay_id" value="${pay.pay_id}"/>
    <div class="form-div">
        <span>用户ID：</span>   
        <input class="easyui-validatebox" type="text" name="user_id" value="${pay.user_id}"/> 
    </div>
    <div class="form-div">
        <span>登录名：</span>   
        <input class="easyui-validatebox" type="text" name="user_name" value="${pay.user_name}"/> 
    </div>
    <div class="form-div">
        <span>总金额（可取现）：</span>   
        <input class="easyui-validatebox" type="text" name="user_jine" value="${pay.user_jine?default('0')}"/> 
    </div>
    <div class="form-div">
        <span>冻结的金额：</span>   
        <input class="easyui-validatebox" type="text" name="user_dongjie" value="${pay.user_dongjie}"/> 
    </div>
    <div class="form-div">
        <span>支付宝账号：</span>   
        <input class="easyui-validatebox" type="text" name="zhifubao" value="${pay.zhifubao}"/> 
    </div>
    <div class="form-div">
        <span>支付宝姓名：</span>   
        <input class="easyui-validatebox" type="text" name="zhifubao_name" value="${pay.zhifubao_name}"/> 
    </div>
    <div class="form-div">
        <span>银行卡号：</span>   
        <input class="easyui-validatebox" type="text" name="yinhangka" value="${pay.yinhangka}"/> 
    </div>
    <div class="form-div">
        <span>银行卡姓名：</span>   
        <input class="easyui-validatebox" type="text" name="yinhangka_name" value="${pay.yinhangka_name}"/> 
    </div>
    <div class="form-div">
        <span>操作违规次数：</span>   
        <input class="easyui-validatebox" type="text" name="weigui_cishu" value="${pay.weigui_cishu}"/> 
    </div>
</form>