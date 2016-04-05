<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>省份管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form action="provinceList" method="post" id="findForm">
		        省份名称: <input type="text" name="provinceName" class="easyui-validatebox" value="${province.provinceName}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form>       
     </div>
   </fieldset>	
	<table id="dg">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'a',width:100">省份id</th>
				<th data-options="field:'b',width:100">省份名称</th>
				<th data-options="field:'g',width:100">省份编码</th>
				<th data-options="field:'f',width:150">创建时间</th>
				<th data-options="field:'e',width:150">创建人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.id}</td>
				    <td>${item.provinceName }</td>
				     <td>${item.provinceCode }</td>
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
				title:'省份列表',
				toolbar: [{
			                id: 'btnAdd',
			                text: '添加',
			                iconCls: 'icon-add',
			                handler: function () {
			                   commonObj.toAdd('添加省份','toProvinceInfo',550,400);
			                }
			            }, '-', {
			                id: 'btnEdit',
			                text: '编辑',
			                iconCls: 'icon-edit',
			                handler: function () {
			                	commonObj.toEdit('toProvinceInfo',550,450,'编辑省份');
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
				     		              url:'delProvince',
				     		              dataType:'json',
				     		              success:function(data){
				     		            	 if(data.status==-1){
				     		                     alert("要删除的省份有关联的城市记录，请先将对应的城市删除后再删除省份");
				     		                     return;
				     		              	  }else  if(data.status==0){
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