<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>放代码订单详情统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="" method="post" id="findForm">
		       <table id="findTable">
		          <tr> 			          
			          <th width="60px">
			                                  手机号:
			          </th>
			          <td>
			              <input type="text" name="mobile"  value="${findDto.mobile}"/>
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
			             <input type="button" id="findBtn"  class="findBtn" value="查询"/>
			          </td>
			          
		         </tr> 
		     
		       </table>
		       <input type="hidden" name="channelId" value="${findDto.channelId }" id="channelId"/>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>  
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'渠道包名称',sortable:true,align:'center'">渠道包名称</th>
			    <th data-options="field:'省份',sortable:true,align:'center'">省份</th>
			    <th data-options="field:'上行时间',sortable:true,align:'center'">上行时间</th> 
			    <th data-options="field:'资费',sortable:true,align:'center'">资费</th> 
			    <th data-options="field:'上行号码',sortable:true,align:'center'">上行号码</th> 
			    <th data-options="field:'下行状态',sortable:true,align:'center'">下行状态</th> 
			    <th data-options="field:'计费状态',sortable:true,align:'center'">计费状态</th> 
			     
			    <th data-options="field:'同步状态',sortable:true,align:'center'">同步状态</th> 
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.channelAppName}</td>
			           <td>${item.province}</td>
			           <td>
			           		<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			           </td>
			           <td> 
				           ${item.feeValue/100}元
				       </td>
			           <td>${item.mobile}</td>
			           <td><img src="${basePath}/images/${item.downStatus==1?'ok':'no'}.png"/></td>
			           <td><img src="${basePath}/images/${item.feeStatus==1?'ok':'no'}.png"/></td>
			           <td>${item.reduceStatus==1?'':item.syncStatus==1?'成功':'失败'}</td>
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
		 
		</script>
</body>
</html>