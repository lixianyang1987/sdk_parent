<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>指令列表</title> 
    <form:form action="toPayPointOperateAdd" method="post" id="findForm">
           <input type="hidden" name="id" value="${findOperate.id}"/>
           <input type="hidden" name="opType" value="${findOperate.opType}"/>
           <input type="hidden" name="appId" value="${findOperate.appId}"/>
           <input type="hidden" name="serverType" value="${findOperate.serverType}"/>
	       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
		   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form:form>     
	<table id="dg2" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:40">ID</th>
			    <th data-options="field:'a',width:60">运营商</th>
				<th data-options="field:'b'">指令名称</th>
				<th data-options="field:'c',width:80">上行通道</th>
				<th data-options="field:'d',width:60">指令内容</th>
				<th data-options="field:'e',width:80">金额<font color="red">(分)</font></th>
				<th data-options="field:'l'">二次确认内容</th>
				<th data-options="field:'f',width:60">操作</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.id}</td>
				<td>
				    <c:choose>
				       <c:when test="${item.serverType==1}">移动</c:when>
				       <c:when test="${item.serverType==2}">联通</c:when>
				       <c:when test="${item.serverType==3}">电信</c:when>
				    </c:choose>
				</td>
				<td>${item.opName}</td>
				<td>
	                ${item.feeCode }
				</td>
				<td>${item.opCode}</td>
				<td>${item.price}</td>
				<td>${item.ensureContent}</td>
				<td><a id="selectBtn" href="javascript:addOperate(${item.id});" class="selectBtn" style="width:50px;">添加</a></td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	       var options={
	    		   remoteSort:false,
	    		   singleSelect:true,
	    		   fitColumns:true,
	    		   noheader:true,
	    		   idField:'id'
	       }
	       filterAuth(options);    
           $('#dg2').datagrid(options);   
           
          function addOperate(id){
        	   $.ajax({
        		   url:'addPayPointOperate',
        		   data:{'operateId':id,'paypointId':'${param.id}'},
        		   type:'post',
        		   dataType:'json',
        		   success:function(data){
        			   if(data.success){
        				   $("#dg2").datagrid("selectRecord",id);
        	        	   var row=$("#dg2").datagrid("getSelected");
        	        	   window.parent.addRow(row);
        				   commonObj.showOpTip('添加成功',function(){},300,1000);
        			   }else{
        				   commonObj.showOpTip('添加失败');
        			   }
        		   } 
        	   }); 
          }         
	</script>
<%@include file="../../common/pageEasyui.jsp" %>
</body>
</html>