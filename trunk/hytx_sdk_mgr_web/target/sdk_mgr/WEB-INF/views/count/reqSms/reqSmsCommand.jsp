<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>短串请求指令查询</title>
	<table id="dgCmd"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th data-options="field:'id',align:'center'">ID</th>
			    <th data-options="field:'provinceId',align:'center'">省份</th>
			    <th data-options="field:'serverType',align:'center'">运营商</th>
			    <th data-options="field:'a',align:'center'">指令名称</th>
			    <th data-options="field:'b',align:'center'">短串号码</th> 
				<th data-options="field:'c',align:'center'">短串内容</th>
				<th data-options="field:'d',align:'center'">发送状态</th>
				<th data-options="field:'e',align:'center'">发送次数</th>
				<th data-options="field:'f',align:'center',width:60">资费<font color="red">(分)</font></th>
				<th data-options="field:'g',align:'center'">应用</th>
				<th data-options="field:'h',align:'center',width:80">计费点</th>
				<th data-options="field:'j',align:'center',width:60">间隔时间</th>
				<th data-options="field:'k',align:'center'">提示开关</th>
				<th data-options="field:'l',align:'center'">二次确认内容</th>
				<th data-options="field:'n',align:'center'">确认默认号码</th>
				<th data-options="field:'o',align:'center'">二次确认状态</th>
				<th data-options="field:'m',align:'center'">更新时间</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
			           <td>${item.id}</td>
			           <td>${item.provinceName}</td>
			           <td>
                          <c:choose>
					       <c:when test="${item.serverType==1}">移动</c:when>
					       <c:when test="${item.serverType==2}">联通</c:when>
					       <c:when test="${item.serverType==3}">电信</c:when>
					      </c:choose>
                       </td>
			           <td>${item.operateName}</td>
			           <td>${item.moNum}</td>
			           <td>${item.moContent}</td>
			           <td>
                          <c:choose>
					       <c:when test="${item.sendStatus==-1}">失败</c:when>
					       <c:when test="${item.sendStatus==0}">未同步</c:when>
					       <c:when test="${item.sendStatus==1}">成功</c:when>
					      </c:choose>
                       </td>
			           <td>${item.sendTimes}</td>
			           <td>${item.feeValue}</td>
			           <td>${item.appName}</td>
			           <td>${item.payPointName}</td>
			           <td>${item.waitSeconds}</td>
			           <td>${item.controlFlag}</td>
			           <td>${item.twoEnsure}</td>
			           <td>${item.ensureNum}</td>
			           <td>
                          <c:choose>
					       <c:when test="${item.ensureStatus==-1}">失败</c:when>
					       <c:when test="${item.ensureStatus==0}">未同步</c:when>
					       <c:when test="${item.ensureStatus==1}">成功</c:when>
					      </c:choose>
                       </td>
			           <td><fmt:formatDate value="${item.updateDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					</tr>
				</c:forEach>
			</tbody>	
		</table>
		<script type="text/javascript">
		   $(document).ready(function(){
			  var options={
					    remoteSort:false,
					    noheader:true,
						title:'短串请求指令查询'
			  };
			  $('#dgCmd').datagrid(options);
			});
		</script>
   </body>
</html>