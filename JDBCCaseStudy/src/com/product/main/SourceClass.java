
/**
 * 
 */
package com.product.main;

import java.util.Scanner;

import com.product.bean.ProductClass;
import com.product.dao.productDAO;
import com.product.dao.userDAO;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */
public class SourceClass {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter login details");
		System.out.println("Enter name");
		String usr=sc.next();
		System.out.println("Enter password");
		String pswd=sc.next();
		if(userDAO.authenticateUser(usr,pswd))
		{
			int c;
			System.out.println("Admin 1 or user 2");
			c=sc.nextInt();
			if(c==2) {
				
				menuForUser();
			}
			else {
				menuForAdmin();
			}
		}
	}

	/**
	 * @param args
	 */
	static Scanner sc= new Scanner(System.in);
public static void menuForAdmin()
{
	int ch;
	do {
		System.out.println("1. Add Products");
		System.out.println("2. View Products");
		System.out.println("3. View Products by category");
		System.out.println("4.Delete Products");
		System.out.println("5.Update Products");
//		System.out.println("6.Add User");
		System.out.println(".Log out");
		System.out.println("\n Enter option");
		
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:
				System.out.println("enter id");
				int pid=sc.nextInt();
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("enter brand");
				String brand=sc.next();
				System.out.println("enter category");
				String category=sc.next();
				System.out.println("enter price");
				Double price=sc.nextDouble();
				ProductClass p=new ProductClass(pid,name,brand,category,price);
				productDAO.addProduct(p);
				break;
		case 2:	productDAO.showProduct();
				break;
		case 3:	System.out.println("enter category");
				  String cat=sc.next();
				productDAO.showProductByCategory(cat);
				break;
		case 4:	System.out.println("enter id");
				int id=sc.nextInt();
				productDAO.deleteProduct(id);
				break;
		case 5:	 System.out.println("Enter price:");
				 double pri=sc.nextDouble();
				 System.out.println("enter id");
				 int id1=sc.nextInt();
				productDAO.updateProduct(pri,id1);
				break;
		
		case 6:System.out.println("Logging out.......\n");
		default:System.out.println("Invalid option!Try again.\n");
		}
	}while(ch!=6);
}
public static void menuForUser() {
	int ch;
	do {
		System.out.println("1.View Products");
		System.out.println("2.View Products by category");
		System.out.println("3.Sort products");
		System.out.println("4.Log out");
		System.out.println("\n Enter option:");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:productDAO.showProduct();
				break;
		case 2: System.out.println("enter category");
				String cat=sc.next();
				productDAO.showProductByCategory(cat);
				break;
		case 3:	System.out.println("Enter high limit");
				double up=sc.nextDouble();
				System.out.println("Enter lower limit");
				double lp=sc.nextDouble();
				productDAO.sortProduct(up,lp);
				break;
		case 4:System.out.println("Logging out.......\n");
		default:System.out.println("Invalid option!Try again.\n");
		}
	}while(ch!=4);	
}

public static void userRegistration() {
	System.out.println("\n Enter  user Id ");
	int id=sc.nextInt();
	System.out.println("Enter Aadhar ");
	int aadhar=sc.nextInt();
	System.out.println("\n Enter  username");
	String usr=sc.next();
	System.out.println("\n Enter password");
	String pswd=sc.next();
	System.out.println("\n Enter Type");
	double type=sc.nextDouble();
	
	
	
}


}
