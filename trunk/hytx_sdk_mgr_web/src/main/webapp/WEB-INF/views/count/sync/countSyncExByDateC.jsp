<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>放代码订单统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="" method="post" id="findForm">
		       <table id="findTable">
		          <tr> 			         
			          <th width="65px">渠道包:</th>
			          <td width="8px">
				         <form:select path="channelAppId" id="channelAppId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${channelAppList}"  itemLabel="name"  itemValue="id"/>
	                     </form:select>
			          </td>			         
		         </tr> 
		         <tr> 	       
			           
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
			
			   
			    <th data-options="field:'业务名称',sortable:true,align:'center'">业务名称</th> 
			    <th data-options="field:'渠道名称',sortable:true,align:'center'">渠道名称</th> 
			    <th data-options="field:'渠道结算',sortable:true,align:'center'">渠道结算</th> 
			    <th data-options="field:'渠道包名称',sortable:true,align:'center'">渠道包名称</th>
			    <th data-options="field:'用户数',sortable:true,align:'center'">用户数</th> 
			    <th data-options="field:'资费',sortable:true,align:'center'">资费</th> 
			    <th data-options="field:'上行数',sortable:true,align:'center'">上行数</th> 
			    <th data-options="field:'下行数',sortable:true,align:'center'">下行数</th> 
			    <th data-options="field:'成功数',sortable:true,align:'center'">成功数</th> 
			   
			    <th data-options="field:'同步数',sortable:true,align:'center'">同步数</th> 
			    <th data-options="field:'计费金额',sortable:true,align:'center'">计费金额</th>  
			    <th data-options="field:'操作',align:'center'">操作</th>  
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
					
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
			      
			           <td>${item.syncedCount}</td>
			           <td>${item.totalFeeValue}元</td>
			           <td>
				           <c:if test="${item.channelAppId!=null}">
				          	 <a href="javascript:toDetail('${basePath}/count/sync/countSyncExDetailByDateC/${findDto.channelId}?channelAppId=${item.channelAppId}&reduceStatus=${findDto.reduceStatus}&startDate=${findDto.startDate}&endDate=${findDto.endDate}');" class="link_a">查看详情</a>
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
			 
		</script>
</body>
</html>