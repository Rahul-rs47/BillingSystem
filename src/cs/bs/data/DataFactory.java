package cs.bs.data;

import java.util.Hashtable;
import cs.bs.dto.Customer;
import cs.bs.dto.Product;

public class DataFactory {

	public static Hashtable<String, Object> billData;

	public static Customer customerData[] = { 
			new Customer(101, "Raj", "8011", "trivandrum"),
			new Customer(102, "Ram", "8012", "delhi"),
			new Customer(103, "Roni", "8013", "goa"),
			new Customer(104, "Rooney", "8014", "mumbai")

	};

	public static Product productData[] = {
			new Product(11, "milk", 40.0), 
			new Product(12, "sugar", 30.0),
			new Product(13, "Rice", 60.0),
			new Product(14, "wheat", 35.0)

	};

}
