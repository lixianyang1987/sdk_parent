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
	margin: 5px 64px;
	display: block;
	float: left;
	width: 60px;	
}
-->
</style>
<form id="modifyUserRoles" action="modifyUserRoles" method="post">
	<input type="hidden" name="userId" value="${param.id}">
	<ul class="pro_ul">
		<c:forEach items="${list}" var="item">
			<li class="pro_li">
				<input type="checkbox" name="roleIds"  value="${item.id}" refId="${item.userId}"/>${item.name}
			</li>
		</c:forEach>
	</ul>
</form>
<div style="display: block;clear: both;"></div>
<div style="text-align: center; margin-top: 20px;">
	<input type="button" value="设置角色" id="subBtn" />
</div>
<script type="text/javascript">
   $(".pro_ul input").each(function(i,n){
    	if($(n).attr("refId")>0){
    		$(n).attr({"checked":"checked"});
    	}
    }); 
    $("#subBtn").click(function(){
    	//异步提交表单
		$('#modifyUserRoles').form('submit',{
			url:'${basePath}/system/user/modifyUserRoles.action',
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
						commonObj.showOpTip("设置角色成功");
					}else{
						commonObj.showOpTip("设置角色失败");
					}
				}catch(e){
					commonObj.showOpTip("设置角色失败");
				}
			}
		});	
    });
  </script>
</body>
</html>