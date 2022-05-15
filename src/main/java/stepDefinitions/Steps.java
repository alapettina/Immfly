package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SpeedbirdPage;


public class Steps {

    private WebDriver driver = Hooks.driver;
    private SpeedbirdPage speedbirdPage = new SpeedbirdPage(driver);
    private final String URL = "https://highlifeshop.com/speedbird-cafe";


    @Given("the user go to the page speedbird-cafe")
    public void goToThePage() {
        driver.get(URL);
        speedbirdPage.clickDeclineCookies();
    }

    @When("^the user do a sort choosing the option (.*)")
    public void sort(String option) {
        speedbirdPage.selectSort(option);
    }

    @When("^the user change the order by (.*)")
    public void order(String option) {
        speedbirdPage.clickOrderArrow(option);
    }

    @When("^the user select the filter (.*) and the option (.*)")
    public void chooseFilter(String category, String option) {
        speedbirdPage.getFilter(category, option);
    }

    @Then("^the user check the order of the elements is depending the sort price and order (.*)")
    public void checkOrder(String orderBy) {
        Assert.assertTrue("The list is nor roder by was expected", speedbirdPage.checkOrder(orderBy));
    }

}
