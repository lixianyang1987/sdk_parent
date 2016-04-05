<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
	<title>角色列表</title> 
   <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form action="roleList" method="post" id="findForm">
		       <label>角色名称:</label><input type="text" name="name" class="easyui-validatebox" value="${role.name}"/> <input type="submit" class="findBtn" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form>       
     </div>
   </fieldset>
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
				<th data-options="field:'name',width:150">角色名称</th>
				<th data-options="field:'status',width:150">状态</th>
				<th data-options="field:'createDt',width:200">创建时间</th>
				<th data-options="field:'createBy',width:200">创建人</th>
				<th data-options="field:'op',width:200">操作</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.id }</td>
				<td>${item.name }</td>
				<td>
					<c:if test="${item.status=='-1'}">
						失效
					</c:if>
					<c:if test="${item.status=='1'}">
						生效
					</c:if>
				</td>
				<td><fmt:formatDate value="${item.createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td>${item.createBy}</td>
				<td>
					<c:if test="${item.status=='-1'}">
						<input type="button" value="启用" onclick="vali('${item.id }');"/>
					</c:if>
					<c:if test="${item.status=='1'}">
						<input type="button" value="禁用" onclick="invali('${item.id}');" />
					</c:if>
					 <input type="button" value="编辑" onclick="edit('${item.id }');" />
				</td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	    $(document).ready(function(){
	    	var options={
	               singleSelect:true,
	         	   remoteSort:false,
	         	   title:'角色列表',
	 			   toolbar: [{
	                    id: 'btnAdd',
	                    text: '添加',
	                    iconCls: 'icon-add',
	                    handler: function () {
	                        commonObj.toAdd('添加角色','toRoleInfo',450,400);
	                    }
	                }, '-', {
	                    id: 'btnEdit',
	                    text: '设置角色权限',
	                    iconCls: 'icon-edit',
	                    handler: function () {
	                       addRoleMenus();
	                    }
	                }]
	 		 };
	 	    filterAuth(options);
	        $('#dg').datagrid(options); 
	    });
	</script>
<%@include file="../../common/pageEasyui.jsp" %>
<script language="javascript" type="text/javascript" >
    function invali(id){
         $.messager.confirm("确认禁用","确定禁用此角色吗？",function(r){
           if(r){
     		$.ajax({
     			type:"post",
     			url:"chRoleState",
     			data:{"id":id,"status":-1},
     			success:function(data){
     				var pass=data;
     				if(pass){
     					commonObj.showOpTip("禁用成功",function(){
     				          $('#findForm').get(0).submit();
     				    },1000);
     				}
     			}
     			});
     	    }
         });  	
     }
      //启用角色
    function vali(id){
     $.messager.confirm("确认启用","确定启用此角色吗？",function(r){
     	if(r){
     		$.ajax({
     			type:"post",
     			url:"chRoleState",
     			data:{"id":id,"status":1},
     			success:function(data){
     				var pass=data;
     				if(pass){
     					commonObj.showOpTip("启用成功",function(){
     				          $('#findForm').get(0).submit();
     				    },1000);
     				}
     			}
     			});
     		}	
     	});
     }
	function addRoleMenus(){
         var idValue=commonObj.getRadioIdValue();
             if(idValue){
                var url='${basePath}/system/roleMenuAuth/toRoleMenuAuthInfo?roleId='+idValue;
                addParentTabs('设置菜单权限',url);
                return;
             }else{
                alert("请选择一个角色");
                return;
             }
	}
   function edit(id){
           commonObj.toEditWithParams("toRoleInfo?id="+id);
       }
</script>
</body>
</html>