package Tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.LoginPage;
import model.Menus.Header;
import model.Menus.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    Header header;
    LoginPage loginPage;
    UtilsMethod utils;
    TopMenu topMenu;

    @BeforeMethod
    void startTests(){
        header = new Header(driver);
    }

    @Test
    public void loginLinkTest() {  // Test case #TC-HD-001
        header.clickLoginButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void  loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        loginPage = header.clickLoginButton()
                .fillUsername(getUserName())
                .fillPassword(getUserPassword())
                .clickSigninButton();
        Assert.assertEquals(driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LogoutLink2")).getText(), "Logout");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        loginPage = header.clickLoginButton()
                .fillUsername("WRONG_LOGIN")
                .fillPassword(getUserPassword())
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        loginPage = header.clickLoginButton()
                .fillPassword(getUserPassword())
                .clickSigninButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }
    @Test
    void registerExistUserTest(){
        loginPage = header.clickLoginButton()
                .fillNewUsername(getUserName())
                .fillNewUserPassword(getUserPassword())
                .confirmNewUserPassword(getUserPassword())
                .clickRegisterButton();
        Assert.assertTrue(driver.findElement(By
                .id("ctl00_ctl00_NestedMaster_PageContent_RegisterDialog1_RegisterValidationSummary")).isDisplayed());
    }
    @Test
    void registerWithWrongUserNameTest() {
        loginPage = header.clickLoginButton()
                .fillNewUsername("WRONG_LOGIN")
                .fillNewUserPassword("AnyPassword")
                .confirmNewUserPassword("AnyPassword")
                .clickRegisterButton();
        WebElement wrongLogin = driver.findElement(By
                .xpath("//*[text()='Email address should be in the format of name@domain.tld.']"));
        Assert.assertTrue(wrongLogin.isDisplayed());
    }
   @Test
    void registerWithShortPasswordTest() {
        loginPage = header.clickLoginButton()
                .fillNewUsername(getUserName())
                .fillNewUserPassword("123")
                .confirmNewUserPassword("123")
                .clickRegisterButton();
        WebElement shortPassword = driver.findElement(By
                .xpath("//*[text()='Password must be at least 6 characters.']"));
        Assert.assertTrue(shortPassword.isDisplayed());
    }
   @Test
    void registerWithoutPasswordTest() {
        loginPage = header.clickLoginButton()
                .fillNewUsername(getUserName())
                .clickRegisterButton();
        WebElement noPassword = driver.findElement(By.xpath("//*[text()='You must provide a password']"));
        WebElement noConfirmPassword = driver.findElement(By.xpath("//*[text()='You must re-enter the password.']"));
        Assert.assertTrue(noPassword.isDisplayed());
        Assert.assertTrue(noConfirmPassword.isDisplayed());
    }

    @Test
    void loginDefaultTest(){
        utils = new UtilsMethod(driver);
        utils.loginDefault();
        Assert.assertEquals(driver.findElement(By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LogoutLink2")).getText(), "Logout");
    }
    @Test
    void menuTest(){
        topMenu = new TopMenu(driver);
        header.clickLoginButton();
        topMenu.topMenuShortTest();
        utils = new UtilsMethod(driver);
        utils.loginDefault();
        header.clickLoginButton();
        topMenu.topMenuFullTest();
    }
}
