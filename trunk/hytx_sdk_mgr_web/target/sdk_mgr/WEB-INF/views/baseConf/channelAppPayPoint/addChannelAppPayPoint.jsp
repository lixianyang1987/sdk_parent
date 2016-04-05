<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>渠道包计费点列表</title> 
    <form:form action="toChannelAppPayPointAdd" method="post" id="findForm">
           <input type="hidden" name="channelId" value="${param.channelId}"/>
           <input type="hidden" name="appId" value="${param.appId}"/>
           <input type="hidden" name="id" value="${param.id}"/>
           <input type="hidden" name="channelAppId" value="${param.id}"/>
	       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
		   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form:form>     
	<table id="dg" class="easyui-datagrid" style="width:auto;height:auto;"
		data-options="remoteSort:false,fitColumns:true,noheader:true">
		<thead>
			<tr>			    
				<th data-options="field:'运营商',width:60,sortable:true">运营商</th>
				<th data-options="field:'计费点名称',sortable:true">计费点名称</th>
				<th data-options="field:'计费金额',width:60,sortable:true">计费金额</th>
				<th data-options="field:'计费代码',width:100">计费代码</th>
				<th data-options="field:'计费状态',width:60,sortable:true">计费状态</th>
				<th data-options="field:'指令类型',width:60,sortable:true">指令类型</th>
				<th data-options="field:'h',width:80">操作</th>
			</tr>
		</thead>
		<tbody>  
		   <c:forEach items="${page.resultList}" var="item">
				<tr>
				  
				    <td>
					    <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					    </c:choose>
					</td>
				    <td>${item.name}</td>
				    <td>${(item.feeValue+0.0)/100}元</td>
				    <td>${item.payCode}</td>
				    <td>${item.status == 1?"生效":"未生效"}</td>
				    <td>${item.opType == 1?"静态指令":"动态指令"}</td>					
				<td><a id="selectBtn" href="javascript:addPayPoint(${item.id},${channelAppPayPoint.channelId});" class="selectBtn" style="width:50px;">添加</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
          function addPayPoint(id,channelId){
        	   $.ajax({
        		   url:'addChannelAppPayPoint',
        		   data:{'channelId':channelId,'payPointId':id,'channelAppId':'${param.id}'},
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