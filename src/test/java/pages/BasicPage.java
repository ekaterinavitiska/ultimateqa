package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasicPage {
    public By header = By.xpath("//h1[@class= 'et_pb_module_header']");
    public By bigPage = By.xpath("//*[contains(@href,'../complicated-page')]");
    public By fakeLanding = By.xpath("//*[contains(@href,'../fake-landing-page')]");
    public By fakePricing = By.xpath("//*[contains(@href,'../fake-pricing-page')]");
    public By fillForms = By.xpath("//*[contains(@href,'../filling-out-forms')]");
    public By login = By.xpath("//*[contains(@href,'../sign_in')]");
    public By interactions = By.xpath("//*[contains(@href,'../simple-html-elements-for-automation')]");
    public By headersButton = By.id("adroll_allow_all");

    Condition clickable = and("can be clicked", visible, enabled);
    public String getHeaderText() {
        return $(header).getText();
    }

    public ComplicatedPage openComplicatedPage() {
        $(bigPage).waitUntil(clickable, Configuration.timeout).click();
        return page(ComplicatedPage.class);
    }

    public IntercationPage openInteractionsPage() {
        $(interactions).waitUntil(clickable, Configuration.timeout).click();
        return page(IntercationPage.class);
    }

    public void clickAcceptCookies() {
        if ($(headersButton).is(Condition.visible))
            $(headersButton).click();
    }

}
