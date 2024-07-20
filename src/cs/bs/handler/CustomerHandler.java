package cs.bs.handler;

import cs.bs.dto.Customer;

public class CustomerHandler {
	
	
	
	
	public static Customer createCustomer(int customerId, String customerName,String customerMobileNumber,String customerPlace) {
		
		Customer customer = null; 
		
		try {
			
			customer = new Customer (customerId,customerName,customerMobileNumber,customerPlace);
			
			
			
		}catch(Exception e) {
			System.out.println("CustomerHandler: createCustomer " + e);
		}
		
		return customer;

	}
	
	
}