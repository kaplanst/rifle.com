import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    void startTests(){
        mainPage = new MainPage(driver);
    }

    @Test
    public void loginLinkTest() {  // Test case #TC-HD-001
        mainPage.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void  loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        loginPage = mainPage.clickLoginButton();
        loginPage.fillUsername("georgians_forever@gmail.com");
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();
        Assert.assertEquals(driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LogoutLink2")).getText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = mainPage.clickLoginButton();
        loginPage.fillUsername("georgians_forever@gmail");
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = mainPage.clickLoginButton();
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }
}
