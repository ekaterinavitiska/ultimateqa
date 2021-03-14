package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;
import pages.*;

import static com.codeborne.selenide.Selenide.open;

public class BasicTests {
    public final String mainHeader =  "Automation Practice";
    public final String complicatedHeader =  "Section of Buttons";
    public final String buttonHeader =  "Button success";
    public final String interactionHeader =  "This section has really simple HTML elements so that you can understand their basic nature. Feel free to practice your test automation on these elements.\n" +
            "  Click Me!\n" +
            "Raise";
    BasicPage basicPage = new BasicPage();

    @Before
    public void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.timeout = 1000;
        open("https://ultimateqa.com/automation");
        basicPage.clickAcceptCookies();

    }

    @After
    public void afterAll() {
        WebDriverRunner.closeWebDriver();
    }

    @Ignore
    public void simpleTest() {
        Assert.assertEquals(basicPage.getHeaderText(), mainHeader);
        ComplicatedPage complicatedPage = basicPage.openComplicatedPage();
        Assert.assertEquals(complicatedPage.getComplicatedText(), complicatedHeader);

    }

    @Ignore
    public void InteractionTest() {

        IntercationPage intercationPage = basicPage.openInteractionsPage();
        Assert.assertEquals(intercationPage.getNewHeaderText(), interactionHeader);
        intercationPage.buttonClick();
        Assert.assertEquals(intercationPage.getButtonText(), buttonHeader);
    }

    @Test
    public void InteractionRadioTest() {

        IntercationPage intercationPage = basicPage.openInteractionsPage();
        Assert.assertEquals(intercationPage.getNewHeaderText(), interactionHeader);
        intercationPage.radioClick();
        Assert.assertTrue(intercationPage.radioSelected());
        intercationPage.typeText("Ekaterina");
        intercationPage.CBClick();
        intercationPage.DDselect();
    }
}
