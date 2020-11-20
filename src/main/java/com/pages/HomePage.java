package com.pages;

import com.helper.WebElementActions;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class HomePage extends WebElementActions {
    WebDriver driver;

   public HomePage(WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(this.driver,this);
   }

   @FindBy(css="#inputEmail")
   private WebElement emailAddress;

   @FindBy(css="#inputPassword")
   private WebElement password;

   @FindBy(css=".form-signin button.btn-lg")
   private WebElement loginButton;

   @FindBy (xpath = "//div[@class = 'col-sm-4 mx-auto']/ul/li[2]")
    private WebElement listGroupItem2;

   @FindBy(css="#dropdownMenuButton")
   private WebElement dropdownMenuButton;

    @FindBy(css = ".jumbotron:nth-child(4) .btn-primary")
    private WebElement buttonQues4a;

    @FindBy(css = ".jumbotron:nth-child(4) .btn-secondary")
    private WebElement buttonQues4b;

    @FindBy (css= "#test5-button")
    private  WebElement buttonQues5a;

    @FindBy (css= "#test5-alert")
    private  WebElement buttonQues5Alert;

    @FindBy(css=".list-group")
    private WebElement listGroup;

    @FindBy(css = ".dropdown-menu")
    private WebElement dopDownMenu;

   public boolean isEmailAddressFieldDisplayed(){
       return emailAddress.isDisplayed();
   }

    public boolean isPasswordFieldDisplayed(){
        return password.isDisplayed();
    }

    public boolean isLoginButtonDisplayed(){
       return loginButton.isDisplayed();
    }

    public void enterEmailAddress(String emailAddressValue){
       setInput(emailAddress,emailAddressValue);
    }

    public void enterPassword(String passwordValue){
       setInput(password,passwordValue);
    }

    public boolean setListGroup(){ return listGroup.isDisplayed();}

    public String verify2ndItem(){
       return listGroupItem2.getText();
    }
    public String getSelectedDropDownValue(){
        return dropdownMenuButton.getText();
    }
    public void selectDropDownItem(String value){
       clickElement(dropdownMenuButton);
        List<WebElement> dropDownItemsList=dopDownMenu.findElements(By.cssSelector(".dropdown-item"));
        for(WebElement dropDownItem:dropDownItemsList){
            if(dropDownItem.getText().trim().equals(value)){
                clickElement(dropDownItem);
            }
        }
    }

    public boolean isQues4aButtonEnabled(){
       return buttonQues4a.isEnabled();
    }
    public boolean isQues4bButtonEnabled(){
        return buttonQues4b.isEnabled();
    }
    public boolean verifyQues5a(){
        /*WebDriverWait w = new WebDriverWait(driver,50);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#test5-button")));*/
        waitForWebElement(this.driver,By.cssSelector("#test5-button"));
        buttonQues5a.click();
        return buttonQues5a.isEnabled();
    }

    public void clickButton5(){
       waitForWebElement(this.driver,By.cssSelector("#test5-button"));
       clickElement(buttonQues5a);
    }

    public boolean isButton5Enabled(){
        return buttonQues5a.isEnabled();
    }

    public String getButton5ClickAlertMessage(){
       waitForWebElement(this.driver,By.cssSelector("#test5-alert"));
       return buttonQues5Alert.getText().trim();
    }

    /*public String verifyQues5b(){
        *//*WebDriverWait w = new WebDriverWait(driver,50);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#test5-button")));*//*
        buttonQues5b.click();
        return buttonQues5b.getText();
    }*/

    public List<WebElement> getListGroupItems(){
       List<WebElement> listOfGroupItems=listGroup.findElements(By.cssSelector(".list-group-item"));
       return listOfGroupItems;
    }

    public List<WebElement> getBadgeItems(){
       List<WebElement> listOfBadgeItems = listGroup.findElements(By.cssSelector(".badge-primary"));
       return listOfBadgeItems;
    }

//;  return buttonQues5.getText();









}