import Utils.BaseTest;
import Utils.UtilsMethod;
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
    UtilsMethod utils;

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
    void registerWithWrongUserNameTest() {
        loginPage = mainPage.clickLoginButton()
                .fillNewUsername(WRONG_LOGIN)
                .fillNewUserPassword(PASSWORD)
                .confirmNewUserPassword(PASSWORD)
                .clickRegisterButton();
        WebElement wrongLogin = driver.findElement(By
                .xpath("//*[text()='Email address should be in the format of name@domain.tld.']"));
        Assert.assertTrue(wrongLogin.isDisplayed());
    }
   @Test
    void registerWithShortPasswordTest() {
        loginPage = mainPage.clickLoginButton()
                .fillNewUsername(LOGIN)
                .fillNewUserPassword("123")
                .confirmNewUserPassword("123")
                .clickRegisterButton();
        WebElement shortPassword = driver.findElement(By
                .xpath("//*[text()='Password must be at least 6 characters.']"));
        Assert.assertTrue(shortPassword.isDisplayed());
    }
   @Test
    void registerWithoutPasswordTest() {
        loginPage = mainPage.clickLoginButton()
                .fillNewUsername(LOGIN)
                .clickRegisterButton();
        WebElement noPassword = driver.findElement(By.xpath("//*[text()='You must provide a password']"));
        WebElement noConfirmPassword = driver.findElement(By.xpath("//*[text()='You must re-enter the password.']"));
        Assert.assertTrue(noPassword.isDisplayed());
        Assert.assertTrue(noConfirmPassword.isDisplayed());
    }

    @Test
    void loginDefaultTest(){
        loginPage = mainPage.clickLoginButton();
        utils = new UtilsMethod(driver);
        System.out.println(getUserName());
    }

}
