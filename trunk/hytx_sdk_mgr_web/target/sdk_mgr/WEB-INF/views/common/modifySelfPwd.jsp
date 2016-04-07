<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="../common/top.jsp" %>
    <style type="text/css">
		   .errorBox{
		        color: #ff0000;
		        font-weight: bold;
		        text-align: center;
		   }
		   th{
		     width:42%;
		   }
	</style>
    <div  id="p" class="easyui-panel" data-options="fit:true,border:false" bodyCls="add_outer_div">
		<form:form id="modifyPwdForm" action="modifySelfPwd"  method="post" commandName="user">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${user.id}"/>
			<table>  
			   <tr>	
			   		<th>用户名：</th>
			   		<td><input type="text" id="userName" name="userName" value="${user.userName}" class="easyui-validatebox" readonly="readonly" disabled="disabled" data-options="required:true,missingMessage:'请输入用户名',validType:['length[3,30]']"  maxlength="30"/></td>
			   </tr>
			   <tr>
			      	<th>登录名：</th>
			   		<td><input type="text" id="loginName" name="loginName" value="${user.loginName}" class="easyui-validatebox" readonly="readonly" disabled="disabled" data-options="required:true,validType:['length[3,30]']"  maxlength="30"/></td>
			   </tr>
			   <tr>
			      	<th>新密码：</th>
			   		<td><input type="password" id="loginPwd" name="loginPwd"  class="easyui-validatebox" data-options="required:true,validType:['length[3,30]']"  maxlength="30"/></td>
			   </tr>
			   <tr>
			      	<th>确认新密码：</th>
			   		<td><input type="password" id="ensurePwd"  value="" class="easyui-validatebox" data-options="required:true,validType:['length[3,30]']"  maxlength="30"/></td>
			   </tr>
			   <tr>
			   		<th colspan="2">
			   			<div style="text-align:center;margin-top:8px;"><input type="button" value="确定" onclick="validSub();"/></div>	
			   		</th>
			   </tr>
			</table>
		</form:form>
	</div>
	<script type="text/javascript">   
		    function validSub(){
		    	if ($("#modifyPwdForm").form("validate")) {
		    		if($("#loginPwd").val() != $("#ensurePwd").val()){
		    			alert("新密码与确认新密码不一致");
		    			return;
		    		}
					$.messager.progress();
					//异步提交表单
					$('#modifyPwdForm').form('submit',{
						url:'${basePath}/common/modifySelfPwd.action',
						success : function(data) {
							 $.messager.progress('close');
						     data=eval('('+data+')');
							 if(data.status){
								 $("#mydialog").panel('close');	
								 $.messager.show({msg:'修改密码成功',showType:'fade',timeOut:50,showSpeed:200});
							 }else{
								 commonObj.showAlert('修改密码失败');
							 }
						}
					});
				} 
		    	
		    }    
	</script>
</body>
</html>