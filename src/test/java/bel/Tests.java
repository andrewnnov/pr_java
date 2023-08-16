package bel;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.PageAfterSearch;
import pages.PageBeforeSearch;
import pages.PageFactoryForTest;

import java.security.Key;
import java.util.List;

public class Tests extends BaseTest{

    @ParameterizedTest
    @DisplayName("Проверка результатов поиска с помощью ПО")
    @CsvSource({"RPA, как создаются роботы", "работа, использование kafka "})
    public void testPO(String keyWords, String result) {
        chromeDriver.get("https://bellintegrator.ru/");
        PageBeforeSearch pageBeforeSearch = new PageBeforeSearch(chromeDriver);
        pageBeforeSearch.find(keyWords);
        PageAfterSearch pageAfterSearch = new PageAfterSearch(chromeDriver);
        Assertions.assertTrue(pageAfterSearch.getResult().stream().anyMatch(x->x.getText().contains(result)),
                "Статьи содержащие " + result + " для поискового слова " + keyWords + " не найдены");
    }

    @Feature("Проверка результатов поиска")
    @DisplayName("Проверка результатов поиска с помощью ПФ")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @CsvSource({"RPA, как создаются роботы", "работа, использование kafka "})
    public void testPF(String keyWords, String result) {
        chromeDriver.get("https://bellintegrator.ru/");
        PageFactoryForTest pageFactoryForTest = PageFactory.initElements(chromeDriver, PageFactoryForTest.class);
        pageFactoryForTest.find(keyWords);
        Assertions.assertTrue(pageFactoryForTest.getResults().stream().anyMatch(x->x.getText().contains(result)));
    }
}
