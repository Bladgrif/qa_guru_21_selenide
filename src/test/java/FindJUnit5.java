import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5 {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    String codeJunit5 = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n";

    @Test
    void FindJUnit5() {
        open("https://github.com/selenide/selenide");
//        open("https://alfabank.ru/");
        $("#wiki-tab").click();
//        $("#wiki-body").$(byText("Soft assertions")).shouldHave(attribute("href", "https://github.com/selenide/selenide/wiki/SoftAssertions")).click();
//        $("#wiki-body").$(byText("Soft assertions")).shouldHave(text("Soft assertions")).click();
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0).shouldHave(text(codeJunit5));

//        sleep(5000);


    }
}
