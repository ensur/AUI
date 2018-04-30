package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KinoTopNewsPage {
    private WebDriver driver = null;
    public KinoTopNewsPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(css = "class,h1")
    WebElement tag;
    public String getPageTag(){
        return tag.getText();
    }
}
