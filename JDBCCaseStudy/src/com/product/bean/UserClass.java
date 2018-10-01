/**
 * 
 */
package com.product.bean;

/**
 * @author pallavi
 * @Date 24-Sep-2018
 */
public class UserClass {
	private int id;
	private int aadhar;
	private String password;
	private String name;
	private String type;
	

	public UserClass(int id, int aadhar, String password, String name, String type) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.password = password;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	public int getAadhar() {
		return aadhar;
	}


	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
