package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import ui.ExtraInformationPage;
import ui.MealsPage;
import ui.Page;
import ui.RegisterPage;

import static org.junit.Assert.*;

public class ViewExtraInformationSteps {
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

    @Given("Broodje met walnoten en broodje veggylicious")
    public void Broodje_met_walnoten_en_broodje_veggylicious() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("broodje met walnoten");
        page.setCategory("broodje");
        page.setPrice(7);
        page.setNuts();
        page.submitValid();

        page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("broodje veggylicious");
        page.setCategory("broodje");
        page.setPrice(5);
        page.setVegetarian();
        page.setGluten();
        page.submitValid();
    }

    @When("Jan deze broodjes op het menu ziet")
    public void Jan_deze_broodjes_op_het_menu_ziet() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("Jan krijgt informatie dat eerste broodje sporen van noten bevat en veggylicious vegetarisch is")
    public void Jan_krijgt_informatie_dat_eerste_broodje_sporen_van_noten_bevat_en_veggylicious_vegetarisch_is() {
        currentPage = PageFactory.initElements(driver, ExtraInformationPage.class);
        assertEquals("Meal Details - Meal app", driver.getTitle());
        assertFalse(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("Yes"));
        assertTrue(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("No"));

        currentPage = PageFactory.initElements(driver, ExtraInformationPage.class);
        assertEquals("Meal Details - Meal app", driver.getTitle());
        assertFalse(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("Yes"));
        assertFalse(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("No"));
    }

    @Given("Broodje spelt dat glutenvrij is")
    public void Broodje_spelt_dat_glutenvrij_is() {
        RegisterPage page = PageFactory.initElements(driver, RegisterPage.class);
        page.setName("broodje spelt");
        page.setCategory("broodje");
        page.setPrice(6);
        page.setVegetarian();
        page.submitValid();
    }

    @When("Jan dit broodje op het menu ziet")
    public void Jan_dit_broodje_op_het_menu_ziet() {
        currentPage = PageFactory.initElements(driver, MealsPage.class);
    }

    @Then("Jan krijgt informatie dat dit broodje glutenvrij is")
    public void Jan_krijgt_informatie_dat_dit_broodje_glutenvrij_is() {
        currentPage = PageFactory.initElements(driver, ExtraInformationPage.class);
        assertEquals("Meal Details - Meal app", driver.getTitle());
        assertFalse(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("Yes"));
        assertFalse(((ExtraInformationPage)currentPage).containsExtraInformationOfMeal("No"));
    }
}
