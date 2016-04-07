<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>字典管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form action="dictList" method="post" id="findForm">
		       <label>关键字名称:</label> <input type="text" name="key" class="easyui-validatebox" value="${dict.key}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>       
     </div>
   </fieldset>	
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'b'">关键字名称</th>
				<th data-options="field:'val'">关键字值</th>
				<th data-options="field:'status',width:100">状态</th>
				<th data-options="field:'d',width:500">备注</th>
				<th data-options="field:'f',width:150">更新时间</th>
				<th data-options="field:'e',width:150">修改人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.key}</td>
				    <td>${item.val}</td>
				    <td>${item.status==1?'启用':'禁用'}</td>
					<td>${item.memo}</td>
					<td>
						<fmt:formatDate value="${item.updateDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${item.updateBy}</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	 <%@include file="../../common/pageEasyui.jsp" %>
	 <script type="text/javascript">
	  var options={
			singleSelect:false,
			remoteSort:false,
			title:'字典列表',
			toolbar: [{
						id: 'btnAdd',
						text: '添加',
						iconCls: 'icon-add',
						handler: function () {
							commonObj.toAdd('添加字典','toDictInfo',550,400);
						}
					}, '-', {
						id: 'btnEdit',
						text: '编辑',
						iconCls: 'icon-edit',
						handler: function () {
							commonObj.toEdit('toDictInfo',550,450,'编辑字典');
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
		     		              url:'delDict',
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