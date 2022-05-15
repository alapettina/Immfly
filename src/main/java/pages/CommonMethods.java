package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

    protected WebDriver driver;

    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait wait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait;
    }

    public void waitElementToBeClickeable(By byElement) {
        wait(driver).until(ExpectedConditions.elementToBeClickable(byElement));
    }

    public void waitElementVisible(By byElement) {
        wait(driver).until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public void waitUrlContains(String url) {
        wait(driver).until(ExpectedConditions.urlContains(url));
    }

    public void selectAnElement(By sortElement, String option) {
        Select selectString = new Select(driver.findElement(sortElement));
        selectString.selectByVisibleText(option);
    }


    public void waitElementDisappear(By element) {
        new WebDriverWait(driver, 12).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitUntilThePageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

}
