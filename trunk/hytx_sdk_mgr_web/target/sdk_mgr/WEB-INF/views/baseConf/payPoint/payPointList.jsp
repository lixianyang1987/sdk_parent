<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>计费点管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form action="payPointList" method="post" id="findForm">
                <label>运营商:</label>
                <select id="serverType" name="serverType" class="easyui-validatebox"   style="width:100px;height:26px;">
                     <option value="0">=全部=</option>
	   		         <option value="1">移动</option>
	   		         <option value="2">联通</option>
	   		         <option value="3">电信</option>
			    </select>
		        <label>所属应用：</label>
		        <form:select path="appId" id="appId" items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:22px;"></form:select>
		        <label>计费点名称:</label> <input type="text" name="name" class="easyui-validatebox" value="${payPoint.name}"/> 
		        <label>金额分:</label> <input type="text" name="feeValue" class="easyui-validatebox" value="${payPoint.feeValue}"/> 
		        <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>       
     </div>
   </fieldset>	
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'所属应用',sortable:true">所属应用</th>
				<th data-options="field:'运营商',width:60,sortable:true">运营商</th>
				<th data-options="field:'计费点名称',sortable:true">计费点名称</th>
				<th data-options="field:'计费金额',width:60,sortable:true">计费金额</th>
				<th data-options="field:'计费代码',width:100">计费代码</th>
				<th data-options="field:'计费状态',width:60,sortable:true">计费状态</th>
				<th data-options="field:'指令类型',width:60,sortable:true">指令类型</th>
				<th data-options="field:'备注',width:150">备注</th>
				<th data-options="field:'创建时间',width:150">创建时间</th>
				<th data-options="field:'创建人',width:150">创建人</th>
				<th data-options="field:'op',width:200">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td><a href="javascript:toTabLink('应用管理','${basePath}/baseConf/app/appList?appName=${appMap.get(item.appId)}');" class="link_a">${appMap.get(item.appId)}</a></td>
				    <td>
					    <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					    </c:choose>
					</td>
				    <td>${item.name}</td>
				    <td>${(item.feeValue+0.0)/100}元</td>
				    <td>${item.payCode}</td>
				    <td>${item.status == 1?"生效":"未生效"}</td>
				    <td>${item.opType == 1?"静态指令":"动态指令"}</td>
					<td>${item.memo}</td>
					<td>
						<fmt:formatDate value="${item.createDt}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>${item.createBy}</td>
					<td>
					<c:if test="${item.status!=1}">
						<input type="button" value="启用" onclick="valid('${item.id }');"/>
					</c:if>
					<c:if test="${item.status==1}">
						<input type="button" value="禁用" onclick="invalid('${item.id}');" />
					</c:if>
				</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
	 <%@include file="../../common/pageEasyui.jsp" %>
	 <script type="text/javascript">
	 $("#serverType").find("option[value='${payPoint.serverType}']").attr({"selected":"selected"});
	  var options={
				singleSelect:false,
				remoteSort:false,
				title:'计费点列表',
				toolbar: [{
			                id: 'btnAdd',
			                text: '添加',
			                iconCls: 'icon-add',
			                handler: function () {
			                    commonObj.toAdd('添加计费点','toPayPointInfo',600,450);
			                }
			            }, '-', {
			                id: 'btnEdit',
			                text: '编辑',
			                iconCls: 'icon-edit',
			                handler: function () {
			                	commonObj.toEdit('toPayPointInfo',600,450,'编辑计费点');
			                }
			            }, '-', {
			                id: 'btnDelete',
			                text: '删除',
			                iconCls: 'icon-remove',
			                handler: function () {
			                	commonObj.toDel(function(r,ids){
			     	               if(r){
				     		           $.ajax({
				     		              type:'get',
				     		              data:{"ids":ids.join(",")},
				     		              url:'delPayPoint',
				     		              dataType:'json',
				     		              success:function(data){
				     		              	  if(data.success==false){
				     		                     alert("删除失败，请稍后再试");
				     		                     return;
				     		              	  }
				     		              	  $("#findForm").submit();
				     		                }
				     		           });  
			     	               }
			     	             });
			                }
			            }, '-', {
			                id: 'btnSetOperate',
			                text: '配置指令',
			                iconCls: 'icon-edit',
			                handler: function () {
			                	 var ids=commonObj.getSelectIdValues();
			                     if(ids.length<1){
			                        commonObj.showAlert("请选择要配置指令的记录");
			                        return;
			                     }else if(ids.length>1){
			                        commonObj.showAlert("配置指令只能选择一条记录");
			                        return;
			                     }
			               	     window.parent.addTab('计费点指令配置','${basePath}/baseConf/payPointOperate/payPointOperateList.action?paypointId='+ids[0]);
			                }
			            }]
			   };
	  filterAuth(options);
	  $('#dg').datagrid(options);
	  
	  function invalid(id){
	         $.messager.confirm("确认禁用","确定禁用此计费点吗？",function(r){
	           if(r){
	     		$.ajax({
	     			type:"post",
	     			url:"chPaypointState",
	     			data:{"id":id,"status":-1},
	     			dataType:'json',
	     			success:function(data){
	     				var pass=data.status;
	     				if(pass){
	     					commonObj.showOpTip("禁用成功",function(){
	     				          $('#findForm').get(0).submit();
	     				    },500);
	     				}else{
	     					alert(data.info);
	     				}
	     			}
	     			});
	     	    }
	         });  	
	     }
	      //启用计费点
	    function valid(id){
	     $.messager.confirm("确认启用","确定启用此计费点吗？",function(r){
	     	if(r){
	     		$.ajax({
	     			type:"post",
	     			url:"chPaypointState",
	     			data:{"id":id,"status":1},
	     			dataType:'json',
	     			success:function(data){
	     				var pass=data.status;
	     				if(pass){
	     					commonObj.showOpTip("启用成功",function(){
	     				          $('#findForm').get(0).submit();
	     				    },500);
	     				}else{
	     					alert(data.info);
	     				}
	     			}
	     			});
	     		}	
	     	});
	     }
	  
	</script>
</body>
</html>