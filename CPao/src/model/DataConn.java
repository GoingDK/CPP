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
			System.out.println("���ݿ��������سɹ���");
			conn= DriverManager.getConnection(dbUrl,dbUser,dbPass);
			System.out.println("�ɹ����ӵ����ݿ�!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		 //�����ṩһ����������ȡ���ݿ�����
		 public static Connection getConnection(){
		return conn;
		 }
		 
		 public static void main(String[] args) throws Exception{
			
		 }

	
}
