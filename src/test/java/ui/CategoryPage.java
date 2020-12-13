package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage extends Page{

    public CategoryPage(WebDriver driver, String category) {
        super(driver);
        driver.get(getPath()+"?command=CategoryDetails&category="+category);
    }

    public boolean containsMealsInCategory (String meal) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(meal)){
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