<%@ page  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div id="imgup">	
</div>  
<script type="text/javascript" src="${basePath}/js/ajaxfileupload.js"/>
<script type="text/javascript">
    var selImg,inited=0;
	var selectImg=function(ele){
	   if(selImg){
	       $(selImg).removeClass('add_border1d');
	   }
	   $(ele).addClass('add_border1d');
	   selImg=ele;
	}
   function toUpload(ele){
      if(inited!=1){
        $('#imgup').append('<input id="imginput" type="file" name="file" size="45" title="上传"/><div id="showImgDiv"></div>');
        if($('#showImgDiv').find("img").length>0){
			$('#showImgDiv').remove("img");		      
		} 
        if(ele.value &&ele.value.length>3){
           var arr=ele.value.split(',');
           for(var i=0,len=arr.length;i<len;i++){
              $('#showImgDiv').append('<img  style="margin:5px;float:left;" width="120" onclick="selectImg(this);" src="'+arr[i]+'"/>');
           }
        }
        inited=1;
      }
      $('#imgup').dialog({   
	    title: 'My Dialog',   
	    width: 400,   
	    height: 300,  
	    resizable:true,
	    maximizable:true,
	    minimizable:true,
	    title:'图片上传', 
	    closed: false,   
	    cache: false,     
	    modal: true, 
	    toolbar:[
				{
					iconCls:'icon-add',
					text:'上传',
					handler:function(){
					  /*  if($('#showImgDiv').find("img").length>0){
					      commonObj.showAlert("只能上传单张图片"); 
					      return;    
					   } */
					   if(!$('#imginput').val()){
					       commonObj.showAlert('请选择要上传的图片');
					       return ;
					   }
                       $.ajaxFileUpload({
                          url:'${basePath}/common/upload',
                          fileElementId:'imginput',
                          secureuri:false,
                          dataType:'json',
                          success:function(data,status){
                             $('#showImgDiv').append('<img  style="margin:5px;float:left;" width="120" onclick="selectImg(this);" src="'+data+'"/>');
                          },
                          error: function(xml,status,e) {  
					            commonObj.showAlert("上传失败，请检查文件是否符合格式要求。");     
					        }  
                       }); 
                    }
				},{
					iconCls:'icon-delete',
					text:'删除',
					handler:function(){
                      $(selImg).remove();
                      selImg=null;
                    }
				},{
					iconCls:'icon-edit',
					text:'确定',
					handler:function(){
                        var imgPath=[];
                        $('#showImgDiv').find("img").each(function(){
                          imgPath.push($(this).attr('src'));
                        });
                        if(imgPath.length>1){
                           commonObj.showAlert("只能保留一张图片,请删除多余的图片");
                           return;
                        }
                        ele.value=imgPath.join(",");
                        $('#imgup').dialog('close');
                    }
				}]  
	});  
	
   }
</script>