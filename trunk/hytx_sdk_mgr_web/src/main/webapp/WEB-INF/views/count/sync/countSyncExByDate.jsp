<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>放代码订单统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countSyncExByDate" method="post" id="findForm">
		       <table id="findTable">
		          <tr>
		           <th width="65px">SP:</th>
			          <td width="8px">
				         <form:select path="spId" id="spId"  name="spId" cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${cpInfoList}"  itemLabel="cpName"  itemValue="id"/>
	                     </form:select>
			          </td>
			          <th width="65px">SP结算:</th>
			          <td width="8px">
				         <form:select path="dsjs" id="dsjs"  name="dsjs" cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${smList}"  itemLabel="smName"  itemValue="smId"/>
	                     </form:select>
			          </td>
			          <th width="65px">渠道:</th>
			          <td width="8px">
				         <form:select path="channelId" id="channelId" name="channelId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${channelList}"  itemLabel="channelName"  itemValue="id"/>
	                     </form:select>
			          </td>
			          <th width="65px">渠道结算:</th>
			          <td width="8px">
				         <form:select path="dxjs" id="dxjs"  name="dxjs" cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${smList}"  itemLabel="smName"  itemValue="smId"/>
	                     </form:select>
			          </td>
			          <th width="65px">渠道包:</th>
			          <td width="8px">
				         <form:select path="channelAppId" id="channelAppId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${channelAppList}"  itemLabel="name"  itemValue="id"/>
	                     </form:select>
			          </td>			         
		         </tr> 
		         <tr>
		          <th width="65px">业务:</th>
			          <td width="8px">
				         <form:select path="appId" id="AppId" name="appId" cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${appList}"  itemLabel="appName"  itemValue="id"/>
	                     </form:select>
			          </td>
			           <th width="80px">
			                                  扣量:
			          </th>
			          <td width="8px">
			              <form:select path="reduceStatus" id="reduceStatus"  cssClass="easyui-validatebox" style="width:152px;height:26px;">
			                  <form:option value="0">扣量前</form:option>
			                  <form:option value="1">扣量后</form:option>
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
			
			    <th data-options="field:'SP名称',sortable:true,align:'center'">SP名称</th>
			    <th data-options="field:'SP结算',sortable:true,align:'center'">SP结算</th> 
			    <th data-options="field:'业务名称',sortable:true,align:'center'">业务名称</th> 
			    <th data-options="field:'渠道名称',sortable:true,align:'center'">渠道名称</th> 
			    <th data-options="field:'渠道结算',sortable:true,align:'center'">渠道结算</th> 
			    <th data-options="field:'渠道包名称',sortable:true,align:'center'">渠道包名称</th>
			    <th data-options="field:'用户数',sortable:true,align:'center'">用户数</th> 
			    <th data-options="field:'资费',sortable:true,align:'center'">资费</th> 
			    <th data-options="field:'上行数',sortable:true,align:'center'">上行数</th> 
			    <th data-options="field:'下行数',sortable:true,align:'center'">下行数</th> 
			    <th data-options="field:'成功数',sortable:true,align:'center'">成功数</th> 
			    <th data-options="field:'扣量比',sortable:true,align:'center'">扣量比</th> 
			    <th data-options="field:'扣量数',sortable:true,align:'center'">扣量数</th> 
			    <th data-options="field:'同步数',sortable:true,align:'center'">同步数</th> 
			    <th data-options="field:'计费金额',sortable:true,align:'center'">计费金额</th>  
			    <th data-options="field:'操作',align:'center'">操作</th>  
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
					<td>${item.spName}</td>
					<td>${item.dsjsName}</td>
					<td>${item.appName}</td>
					<td>${item.channelName}</td>
					<td>${item.dxjsName}</td>
			           <td>
			             <c:choose>
			                <c:when test="${item.channelAppId!=null}">
			                	<a href="javascript:toTabLink('渠道包管理','${basePath}/baseConf/channelApp/channelAppList?name=${item.channelAppName}');" class="link_a">${item.channelAppName}</a>
			                </c:when>
			                <c:otherwise>
			                    ${item.channelAppName}
			                </c:otherwise>
			             </c:choose>
			           </td>
			           <td>${item.totalUsers}</td>
			           <td> 
			               <c:if test="${item.feeValue > 0}">
				           		${item.feeValue/100}元
				           </c:if>
				       </td>
			           <td>${item.upCount}</td>
			           <td>${item.downCount}</td>
			           <td>${item.sucCount}</td>
			           <td>
				           <c:if test="${item.reducePercent > 0}">
				           		${item.reducePercent}%
				           </c:if>
			           </td>
			           <td>${item.reduceCount}</td>
			           <td>${item.syncedCount}</td>
			           <td>${item.totalFeeValue}元</td>
			           <td>
				           <c:if test="${item.channelAppId!=null}">
				          	 <a href="javascript:toDetail('${basePath}/count/sync/countSyncExDetailByDate?channelAppId=${item.channelAppId}&reduceStatus=${findDto.reduceStatus}&startDate=${findDto.startDate}&endDate=${findDto.endDate}');" class="link_a">查看详情</a>
				           </c:if>
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
			 
			 
			 function toDetail(url){
				// url=encodeURI(url);
				 toTabLink('放代码订单详情统计',url);
			 }
			 $("#spId").change(function(){
				
					var spId=$("#spId").val();
					var channelId=$("#channelId").val();
					reloadApp(spId,channelId);
				});
			
			 $("#AppId").change(function(){
				
					var appId=$("#AppId").val();
					
					reloadChannel(appId);
				});
			 
			 function reloadApp(spId,channelId){				
				$.ajax({
					 url:'${basePath}/baseConf/app/selectAppBySp.action',  
					 type:'get',
					 dataType:'json',
					 data:{"spId":spId,"channelId":channelId},
					 success:function(data){
						 $("#AppId").empty();
						 $("#AppId").append('<option value="-1" selected="selected">=全部=</option>');
						 for(var i=0;i<data.length;i++){
							 $("#AppId").append('<option value="'+data[i].id+'">'+data[i].appName+'</option>');
						 }
					 }
				 });
			 }
			 function reloadChannel(appId){				
				$.ajax({
					 url:'${basePath}/baseConf/channel/selectChannelsByApp.action',  
					 type:'get',
					 dataType:'json',
					 data:{"appId":appId},
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