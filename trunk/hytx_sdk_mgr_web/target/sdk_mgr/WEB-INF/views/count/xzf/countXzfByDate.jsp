<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>信支付订单统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countXzfByDate" method="post" id="findForm">
		       <table id="findTable">
		         <tr>
			          <th width="65px">开始日期:</th>
			          <td width="80px">
			             	<input type="text" id="startDate" name="startDate" value="${findDto.startDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <th width="65px">结束日期:</th>
			          <td>
			             <input type="text" id="endDate" name="endDate" value="${findDto.endDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
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
			    <th data-options="field:'支付类型',sortable:true,align:'center'">支付类型</th> 
			    <th data-options="field:'资费',sortable:true,align:'center'">资费</th> 
			    <th data-options="field:'操作',sortable:true,align:'center'">操作</th> 
			    <th data-options="field:'订单数',sortable:true,align:'center'">订单数</th> 
			    <th data-options="field:'订单成功数',sortable:true,align:'center'">订单成功数</th> 
			    <th data-options="field:'订购用户数',sortable:true,align:'center'">订购用户数</th> 
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.dataType==1?'信支付':item.dataType==2?'银联支付':item.dataType==3?'话费支付':item.dataType==4?'易接支付':'其它'}</td>
			           <td> 
			               <c:if test="${item.feeValue > 0}">
				           		${item.feeValue/100}元
				           </c:if>
				       </td>
			           <td>${item.opType==1?'购买':'还款'}</td>
			           <td>${item.total}</td>
			           <td>${item.totalSuc}</td>
			           <td>${item.totalUsers}</td>
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
		</script>
</body>
</html>