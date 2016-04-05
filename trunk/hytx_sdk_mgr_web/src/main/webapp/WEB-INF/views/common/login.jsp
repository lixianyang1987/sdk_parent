<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp" %>
<style type="text/css">
  body{
    
    background-image: url("${basePath}/images/Login.png");
    
  }
  #loginDiv{
     width:400px;
     height:335px;
     top:50%;
     left:50%;
     margin-left:-200px;
     margin-top:-168px;
     position:absolute;
     border: 1px solid #ccc;
     background-color:#fff;
     box-shadow:0 0 40px #ccc; 
  }
  #tit{
    font-size: 24px;
    font-weight: normal;
    text-align: center;
    margin-top:36px;
    font-family: "宋体";
  }
  .loginForm{
     bottom: 125px;
     position: absolute;
     height: 140px;
     width: 100%;
  }
  .loginForm th{
    font-weight: bold;
    text-align: right;
    width:85px;
  }
  .loginForm td{
    text-align: left;
  }
   .loginForm tr{
       line-height: 55px;
       vertical-align: middle;
  }
  .loginForm input{
     height:35px;
     width: 235px;
     vertical-align: middle;
     border: 1px solid #cccccc;
  }
  .loginForm img{
     height:35px;
     vertical-align: middle;
  }
  .loginForm .btn{
     background-image: url("${basePath}/images/Login_Btn.png");
     border-radius:5px;
     font-weight: normal;
     font-family: "楷体";
     font-weight:bold;
     font-size:18px;
     margin-top:8px;
     width: 180px;
  }
</style>
 <div id="loginDiv">
		<div id="tit">后台管理系统</div>
		<div style="color:#53ff53;text-align: center;" id="tip">${msg}</div>
		<div class="loginForm">
		   <form action="login" method="post" id="toLogin">
			     <table  style="">
			    	<tr>
			    		<th>登录名：</th>
			    		<td><input  placeholder="输入用户名" id="loginName" name="loginName" value="${loginName}" type="text"   class="easyui-validatebox" data-options="required:true,missingMessage:'请输入登录名',validType:['length[3,30]']" /></td>
			    	</tr>
			    	<tr>
			    		<th>密 码：</th>
			    		<td><input  placeholder="输入密码" name="password" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请输入密码'"/></td>
			    	</tr>
			    	<tr>
	    	            <th> 验证码：</th>
                        <td>
                             <input placeholder="输入验证码" name="vcode" type=text value="" style="width:170px;" class="easyui-validatebox"  maxLength=4 size=10 data-options="required:true,missingMessage:'请输入验证码',deltaX:65">
                             <img id="vcodeImg" src="${basePath}/images/loginimg.jsp"  width="60" height="35px"/>
                       </td>			    	
			    	</tr>
			    	<tr>
			    		<td></td>
			    		<td><input class="btn"  type="button" value="登    录" onclick="validSub();" /></td>
			    	</tr>
			    </table> 
			</form>
		</div>
	</div>
	<script type="text/javascript">
	   var num=1;
	   $(document).ready(function(){
		  $("#vcodeImg").click(function(){
			  $(this).attr("src","${basePath}/images/loginimg.jsp?n="+num);
			  num=num+1;
		  });
		  $("input").change(function(){
			  $("#tip").html("");
		  });
		  
		  $(window).keydown(function(event){
			  if(event.keyCode==13){
				  validSub();
			  } 
		  });
		  
		});
	   
	   function validSub(){
	    	if($("#toLogin").form("validate")){
	    		$.messager.progress();
	    		document.forms['toLogin'].submit();
	    	}
	    }
	</script>
</body>
</html>
