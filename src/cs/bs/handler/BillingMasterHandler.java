/**
 * This class is used to handle CRUD operation on the Bill Master hash table
 * create -- addBillingMaster
 * read -- getBillingMaster
 * generate --  next billMasterId -- getNextBillId 
 * 
 */

package cs.bs.handler;

import java.util.Enumeration;
import java.util.Hashtable;

import cs.bs.data.DataFactory;
import cs.bs.dto.BillingMaster;

public class BillingMasterHandler {
	
	
	public static boolean addBillingMaster(BillingMaster billingMaster) {
		boolean result = false;
		
		try {
			
			DataFactory.htBillingMaster.put(billingMaster.getBillId(),billingMaster);
			result = true;
			
		}catch(Exception e ) {
			System.out.println("BillingMasterHandler: addBillingMaster :- " + e);
			
		}
		return result ;
	
	}
	
	public static Hashtable<Integer, BillingMaster> getAllBillingMaster() {
		
		Hashtable<Integer, BillingMaster> htBillingMaster = null;
		
			try {
				
				htBillingMaster =	DataFactory.htBillingMaster	;
					
			}catch(Exception e ) {
				System.out.println("BillingMasterHandler: getAllBillingMaster :- " + e);
				
			}
			
			return htBillingMaster;
		
		
	}
	
	
	public static BillingMaster getBillingMaster(int billId) {
		BillingMaster billingMaster = null;
			try {
				
				if (DataFactory.htBillingMaster != null && DataFactory.htBillingMaster.size() > 0) 
				{
					billingMaster =	DataFactory.htBillingMaster.get(billId);
				}
				
				
			}catch(Exception e ) {
				System.out.println("BillingMasterHandler: getBillingMaster :- " + e);
				
			}
		
		return billingMaster;
		
	}
	
	
	
	
	
	public static int getNextBillId() {

		int newBillId = 0;

		try {

			if (DataFactory.htBillingMaster != null && DataFactory.htBillingMaster.size() > 0) {
				newBillId = DataFactory.htBillingMaster.get(1000 + DataFactory.htBillingMaster.size()).getBillId() + 1;
			} else {

				newBillId = 1001;
			}

		} catch (Exception e) {
			System.out.println("BillingMasterHandler: getNextBillId :" + e);
		}

		return newBillId;

	}
	
	public static Hashtable<Integer,BillingMaster> getBillingMasterByCustomerId(int customerId) {
		Hashtable<Integer,BillingMaster> htBillingMaster = null;
		
		try {
			
			Enumeration <Integer> eBillingMasterKey = DataFactory.htBillingMaster.keys();
			
			 htBillingMaster = new Hashtable<Integer,BillingMaster>();
			 
			 while(eBillingMasterKey.hasMoreElements()) {
				 
				 int billMasterBillId = eBillingMasterKey.nextElement();
				 
				 BillingMaster billingMaster = DataFactory.htBillingMaster.get(billMasterBillId);
				 
				 if(customerId == billingMaster.getCustomerId()) {
					 
					htBillingMaster.put(billingMaster.getBillId(), billingMaster);
				 }
				 
			 }
			
		}catch (Exception e) {
			System.out.println("BillingMasterHandler: getBillByCustomerId :" + e);
		}
		
		
		return htBillingMaster;
		
	}
}
