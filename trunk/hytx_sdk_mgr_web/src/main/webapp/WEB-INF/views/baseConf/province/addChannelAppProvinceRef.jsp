<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp"%>
<style type="text/css">
<!--
.pro_ul {
	margin: 10px;
	position: relative;
}

.pro_li {
	list-style: none;
	margin: 5px 14px;
	display: block;
	float: left;
	width: 130px;
}
-->
</style>
<form id="addChannelAppProvinceRef" action="addChannelAppProvinceRef" method="post">
	<input type="hidden" name="recordId" value="${recordId}">
	<ul class="pro_ul">
		<c:forEach items="${list}" var="item">
			<li class="pro_li">
			<input type="checkbox" name="ids"  value="${item.id}" refId="${item.refId}" />${item.provinceName}
			<input type="text" value="${item.dayLimit}"  class="easyui-validatebox" data-options="validType:['number']" size="6" maxlength="6"/>
			</li>
		</c:forEach>
	</ul>
</form>
<div style="text-align: center; margin-top: 20px; clear: both;">
	<input id="selectAll" type="button" value="全选" onclick="selectAll();">
	<input id="revertAll" type="button" value="反选" onclick="revertAll();">
	<input id="cancelAll" type="button" value="全取消" onclick="cancelAll();">
	<input type="button" value="设置所选省份" id="subBtn" />
</div>
<script type="text/javascript">
   $(".pro_ul input").each(function(i,n){
    	if($(n).attr("refId")>0){
    		$(n).attr({"checked":"checked"});
    	}
    }); 
    $("#subBtn").click(function(){
    	$(".pro_ul input").each(function(i,n){
    		if(n.checked == true){
    			$(n).siblings("input:first").attr({"name":"limits"});
    		}
    	});
    	//异步提交表单
		$('#addChannelAppProvinceRef').form('submit',{
			url:'${basePath}/baseConf/province/addChannelAppProvinceRef.action',
			success : function(data) {
				try{
					var jsonData;
					if(JSON){
						jsonData=JSON.parse(data)
					}else{
						jsonData=eval("("+data+")");
					}
					if(jsonData.success){
						$("#mydialog").panel('close');
						commonObj.showOpTip("设置成功");
					}else{
						commonObj.showOpTip("设置失败");
					}
				}catch(e){
					commonObj.showOpTip("设置失败");
				}
			}
		});	
    });
    $(".pro_ul input[type='text']").blur(function(){
    	if($(this).val()==''){
    		$(this).val(0);
    	}
    });
    function selectAll(){
    	$(".pro_ul input[type='checkbox']").each(function(i,n){
    		n.checked = true;
    	});
    }
    
   function cancelAll(){
	   $(".pro_ul input[type='checkbox']").each(function(i,n){
   		   n.checked = false;
   	   });
    }
   function revertAll(){
	   $(".pro_ul input[type='checkbox']").each(function(i,n){
		   if(n.checked){
			   n.checked = false;
		   }else{
			   n.checked = true;
		   }
   		   
   	   });
    }
  </script>
</body>
</html>