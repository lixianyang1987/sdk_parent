<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>扎西嘉淼包月留存统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countSyncRetainedByDate" method="post" id="findForm">
		       <table id="findTable">
		          <tr>
			          <th width="65px">渠道包:</th>
			          <td width="8px">
				         <form:select path="channelAppId" id="channelAppId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;">
	                          <form:option value="-1">=全部=</form:option>
	                          <form:options items="${channelappList}"  itemLabel="name"  itemValue="id"/>
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
			          <th width="80px">
			                                  应用:
			          </th>
			          <td width="8px">
			              <form:select path="appId" id="appId"  cssClass="easyui-validatebox" style="width:152px;height:26px;">
			                   <form:option value="-1">=全部=</form:option>
	                          <form:options items="${appList}"  itemLabel="appName"  itemValue="id"/>
			              </form:select>
			          </td>
			           <td>
			             <input type="button" id="findBtn" style="margin-left:15px;" class="findBtn" value="查询"/>
			          </td>
			          <th width="80px"></th>
			          <td></td>
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
			    <th data-options="field:'订单号',sortable:true,align:'center'">订单号</th>
			    <th data-options="field:'手机号',sortable:true,align:'center'">手机号</th>
			    <th data-options="field:'上行号码',sortable:true,align:'center'">上行号码</th> 
			    <th data-options="field:'上行指令',sortable:true,align:'center'">上行指令</th> 
			    <th data-options="field:'上行时间',sortable:true,align:'center'">上行时间</th> 
			    <th data-options="field:'资费',sortable:true,align:'center'">资费</th> 			    
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.linkid}</td>
			           <td>${item.mobile}</td>
			            <td>${item.port}</td>
			            <td>${item.msg}</td>
			           <td>${item.orderTime} </td>
			           <td> ${item.payFee/100}元   </td>
			          
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<%@include file="../../common/pageEasyui.jsp" %>
		<script type="text/javascript">
		$(document).ready(function(){
		  var options={
				    remoteSort:false,
					title:'订单详情列表<span style="margin-left:50px;color:#ff0000;">选择日期后才能查询数据</span>',
					toolbar:[
					         {
				                id: 'btnAdd',
				                text: '导出xls',
				                iconCls: 'icon-remove',
				                handler: function () {
				                	 var data=$('#dg').datagrid("getData");
				                	 var fields=$("#dg").datagrid("getColumnFields",false);
				                	 exportXls(data,fields);
				                }
			                 }, '-', {
					                id: 'btnEdit',
					                text: '导入xls',
					                iconCls: 'icon-add',
					                handler: function () {
					                	commonObj.toAdd('导入xls','toAddXls',500,450);
					                }}
					    ]
		  };
		  filterAuth(options);
		  $('#dg').datagrid(options);
		});
		
		 $("#findBtn").click(function(){			
    		  document.forms['findForm'].submit();
		 });
		 
		</script>
</body>
</html>