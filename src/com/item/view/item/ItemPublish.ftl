<META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<link rel="stylesheet" href="/global/scripts/jquery-uploadify/uploadify.css"/>
<script type="text/javascript" src="/global/scripts/jquery-uploadify/jquery.uploadify.js"></script>
<div class="content-title">
	<span> 新任务发布</span>
</div>
<#if map?exists && map.success == '1'>
	<div class="alert alert-success">${map.message}</div>
<#else>
<div class="col-lg-10">
<form id="itemPublishForm" method="post" action="/item/itemPublishSubmit.htm" class="form-horizontal">
	<div class="form-group">
	    <span class="col-lg-3 control-label">宝贝来源</span>
	    <div class="col-lg-8">
	       	<select class="form-control" name="item_source">
		         <option value="淘宝">淘宝</option>
		         <option value="京东">京东</option>
		     </select>
	    </div>
	</div>
	<div class="form-group">
	    <span class="col-lg-3 control-label">宝贝连接地址</span>
	    <div class="col-lg-8">
	        <input type="text" class="form-control" name="item_link"/>
	    </div>
	</div>
    <div class="form-group">
        <span class="col-lg-3 control-label">宝贝金额/元</span>
        <div class="col-lg-8">
            <input type="number" class="form-control" id="item_one_cost" name="item_one_cost" value="" placeholder="该宝贝需要支付多少钱？"/>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-3 control-label">几天后确认收货评价</span>
        <div class="col-lg-8">
            <select class="form-control" name="comments_after">
		         <option value="1">1天</option>
		         <option value="2">2天</option>
		         <option value="3">3天</option>
		         <option value="4" selected="selected">4天</option>
		         <option value="5">5天</option>
		         <option value="6">6天</option>
		     </select>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-3 control-label">几星好评</span>
        <div class="col-lg-8">
            <select class="form-control" name="comments_stars">
		         <option value="1">1星</option>
		         <option value="2">2星</option>
		         <option value="3">3星</option>
		         <option value="4">4天</option>
		         <option value="5" selected="selected">5星</option>
		     </select>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-3 control-label">评价内容</span>
        <div class="col-lg-8">
            <textarea class="form-control" id="comments_content" name="comments_content" placeholder="300字以内..."></textarea>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-3 control-label">其他要求</span>
        <div class="col-lg-8">
            <textarea class="form-control" id="other_needs" name="other_needs" placeholder="1000字以内...如：具体操作流程请见附件"></textarea>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-9 col-lg-offset-2 control-label">如果有特殊要求，请上传word文档说明（先选择word文件，然后点击上传）</span>
    </div>
    <div class="form-group">
        <div class="col-lg-9 col-lg-offset-3">
            <input type="file" name="uploadify" id="uploadify"/>
			<div id="fileQueue"></div>
        </div>
    </div>
    <div class="form-group">
        <span class="col-lg-3 control-label" id="captchaOperation"></span>
        <div class="col-lg-8">
            <input type="text" class="form-control" name="captcha" placeholder="请输入左侧算式的计算结果"/>
        </div>
    </div>
	<div class="col-lg-offset-3" >
        <button class="btn btn-theme-red01" style="width:405px;" id="submitRegBtn" type="submit">提 交</button>
    </div>
</form>
</div>
<script type="text/javascript">
$(document).ready(function() {

	$('input[id=lefile]').change(function() {
		$('#photoCover').val($(this).val());
	});

    function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    function generateCaptcha() {
        $('#captchaOperation').html([randomNumber(1, 50), '+', randomNumber(1, 50), '='].join(' '));
    };
    generateCaptcha();
    
    $('#itemPublishForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            item_link: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    }
                }
            },
            item_one_cost: {
                validators: {
                    notEmpty: {
                        message: '宝贝金额不能为空'
                    }
                }
            },
            comments_content: {
                validators: {
                    notEmpty: {
                        message: '宝贝评价内容不能为空'
                    }
                }
            },
            other_needs: {
                validators: {
                    notEmpty: {
                        message: '宝贝评价内容不能为空'
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
            }
        }
    });;
});
</script>
<script>
$(document).ready( function() {
	   $('#uploadify').uploadify({
	     'swf':'/global/scripts/jquery-uploadify/uploadify.swf',
	     'uploader':'/service/UploadifyService',
	     'buttonText': '选择文档',
	     'method':'post',
         'fileTypeDesc': '请选择说明文档',
         'fileTypeExts': '*.*',
     	 'auto': false,//是否允许自动上传
     	 'fileSizeLimit':'10MB',//文件大小限制
         'multi': true,//是否允许选择多个文件
         'uploadLimit':1,//最多上传多少个文件
         'simUploadLimit':1,//最多允许多少个文件
         'onUploadSuccess':function(file,data,response){
	     	$('#uploadify').before('<span style="color:#F3726D">已上传 </span> '+file.name+'<br>');
	     	$('#uploadify').before('<input type="hidden" id="file_name" name="file_name" value='+data+'>');
          },
          onSelectError:function(){
          	alert('只能选择一个文件！');
          	return 0;
          }
    　　　});
    $('#uploadify').after('<a style="position:absolute;margin-left:130px;margin-top:-25px;" href="javascript:$(\'#uploadify\').uploadify(\'upload\',\'*\')">点击上传</a>');
});
</script>
</#if>