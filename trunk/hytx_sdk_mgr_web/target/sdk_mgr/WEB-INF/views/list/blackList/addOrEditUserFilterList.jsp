<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@include file="../../common/top.jsp" %>
    <style type="text/css">
		   .errorBox{
		        color: #ff0000;
		        font-weight: bold;
		        text-align: center;
		   }
		   th{
		     width:30%;
		   }
	</style>
    <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form:form id="addOrEditUserFilterListForm" action="addOrEditUserFilterList"  method="post" commandName="userFilterList" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${userFilterList.id}"/>
			<table>  
			   <tr>	
			   		<th>黑名单IMSI：</th>
			   		<td><input type="text" id="imsi" name="imsi" value="${userFilterList.imsi}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入黑名单IMSI'" size="22" maxlength="50"/></td>
			   </tr>
			    <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="5" cols="20">${userFilterList.memo}</textarea>
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
		    function validSub(){
		    	if($("#addOrEditUserFilterListForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditUserFilterListForm'].submit();
		    	}
		    }
	</script>
</body>
</html>