/**
 * This class offers functionality for reading from and writing to hash table data files
 * 
 * read   -- readData
 * write  -- writeData
 * 
 */

package cs.bs.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

public class FileHelper {
	
	private static String dataFile;
	

	static{
		dataFile = "Billing.data";
		
	}
	public static Hashtable readData(){

		 FileInputStream inputFIS = null;
		 ObjectInputStream outputOIS = null;

		 Hashtable htBilling = null;
		 try {
		 	 inputFIS = new FileInputStream(dataFile);
			 outputOIS = new ObjectInputStream(inputFIS);

			 htBilling = (Hashtable) outputOIS.readObject();
			 inputFIS.close();
			 outputOIS.close();

			}
			catch(Exception e) {
				//e.printStackTrace();
				//System.out.println("IMSHelper.readData()");
				//System.out.println("FileHelper:readData : " + e);
			}

		 return htBilling;
	}
	
	public static boolean writeData(Hashtable htBilling){

		FileOutputStream outputFOS = null;
		ObjectOutputStream outputOOS = null;
		boolean result = false;

		try{
			outputFOS = new FileOutputStream(dataFile);
			outputOOS = new ObjectOutputStream(outputFOS);
			outputOOS.writeObject(htBilling);
			
			outputFOS.close();
			outputOOS.close();
			result = true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			//result = true;
			System.out.println("FileHelper: writeData" + e);
		}

		return result;
	}

}
