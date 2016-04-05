<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>渠道包指令列表</title> 
    <form:form action="toChannelAppOperateAdd" method="post" id="findForm">
           <input type="hidden" name="channelId" value="${param.channelId}"/>
           <input type="hidden" name="appId" value="${param.appId}"/>
           <input type="hidden" name="id" value="${param.id}"/>
	       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
		   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form:form>     
	<table id="dg" class="easyui-datagrid" style="width:auto;height:auto;"
		data-options="remoteSort:false,fitColumns:true,noheader:true">
		<thead>
			<tr>
			    <th data-options="field:'a',width:60">运营商</th>
				<th data-options="field:'b',width:100">指令名称</th>
				<th data-options="field:'c',width:100">上行通道</th>
				<th data-options="field:'d',width:150">指令内容</th>
				<th data-options="field:'e',width:100">计费金额<font color="red">(分)</font></th>
				<th data-options="field:'h',width:80">操作</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
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
				
				<td><a id="selectBtn" href="javascript:addOperate(${item.id},${channelAppOperate.channelId},${channelAppOperate.appId});" class="selectBtn" style="width:50px;">添加</a></td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
          function addOperate(id,channelId,appId){
        	   $.ajax({
        		   url:'addChannelAppOperate',
        		   data:{'channelId':channelId,'appId':appId,'operateId':id,'channelAppId':'${param.id}'},
        		   type:'post',
        		   dataType:'json',
        		   success:function(data){
        			   if(data.success){
        				   commonObj.showOpTip('添加成功',function(){
        					  $("#findForm").submit();
        				   },300,1000);
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