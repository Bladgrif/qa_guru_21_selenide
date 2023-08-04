package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
    }

    @Test
    void enterprisePageOpensFromSolutions() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".enterprise-hero .h1-mktg").shouldHave(text("Build like the best"));
//        sleep(3000);
    }
}
