package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ComplicatedPage extends BasicPage{
    public By complicatedHeader = By.id("Section_of_Buttons");

    public ComplicatedPage() {
        waitPageToLoad();
    }

    public String getComplicatedText() {
        return $(complicatedHeader).getText();
    }

    public void waitPageToLoad() {
        $(complicatedHeader).waitUntil(Condition.visible, Configuration.timeout);
    }

}
