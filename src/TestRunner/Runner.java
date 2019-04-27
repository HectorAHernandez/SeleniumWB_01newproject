package TestRunner;
/* run the cucumber test by using the following annotations:
@RunWith() annotation tells about the test runner class to start executing our 
tests.
@CucmberOptions() annotation is used to set some properties for our cucumber 
test like feature file, step definition, etc.*/

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;	


@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"StepDefinition"})

public class Runner {
	
	
}
