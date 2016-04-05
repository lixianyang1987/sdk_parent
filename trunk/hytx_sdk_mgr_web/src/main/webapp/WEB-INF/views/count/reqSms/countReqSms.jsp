<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>短串请求查询</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countReqSms" method="post" id="findForm">
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
		 </form:form>       
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'日期',align:'center'">日期</th>
			    <th data-options="field:'手机号',align:'center'">手机号</th>
			    <th data-options="field:'省份',align:'center'">省份</th>
			    <th data-options="field:'运营商',align:'center'">运营商</th>
				<th data-options="field:'渠道包',align:'center'">渠道包</th>
				<!-- <th data-options="field:'道具代码',align:'center'">道具代码</th> -->
				<th data-options="field:'资费',align:'center',width:60">资费<font color="red">(分)</font></th>
				<th data-options="field:'IMSI',align:'center'">IMSI</th>
				<th data-options="field:'状态',align:'center',width:80">状态</th>
				<th data-options="field:'计费点',align:'center'">计费点</th>
				<th data-options="field:'ip',align:'center'">ip</th>
				<th data-options="field:'hasLayout',align:'center'">短信拦截</th>
				<th data-options="field:'extra_info',align:'center'">点击行为</th>
				<th data-options="field:'UA',align:'center'">UA</th>
				<th data-options="field:'操作',align:'center'">操作</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td><fmt:formatDate value="${item.updateDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			           <td>${item.mobile}</td>
			           <td>${item.provinceName}</td>
			           <td>
                          <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					      </c:choose>
                       </td>
			           <td>${item.cnName}</td>
			           <%-- <td>${item.payCode}</td> --%>
			           <td>${item.feeValue}</td>
			           <td>${item.imsi}</td>
			           <td>${item.status}</td>
			           <td>${item.payPointName}</td>
			           <td>${item.ip}</td>
			           <td>${item.hasLayout!=null&&item.hasLayout==1?'有拦截':''}</td>
			           <td>${item.extraInfo}</td>
			           <td>${item.ua}</td>
			           <td>
						   <a href="javascript:showCommands('${item.orderId}');"  class="selectBtn" style="width:100px;">查看短串详情</a>
					   </td>	
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<%@include file="../../common/pageEasyui.jsp" %>
		<script type="text/javascript">
		$(document).ready(function(){
		  var options={
				    remoteSort:false,
				    singleSelect:true,
					title:'短串请求日志查询',
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
		  $("#findBtn").click(function(){
				 if($("#endDate").val() < $("#startDate").val()){
					 alert('开始日期必须小于结束日期');
					 return false;
			      }
				  if($("#findForm").form("validate")){
					  document.forms['findForm'].submit();
				  }
			 });
		  
		   $("#channelId").change(function(){
				var channelId=$("#channelId").val();
				reloadApp(-1,channelId);
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
		});
		
		function showCommands(orderId){
			var url='${basePath}/count/reqSms/findReqSmsCommands.action?orderId='+orderId;
			commonObj.toAdd('短串详情',url,1000,300);
		}
	</script>
</body>
</html>