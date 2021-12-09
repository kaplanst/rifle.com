import Utils.BaseTest;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Stan extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;


    @Test
    public void loginLinkTest() {  // Test case #TC-HD-001
        mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
 //       driver.findElement(By.xpath("//a[@id='ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void loginWithCorrectCredsPOMTest() {  // Test case #TC-HD-002
        mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        loginPage = new LoginPage(driver);
        loginPage.fillUsername("georgians_forever@gmail.com");
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();

        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Account Sign In");
    }

    @Test
    void loginWithIncorrectCredsTest() {  // Test case #TC-HD-003
        driver.get("https://rifle.com/Login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_UserName']")).sendKeys("georgians_forever@gmail");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password']")).sendKeys("Qwerty1");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='The sign in information you provided was incorrect.']")).isDisplayed());
    }

    @Test
    void loginWithEmptyUsernameTest() {  // Test case #TC-HD-004
        driver.get("https://rifle.com/Login.aspx");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_Password']")).sendKeys("Qwerty1");
        driver.findElement(By.xpath("//input[@id='ctl00_ctl00_NestedMaster_PageContent_LoginDialog1_LoginButton']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You must provide a user name.']")).isDisplayed());
    }


}
