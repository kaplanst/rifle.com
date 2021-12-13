package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By backToShoppingButton = By.id("ctl00_ctl00_NestedMaster_PageContent_KeepShoppingButton");
    By productLinInCart = By.id("ctl00_ctl00_NestedMaster_RightSidebar_PopularProductsDialog1_ProductList_ctl01_ProductItemDisplay1_ProductName");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBackToShopping () {
        driver.findElement(backToShoppingButton).click();
    }

    public void clickProductFromCart () {
        driver.findElement(productLinInCart).click();
    }

}
