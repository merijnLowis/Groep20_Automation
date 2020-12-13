package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.MealsPage;
import ui.Page;
import ui.RegisterPage;
import ui.Maintest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewPriceSteps {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Maintest.getDirverPath());
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.get(path+"?command=DeleteAll");
        driver.quit();
    }

    @Given("broodje martino en lasagne")
    public void broodje_martino_en_lasagne() {
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
    }

    @When("Jan deze maaltijden ziet")
    public void Jan_deze_maaltijden_ziet() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("Krijgt Jan de informatie over de prijs en kan hij zo beslissen welke maaltijd hij wil bestellen")
    public void Krijgt_Jan_de_informatie_over_de_prijs_en_kan_hij_zo_beslissen_welek_maaltijd_hij_wil_bestellen() {
        assertEquals("Meal Overview - Meal app", driver.getTitle());
        assertTrue(((MealsPage)currentPage).containsMealsWithName("broodje martino"));
        assertTrue(((MealsPage)currentPage).containsMealsWithName("lasagne"));
        assertTrue(((((MealsPage) currentPage).containsPrice("broodje martino","6.0 euro"))));
        assertTrue(((((MealsPage) currentPage).containsPrice("lasagne","15.0 euro"))));

        clean();
    }
}
