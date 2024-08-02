/*
 * This class is used to handle CRUD operation on the Bill Details hash table
 * create -- addBillDetails
 * read -- getBillDetailbyBillId
 * generate -- next billId -- getNextBillIingDetailsId
 * 
 * */

package cs.bs.handler;

import java.util.Enumeration;
import java.util.Hashtable;

import cs.bs.data.DataFactory;
import cs.bs.dto.BillDetails;

public class BillDetailsHandler {
	
	
	public static boolean addBillDetails(BillDetails billdetails) {
		boolean result = true;
		
		try {
			
			DataFactory.htBillDetails.put(billdetails.getBillDetailsId(), billdetails);
			result = true;
			
		}catch(Exception e) {
			System.out.println("BillDetailsHandler : addBillDetails : - " + e);
			
		}
		
		return result;
		
	}
	
	
	public static Hashtable<Integer,BillDetails> getBillDetailbyBillId(int billId){
		Hashtable<Integer, BillDetails>  htBillDetails = null;
		
		try {
			
			 Enumeration<Integer> eBillDetailsKey = DataFactory.htBillDetails.keys();
			 
			 htBillDetails = new Hashtable<Integer, BillDetails>();
			    
			 // Checking for next element in Hashtable object with the help of hasMoreElements() method
			    while (eBillDetailsKey.hasMoreElements()) {
	 
			        // Getting the key of a particular entry
			        int billDetailsId = eBillDetailsKey.nextElement(); 
			        
			        BillDetails billDetails = DataFactory.htBillDetails.get(billDetailsId);
			        
			        if(billId == billDetails.getBillId()) {
			        	
			        	htBillDetails.put(billDetails.getBillDetailsId(), billDetails);
			        	
			        }
			       
			        
			    }

			
		}catch(Exception e) {
			System.out.println("BillDetailsHandler : getBillDetailbyBillId : - " + e);
		}
		return htBillDetails;
	}

	public static int getNextBillIingDetailsId() {

		int newBillDetailsId = 0;

		try {

			if (DataFactory.htBillDetails != null && DataFactory.htBillDetails.size() > 0) {
				newBillDetailsId = DataFactory.htBillDetails.get(DataFactory.htBillDetails.size()).getBillDetailsId() + 1;
			} else {

				newBillDetailsId = 1;
			}

		} catch (Exception e) {
			System.out.println("BillDetailsHandler: getNextBillingDetailsId:" + e);
		}

		return newBillDetailsId;

	}
}
