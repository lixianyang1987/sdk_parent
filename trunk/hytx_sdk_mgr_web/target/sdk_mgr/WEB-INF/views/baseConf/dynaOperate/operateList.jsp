<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>动态指令列表</title> 
   <fieldset class="top-fieldset" >
     <div id="tb">
          <form:form action="operateList" method="post" id="findForm">
               <label>应用：</label>
               <form:select path="appId" id="appId" items="${appList}" itemLabel="appName" itemValue="id" cssClass="easyui-validatebox" style="width:152px;height:26px;"></form:select>
		       <label>动态指令名称:</label><input type="text" name="opName" class="easyui-validatebox" value="${operateDto.opName}"/> 
		       <label>运营商:</label>
               <form:select id="serverType" path="serverType" cssClass="easyui-validatebox"  cssStyle="width:100px;height:26px;">
                     <form:option value="0">=全部=</form:option>
	   		         <form:option value="1">移动</form:option>
	   		         <form:option value="2">联通</form:option>
	   		         <form:option value="3">电信</form:option>
			   </form:select>
			   <label>开通省份:</label>
			   <form:select path="provinceId"  cssClass="easyui-validatebox" style="width:150px;height:26px;">
			       <form:option value="-1">=全部=</form:option>
			       <form:options items="${proList}" itemLabel="provinceName" itemValue="id" />
			   </form:select>         
		       <input type="submit" class="findBtn" value="查询"/>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>     
     </div>
   </fieldset>
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
			    <th data-options="field:'appName'">所属应用</th>
			    <th data-options="field:'a',width:60">运营商</th>
				<th data-options="field:'b'">指令名称</th>
				<th data-options="field:'price'">资费<font color="red">(分)</font></th>
				<th data-options="field:'c'">上行通道</th>
				<th data-options="field:'d'">指令接口</th>
				<th data-options="field:'f',width:60">模糊位数</th>
				<th data-options="field:'g',width:40">状态</th>
				<th data-options="field:'h',width:35">权重</th>
				<th data-options="field:'计费应用编号',width:100">计费应用编号</th>
				<th data-options="field:'计费渠道编号',width:100">计费渠道编号</th>
				<th data-options="field:'k'">二次确认类型</th>
				<th data-options="field:'l'">二次确认内容</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.id }</td>
			     <td><a href="javascript:toTabLink('应用管理','${basePath}/baseConf/app/appList?appName=${appMap.get(item.appId)}');" class="link_a">${appMap.get(item.appId)}</a></td>
				<td>
				    <c:choose>
				       <c:when test="${item.serverType==1}">移动</c:when>
				       <c:when test="${item.serverType==2}">联通</c:when>
				       <c:when test="${item.serverType==3}">电信</c:when>
				    </c:choose>
				</td>
				<td>${item.opName}</td>
				<td>${item.price>0?item.price:'任意资费'}</td>
				<td>
	                ${item.feeCode }
				</td>
				<td>${interfaceMap.get(item.opCode)}</td>
				<td>${item.suffixNum}</td>
				<td>
				    <c:choose>
				       <c:when test="${item.status==1}">启用</c:when>
				       <c:otherwise>未启用</c:otherwise>
				    </c:choose>
				</td>
				<td>${item.weight}</td>
				<td>${item.appSn}</td>
				<td>${item.channelSn}</td>
				<td> 
					<c:choose>
						<c:when test="${item.ensureType==null||item.ensureType==0}">
						   无
						</c:when>
						<c:when test="${item.ensureType==1}">
						    静态确认
						</c:when>
						<c:when test="${item.ensureType==2}">
						    动态确认
						</c:when>
					</c:choose>
				</td>
				<td>${item.ensureContent}</td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<script type="text/javascript">
	           var options={
	        		singleSelect:true,
	        		remoteSort:false,
	        		title:'动态指令列表',
	   				toolbar: [{
	                    id: 'btnAdd',
	                    text: '添加',
	                    iconCls: 'icon-add',
	                    handler: function () {
	                        //commonObj.toAdd('添加动态指令','toOperateInfo',800,450);
	                 	   window.location.href="toOperateInfo"
	                    }
	                }, '-', {
	 	                id: 'btnEdit',
	 	                text: '编辑',
	 	                iconCls: 'icon-edit',
	 	                handler: function () {
	 	                	//commonObj.toEdit('toOperateInfo',800,450,'编辑动态指令');
	 	                	var ids=commonObj.getSelectIdValues();
	 	                    if(ids.length<1){
	 	                       commonObj.showAlert("请选择要编辑的记录");
	 	                       return;
	 	                    }else if(ids.length>1){
	 	                       commonObj.showAlert("编辑只能选择一条记录");
	 	                       return;
	 	                    }
	 	                    window.location.href="toOperateInfo?id="+ids[0];
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
	 		     		              url:'delOperate',
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
	 	     	             },'删除指令将会删除其与渠道包的关联数据，你确定要删除吗？');
	 	                }
	 	            }, '-', {
		                id: 'btnSetOperateKeyword',
		                text: '配置屏蔽信息',
		                iconCls: 'icon-edit',
		                handler: function () {
		                	 var ids=commonObj.getSelectIdValues();
		                     if(ids.length<1){
		                        commonObj.showAlert("请选择要配置屏蔽信息的记录");
		                        return;
		                     }else if(ids.length>1){
		                        commonObj.showAlert("只能选择一条记录");
		                        return;
		                     }
		                    window.parent.addTab('指令屏蔽信息配置','${basePath}/baseConf/operateKeyword/operateKeywordList.action?operateId='+ids[0]);
		                }
		            }]
	 			};
	           filterAuth(options);
               $('#dg').datagrid(options);
               
               function configProvince(id){
                	 commonObj.toAdd('设置指令省份  <label style="color:#ff0000;margin-left:46px;">以下为开通省份以及省份的日限条数,0为不限量</label>','${basePath}/baseConf/province/toAddOperateProvinceRef?recordId='+id,550,450);
              }  
	</script>
<%@include file="../../common/pageEasyui.jsp" %>
</body>
</html>