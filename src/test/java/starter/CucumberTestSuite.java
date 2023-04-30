package starter;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@io.cucumber.junit.CucumberOptions(plugin = { "pretty" }, features = "src/test/resources/features")
/**
 * Unit test for simple App.
 */
public class CucumberTestSuite {
}