<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp" %>
  <title>计费点指令列表</title> 
     <div style="padding:10px;">
       <h2>计费点名称:<font color="red">${payPoint.name}</font>  
           &nbsp;&nbsp;指令类型：<font color="red">${payPoint.opType==1?'静态指令':'动态指令'}</font> 
           &nbsp;&nbsp;运营商：<font color="red"> <c:choose>
				       <c:when test="${payPoint.serverType==1}">移动</c:when>
				       <c:when test="${payPoint.serverType==2}">联通</c:when>
				       <c:when test="${payPoint.serverType==3}">电信</c:when>
				    </c:choose></font> 
           &nbsp;&nbsp;计费金额：<font color="red">${payPoint.feeValue}</font>(分) 
       </h2>
    </div>
     <form:form action="payPointOperateList" method="post" id="findPayPointOperateForm">
           <input type="hidden" name="paypointId" value="${param.paypointId}"/>
	</form:form>     
	<table id="dg" style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',width:10,checkbox:true"></th> 
			    <th data-options="field:'a',width:60">运营商</th>
				<th data-options="field:'b'">指令名称</th>
				<th data-options="field:'c',width:100">上行通道</th>
				<th data-options="field:'d'">指令内容</th>
				<th data-options="field:'e',width:100">计费金额<font color="red">(分)</font></th>
				<th data-options="field:'l'">二次确认内容</th>
			</tr>
		</thead>
		<tbody>  
		    <c:forEach items="${list}" var="item">
			<tr>
			    <td>${item.refRecordId}</td>
				<td>
				    <c:choose>
				       <c:when test="${item.serverType==1}">移动</c:when>
				       <c:when test="${item.serverType==2}">联通</c:when>
				       <c:when test="${item.serverType==3}">电信</c:when>
				    </c:choose>
				</td>
				<td>${item.opName}</td>
				<td>
	                ${item.feeCode }
				</td>
				<td>${item.opCode}</td>
				<td>${item.price}</td>
				<td>${item.ensureContent}</td>
			</tr>
		</c:forEach>
		</tbody>  
	</table>
	<div  style="text-align:right;margin-right:120px;margin-top:10px;font-weight:bold;">总金额：<span id="totalPrice">0</span>分</div>
	<script type="text/javascript">
	        var options={
	                singleSelect:false,
	                remoteSort:false,
	                fitColumns:true,
	                title:'计费点指令列表',   
					toolbar: [{
	                   id: 'btnAdd',
	                   text: '添加指令',
	                   iconCls: 'icon-add',
	                   handler: function () {
	                     commonObj.openSelectWindow({
								href:'toPayPointOperateAdd?id=${payPoint.id}&opType=${payPoint.opType}&serverType=${payPoint.serverType}',
								title:'添加计费点指令 <label style="color:#ff0000;margin-left:120px;">以下为未被此计费点添加过的指令列表</label>',
								modal: true,
								width:600,
					            height:400,
					            left:300,
					            top:200,
					            maximizable:true,
					            minimizable:true,
					            onClose:function(){
					            	 $("#findPayPointOperateForm").submit();
					            }
							}); 
	                   }
	               },'-', {
		                id: 'btnDelete',
		                text: '移除指令',
		                iconCls: 'icon-remove',
		                handler: function () {
		                	commonObj.toDel(function(r,ids){
		     	               if(r){
			     		          $.ajax({
			     		              type:'get',
			     		              data:{"ids":ids.join(",")},
			     		              url:'delPayPointOperate',
			     		              dataType:'json',
			     		              success:function(data){
			     		              	  if(data.success==false){
			     		                     alert("删除失败，请稍后再试");
			     		                     return;
			     		              	  }else{
			     		              		 commonObj.showOpTip('删除成功',function(){},300,1000);
			     		              	     $("#findPayPointOperateForm").submit();
			     		              	  }
			     		                }
			     		           });   
		     	               }
		     	             });
		                }
		            }]
				};
            filterAuth(options);    
            $('#dg').datagrid(options);   
            var data=$("#dg").datagrid("getData");
            if(data.total>0){
            	var rows=data.rows;
            	var totalPrice=0;
            	for(var i=0;i<rows.length;i++){
            		totalPrice=totalPrice+parseInt(rows[i].e);
            	}
            	$("#totalPrice").html(totalPrice);
            }
            function addRow(row){
            	  $("#dg").datagrid("appendRow",row);  
            	  var totalPrice=parseInt($("#totalPrice").text());
            	  totalPrice=totalPrice+parseInt(row.e);
            	  $("#totalPrice").html(totalPrice);
            }
	</script>
</body>
</html>