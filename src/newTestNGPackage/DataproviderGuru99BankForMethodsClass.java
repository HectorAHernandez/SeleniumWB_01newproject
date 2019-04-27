package newTestNGPackage;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

/**
 * Here DataProvider returning value on the basis of test method name
 * @param m
 * @return
 **/

public class DataproviderGuru99BankForMethodsClass {
 @DataProvider(name="BankDataProviderExternalForMethod")
 public static Object[][] getDataFromDataprovider(Method method){
 
    if(method.getName().equalsIgnoreCase("test10_Create_New_Customer")){
    return new Object[][] {
          {"Janice Smith", "Female", "01/25/1970", "4534 Sun Drive", "Sarasota", "Florida" 
           ,"123456", "7272547894", "roseGon3@gmail.com", "password01"},    
          {"Peter Alfred", "Male", "03/25/1965", "1234 Sun Set", "Orlando", "Florida" 
           ,"123456", "7272547811", "PeterAf3@gmail.com", "password02"},
          {"Dawn Guzman", "Female", "07/12/1975", "1234 Sun Set", "Orlando", "Florida" 
           ,"123456", "7132547814", "DawnG3@gmail.com", "password03"}               
        };}
    else if(method.getName().equalsIgnoreCase("test20_Edit_Customer")){
        return new Object[][] {
            {"Queens", "New York", "112245", "2124547894"},    
            {"Barcelona", "California", "551547", "7512545874"},
            {"Houston", "Texas", "856004", "6161248555"}          
          };}
    else if(method.getName().equalsIgnoreCase("test30_New_Account")){
        return new Object[][] {
            {"Current","155004510"},    
            {"Savings","431000111"},          
            {"Current","665004510"},    
            {"Savings","881000111"}          
          };}
//    else if(method.getName().equalsIgnoreCase("test40_Edit_Account")){
//        return new Object[][] {
//            {"Savings"},
//            {"Current"},
//            {"Savingt"}          
//          };}
    else if(method.getName().equalsIgnoreCase("test50_Make_Deposit")){
        return new Object[][] {
            {"53250","Deposit ch"},
            {"4250","Deposit hg"},
            {"8565","Deposit rr"}          
          };}
    else{
        return null;
        }         
 }
}

