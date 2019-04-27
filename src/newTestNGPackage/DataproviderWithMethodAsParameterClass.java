package newTestNGPackage;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

/**
 * Here DataProvider returning value on the basis of test method name
 * @param m
 * @return
 **/

public class DataproviderWithMethodAsParameterClass {
 @DataProvider(name="SearchProviderExternalAsMethod")
public static Object[][] getDataFromDataprovider(Method m){
    if(m.getName().equalsIgnoreCase("testMethodA")){
    return new Object[][] {
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };}
    else{
    return new Object[][] {
            { "Canada" },
            { "Russia" },
            { "Japan" }
        };}       
 }
}

