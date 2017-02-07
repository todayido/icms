<link href="/global/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/global/bootstrap-3.3.5/css/bootstrapValidator.css"/>
<script src="/global/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/global/bootstrap-3.3.5/js/bootstrapValidator.js"></script>
<div style="border-bottom:solid 1px #eee;margin:3px 0px 30px 0px ;font-size:16px;">
	<span style="border-left:3px solid #F3726D;padding-left:5px;"> 支付宝充值申请</span>
</div>
<div class="alert alert-success" style="display:none;"></div>
<form id="payForm" method="post" action="/register/doRegister.htm" class="form-horizontal">
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
		    <span class="col-lg-2 control-label">充值金额</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="money"/>
		    </div>
		</div>
	</fieldset>
    <fieldset>
    <div class="form-group">
        <div class="col-lg-9">	
        	<button class="btn button-width-280" id="submitRegBtn" type="submit">确认充值</button>
        </div>
    </div>
    </fieldset>	
</form>
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
            }
        }
    }).on('success.form.bv', function(e) {
            e.preventDefault();
            // Get the form instance
            var $form = $("#regForm");
            var bv = $form.data('bootstrapValidator');
            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
	            if(result==1){
	            	$('.alert').html('请重新输入账号，账号为空不能注册!').show();
                	$("#submitRegBtn").removeAttr('disabled');
	            }else{
	            	$('.alert').html('注册失败，请联系管理员 ').show();
	            }
               
            }, 'json')
        });;
});
</script>
