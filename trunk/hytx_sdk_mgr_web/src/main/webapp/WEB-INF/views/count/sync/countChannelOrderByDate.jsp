<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>激活量统计</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="${findDto.channelId}" method="post" id="findForm">
		       <table id="findTable">
			         <tr>
			          <th width="80px">
			                                  应用:
			          </th>
			          <td width="8px">
			              <form:select path="appId" id="appId"  cssClass="easyui-validatebox" style="width:152px;height:26px;">
			                  <form:option value="-1">=全部=</form:option>
	                          <form:options items="${appList}" itemLabel="appName" itemValue="id"/>
			              </form:select>
			          </td>
			          <th width="80px">开始日期:</th>
			          <td width="120px">
			             	<input type="text" id="startDate" name="startDate" value="${findDto.startDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <th width="80px">结束日期:</th>
			          <td width="120px">
			             <input type="text" id="endDate" name="endDate" value="${findDto.endDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <td>
			             <input type="button" id="findBtn" style="margin-left:15px;" class="findBtn" value="查询"/>
			          </td>
		         </tr> 
		       </table>
		 </form:form>  
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'日期',align:'center',width:100">日期</th>
			    <th data-options="field:'渠道名称',align:'center',width:150">渠道名称</th> 
			    <th data-options="field:'渠道包名称',align:'center',width:150">渠道包名称</th> 
			    <th data-options="field:'激活量',align:'center',width:100">激活量</th>  
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.date}</td>
			           <td>${item.channelName}</td>
			           <td>${item.cnName}</td>
			           <td>${item.activates}</td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<div id="totalDiv" style="text-align:left;margin-left:400px;margin-top:10px;font-weight:bold;display:none;">激活量汇总：<span id="total">0</span></div>
		<script type="text/javascript">
		$(document).ready(function(){
		  var options={
				    remoteSort:false,
					title:'激活量列表<span style="margin-left:50px;color:#ff0000;">选择日期后才能查询数据</span>',
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
		  var rows=$('#dg').datagrid('getRows');
		  var total=0;
		  if(rows&&rows.length>0){
			  for(var i=0;i<rows.length;i++){
			    total=total+parseInt(rows[i].激活量);
			  }
			  $("#total").html(parseInt(total));
		      $("#totalDiv").show();
		  }
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