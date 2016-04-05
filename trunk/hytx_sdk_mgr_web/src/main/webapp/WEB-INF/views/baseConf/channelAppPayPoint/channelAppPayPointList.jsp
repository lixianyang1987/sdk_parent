<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>渠道包计费点列表</title> 
    <div style="padding:10px;">
       <h2>渠道名称:<font color="red">${dto.channelName}</font> &nbsp;&nbsp;应用名称：<font color="red">${dto.appName}</font></h2>
    </div>
    <form:form action="channelAppPayPointList" method="post" id="findForm">
		       <input type="hidden" name="id" value="${param.id}"/>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form:form>     
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'所属应用',sortable:true">所属应用</th>
				<th data-options="field:'运营商',width:60,sortable:true">运营商</th>
				<th data-options="field:'计费点名称',sortable:true">计费点名称</th>
				<th data-options="field:'计费金额',width:60,sortable:true">计费金额</th>
				<th data-options="field:'计费代码',width:100">计费代码</th>
				<th data-options="field:'计费状态',width:60,sortable:true">计费状态</th>
				<th data-options="field:'指令类型',width:60,sortable:true">指令类型</th>
				<th data-options="field:'创建人',width:150">创建人</th>
				<th data-options="field:'创建时间',width:150">创建时间</th>
			</tr>
		</thead>
		<tbody>  
		   <c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${appMap.get(item.appId)}</td>
				    <td>
					    <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					    </c:choose>
					</td>
				    <td><a href="javascript:toTabLink('计费点管理','${basePath}/baseConf/payPoint/payPointList.action?name=${item.name}');" class="link_a">${item.name}</a></td>
				    
				    <td>${(item.feeValue+0.0)/100}元</td>
				    <td>${item.payCode}</td>
				    <td>${item.status == 1?"生效":"未生效"}</td>
				    <td>${item.opType == 1?"静态指令":"动态指令"}</td>				
					<td>${item.createBy}</td>
					<td>
						<fmt:formatDate value="${item.createDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				
				</tr>
				</c:forEach>
			</tbody>	
	</table>
	<script type="text/javascript">
	        var options={
	                singleSelect:false,
	                remoteSort:false,
	                fitColumns:true,
	                title:'渠道包计费点列表', 
					toolbar: [{
	                   id: 'btnAdd',
	                   text: '添加计费点',
	                   iconCls: 'icon-add',
	                   handler: function () {
	                      commonObj.openSelectWindow({
	                    	  
								href:'toChannelAppPayPointAdd?channelId=${dto.channelId}&appId=${dto.appId}&id=${param.id}&channelAppId=${param.id}',
								title:'添加渠道包计费点 <label style="color:#ff0000;margin-left:178px;">以下为未被此渠道包添加过的计费点列表</label>',
								modal: true,
								width:800,
					            height:400,
					            onClose:function(){
					            	$("#findForm").submit();
					            }
							});
	                   }
	               },'-', {
		                id: 'btnDelete',
		                text: '移除计费点',
		                iconCls: 'icon-remove',
		                handler: function () {
		                	commonObj.toDel(function(r,ids){
		     	               if(r){
			     		          $.ajax({
			     		              type:'get',
			     		              data:{"ids":ids.join(","),"channelAppId":'${param.id}'},
			     		              url:'delChannelAppPayPoint',
			     		              dataType:'json',
			     		              success:function(data){
			     		              	  if(data.success==false){
			     		                     alert("删除失败，请稍后再试");
			     		                     return;
			     		              	  }
			     		              	  $("#findForm").submit();
			     		                }
			     		           });   
		     	               }
		     	             });
		                }
		            }]
				};
            filterAuth(options);    
            $('#dg').datagrid(options);   
	</script>
<%@include file="../../common/pageEasyui.jsp" %>
</body>
</html>