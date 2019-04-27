package newTestNGPackage;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * Here the DAtaProvider will provide Object array on the basis on ITestContext, to process @Test as group.
 * @param c
 * @return
 */
public class DataproviderWithITestContextAsParameterClass {
	 @DataProvider(name="SearchProviderExternalAsITestContext")
	public static Object[][] getDataFromDataprovider(ITestContext c){
	 
	Object[][] groupArray = null;
	for (String group : c.getIncludedGroups()) {
		System.out.println("Group to Process is: "+group);
	    if(group.equalsIgnoreCase("A")){
	       groupArray = new Object[][] { 
				{ "Guru99", "India" }, 
				{ "Krishna", "UK" }, 
				{ "Bhupesh", "USA" } 
		   };
	       break;	    
	    }
		else if(group.equalsIgnoreCase("B"))  {
		   groupArray = new Object[][] { 
					{  "Canada" }, 
					{  "Russia" }, 
					{  "Cuba" }, 
					{  "Japan" } 
		   };
		   break;
		 }   
   }
   return groupArray;		
   }
}


