/**
 * This program is used to store the data in the hashtables
 * product
 * customer
 * bill
 */

package cs.bs.data;

import java.util.Hashtable;
import java.util.LinkedHashMap;

import cs.bs.dto.BillDetails;
import cs.bs.dto.BillingMaster;
import cs.bs.dto.Customer;
import cs.bs.dto.Product;
import cs.bs.util.FileHelper;

public class DataFactory {

	public static Hashtable<String, Object> billData;

	public static Hashtable<Integer, Product> htProducts;
	public static Hashtable<Integer, BillingMaster> htBillingMaster;
	public static Hashtable<Integer, BillDetails> htBillDetails;
	public static LinkedHashMap<Integer,Customer>lhmCustomers;

	public static boolean syncData() {

		boolean result = false;

		try {

			DataFactory.billData = FileHelper.readData();

			if (DataFactory.billData == null) {

				DataFactory.billData = new Hashtable<String, Object>();

				
				htProducts = new Hashtable<Integer, Product>();
				htBillingMaster = new Hashtable<Integer, BillingMaster>();
				htBillDetails = new Hashtable<Integer, BillDetails>();
				lhmCustomers = new LinkedHashMap<Integer,Customer>();

				
				DataFactory.billData.put("products", htProducts);
				DataFactory.billData.put("billingMaster", htBillingMaster);
				DataFactory.billData.put("billDetails", htBillDetails);
				DataFactory.billData.put("customers",lhmCustomers);

				FileHelper.writeData(DataFactory.billData);
			}

			if (DataFactory.billData != null) {

				
				htProducts = (Hashtable<Integer, Product>) DataFactory.billData.get("products");
				htBillingMaster = (Hashtable<Integer, BillingMaster>) DataFactory.billData.get("billingMaster");
				htBillDetails = (Hashtable<Integer, BillDetails>) DataFactory.billData.get("billDetails");
				lhmCustomers = (LinkedHashMap<Integer,Customer>) DataFactory.billData.get("customers");

			}
			result = true;

		} catch (Exception e) {

			result = false;

			System.out.println("error : DataFactory : syncData : " + e);

		}

		return result;

	}

	public static boolean writeData() {

		boolean result = false;

		try {
			DataFactory.billData = new Hashtable<String, Object>();


			
			DataFactory.billData.put("products", htProducts);
			DataFactory.billData.put("billDetails", htBillDetails);
			DataFactory.billData.put("billingMaster", htBillingMaster);
			DataFactory.billData.put("customers", lhmCustomers);
			FileHelper.writeData(DataFactory.billData);

			result = true;

		} catch (Exception e) {

			result = false;

			System.out.println("error : DataFactory : writeData : " + e);

		}

		return result;

	}

}
