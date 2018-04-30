import Component.PetsNewsTile;
import button.PetsNewsButtonMore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PetsNewsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class PetsNews_Test {
    private WebDriver driver;

    @Before
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "c:/driver/chromedriver.exe");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void checkButtonMore(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        PetsNewsPage page = PageFactory.initElements(driver, PetsNewsPage.class);
        PetsNewsButtonMore button = PageFactory.initElements(driver, PetsNewsButtonMore.class);
        PetsNewsTile tile = PageFactory.initElements(driver, PetsNewsTile.class);
        page.open();
        Integer tileBeforeClick = tile.tileQt();
        button.click();
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(tile.getTileLocator()),13));
        Integer tileAfterClick = tile.tileQt();
        assertTrue("Элемент функционирует неверно", tileAfterClick>tileBeforeClick);
        }
}
