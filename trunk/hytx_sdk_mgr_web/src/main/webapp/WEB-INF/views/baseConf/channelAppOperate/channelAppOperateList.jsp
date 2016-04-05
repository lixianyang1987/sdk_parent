<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>渠道包指令列表</title> 
    <div style="padding:10px;">
       <h2>渠道名称:<font color="red">${dto.channelName}</font> &nbsp;&nbsp;应用名称：<font color="red">${dto.appName}</font></h2>
    </div>
    <form:form action="channelAppOperateList" method="post" id="findForm">
		       <input type="hidden" name="id" value="${param.id}"/>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form:form>     
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
			    
			    <th data-options="field:'a'">运营商</th>
				<th data-options="field:'b'">指令名称</th>
				<th data-options="field:'c'">上行通道</th>
				<th data-options="field:'d',editor:'text'">指令内容</th>
				<th data-options="field:'k',formatter:function(value,row,index){value=value.replace('{0}','${dto.key}');value=value.replace('{1}','{0}');  return value;},editor:{type:'text'}">下游指令</th>
				<th data-options="field:'e'">计费金额<font color="red">(分)</font></th>
				<th data-options="field:'f'">模糊位数</th>
				<th data-options="field:'g',width:60">状态</th>
				<th data-options="field:'h',width:60">权重</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>				
			    <td>${item.id }</td>
				<td>
				    <c:choose>
				       <c:when test="${item.serverType==1}">移动</c:when>
				       <c:when test="${item.serverType==2}">联通</c:when>
				       <c:when test="${item.serverType==3}">电信</c:when>
				    </c:choose>
				</td>
				<td>
				
					<c:choose>
						<c:when test="${item.opType==1}"><a href="javascript:toTabLink('静态指令编辑','${basePath}/baseConf/operate/toOperateInfo.action?id=${item.id }');" class="link_a">${item.opName}</a></c:when>
						<c:when test="${item.opType==2}"><a href="javascript:toTabLink('动态指令编辑','${basePath}/baseConf/dynaOperate/toOperateInfo.action?id=${item.id }');" class="link_a">${item.opName}</a></c:when>
					</c:choose>
				</td>
				<td>
	                ${item.feeCode }
				</td>
				<td>${item.opCode}</td>
				<td>${item.opCode}</td>
				<td>${item.price}</td>
				<td>${item.suffixNum}</td>
				<td>
				    <c:choose>
				       <c:when test="${item.status==1}">启用</c:when>
				       <c:otherwise>未启用</c:otherwise>
				    </c:choose>
				</td>
				<td>${item.weight}</td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	        var options={
	                singleSelect:false,
	                remoteSort:false,
	                fitColumns:true,
	                title:'渠道包指令列表', 
					toolbar: [{
	                   id: 'btnAdd',
	                   text: '添加指令',
	                   iconCls: 'icon-add',
	                   handler: function () {
	                      commonObj.openSelectWindow({
								href:'toChannelAppOperateAdd?channelId=${dto.channelId}&appId=${dto.appId}&id=${param.id}&channelAppId=${param.id}',
								title:'添加渠道包指令 <label style="color:#ff0000;margin-left:178px;">以下为未被此渠道包添加过的指令列表</label>',
								modal: true,
								minimizable:true,
								maximizable:true,
								width:800,
					            height:600,
					            onClose:function(){
					            	$("#findForm").submit();
					            }
							});
	                   }
	               },'-', {
		                id: 'btnDelete',
		                text: '移除指令',
		                iconCls: 'icon-remove',
		                handler: function () {
		                	commonObj.toDel(function(r,ids){
		     	               if(r){
			     		          $.ajax({
			     		              type:'get',
			     		              data:{"ids":ids.join(","),"channelAppId":'${param.id}'},
			     		              url:'delChannelAppOperate',
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