<link href="/global/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/global/bootstrap-3.3.5/css/bootstrapValidator.css"/>
<script src="/global/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/global/bootstrap-3.3.5/js/bootstrapValidator.js"></script>
<div class="content-title">
	<span> 新用户注册</span>
</div>
<#if message?exists>
	<div class="alert alert-success">${message}</div>
</#if>
<div class="col-lg-10 col-lg-offset-2">
<form id="regForm" method="post" action="/register/doRegister.htm" class="form-horizontal">
   	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">用户名</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="user_name"/><span id="user_name_error"></span>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label reg-title">邮箱地址</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="email" placeholder="找回密码时使用，请正确填写"/>
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
     </fieldset>
     <fieldset>
        <div class="form-group">
            <span class="col-lg-2 control-label reg-title">确认密码</span>
            <div class="col-lg-6">
                <input type="password" class="form-control" name="confirmPassword" />
            </div>
        </div>
       </fieldset>
       <fieldset>
        <div class="form-group">
            <span class="col-lg-2 control-label reg-title">安全码</span>
            <div class="col-lg-6">
                <input type="text" class="form-control" name="anquanma" placeholder="请输入六位数字安全码，务必牢记！"/>
            </div>
        </div>
       </fieldset>
       <fieldset>
        <div class="form-group">
            <span class="col-lg-2 control-label reg-title" id="captchaOperation"></span>
            <div class="col-lg-6">
                <input type="text" class="form-control " name="captcha" placeholder="请输入左侧算式的计算结果"/>
            </div>
        </div>
     </fieldset>
	 <fieldset>
    	<div class="checkbox col-lg-offset-2" >
            <span style="margin-left:20px;">
                <input type="checkbox" name="acceptTerms" value="javascript"/>同意
            </span>
            <a href=""> 请认真阅读《注册条款》 </a>
        </div>
    </fieldset>
    <fieldset>
    <fieldset>
    	<div class="checkbox col-lg-offset-2" >
            <button class="btn btn-theme-red01" style="width:290px;" id="submitRegBtn" type="submit">注册</button>
        </div>
    </fieldset>
    <fieldset>
    	<div class="checkbox col-lg-offset-2" >
            <button class="btn btn-theme-red01" style="width:290px;" type="button" onclick="javascrtpt:window.location.href='/login/login.htm'">已有账号，直接登录</button>
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
    
    $('#regForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user_name: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 8,
                        max: 15,
                        message: '请输入8到20个字符'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '登录名只能包含字母、数字、下划线（_）'
                    }
                }
            },
            anquanma: {
                message: 'The anquanma is not valid',
                validators: {
                    notEmpty: {
                        message: '安全码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 6,
                        message: '请输入6位数字安全码'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '安全码只能由数字组成'
                    }
                }
            },
            acceptTerms: {
                validators: {
                    notEmpty: {
                        message: '<span style="color:#a94442">同意该条款</span>'
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
                    },
                    stringLength: {
                        min: 8,
                        message: '不能少于8位'
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
            },captcha: {
                validators: {
                    callback: {
                        message: '验证码错误',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            }
        }
    });;
});
</script>
