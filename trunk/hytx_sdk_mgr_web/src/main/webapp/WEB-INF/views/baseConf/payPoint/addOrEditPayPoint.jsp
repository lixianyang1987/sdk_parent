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
		<form:form id="addOrEditPayPointForm" action="addOrEditPayPoint"  method="post" commandName="payPoint" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${payPoint.id}"/>
		    <input type="hidden" name="opRange" value="${payPoint.opRange}"/>
		    <input type="hidden" name="status" value="${payPoint.status}"/>
			<table>  
			   <tr>	
			   		<th>计费点名称：</th>
			   		<td><input type="text" id="name" name="name" value="${payPoint.name}"
			   		 class="easyui-validatebox" data-options="required:true,missingMessage:'请输入计费点名'"  maxlength="50"/></td>
			   </tr>
			    <tr>
			   		<th>运营商：</th>
			   		<td>
			   		    <select id="serverType" name="serverType" class="easyui-validatebox" style="width:152px;height:22px;">
			   		         <option value="1">移动</option>
			   		         <option value="2">联通</option>
			   		         <option value="3">电信</option>
			   		    </select>
			   		</td>
				</tr>
			    <tr>
			   		<th>所属应用：</th>
			   		<td>
                         <form:select id="selAppId" path="appId" items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;" ></form:select>
                   </td>
			    </tr>  
			    <tr>
			   		<th>计费代码：</th>
			   		<td>
			   		   <input type="text" id="payCode" name="payCode" value="${payPoint.payCode}"  class="easyui-validatebox" data-options="required:true"/>
			   		</td>
			    </tr> 
			    <tr>
			   		<th>道具资费：</th>
			   		<td>
			   		   <input type="text" id="feeValue" name="feeValue" value="${payPoint.feeValue}"  class="easyui-validatebox" data-options="required:true,validType:['number']">分
			   		</td>
			    </tr> 
			    <tr>
			   		<th>指令类型：</th>
			   		<td>
			   		    <select id="opType" name="opType" class="easyui-validatebox" style="width:152px;height:22px;">
			   		         <option value="1">静态指令</option>
			   		         <option value="2">动态指令</option>
			   		    </select>
			   		</td>
				</tr>
			    <!-- <tr>	
			   		<th>是否启用：</th>
			   		<td>
			   		    <select id="status" name="status" class="easyui-validatebox" style="width:100px;">
			   		         <option value="-1">禁用</option>
			   		         <option value="1">启用</option>
			   		    </select>
			   		</td>
			   </tr>   -->
			   <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="3" cols="20">${payPoint.memo}</textarea>
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
	  $("#addOrEditPayPointForm").find("#serverType").find("option[value='${payPoint.serverType}']").attr({"selected":"selected"});
      $("#addOrEditPayPointForm").find("#status").find("option[value='${payPoint.status}']").attr({"selected":"selected"});
      $("#addOrEditPayPointForm").find("#opType").find("option[value='${payPoint.opType}']").attr({"selected":"selected"});
	  
      if('${payPoint.id}'!=''){
    	  $("#serverType").attr("disabled","disabled");
    	  $("#selAppId").attr("disabled","disabled");
    	  $("#opType").attr("disabled","disabled");
      }
      
      function validSub(){
	    	if($("#addOrEditPayPointForm").form("validate")){
	    		$.messager.progress();
	    		document.forms['addOrEditPayPointForm'].submit();
	    	}
	    }
	</script>
</body>
</html>