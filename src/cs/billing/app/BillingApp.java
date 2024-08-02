/**
 *  This Program is to generate the main menu of the Billing Application
 *  
 * 
 * 
 */


package cs.billing.app;

import java.time.LocalDate;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

import cs.bs.data.DataFactory;
import cs.bs.dto.BillDetails;
import cs.bs.dto.BillingMaster;
import cs.bs.dto.Customer;
import cs.bs.dto.Product;
import cs.bs.handler.BillDetailsHandler;
import cs.bs.handler.BillingMasterHandler;
import cs.bs.handler.CustomerHandler;
import cs.bs.handler.ProductHandler;
import cs.bs.util.Helper;

@SuppressWarnings("unchecked")
public class BillingApp {

	static {

		try {

			boolean result = DataFactory.syncData();

			if (result) {
				System.out.println("Welcome to Billing System ! ... \n");
			} else {

				System.out.println("Not able access the data file ! ... \n");
				System.exit(0);

			}

		} catch (Exception e) {
			System.out.println("error : Library : static block : " + e);
		}

	}

	public static void main(String args[]) {

		int option = 0;
		while (option != 9) {

			System.out.println("Main Menu");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("1 .Bill ");
			System.out.println("2. Product ");
			System.out.println("3. Customer \n");
			System.out.println("9. Exit ");	
			System.out.println("~~~~~~~~~~~~~~~~~~~~~\n");

			System.out.println("Please enter the option");
			option = Helper.getI();

			switch (option) {

			case 1:

				int billOption = 0;
				while (billOption != 9) {
					System.out.println("Bill Options");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("1. Generate Bill ");
					System.out.println("2. Display All Bill Details");
					System.out.println("3. Search Bill \n");
					System.out.println("9. Back to Main menu \n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Please Enter the option");
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

						/* search bill by bill Id */

						System.out.println("Enter  the Bill Id");
						int billId = Helper.getI();

						boolean output = displayBillDetails(billId);

						if (!output) {
							System.out.println("There is no bill with this bill Id : " + billId);
						}

						break;
						
					case 9:
						
						break;
						
					default:
						System.out.println("Wrong Option, Please choose a right option !");

					}

				}

				break;

			case 2:
				int productOption = 0;
				while (productOption != 9) {
					System.out.println("Product Options");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("1. View all Product ");
					System.out.println("2. Search Product");
					System.out.println("3. Add product");
					System.out.println("4. Edit product \n");
					System.out.println("9. Back to Main menu \n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~ \n");
					
					System.out.println("Please enter the option");
					productOption = Helper.getI();

					switch (productOption) {

					case 1:

						// display all Products

						displayAllProducts();

						break;
					case 2:

						// Search Product By productId

						System.out.println("Enter the product id you wish to search : - ");
						int productId = Helper.getI();
						Product product = ProductHandler.getProduct(productId);

						if (product == null) {
							System.out.println("No Product details avaialble for this Product ID.");

						} else {
							System.out.println(product);
						}

						break;

					case 3:

						/* Add product */
						System.out.println(" Add product");
						
						productId = ProductHandler.getProductId();

						System.out.println("Enter the product Name ");
						String productName = Helper.getS();

						System.out.println("Enter the product price");
						double productPrice = Helper.getD();

						Product productObj = new Product(productId, productName, productPrice);
						boolean result = false;
						result = ProductHandler.addProduct(productObj);
						

						if (result != false) {
						    DataFactory.writeData();
							System.out.println("Product Added sucessfully");

						} else {
							System.out.println("Product not added ");
						}

						break;

					case 4:

						/* Edit product */

						System.out.println(" Edit product");
						System.out.println("Enter the productId to Edit");
						int productIdEdit = Helper.getI();
						Product productExist = ProductHandler.getProduct(productIdEdit);
						if (productExist != null) {

							System.out.println(productExist);

							System.out.println("Enter the new product Name ");
							String productNameNew = Helper.getS();

							System.out.println("Enter the new product price");
							double productPriceNew = Helper.getD();

							Product productNew = new Product(productIdEdit, productNameNew, productPriceNew);

							result = ProductHandler.updateProduct(productNew);

							if (result) {
								 DataFactory.writeData();
								System.out.println("Product details update succesffully");
							} else {
								System.out.println("Product details not updated");
							}

						} else {
							System.out.println("There is no product availble with this product id ");
						}

						break;

					}
				}
				break;

			case 3:
				int customerOption = 0;
				while (customerOption != 9) {

					System.out.println("Customer Options");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~ \n");
					System.out.println("1. View all Customer ");
					System.out.println("2. Search Customer");
					System.out.println("3. Add Customer");
					System.out.println("4. Edit Customer");
					System.out.println("5. Search Bill by Customer id \n");
					System.out.println("9. Back to Main menu \n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~ \n");
					System.out.println("Please enter the option");
					customerOption = Helper.getI();

					switch (customerOption) {

					case 1:

						/* View all Customer */
						System.out.println(" View all Customer");
						System.out.println("``````````````````````````");

						displayAllCustomers();

						break;

					case 2:

						/* Search Customer */
						System.out.println(" Search Customer");

						//

						System.out.println("Enter the Customer id you wish to search : - ");
						int customerId = Helper.getI();
						Customer customer = CustomerHandler.getCustomer(customerId);
						
						

						if (customer == null) {
							System.out.println("No Customer details avaialble for this customer ID.");

						} else {
							System.out.println(customer);
						}

						break;

					case 3:

						/* Add Customer */
						System.out.println(" Add Customer");

					
						
						int newCustomerId = CustomerHandler.getCustomerIdlhm();
						System.out.println("Enter the customer Name ");
						String customerName = Helper.getS();

						System.out.println("Enter the customer Mobile Number");
						String customerMobileNumber = Integer.toString(Helper.getI());

						System.out.println("Enter the customer Place");
						String customerPlace = Helper.getS();

						Customer customerObj = new Customer(newCustomerId, customerName, customerMobileNumber,
								customerPlace);
						boolean result = false;
						result = CustomerHandler.addCustomer(customerObj);

						if (result != false) {
							 DataFactory.writeData();
							System.out.println("Customer Added sucessfully");

						} else {
							System.out.println("customer not added ");
						}

						break;

					case 4:

						/* Edit Customer */
						System.out.println(" Edit Customer");

						System.out.println("Enter the customerId to Edit");
						//int customerIdEdit = Helper.getI();
						
						Customer customerExist = CustomerHandler.getValidCustomerId();
						
						int customerIdEdit = customerExist.getCustomerId();
						
						
						//Customer customerExist = CustomerHandler.getCustomer(customerIdEdit);
						System.out.println(customerExist);

						System.out.println("Enter the customer Name ");
						String customerNamenew = Helper.getS();

						System.out.println("Enter the customer Mobile Number");
						String customerMobileNumbernew = Integer.toString(Helper.getI());

						System.out.println("Enter the customer Place");
						String customerPlacenew = Helper.getS();

						Customer customerObjnew = new Customer(customerIdEdit, customerNamenew, customerMobileNumbernew,
								customerPlacenew);
						boolean flag = false;

						flag = CustomerHandler.updateCustomer(customerObjnew);

						if (flag) {
							 DataFactory.writeData();
							System.out.println("Customer with customerId " + "updated succesfully");
						} else {
							System.out.println("Customer not updated");
						}

						break;

					case 5:

						searchBillByCustomer();

						break;
						
					case 9:
						//boolean result1 = DataFactory.writeData();

						//System.out.println("Thanks for using billing system");
						//System.exit(0);*/
						break;
						
					 default:
						
						System.out.println(" Wrong Option, Please choose a right option  ");
						break;

					}
				}
				break;

			case 9:
				boolean result = DataFactory.writeData();

				System.out.println("Thanks for using billing system");
				System.exit(0); 
				
			 default:
				
				System.out.println(" Wrong Option, Please choose a right option  ");
				break;
				

			}

		}

	}

	/**
	 * 
	 */
	public static void searchBillByCustomer() {
		/* Search Bill by customer Id */
		System.out.println(" Search Bill by Customer id");

		System.out.println("Enter the Customer Id");
		
		Customer customer = CustomerHandler.getValidCustomerId();
		
		int searchCustomerId = customer.getCustomerId();
		
	//	int searchCustomerId = Helper.getI();

		Hashtable<Integer, BillingMaster> htBillingMaster = null;
		htBillingMaster = BillingMasterHandler.getBillingMasterByCustomerId(searchCustomerId);
		//System.out.println("htBillingMaster.size() : " + htBillingMaster.size());
		if (htBillingMaster != null && htBillingMaster.size() > 0) {
			
			System.out.println("     Customer Bill Details    ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			System.out.println("Customer Id  : " + searchCustomerId + "                            " + "Customer Name  : " + CustomerHandler.getCustomer(searchCustomerId).getCustomerName());
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Enumeration<Integer> eBillingMasterKey = htBillingMaster.keys();

			while (eBillingMasterKey.hasMoreElements()) {

				int billMasterBillId = eBillingMasterKey.nextElement();
				
				//System.out.println("billMasterBillId : " + billMasterBillId);

				BillingMaster billingMaster = htBillingMaster.get(billMasterBillId);
				
				//System.out.println("billingMaster : " + billingMaster);
				
				System.out.print("Bill Id :  " + billingMaster.getBillId() + "     ");
				System.out.print("Bill Date :  " + billingMaster.getBillDate() + "     ");
				System.out.println("Bill Amount :  " + billingMaster.getTotalAmount());
				
				

			}

		} else {

			System.out.println("There is no bill available for this customer");
		}
	}

	/**
	 * 
	 */
	public static void displayAllProducts() {
		Hashtable<Integer, Product> htProdcts = null;

		htProdcts = ProductHandler.getAllProducts();

		if (htProdcts != null && htProdcts.size() > 0) {

			System.out.println("		Product DETAILS 		");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			// Creating Enumeration interface and get keys() from Hashtable
			Enumeration<Integer> eProductsKey = htProdcts.keys();

			// Checking for next element in Hashtable object with the help of
			// hasMoreElements() method
			while (eProductsKey.hasMoreElements()) {

				// Getting the key of a particular entry
				int productKey = eProductsKey.nextElement(); // productId

				System.out.println(htProdcts.get(productKey));
				System.out.println("\n");

			}

		} else {
			System.out.println("There is no products.");
		}
	}

	public static void displayAllCustomers() {

	//	Hashtable<Integer, Customer> htCustomers = null;

	//	LinkedHashMap<Integer, Customer> lhmCustomers = CustomerHandler.getAllCustomerslhm();
		LinkedHashMap<Integer, Customer> lhmCustomers = CustomerHandler.getAllCustomerslhm(); // lhm method

		//if (htCustomers != null && htCustomers.size() > 0)
		if (lhmCustomers != null && lhmCustomers.size() > 0)
		{

			System.out.println("     Customer DETAILS ");
			System.out.println("`````````````````````````````````");

			//Enumeration<Integer> eCustomersKey = htCustomers.keys();            
				
			
			Iterator<Integer> eCustomersKey = lhmCustomers.keySet().iterator();      //	lhm method

			//while (eCustomersKey.hasMoreElements()) 
			while (eCustomersKey.hasNext())
			{

			//	int CustomerKey = eCustomersKey.nextElement();
				int CustomerKey = eCustomersKey.next();
				
				System.out.println(lhmCustomers.get(CustomerKey));
				System.out.println("\n");

			}

		} else {
			System.out.println("There is no Customer");

		}
	}

	private static boolean displayBillDetails(int billId) {

		boolean result = true;

		BillingMaster billingMaster = null;
		int billingMasterBillId;

		try {

			try {
				billingMaster = BillingMasterHandler.getBillingMaster(billId);
				if (billingMaster != null) {
					billingMasterBillId = billingMaster.getBillId();
				} else {
					result = false;
					return result;
				}

			} catch (Exception e) {

				result = false;

				System.out.println("BillingApp: displayBillDetails nestedTry :" + e);
				return result;

			}

			Hashtable<Integer, BillDetails> htBillDetails = null;
			htBillDetails = BillDetailsHandler.getBillDetailbyBillId(billingMasterBillId);

			if (htBillDetails != null && htBillDetails.size() > 0) {

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("			RAHUL SUPERMARKET 						   ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

				System.out.print("Bill Id : " + billingMaster.getBillId());
				System.out.print("                          ");

				System.out.println("Bill Date : " + billingMaster.getBillDate());
				System.out.print("Customer Id : " + billingMaster.getCustomerId());
				System.out.print("                 ");
				System.out.println("Customer Name  : "
						+ CustomerHandler.getCustomer(billingMaster.getCustomerId()).getCustomerName());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

				Enumeration<Integer> eBillDetailsKey = htBillDetails.keys();

				while (eBillDetailsKey.hasMoreElements()) {

					int billDetailsId = eBillDetailsKey.nextElement();

					BillDetails billDetails = DataFactory.htBillDetails.get(billDetailsId);

					int billProductId = billDetails.getProductId();
					int qty = billDetails.getQuantity();
					double price = (ProductHandler.getProduct(billProductId)).getProductPrice();
					double subTotal = qty * price;

					System.out.println("Product Id : " + billProductId + "   " + " Qty : " + qty + " Unit Price : "
							+ price + " Amount  : " + subTotal);

				}

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.print("                                  ");
				System.out.println("Total Amount    : " + billingMaster.getTotalAmount());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			} else {

				System.out.println("There is no details available for this billId");

			}

		} catch (Exception e) {

			result = false;
			System.out.println("BillingApp: displayBillDetails :" + e);
		}

		return result;

	}

	public static void generateBill() {
		int customerId = 0, productId = 0, quantity;
		LocalDate billDate = null;
		char option;
		int billId = BillingMasterHandler.getNextBillId();
		double productPrice = 0;

		System.out.println("billId : " + billId);

		double totalAmount = 0;
		BillingMaster billingMaster = null;
		int billDetailsId = 0;

		BillDetails billDetails = null;
		boolean flag1 = true;
		try {
			billDate = Helper.getCurrentDate();
			System.out.println("Enter the Customer id");
			//customerId = Helper.getI();
			Customer customer = CustomerHandler.getValidCustomerId();
			
			customerId = customer.getCustomerId();
			System.out.println("Customer Name : "+ customer.getCustomerName());

			do {
				System.out.println("Enter  productId");
				boolean flag = true;
				Product product = null;
			//	productId = Helper.getI();
				
				while(flag) {
					
					
					productId = Helper.getI();
					 product = ProductHandler.getProduct(productId);
					
					if(product != null) {
						flag = false;
					}else {
						System.out.println("Enter the correct product Id");
					}
					
				}
				
				//Product productSearch = ProductHandler.getProduct(productId);
				
				System.out.println("productId : " + productId  + ", Product Name : " + product.getProductName() + ",  Product price : " + product.getProductPrice());
				//System.out.println("Product price " + ProductHandler.getProduct(productId).getProductPrice());
				double price = product.getProductPrice();
				System.out.println("Enter  quantity");
				quantity = Helper.getI();
				System.out.println("productId : " + productId  + ", Product Name : " + product.getProductName() + ",  Product price : " + product.getProductPrice() + ", quantity : " + quantity + ",  Total Amount = " +  price * quantity);
				productPrice = ProductHandler.getProduct(productId).getProductPrice();

				billDetailsId = BillDetailsHandler.getNextBillIingDetailsId();

				billDetails = new BillDetails(billDetailsId, billId, productId, quantity);

				BillDetailsHandler.addBillDetails(billDetails);

				totalAmount += (productPrice * quantity);

				System.out.println("Do you want to enter more Products Y/N ");
				option = Helper.getC();

			} while (option == 'y' || option == 'Y');

			billingMaster = new BillingMaster(billId, customerId, billDate, totalAmount);

			BillingMasterHandler.addBillingMaster(billingMaster);
			
			boolean result = DataFactory.writeData();
			
			displayBillDetails(billId);

		} catch (Exception e) {
			System.out.println("BillingApp: generateBill :" + e);
		}
	}

	public static void displayAllBillDetails() {

		Hashtable<Integer, BillingMaster> htBillingMaster = null;
		try {
			htBillingMaster = BillingMasterHandler.getAllBillingMaster();

			if (htBillingMaster != null && htBillingMaster.size() > 0) {

				Enumeration<Integer> eBillingMasterKey = htBillingMaster.keys();

				while (eBillingMasterKey.hasMoreElements()) {

					int billMasterId = eBillingMasterKey.nextElement();

					BillingMaster billingMaster = htBillingMaster.get(billMasterId);

					int billId = billingMaster.getBillId();

					displayBillDetails(billId);

				}

			}
		} catch (Exception e) {
			System.out.println("BillingApp : displayAllBillDetails " + e);
		}
	}

}
