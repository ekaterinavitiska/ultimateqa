package pages;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class IntercationPage extends BasicPage{

    public By button = By.name("button1");
    public By buttonHeader = By.className("entry-title");
    public By newHeader = By.xpath("//div[@class ='et_pb_text_inner']");
    public By textField = By.name("et_pb_contact_name_0");
    public By radioButton = By.cssSelector("input[value='male']");
    public By checkBox = By.cssSelector("input[value='Bike']");
    public By DDV = By.cssSelector("select[]");

 public void buttonClick(){
     $(button).click();
 }

    public void radioClick(){
        $(radioButton).click();
    }

    public void CBClick(){
        $(checkBox).click();
    }

    public void DDselect(){
        $(checkBox).click();
    }
    public void typeText(String value){
        $(textField).sendKeys(value);
    }
    public boolean radioSelected(){
        return $(radioButton).isSelected();
    }
    public String getNewHeaderText() {
        return $(newHeader).getText();
    }
    public String getButtonText() {
        return $(buttonHeader).getText();
    }


    public void selectDDbyValue(String ddvalue ) {
        Select dropdown = new Select($(DDV));
        dropdown.selectByValue(ddvalue);
    }
}
