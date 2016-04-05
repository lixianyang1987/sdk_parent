<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/top.jsp"%>
<style type="text/css">
.errorBox {
	color: #ff0000;
	font-weight: bold;
	text-align: center;
}

th {
	width: 36%;
}
</style>
<title>添加或编辑应用</title>
<div id="p" class="easyui-panel"
	data-options="fit:true,border:false,bodyCls:'add_outer_div'">
	<form:form action="addOrEditApp" name="addOrEditApp" method="post"
		commandName="app" id="addOrEditApp" data-options="ajax:false">
		<input type="hidden" name="id" value="${app.id}" />
		<table>
			<!--  <tr>
				   		<th>运营商：</th>
				   		<td>
				   		    <select id="serverType" name="serverType" class="easyui-validatebox" style="width:100px;">
				   		         <option value="1">移动</option>
				   		         <option value="2">联通</option>
				   		         <option value="3">电信</option>
				   		    </select>
				   		</td>
				   </tr> -->
			<tr>
				<th>应用名称：</th>
				<td><input type="text" name="appName" value="${app.appName}"
					class="easyui-validatebox" data-options="required:true"
					maxlength="50" /></td>
			</tr>
			<tr>
				<th>所属SP：</th>
				<td><form:select path="cpId" items="${cpList}"
						itemLabel="cpName" itemValue="id" cssClass="easyui-validatebox"
						style="width:150px;height:26px;"></form:select></td>
			</tr>
			<tr>
				<th>结算方式：</th>
				<td><form:select path="smId" items="${smList}"
						itemLabel="smName" itemValue="smId" cssClass="easyui-validatebox"
						style="width:150px;height:26px;"></form:select></td>
			</tr>

			
			<tr>
				<th>结算率：</th>
				<td><select id="feePercent" name="feePercent"
					class="validate-box" style="width: 150px; height: 22px;">
				</select></td>
			</tr>
			<%--  
			<tr>
				<th>应用KEY：</th>
				<td><input type="text" name="appKey" value="${app.appKey}"
					class="easyui-validatebox" data-options="required:true"
					maxlength="50" /></td>
			</tr>
			<tr>
				<th>计费APPID：</th>
				<td><input type="text" id="appSn" name="appSn"
					value="${app.appSn}" class="easyui-validatebox"
					data-options="required:true" maxlength="30" /></td>
			</tr>
			<tr>
				<th>上游渠道ID：</th>
				<td><input type="text" id="channelSn" name="channelSn"
					value="${app.channelSn}" data-options="required:true"
					maxlength="30" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				   		<th>用户日限额：</th>
				   		<td>
				   		   <input type="text" id="dayLimit" name="dayLimit" value="${app.dayLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示无不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>用户月限额：</th>
				   		<td>
				   		   <input type="text" id="monthLimit" name="monthLimit" value="${app.monthLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示无不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>提示开关：</th>
				   		 <td>
				                           开启<input type="radio" name="controlFlag" value="1" checked="checked">&nbsp;&nbsp;关闭<input type="radio" name="controlFlag" value="0"/>
				        </td>
				   </tr> 
				   <tr>
				   		<th>指令发送间隔秒数：</th>
				   		<td>
				   		   <input type="text" id="waitSeconds" name="waitSeconds" value="${app.waitSeconds}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">秒</font>
				   		</td>
				   </tr>     --%>
			<tr>
				<th>应用描述：</th>
				<td><textarea rows="3" cols="25" name="appDescribe"
						value="${app.appDescribe}" class="easyui-validatebox"
						maxlength="255">${app.appDescribe}</textarea></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="button" value="确定" id="subBtn" /></td>
			</tr>
		</table>
	</form:form>
</div>
<script type="text/javascript">
	$("#subBtn").click(function() {
		if ($("#addOrEditApp").form("validate")) {
			$.messager.progress();
			document.forms['addOrEditApp'].submit();
		}
	});

	if ('${app.id}' != '') {
		$("#appSn").attr("disabled", "disabled");
		$("#channelSn").attr("disabled", "disabled");
	}
	$("#cpName").click(
			function() {
				commonObj.addSecondWin('选择CP',
						"${basePath}/system/cp/selectUserList", 800, 400);
			});
	$(document).ready(
			function() {
				for (var i = 0; i <= 100; i = i + 1) {
					$("#feePercent").append(
							"<option value='"+i+"'>" + i + "%</option>");
				}
				$("#feePercent").find("option[value='${app.feePercent}']")
						.attr({
							"selected" : "selected"
						});
			});
</script>
</body>
</html>