<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <style type="text/css">
   .errorBox{
        color: #ff0000;
        font-weight: bold;
        text-align: center;
   }
</style>	
 <div  id="p" class="add_outer_div">
        <div style="margin-left:20%;text-align:left;">
		    <h2>${operate.id==null?'添加':'编辑'}动态指令</h2>
		 </div>
		<form:form  action="addOrEditOperate" method="post" commandName="operate" name="addOrEditOperate" id="addOrEditOperate"  data-options="ajax:false">
		        <input type="hidden" name="id" value="${operate.id}"/>
		        <input type="hidden" name="opType" value="2"/>
				<table>
				    <tr>		
				   		<th><label>指令名称：</label></th>
				   		<td><input type="text" name="opName" value="${operate.opName}"  class="easyui-validatebox" data-options="required:true" maxlength="50"/></td>
				   </tr>
				    <tr>		
				   		<th><label>指令资费：</label></th>
				        <td>
				   		   <input type="text" id="price" name="price" value="${operate.price+0}" data-options="required:true,validType:['number']" maxlength="6" class="easyui-validatebox"/><font color="red">(分)</font>
				   	    </td>
				   </tr>
				   
				   <tr>
				      <th></th>
				      <td ><div class="form_tip2">指令标题，例：移动_切红包_动态指令</div></td>
				   </tr>
				   <tr>
				  	    <th width="20%">所属应用：</th>
				   		<td>
				   		   <form:select id="selAppId" path="appId"  items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>
				   		</td>
				   </tr>
				   <tr>
				   		<th width="20%"><label>运营商：</label></th>
				   		<td>
				   		    <form:select id="serverType" path="serverType" cssClass="easyui-validatebox" cssStyle="width:152px;height:22px;">
				   		         <form:option value="1">移动</form:option>
				   		         <form:option value="2">联通</form:option>
				   		         <form:option value="3">电信</form:option>
				   		    </form:select>
				   		</td>
				   </tr>
				   <tr>
				   		<th><label>指令接口：</label></th>
				   		<td>
				   			<form:select path="opCode"  cssClass="easyui-validatebox" style="width:152px;height:22px;">
				   			     <form:options items="${interfaceMap}"/>
				   			</form:select>
				   		</td>
				   </tr> 
				    <tr>
				   		<th><label>上行通道：</label></th>
				   		<td>
				   		   <input type="text" id="feeCode" name="feeCode" value="${operate.feeCode}"  maxlength="30" class="easyui-validatebox"/>
				   		</td>
				   	</tr>
				   <tr>
				      <th></th>
				      <td><div class="form_tip2">上行通道号码，例：1065880088,不填则根据接口返回值里的通道。</div></td> 
				   </tr>
				   <tr>		
				   		<th><label>模糊位数：</label></th>
				   		<td>
				   		   <input type="text" id="suffixNum" name="suffixNum" value="${operate.suffixNum+0}"  maxlength="6" data-options="required:true,validType:['number']" class="easyui-validatebox"/>
				   		</td>
				   </tr>   
				   <tr>
				      <th></th>
				      <td ><div class="form_tip2">取值范围是0-20，由系统自动在指令后加上随机代码，用于账单与短信记录数据关联，默认0为固定指令，可根据上游通道模糊规则设置，建议位数不低于10位</div></td>
				    </tr>
				   <tr>
				   		<th><label>权重：</label></th>
				   		<td>
				   		   <input type="text" id="weight" name="weight" data-options="required:true,validType:['number']" value="${operate.weight+0}" maxlength="6" class="easyui-validatebox"/>
				   		</td>
				   </tr>
				   <tr>
				      <th></th>
				      <td><div class="form_tip2">取值范围0-9999，相同条件下系统自动投放权重高的指令，相同权重值则随机</div></td>
				   </tr>
				   <tr>	
				   		<th><label>是否启用：</label></th>
				   		<td>
				   		    <form:select id="status" path="status" cssClass="easyui-validatebox" cssStyle="width:100px;">
				   		         <form:option value="-1">不启用</form:option>
				   		         <form:option value="1">启用</form:option>
				   		    </form:select>
				   		</td>
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
				   </tr> 
				   <tr>		
				   		<th>二次确认内容：</th>
				   		<td>
				   		   <input type="text" id="ensureContent" name="ensureContent"  value="${operate.ensureContent}" maxlength="100" class="easyui-validatebox"/>
				   		</td>
				   </tr>
				   <tr> 
				   		<th>二次确认默认号码：</th>
				   		<td>
				   		     <input type="text" id="ensureNum" name="ensureNum"  value="${operate.ensureNum}" maxlength="20" class="easyui-validatebox"/>
				   		</td>
				   	</tr>	
				</table> 
		  </form:form>
		  <div style="margin-left:20%;margin-top:20px;text-align:left;"><input type="button" value="返回" id="backBtn"/><input type="button" value="提交" id="subBtn"/></div>
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
			  //history.go(-1);
			  window.location.href='${basePath}/baseConf/dynaOperate/operateList.action';
		   });  
		  
	</script>
</body>
</html>