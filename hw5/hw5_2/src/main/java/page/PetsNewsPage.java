package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

public class PetsNewsPage {
    WebDriver driver = null;
    public PetsNewsPage(WebDriver driver){
        this.driver = driver;
    }
    private String url = System.getProperty("url") + "/";
    private Pattern pattern = Pattern.compile(System.getProperty("url") + "/");

    public PetsNewsPage open(){
        driver.get(url);
        return this;
    }


}
