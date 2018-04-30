package components;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KinoTopPageSeeMoreComponent {

    private WebDriver driver = null;


    public KinoTopPageSeeMoreComponent(WebDriver driver) {
        this.driver = driver;
    }

    String locatorN = "//div[contains(@class, 'slider_centered')]//div[contains(@class, 'next')]";
    String locatorP = "//div[contains(@class, 'slider_centered')]//div[contains(@class, 'prev')]/span";
    String locatorL = "//div[contains(@class, 'slider_centered')]//div[contains(@class, 'selected')]//a[@class][@style]";

    public WebElement getButtonNext() {
        return driver.findElement(By.xpath(locatorN));
    }

    public WebElement getButtonPrev() {
        return driver.findElement(By.xpath(locatorP));
    }

    public List<String> kinoTopPageSeeMoreTileActual() {//Метод для создания листа актуальных плиток
        List<WebElement> listw = driver.findElements(By.xpath(locatorL));
        List<String> lists = new ArrayList<>();
        listw.forEach(s -> lists.add(s.getAttribute("href")));
        return lists;
    }

    public boolean checkNew(WebElement button){//проверка по наполнению
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 10000);

        List<String> first = kinoTopPageSeeMoreTileActual();
        if (buttonIsHere(button)) button.click();
        else return false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'slider_centered')]//div[contains(@class, 'slider__item_selected')]")));
        List<String> second = kinoTopPageSeeMoreTileActual();
        if (first.equals(second)) return false;
        else return true;
    }

    public boolean buttonIsHere(WebElement button) {//Проверяет, активна ли кнопка.
        WebDriverWait driverWait = new WebDriverWait(driver, 1);
        try {
            driverWait.until(ExpectedConditions.attributeContains(button, "class", "hidden"));
            return false;
        } catch(Exception ex) {
            return true;
        }
    }
}