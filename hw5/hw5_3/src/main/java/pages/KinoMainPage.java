package pages;

import org.openqa.selenium.WebDriver;

public class KinoMainPage {
    private WebDriver driver = null;
    public KinoMainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(System.getProperty("url"));
    }

}
