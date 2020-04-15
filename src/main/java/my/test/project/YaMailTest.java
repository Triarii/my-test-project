package my.test.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/my/test/project/features",
        glue = {"src/main/java/my/test/project/features/steps"},
        tags = {"@ya-mail"},
        strict = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class YaMailTest {

}
