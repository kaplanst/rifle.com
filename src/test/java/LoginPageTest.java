import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        loginPage = mainPage.clickLoginButton()
                .fillUsername(LOGIN)
                .fillPassword(PASSWORD)
                .clickSigninButton();
        Assert.assertEquals(driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LogoutLink2")).getText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = mainPage.clickLoginButton()
                .fillUsername(WRONG_LOGIN)
                .fillPassword(PASSWORD)
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = mainPage.clickLoginButton()
                .fillPassword(PASSWORD)
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }
    @Test
    void registerExistUserTest(){
        loginPage = mainPage.clickLoginButton()
                .fillNewUsername(LOGIN)
                .fillNewUserPassword(PASSWORD)
                .confirmNewUserPassword(PASSWORD)
                .clickRegisterButton();
        Assert.assertTrue(driver.findElement(By
                .id("ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_RegisterValidationSummary")).isDisplayed());
    }
    @Test
    void registerWithWrongEserNameTest() {
        loginPage = mainPage.clickLoginButton()
                .fillNewUsername(WRONG_LOGIN)
                .fillNewUserPassword(PASSWORD)
                .confirmNewUserPassword(PASSWORD)
                .clickRegisterButton();
        WebElement wrongLogin = driver.findElement(By.xpath("//*[text()='Email address should be in the format of name@domain.tld.']"));
        Assert.assertTrue(wrongLogin.isDisplayed());
    }

}
