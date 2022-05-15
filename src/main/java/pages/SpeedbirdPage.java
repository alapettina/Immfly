package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpeedbirdPage extends CommonMethods {

    private By cookies = By.className("-decline");
    private By loadPage = By.className("modals-overlay");

    private By sorterOptions = By.id("sorter");
    private By orderArrow = By.className("sorter-action");

    private By filter = By.className("filter-options-item");
    private By filterTitle = By.className("filter-options-title");
    private By filterItems = By.className("item");

    private By productsList = By.className("product-item");
    private By price = By.className("price");


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
        waitElementToBeClickeable(orderArrow);
        if (!(getOrder().contains(order)))
            driver.findElement(orderArrow).click();
    }

    public String getOrder() {
        return driver.findElement(orderArrow).getAttribute("title");
    }

    public void selectSort(String option) {
        waitElementToBeClickeable(sorterOptions);
        driver.findElement(sorterOptions).click();
        selectAnElement(sorterOptions, option);
    }

    public void getFilter(String section, String options) {
        List<WebElement> categories = driver.findElements(filter);
        for (WebElement category : categories) {
            if (category.findElement(filterTitle).getText().contains(section)) {
                checkCollapse(category.findElement(filterTitle));
                clickElement(category, options);
                break;
            }
        }
    }


    public void checkCollapse(WebElement element) {
        if (element.getAttribute("aria-expanded").equals("false"))
            element.click();
    }


    public void clickElement(WebElement element, String option) {
        List<WebElement> items = element.findElements(filterItems);
        for (WebElement item : items) {
            if (item.getText().contains(option)) {
                item.findElement(By.xpath("a")).click();
                break;
            }
        }
        waitUntilThePageLoaded();
    }


    public boolean checkOrder(String orderBy) {
        List<Character> result = new ArrayList<>();
        List<WebElement> elements = driver.findElements(productsList);
        int size = elements.size();
        float number = Float.parseFloat((elements.get(0).findElement(price).getText().substring(1)));
        for (WebElement element : elements) {
            float nextNumber = Float.parseFloat(element.findElement(price).getText().substring(1));
            if (orderBy.toLowerCase().contains("asc")) {
                if (nextNumber <= number)
                    result.add('T');
            } else {
                if (nextNumber >= number)
                    result.add('T');
            }
            number = nextNumber;
        }
        return result.size() == size;
    }


}





