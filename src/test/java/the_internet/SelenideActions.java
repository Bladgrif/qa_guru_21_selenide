package the_internet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActions {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
    }

    @Test
    void enterprisePageOpensFromSolutions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement box_A = $("#column-a");
        SelenideElement box_B = $("#column-b");
        box_A.dragAndDropTo(box_B);
        box_A.shouldHave(text("B"));
        box_B.shouldHave(text("A"));
        sleep(3000);
    }
}
