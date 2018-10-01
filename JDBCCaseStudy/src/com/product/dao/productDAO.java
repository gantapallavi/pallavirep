/**
 * 
 */
package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.product.bean.ProductClass;
import com.product.bean.UserClass;
import com.product.util.JdbcConnection;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */
public class productDAO {

	/**
	 * @param args
	 */
	public static void addProduct(ProductClass pc) {
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="select pid from product where pid=?;";
		String query2="insert into product values(?,?,?,?,?);";
		try {
			smt=con.prepareStatement(query1);
			smt.setInt(1,pc.getPid());
			ResultSet rs=smt.executeQuery();
			if(rs.next()) {
				System.out.println("User already exists!");	
			}else
			{
				
				smt=con.prepareStatement(query2);
				smt.setInt(1, pc.getPid());
				smt.setString(2, pc.getName());
				smt.setString(3, pc.getBrand());
				smt.setString(4, pc.getCategory());
				smt.setDouble(5, pc.getPrice());
				smt.execute();
				System.out.println("Product added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
		
			
	}
	
	public static void showProduct() {
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="select * from product ;";
		try {
			smt=con.prepareStatement(query1);
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
					System.out.println(rs.getInt(1)+":"+ rs.getString(2)+":" +rs.getString(3)+":"+rs.getString(4)+":"+rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
		
			
	}
	
	
	public static void showProductByCategory(String cat) {
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="select * from product where pcat=?;";
		try {
			smt=con.prepareStatement(query1);
			smt.setString(1,cat);
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
					System.out.println(rs.getInt(1)+":"+ rs.getString(2)+":" +rs.getString(3)+":"+rs.getString(4)+":"+rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
		
	}
	
	public static void deleteProduct(int id) {
		
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="delete from product where pid=?;";
		try {
			smt=con.prepareStatement(query1);
			smt.setInt(1,id);
			smt.execute();
			System.out.println("Record is deleted");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
	}
	
	
	public static void updateProduct(double pri,int id1) {
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="update product set price=? where pid=?;";
		try {
			smt=con.prepareStatement(query1);
			smt.setDouble(1,pri);
			smt.setInt(2, id1);
			smt.execute();
			System.out.println("Record is updated");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}		
	}
	
	public static void sortProduct(double up,double lp) {
		Connection con=JdbcConnection.getConnection();
		PreparedStatement smt=null;
		String query1="select * from product where price>=? and price<=?;";
		try {
			smt=con.prepareStatement(query1);
			smt.setDouble(1,up);
			smt.setDouble(2, lp);
			ResultSet rs=smt.executeQuery();
			while(rs.next()) {
					System.out.println(rs.getInt(1)+":"+ rs.getString(2)+":" +rs.getString(3)+":"+rs.getString(4)+":"+rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnection.closeDBResources(con, smt);
		}
		
	}
}
