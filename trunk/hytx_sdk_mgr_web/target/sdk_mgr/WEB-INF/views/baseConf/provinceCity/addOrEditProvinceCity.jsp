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
		<form:form id="addOrEditProvinceCityForm" action="addOrEditProvinceCity"  method="post" commandName="provinceCity" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${provinceCity.id}"/>
			<table>  
			   <tr>
			      	<th>所属省份：</th>
			   		<td>
			   		   <form:select path="provinceId" items="${proList}" itemLabel="provinceName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>         
			   		</td>
			   </tr>
			   <tr>	
			   		<th>城市名称：</th>
			   		<td><input type="text" id="cityName" name="provinceCityName" value="${provinceCity.cityName}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入城市名'"  maxlength="50"/></td>
			   </tr>
			    <tr>
			      	<th>城市编码：</th>
			   		<td><input type="text" id="cityCode" name="cityCode" value="${provinceCity.cityCode}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
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
		    	if($("#addOrEditProvinceCityForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditProvinceCityForm'].submit();
		    	}
		    }
	</script>
</body>
</html>