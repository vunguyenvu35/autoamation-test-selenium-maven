package com.selenium.pages;

import com.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePage extends DriverBase {

    private WebDriver driver;

    private String webBaseRoot = "http://157.230.43.172/en";

    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifyHomePages() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        //  And now use this to visit Home page
        driver.get(webBaseRoot);

        String search_text = "Search";

        WebElement search_button = driver.findElement(By.xpath("//button[@title='Search']"));

        System.out.println(search_button);

        String text = search_button.getText();

        Assert.assertEquals(text, search_text, "Text not found!");
    }

}
