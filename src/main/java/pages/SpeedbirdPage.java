package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpeedbirdPage extends CommonMethods {

    private By cookies = By.className("-decline");
    private By loadPage = By.className("modals-overlay");

    private By sorterOptions = By.id("sorter");
    private By orderArrow = By.className("sorter-action");
    private By productsList = By.className("product-items");


    public SpeedbirdPage(WebDriver driver) {
        super(driver);
    }


    public void clickDeclineCookies() {
        driver.findElement(cookies).click();
        waitLoadDissappear();
    }

    public void waitLoadDissappear() {
        waitElementDisappear(loadPage);
    }


    public void clickOrderArrow(String order) {
        if (!(getOrder().contains(order)))
            driver.findElement(orderArrow).click();
    }

    public String getOrder() {
        return driver.findElement(orderArrow).getAttribute("title");
    }

    public void selectSort(String option) {
        driver.findElement(sorterOptions).click();
        selectAnElement(sorterOptions, option);
    }


}



