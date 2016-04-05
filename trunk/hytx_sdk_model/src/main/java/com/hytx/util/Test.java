package com.hytx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {
	private static Connection connect;
	
	private static int n=1;
	
	public static void main(String[] args) {
		Semaphore sem=new Semaphore(1);
		Semaphore sem2=new Semaphore(0);
		for(int i=0;i<11;i++){
			Thread t1=new Thread(new MyRunnable(sem,sem2));
			Thread t2=new Thread(new MyRunnable(sem2,sem)); 
			t1.start();
			t2.start();
		}
	}
	
	public static int selectTotal(Connection connection) throws SQLException{
		//connection.commit();
		int total=0;
		String sql="select count(*) from t_tb";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			total=rs.getInt(1);
		}
		rs.close();
		pst.close();
		System.out.println("total:"+total);
		return total;
	}
	
	public static int insert(Connection connection) throws SQLException{
		connection.setAutoCommit(false);
		String sql="insert into t_tb(name)values(?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, "hhh");
		pst.execute();
		if(n%5==0){
			connection.commit();
		}
		System.out.println("n:"+n);
		n++;
		return 0;
	}
	
	
	synchronized public static Connection getConnection(){
		/*if(connect!=null){
			return connect;
		}*/
		ResourceBundle bundle=ResourceBundle.getBundle("application");
		try{
			Class.forName(bundle.getString("jdbc.driver"));
			connect=DriverManager.getConnection(bundle.getString("jdbc.url"), bundle.getString("jdbc.username"), bundle.getString("jdbc.password"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return connect;
	}
	
	public static class MyRunnable implements Runnable{
		private Semaphore sem;
		private Semaphore semNext;
		public MyRunnable(Semaphore sem,Semaphore semNext){
			this.sem=sem;
			this.semNext=semNext;
		}
		@Override
		public void run() {
			  try {
					sem.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
			    }
			    try {
					Test.insert(getConnection());
					TimeUnit.SECONDS.sleep(1);
					Test.selectTotal(getConnection());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    semNext.release();
			    try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
