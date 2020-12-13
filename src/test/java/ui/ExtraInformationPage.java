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
        List<WebElement> trs = driver.findElements(By.cssSelector("td"));
        for (WebElement tr: trs) {
            WebElement th= trs.get(1);
            WebElement td=trs.get(2);
            if (th.getText().equals(warningType)){
                if(td.getText().equals("Yes")) return true;
                else if(td.getText().equals("No")) return false;
            }
        }
        throw new RuntimeException("alles is een leugen");
    }

}
