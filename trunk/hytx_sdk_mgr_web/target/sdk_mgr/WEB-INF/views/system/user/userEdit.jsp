<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="../../common/top.jsp" %>
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
    <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form:form id="addOrEditUserForm" action="addOrEditUser"  method="post" commandName="user" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${user.id}"/>
			<table>  
			   <tr>	
			   		<th>用户名：</th>
			   		<td><input type="text" id="userName" name="userName" value="${user.userName}" class="easyui-validatebox" data-options="required:true,delay:1000,missingMessage:'请输入用户名',validType:['exists','length[2,30]']"  maxlength="30"/></td>
			   </tr>
			   <tr>
			      	<th>登录名：</th>
			   		<td><input type="text" id="loginName" name="loginName" value="${user.loginName}" class="easyui-validatebox" data-options="required:true,delay:1000,validType:['length[2,30]','existsLoginName']"  maxlength="30"/></td>
			   </tr>
			    <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="5" cols="20">${user.memo}</textarea>
			   		</td>
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
	        //自定义检查用户存在的验证
	        $.extend($.fn.validatebox.defaults.rules, {
		        exists: {
			        validator: function(value){
		        	if(value != '' && value == '${user.userName}'){
			        	return true;
			        }
			        var mark=true;
			        $.ajax({
		    			url:'checkExistsUserName.action',
		    			data:{userName:value},
		    			type:'get',
		    			async:false,
		    			success:function(data){
		    				if(data.exists){
		    					mark= false;
		    				}
		    			}
		    		});
			        return mark;
		        },
		          message: '用户名已存在，请选择其它用户名'
		        } ,
		        existsLoginName: {
			        validator: function(value){
		        	if(value != '' && value == '${user.loginName}'){
			        	return true;
			        }
			        var mark=true;
			        $.ajax({
		    			url:'${basePath}/system/user/checkExistsLoginName.action',
		    			data:{loginName:value},
		    			type:'get',
		    			async:false,
		    			success:function(data){
		    				if(data.exists){
		    					mark= false;
		    				}
		    			}
		    		});
			        return mark;
		        },
		          message: '登录名已存在，请选择其它登录名'
		        }
	        });
		    function validSub(){
		    	if($("#addOrEditUserForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditUserForm'].submit();
		    	}
		    }
	</script>
</body>
</html>