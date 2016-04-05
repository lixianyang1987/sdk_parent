<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <style type="text/css">
   .errorBox{
        color: #ff0000;
        font-weight: bold;
        text-align: center;
   }
</style>	
 <div style="margin-left:38%;">
    <h2>${operate.id==null?'添加':'编辑'}静态指令</h2>
 </div>
 <div  id="p" class="add_outer_div">
		<form:form  action="addOrEditOperate" method="post" commandName="operate" name="addOrEditOperate" id="addOrEditOperate"  data-options="ajax:false">
		        <input type="hidden" name="id" value="${operate.id}"/>
		        <input type="hidden" name="opType" value="1"/>
				<table>
				   <tr>
				  	    <th>所属应用：</th>
				   		<td width="20%">
				   		   <form:select id="selAppId" path="appId"  items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>
				   		</td>
				   		<th  width="20%">运营商：</th>
				   		<td>
				   		    <form:select id="serverType" path="serverType" cssClass="easyui-validatebox" cssStyle="width:152px;height:22px;">
				   		         <form:option value="1">移动</form:option>
				   		         <form:option value="2">联通</form:option>
				   		         <form:option value="3">电信</form:option>
				   		    </form:select>
				   		</td>
				   </tr>
				   <tr>
				   		<th>指令标题：</th>
				   		<td><input type="text" name="opName" value="${operate.opName}"  class="easyui-validatebox" data-options="required:true" maxlength="50"/></td>
				   		<th>指令内容：</th>
				   		<td>
				   		   <input type="text" id="opCode" name="opCode" value="${operate.opCode}" data-options="required:true" maxlength="200" class="easyui-validatebox"/>
				   		</td>
				   </tr> 
				     <tr>
				      <th></th>
				      <td><div class="form_tip">指令标题，例：移动指令001</div></td>
				      <th></th>
				      <td ></td>
				   </tr>
				   <tr>
				   		<th>上行通道：</th>
				   		<td>
				   		   <input type="text" id="feeCode" name="feeCode" value="${operate.feeCode}" data-options="required:true" maxlength="30" class="easyui-validatebox"/>
				   		</td>
				   		<th>模糊位数：</th>
				   		<td>
				   		   <input type="text" id="suffixNum" name="suffixNum" value="${operate.suffixNum+0}"  maxlength="6" data-options="required:true,validType:['number']" class="easyui-validatebox"/>
				   		</td>
				   </tr>   
				   <tr>
				      <th></th>
				      <td><div class="form_tip">上行通道号码，例：1065556131</div></td>
				      <th></th>
				      <td style="vertical-align:top;"><div class="form_tip">取值范围是0-20，建议位数不低于10位</div></td>
				   </tr>
				    <tr>
				   		<th>计费金额：</th>
				   		<td>
				   		   <input type="text" id="price" name="price" value="${operate.price+0}" data-options="required:true,validType:['number']" maxlength="6" class="easyui-validatebox"/><font color="red">(分)</font>
				   		</td>
				   		<th>权重：</th>
				   		<td>
				   		   <input type="text" id="weight" name="weight" data-options="required:true,validType:['number']" value="${operate.weight+0}" maxlength="6" class="easyui-validatebox"/>
				   		</td>
				   </tr> 
				   <tr>
				      <th></th>
				      <td ></td>
				      <th></th>
				      <td style="vertical-align:top;"><div class="form_tip">取值范围0-9999</div></td>
				    </tr> 
				    <tr>
				   		<th>二次确认类型：</th>
				   		<td>
				   		   <form:select path="ensureType" cssClass="easyui-validatebox" cssStyle="width:152px;height:22px;">
				   		         <form:option value="">无</form:option>
				   		         <form:option value="1">静态</form:option>
				   		         <form:option value="2">动态</form:option>
				   		   </form:select>
				   		</td>
				   		<th>状态：</th>
				   		<td>
				   		   <form:select path="status" cssClass="easyui-validatebox" cssStyle="width:152px;height:22px;">
				   		         <form:option value="-1">禁用</form:option>
				   		         <form:option value="1">启用</form:option>
				   		   </form:select>
				   		</td>
				   </tr> 
				    <tr>
				   		<th>二次确认内容：</th>
				   		<td>
				   		   <input type="text" id="ensureContent" name="ensureContent"  value="${operate.ensureContent}" maxlength="100" class="easyui-validatebox"/>
				   		</td>
				   		<th>
				   		  二次确认默认号码：
				   		</th>
				   		<td>
				   		     <input type="text" id="ensureNum" name="ensureNum"  value="${operate.ensureNum}" maxlength="20" class="easyui-validatebox"/>
				   		</td>
				   </tr> 
				</table>
		  </form:form>
		  <div style="text-align:left;margin-left:38%;margin-top:20px;"><input type="button" value="返回" id="backBtn"/><input type="button" value="提交" id="subBtn"/></div>
		</div>
	    <script type="text/javascript">
	      if('${operate.id}'!=''){
	    	  $("#serverType").attr("disabled","disabled");
	    	  $("#selAppId").attr("disabled","disabled");
	      }
	      $("#subBtn").click(function(){ 
			  if($("#addOrEditOperate").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditOperate'].submit();
		      } 
		   }); 
		  $("#backBtn").click(function(){ 
			  window.location.href='${basePath}/baseConf/operate/operateList.action';
			  // history.go(-1);
		   });   
	</script>
</body>
</html>