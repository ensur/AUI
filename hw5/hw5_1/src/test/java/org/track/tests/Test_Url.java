package org.track.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

import java.net.URLConnection;

import java.util.ArrayList;
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
      // System.getProperty("webdriver.url.collect");
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
    public void getAllUrl() throws MalformedURLException {
        driver.get(System.getProperty("url"));
        //URL urrl = new URL(System.getProperty("url"));
        By locator = By.xpath("//a[contains (@href, 'https')]");
        //List<String> domain = new ArrayList<>();
        String domain = System.getProperty("url").substring(System.getProperty("url").indexOf("/")+2);
        System.out.println(domain);
        //String domain = System.getProperty("url").substring(System.getProperty("url").indexOf("/")+2, System.getProperty("url").indexOf("."));
       List<WebElement> urle = driver.findElements(locator);
       List<String> urls = new ArrayList<>();
        urle.forEach(s -> urls.add(s.getAttribute("href")));
        urls.forEach(s -> System.out.println(s));
        System.out.println(domain);
       urls.stream()
               //.filter(u -> (u.contains("." + domain)||u.contains(domain + ".")))
               .filter(u -> (u.contains(domain)))
               //.filter(s -> s.toString().contains(domain))
               .forEach(p -> System.out.println(p));


       /*urls.forEach(s -> {
           URL urlc = null;
           try {
               urlc = new URL(s.getAttribute("href"));
           } catch (MalformedURLException e) {
               e.printStackTrace();
           }
           domain.add(urlc.getHost());
       });*/

        //urls.forEach(s -> System.out.println(s.getAttribute("href")));
       // System.out.println(urrl.getHost());
        //System.getProperty("url").getHost();
        //urls.stream();

        driver.close();
    }
}
