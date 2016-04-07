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
	margin: 5px 10px;
	display: block;
	float: left;
	width: 46%;	
}
-->
</style>
<form id="addMenuAuth" action="addMenuAuth" method="post">
	<input type="hidden" name="menuId" value="${menuId}">
	<ul class="pro_ul">
		<c:forEach items="${authList}" var="item">
			<li class="pro_li">
				<input type="checkbox" name="authIds"  value="${item.id}" refId="${item.menuId}"/>${item.authName}<br/>
			    <textarea rows="1"  cols="46"   class="easyui-validatebox" placeholder="权限对应的一个或多个url,以逗号分隔">${item.url}</textarea>
			</li>
		</c:forEach>
	</ul>
</form>
<div style="text-align: center; margin-top: 40px; clear: both;">
	<input type="button" value="设置权限" id="subBtn" />
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
    			$(n).siblings("textarea:first").attr({"name":"urls"});
    		}
    	});
    	//异步提交表单
		$('#addMenuAuth').form('submit',{
			url:'${basePath}/system/menu/addMenuAuth.action',
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
  </script>
</body>
</html>