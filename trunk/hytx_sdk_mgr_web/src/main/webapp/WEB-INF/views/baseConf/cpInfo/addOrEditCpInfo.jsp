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
		<form:form id="addOrEditCpInfoForm" action="addOrEditCpInfo"  method="post" commandName="cpInfo" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${cpInfo.id}"/>
			<table>  
				<c:if test="${cpInfo.id!=null}"><tr>	
				   		<th>CPID：</th>
				   		<td>${cpInfo.id}</td>
				   </tr></c:if>
			   <tr>	
			   		<th>SP名称：</th>
			   		<td><input type="text" id="cpName" name="cpName" value="${cpInfo.cpName}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入SP名称'"  maxlength="50"/></td>
			   </tr>
			    <tr>
			      	<th>联系人：</th>
			   		<td><input type="text" id="linkMan" name="linkMan" value="${cpInfo.linkMan}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			   <tr>
			      	<th>联系号码：</th>
			   		<td><input type="text" id="linkMobile" name="linkMobile" value="${cpInfo.linkMobile}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			   <tr>
			      	<th>联系QQ：</th>
			   		<td><input type="text" id="linkQq" name="linkQq" value="${cpInfo.linkQq}" class="easyui-validatebox" data-options="validType:['length[0,15]']"  maxlength="15"/></td>
			   </tr>
			   <tr>
			      	<th>联系邮箱：</th>
			   		<td><input type="text" id="linkEmail" name="linkEmail" value="${cpInfo.linkEmail}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			    <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="5" cols="20">${cpInfo.memo}</textarea>
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
		    	if($("#addOrEditCpInfoForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditCpInfoForm'].submit();
		    	}
		    }
	</script>
</body>
</html>