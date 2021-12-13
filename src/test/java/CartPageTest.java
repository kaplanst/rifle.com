import Utils.BaseTest;
import model.CartPage;
import model.LoginPage;
import model.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    CartPage cartPage;

    @BeforeMethod
    void startTests(){
        mainPage = new MainPage(driver);
    }

    @Test
    void clickCartButton (){
        mainPage.clickCartButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "My Shopping Cart");
    }

    @Test
    void clickBackToShoppingNoLogin () {
        cartPage = mainPage.clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickBackToShoppingNoLoginProduct () {
        cartPage = mainPage.clickCartButton();
        cartPage.clickProductFromCart();
        cartPage = mainPage.clickCartButton();
        cartPage.clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }

    @Test
    void clickBackToShoppingLogin () {
        loginPage = mainPage.clickLoginButton();
        loginPage.fillUsername("georgians_forever@gmail.com");
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();
        cartPage = mainPage.clickCartButton();
        cartPage.clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickBackToShoppingLoginProduct () {
        loginPage = mainPage.clickLoginButton();
        loginPage.fillUsername("georgians_forever@gmail.com");
        loginPage.fillPassword("Qwerty1");
        loginPage.clickSigninButton();
        cartPage = mainPage.clickCartButton();
        cartPage.clickProductFromCart();
        cartPage = mainPage.clickCartButton();
        cartPage.clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }
}
