import components.NewsPageInstaComponent;
import data.InstaFormData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.NewsPage;
import sun.security.smartcardio.SunPCSC;

import static org.junit.Assert.assertTrue;

public class NewsPageInsta_Test {
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
        public void test(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            NewsPage newspage = PageFactory.initElements(driver, NewsPage.class);
            newspage.open();
            NewsPageInstaComponent insta = PageFactory.initElements(driver, NewsPageInstaComponent.class);
            Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000000);
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));//полная загрузка странички
            wait.until(ExpectedConditions.visibilityOf(insta.getInstaForm()));
            System.out.println("++++++++++++");
            insta.getInstaForm().isDisplayed();
            driver.switchTo().frame(insta.getInstaForm());//переключились на фрэйм
            assertTrue("Форма функцилнирует неверно", insta.checkContent(InstaFormData.Next));//тесты
            assertTrue("Форма функцилнирует неверно", insta.checkContent(InstaFormData.Next));
            assertTrue("Форма функцилнирует неверно", insta.checkContent(InstaFormData.Prev));


        }

}
