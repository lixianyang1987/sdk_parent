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
		<form:form id="addOrEditDictForm" action="addOrEditDict"  method="post" commandName="dict" data-options="ajax:false">
		    <div class="errorBox">
	            <form:errors path="*"/>
	        </div>
		    <input type="hidden" name="id" value="${dict.id}"/>
			<table>  
			   <tr>	
			   		<th>关键字名称：</th>
			   		<td><input type="text" id="key" name="key" value="${dict.key}"
			   		 class="easyui-validatebox" data-options="required:true,validType:['exists'],missingMessage:'请输入关键字名称'"  maxlength="30"/></td>
			   </tr>
			   <tr>	
			   		<th>关键字值：</th>
			   		<td><input type="text" id="val" name="val" value="${dict.val}" class="easyui-validatebox"   maxlength="200"/></td>
			   </tr>
			   <tr>	
			   		<th>状态：</th>
			   		<td>
			   		   <form:radiobutton path="status" value="1" />开启 &nbsp;&nbsp;&nbsp;<form:radiobutton path="status" value="-1"/>关闭
                    </td>
			   </tr>
			   <tr>
			        <th>备注：</th>
			   		<td>
			   			 <textarea name="memo" rows="5" cols="20">${dict.memo}</textarea>
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
	    //自定义检查key存在的验证
	    $.extend($.fn.validatebox.defaults.rules, {
	        exists: {
		        validator: function(value){
	        	if(value != '' && value == '${dict.key}'){
		        	return true;
		        }
		        var mark=true;
		        $.ajax({
	    			url:'${basePath}/baseConf/dict/checkKey.action',
	    			data:{key:value},
	    			type:'get',
	    			async:false,
	    			success:function(data){
	    				if(data.exists){
	    					mark= false;
	    				}
	    			}
	    		});
		        return mark;
	        },
	          message: '关键字名称已存在，请使用其它名称'
	        } 
	    });
	
	    function validSub(){
	    	if($("#addOrEditDictForm").form("validate")){
	    		$.messager.progress();
	    		document.forms['addOrEditDictForm'].submit();
	    	}
	    }
	</script>
</body>
</html>