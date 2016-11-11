(function($){
$.fn.clearForm=function(){
	$(this).find('input').val('');
}
/**
 * 打开一个没有按钮的对话框
 */
$.fn.utilsOpenDialogWithOutBth = function(width, height, title, href){
	//无按钮对话框
	var dialogid = '#'+$(this).attr('id');
	$(dialogid).dialog({    
	    title: title,    
	    width: width,    
	    height: height,    
	    closed: false,    
	    cache: false,    
	    href: href,    
	    modal: true,
	    maximizable:true,
	    resizable:true
	});
}
/**
 * 删除datagrid中选择的记录
 * @param dataTable:数据datagrid的id属性
 * @param primarykey:datagrid的主键标识
 * @param action:动作
 */
$.fn.utilsDeleteRows = function(tableid,primarykey,action){
    //删除操作
	var tableid = "#"+tableid;
	var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择要操作的对象','');
    }else{
    	$.messager.confirm('提示','确定要进行该操作吗？',function(r){
    		if(r){
    			var selectedRow = $(tableid).datagrid('getSelections');
    			var ids=[];
    			for ( var i = 0; i < selectedRow.length;i++) {
    				ids.push(selectedRow[i][primarykey]);
				}
				$.getJSON(action,
					{"params[]":ids},
					function(data){
						if(data>0){
							$.messager.alert('提示','删除成功','',function(){
								$(tableid).datagrid('clearSelections');
								$(tableid).datagrid("reload");
            				});
						}else{
							$.messager.alert("提示","操作失败 ，请重新尝试");
						}
					}
				);
          	}
		});
	}
}
/**
 * 
 * @param dialogid:窗口div的id属性
 * @param tableid:数据datagrid的id属性
 * @param width：窗口的宽度
 * @param height：窗口的高度
 * @param title：窗口的标题
 * @param href:窗口超链接
 * @return
 */
$.fn.utilsOpenDialogAdd = function(tableid, width, height, title, href){
	//添加对话框
	var dialogid = '#'+$(this).attr('id');
	var tableid = '#'+tableid;
	$(dialogid).dialog({    
	    title: title,    
	    width: width,    
	    height: height,    
	    closed: false,    
	    cache: false,    
	    href: href,    
	    modal: true,
	    maximizable:true,
	    resizable:true,
	    buttons: [{ 
	    	text: '保存', 
	    	handler: function(){ 
	    		//提交窗口中的表单
	    		var $form = $(dialogid).find("form");
	    		$form.form('submit',{
            		url:$form.action,
            		onSubmit:function(){
            			return  $form.form('validate');
            		},
            		success:function(data){
            			if(data>0){
            				$.messager.alert('提示','添加成功','',function(){
            					$(dialogid).dialog('close');
                				$(tableid).datagrid('reload');
            				});
            			}else{
            				$.messager.alert('提示','操作失败，请重新尝试','');  
            			}
            		}
            	});
	    	} 
	    	}, { 
	    	text: '取消', 
	    	handler: function(){
	    		$(dialogid).dialog('close'); 
	    	} 
	    }] 
	});
}
/**
 * @param action:修改动作
 * @param tableid:数据datagrid的id属性
 * @param primarykey:数据记录的主键，用来查找数据后修改数据。
 * @param width：窗口的宽度
 * @param height：窗口的高度
 * @param title：窗口的标题
 * @param href:窗口超链接
 * @return
 */
$.fn.utilsOpenDialogModify = function(tableid,primarykey,width,height,title,href){
    //修改操作
	var tableid = "#"+tableid;
	var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择要操作的记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录','');
    }else{
		var id = $(tableid).datagrid('getSelected')[primarykey];
			var dialogid = '#'+$(this).attr('id');
			$(dialogid).dialog({    
			    title: title,    
			    width: width,    
			    height: height,    
			    closed: false,    
			    cache: false,    
			    href: href+'?'+primarykey+'='+id,    
			    modal: true,
			    maximizable:true,
			    resizable:true,
			    buttons: [{ 
			    	text: '保存',
			    	handler: function(){ 
			    		//提交窗口中的表单
			    		var $form = $(dialogid).find("form");
			    		$form.form('submit',{
		            		url:$form.action,
		            		onSubmit:function(){
		            			return  $form.form('validate');
		            		},
		            		success:function(data){
		            			if(data>0){
		            				$.messager.alert('提示','修改成功','',function(){
		            					$(dialogid).dialog('close');
		                				$(tableid).datagrid('reload');
		            				});
		            			}else{
		            				$.messager.alert('提示','操作失败，请重新尝试','');  
		            			}
		            		}
		            	});
			    	}
			    },{ 
			    	text: '取消', 
			    	handler: function(){
			    		$(dialogid).dialog('close'); 
			    	} 
			    }] 
			});
	}
}
/**
 * @param action:打开操作窗口
 * @param tableid:数据datagrid的id属性
 */
$.fn.utilsOpenDialogWithMorePrams = function(tableid,primarykey,width,height,title,href){
	var tableid = "#"+tableid;
	var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择一条记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录','');
    }else{
		var id = $(tableid).datagrid('getSelected')[primarykey];
			var dialogid = '#'+$(this).attr('id');
			$(dialogid).dialog({    
			    title: title,    
			    width: width,    
			    height: height,    
			    closed: false,    
			    cache: false,    
			    href: href+'&'+primarykey+'='+id,    
			    modal: true,
			    maximizable:true,
			    resizable:true,
			    buttons: [{ 
			    	text: '提交', 
			    	handler: function(){ 
			    		//提交窗口中的表单
			    		var $form = $(dialogid).find("form");
			    		$form.form('submit',{
		            		url:$form.action,
		            		onSubmit:function(){
		            			return  $form.form('validate');
		            		},
		            		success:function(data){
		            			if(data>0){
		            				$.messager.alert('提示','操作成功','',function(){
		            					$(dialogid).dialog('close');
		                				$(tableid).datagrid('reload');
		            				});
		            			}else{
		            				$.messager.alert('提示','操作失败，请重新尝试','');  
		            			}
		            		}
		            	});
			    	} 
			    	}, { 
			    	text: '取消', 
			    	handler: function(){
			    		$(dialogid).dialog('close'); 
			    	} 
			    }] 
			});
	 }
}
/**
 * 没有提交按钮的弹出窗
 */
$.fn.utilsOpenDialogWithoutBtn = function(tableid,primarykey,width, height, title, href){
	var tableid = "#"+tableid;
	var rows = $(tableid).datagrid('getSelections');
    if(rows.length==0){
    	$.messager.alert('提示','请选择一条记录','');
    }else if(rows.length>1){
    	$.messager.alert('提示','只能选择一条记录','');
    }else{
    	var dialogid = '#'+$(this).attr('id');
    	var id = $(tableid).datagrid('getSelected')[primarykey];
    	var tableid = '#'+tableid;
    	$(dialogid).dialog({    
    	    title: title,    
    	    width: width,    
    	    height: height,    
    	    closed: false,    
    	    cache: false,    
    	    href: href+'?'+primarykey+'='+id,
    	    modal: true,
    	    maximizable:true,
    	    resizable:true
    	});
    }
}
/**
 * json提交
 */
$.fn.utilsJsonPost = function(){
	var $form = $(this);
	$form.form('submit',{
		url:$form.action,
		success:function(data){
			if(data>0){
				showTips('操作成功','35','1');
				//$.messager.alert('提示','保存成功！','');
			}else{
				showTips('操作失败，请重新尝试','0','1');
			}
		}
	});
}
/**
 * json提交，弹出指定的提示内容
 */
$.fn.utilsJsonPostWithMessages = function(tips){
	var $form = $(this);
	$form.form('submit',{
		url:$form.action,
		success:function(data){
			if(data>0){
				$.messager.alert('提示',tips+'成功！','');
			}else{
				$.messager.alert('提示',tips+'失败，请重新尝试','');  
			}
		}
	});
}
})(jQuery);

function showTips( tips, height, time ){
  var windowWidth  = $(window).width();
  var tipsDiv = '<div class="tipsClass">' + tips + '</div>';
  $('body').append(tipsDiv);
  $( 'div.tipsClass' ).css({
      'top'       : height+ 'px',
      'left'      : '35px',//( windowWidth / 2 )-( tips.length * 7 ) + 'px', 
      'position'  : 'absolute',
      'padding'   : '6px 10px',
      'background': '#1D6BA3',
      'font-size' : 15 + 'px',
      'margin'    : '0 auto',
      'font-family':'Microsoft YaHei',
      'text-align': 'center',
      'width'     : '100',
      'color'     : '#FFF',
      'opacity'   : '0.8',
      'zIndex'    :'9999',
  }).show();
  setTimeout( function(){$( 'div.tipsClass' ).fadeOut();}, ( time * 1000 ) );
}

//easyui时间格式化
function formatDatebox(value,row,index) {
    var date = new Date(value.time);
    var m = date.getMonth()+1;
    if(m<10){
    	m = '0'+m;
    }
    
    var d = date.getDate();
    if(d<10){
    	d = '0'+d;
    }
    
    var h = date.getHours();
    if(h<10){
    	h = '0'+h;
    }
    
    var mi = date.getMinutes();
    if(mi<10){
    	mi = '0'+mi;
    }
    
    var s = date.getSeconds();
    if(s<10){
    	s = '0'+s;
    }
    return date.getFullYear()+'-'+(m)+'-'+(d)+' '+(h)+':'+(mi)+':'+(s);
}



