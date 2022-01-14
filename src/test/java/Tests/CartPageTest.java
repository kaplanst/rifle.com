package Tests;

import Utils.BaseTest;
import Utils.UtilsMethod;
import model.CartPage;
import model.Menus.Header;
import model.Menus.TopMenu;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
    Header header;
    TopMenu menu;
    CartPage cartPage;
    UtilsMethod utils;


    @BeforeMethod
    void startTests(){
        header = new Header(driver);
        utils = new UtilsMethod(driver);
        menu = new TopMenu(driver);
        cartPage = new CartPage(driver);
    }

    @Test
        void topMenuTest(){
            header.clickCartButton();
            menu.topMenuShortTest();
    }

    @Test
    void clickCartButton (){
        header.clickCartButton();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "My Shopping Cart");
    }

    @Test
    void clickBackToShoppingNoLogin () {
        cartPage = header.clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickBackToShoppingNoLoginProduct () {
        cartPage = header.clickCartButton()
                .clickProductFromCart()
                .clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }

    @Test
    void clickBackToShoppingLogin () {
        utils.loginDefault();
        cartPage = header.clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickBackToShoppingLoginProduct () {
        utils.loginDefault();
        cartPage = header.clickCartButton();
                utils.clearCart()
                .clickProductFromCart()
                .clickCartButton()
                .clickBackToShopping();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_NestedMaster_PageContent_ctl00_BuyProductDialog1_trOurPrice']/th")).getText(), "Our Price:");
    }
}
