/**
 * This class is used to store the master Bill items
 * 
 * Serializable - store the object in file
 * constructor and setter and getter methods
 * 
 */


package cs.bs.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BillingMaster implements Serializable {
	
	private int billId;
	private int customerId;
	private LocalDate billDate;
	private double totalAmount;

	public BillingMaster(int billId, int customerId, LocalDate billDate, double totalAmount) {
		super();
		this.billId = billId;
		this.customerId = customerId;
		this.billDate = billDate;
		this.totalAmount = totalAmount;
	}



	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



}
