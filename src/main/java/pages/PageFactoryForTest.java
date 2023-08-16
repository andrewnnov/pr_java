package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryForTest {
    private WebDriver chromeDriver;

    @FindBy(how = How.XPATH, xpath = "//input[@name='search']")
    WebElement searchField;

    @FindBy(how = How.XPATH, xpath = "//div[@id='search-open']")
    WebElement searchButton;

    @FindBy(how = How.XPATH, xpath = "//li//div[@class='search-result__snippet-info']")
    List<WebElement> results;


    public PageFactoryForTest(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public List<WebElement> getResults() {
        return results;
    }

    public void find(String key) {
        searchButton.click();
        searchField.sendKeys(key);
        searchField.sendKeys(Keys.ENTER);
    }
}
