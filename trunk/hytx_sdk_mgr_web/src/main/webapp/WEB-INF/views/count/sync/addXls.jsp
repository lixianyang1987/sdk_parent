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
<title>添加xls</title>
<div id="p" class="easyui-panel"
	data-options="fit:true,border:false,bodyCls:'add_outer_div'">
	<form action="addSyncByRetained" name="addSyncByRetained" id="addSyncByRetained" method="post"
		   enctype="multipart/form-data">
		
		<table>			
			<tr>
				<th>导入文件：</th>
				<td><input type="text" name="uri"  id="uri"
					maxlength="50"  />
					</td>
					<td>
						输入文件完整路径，文件名加后缀
					</td>
					
					
			</tr>
			
			<tr>
				<th></th>
				<td><input type="button" value="确定" id="subBtn" /></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	$("#subBtn").click(function() {
		
		 $.ajax({
			 url:'${basePath}/count/sync/addSyncByRetained.action',
			 type:'post',
			 dataType:'json',
			 data:{"uri":$("#uri").val()},
			 success:function(data){
				 if(data.success){
					 alert("ok");
				 }else{
					 alert("no");
				 }
			 }
		 });

	});
	
	function readFile(elem){
	    document.getElementById("mytext").value = elem.value;
	}

</script>
</body>
</html>