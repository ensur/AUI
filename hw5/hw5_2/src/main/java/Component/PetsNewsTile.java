package Component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PetsNewsTile {
    private WebDriver driver = null;
    public PetsNewsTile(){
        this.driver = driver;
    }
    private String locator = ".js-pgng_item";

    @FindBy(css = ".js-pgng_item")//Тут смог проверить только по размеру, т.к. если
    List<WebElement> tile;//передаю весь лист, он некорректно обрабатывает. Пишет что
    //одинаковые размеры и до и после.

    public String getTileLocator(){//
        return locator;
    }

    public Integer tileQt(){//
        return tile.size();
    }


}
