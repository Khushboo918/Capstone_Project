package MyRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/java/feature/Add2cart.feature",
	    glue = "Stepdef",
	    plugin = {"pretty",
	    		"html:Reports/cucumberReport.html",
				"json:Reports/cucumberReport.json",
				"junit:Reports/cucmberReport.xml"
	    }
	    
	)
public class Add2cart_testrunner {

}