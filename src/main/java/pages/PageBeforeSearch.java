package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBeforeSearch {
    protected WebDriver chromedriver;
    protected WebElement searchField;
    protected WebElement searchButton;

    public PageBeforeSearch(WebDriver chromedriver) {
        this.chromedriver = chromedriver;
        this.searchField = chromedriver.findElement(By.xpath("//input[@name='search']"));
        this.searchButton = chromedriver.findElement(By.xpath("//div[@id='search-open']"));
    }

    public void find(String key) {
        searchButton.click();
        searchField.sendKeys(key);
        searchField.sendKeys(Keys.ENTER);
    }
}
