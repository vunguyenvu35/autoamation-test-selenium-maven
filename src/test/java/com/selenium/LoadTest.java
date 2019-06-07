package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoadTest {

    private WebDriver driver;

    private String webBaseRoot = "http://157.230.43.172/en";

    @BeforeClass
    public void beforeClass() {
        String currentDirectory = System.getProperty("user.dir");
        String exePath = currentDirectory+"\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void verifySearchButton() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get(webBaseRoot);

        String search_text = "Search";

        WebElement search_button = driver.findElement(By.xpath("//button[@title='Search']"));

        System.out.println(search_button);

        String text = search_button.getText();

        Assert.assertEquals(text, search_text, "Text not found!");
    }
}
