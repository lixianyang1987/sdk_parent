<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
 <%@include file="../../common/top.jsp" %>
  <title>信支付日志查询</title>
  <fieldset class="top-fieldset" >
     <div id="tb" style="padding:5px;height:auto">
          <form:form  action="xzfLogList" method="post" id="findForm">
		       <table id="findTable">
		         <tr>
			          <th width="65px">开始日期:</th>
			          <td width="80px">
			             	<input type="text" id="startDate" name="startDate" value="${xzfFlowLogDto.startDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			          </td>
			          <th width="65px">结束日期:</th>
			          <td>
			             <input type="text" id="endDate" name="endDate" value="${xzfFlowLogDto.endDate}" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser,required:true" />
			             <input type="button" id="findBtn" style="margin-left:15px;" class="findBtn" value="查询"/>
			          </td>
		         </tr> 
		       </table>
		       <input type="hidden" name="pageIndex" value="${page.pageIndex }" id="page_id"/>
			   <input type="hidden" name="pageSize" value="${page.pageSize }" id="page_size"/>
		 </form:form>  
     </div>
   </fieldset>
   <style type="text/css">
	  #dg{
	     
	  
	  }
	  
	  
	  #dg td,#dg th{
	   border-color: #ccc;
	   margin: 0px;
	   padding: 0px;
	   border-style:solid;
	   border-width: 0 1px 1px 0;
	   font-size: 13px;
	   font-family: verdana,helvetica,arial,sans-serif;
	   text-align: center;
	   vertical-align: middle;
	   padding: 2px;
	   word-wrap:break-word;
	   overflow: auto;
	  }
	  #dg th{
	    background-color: #f4f4f4;
	  }
	</style>
	<div class="panel datagrid" style="overflow: scroll;">
	<div class="panel-header" style="width:100%;"><div class="panel-title">日志列表</div><div class="panel-tool"></div></div>
	<table id="dg"  style="width:auto;height:auto;">
		<thead>
			<tr>
			    <th width="230px">订单号</th> 
			    <th width="120px">IMEI</th> 
			    <th width="120px">IMSI</th> 
			    <th width="100px">手机号</th> 
			    <th width="80px">用户姓名</th> 
			    <th width="180px">日志名称</th> 
			    <th width="200px">日志描述</th> 
			    <th width="150px">日志时间</th> 
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${dataMap}" var="item">
				    <c:set var="list" value="${item.value}"></c:set>
				    <c:set var="rows" value="${list.size()}"></c:set>
					<tr>
			           <td rowspan="${rows}">${item.key}</td>
			           <td rowspan="${rows}">${list[0].imei}</td>
			           <td rowspan="${rows}">${list[0].imsi}</td>
			           <td rowspan="${rows}">${list[0].mobile}</td>
			           <td rowspan="${rows}">${list[0].userName}</td>
		               <td width="100px">${list[0].name}</td>
		               <td><div style="width:200px;max-width:200px;word-wrap:word-break;">${list[0].memo}</div></td>
		               <td><fmt:formatDate value="${list[0].createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					</tr>
					<c:if test="${rows>1}">
					   <c:forEach items="${list}" begin="1" var="it">
					       <tr>
				               <td>${it.name}</td>
				               <td><div style="width:200px;max-width:200px;word-wrap:word-break;">${it.memo}</div></td>
				               <td><fmt:formatDate value="${it.createDt}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
							</tr>
					   </c:forEach>
					</c:if>
				</c:forEach>
			</tbody>	
		</table>
		</div>
		<%@include file="../../common/pageEasyui.jsp" %>
		<script type="text/javascript">
			 $("#findBtn").click(function(){
				 var endDate=$('#endDate').datebox('getValue');
				 var startDate=$('#startDate').datebox('getValue');
				 if(endDate < startDate){
					 alert('开始日期必须小于结束日期');
					 return false;
			      }
	    		  document.forms['findForm'].submit();
			 });
		</script>
</body>
</html>