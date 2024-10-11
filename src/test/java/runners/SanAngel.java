package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@io.cucumber.junit.CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class SanAngel {
}
