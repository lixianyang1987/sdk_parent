<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>订单统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countSyncAllByDate" method="post" id="findForm">
		       <table id="findTable">
			         <tr>
			          <th width="65px">所属CP:</th>
			          <td width="8px">
				         <form:select path="cpId" id="cpId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${cpList}"  itemLabel="cpName"  itemValue="id"/>
	                     </form:select>
			          </td>
			          <th width="65px">渠道:</th>
			          <td width="8px">
			           		<form:select path="channelId" id="channelId" cssClass="easyui-validatebox" style="width:152px;height:26px;">
			           		    <form:option value="-1">=全部=</form:option>
	                            <form:options  items="${channelList}" itemLabel="channelName" itemValue="id"/>
			           		</form:select>
			          </td>
			          <th width="80px">
			                                  应用:
			          </th>
			          <td width="8px">
			              <form:select path="appId" id="appId"  cssClass="easyui-validatebox" style="width:152px;height:26px;">
			                  <form:option value="-1">=全部=</form:option>
	                          <form:options items="${appList}" itemLabel="appName" itemValue="id"/>
			              </form:select>
			          </td>
		         </tr> 
		         <tr>
		              <th>运营商:</th>
			          <td>
			             <form:select id="serverType" path="serverType" cssClass="easyui-validatebox"  cssStyle="width:152px;height:26px;">
		                     <form:option value="0">=全部=</form:option>
			   		         <form:option value="1">移动</form:option>
			   		         <form:option value="2">联通</form:option>
			   		         <form:option value="3">电信</form:option>
					   </form:select>
			          </td>
			          <th>开始日期:</th>
			          <td>
			             	<input type="text" id="startDate" name="startDate" value="${findDto.startDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <th>结束日期:</th>
			          <td>
			             <input type="text" id="endDate" name="endDate" value="${findDto.endDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <td>
			             <input type="button" id="findBtn" style="margin-left:15px;" class="findBtn" value="查询"/>
			          </td>
		         </tr> 
		       </table>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>  
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'日期',sortable:true">日期</th>
			    <th data-options="field:'省份',sortable:true">省份</th>
			    <th data-options="field:'运营商',sortable:true">运营商</th>
			    <th data-options="field:'渠道名称',sortable:true">渠道名称</th> 
			    <th data-options="field:'应用名称',sortable:true">应用名称</th> 
			    <th data-options="field:'资费',sortable:true">资费</th> 
			    <th data-options="field:'cp请求数',sortable:true">cp请求数</th> 
			    <th data-options="field:'上行总数',sortable:true">上行总数</th> 
			    <th data-options="field:'上行成功数',sortable:true">上行成功数</th> 
			    <th data-options="field:'用户请求率',sortable:true">用户请求率</th> 
			    <th data-options="field:'上行成功率',sortable:true">上行成功率</th> 
			     <th data-options="field:'二次回复数',sortable:true">二次回复数</th> 
			    <th data-options="field:'二次成功数',sortable:true">二次成功数</th> 
			    <th data-options="field:'二次失败数',sortable:true">二次失败数</th> 
			    <th data-options="field:'计费总数',sortable:true">计费总数</th> 
			    <th data-options="field:'计费成功数',sortable:true">计费成功数</th> 
			    <th data-options="field:'计费成功金额',sortable:true">计费成功金额</th> 
			    <th data-options="field:'计费成功率',sortable:true">计费成功率</th> 
			    <th data-options="field:'通道转化率',sortable:true">通道转化率</th>  
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.date}</td>
			           <td>${item.provinceName}</td>
			           <td>${item.serverType==1?'移动':item.serverType==2?'联通':item.serverType==3?'电信':''}</td>
			           <td><a href="javascript:toTabLink('渠道管理','${basePath}/baseConf/channel/channelList?channelName=${item.channelName}');" class="link_a">${item.channelName}</a></td>
			           <td><a href="javascript:toTabLink('应用管理','${basePath}/baseConf/app/appList?appName=${item.appName}');" class="link_a">${item.appName}</a></td>
			           <td>${item.feeValue/100}元</td>
			           <td>${item.allFee}</td>
			           <td>${item.failFee+item.sucFee}</td>
			           <td>${item.sucFee}</td>
			           <td><fmt:formatNumber type="percent" maxFractionDigits="2" value="${item.allFee>0?(item.failFee+item.sucFee)/(item.allFee):0}"/></td>
			           <td><fmt:formatNumber type="percent" maxFractionDigits="2" value="${item.sucFee>0?item.sucFee/(item.sucFee+item.failFee):0}"/></td>
			           <td>${item.ensureCount}</td>
			           <td>${item.ensureSucCount}</td>
			           <td>${item.ensureFailCount}</td>
			           <td>${item.cnFailFee+item.cnSucFee}</td>
			           <td>${item.cnSucFee}</td>
			           <td>${item.cnSucFee*item.feeValue/100}元</td>
			           <td><fmt:formatNumber type="percent" maxFractionDigits="2" value="${item.cnSucFee>0?item.cnSucFee/(item.cnSucFee+item.cnFailFee):0}"/></td>
			           <td><fmt:formatNumber type="percent" maxFractionDigits="2" value="${item.sucFee>0?(item.cnSucFee)/(item.sucFee):0}"/></td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<%@include file="../../common/pageEasyui.jsp" %>
		<script type="text/javascript">
		$(document).ready(function(){
		  var options={
				    remoteSort:false,
					title:'订单列表<span style="margin-left:50px;color:#ff0000;">选择日期后才能查询数据</span>',
					toolbar:[
					         {
				                id: 'btnAdd',
				                text: '导出xls',
				                iconCls: 'icon-add',
				                handler: function () {
				                	 var data=$('#dg').datagrid("getData");
				                	 var fields=$("#dg").datagrid("getColumnFields",false);
				                	 exportXls(data,fields);
				                }
			                 }
					    ]
		  };
		  filterAuth(options);
		  $('#dg').datagrid(options);
		  coculateTotal();
		  
		});
		
		
		function coculateTotal(){
			var data=$('#dg').datagrid("getData");
			console.log(data);
			if(data.total<1){
				return;
			}
			var cpReq=0,upSms=0,upSucSms=0,sync=0,syncSuc=0,sucFee=0,ensureCount=0,ensureSucCount=0,ensureFailCount=0;
			var rows=data.rows;
			for(var i=0;i<data.total;i++){
				cpReq=cpReq+parseInt(rows[i].cp请求数);
				upSms=upSms+parseInt(rows[i].上行总数);
				upSucSms=upSucSms+parseInt(rows[i].上行成功数);
				sync=sync+parseInt(rows[i].计费总数);
				syncSuc=syncSuc+parseInt(rows[i].计费成功数);
				sucFee=sucFee+parseFloat(rows[i].计费成功金额);
				ensureCount=ensureCount+parseInt(rows[i].二次回复数);
				ensureSucCount=ensureSucCount+parseInt(rows[i].二次成功数);
				ensureFailCount=ensureFailCount+parseInt(rows[i].二次失败数);
			}
			$('#dg').datagrid('appendRow',{
				日期:'汇总',
				cp请求数:cpReq,
				上行总数: upSms,
				上行成功数:upSucSms,
				计费总数: sync,
				计费成功数:syncSuc,
				二次回复数:ensureCount,
				二次成功数:ensureSucCount,
				二次失败数:ensureFailCount,
				计费成功金额:sucFee==0?0.0+"元":new Number(sucFee).toFixed(1)+"元",
				上行成功率:upSms==0?"0%":parseInt(upSucSms*100/upSms)+"%",
				用户请求率:cpReq==0?"0%":parseInt(upSms*100/cpReq)+"%",
				计费成功率:sync==0?"0%":parseInt(syncSuc*100/sync)+"%",
				通道转化率:upSms==0?"0%":parseInt(syncSuc*100/upSucSms)+"%",
		     });
			
		}
		
		 $("#findBtn").click(function(){
			 var endDate=$('#endDate').datebox('getValue');
			 var startDate=$('#startDate').datebox('getValue');
			 if(endDate < startDate){
				 alert('开始日期必须小于结束日期');
				 return false;
		      }
    		  document.forms['findForm'].submit();
		 });
		 
		$("#cpId").change(function(){
			var cpId=$("#cpId").val();
			reloadChannel(cpId);
			reloadApp(cpId,-1);
		});
		
		$("#channelId").change(function(){
			var cpId=$("#cpId").val();
			var channelId=$("#channelId").val();
			reloadApp(cpId,channelId);
		});
		
		function reloadApp(cpId,channelId){
			 $.ajax({
				 url:'${basePath}/baseConf/app/selectApp.action',
				 type:'get',
				 dataType:'json',
				 data:{"cpId":cpId,"channelId":channelId},
				 success:function(data){
					 $("#appId").empty();
					 $("#appId").append('<option value="-1" selected="selected">=全部=</option>');
					 for(var i=0;i<data.length;i++){
						 $("#appId").append('<option value="'+data[i].id+'">'+data[i].appName+'</option>');
					 }
				 }
			 });
		 }
		function reloadChannel(cpId){
			 $.ajax({
				 url:'${basePath}/baseConf/channel/selectChannelsByCp.action',
				 type:'get',
				 dataType:'json',
				 data:{"cpId":cpId},
				 success:function(data){
					 $("#channelId").empty();
					 $("#channelId").append('<option value="-1" selected="selected">=全部=</option>');
					 for(var i=0;i<data.length;i++){
						 $("#channelId").append('<option value="'+data[i].id+'">'+data[i].channelName+'</option>');
					 }
				 }
			 });
		 }
		
		 
		</script>
</body>
</html>