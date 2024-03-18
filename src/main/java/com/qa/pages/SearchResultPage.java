package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    WebDriver driver;

    @FindBy(css = "h3")
    private WebElement firstResultTitleElement;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }

    public String getFirstResultTitle() {
        return firstResultTitleElement.getText(); // Use the initialized WebElement
    }
}
