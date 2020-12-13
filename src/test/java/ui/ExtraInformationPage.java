package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExtraInformationPage extends Page{

    public ExtraInformationPage(WebDriver driver, String meal) {
        super(driver);
        driver.get(getPath()+"?command=MealDetails&name="+meal);
    }

    public boolean containsExtraInformationOfMeal (String warningType) {
        List<WebElement> trs = driver.findElements(By.cssSelector("tr"));
        for (WebElement tr: trs) {
            WebElement th= tr.findElement(new By.ByTagName("th"));
            WebElement td= tr.findElement(new By.ByTagName("td"));
            if (th.getText().equals(warningType)){
                if(td.getText().equals("Yes")) return true;
                else if(td.getText().equals("No")) return false;
            }
        }
        throw new RuntimeException("alles is een leugen");
    }

}