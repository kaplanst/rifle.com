package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    public WebDriver driver;

    By loginButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_LoginLink2");
    By accountButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootAccountLink");
    By wishListButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootWishlistLink");
    By cartButton = By.id("ctl00_ctl00_NestedMaster_PageHeader_StoreHeaderRifle_H_BootBasketLink");

    public MainPage(WebDriver driver) {
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
