/**
 * This class is used to handle CRUD operation on the Customer hash table
 * create -- addCustomer
 * read -- getCustomer getAllCustomerslhm getCustomerIdlhm getValidCustomerId
 * update -- updateCustomer
 * generate -- next billId -- getNextBillIingDetailsId
 * 
 */


package cs.bs.handler;

import java.util.Hashtable;
import java.util.LinkedHashMap;

import cs.bs.data.DataFactory;
import cs.bs.dto.Customer;
import cs.bs.util.Helper;

public class CustomerHandler {

	public static boolean addCustomer(Customer customer) {

		boolean result = false;
		try {

			//DataFactory.htCustomers.put(customer.getCustomerId(), customer);
			DataFactory.lhmCustomers.put(customer.getCustomerId(), customer);// LHM Method
			result = true;

		} catch (Exception e) {
			System.out.println("error : CustomerHandler : addCustomer : " + e);
		}

		return result;
	}

	public static boolean updateCustomer(Customer customer) {

		boolean result = false;

		try {
			//DataFactory.htCustomers.remove(customer.getCustomerId());
			//DataFactory.htCustomers.put(customer.getCustomerId(), customer);
			
			DataFactory.lhmCustomers.remove(customer.getCustomerId());//    LHM method
			DataFactory.lhmCustomers.put(customer.getCustomerId(), customer);// LHM method
			result = true;

		} catch (Exception e) {
			System.out.println("error : CustomerHandler : updateCustomer : " + e);
		}
		return result;
	}

	public static Customer getCustomer(int customerId) {

		Customer customer = null;
		try {
			
	
			
			if (DataFactory.lhmCustomers != null && DataFactory.lhmCustomers.size() > 0) // LHM method
			{

				customer = DataFactory.lhmCustomers.get(customerId);// LHM method
			}
			
			

		} catch (Exception e) {
			System.out.println("error : CustomerHandler : getCustomer : " + e);
		}
		return customer;
	}


	
	public static LinkedHashMap<Integer, Customer> getAllCustomerslhm() {
		LinkedHashMap<Integer, Customer> lhmCustomers = null;
		try {

			lhmCustomers = DataFactory.lhmCustomers;                   // LHM method

		} catch (Exception e) {
			System.out.println("error : CustomerHandler : getAllCustomers : " + e);
		}

		return lhmCustomers;

	}
	
	public static int getCustomerIdlhm() {

		int newCustomerId = 0;

		try {
			
			
			
			if (DataFactory.lhmCustomers != null && DataFactory.lhmCustomers.size() > 0) {
				newCustomerId = DataFactory.lhmCustomers.get(DataFactory.lhmCustomers.size() +1000).getCustomerId() + 1;
				
			} else {

				newCustomerId = 1001;
			}

		} catch (Exception e) {
			System.out.println("CustomerHandler: getCustomerId:" + e);
		}

		return newCustomerId;

	}
	
	public static Customer getValidCustomerId() {
		Customer customer = null;
		boolean flag = true;
		while(flag) {
			
		
			int customerId = Helper.getI();
			customer = CustomerHandler.getCustomer(customerId) ;
			
			if(customer != null) {
				flag = false;
			}else {
				System.out.println("Enter the correct customer Id");
			}
			
		}
		
		return customer;
	}

}