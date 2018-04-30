package components;

import data.InstaFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPageInstaComponent {
    WebDriver driver = null;

    public NewsPageInstaComponent(WebDriver driver){
        this.driver = driver;
    }

    String buttonLocator = "//a[@class=' _5wmqs %s']";
    @FindBy(xpath = "//div[@class='EmbedSidecar']//img")
    WebElement img;
    @FindBy(xpath = "//iframe[contains(@class, 'instagram-media')]")
    WebElement instaForm;

    public WebElement getInstaForm() {//для переключения драйвера на frame
        return instaForm;
    }

    public boolean isButtonHere(InstaFormData instaFormData){//проверка присутствия кнопки
        WebDriverWait driverWait = new WebDriverWait(driver, 1);
        String locator = String.format(buttonLocator, instaFormData.getName());
        try {
            driverWait.until(ExpectedConditions.attributeContains(By.xpath(locator), "class", instaFormData.getName()));
            return true;
        } catch(Exception ex) {
            return false;
        }
    }

    public boolean checkContent(InstaFormData instaformdata){//проверка контента
        String first = img.getAttribute("src");
        clickButton(instaformdata);
        String second = img.getAttribute("src");
        if(first==second) return false;
        else return true;
    }

    public void clickButton(InstaFormData instaFormData){//нажатие кнопки
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 10000);
        String locator = String.format(buttonLocator, instaFormData.getName());
        if(isButtonHere(instaFormData)) driver.findElement(By.xpath(locator)).click();
        else System.out.println("This button is not avalible ");

    }


}
