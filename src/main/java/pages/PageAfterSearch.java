package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageAfterSearch extends PageBeforeSearch  {

    private List<WebElement> result;

    WebDriverWait wait = new WebDriverWait(chromedriver, 120);

    public PageAfterSearch(WebDriver chromedriver) {
        super(chromedriver);
    }

    public List<WebElement> getResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//li//div[@class='search-result__snippet-info']")));
        result = chromedriver.findElements(By.xpath("//li//div[@class='search-result__snippet-info']"));
        return  result;
    }
}
