 //日期对象转成日期字符串
function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
 //日期字符串转成日期对象
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}

//日期+时间对象转成日期+时间字符串
function mydatetimeformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			var h= date.getHours();
			var f= date.getMinutes();
			var s= date.getSeconds();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(f<10?('0'+f):f)+':'+(s<10?('0'+s):s);
}
//日期+时间字符串转成日期+时间对象
function mydatetimeparser(s){
	if (!s) return new Date();
	var ds=(s.split(' '));
	var ss = (ds[0].split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	
	var tt = (ds[1].split(':'));
	var h = parseInt(tt[0],10);
	var f = parseInt(tt[1],10);
	var s = parseInt(tt[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d,h,f,s,0);
	} else {
		return new Date();
	}
}

//日期对象转成日期字符串HH:mm
function myformatterTime(date){
	        var h= date.getHours();
	        var m= date.getMinutes();
			return (h>10?h:'0'+h)+':'+(m<10?('0'+m):m);
}
 //日期字符串HH:mm转成日期对象
function myparserTime(s){
	var date=new Date();
	if (!s) return date;
	var ss = (s.split(':'));
	var h = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	if (!isNaN(h) && !isNaN(m)){
		 date.setHours(h);
		 date.setMinutes(m);
	} 
	return date;
}


function addParentTabs(title,url){
    top.addTab(title,url,true);
  }
//自适应百分比宽度
function fixWidth(percent)  
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
} 
//自适应百分比高度
function fixHeight(percent)  
{  
    return document.body.clientHeight * percent ; //这里你可以自己做调整  
}
//列排序方法
function myNumsorter(a,b){
    return Number(a)>Number(b)?1:-1;   
}
//退出
function loginOut(){
	  window.top.location.href=basePath+'/common/logout';
} 

function toTabLink(title,url){
	window.top.addTab(title,url);
}


commonObj={
	apply:function(o,c,defaults){
		if(defaults){
			apply(o,defaults);
		}
		if(o && c && typeof c == 'object'){
			for(var v in c){
				o[v]=c[v];
			}
		}
		return o;
	},
	showDialog:function(config){
		if(!config.width){
			config.width=400;
		}
		if(!config.height){
			config.height=300;
		}
		this.apply(config,{
			  closed: false, 
			  cache: false,  
			  minimizable:true,
			  maximizable:true,
			  resizable:true,
			  modal: true,
			  onMove:function(left,top){
					if(top<1){
						$('#mydialog').dialog("move",{left:left,top:1});
					}
					if(left<1){
						$('#mydialog').dialog("move",{left:1,top:top});
					}
				},
			  inline:false
		});
		if($('#mydialog').length<1){
			$("body").append('<div id="mydialog"></div>');
		}
		$('#mydialog').dialog(config);   
	},
	addSecondWin:function(tit,url,width,height){
		this.openSelectWindow({
			href:url,
			title:tit,
			modal: true,
			width:width,
            height:height
		});
	},
	openSelectWindow: function(config){
		if(!config.width){
			config.width=400;
		}
		if(!config.height){
			config.height=300;
		}
		var href=''
		if(config.href){
			href=config.href;
			delete config.href;
		}
		config.onMove=function(left,top){
			if(top<1){
				$('#mydialog2').dialog("move",{left:left,top:1});
			}
			if(left<1){
				$('#mydialog2').dialog("move",{left:1,top:top});
			}
		};
		if($("#mydialog2").length<1){
			$("body").append('<div id="mydialog2"> </div>')
		}
		$('#mydialog2').dialog(config);  
		$('#mydialog2').html('<iframe src="'+href+'" frameborder="0" scrolling="no" width="100%" height="100%"></iframe>');
	},
	toAdd:function(tit,url,width,height){
		this.showDialog({
			href:url,
			title:tit,
			width:width,
            height:height
		});
	},
	toEdit:function(uri,width,height,title){
		 var ids=this.getSelectIdValues();
         if(ids.length<1){
            commonObj.showAlert("请选择要编辑的记录");
            return;
         }else if(ids.length>1){
            commonObj.showAlert("编辑只能选择一条记录");
            return;
         }
         this.showDialog({
             href:uri+"?id="+ids[0] ,
             title:title||'编辑' ,
             width:width,
             height:height
           });
	},
	toEditWithParams:function(url,width,height){
        this.showDialog({
            href:url,
            title:'编辑' ,
            width:width,
            height:height
          });
	},
	toDel:function(callback,tip){
     	var ids=this.getSelectIdValues();
        if(ids.length<1){
           this.showAlert("请选择要删除的记录");
           return;
        }else{
            $.messager.confirm("删除确认",tip||"你确定要删除所选记录吗?",function(r){
            	callback(r,ids);
            });
        }  
    },toDetailWithParam:function(uri,width,height){
         this.showDialog({
             href:uri,
             title:'查看详情' ,
             width:width,
             height:height
           });
	},toDetail:function(uri,width,height){
		 var ids=this.getSelectIdValues();
         if(ids.length<1){
            commonObj.showAlert("请选择要查看详情的记录");
            return;
         }else if(ids.length>1){
            commonObj.showAlert("查看详情只能选择一条记录");
            return;
         }
         this.showDialog({
             href:uri+"?id="+ids[0] ,
             title:'查看详情' ,
             width:width,
             height:height
           });
	},
	getSelectIdValues:function(){
		   var idValues=[];
		   $("input[name='id']:checked").each(function() {
			   idValues.push($(this).val());
	        });
		    return idValues;
		},
	getRadioIdValue:function(){
		   var idValues=this.getSelectIdValues();
		   if(idValues.length>0){
			   return idValues[0];
		   }
		   return null;
	},
	getTableSelectIdValues:function(){
		   var idValues=[];
		   $('.datagrid-btable').find("input[name='id'][type='checkbox']:checked").each(function() {
			   idValues.push($(this).val());
	        });
		   return idValues;
		},
	getDataMapValue:function(dataMap,key){
		for(i=0,len=dataMap.length;i<len;i++){
			if(dataMap[i][0]==key){
				return dataMap[i][1];	
			}
		}
		return null;
	},
	showOpTip:function(tip,callback,inspeed,outspeed){
		    var ins = typeof inspeed === 'number'?inspeed:1000;
		    var outs = typeof outspeed === 'number'?outspeed:1000;
		    if($("#tipDiv").length<1){
		    	$("body").append('<div id="tipDiv" class="tipClass" style="z-index:50000"></div>');
		    }
		    $("#tipDiv").html(tip);
		    $("#tipDiv").fadeIn(ins,function(){
		            $("#tipDiv").fadeOut(outs,callback);
		    });
	},
    showAlert:function(){
    	if(arguments.length==0){
    		return;
    	}else if(arguments.length==1){
    		//$.messager.alert('提示',arguments[0]);
    		$.messager.show({
    			title:'提示',
    			msg:arguments[0],
    			showType:'show',
    			style:{
    				right:'',
    				top:document.body.scrollTop+document.documentElement.scrollTop,
    				bottom:''
    			}});
    		return;
    	}else if(arguments.length==2){
    		$.messager.alert(arguments[0],arguments[1]);
    		return;
    	}else if(arguments.length==3){
    		$.messager.alert(arguments[0],arguments[1],arguments[2]);
    		return;
    	}
    }
	
	
};
