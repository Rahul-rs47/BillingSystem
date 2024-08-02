/**
 * This class is used to store the  details of products in a bill 
 * 
 * Serializable - store the object in file
 * constructor and setter and getter methods
 * 
 */

package cs.bs.dto;

import java.io.Serializable;

public class BillDetails implements Serializable{
	
	

	private int billDetailsId;
	private int billId;
	private int productId;
	private int quantity;
	
	public BillDetails(int billDetailsId, int billId, int productId, int quantity) {
		super();
		this.billDetailsId = billDetailsId;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public int getBillDetailsId() {
		return billDetailsId;
	}
	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
