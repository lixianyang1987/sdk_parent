<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/top.jsp" %>	
<title>添加或编辑角色</title>
 <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form:form action="addOrEditRole" method="post" commandName="role"  id="addOrEditRole"  data-options="ajax:false">
		        <input type="hidden" name="id" value="${role.id}"/>
				<table>
				   <tr>
				   		<th>角色名称：</th>
				   		<td><input type="text" name="name" value="${role.name}"  class="easyui-validatebox" data-options="required:true" maxlength="24"/></td>
				   </tr>
				    <tr>
				   		<th>角色状态：</th>
				   		<td>
				   		    <select name="status" value="${role.status}" class="easyui-combobox" disabled="disabled" >
				   		        <c:choose>
				   		           <c:when test="${role.status==1}">
					   		           <option value="-1" >失效</option>
					   		           <option value="1" selected="selected">生效</option>
				   		           </c:when>
				   		           <c:otherwise>
				   		               <option value="-1" selected="selected">失效</option>
					   		           <option value="1">生效</option>
				   		           </c:otherwise>
				   		        </c:choose>   
				   		    </select>
				   		</td>
				   </tr> 
				   <tr>
				        <th></th>
				   		<td>
				   		     <input type="submit" value="确定" id="submit"/>
				   		</td>
				   </tr>
				</table>
		  </form:form>
		</div>
		<script type="text/javascript">
		   /*  $("#submit").click(function(){
			   if($("#addOrEditRole").form("validate")){
		    		$.messager.progress();
		    		$("#addOrEditRole").submit();
		    	}
		   });   */
	</script>
</body>
</html>