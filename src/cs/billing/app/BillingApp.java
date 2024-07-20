package cs.billing.app;

import java.time.LocalDate;
import java.util.Hashtable;

import cs.bs.data.DataFactory;
import cs.bs.dto.BillDetails;
import cs.bs.dto.BillingMaster;
import cs.bs.dto.Customer;
import cs.bs.dto.Product;
import cs.bs.util.FileHelper;
import cs.bs.util.Helper;

@SuppressWarnings("unchecked")
public class BillingApp {

	public static Product products[];
	public static Customer customers[];

	public static Hashtable<Integer, BillingMaster> htBillingMaster;

	public static Hashtable<Integer, BillDetails> htBillDetails;

	static {

		try {

			DataFactory.billData = FileHelper.readData();
			if (DataFactory.billData == null) {
				DataFactory.billData = new Hashtable<String, Object>();
				DataFactory.billData.put("product", DataFactory.productData);
				DataFactory.billData.put("customer", DataFactory.customerData);

				htBillingMaster = new Hashtable<Integer, BillingMaster>();
				htBillDetails = new Hashtable<Integer, BillDetails>();

				DataFactory.billData.put("billingMaster", htBillingMaster);
				DataFactory.billData.put("billDetails", htBillDetails);

				FileHelper.writeData(DataFactory.billData);
			}

			if (DataFactory.billData != null) {
				products = (Product[]) DataFactory.billData.get("product");
				customers = (Customer[]) DataFactory.billData.get("customer");

				htBillingMaster = (Hashtable<Integer, BillingMaster>) DataFactory.billData.get("billingMaster");
				htBillDetails = (Hashtable<Integer, BillDetails>) DataFactory.billData.get("billDetails");

				/*
				 * for(Product product : products) { System.out.println(product); }
				 */

				System.out.println("htBillingMaster.size() : " + htBillingMaster.size());

				displayAllBillDetails();

			}

		} catch (Exception e) {
			System.out.println("error : Library : static block : " + e);
		}

	}

	public static void main(String args[]) {

		int option;
		while (true) {

			System.out.println("Main Menu");
			System.out.println("~~~~~`~~~~~~`~~~~~~");
			System.out.println("1 .Bill ");
			System.out.println("2. Product ");
			System.out.println("3. Customer ");
			System.out.println("4. Exit ");

			System.out.println("Please enter from the above menu options 1 to 4");
			option = Helper.getIBetween(1, 4);

			switch (option) {

			case 1:

				int billOption = 0;
				while (billOption != 9) {
					System.out.println("Bill Options");
					System.out.println("~~~~~`~~~~~~`~~~~~~");
					System.out.println("1. Generate Bill ");
					System.out.println("2. Display All Bill Details");
					System.out.println("3. Search Bill ");
					System.out.println("9. Back to Main menu");
					System.out.println("Please Enter from the above menu options 1 to 4");
					billOption = Helper.getI();

					switch (billOption) {

					case 1:

						/* generate Bill */
						System.out.println("Generate Bill");
						generateBill();

						break;

					case 2:

						/* display all bill details */
						
						displayAllBillDetails();
						
						
						break;
						
					case 3:

						/* search bill by bill Id*/
						
						System.out.println("Enter  the Bill Id");
						int billId = Helper.getI();
						
						boolean output = displayBillDetails(billId);
						
						if(!output) {
							System.out.println("There is no bill with this bill Id : " +  billId);
						}
						
						
						break;
					default : 
						System.out.println("Wrong Option, Please choose a right option !");
						
							

					}

				}

				break;

			case 2:
				int productOption = 0;
				while (productOption != 5) {
					System.out.println("Product Options");
					System.out.println("~~~~~`~~~~~~`~~~~~~");
					System.out.println("1. View all Product ");
					System.out.println("2. Search Product");
					System.out.println("3. Add product");
					System.out.println("4. Edit product");
					System.out.println("5. Back to Main menu");
					System.out.println("Please enter from the above menu options 1 to 4");
					productOption = Helper.getIBetween(1, 5);

					switch (productOption) {

					case 1:

						/* View all Product */
						System.out.println(" View all Product");
						break;

					case 2:

						/* Search Product */
						System.out.println(" Search Product");
						break;

					case 3:

						/* Add product */
						System.out.println(" Add product");
						break;

					case 4:

						/* Edit product */
						System.out.println(" Edit product");
						break;

					}
				}
				break;

			case 3:
				int customerOption = 0;
				while (customerOption != 6) {

					System.out.println("Customer Options");
					System.out.println("~~~~~`~~~~~~`~~~~~~");
					System.out.println("1. View all Customer ");
					System.out.println("2. Search Customer");
					System.out.println("3. Add Customer");
					System.out.println("4. Edit Customer");
					System.out.println("5.Search Bill by Customer id");
					System.out.println("6. Back to Main menu");
					System.out.println("Please enter from the above menu options 1 to 6");
					customerOption = Helper.getIBetween(1, 6);

					switch (customerOption) {

					case 1:

						/* View all Customer */
						System.out.println(" View all Customer");
						break;

					case 2:

						/* Search Customer */
						System.out.println(" Search Customer");
						break;

					case 3:

						/* Add Customer */
						System.out.println(" Add Customer");
						break;

					case 4:

						/* Edit Customer */
						System.out.println(" Edit Customer");
						break;
					case 5:

						/* Search Bill by customer Id */
						System.out.println(" Search Bill by Customer id");
						break;

					}
				}
				break;

			case 4:
				System.out.println("Thanks for using billing system");
				System.exit(0);

			}

		}

	}

	private static boolean displayBillDetails(int billId) {
		
		boolean result = true; 
		
		BillingMaster billingMaster = null;
		int billingMasterBillId;
		
		try {
			
			
			if (htBillingMaster != null && htBillingMaster.size() > 0) {


					try {
						billingMaster = htBillingMaster.get(billId);
						if(billingMaster != null) {
							billingMasterBillId = billingMaster.getBillId();
						}else {
							result = false;
							return result;
						}

					}catch (Exception e) {
						
						result = false;
						
						System.out.println("BillingApp: displayBillDetails nestedTry :" + e);
						return result;
						
					}
					
					
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("			RAHUL SUPERMARKET 						   ");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					System.out.print("Bill Id : " + billingMaster.getBillId());
					System.out.print("                          ");
					
					System.out.println("Bill Date : " + billingMaster.getBillDate());
					System.out.print("Customer Id : " + billingMaster.getCustomerId());
					System.out.print("                 ");
					System.out.println("Customer Name  : " + getCustomerById(billingMaster.getCustomerId()).getCustomerName() );
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					if (htBillDetails != null && htBillDetails.size() > 0) {

						// System.out.print("htBillDetails.size() : " + htBillDetails.size());

						for (int j = 1; j <= htBillDetails.size(); j++) {

							BillDetails billDetails = htBillDetails.get(j);

							if (billDetails != null && billingMasterBillId == billDetails.getBillId()) {

								int billProductId = billDetails.getProductId();
								int qty = billDetails.getQuantity();
								double price = getProductById(billProductId).getProductPrice();
								double subTotal = qty * price;

								System.out.println("Product Id : " + billProductId + "   " + " Qty : " + qty
										+ " Unit Price : " + price + " Amount  : " + subTotal);

							}

						}
					}

					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.print("                                  ");
					System.out.println("Total Amount    : " + billingMaster.getTotalAmount());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			
		} catch (Exception e) {
			
			result = false;
			System.out.println("BillingApp: displayBillDetails :" + e);
		}
		
		
		return result;
		
		
	}

	public static void generateBill() {
		int customerId, productId, quantity;
		LocalDate billDate = null;
		char option;
		int billId = getNextBillId();
		double productPrice = 0;

		System.out.println("billId : " + billId);

		double totalAmount = 0;
		BillingMaster billingMaster = null;
		int billDetailsId = 0;

		BillDetails billDetails = null;

		try {
			billDate = Helper.getCurrentDate();
			System.out.println("Enter the Customer id");
			customerId = Helper.getI();

			do {
				System.out.println("Enter  productId");
				productId = Helper.getI();
				System.out.println("Enter  quantity");
				quantity = Helper.getI();

				productPrice = getProductById(productId).getProductPrice();

				billDetailsId = getNextBillIingDetailsId();

				billDetails = new BillDetails(billDetailsId, billId, productId, quantity);

				htBillDetails.put(billDetailsId, billDetails);

				totalAmount += (productPrice * quantity);

				System.out.println("Do you want to enter more Products Y/N ");
				option = Helper.getC();

			} while (option == 'y' || option == 'Y');

			billingMaster = new BillingMaster(billId, customerId, billDate, totalAmount);

			htBillingMaster.put(billId, billingMaster);

			DataFactory.billData = new Hashtable<String, Object>();

			DataFactory.billData.put("product", DataFactory.productData);
			DataFactory.billData.put("customer", DataFactory.customerData);

			DataFactory.billData.put("billDetails", htBillDetails);
			DataFactory.billData.put("billingMaster", htBillingMaster);

			FileHelper.writeData(DataFactory.billData);

		} catch (Exception e) {
			System.out.println("BillingApp: generateBill :" + e);
		}
	}

	public static int getNextBillId() {

		int newBillId = 0;

		try {

			if (htBillingMaster != null && htBillingMaster.size() > 0) {
				newBillId = htBillingMaster.get(1000 + htBillingMaster.size()).getBillId() + 1;
			} else {

				newBillId = 1001;
			}

		} catch (Exception e) {
			System.out.println("BillingApp: getNextBillId :" + e);
		}

		return newBillId;

	}

	public static int getNextBillIingDetailsId() {

		int newBillDetailsId = 0;

		try {

			if (htBillDetails != null && htBillDetails.size() > 0) {
				newBillDetailsId = htBillDetails.get(htBillDetails.size()).getBillDetailsId() + 1;
			} else {

				newBillDetailsId = 1;
			}

		} catch (Exception e) {
			System.out.println("BillingApp: getNextBillingDetailsId:" + e);
		}

		return newBillDetailsId;

	}

	public static Product getProductById(int productId) {

		Product product = null;
		try {

			for (Product x : products) {
				if (x.getProductId() == productId) {
					product = x;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("BillingApp : getProductById " + e);
		}

		return product;

	}
	
	public static Customer getCustomerById(int customerId) {

		Customer customer = null;
		try {

			for (Customer x : customers) {
				if (x.getCustomerId() == customerId) {
					customer = x;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("BillingApp : getCustomerById " + e);
		}

		return customer;

	}

	public static void displayAllBillDetails() {

		try {
			if (htBillingMaster != null && htBillingMaster.size() > 0) {

				for (int i = 1; i <= htBillingMaster.size(); i++) {

					BillingMaster billingMaster = htBillingMaster.get(i + 1000);

					int billingMasterBillId = billingMaster.getBillId();
					
					displayBillDetails(billingMasterBillId);
					
				} 

			}
		} catch (Exception e) {
			System.out.println("BillingApp : displayAllBillDetails " + e);
		}
	}

}
