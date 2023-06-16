package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
       plugin = {
               "pretty",
               "html:target/default-cucumber-reports.html",
               "json:target/json-reports/cucumber.json",
               "junit:target/xml-reports/cucumber.xml",
               "rerun:target/failedRerun.txt"
       },
        features = "./src/test/resources",
        glue = {"dbStepdef"},
        tags = "@Db",
        dryRun = true
)

public class Runner {
}
