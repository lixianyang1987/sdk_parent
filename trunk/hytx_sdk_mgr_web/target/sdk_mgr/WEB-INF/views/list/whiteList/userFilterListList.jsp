<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>白名单管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form action="userFilterListList" method="post" id="findForm">
		       <label>IMSI:</label> <input type="text" name="imsi" class="easyui-validatebox" value="${userFilterList.imsi}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>       
     </div>
   </fieldset>	
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'b',width:100">IMSI</th>
				<th data-options="field:'d',width:150">备注</th>
				<th data-options="field:'e',width:150">创建人</th>
				<th data-options="field:'f',width:150">创建时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.imsi }</td>
					<td>${ item.memo}</td>
					<td>${item.createBy}</td>
					<td>
						<fmt:formatDate value="${item.createDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	 <%@include file="../../common/pageEasyui.jsp" %>
	 <script type="text/javascript">
	  var options={
			singleSelect:false,
			remoteSort:false,
			title:'白名单列表',
			toolbar: [{
						id: 'btnAdd',
						text: '添加',
						iconCls: 'icon-add',
						handler: function () {
							commonObj.toAdd('添加白名单','toUserFilterListInfo',400,350);
						}
					}, '-', {
						id: 'btnEdit',
						text: '编辑',
						iconCls: 'icon-edit',
						handler: function () {
							commonObj.toEdit('toUserFilterListInfo',400,350,'编辑白名单');
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
		     		              url:'delUserFilterList',
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