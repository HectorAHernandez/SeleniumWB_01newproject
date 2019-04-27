package firsttestngpackage;

	import org.testng.annotations.*;
	import org.testng.Assert;
    import org.testng.SkipException;
	
	public class TestNGAnnotationParameter {

// Below three test will be executed in alphabetical order not topdown.
		
 // Below test will be executed in alphabetical order:	  
	  @Test
	  public void c_test() {
		  Assert.fail(); 
	  }  
	  
	  @Test
	  public void a_test() {
		  Assert.assertTrue(true);
	  }
	  
	  @Test
	  public void b_test() {
		  throw new SkipException("Hector: Skipping b_test");
		//  Assert.assertTrue(true);
	  }

	  //If you want the methods to be executed in a different order, use the parameter "priority". Parameters
	  // are keywords that modify the annotation's function.
	  //TestNG will execute the @Test annotation with the lowest priority value up to the largest. There is no need
	  //for your priority values to be consecutive

	  @Test (priority = 3)      // the 2nd least priority, so will be executed second.
	  public void c1_test() {
		  Assert.fail(); 
	  }  
	  
	  @Test (priority = 0)     //this is the lowest priority, so it will be executed first.
	  public void a1_test() {
		  Assert.assertTrue(true);
	  }
	  
	  @Test (priority = 7)    //largest priotiry, so will execute last.
	  public void b1_test() {
		  throw new SkipException("Hector: Skipping b_test");
	  }
	  
	  
	}
