<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>角色菜单权限管理</title>
  <div id="p"
	style="padding: 10px; position: fixed; top: 0; padding-left: 20px; width: 100%; height: 20px;; background-color: #fff; z-index: 100;">
	<a id="authBtn" href="javascript:void(0);"
		class="easyui-linkbutton" data-options="iconCls:'icon-edit'">设置${param.name}权限</a>
</div>
<ul id="menuTree" style="margin-top: 40px;">		
</ul>
<script type="text/javascript">	
    var  dataMenus=jQuery.parseJSON('${rootNode}');
    $('#menuTree').tree({
        data: dataMenus,
        lines:true,
        checkbox:true,
     });
    
    function findLeafId(node,selIds){
    	if(node.children.length<1 && node.attributes.isLeaf==1){
    		selIds.push(node.id);
    	}	
    }
    
    $(document).ready(function(){
    	$("#authBtn").click(function(){
    		var roleId='${param.roleId}';
    		var sels=$('#menuTree').tree("getChecked");
    		var ids=[];
    		for(var i=0;i<sels.length;i++){
        		findLeafId(sels[i],ids);
        	} 
    		$.ajax({
    			url:'${basePath}/system/roleMenuAuth/addRoleMenuAuth.action',
    			type:'get',
    			data:{roleId:roleId,menuAuthIds:ids.join(",")},
    			dataType:'json',
    			success:function(data){
    				if(data.success){
						alert("设置成功");
					}else{
						alert("设置失败");
					}
    			}
    		});
    		console.log(ids);
    	});

    });
 </script>
</body>
</html>