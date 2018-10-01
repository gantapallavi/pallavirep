/**
 * 
 */
package com.product.util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */
public class JdbcConnection {
	//private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/product_db";
	private static final String UNAME="root";
	private static final String PASSWORD="asdf";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(URL,UNAME,PASSWORD);
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Error occured while establishing Connection");
		}
		return con;
	}
	public static void closeDBResources(Connection con) {
		try {
			if(con!=null)
				con.close();
		}catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
	
	public static void closeDBResources(Connection con,PreparedStatement smt) {
		try {
				if(con!=null)
				smt.close();
				con.close();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
