import Utils.BaseTest;
import Utils.UtilsMethod;
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
    UtilsMethod utils;

    @BeforeMethod
    void startTests(){
        mainPage = new MainPage(driver);
        utils = new UtilsMethod(driver);
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
        cartPage = mainPage.clickCartButton()
                .clickProductFromCart()
                .clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }

    @Test
    void clickBackToShoppingLogin () {
        utils.loginDefault();
        cartPage = mainPage.clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickBackToShoppingLoginProduct () {
        utils.loginDefault();
        cartPage = mainPage.clickCartButton();
                utils.clearCart()
                .clickProductFromCart()
                .clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }
}
