package org.track.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.track.tests.getInfo.GetInfo;
import org.track.tests.putFile.PutFile;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(){

        ChromeDriver driver = GetInfo.setDriver();
        String domain = GetInfo.getDomain(driver);
        List<WebElement> urlOut = GetInfo.getList(driver);
        List<WebElement> urlIn = urlOut.stream()
                .filter(s -> s.getAttribute("href").toString().contains("/" + domain + "/"))
                .collect(Collectors.toList());
        urlOut.removeAll(urlIn);//удаляем внутренние из всех
        PutFile.writer(urlIn, urlOut);
        driver.quit();
    }
}
