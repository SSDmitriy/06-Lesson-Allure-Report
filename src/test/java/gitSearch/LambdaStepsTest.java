package gitSearch;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    private final String URL = "https://github.com";
    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final int ISSUE_NUMBER = 68;
    private final String TITLE_NAME = "Listeners NamedBy";


    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testIssueSearch() {

//        teamplate for Lambda step
//        step("", () -> {
//
//        });

        step("01-Open github.", (s) -> {
            s.parameter("url: ", URL);
            open(URL);
        });

        step("02-Find repository.", (s) -> {
            s.parameter("Repo name: ", REPOSITORY);
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });

        step("03-Go to repo.", (s) -> {
            s.parameter("Repo name: ", REPOSITORY);
            $(By.linkText(REPOSITORY)).click();
        });

        step("04-Open \"Issue\" tab.", () -> {
            $(withText("Issues")).click();
        });

        step("05-Check, that #" + ISSUE_NUMBER + " does exist.", (s) -> {
            s.parameter("iss_number: ", ISSUE_NUMBER);
            $(withText("#68")).should(exist);
        });

        step("06-Check title for issue", (s) -> {
            s.parameter("title name: ", TITLE_NAME);
            $("#issue_68_link").shouldHave(text(TITLE_NAME));
        });
    }
}
