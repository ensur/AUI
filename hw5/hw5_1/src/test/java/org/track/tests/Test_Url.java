package org.track.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Scanner;

public class Test_Url {


   // public void goToUrl(String url)
    //{
      //  this.driver.navigate().to(url);
   // }

    @Before
    public void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "c:/driver/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
    }
    private WebDriver driver;
    @After
    public void close(){
        if (driver !=null){
            driver.quit();
        }
    }
    @Test
    public void getAllUrl(){
        By locator = By.xpath("//a[contains (@href, 'https')]");
        List<WebElement> urls = driver.findElements(locator);
        urls.forEach(s -> System.out.println(s.getAttribute("href")));

    }
}
