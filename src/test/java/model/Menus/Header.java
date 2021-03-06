package model.Menus;

import model.AccountPage;
import model.CartPage;
import model.LoginPage;
import model.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    public WebDriver driver;

    By loginButton = By.xpath("//*[contains(@id, 'LoginLink2')]");
    By accountButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink");
    By wishListButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink");
    By cartButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public AccountPage clickAccountButton(){
        driver.findElement(accountButton).click();
        return new AccountPage(driver);
    }

    public WishListPage clickWishlistButton(){
        driver.findElement(wishListButton).click();
        return new WishListPage(driver);
    }

    public CartPage clickCartButton(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
