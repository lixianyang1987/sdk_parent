<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>渠道管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form action="channelList" method="post" id="findForm">
		        渠道名称: <input type="text" name="channelName" class="easyui-validatebox" value="${channel.channelName}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form>       
     </div>
   </fieldset>	
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'a',width:100">渠道id</th>
				<th data-options="field:'b',width:100">渠道名称</th>
				<th data-options="field:'g',width:100">联系人</th>
				<th data-options="field:'i',width:100">联系电话</th>
				<th data-options="field:'k',width:100">联系QQ</th>
				<th data-options="field:'h',width:100">联系email</th>
				<th data-options="field:'d',width:150">备注</th>
				<th data-options="field:'f',width:150">创建时间</th>
				<th data-options="field:'e',width:150">创建人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.id}</td>
				    <td>${item.channelName }</td>
			        <td>${item.linkMan }</td>
			        <td>${item.linkMobile }</td>
			        <td>${item.linkQq}</td>
			        <td>${item.linkEmail }</td>
					<td>${ item.memo}</td>
					<td>
						<fmt:formatDate value="${item.createDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${item.createBy}</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	 <%@include file="../../common/pageEasyui.jsp" %>
	 <script type="text/javascript">
	   var options={
				singleSelect:false,
				remoteSort:false,
				title:'渠道列表',
				toolbar: [{
			                id: 'btnAdd',
			                text: '添加',
			                iconCls: 'icon-add',
			                handler: function () {
			                    commonObj.toAdd('添加渠道','toChannelInfo',550,400);
			                }
			            }, '-', {
			                id: 'btnEdit',
			                text: '编辑',
			                iconCls: 'icon-edit',
			                handler: function () {
			                	commonObj.toEdit('toChannelInfo',550,450,'编辑渠道');
			                }
			            }, '-', {
			                id: 'btnDelete',
			                text: '删除',
			                iconCls: 'icon-remove',
			                handler: function () {
			                	commonObj.toDel(function(r,ids){
			     	               if(r){
				     		           $.ajax({
				     		              type:'get',
				     		              data:{"ids":ids.join(",")},
				     		              url:'delChannel',
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
			     	             },'删除渠道将会删除渠道关联的渠道包及渠道包关联的省份及指令等，你确定要删除吗？');
			                }
			            }]
			   };
	   filterAuth(options);
	   $('#dg').datagrid(options);
	</script>
</body>
</html>