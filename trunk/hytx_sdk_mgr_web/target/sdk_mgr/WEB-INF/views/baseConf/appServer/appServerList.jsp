<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>应用运营商配置管理</title>
    <div style="padding:10px;">
       <h2>应用名称: <font color="red">${app.appName}</font></h2>
    </div>
    <form action="appServerList" method="post" id="findForm">
	       <input type="hidden" name="appId" value="${appServer.appId}"/>
	       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
		   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
	</form>     	
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'serverType'">运营商</th>
				<th data-options="field:'dayLimit'">用户日限</th>
				<th data-options="field:'monthLimit'">用户月限</th>
				<th data-options="field:'controlFlag'">提示开关</th>
				<th data-options="field:'waitSeconds'">指令间隔</th>
				<th data-options="field:'opRange'">指令使用范围</th>
				<th data-options="field:'createDt',width:150">创建时间</th>
				<th data-options="field:'createBy',width:100">创建人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				   	<td>
					    <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					    </c:choose>
	                </td>
					<td>${item.dayLimit>0?item.dayLimit:'不限'}<font color="red">（分）</font></td>
					<td>${item.monthLimit>0?item.monthLimit:'不限'}<font color="red">（分）</font></td>
		            <td>${item.controlFlag==1?'开启':'关闭'}</td>
					<td>
		                ${item.waitSeconds }<font color="red">（秒）</font>
					</td>
					<td>${item.opRange==1?'共享':'私有'}</td>
					<td><fmt:formatDate value="${item.createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
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
			title:'${app.appName}运营商配置列表',
			toolbar: [{
						id: 'btnAdd',
						text: '添加',
						iconCls: 'icon-add',
						handler: function () {
							commonObj.toAdd('添加${app.appName}运营商配置','toAppServerInfo?appId=${appServer.appId}',550,400);
						}
					}, '-', {
						id: 'btnEdit',
						text: '编辑',
						iconCls: 'icon-edit',
						handler: function () {
							commonObj.toEdit('toAppServerInfo',550,450,'编辑${app.appName}运营商配置');
						}
					},
				'-', {
	                id: 'btnDelete',
	                text: '删除',
	                iconCls: 'icon-remove',
	                handler: function () {
	                	commonObj.toDel(function(r,ids){
	     	               if(r){
		     		           $.ajax({
		     		              type:'get',
		     		              data:{"ids":ids.join(",")},
		     		              url:'delAppServer',
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
</body>
</html>