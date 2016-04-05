<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>指令屏蔽信息列表</title>
    <div style="padding:10px;">
       <h2>指令名称:<font color="red">${operate.opName}</font>  
           &nbsp;&nbsp;运营商：<font color="red"> <c:choose>
				       <c:when test="${operate.serverType==1}">移动</c:when>
				       <c:when test="${operate.serverType==2}">联通</c:when>
				       <c:when test="${operate.serverType==3}">电信</c:when>
				    </c:choose></font> 
           &nbsp;&nbsp;金额：<font color="red">${operate.price}</font>(分) 
           &nbsp;&nbsp;指令类型：<font color="red">${operate.opType==1?'静态指令':'动态指令'}</font>
       </h2>
    </div> 
     <form:form action="operateKeywordList" method="post" id="findOperateKeywordForm">
           <input type="hidden" name="operateId" value="${operate.id}"/>
	</form:form>  
	<table id="dg2" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
				<th data-options="field:'c',width:100">屏蔽号码</th>
				<th data-options="field:'d',width:200">屏蔽内容</th>
				<th data-options="field:'e',width:200">屏蔽状态</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.id}</td>
				<td>${item.mtNum}</td>
				<td>${item.mtContent}</td>
				<td> 
					<c:choose>
						<c:when test="${item.status==-1}">
						    已失效
						</c:when>
						<c:when test="${item.status==1}">
						   仅主动计费屏蔽
						</c:when>
						<c:when test="${item.status==2}">
						    正常屏蔽
						</c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	        var options={
	                singleSelect:false,
	                remoteSort:false,
	                fitColumns:true,
	                title:'指令屏蔽信息列表',
	                noheader:true,
					toolbar: [{
	                   id: 'btnAdd',
	                   text: '添加',
	                   iconCls: 'icon-add',
	                   handler: function () {
		                     commonObj.openSelectWindow({
									href:'${basePath}/baseConf/operateKeyword/toOperateKeywordAdd?operateId=${param.operateId}',
									title:'添加屏蔽信息',
									modal: true,
									width:400,
						            height:300,		
						            onClose:function(){
						            	 $("#findOperateKeywordForm").submit();
						            }
								}); 
	                   }
	               }, '-', {
		                id: 'btnEdit',
		                text: '编辑',
		                iconCls: 'icon-edit',
		                handler: function () {
		                	 var ids=commonObj.getSelectIdValues();
			                    if(ids.length<1){
			                       commonObj.showAlert("请选择要编辑的记录");
			                       return;
			                    }else if(ids.length>1){
			                       commonObj.showAlert("编辑只能选择一条记录");
			                       return;
			                    }   
		                	commonObj.openSelectWindow({
								href:'${basePath}/baseConf/operateKeyword/toOperateKeywordAdd?id='+ids[0],
								title:'编辑屏蔽信息',
								modal: true,
								width:400,
					            height:300,		
					            onClose:function(){
					            	 $("#findOperateKeywordForm").submit();
					            }
							}); 
		                }
		            },'-', {
		                id: 'btnDelete',
		                text: '删除',
		                iconCls: 'icon-remove',
		                handler: function () {
		                	commonObj.toDel(function(r,ids){
		     	               if(r){
			     		          $.ajax({
			     		              type:'get',
			     		              data:{"ids":ids.join(",")},
			     		              url:'delOperateKeyword',
			     		              dataType:'json',
			     		              success:function(data){
			     		              	  if(data.success==false){
			     		                     alert("删除失败，请稍后再试");
			     		                     return;
			     		              	  }else{
			     		              		 commonObj.showOpTip('删除成功',function(){},300,1000);
			     		              	     $("#findOperateKeywordForm").submit();
			     		              	  }
			     		                }
			     		           });   
		     	               }
		     	             });
		                }
		            }]
			};
            filterAuth(options); 
            $("#dg2").datagrid(options);
            
            function closeSecondWin(){
            	$("#mydialog2").panel("close");
            }
	</script>
</body>
</html>