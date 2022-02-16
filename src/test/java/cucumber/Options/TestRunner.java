package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features"
        , glue = "steps"
        ,publish = true
        //,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        //, tags = ("@DeletePlace")
)
public class TestRunner {
}
