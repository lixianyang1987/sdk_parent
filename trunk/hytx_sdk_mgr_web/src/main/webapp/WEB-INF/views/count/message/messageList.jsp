<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
     <div id="tip" style="text-align:center;font-size:16px;margin-top:50px;">暂时没有提醒消息</div>
	 <table id="dg" style="width:auto;height:auto;"></table>
	 <table id="msApp" style="width:auto;height:auto;"></table>
	 <script type="text/javascript">
	   var fields=[[
					{field:'name',title:'名称',width:80,align:'center'},
					{field:'provinceName',title:'省份',width:80,align:'center'},
					{field:'dayLimit',title:'日限额',width:100,align:'center'},
					{field:'consumer',title:'今日消费',width:100,align:'center'},
					{field:'percent',title:'使用百分比',width:100,align:'center',formatter: function(value,row,index){
						if (row.dayLimit>0){
							 return Math.round(row.consumer*10000/row.dayLimit,4)/100+'%';
						}
					}}
				]];
	   $(document).ready(function(){
		   $.ajax({
			   url:'${basePath}/count/message/channelAppMessageList.action',
			   type:'get',
			   dataType:'json',
			   success:function(dt){
				   try{
					   if(dt.msChannelApp.length>0){
						   $("#tip").remove();
						   $('#dg').datagrid({
							    singleSelect:false,
								remoteSort:false,
								title:'渠道包消息提醒列表<span style="margin-left:50px;color:#ff0000;">只显示用量超过日限量80%的数据</span>',
								columns:fields,
								data:dt.msChannelApp
						   });
					   }
				   }catch(e){
					   alert(e);
				   }
			   }
		   });   
		   
		   
		   $.ajax({
			   url:'${basePath}/count/message/appMessageList.action',
			   type:'get',
			   dataType:'json',
			   success:function(dt){
				   try{
					   if(dt.msApp.length>0){
						   $("#tip").remove();
						   $('#msApp').datagrid({
							    singleSelect:false,
								remoteSort:false,
								title:'应用消息提醒列表<span style="margin-left:50px;color:#ff0000;">只显示用量超过日限量80%的数据</span>',
								columns:fields,
								data:dt.msApp
						   });
					   }
				   }catch(e){
					   alert(e);
				   }
			   }
		   });   
	   });
	   
	</script>
</body>
</html>