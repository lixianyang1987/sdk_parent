<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp"%>
 <c:if test='${pmenu!=null}'>
   <title>编辑菜单</title>
 </c:if>
 <c:if test='${pmenu==null}'>
    <title>添加菜单</title>
 </c:if>
      <c:if test="${menu.id != null }">
         <div style="color:red;width: 200px;margin: 0 auto;padding-top:10px;">编辑菜单时不能编辑菜单类型</div>
      </c:if>
     <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form id="addOrEditMenu" action="addOrEditMenu" method="post">
		        <input type="hidden" name="id" value="${menu.id}"/>
		        <input type="hidden" name="pid" value="${pid}"/>
		        <input type="hidden" name="tier" value="${menu.tier}"/>
				<table>
				   <c:if test='${pmenu!=null}'>
				      <tr>
				  		<th>父菜单名：</th>
				   		<td>${pmenu.name}</td>
				  	  </tr>
				   </c:if>
				   <tr>
				   		<th>菜单名称：</th>
				   		<td><input id="menuName" type="text" name="name" value="${menu.name}" class="easyui-validatebox" data-options="required:true"  maxlength="30"/></td>
				   </tr>
				   <c:if test="${menu.id != null }">
				      <input type="hidden" name="menuType" value="${menu.menuType}"/>
				   </c:if>
				   <c:if test="${menu.id == null }">
				      <tr>
				   		<th>菜单类型：</th>
				   		<td>
				   		    <select id="menuType" name="menuType" value="${menu.menuType}">
				   		         <option value="2">功能菜单</option>
				   		         <option value="1">非功能菜单</option>
				   		    </select>
				   		</td>
				   </tr>
				   </c:if>
				   <tr id="url_row" >
				   		<th>菜单url：</th>
				   		<td><input id="url" type="text" name="url" value="${menu.url}" class="easyui-validatebox" data-options="required:true" maxlength="50"/></td>
				   </tr>
				   <tr>
				   		<th>菜单排序：</th>
				   		<td><input id="orderNum" type="text" name="ordernum" value="${menu.ordernum}" class="easyui-validatebox" data-options="required:true,validType:'number'" maxlength="50"/></td>
				   </tr>
				   <tr>
				        <th></th>
				   		<td>
				   			<a id="submit" href="javascript:void(0)" class="easyui-linkbutton" style="width:50px">确定</a>
				   		</td>
				   </tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
	    $(document).ready(function(){
	    	var menuType='${menu.menuType}';
		    if(menuType && menuType == '1'){
		    	$("#url_row").hide();
		    }else{
		    	menuType='2';
		    }
		    $("#menuType").combobox({
		    	width:155,
		    	editable:false,
		    	value:menuType,
		    	onChange:changeType
		    });
		    var id='${menu.id}';
		    if(id != ''){
		    	$("#menuType").combobox('readonly',true);
		    }
	    });
	    function changeType(newValue,oldValue){
	    	if(newValue==1){
	    		$("#url").val("");
	    		$("#url_row").hide();
	    		$("#url").validatebox("disableValidation");
	    	}else{
	    		$("#url_row").show();
	    		$("#url").validatebox("enableValidation");
	    	}
	    };
		$("#submit").click(function() { 
			 var ty=$("input[name='menuType']:first").val();
			 if(ty == 1){
				 $("#url").validatebox("disableValidation");
			 }
			 if ($("#addOrEditMenu").form("validate")) {
				$.messager.progress();
				//异步提交表单
				$('#addOrEditMenu').form('submit',{
					url:'addOrEditMenu.action',
					success : function(data) {
						 $.messager.progress('close');
					     data=eval('('+data+')');
						 if(data.success){
							 $("#mydialog").panel('close');
							 var selNode=$('#menuTree').tree('getSelected');
							 var ty=$("input[name='menuType']:first").val();
							 var n={id:data.id,text:$("#menuName").val(),state:'closed',iconCls:'tree-folder-open',attributes:{menuType:ty}};
							 if(ty==2){
								 n.iconCls='tree_node_icon_none';
								 n.state='open';
							 }
							 var mid='${menu.id}';
							 if(mid != ''){
								 n.target=selNode.target;
								 $('#menuTree').tree('update',n);
							 }else{
								 $('#menuTree').tree("append",{
									 parent:selNode.target,
									 data:[n]
								 });
							 }	
						 }else{
							 commonObj.showAlert('添加菜单失败');
						 }
					}
				});
			}  
		});
	</script>
</body>
</html>