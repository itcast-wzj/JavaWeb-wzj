package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtils {
	//数据库的四大参数,一般的话是从配置文件中获取
	static String driver =  "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&useSSL=true";
	static String username = "root";
	static String password = "123";
	
	public static Connection getConn(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConn(Connection conn){
		//关闭连接,只有当连接不是null才关,是null还关干嘛
		try {
			if(null != conn && !conn.isClosed() ){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
