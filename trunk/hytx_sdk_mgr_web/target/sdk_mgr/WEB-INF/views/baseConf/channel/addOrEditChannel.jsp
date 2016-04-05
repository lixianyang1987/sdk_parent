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
		<form:form id="addOrEditChannelForm" action="addOrEditChannel"  method="post" commandName="channel" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${channel.id}"/>
			<table>  
				<c:if test="${channel.id!=null}"><tr>	
				   		<th>渠道ID：</th>
				   		<td>${channel.id}</td>
				   </tr></c:if>
			   <tr>	
			   		<th>渠道名称：</th>
			   		<td><input type="text" id="channelName" name="channelName" value="${channel.channelName}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入渠道名'"  maxlength="50"/></td>
			   </tr>
			    <tr>
			      	<th>联系人：</th>
			   		<td><input type="text" id="linkMan" name="linkMan" value="${channel.linkMan}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			   <tr>
			      	<th>联系号码：</th>
			   		<td><input type="text" id="linkMobile" name="linkMobile" value="${channel.linkMobile}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			   <tr>
			      	<th>联系QQ：</th>
			   		<td><input type="text" id="linkQq" name="linkQq" value="${channel.linkQq}" class="easyui-validatebox" data-options="validType:['length[0,15]']"  maxlength="15"/></td>
			   </tr>
			   <tr>
			      	<th>联系邮箱：</th>
			   		<td><input type="text" id="linkEmail" name="linkEmail" value="${channel.linkEmail}" class="easyui-validatebox" data-options="validType:['length[0,50]']"  maxlength="50"/></td>
			   </tr>
			    <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="5" cols="20">${channel.memo}</textarea>
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
		    	if($("#addOrEditChannelForm").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditChannelForm'].submit();
		    	}
		    }
	</script>
</body>
</html>