package pages;

import org.openqa.selenium.WebDriver;

public class NewsPage {
    private WebDriver driver = null;
    public NewsPage(WebDriver driver){
        this.driver=driver;
    }
    public void open(){//открытие странички
         driver.get(System.getProperty("url"));
    }


}
