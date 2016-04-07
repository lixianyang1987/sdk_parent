<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>权限名管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form action="authList" method="post" id="findForm">
		       <label>权限名名称:</label> <input type="text" name="authName" class="easyui-validatebox" value="${auth.authName}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>       
     </div>
   </fieldset>	
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'a',width:100">权限名</th>
				<th data-options="field:'f',width:150">创建时间</th>
				<th data-options="field:'e',width:150">创建人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.authName }</td>
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
	    			title:'权限名列表',
	    			toolbar: [{
	    		                id: 'btnAdd',
	    		                text: '添加',
	    		                iconCls: 'icon-add',
	    		                handler: function () {
	    		                    commonObj.toAdd('添加权限名','toAuthInfo',550,400);
	    		                }
	    		            }, '-', {
	    		                id: 'btnEdit',
	    		                text: '编辑',
	    		                iconCls: 'icon-edit',
	    		                handler: function () {
	    		                	commonObj.toEdit('toAuthInfo',550,450,'编辑权限名');
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
	    			     		              url:'delAuth',
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