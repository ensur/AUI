package button;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.PetsNewsPage;

import java.util.List;

public class PetsNewsButtonMore {
    private WebDriver driver = null;
    public PetsNewsButtonMore(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(css = ".js-pgng_more_link")
    private WebElement button;

    public WebElement getButtonElement(){
        return button;
    }

    public PetsNewsPage click(){
        button.click();
        return PageFactory.initElements(driver, PetsNewsPage.class);
    }
}
