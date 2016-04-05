<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>城市管理</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form action="provinceCityList" method="post" id="findForm">
               <label>省份:</label><form:select path="provinceId" items="${proList}" itemLabel="provinceName" itemValue="id" cssClass="easyui-validatebox" style="width:150px;height:26px;"></form:select>         
		       <label>城市名称:</label> <input type="text" name="cityName" class="easyui-validatebox" value="${provinceCity.cityName}"/> <input class="findBtn" type="submit" value="查询"/> 
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>       
     </div>
   </fieldset>	
      <table id="dg"   style="width:auto;height:auto;">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,width:50"></th>
				<th data-options="field:'a',width:100">城市名称</th>
				<th data-options="field:'b',width:100">城市编码</th>
	            <th data-options="field:'c',width:100">所属省份</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.resultList}" var="item">
				<tr>
				    <td>${item.id}</td>
				    <td>${item.cityName }</td>
				    <td>${item.cityCode }</td>
			        <td>${item.provinceName}</td>
				</tr>
				</c:forEach>
			</tbody>	
		</table>
		<%@include file="../../common/pageEasyui.jsp" %>
	 <script type="text/javascript">
	   var options={
			   singleSelect:false,
			   remoteSort:false,
			   title:'城市列表',
			   toolbar: [{
			                id: 'btnAdd',
			                text: '添加',
			                iconCls: 'icon-add',
			                handler: function () {
			                    commonObj.toAdd('添加城市','toProvinceCityInfo',550,400);
			                }
			            }, '-', {
			                id: 'btnEdit',
			                text: '编辑',
			                iconCls: 'icon-edit',
			                handler: function () {
			                	commonObj.toEdit('toProvinceCityInfo',550,450,'编辑城市');
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
				     		              url:'delProvinceCity',
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
		            }]
		   };
	   filterAuth(options);
	   $('#dg').datagrid(options);
	</script>
</body>
</html>