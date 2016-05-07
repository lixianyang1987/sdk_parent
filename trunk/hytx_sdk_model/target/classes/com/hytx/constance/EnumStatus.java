package com.hytx.constance;

public enum EnumStatus {
   del(-10),//逻辑删除状态
   ok(1), //可使用状态
   failure(-1);//不可使用状态
   
   private Integer value;
   private EnumStatus(Integer value){
	   this.value=value; 
   }
   public Integer getValue(){
	   return this.value;
   }
	
   public static boolean isEfficient(int status){
	   EnumStatus[] values = EnumStatus.values();
	   for(EnumStatus es:values){
		   if(es.getValue()==status){
			   return true;
		   }
	   }
	   return false;
   }
}
