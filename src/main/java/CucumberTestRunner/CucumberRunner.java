package CucumberTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"C:\\Users\\dziekonskit\\IdeaProjects\\HRProject\\src\\main\\java\\Features\\features.feature"}, glue ="CucumberStepDefinition", plugin={"pretty","html:format"})
public class CucumberRunner extends AbstractTestNGCucumberTests {


}
