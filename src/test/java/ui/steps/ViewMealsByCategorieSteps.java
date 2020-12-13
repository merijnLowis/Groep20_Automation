package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.*;

import static org.junit.Assert.*;

public class ViewMealsByCategorieSteps {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Maintest.getDriverPath());
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.get(path+"?command=DeleteAll");
        driver.quit();
    }

    @Given("Lasagne, Broodje martino en tomatensoep staan op de menu en zijn beschikbaar")
    public void Lasagne_broodje_martino_en_tomatensoep_staan_op_de_menu_en_zijn_beschikbaar() {
        setUp();
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("broodje martino");
        page.setCategory("broodje");
        page.setPrice(6);
        page.setLactose();
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("lasagne");
        page.setCategory("pasta");
        page.setPrice(15);
        page.setLactose();
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("tomatensoep");
        page.setCategory("soep");
        page.setPrice(8);
        page.setLactose();
        page.submitValid();
    }

    @When("Jan de menu bekijkt")
    public void Jan_de_menu_bekijkt() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("kan Jan een lijst met categorieen zien en deze zijn producten")
    public void Kan_Jan_een_lijst_met_categorieen_zien_en_deze_zijn_producten() {
        CategoryPage categoryPage=new CategoryPage(driver,"broodje");
        PageFactory.initElements(driver, categoryPage);
        assertEquals("Category Details - Meal app", driver.getTitle());
        assertTrue((categoryPage).containsMealsInCategory("broodje martino"));
        assertFalse((categoryPage).containsMealsInCategory("lasagne"));
        assertFalse((categoryPage).containsMealsInCategory("tomatensoep"));
        clean();
    }

}