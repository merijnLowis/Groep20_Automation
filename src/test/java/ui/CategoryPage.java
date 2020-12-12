package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends Page{

    public CategoryPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=CategoryDetails");
    }

    public boolean containsMealsWithCategory (String category) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(category)){
                return true;
            }
        }
        return false;
    }

    public boolean containsErrorMessage (String name) {
        WebElement error = driver.findElement(By.cssSelector("em"));
        return error.getText().equals(name);
    }
}
