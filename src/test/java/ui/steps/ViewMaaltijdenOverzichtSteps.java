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

import static org.junit.Assert.*;

public class ViewMaaltijdenOverzichtSteps {
    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    private Page currentPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC-Matthias\\Desktop\\UCLL\\webontwikkeling\\web3\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.get(path+"?command=DeleteAll");
        driver.quit();
    }

    @Given("dat er maaltijden op het menu staan")
    public void dat_er_maaltijden_op_het_menu_staan() {
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

    @When("Jan dan op het menu kijkt")
    public void jan_dan_op_het_menu_kijkt() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("worden alle maaltijden getoond die op het menu staan")
    public void worden_alle_maaltijden_getoond_die_op_het_menu_staan() {
        assertEquals("Meal Details - Meal app", driver.getTitle());
        assertTrue(((MealsPage)currentPage).containsMealsWithName("broodje martino"));
        assertTrue(((MealsPage)currentPage).containsMealsWithName("lasagne"));
        assertTrue(((MealsPage)currentPage).containsMealsWithName("tomatensoep"));
    }

    @Given("er geen maaltijden op het menu staan")
    public void er_geen_maaltijden_op_het_menu_staan() {
        driver.get(path+"?command=DeleteAll");

    }

    @When("Jan op het menu kijkt")
    public void Jan_op_het_menu_kijkt() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("krijgt Jan een melding dat er momenteel nog geen broodjes op het menu staan")
    public void krijgt_jan_een_melding_dat_er_momenteel_nog_geen_broodjes_op_het_menu_staan() {
        assertEquals("Meal Overview - Meal app", driver.getTitle());
        assertFalse(((MealsPage)currentPage).containsMealsWithName("broodje martino"));
        assertFalse(((MealsPage)currentPage).containsMealsWithName("lasagne"));
        assertFalse(((MealsPage)currentPage).containsMealsWithName("tomatensoep"));
        assertTrue(((MealsPage)currentPage).containsErrorMessage("No meals found"));
    }
}
