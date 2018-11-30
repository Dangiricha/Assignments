
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*
 * Assignment no: 7 
 * Print values from property file using for loop
 */

public class ReadProp {
	
	public	 static Properties prop;
	
	public static void  main (String args[]) throws IOException{
prop = new Properties();
//prop.setProperty("Name", "Tom");
//prop.setProperty("Mobile", "1234567");
//prop.setProperty("Address", "Westley Street");

		
		File src = new File("./config.properties");
		FileInputStream fis = new  FileInputStream("/Users/Riaan/Documents/workspaces/Assignment/src/config.properties");
		
		prop.load(fis);	
		HashMap<String, String> propMap = new HashMap<String, String>((Map) prop);
		Set<Map.Entry<String, String>> propSet;
	    propSet = propMap.entrySet();

	    System.out.println("Contents of properties file: ");
	    for (Map.Entry<String, String> e : propSet) {
	      System.out.print(e.getKey() + ": ");
	      System.out.println(e.getValue());
	    }
	  }
	
		
	

}
