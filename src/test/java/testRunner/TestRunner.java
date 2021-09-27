package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="C:\\Users\\azeem.hameed\\IdeaProjects\\AutomationKTCucumber\\src\\test\\java\\features\\LoginFeature.feature",
        glue="stepDefination",
        plugin= {"pretty","html:./rep"}
        
        )

public class TestRunner {
    

}
