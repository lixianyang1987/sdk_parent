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
		<form:form id="addOrEditProvinceForm" action="addOrEditProvince"  method="post" commandName="province">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${province.id}"/>
			<table>  
			   <tr>	
			   		<th>省份名称：</th>
			   		<td><input type="text" id="provinceName" name="provinceName" value="${province.provinceName}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入省份名'"  maxlength="30"/></td>
			   </tr>
			    <tr>
			      	<th>省份编码：</th>
			   		<td><input type="text" id="provinceCode" name="provinceCode" value="${province.provinceCode}" class="easyui-validatebox" data-options="validType:['length[0,20]']"  maxlength="20"/></td>
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
		    	if($("#addOrEditProvinceForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditProvinceForm'].submit();
		    	}
		    }
	</script>
</body>
</html>