import components.KinoMainPageNewsTopTile;
import components.KinoTopPageSeeMoreComponent;
import components.KinoTopPageShareButtonVk;
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
import pages.KinoMainPage;
import pages.KinoTopNewsPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class KinoNews_Test {
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
    public void kinoTopNews_Test(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 10000);
        KinoMainPage mainPage = PageFactory.initElements(driver, KinoMainPage.class);
        mainPage.open();//открыли страницу

        KinoMainPageNewsTopTile topTile = PageFactory.initElements(driver, KinoMainPageNewsTopTile.class);
        String topTileCap = topTile.getTileCap();
        KinoTopNewsPage newsPage = topTile.topTileClick();//открыли страницу

        assertTrue("Заголовок не соответствует нужному", newsPage.getPageTag().contains(topTileCap));//проверили заголовок
        KinoTopPageSeeMoreComponent seeMore = PageFactory.initElements(driver, KinoTopPageSeeMoreComponent.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-counter-id='25735907']//div[@class='control control_next control_absolute js-slider__next']")));
        assertTrue("Слайдер работает некорректно", seeMore.checkNew(seeMore.getButtonNext()));//пару раз вперед и назад

        assertTrue("Слайдер работает некорректно", seeMore.checkNew(seeMore.getButtonNext()));
        assertTrue("Слайдер работает некорректно", seeMore.checkNew(seeMore.getButtonPrev()));


    }
}
