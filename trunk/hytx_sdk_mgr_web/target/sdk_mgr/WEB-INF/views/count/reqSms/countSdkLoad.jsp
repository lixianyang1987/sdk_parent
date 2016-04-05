<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>SDK启动日志查询</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countSdkLoad" method="post" id="findForm">
		       <table id="findTable">
		         <tr>
			          <th width="65px">渠道:</th>
			          <td width="8px">
			           		<form:select path="channelId" id="channelId"  cssClass="easyui-validatebox" style="width:152px;height:26px;">
			           			<form:option value="-1">=全部=</form:option>
			           		    <form:options items="${chList}" itemLabel="channelName" itemValue="id"/>
			           		</form:select>
			          </td>
			          <th width="50px">
			                                  应用:
			          </th>
			          <td width="8px">
			              <form:select path="appId"  id="appId" cssClass="easyui-validatebox" style="width:152px;height:26px;">
			               	  <form:option value="-1">=全部=</form:option>
			           		   <form:options items="${appList}" itemLabel="appName" itemValue="id"/>
			              </form:select>
			          </td>
		 
			          <th width="75px">开始日期:</th>
			          <td width="160px">
			             	<input type="text" id="startDate" name="startDate" value="${command.startDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <th width="75px">结束日期:</th>
			          <td>
			             	<input type="text" id="endDate" name="endDate" value="${command.endDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
		         </tr> 
		         <tr>
			          <th width="65px">IMSI:</th>
			          <td width="8px">
			             	<input type="text" id="imsi" name="imsi" value="${command.imsi}" class="easyui-validatebox" maxlength="20"/>
			          </td>
			          <th width="50px">
			                                  手机号:
			          </th>
			          <td width="8px">
			          	    <input type="text" id="mobile" name="mobile" value="${command.mobile}" class="easyui-validatebox" data-options="validType:['number']" maxlength="20"/>
			          </td>
			          <th width="65px">运营商:</th>
			          <td width="8px">
			           		<form:select path="serverType" id="serverType" cssClass="easyui-validatebox" style="width:152px;height:26px;">
			           		   <form:option value="-1">=全部=</form:option>
			           		   <form:option value="1">移动</form:option>
			           		   <form:option value="2">联通</form:option>
			           		   <form:option value="3">电信</form:option>
			           		</form:select>
			          </td>
			          <th width="65px">省份:</th>
			          <td>
			           		<form:select path="provinceId" id="provinceId" cssClass="easyui-validatebox" style="width:152px;height:26px;">
			           		   <form:option value="-1">=全部=</form:option>
			           		   <form:options items="${proList}" itemLabel="provinceName" itemValue="id"/>
			           		</form:select>
			              <input type="button" id="findBtn" style="margin-left:32px;" class="findBtn" value="查询"/>
			          </td>
		         </tr> 
		          <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			      <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		       </table>
		       
		        <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			    <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>  
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'启动时间',align:'center'">启动时间</th>
			    <th data-options="field:'手机号',align:'center'">手机号</th>
			    <th data-options="field:'运营商',align:'center'">运营商</th>
			    <th data-options="field:'省份',align:'center'">省份</th>
			    <th data-options="field:'渠道包',align:'center'">渠道包</th>
			    <th data-options="field:'IMSI',align:'center'">IMSI</th>
			    <th data-options="field:'ICCID',align:'center'">ICCID</th>
			    <th data-options="field:'IP',align:'center'">IP</th>
			    <th data-options="field:'UA',align:'center'">UA</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td><fmt:formatDate value="${item.createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			           <td>${item.mobile}</td>
			           <td>
                          <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					      </c:choose>
                       </td>
			           <td>${item.provinceName}</td>
			           <td>${item.cnName}</td>
			           <td>${item.imsi}</td>
			           <td>${item.iccid}</td>
			           <td>${item.ip}</td>
			           <td>${item.ua}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<%@include file="../../common/pageEasyui.jsp" %>
		<script type="text/javascript">
		$(document).ready(function(){
		  var options={
				    remoteSort:false,
					title:'SDK启动日志列表<span style="margin-left:50px;color:#ff0000;">选择日期后才能查询数据</span>',
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
		});
		 $("#findBtn").click(function(){
			 var endDate=$('#endDate').datebox('getValue');
			 var startDate=$('#startDate').datebox('getValue');
			 if(endDate < startDate){
				 alert('开始日期必须小于结束日期');
				 return false;
		      }
    		  document.forms['findForm'].submit();
		 });
		$("#channelId").change(function(){
			var channelId=$("#channelId").val();
			reloadApp(null,channelId);
		});
		
		function reloadApp(cpId,channelId){
			 $.ajax({
				 url:'${basePath}/baseConf/app/selectApp.action',
				 type:'get',
				 dataType:'json',
				 data:{"channelId":channelId},
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