<%@ page  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div class="easyui-pagination" style="border:1px solid #95B8E7;border-top:0;width:auto;"  
          data-options="   
            total: ${page.totalCount },   
            pageSize: ${page.pageSize }, 
            pageNumber:${page.pageIndex},  
            onSelectPage: function(pageIndex, pageSize){ 
                $('#page_id').val(pageIndex);  
                $('#page_size').val(pageSize);
                $('#findForm').submit();   
            }">  
 </div>  


