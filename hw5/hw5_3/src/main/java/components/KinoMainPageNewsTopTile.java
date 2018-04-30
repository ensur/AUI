package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.KinoTopNewsPage;

import java.util.List;

public class KinoMainPageNewsTopTile {//находим топ питку
    //private String locator = "div.slider__item_selected > div.news-three__items__block > article.news-three__item_top > a"; //"div.slider__item_selected > div.news-three__items__block > article.news-three__item_top > a";
    private WebDriver driver =null;
    public KinoMainPageNewsTopTile(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//div[contains(@class, 'slider__item_selected')]//article[contains(@class, 'news-three__item_top')]/a")
    private List<WebElement> topTile;

    public KinoTopNewsPage topTileClick(){
        topTile.get(1).click();
        return PageFactory.initElements(driver, KinoTopNewsPage.class);
    }
    public String getTileCap(){//берем заголовок
        return topTile.get(1).getText();
    }
}
