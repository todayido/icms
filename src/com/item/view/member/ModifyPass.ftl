<div class="content-title">
	<span>登录密码修改</span>
</div>
<#if map?exists>
<div class="alert alert-success" style="line-height:25px;background:#FFF;border:solid 1px #eee">${map}</div>
</#if>
<div class="col-lg-10 col-lg-offset-2">
<form id="payForm" method="post" action="/member/modifyPassSumit.htm" class="form-horizontal">
   	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">原密码</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="old_pass"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">新密码</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="new_pass1"/>
		    </div>
		</div>
	</fieldset>
	<fieldset>
		<div class="form-group">
		    <span class="col-lg-2 control-label">确认新密码</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="new_pass2"/>
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
    <div class="form-group">
    	<span class="col-lg-2 control-label"></span>
        <div class="col-lg-6">	
        	<button class="btn btn-theme-red01" style="width:290px;" id="submitRegBtn" type="submit">确认修改</button>
        </div>
    </div>
    </fieldset>	
</form>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $('#payForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            old_pass: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '原密码不能为空'
                    }
                }
            },
            new_pass1: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'new_pass2',
                        message: '两次输入的密码不一致，请重新输入'
                    },
                    stringLength: {
                        min: 8,
                        message: '不能少于8位'
                    }
                }
            },
            new_pass2: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'new_pass1',
                        message: '两次输入的密码不一致，请重新输入'
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
