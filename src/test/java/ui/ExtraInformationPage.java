package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtraInformationPage extends Page{

    public ExtraInformationPage(WebDriver driver) {
        super(driver);
        driver.get(getPath()+"?command=MealDetails&name=broodje%20spelt");
    }

    public boolean containsExtraInformationOfMeal (String category) {
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            if (tr.getText().equals(category)){
                return true;
            }
        }
        return false;
    }

}
