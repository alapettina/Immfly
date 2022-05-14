package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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

    @When("the user do a sort choosing the option (.*)")
    public void sort(String option) {
        speedbirdPage.selectSort(option);
    }

    @When("the user change the order by (.*)")
    public void order(String option) {
        speedbirdPage.clickOrderArrow(option);
    }


}
