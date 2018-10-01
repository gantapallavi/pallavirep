/**
 * 
 */
package com.product.bean;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */
public class ProductClass {

	/**
	 * @param args
	 */
	private int pid;
	private String name;
	private String brand;
	private String category;
	private double price;
	
	
	public ProductClass(int pid, String name, String brand, String category, double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
