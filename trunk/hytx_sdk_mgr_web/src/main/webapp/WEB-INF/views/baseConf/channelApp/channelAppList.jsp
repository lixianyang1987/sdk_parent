<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp"%>
<title>渠道包列表</title>
<fieldset class="top-fieldset">
	<div id="tb">
		<form:form action="channelAppList" method="post" id="findForm">
			<label>渠道:</label>
			<form:select path="channelId" items="${channelList}"
				itemLabel="channelName" itemValue="id" cssClass="easyui-validatebox"
				style="width:152px;height:26px;"></form:select>
			<label>优选应用:</label>
			<form:select path="appId" items="${appList}" itemLabel="appName"
				itemValue="id" cssClass="easyui-validatebox"
				style="width:152px;height:26px;"></form:select>
			<label>结算方式：</label>
			<form:select path="smId" items="${smList}" itemLabel="smName"
				itemValue="smId" cssClass="easyui-validatebox"
				style="width:150px;height:26px;"></form:select>
			<label>名称:</label>
			<form:input path="name" />
			<input type="submit" class="findBtn" value="查询" />
			<input type="hidden" name="pageIndex" value="${page.pageIndex }"
				id="page_id" />
			<input type="hidden" name="pageSize" value="${page.pageSize }"
				id="page_size" />
		</form:form>
	</div>
</fieldset>
<table id="dg" style="width: auto; height: auto;">
	<thead>
		<tr>
			<th data-options="field:'id',width:10,checkbox:true"></th>
			<th data-options="field:'n'">渠道包ID</th>
			<th data-options="field:'推广包名'">渠道包名</th>
			<th data-options="field:'a'">渠道名称</th>
			<th data-options="field:'b'">优选应用</th>			
			<th data-options="field:'d',width:60">结算方式</th>
			<th data-options="field:'g'">扣量百分数</th>
			<th data-options="field:'e',width:60">同步状态</th>
			<th data-options="field:'c',width:80">渠道包KEY</th>
			<th data-options="field:'k',width:100">用户日限额</th>
			<th data-options="field:'l',width:100">用户月限额</th>
			<th data-options="field:'m'">结算百分数</th>
			<th data-options="field:'cpa'">CPA金额(分)</th>
			<th data-options="field:'密钥'">密钥</th>
			<th data-options="field:'f'">同步URL</th>
			
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id }</td>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td><a
					href="javascript:toTabLink('渠道管理','${basePath}/baseConf/channel/channelList?channelName=${item.channelName}');"
					class="link_a">${item.channelName}</a></td>
				<td><a
					href="javascript:toTabLink('应用管理','${basePath}/baseConf/app/appList?appName=${item.appName}');"
					class="link_a">${item.appName}</a></td>				
				<td>${item.smName}</td>
				<td>${item.reducePercent}%</td>
				<td>${item.syncStatus==1?'同步':'不同步'}</td>
				<td>${item.key}</td>				
				<td>${item.dayLimit>0?item.dayLimit:'不限'}<font color="red">（分）</font></td>
				<td>${item.monthLimit>0?item.monthLimit:'不限'}<font color="red">（分）</font></td>
				<td>${item.feePercent}%</td>
				<td>${item.cpaPrice}<font color="red">（分）</font></td>
				<td>${item.signKey}</td>
				<td>${item.syncUrl}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	var options = {
		singleSelect : true,
		striped : true,
		remoteSort : false,
		title : '渠道包列表',
		toolbar : [
				{
					id : 'btnAdd',
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
						commonObj.toAdd('添加渠道包', 'toChannelAppInfo', 550, 480);
					}
				},
				'-',
				{
					id : 'btnEdit',
					text : '编辑',
					iconCls : 'icon-edit',
					handler : function() {
						commonObj.toEdit('toChannelAppInfo', 550, 480, '编辑渠道包');
					}
				},
				'-',
				{
					id : 'btnDelete',
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						commonObj.toDel(function(r, ids) {
							if (r) {
								$.ajax({
									type : 'get',
									data : {
										"ids" : ids.join(",")
									},
									url : 'delChannelApp',
									dataType : 'json',
									success : function(data) {
										if (data.success == false) {
											alert("删除失败，请稍后再试");
											return;
										}
										$("#findForm").submit();
									}
								});
							}
						});
					}
				},
				'-',
				{
					id : 'btnSetOperate',
					text : '配置指令',
					iconCls : 'icon-edit',
					handler : function() {
						var ids = commonObj.getSelectIdValues();
						if (ids.length < 1) {
							commonObj.showAlert("请选择要配置指令的记录");
							return;
						} else if (ids.length > 1) {
							commonObj.showAlert("配置指令只能选择一条记录");
							return;
						}
						window.parent.addTab('渠道包指令配置',
								'${basePath}/baseConf/channelAppOperate/channelAppOperateList.action?id='
										+ ids[0]);
					}
				},
				'-',
				{
					id : 'btnSetPayPoint',
					text : '设置计费点',
					iconCls : 'icon-edit',
					handler : function() {
						var ids = commonObj.getSelectIdValues();
						if (ids.length < 1) {
							commonObj.showAlert("请选择要设置计费点的记录");
							return;
						} else if (ids.length > 1) {
							commonObj.showAlert("设置计费点只能选择一条记录");
							return;
						}
						window.parent.addTab('渠道包计费点配置',
								'${basePath}/baseConf/channelAppPayPoint/channelAppPayPointList.action?id='
										+ ids[0]);
					}
				},
				'-',
				{
					id : 'btnSetProvince',
					text : '设置省份',
					iconCls : 'icon-edit',
					handler : function() {
						var ids = commonObj.getSelectIdValues();
						if (ids.length < 1) {
							commonObj.showAlert("请选择要设置省份的记录");
							return;
						} else if (ids.length > 1) {
							commonObj.showAlert("设置省份只能选择一条记录");
							return;
						}
						commonObj
								.toAdd(
										'设置渠道包省份  <label style="color:#ff0000;margin-left:46px;">以下为开通省份以及省份的日限金额(分),0为不限量</label>',
										'${basePath}/baseConf/province/toAddChannelAppProvinceRef?recordId='
												+ ids[0], 550, 450);
					}
				} ]
	};
	filterAuth(options);
	$('#dg').datagrid(options);
</script>
<%@include file="../../common/pageEasyui.jsp"%>
</body>
</html>