package bel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver chromeDriver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/andrey/IdeaProjects/pr_java/chromedriver/chromedriver");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    public void after() {
        chromeDriver.quit();
    }
}
