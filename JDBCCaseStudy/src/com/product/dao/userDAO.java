/**
 * 
 */
package com.product.dao;

import java.sql.*;

import com.product.bean.UserClass;
import com.product.util.JdbcConnection;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */

public class userDAO {

	/**
	 * @param args
	 */
	
	public  Boolean insertUser(UserClass uc)
	{
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		boolean userExits=false;
		String query1="select id from user where id=?;";
		String query2="insert into user values(?,?,?,?,?);";
		try {
			smt=con.prepareStatement(query1);
			smt.setInt(1,uc.getId());
			ResultSet rs=smt.executeQuery();
			if(rs.next()) {
				System.out.println("User already exists!try with different username and password");
				return false;
			}
			else {
				smt=con.prepareStatement(query2);
				smt.setInt(1, uc.getId());
				smt.setInt(2, uc.getAadhar());
				smt.setString(3, uc.getName());
				smt.setString(4, uc.getPassword());
				smt.setString(5, uc.getType());
				smt.execute();
				System.out.println("User added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
		return true;
			
	}
	public static  boolean authenticateUser(String name,String password) {
		
			Connection con=JdbcConnection.getConnection();
			PreparedStatement smt=null;
			ResultSet rs=null;
			boolean flag =true;
			String query="select * from user where name=? and pswd=?;";
			try {
				smt=con.prepareStatement(query);
				smt.setString(1, name);
				smt.setString(2, password);
				rs=smt.executeQuery();
				if(rs.next()) {
					System.out.println("WELCOME USER");
					flag=true;
				}else {
					System.out.println("NO USER");
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcConnection.closeDBResources(con,smt);
			}
			return flag;
			
	}
	
	
}
