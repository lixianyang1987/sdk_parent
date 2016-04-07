<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <style type="text/css">
   .errorBox{
        color: #ff0000;
        font-weight: bold;
        text-align: center;
   }
   th{
     width:36%;
   }
</style>	
<title>添加或编辑渠道包</title>
 <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form:form  action="${basePath}/baseConf/channelApp/addOrEditChannelApp" method="post" commandName="channelApp" name="addOrEditChannelApp" id="addOrEditChannelApp"  data-options="ajax:false">
		        <input type="hidden" name="id" value="${channelApp.id}"/>
		        <input type="hidden" name="testStatus" value="0"/>
				<table>
				   <tr>
				   		<th>渠道包名：</th>
				   		<td>
				   		    <input type="text" id="name" name="name" value="${channelApp.name}" maxlength="50"   class="easyui-validatebox"/>
				   		</td>
				   </tr>
				   <tr>
				   		<th>渠道：</th>
				   		<td>
				   		    <form:select path="channelId" items="${channelList}" itemLabel="channelName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>
				   		</td>
				   </tr>
				   <tr>
				   		<th>应用：</th>
				   		<td>
				   		    <form:select path="appId" items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>
				   		</td>
				   </tr>   
				   <tr>
				   		<th>渠道包路径：</th>
				   		<td>
				   		      <input type="text" id="packageName" name="packageName" value="${channelApp.packageName}" data-options="required:true" maxlength="50" class="easyui-validatebox"/>
				   		</td>
				   </tr> 
				   <tr>
				<th>结算方式：</th>
				<td><form:select path="smId" items="${smList}"
						itemLabel="smName" itemValue="smId" cssClass="easyui-validatebox"
						style="width:150px;height:26px;"></form:select></td>
				</tr>
				   <tr>
				   		<th>计费状态：</th>
				   		<td>
				                                   计费<input type="radio" name="feeStatus" value="1" checked="checked">&nbsp;&nbsp;不计费<input type="radio" name="feeStatus" value="0"/>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>扣量百分数：</th>
				   		<td>
				   		    <select id="reducePercent" name="reducePercent" class="validate-box" style="width:150px;height:22px;">
				   		    </select>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>同步状态：</th>
				   		 <td>
				                           同步<input type="radio" name="syncStatus" value="1" checked="checked">&nbsp;&nbsp;不同步<input type="radio" name="syncStatus" value="0"/>
				        </td>
				   </tr>    
				   <tr>
				   		<th>同步url：</th>
				   		<td>
				   		      <input type="text" id="syncUrl" name="syncUrl" value="${channelApp.syncUrl}" data-options="required:true,validType:['url']" size="40" maxlength="500" class="easyui-validatebox"/>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>用户日限额：</th>
				   		<td>
				   		   <input type="text" id="dayLimit" name="dayLimit" value="${channelApp.dayLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>用户月限额：</th>
				   		<td>
				   		   <input type="text" id="monthLimit" name="monthLimit" value="${channelApp.monthLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>结算率：</th>
				   		<td>
				   		    <select id="feePercent" name="feePercent" class="validate-box" style="width:150px;height:22px;">
				   		    </select>
				   		</td>
				   </tr> 
				    <tr>
				   		<th>CPA金额：</th>
				   		<td>
				   		   <input type="text" id="cpaPrice" name="cpaPrice" value="${channelApp.cpaPrice}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>备注：</th>
				   		<td>
				   		     <textarea rows="2" cols="37" name="memo" value="${channelApp.memo}"  class="easyui-validatebox" maxlength="255">${channelApp.memo}</textarea>
				   		</td>
				   </tr> 
				   <tr>
				        <th></th>
				   		<td>
				   		     <input type="button" value="确定" id="subBtn"/>
				   		</td>
				   </tr>
				</table>
		  </form:form>
		</div>
	<script type="text/javascript">
	      $("#addOrEditChannelApp").find("input[name='syncStatus'][value='${channelApp.syncStatus}']").attr({"checked":"checked"});
	      $("#addOrEditChannelApp").find("input[name='feeStatus'][value='${channelApp.feeStatus}']").attr({"checked":"checked"});
		  
	      $("#subBtn").click(function(){ 
			  if($("#addOrEditChannelApp").form("validate")){
		    		$.messager.progress();
		    		document.forms['addOrEditChannelApp'].submit();
		    	} 
		   }); 
	      $(document).ready(function(){
	    	  for(var i=0;i<=100;i=i+5){
	    		  $("#reducePercent").append("<option value='"+i+"'>"+i+"%</option>");
	    	  }
	    	  $("#reducePercent").find("option[value='${channelApp.reducePercent}']").attr({"selected":"selected"});
	    	  for(var i=0;i<=100;i=i+1){
	    		  $("#feePercent").append("<option value='"+i+"'>"+i+"%</option>");
	    	  }
	    	  $("#feePercent").find("option[value='${channelApp.feePercent}']").attr({"selected":"selected"});
	      }); 
	</script>
</body>
</html>