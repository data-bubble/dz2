package features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepdefs",
        tags = "@SignIn,@Debug"
)
public class MyDebugTest {      //простой сценарий для ловли своих ошибок(не учавствует в тестировании)
}
