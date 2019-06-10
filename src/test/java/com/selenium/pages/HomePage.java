package com.selenium.pages;

import com.selenium.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExtentReports.ExtentTestManager;

import java.util.concurrent.TimeUnit;

public class HomePage extends DriverBase {

    @Test(groups="Homepage", priority = 1, description = "Invalid Home page scenario with loading home page.")
    public void verifyHomePages() throws Exception {
        //ExtentReports Description

        String methodName = new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();

        ExtentTestManager.startTest(methodName, "Invalid Login Scenario with empty username and password.");

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
