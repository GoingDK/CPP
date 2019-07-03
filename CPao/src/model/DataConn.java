package model;

import java.sql.*;

public class DataConn {
		static String dbUrl = "jdbc:mysql://193.112.10.155/cpptakeoutsys?useSSL=false&useUnicode=true&characterEncoding=utf8";
		static String dbUser = "root";
		static String dbPass = "123456";
		static String driveName = "com.mysql.jdbc.Driver";
		private static Connection conn=null;
		
		 static{
			try {
				Class.forName(driveName);
			System.out.println("数据库驱动加载成功！");
			conn= DriverManager.getConnection(dbUrl,dbUser,dbPass);
			System.out.println("成功连接到数据库!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		 //对外提供一个方法来获取数据库连接
		 public static Connection getConnection(){
		return conn;
		 }
		 
		 public static void main(String[] args) throws Exception{
			
		 }

	
}
