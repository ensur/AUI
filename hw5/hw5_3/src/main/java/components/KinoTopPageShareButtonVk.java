package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KinoTopPageShareButtonVk {
    WebDriver driver = null;
    public KinoTopPageShareButtonVk(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(css = "div.share__button > i.icon_social_vk")
    List<WebElement> shareVkButtons;

    public WebElement getShareVkButtonFirst(){
        return shareVkButtons.get(0);
    }
}
