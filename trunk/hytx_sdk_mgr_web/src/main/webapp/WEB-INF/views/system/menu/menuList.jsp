<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/top.jsp"%>
<title>菜单管理</title>
<div id="p"
	style="padding: 10px; position: fixed; top: 0; padding-left: 20px; width: 100%; height: 20px;; background-color: #fff; z-index: 100;">
	<a id="addBtn" href="javascript:void(0);" class="easyui-linkbutton"
		data-options="iconCls:'icon-add'">添加</a>
	<a id="editBtn" href="javascript:void(0);" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit'">编辑</a>
    <a id="removeBtn" href="javascript:void(0);"
		class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
	<a id="authBtn" href="javascript:void(0);"
		class="easyui-linkbutton" data-options="iconCls:'icon-edit'">设置菜单权限</a>
</div>
<ul id="menuTree" style="margin-top: 40px;" class="easyui-tree" data-options="lines:true,data:[{id:0,state:'closed',text:'管理系统',iconCls:'',attributes:{menuType:1,loaded:0}}],onClick:clickMenuNode,onBeforeExpand:beforeExpand">		
</ul>
<script type="text/javascript">	
	baseAuthFilter();
	var basePath='${basePath}';
	function beforeExpand(node){
	   if($(node.target).siblings("ul").length>0 || $(node.target).attr("loaded") == "1"){
		   return true;
	   }else{
		   loadChildMenus(node);
	   }  
	   return true;
	}
	function clickMenuNode(node){
		  loadChildMenus(node);
		  if(node.attributes.menuType!=2){
	         $('#menuTree').tree('toggle',node.target);
	      }
	      return true;
	}	
	    
	function loadChildMenus(node){
	  if(node.attributes.menuType==2||node.attributes.loaded==1){   
          return ;
	   }
	   $.ajax({
			type:"get",
			url:"${basePath}/system/menu/findChildMenus.action",
			data:"pid="+node.id,
			dataType:'json',
			async:false,
			success:function(data){
			     try{
			    	if(data&&data.length>0){
			    		    var subMenus=data;
				  		    var nodeDatas=[];
				  		    for(var i=0,len=subMenus.length;i<len;i++){
				  		       var n={id:subMenus[i].id,text:subMenus[i].name,state:'closed',target:node};
				  		       if(subMenus[i].menuType==2){
				  		           n.text=subMenus[i].name;
				  		           n.state='open';
				  		       }
				  		       n.attributes={"menuType":subMenus[i].menuType};
				  		       if(subMenus[i].menuType==2){
				  		    	 n.iconCls="tree_node_icon_none"; 
				  		       }
				  		       nodeDatas.push(n);
				  		    }
						    $('#menuTree').tree('append',{
						         parent:node.target,
						         data: nodeDatas
						     });  
			    	  }
			    	  node.attributes.loaded=1;
			    	  $(node.target).attr({"loaded":"1"});
			     }catch (e) {
			    	 commonObj.showAlert('加载菜单失败');
				}
			  }
			});
	    }
    $(document).ready(function(){
    	$("#addBtn").click(function(){
    		var node = $('#menuTree').tree('getSelected');
    		if(!node){
    			commonObj.showAlert("请选择父菜单");
    			return;
    		}
    		if(node.attributes.menuType==2){
    			commonObj.showAlert("功能菜单不能添加子菜单");
    			return;
    		}
    		commonObj.toAdd("添加菜单","toMenuInfo?pid="+node.id);
    	});
    	
        $("#editBtn").click(function(){
        	var node = $('#menuTree').tree('getSelected');
        	if(!node){
        		commonObj.showAlert("请选要编辑的菜单");
        		return;
    		}else if(node.id==0){
    			commonObj.showAlert("根菜单不能编辑");
    			return;
    		}
        	commonObj.toEditWithParams("toMenuInfo?id="+node.id);
    	});
    	
      $("#removeBtn").click(function(){
    	   var node = $('#menuTree').tree('getSelected');
    	   if(!node){
    		   commonObj.showAlert("请选要删除的菜单");
    		   return;
   		   } 
    	   if(node.id == 0){
    		   commonObj.showAlert("根菜单不能被删除");
    		   return;
   		   } 
    	   var content='你确定要删除所选菜单吗?';
    	   if(node.attributes.menuType !=2 ){
    		   content='你确定要删除所选菜单及其子菜单吗?';
    	   }
    	   $.messager.confirm("删除确认",content,function(r){
           	   if(r){
           		    $.ajax({
	          		   url:'delMenu.action',
	          		   type:'get',
	          		   data:{id:node.id},
	          		   dataType:'json',
	          		   success:function(data){
	          			    if(data.status == 0){
	          			    	var node=$('#menuTree').tree('getSelected');
	          			    	$('#menuTree').tree('remove',node.target);
	          			    }else{
	          			    	 commonObj.showAlert("删除失败");
	          			    }
	          		   }
	          	   });  
           	   }
           });
    	});
      
      $("#authBtn").click(function(){
    	    var node = $('#menuTree').tree('getSelected');
	  		if(!node){
	  			commonObj.showAlert("请选择菜单");
	  			return;
	  		}
	  		if(node.attributes.menuType!=2){
	  			commonObj.showAlert("非功能菜单不能设置菜单权限");
	  			return;
	  		}
  		    commonObj.toAdd("设置菜单权限","toAddMenuAuth?menuId="+node.id,860,450);
      });
      
    });
	</script>
</body>
</html>