<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
   <div  id="p" class="easyui-panel" data-options="fit:true,border:false,bodyCls:'add_outer_div'">
		<form:form  action="addOperateKeyword" name="addOperateKeyword" method="post" commandName="operateKeyword"  id="addOperateKeyword"  data-options="ajax:false">
				<input type="hidden" name="operateId" value="${operateId}">
				<input type="hidden" name="id" value="${operateKeyword.id}">
				<table>
				   <tr>
				   		<th>屏蔽号码：</th>
				   		<td><input type="text" name="mtNum" value="${operateKeyword.mtNum}"  class="easyui-validatebox" data-options="required:true" size="28" maxlength="30"/></td>
				   </tr>
				   <tr>
				   		<th>屏蔽状态：</th>
				   		<td>
				   		   <form:select path="status" cssClass="easyui-validatebox" cssStyle="width:152px;height:22px;">
				   		         <form:option value="-1">禁用屏蔽</form:option>
				   		         <form:option value="1">仅主动计费屏蔽</form:option>
				   		         <form:option value="2">正常屏蔽</form:option>
				   		   </form:select>
				   		</td>
				   </tr> 
				    <tr>
				   		<th>屏蔽内容：</th>
				   		<td>
				   		     <textarea rows="5" cols="25" name="mtContent" value="${operateKeyword.mtContent}"  class="easyui-validatebox"  maxlength="255">${operateKeyword.mtContent}</textarea>
				   		</td>
				   </tr> 
				   <tr>
				        <th></th>
				   		<td>
				   		     <input type="button" value="保存" id="subBtn"/>
				   		</td>
				   </tr>
				</table>
		  </form:form>
	</div>
	<script type="text/javascript">
	 $("#subBtn").click(function(){
	    	//异步提交表单
			$('#addOperateKeyword').form('submit',{
				url:'${basePath}/baseConf/operateKeyword/addOperateKeyword.action',
				success : function(data) {
					try{
						var jsonData;
						if(JSON){
							jsonData=JSON.parse(data)
						}else{
							jsonData=eval("("+data+")");
						}
						console.log(jsonData);
						if(jsonData.success){
							window.parent.closeSecondWin();
							commonObj.showOpTip("添加成功");
						}else{
							alert("添加失败");
						}
					}catch(e){
						alert("添加失败");
					}
				}
			});	
	    });    
	</script>
</body>
</html>