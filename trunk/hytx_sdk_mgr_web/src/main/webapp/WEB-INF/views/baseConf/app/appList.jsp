<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>应用列表</title> 
   <fieldset class="top-fieldset" >
     <div id="tb">
          <form:form action="appList" method="post" id="findForm">
		       <label>应用名称:</label><input type="text" name="appName" class="easyui-validatebox" value="${app.appName}"/>
		       <label>所属SP:</label>
			   <form:select path="cpId"  cssClass="easyui-validatebox"  panelHeight="AUTO"  style="width:150px;height:26px;"
                         items="${cpList}"  itemLabel="cpName"  itemValue="id"/>
               <label>结算方式：</label><form:select path="smId" items="${smList}"
						itemLabel="smName" itemValue="smId" cssClass="easyui-validatebox"
						style="width:150px;height:26px;"></form:select>              
		       <input type="submit" class="findBtn" value="查询"/>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>  
		
     </div>
   </fieldset>
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
			    <th data-options="field:'ID'">ID</th>
				<th data-options="field:'name'">应用名称</th>
				<!-- <th data-options="field:'appsn'">APPID</th>
				<th data-options="field:'channelsn'">上游渠道ID</th>
				<th data-options="field:'key'">KEY</th>
				    <td>${item.appSn }</td>
			     <td>${item.channelSn }</td>
			    <td>${item.appKey }</td>
				 -->
				<th data-options="field:'cpId',width:100">所属SP</th>
				<th data-options="field:'appDescribe',width:100">结算方式</th>
				<th data-options="field:'m'">结算百分数</th>
				<th data-options="field:'createDt',width:150">创建时间</th>
				<th data-options="field:'createBy',width:100">创建人</th>
			    <th data-options="field:'操作'">操作</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.id }</td>
			    <td>${item.id }</td>
			    <td>${item.appName }</td>
			
				<td>
	                ${item.cpName }
				</td>
				<td>
	                ${item.smName }
				</td>
				<td>${item.feePercent}%</td> 	
				<td><fmt:formatDate value="${item.createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td>${item.createBy}</td>	
				<td>
				   <a href="javascript:serverConf(${item.id});"  class="selectBtn" style="width:100px;">运营商配置</a>
				</td>	
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	       var options={
	            	singleSelect:true,
	            	remoteSort:false,
	            	title:'应用列表',
					toolbar: [{
	                   id: 'btnAdd',
	                   text: '添加',
	                   iconCls: 'icon-add',
	                   handler: function () {
	                       commonObj.toAdd('添加应用','toAppInfo',500,450);
	                   }
	               }, '-', {
		                id: 'btnEdit',
		                text: '编辑',
		                iconCls: 'icon-edit',
		                handler: function () {
		                	commonObj.toEdit('toAppInfo',500,450,'编辑应用');
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
			     		              url:'delApp',
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
		     	             },'删除应用将会删除应用关联数据，包括渠道包，计费点，指令及它们关联的数据，你确定要删除吗？');
		                }
		            }, '-', {
		                id: 'btnSetProvince',
		                text: '设置省份',
		                iconCls: 'icon-edit',
		                handler: function () {
		                	var rows=$("#dg").datagrid("getChecked");
		                	if(rows.length>1){
		                		commonObj.showAlert("只能给一个应用设置省份");
		                		return;
		                	}
		                	var id=rows[0].id;
		                	commonObj.toAdd('设置应用省份  <label style="color:#ff0000;margin-left:46px;">以下为开通省份以及省份的日限金额(分),0为不限量</label>','${basePath}/baseConf/province/toAddAppProvinceRef?recordId='+id,550,450);
		                }
		            }]
		  };
	      filterAuth(options);
          $('#dg').datagrid(options);
          
          function serverConf(id){
        	  window.parent.addTab('运营商配置','${basePath}/baseConf/appServer/appServerList.action?appId='+id);
          }
	</script>
<%@include file="../../common/pageEasyui.jsp" %>
</body>
</html>