<link href="/global/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/global/bootstrap-3.3.5/css/bootstrapValidator.css"/>
<script src="/global/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/global/bootstrap-3.3.5/js/bootstrapValidator.js"></script>
<style>
.zhifubao-title{border-bottom:solid 1px #eee;margin:3px 0px 30px 0px ;font-size:14px;padding:2px;}
.zhifubao-title span{border-left:5px solid #F3726D;padding-left:5px;}
</style>
<div class="zhifubao-title">
	<span> 支付宝充值申请</span>
</div>
<div class="alert alert-success" style="display:none;line-height:25px;background:#FFF;border:solid 1px #eee"></div>
<div class="col-lg-10 col-lg-offset-2">
<form id="payForm" method="post" action="/payLog/zhifubaoSubmit.htm" class="form-horizontal">
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
		    <span class="col-lg-2 control-label">备注</span>
		    <div class="col-lg-6">
		        <input type="text" class="form-control" name="beizhu"/>
		    </div>
		</div>
	</fieldset>
    <fieldset>
    <div class="form-group">
    	<span class="col-lg-2 control-label"></span>
        <div class="col-lg-6">	
        	<button class="btn btn-theme-red01" style="width:290px;" id="submitRegBtn" type="submit">确认充值</button>
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
    });;
});
</script>
