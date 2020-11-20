import com.pages.HomePage;
import com.helper.BrowserUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class TestInterview {
    WebDriver driverInstance;
    HomePage homePage;
    BrowserUtility browserUtility = new BrowserUtility();

    @BeforeMethod
    public void setup(){
        driverInstance = browserUtility.getBrowserInstance("chrome");
        driverInstance.get(System.getProperty("user.dir")+"/src/main/resources/index.html");
        homePage = new HomePage(driverInstance);
    }

    @AfterMethod
    public void tearDown(){
        if(null!=driverInstance)
            driverInstance.quit();
    }

    @Test
    public void test_001(){
        Assert.assertTrue(homePage.isEmailAddressFieldDisplayed());
        Assert.assertTrue(homePage.isPasswordFieldDisplayed());
        Assert.assertTrue(homePage.isLoginButtonDisplayed());
        homePage.enterEmailAddress("test@example.com");
        homePage.enterPassword("TestPassword");

    }

    @Test
    public void test_002(){
        int count=1;
        List<WebElement> listOfGroupItems=homePage.getListGroupItems();
        List<WebElement> lisOfBadgeItems = homePage.getBadgeItems();
        Assert.assertEquals(listOfGroupItems.size(),3,"Values count is not as expected");
        for(WebElement listOfGroupItem:listOfGroupItems){
            if(count == 2){
                String secondItem = listOfGroupItem.getText().trim();
                secondItem = secondItem.replace("6","");
                Assert.assertEquals(secondItem.trim(),"List Item 2","Second Item value is not as expected");
                Assert.assertEquals(lisOfBadgeItems.get(count-1).getText().trim(),"6","Second item badge value is not as expected");
            }
            Assert.assertNotEquals(listOfGroupItem.getText().trim(),"","Item value is empty");
            count ++;
        }



    }

    @Test
    public void test_003(){
        Assert.assertEquals(homePage.getSelectedDropDownValue(), "Option 1");
        homePage.selectDropDownItem("Option 3");
        Assert.assertEquals(homePage.getSelectedDropDownValue(), "Option 3");
    }

    @Test
    public  void test_004(){
        Assert.assertTrue(homePage.isQues4aButtonEnabled(),"Question 4 first button is not enabled");
        Assert.assertFalse(homePage.isQues4bButtonEnabled(),"Question 4 second button is enabled");
    }

    @Test
    public  void test_005(){
        homePage.clickButton5();
        Assert.assertFalse(homePage.isButton5Enabled(),"Button 5 is not disabled after the click");
        Assert.assertEquals(homePage.getButton5ClickAlertMessage(),"You clicked a button!","Button 5 click alert message is not as expected");
    }

}
