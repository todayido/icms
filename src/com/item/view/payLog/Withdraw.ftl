<div class="content-title">
	<span> 提现申请</span>
</div>
<#if message?exists>
<div class="alert alert-success" style="line-height:25px;background:#FFF;border:solid 1px #eee">${message}</div>
</#if>
<div class="col-lg-10 col-lg-offset-2">
<form id="payForm" method="post" action="/pay/withdrawSubmit.htm" class="form-horizontal">
   	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">支付宝账号</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="pay_zhanghao"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">提取金额</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="money"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">备注</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="beizhu"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">安全码</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="anquanma"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group form-horizontal">
	        <span class="col-lg-2 control-label reg-title" id="captchaOperation"></span>
	        <div class="col-lg-6">
	            <input type="text" class="form-control " name="captcha" placeholder="请输入左侧算式的计算结果"/>
	        </div>
	    </div>
    </fieldset>
    <fieldset>
    <div class="form-group">
    	<span class="col-lg-2 control-label"></span>
        <div class="col-lg-6">	
        	<button class="btn btn-theme-red01" style="width:290px;" id="submitRegBtn" type="submit">提交申请</button>
        </div>
    </div>
    </fieldset>	
</form>
</div>
<script type="text/javascript">
$(document).ready(function() {
	function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    function generateCaptcha() {
        $('#captchaOperation').html([randomNumber(1, 50), '+', randomNumber(1, 50), '='].join(' '));
    };
    generateCaptcha();
    
    $('#payForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            pay_zhanghao: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '支付宝账号不能为空'
                    }
                }
            },
            money: {
                validators: {
                    notEmpty: {
                        message: '充值金额不能为空'
                    }
                }
            },
            captcha: {
                validators: {
                    callback: {
                        message: '验证码错误',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            },
            anquanma: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '安全码不能为空'
                    }
                }
            }
        }
    });;
});
</script>
