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
		<form:form id="addOrEditAppServerForm"  action="addOrEditAppServer"  method="post" commandName="appServer" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${appServer.id}"/>
		    <input type="hidden" id="appId" name="appId" value="${appServer.id!=null?appServer.appId:param.appId}"/>
			<table> 
			     <tr>
				   		<th>运营商：</th>
				   		<td>
				   		    <select id="serverType" name="serverType" class="easyui-validatebox" style="width:100px;">
				   		         <option value="1">移动</option>
				   		         <option value="2">联通</option>
				   		         <option value="3">电信</option>
				   		    </select>
				   		</td>
				   		<script type="text/javascript">
				   		       $("#addOrEditAppServerForm").find("#serverType").find("option[value='${appServer.serverType}']").attr({"selected":"selected"});
				   		</script>
				  </tr> 
				  <tr>
				   		<th>用户日限额：</th>
				   		<td>
				   		   <input type="text" id="dayLimit" name="dayLimit" value="${appServer.dayLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>用户月限额：</th>
				   		<td>
				   		   <input type="text" id="monthLimit" name="monthLimit" value="${appServer.monthLimit}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">分(0或不填表示不限)</font>
				   		</td>
				   </tr> 
				   <tr>
				   		<th>提示开关：</th>
				   		 <td>
				                           开启<input type="radio" name="controlFlag" value="1" checked="checked">&nbsp;&nbsp;关闭<input type="radio" name="controlFlag" value="0"/>
				        </td>
				   </tr> 
				   <tr>
				   		<th>指令使用范围：</th>
				   		 <td>
				                           共享<input type="radio" name="opRange" value="1" checked="checked">&nbsp;&nbsp;私有<input type="radio" name="opRange" value="2"/>
				        </td>
				   </tr> 
				   <tr>
				   		<th>指令发送间隔秒数：</th>
				   		<td>
				   		   <input type="text" id="waitSeconds" name="waitSeconds" value="${appServer.waitSeconds}" data-options="validType:['minNum[0]']"   class="easyui-validatebox"/><font color="red">秒</font>
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
	        $("#addOrEditAppServerForm").find("input[name='controlFlag'][value='${appServer.controlFlag}']").attr({"checked":"checked"});
	        $("#addOrEditAppServerForm").find("input[name='opRange'][value='${appServer.opRange}']").attr({"checked":"checked"});
	        function validSub(){
		    	if($("#addOrEditAppServerForm").form("validate")){
		    		var opRange=$("input[name='opRange'][checked='checked']").val();
		    		if(opRange!='${appServer.opRange}'&&'${appServer.opRange}'!=''){
		    			$.ajax({
			    			url:'${basePath}/baseConf/appServer/checkPrivateOp.action',
			    			data:{appId:$("#appId").val(),serverType:$("#serverType").val()},
			    			type:'get',
			    			async:false,
			    			success:function(data){
			    				if(data.exists){
			    					 var list=data.list;
			    					 var content='';
			    					 for(var i=0,len=list.length;i<len;i++){
                                         if(i>0){
                                        	 content=content+"|"; 
			    						 }
			    						 content=content+list[i].name;
			    					 }
			    					 alert(content+"  这些计费点中包含此运营商应用的指令，若要设置成私有，请先删除这些计费点");
			    				}else{
			    					$.messager.progress();
			    		    		document.forms['addOrEditAppServerForm'].submit();
			    				}
			    			}
			    		});
		    		}else{
		    			$.messager.progress();
    		    		document.forms['addOrEditAppServerForm'].submit();
		    		}
		    	}
		    }
	</script>
</body>
</html>