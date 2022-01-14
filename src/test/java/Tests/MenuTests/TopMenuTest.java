package Tests.MenuTests;

import Utils.BaseTest;
import model.Menus.TopMenu;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    TopMenu topMenu;

    @BeforeMethod
    void startTests() {
        topMenu = new TopMenu(driver);
    }

    @Test
    void clickHomeLinkTest(){
        topMenu.clickSearchByModelsLink();
        topMenu.clickHomeLink();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Motorcycle Windshields and Fairings");
    }

    @Test
    void clickSearchByModelsLinkTest(){
        topMenu.clickSearchByModelsLink();
        Assert.assertEquals(driver.getTitle(), "Search for Rifle Products by Make Model");
    }

    @Test
    void clickContactRifleLinkTest(){
        topMenu.clickContactRifleLink();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Contact RIFLE");
    }

    @Test
    void clickAboutAsLinkTest(){
        topMenu.clickAboutAsLink();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Message From The President");
    }

    @Test
    void checkProductsDropDownTest() {
        String item = "Honda Pacific Coast Windshield System";
        topMenu.checkProductsDropDown("  Products")
                .checkProductsDropDown("Motorcycle Replacement Windshields")
                .checkProductsDropDown("Honda Replacement Windshields")
                .clickItem(item);
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), item);
    }

    @Test
    void check_2_ProductsDropDownTest() {
        String item = "Roadster Fairing Harley-Davidson";
        topMenu.checkProductsDropDown("  Products")
                .checkProductsDropDown("Fairings")
                .checkProductsDropDown("Rifle Roadster Fairing")
                .clickItem(item);
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), item);
    }

    @Test
    void check_3_ProductsDropDownTest() {
        String item = "Just Released";
        topMenu.checkProductsDropDown("  Products")
                .clickItem(item);
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), item);
    }

    @Test
    void clickWindshieldSelectionGuideTest(){
        topMenu.checkInfoDropDown()
                .clickWindshieldSelectionGuide();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "How to Select a Windshield Size");
    }

    @Test
    void clickOrderInfoTest(){
        topMenu.checkInfoDropDown()
                .clickOrderInfo();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "How To Order RIFLE Products");
    }

    @Test
    void clickBecomeDealerTest(){
        topMenu.checkInfoDropDown()
                .clickBecomeDealer();
        Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Dealer Information Page");
    }

    @Test
    void clickInquireAboutCustomManufacturingTest(){
        String expectedTitle = "Rifle Job Shop Atascadero, CA 93422-Vacuum Forming, CNC Machining";
        topMenu.checkInfoDropDown()
                .clickInquireAboutCustomManufacturing();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

}
