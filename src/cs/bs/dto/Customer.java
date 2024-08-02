/**
 * This class is used to store the master Customer
 * 
 * Serializable - store the object in file
 * constructor and setter and getter methods
 * 
 */

package cs.bs.dto;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private  int customerId;
	private String customerName;
	private String customerMobileNumber;
	private String customerPlace;


	public Customer(int customerId, String customerName, String customerMobileNumber, String customerPlace) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNumber = customerMobileNumber;
		this.customerPlace = customerPlace;
	}

	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}

	public String getCustomerPlace() {
		return customerPlace;
	}

	public void setCustomerPlace(String customerPlace) {
		this.customerPlace = customerPlace;
	}
	
	public String toString(){
		String output = null;
		output = " \n customerId :-" + customerId;
		output += "\n customerName :- "+ customerName;
		output += "\n customerMobileNumber :- "+ customerMobileNumber;
		output += "\n customerPlace :- "+ customerPlace;
		  
		return output;
	}

}
