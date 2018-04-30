package org.track.tests.getInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;
import java.util.regex.Pattern;

public class GetInfo {
    public static ChromeDriver setDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "c:/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    public static String getDomain(ChromeDriver driver){//берем домен
        driver.get(System.getProperty("url"));
        Pattern pattern = Pattern.compile("http[s]?://.*?(?::\\d+)?");
        String domain = pattern.split(System.getProperty("url"))[1];
        return domain;
    }

    public static List<WebElement> getList(ChromeDriver driver) {//берем лист всех
        driver.get(System.getProperty("url"));
        By locator = By.xpath("//a[@href]");
        List<WebElement> urlOut = driver.findElements(locator);
        return urlOut;
    }
}

