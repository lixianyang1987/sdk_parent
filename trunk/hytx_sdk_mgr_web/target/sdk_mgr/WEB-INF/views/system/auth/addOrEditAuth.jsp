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
		<form:form id="addOrEditAuthForm" action="addOrEditAuth"  method="post" commandName="auth" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${auth.id}"/>
			<table>  
			   <tr>	
			   		<th>权限名：</th>
			   		<td><input type="text" id="authName" name="authName" value="${auth.authName}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入权限名'"  maxlength="50"/></td>
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
		    	if($("#addOrEditAuthForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditAuthForm'].submit();
		    	}
		    }
	</script>
</body>
</html>