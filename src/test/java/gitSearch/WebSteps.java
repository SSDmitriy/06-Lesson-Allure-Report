package gitSearch;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("01-Open github.")
    public void openGitHub(String url) {
        open("https://github.com");
    }

    @Step("02-Find repository {repository}.")
    public void findRepository(String repository) {
        $(".header-search-input").setValue(repository).pressEnter();
    }

    @Step("03-Go to repo {repository}.")
    public void goToRepo(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("04-Open \"Issue\" tab.")
    public void openIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("05-Check, that #{number} does exist.")
    public void chekThatNumberExist(int number) {
        $(withText("#" + number)).should(exist);
    }

    @Step("06-Check, title {name}.")
    public void chekTitleName(String name) {
        $("#issue_68_link").shouldHave(text(name));
    }
}
