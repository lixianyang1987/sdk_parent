<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>管理平台主页</title>
	<link rel="shortcut icon" href="${basePath }/images/m.gif" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${basePath }/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${basePath }/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${basePath }/easyui/css/common.css">
	<script type="text/javascript" src="${basePath }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${basePath }/js/common.js"></script>
	<style type="text/css">
	   .treeLeaf{
	     text-decoration: none; 
	     color: #000000;
	   }
	</style>
</head>
<body class="easyui-layout" id="body">
    <!-- 顶部区域 -->
	<div data-options="region:'north'" style="height:40px;background:#f5f5f5;padding:10px">
	    <div style="display:inline-block;font-size:14px;color:#4A708B;text-align:center;width:570px;position: absolute;margin-left:28%;" id="versionTip">
		   请使用火狐或谷歌浏览器浏览此系统，对其它浏览器未做适配,不能很好的支持,点击隐藏。
		</div>
		<div style="font-size:18px;margin-left:10px;width:200px;display:inline-block;">管理后台</div>  
		<div style="float:right;margin-right:20px;display:inline-block;" >
			<button id="modifyPwdBtn">修改密码</button>
			<button  onclick="loginOut();">退出系统</button>
		</div>
    </div>
	<!-- 左边菜单 -->
	<div id="left" data-options="region:'west',split:true,collapsed:true,title:'欢迎${sessionUser.userName}用户'" style="width:180px;padding:1px;">  
      <ul id="tt" class="easyui-tree" data-options="lines:true,data:[{id:0,state:'closed',text:'管理系统',attributes:{isLeaf:0,loaded:0}}],onClick:clickNode,onBeforeExpand:beforeExpand"></ul> 
    </div>
    <!-- 右边菜单 -->
	<div  data-options="region:'east',split:true,collapsed:true,title:'消息提醒'" style="width:500px;padding:10px;">暂无消息</div>
	<!-- 中间区域 - -->	
	<div  id="center" data-options="region:'center',title:''">
	   <div id="tab">
	   </div>
	</div>
	<!-- 底部区域 - -->
	<div data-options="region:'south',split:true,collapsed:true" style="height:50px;padding:0px;">
	    <p style="text-align:center;text-valign:middle;font-size:14px;">合游天下科技有限公司</p>
	</div>
	<script type="text/javascript">
	    function addTab(title, url,update){
			if ($('#tab').tabs('exists', title)){
				$('#tab').tabs('select', title);
		        var tab = $('#tab').tabs('getSelected');  
		        var tabWd=$("#tab").width();
		       	var content = '<iframe scrolling="auto" frameborder="0" sss="'+tabWd+'"  src="'+url+'" style="width:100%;height:100%;margin-top:0;margin-bottom:0"></iframe>';
				$('#tab').tabs('update', {
					tab: tab,
					options: {
                     content:content
					}
				});	 
			} else {
				var tabWd=$("#tab").width();
				var content = '<iframe scrolling="auto" sss="'+tabWd+'"  frameborder="0"  src="'+url+'" style="width:100%;height:100%;margin-top:0;margin-bottom:0"></iframe>';
				$('#tab').tabs('add',{
					title:title,
					content:content,
					closable:true
				});
			}
		}
	    
	    $("#tab").tabs({
	    	fit:true,
	    	border:false,
			onSelect:function(title,index){
		 		  var tab=$("#tab").tabs("getSelected");
		 		  var sss=$(tab).find("iframe:first").attr("sss");
		 		  var tabWd=$("#tab").width();
		 		  if(sss < tabWd){
					  var content=$(tab).html();
					  content=$(content).attr("sss",tabWd);
					  $('#tab').tabs('update', {
							tab: tab,
							options: {
		                       content:content
							}
						});	 
		 		  }
			}
	    });
	   var basePath='${basePath}';
	   function beforeExpand(node){
		   loadChildMenus(node);
		   return true;
	   }
	   function clickNode(node){
	         loadChildMenus(node);
	         if(node.attributes.isLeaf!=1){
		          $('#tt').tree('toggle',node.target);
		     }
	   }
	   function loadChildMenus(node){
		     if(node.attributes.isLeaf==1||node.attributes.loaded==1){   
		         return;
		     }
		      $.ajax({
	  			type:"get",
	  			url:basePath+"/ajaxLoadMenus.action",
	  			dataType:'json',
	  			data:"pid="+node.id,
	  			async:false,
	  			success:function(data){
	  			     try{
	  			    	if(data.length>0){
		  			    	var subMenus=data;
					  		var nodeDatas=[];
				  		    for(var i=0,len=subMenus.length;i<len;i++){
				  		       var n={id:subMenus[i].id,text:subMenus[i].name,state:'closed',target:node};
				  		       if(subMenus[i].menuType==2){
				  		           n.text='<a class="treeLeaf" href=javascript:addTab("'+subMenus[i].name+'","'+(basePath+subMenus[i].url)+'");>'+subMenus[i].name+'</a>';
				  		           n.state='open';
				  		           n.iconCls="tree_node_icon_none"; 
				  		       }  
				  		       n.attributes={"isLeaf":subMenus[i].isLeaf};
				  		       nodeDatas.push(n);
				  		    }
			  			    $('#tt').tree('append',{
						         parent:node.target,
						         data: nodeDatas
						     });  
	  			    	}
	  			    	node.attributes.loaded=1;
	  			     }catch (e) {
						alert('加载菜单失败');
					}
	  			}
	  		});
	   }
	   
	   
	   $("#modifyPwdBtn").click(function(){
		   commonObj.toEditWithParams('${basePath}/common/toModifySelfPwd.action',500,300,'修改密码');
	   });
	   
       $(document).ready(function(){
		   $("#body").layout("expand","west");
		   $("#left").panel({
			   onCollapse:function(){
                  var tab=$("#tab").tabs("getSelected");
                  var sss=$(tab).find("iframe:first").attr("sss");
                  var tabWd=$("#tab").width();
		 		  if(sss < tabWd){
					  var content=$(tab).html();
					  content=$(content).attr("sss",tabWd);
					  $('#tab').tabs('update', {
							tab: tab,
							options: {
		                       content:content
							}
					 });	 
		 		  }
			  }
		   });  
		   $("#versionTip").click(function(){
			   $(this).hide();
		   });
	   });  
	</script>
</body>
</html>