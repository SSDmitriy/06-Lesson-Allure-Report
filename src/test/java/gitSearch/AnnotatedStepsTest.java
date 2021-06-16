package gitSearch;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private WebSteps steps = new WebSteps();

    @Test
    public void testIssueSearch() {
        steps.openGitHub("https://github.com");
        steps.findRepository("eroshenkoam/allure-example");
        steps.goToRepo("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.chekThatNumberExist(68);
        steps.chekTitleName("Listeners NamedBy");
    }
}
