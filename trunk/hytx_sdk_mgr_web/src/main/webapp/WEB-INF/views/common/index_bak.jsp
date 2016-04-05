<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<body class="easyui-layout">
    <!-- 顶部区域 -->
	<div data-options="region:'north',border:false" style="height:40px;background:#f5f5f5;padding:10px">
		<div style="font-size:18px;margin-left:10px;width:200px;display:inline-block;">合游天下科技有限公司</div> 
    </div>
	<!-- 左边菜单 -->
	<div data-options="region:'west',split:true,title:'欢迎使用'" style="width:180px;padding:1px;">  
      <ul id="tt"></ul> 
    </div>
	<div data-options="region:'east',split:true,collapsed:true,title:'消息提醒'" style="width:100px;padding:10px;">暂无消息</div>
	<!-- 底部区域 - -->
	<div data-options="region:'south',split:true,collapsed:true" style="height:50px;padding:0px;">
	    <p style="text-align:center;text-valign:middle;font-size:14px;">合游天下科技有限公司</p>
	</div>
	<!-- 中间区域 - -->
	<div id="tab"  data-options="region:'center'" class="easyui-tabs">	
	</div>
	<script type="text/javascript">
	   var basePath='${basePath}';
	   var  dataMenus=[{id:0,state:'closed',text:'管理系统',children:[
				  { text:'<a class="treeLeaf" href=javascript:addTab("CP管理","${basePath}/baseConf/cpInfo/cpInfoList.action");>CP管理</a>'
					   ,iconCls:"tree_node_icon_none"} 
				,{ text:'<a class="treeLeaf" href=javascript:addTab("应用管理","${basePath}/baseConf/appInfo/appInfoList.action");>应用管理</a>'
					   ,iconCls:"tree_node_icon_none"}                                                   
	           ,{ text:'<a class="treeLeaf" href=javascript:addTab("渠道同步配置","${basePath}/baseConf/channelSync/channelSyncList.action");>渠道同步配置</a>'
	        	   ,iconCls:"tree_node_icon_none"} 
        	   ,{ text:'<a class="treeLeaf" href=javascript:addTab("渠道管理","${basePath}/baseConf/channel/channelList.action");>渠道管理</a>'
	        	   ,iconCls:"tree_node_icon_none"}
	          ,{ text:'<a class="treeLeaf" href=javascript:addTab("渠道扣量管理","${basePath}/baseConf/channelReduce/channelReduceList.action");>渠道扣量管理</a>'
	        	   ,iconCls:"tree_node_icon_none"}
	        ]}];
	   
	       $('#tt').tree({
	           data: dataMenus,
	           lines:true
	        });
	   
	</script>
</body>
</html>