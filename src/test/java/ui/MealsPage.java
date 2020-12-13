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
        for (WebElement tr : trs) {
            List<WebElement> tds = tr.findElements(By.tagName("td"));
                if(tds.size()>2) {
                    String productName = tds.get(0).getText();
                    if (meal.equals(productName) && price.equals(tds.get(2).getText())) {
                        return true;
                    }
                }

        }
        return  false;
    }

    public boolean containsErrorMessage (String name) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(name);
    }
}
