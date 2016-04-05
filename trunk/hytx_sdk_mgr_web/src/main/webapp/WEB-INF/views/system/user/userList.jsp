<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>用户管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form action="userList" method="post" id="findForm">
		                  用户名称: <input type="text" name="userName" class="easyui-validatebox" value="${findUser.userName}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form>       
     </div>
   </fieldset>	
	<table id="dg"   style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'c',width:150">用户名</th>
				<th data-options="field:'b',width:150">登录名</th>
				<th data-options="field:'d',width:150">备注</th>
				<th data-options="field:'f',width:150">创建时间</th>
				<th data-options="field:'e',width:150">创建人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.userName }</td>
					<td>${item.loginName }</td>				
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
	    			title:'用户列表',
	    			toolbar: [{
	    		                id: 'btnAdd',
	    		                text: '添加',
	    		                iconCls: 'icon-add',
	    		                handler: function () {
	    		                    commonObj.toAdd('添加用户','toUserInfo',550,400);
	    		                }
	    		            }, '-', {
	    		                id: 'btnEdit',
	    		                text: '编辑',
	    		                iconCls: 'icon-edit',
	    		                handler: function () {
	    		                	commonObj.toEdit('toUserInfo',550,400);
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
	    			     		              url:'delUser',
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
	    		            }, '-', {
	    		                id: 'btnEditPwd',
	    		                text: '修改密码',
	    		                iconCls: 'icon-edit',
	    		                handler: function () {
	    		                	commonObj.toEdit('toModifyPwd',500,300,'修改密码');
	    		                }
	    		            }, '-', {
	    		                id: 'btnEditRole',
	    		                text: '设置用户角色',
	    		                iconCls: 'icon-edit',
	    		                handler: function () {
	    		                	commonObj.toEdit('toModifyUserRoles',500,400,'设置用户角色');
	    		                }
	    		            }]
	    		   };
	             filterAuth(options);
	             $('#dg').datagrid(options);
	</script>
</body>
</html>