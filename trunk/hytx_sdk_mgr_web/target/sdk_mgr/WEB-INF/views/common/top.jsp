<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="${basePath }/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${basePath }/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${basePath }/easyui/css/common.css">
	<script type="text/javascript" src="${basePath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${basePath }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${basePath }/js/common.js"></script>
	<script type="text/javascript">
        $.extend($.fn.validatebox.defaults.rules, {
	        minLength: {
		        validator: function(value, param){
		       	  return value.length >= param[0];
		        },
		        message: '请输入至少{0}个字符'
	        },
	        maxLength: {
		        validator: function(value, param){
		       	  return value.length <= param[0];
		        },
		        message: '最多只能输入{0}个字符'
	        },
	        number: {
		        validator: function(value, param){
		          var regex= /^[\-\+]?((([0-9]{1,3})([,][0-9]{3})*)|([0-9]+))?([\.]([0-9]+))?$/;
		       	  return regex.test(value);;
		        },
		        message: '无效的数值'
	        },
	        minNum: {
		        validator: function(value, param){
		          var regex= /^[\-\+]?((([0-9]{1,3})([,][0-9]{3})*)|([0-9]+))?([\.]([0-9]+))?$/;
		       	   if(regex.test(value)){
		       		   var intVal=parseInt(value);
		       		   return intVal>=param[0];
		       	   }else{
		       		   return false;
		       	   }
		        },
		        message: '请输入大于或等{0}的整数'
	        },
	        phone: {
		        validator: function(value, param){
		          var regex= /^([\+][0-9]{1,3}[ \.\-])?([\(]{1}[0-9]{2,6}[\)])?([0-9 \.\-\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/;
		       	  return regex.test(value);;
		        },
		        message: '无效的电话号码'
	        },
	        date: {
		        validator: function(value, param){
		          var regex=/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
		       	  return regex.test(value);;
		        },
		        message: '无效的日期，格式必需为 YYYY-MM-DD'
	        },
	        myTime: {
		          validator: function(value, param){
		          if(value=='0'){
		        	  return true;
		          }
		          var regex= /^[0-9]{2}:[0-9]{2}$/;
		       	  return regex.test(value);;
		        },
		        message: '无效的时间格式，此输入接受的格式为HH:mm'
	        }
        });
        var authStr,authArr,auths='${auths}';
        if(auths!=''){
        	authStr=auths.substring(1,auths.length-1);
        	authArr=authStr.split(',');
    	 }
        //datagrid 权限验证
        function filterAuth(dg_options){
     	   var tb=dg_options.toolbar;
     	   if(!tb || tb.length<1){
     		   return;
     	   }
     	   var mytoolbar=[];
     	   if(auths==''){
     		   return;
     	   }
     	   for(var i=0;i<tb.length;i++){
    		   for(var n=0;n<authArr.length;n++){
    			   if($.trim(authArr[n]) == tb[i].text){
    				   mytoolbar.push(tb[i]);
    			   }
    		   }
    	   }
    	   dg_options.toolbar=mytoolbar;
    	   $("input[type='button']").each(function(i,n){
    		   if(findIndexInArray(authArr,$(n).val())<0){
    			   $(this).remove(); 
    		   }
     	   });
    	   
    	   $(".easyui-linkbutton").each(function(i,n){
    		   if(findIndexInArray(authArr,$(n).text())<0){
    			   $(this).remove(); 
    		   }
     	   });
    	   $(".selectBtn").each(function(i,n){
    		   if(findIndexInArray(authArr,$(n).text())<0){
    			   $(this).remove(); 
    		   }
     	   });
        }
        //不带datagrid的权限过滤
        function baseAuthFilter(){
           if(auths==''){
       		   return;
       	   }
       	   $("input[type='button']").each(function(i,n){
	  		   if(findIndexInArray(authArr,$(n).val())<0){
	  			   $(this).remove(); 
	  		   }
	   	   });
	  	   
	  	   $(".easyui-linkbutton").each(function(i,n){
	  		   if(findIndexInArray(authArr,$(n).text())<0){
	  			   $(this).remove(); 
	  		   }
	   	   });
	  	   $(".selectBtn").each(function(i,n){
	  		   if(findIndexInArray(authArr,$(n).text())<0){
	  			   $(this).remove(); 
	  		   }
	   	   });
        }
        //查询某元素在数组中的下标，找不到返回-1
        function findIndexInArray(arr,n){
        	for(var i=0;i<arr.length;i++){
        		if($.trim(arr[i]) == n){
        			return i;
        		}
        	}
        	return -1;
        }
        //导出xls的方法调用 
        function exportXls(data,fields){
        	if(!data || data.rows.length<1){
        		alert('没有可导出的数据');
        		return;
        	}
        	var form=$("#exportXlsForm");
        	if(form.length<1){
	           var formHtml='<form id="exportXslForm" action="${basePath}/count/export/exportXls.action" method="post">'
				    		   + '<input type="hidden" name="rows"/>'
				    		   + '<input type="hidden" name="fields"/>'
				    		+'</form>';
	    		$("body").append(formHtml);
	    		form=$("#exportXlsForm");
        	}
        	 $("#exportXslForm").find("input[name='rows']").val(JSON.stringify(data.rows));
        	 $("#exportXslForm").find("input[name='fields']").val(fields.join(","));
        	 $("#exportXslForm").submit();
        }
	</script>
</head>
<body>