package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="category")
    private WebElement categoryField;

    @FindBy(id="price")
    private WebElement priceField;

    @FindBy(id="vegetarian")
    private WebElement vegetarianField;

    @FindBy(id="lactose")
    private WebElement lactoseField;

    @FindBy(id="nuts")
    private WebElement nutsField;

    @FindBy(id="register")
    private WebElement registerButton;

    public RegisterPage (WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=SignUp");
    }

    public void setName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setCategory(String category) {
        categoryField.clear();
        categoryField.sendKeys(category);
    }

    public void setPrice(double price) {
        String prijs = "" + price;
        vegetarianField.clear();
        vegetarianField.sendKeys(prijs);
    }

    public void setVegetarian() {
        vegetarianField.clear();
        vegetarianField.click();
    }

    public void setLactose() {
        lactoseField.clear();
        lactoseField.click();
    }

    public void setNuts() {
        nutsField.clear();
        nutsField.click();
    }

    public void submitValid() {
        registerButton.click();
    }

}
