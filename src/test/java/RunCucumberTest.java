import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/features/Scenario.feature"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"}
        , glue = {"steps","util"})
public class RunCucumberTest {

}