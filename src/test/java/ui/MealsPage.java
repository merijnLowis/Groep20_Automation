package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MealsPage extends Page {

    public MealsPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=Overview");
    }

    public boolean containsMealsWithName (String name) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean containsPrice(String meal , String price) {
        List<WebElement> trs = driver.findElements(By.tagName("tr"));
        Boolean containsMeal = false;
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
            for (WebElement td : tds) {
                String productName = td.getAttribute("innerHTML");
                if (meal.equals(td.getAttribute("innerHTML"))) {
                    containsMeal = true;

                }
                if (containsMeal && price.equals(td.getAttribute("innerHTML"))) {
                    return true;
                }

            }
            containsMeal = false;
        }
        return  false;
    }

    public boolean containsErrorMessage (String name) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(name);
    }
}
