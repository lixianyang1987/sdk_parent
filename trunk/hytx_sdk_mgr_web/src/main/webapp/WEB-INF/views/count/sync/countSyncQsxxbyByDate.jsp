<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>全盛包月订单统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="countSyncQsxxbyByDate" method="post" id="findForm">
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
			   <th data-options="field:'时间'">时间</th> 
			    <th data-options="field:'手机号'">手机号</th>
			    <th data-options="field:'操作',sortable:true">操作</th> 
			    <th data-options="field:'状态',sortable:true">状态</th> 
			    <th data-options="field:'生效时间'">生效时间</th> 
			    <th data-options="field:'失效时间'">失效时间</th> 
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.modatReceive}</td>
			           <td>${item.phone}</td>
			           <td>${item.operateType==2?'订购':'退订'}</td>
			           <td>${item.status}</td>
			           <td><fmt:formatDate value="${item.beginTime}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			           <td><fmt:formatDate value="${item.endTime}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
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