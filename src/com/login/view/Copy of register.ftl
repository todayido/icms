<link href="/global/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/global/bootstrap-3.3.5/css/bootstrapValidator.css"/>
<script src="/global/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/global/bootstrap-3.3.5/js/bootstrapValidator.js"></script>

<link rel="stylesheet" type="text/css" href="/global/styles/sg-register-1.0.css" />
<script type="text/javascript">
</script>
<div class="reg">新用户注册</div><br>
<div style="margin-left:50px;">
<form id="regForm" method="post" action="/register/doRegister.htm" class="form-horizontal">
   	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">用户名</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="username"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">邮箱地址</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="email" placeholder="找回密码时使用，请牢记"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">真实姓名</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="real_name" placeholder="取款时银行卡必须与之一致，否则不能提款" data-bv-notempty data-bv-notempty-message="不能为空"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
        <div class="form-group">
            <span class="col-lg-2 control-label reg-title">密码</span>
            <div class="col-lg-6">
                <input type="password" class="form-control" name="password" />
            </div>
        </div>
        <div class="form-group">
            <span class="col-lg-2 control-label reg-title">确认密码</span>
            <div class="col-lg-6">
                <input type="password" class="form-control" name="confirmPassword" />
            </div>
        </div>
    </fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">淘宝账号</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="taobao" data-bv-notempty data-bv-notempty-message="不能为空"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">支付宝账号</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="zhifubao" data-bv-notempty data-bv-notempty-message="不能为空"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">六位安全码</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="anquanma" placeholder="取款时必须输入六位安全码才能提款" data-bv-notempty data-bv-notempty-message="不能为空"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
    	<div class="checkbox col-lg-offset-2" >
            <label>
                <input type="checkbox" name="agreewith" value="javascript" checked/>同意
            </label>
            <a href=""> 请认真阅读《注册条款》 </a>
        </div>
    </fieldset>
    <fieldset>
    <div class="form-group">
        <div class="col-lg-9">	
        	<button class="button-width-280 blue" id="submitRegBtn" type="submit">注册</button>
        </div>
    </div>
    </fieldset>	
</form>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('#regForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 15,
                        message: '请输入6到20个字符'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '登录名只能包含字母、数字、点（.）、下划线（_）'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: '接受该条款'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱不能为空'
                    },
                    emailAddress: {
                        message: '请输入合法的邮箱地址'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: '两次输入的密码不一致，请重新输入'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '两次输入的密码不一致，请重新输入'
                    }
                }
            }
        }
    });
});
</script>
