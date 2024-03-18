package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
    WebDriver driver;

    @FindBy(css = "textarea[title='Search']")
    private WebElement searchInputElementBoxElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public void enterSearchTerm(String searchTerm) {
        searchInputElementBoxElement.sendKeys(searchTerm); // Use the initialized WebElement
    }

    public void submitSearch() {
        searchInputElementBoxElement.submit(); // Use the initialized WebElement
    }
}
