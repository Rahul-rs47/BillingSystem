/**
 * This class is used to handle CRUD operation on the Product hash table
 * create -- addProduct
 * read -- getProduct getAllProducts getCustomerIdlhm getValidCustomerId
 * update -- updateProduct
 * generate -- next billId -- getNextBillIingDetailsId
 * 
 */

package cs.bs.handler;

import java.util.Hashtable;

import cs.bs.data.DataFactory;
import cs.bs.dto.Product;

public class ProductHandler {

	public static boolean addProduct(Product product) {
		boolean result = false;

		try {

			DataFactory.htProducts.put(product.getProductId(), product);
			result = true;
		} catch (Exception e) {
			System.out.println("ProductHandler : addProduct : - " + e);
		}

		return result;
	}

	public static boolean updateProduct(Product product) {

		boolean result = false;

		try {

			DataFactory.htProducts.remove(product.getProductId());
			DataFactory.htProducts.put(product.getProductId(), product);
			result = true;
		} catch (Exception e) {
			System.out.println("ProductHandler : updateProduct : - " + e);
		}

		return result;
	}

	public static Product getProduct(int productId) {

		Product product = null;
		try {

			if (DataFactory.htProducts != null && DataFactory.htProducts.size() > 0) {

				product = DataFactory.htProducts.get(productId);
			}

		} catch (Exception e) {
			System.out.println("ProductHandler : getProduct : - " + e);
		}

		return product;
	}

	public static Hashtable<Integer, Product> getAllProducts() {
		Hashtable<Integer, Product> htProducts = null;

		try {

			htProducts = DataFactory.htProducts;

		} catch (Exception e) {
			System.out.println("ProductHandler : getAllProducts : - " + e);
		}
		return htProducts;
	}
	
	public static int getProductId() {

		int newProductId = 0;

		try {

			if (DataFactory.htProducts != null && DataFactory.htProducts.size() > 0) {
				newProductId = DataFactory.htProducts.get(DataFactory.htProducts.size() + 2000).getProductId() + 1;
			} else {

				newProductId = 2001;
			}

		} catch (Exception e) {
			System.out.println("ProductHandler: getProductId:" + e);
		}

		return newProductId;

	}

}
