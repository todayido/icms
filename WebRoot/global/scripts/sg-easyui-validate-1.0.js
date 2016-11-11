$.extend($.fn.validatebox.defaults.rules, {
    username: {
       validator: function (value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
    },
    number:{
    	validator: function (value) {
    		return !isNaN(value);
    	},
    	message: '必须为数字'
    },
    equalTo:{
    	validator: function (value, param) {
    		return $(param[0]).val()==value;
        },
        message: '两次密码不一致'
    }
}); 