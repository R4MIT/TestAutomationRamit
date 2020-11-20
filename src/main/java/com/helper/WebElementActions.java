package com.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementActions {

    private final static int TIME_OUT=30;

    protected void clickElement(WebElement element){
        element.click();
    }

    protected void setInput(WebElement element,String input){
        element.sendKeys(input);
    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void waitForWebElement(WebDriver driver, By locator){
        WebDriverWait w = new WebDriverWait(driver,TIME_OUT);
        w.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
