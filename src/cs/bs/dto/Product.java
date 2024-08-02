/**
 * This class is used to store the master Product
 * 
 * Serializable - store the object in file
 * constructor and setter and getter methods
 * 
 */


package cs.bs.dto;

import java.io.Serializable;

public class Product implements Serializable{
	
	

	private int productId;
	private String productName;
	private double productPrice;
	
	public Product(int productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public String toString(){
		String output = null;
		output = " \n productId :-" + productId;
		output += "\n productName :- "+ productName;
		output += "\n productPrice :- "+ productPrice;
		  
		return output;
	}

	
	
	

}
